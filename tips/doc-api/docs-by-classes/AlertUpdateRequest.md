# AlertUpdateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]
**priority** | [**PriorityEnum**](#PriorityEnum) |  |  [optional]
**description** | **String** |  |  [optional]
**location** | **String** |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]

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
