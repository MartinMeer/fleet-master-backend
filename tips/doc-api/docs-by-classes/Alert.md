# Alert

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier | 
**carId** | **String** | Associated car ID | 
**carName** | **String** | Car display name | 
**type** | [**TypeEnum**](#TypeEnum) | Alert type | 
**priority** | [**PriorityEnum**](#PriorityEnum) | Priority level | 
**description** | **String** | Alert description | 
**location** | **String** | Problem location | 
**mileage** | **Integer** | Mileage when reported | 
**reportedAt** | [**OffsetDateTime**](OffsetDateTime.md) | Report timestamp | 
**status** | [**StatusEnum**](#StatusEnum) | Current status | 

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
PROBLEM | &quot;problem&quot;
RECOMMENDATION | &quot;recommendation&quot;

<a name="PriorityEnum"></a>
## Enum: PriorityEnum
Name | Value
---- | -----
CRITICAL | &quot;critical&quot;
UNCLEAR | &quot;unclear&quot;
CAN_WAIT | &quot;can-wait&quot;

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;active&quot;
ARCHIVED | &quot;archived&quot;
