# MaintenancePlanCreateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**carId** | **String** |  | 
**carName** | **String** |  | 
**status** | [**StatusEnum**](#StatusEnum) |  | 
**plannedDate** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**plannedCompletionDate** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**plannedMileage** | **String** |  |  [optional]
**periodicOperations** | [**List&lt;MaintenanceOperationCreateRequest&gt;**](MaintenanceOperationCreateRequest.md) |  | 
**repairOperations** | [**List&lt;MaintenanceOperationCreateRequest&gt;**](MaintenanceOperationCreateRequest.md) |  | 
**totalEstimatedCost** | **Float** |  | 
**serviceProvider** | **String** |  |  [optional]
**notes** | **String** |  |  [optional]

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
DRAFT | &quot;draft&quot;
SCHEDULED | &quot;scheduled&quot;
IN_PROGRESS | &quot;in-progress&quot;
COMPLETED | &quot;completed&quot;
