# MaintenancePlan

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier | 
**carId** | **String** | Associated car ID | 
**carName** | **String** | Car display name | 
**status** | [**StatusEnum**](#StatusEnum) | Plan status | 
**plannedDate** | [**OffsetDateTime**](OffsetDateTime.md) | Planned start date | 
**plannedCompletionDate** | [**OffsetDateTime**](OffsetDateTime.md) | Planned completion date | 
**plannedMileage** | **String** | Planned mileage |  [optional]
**periodicOperations** | [**List&lt;MaintenanceOperation&gt;**](MaintenanceOperation.md) | Scheduled operations | 
**repairOperations** | [**List&lt;MaintenanceOperation&gt;**](MaintenanceOperation.md) | Repair operations | 
**totalEstimatedCost** | **Float** | Total estimated cost | 
**serviceProvider** | **String** | Service provider |  [optional]
**notes** | **String** | Additional notes |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | Creation timestamp | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | Last update timestamp | 

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
DRAFT | &quot;draft&quot;
SCHEDULED | &quot;scheduled&quot;
IN_PROGRESS | &quot;in-progress&quot;
COMPLETED | &quot;completed&quot;
