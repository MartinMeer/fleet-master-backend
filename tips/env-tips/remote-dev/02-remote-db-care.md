# Managing Remote Database Volumes and Backups

You've identified the key concern perfectly. With your SSH-based remote development approach, the only critical persistent data you need to manage is your PostgreSQL database volume. Everything else (codebase, configurations) is safely stored in GitHub or can be recreated. Let me outline a complete strategy for managing your database volumes and implementing reliable backups.

## PostgreSQL Volume Management Strategy

### 1. Understanding Your Database Volume

On your remote VM, Docker manages the PostgreSQL volume:

```bash
# SSH into your VM
ssh devvm

# List all Docker volumes
docker volume ls

# Find your PostgreSQL volume (likely named something like 'devcontainer_postgres-data')
docker volume inspect devcontainer_postgres-data
```

This volume is physically stored at the path shown in the inspect command, typically `/var/lib/docker/volumes/devcontainer_postgres-data/_data`.

### 2. Regular Backup Procedures

#### A. Automated Database Dumps

Create a backup script on your VM (`~/scripts/backup-db.sh`):

```bash
#!/bin/bash
# Create backups directory if not exists
mkdir -p ~/backups

# Generate timestamp
TIMESTAMP=$(date +"%Y%m%d_%H%M%S")
BACKUP_FILE="~/backups/postgres_backup_${TIMESTAMP}.sql"

# Create database dump
docker exec postgres pg_dump -U postgres postgres > $BACKUP_FILE

# Compress the backup
gzip $BACKUP_FILE

# Keep only the 5 most recent backups
ls -tp ~/backups/postgres_backup_*.sql.gz | grep -v '/$' | tail -n +6 | xargs -I {} rm -- {}

echo "Backup completed: ${BACKUP_FILE}.gz"
```

Make it executable:
```bash
chmod +x ~/scripts/backup-db.sh
```

#### B. Schedule Regular Backups with Cron

```bash
# Edit crontab
crontab -e

# Add line for daily backups at 2 AM
0 2 * * * ~/scripts/backup-db.sh >> ~/backup.log 2>&1
```

#### C. Offsite Backup Storage

For additional safety, set up automatic transfer of backups to your local machine:

Create a local script `fetch-backups.sh`:

```bash
#!/bin/bash
# Directory to store backups locally
LOCAL_BACKUP_DIR="$HOME/db_backups"
mkdir -p $LOCAL_BACKUP_DIR

# Download all backup files from remote VM
scp devvm:~/backups/postgres_backup_*.sql.gz $LOCAL_BACKUP_DIR/

echo "Backups downloaded to $LOCAL_BACKUP_DIR"
```

### 3. Database Restoration Procedure

In case you need to restore your database:

```bash
# Copy backup file to VM (if restoring from local)
scp local_backup_file.sql.gz devvm:~/backups/

# SSH into your VM
ssh devvm

# Decompress backup
gunzip ~/backups/backup_file.sql.gz

# Restore database
cat ~/backups/backup_file.sql | docker exec -i postgres psql -U postgres postgres

# Verify restoration
docker exec -i postgres psql -U postgres postgres -c "SELECT count(*) FROM your_main_table;"
```

## Volume Management Best Practices

### 1. Monitoring Volume Usage

Create a monitoring script (`~/scripts/check-disk.sh`):

```bash
#!/bin/bash

# Check Docker volume usage
echo "Docker volume usage:"
docker system df -v

# Check overall disk usage
echo -e "\nDisk usage:"
df -h /

# Alert if less than 5GB free
FREE_SPACE=$(df -BG / | awk 'NR==2 {print $4}' | sed 's/G//')
if [ $FREE_SPACE -lt 5 ]; then
  echo "WARNING: Less than 5GB of free space available!"
fi
```

### 2. Volume Maintenance

Periodically run database maintenance to optimize storage:

```bash
# Create maintenance script
cat > ~/scripts/maintain-db.sh << EOF
#!/bin/bash
echo "Running PostgreSQL VACUUM FULL..."
docker exec postgres psql -U postgres postgres -c "VACUUM FULL;"
echo "Database maintenance completed"
EOF

chmod +x ~/scripts/maintain-db.sh

# Add to crontab for weekly execution (Sundays at 3 AM)
# 0 3 * * 0 ~/scripts/maintain-db.sh >> ~/maintenance.log 2>&1
```

### 3. Emergency Cleanup Plan

If you ever run out of disk space:

```bash
# Clean Docker system
docker system prune -a --volumes --filter "until=24h"

# Remove old logs
find ~/logs -name "*.log" -type f -mtime +7 -delete

# Clear apt cache
sudo apt-get clean
```

## Complete Data Management Workflow

### Daily Operations

- Code changes pushed to GitHub
- Database changes automatically persisted in Docker volume
- Daily automated backups run at 2 AM

### Weekly Operations

- Run `~/scripts/maintain-db.sh` to optimize database
- Download local copies of backups with `fetch-backups.sh`
- Check disk usage with `~/scripts/check-disk.sh`

### Monthly Operations

- Perform a manual backup before major changes
- Test database restoration procedure on a separate container
- Review and clean up unnecessary data in the database

### Before Major Updates

1. Create a manual backup:
   ```bash
   ~/scripts/backup-db.sh
   ```

2. Download the backup to your local machine:
   ```bash
   ./fetch-backups.sh
   ```

3. Proceed with updates

## Disaster Recovery Plan

### Scenario 1: VM Failure

1. Provision a new VM with the same specs
2. Set up Docker and your development environment
3. Restore latest database backup

### Scenario 2: Database Corruption

1. Stop the affected container
2. Rename the corrupted volume
3. Create a new volume and restore from backup

### Scenario 3: Accidental Data Deletion

1. Immediately stop application to prevent further changes
2. Restore from the most recent backup before the deletion

## Time Investment for Database Management

With this setup, your time investment for database management is minimal:

- **Setup time**: 1-2 hours (one-time)
- **Daily attention**: 0 minutes (fully automated)
- **Weekly review**: 10-15 minutes
- **Monthly maintenance**: 30 minutes

This approach ensures your valuable database data is protected while keeping your management overhead to a minimum. Your development workflow stays focused on code (safely in GitHub) while the critical persistent data in your database volume is automatically backed up and maintained.
