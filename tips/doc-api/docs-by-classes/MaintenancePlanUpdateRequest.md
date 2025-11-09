# MaintenancePlanUpdateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**plannedDate** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**plannedCompletionDate** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**plannedMileage** | **String** |  |  [optional]
**totalEstimatedCost** | **Float** |  |  [optional]
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
