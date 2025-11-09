# AlertCreateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**carId** | **String** |  | 
**carName** | **String** |  | 
**type** | [**TypeEnum**](#TypeEnum) |  | 
**priority** | [**PriorityEnum**](#PriorityEnum) |  | 
**description** | **String** |  | 
**location** | **String** |  | 
**mileage** | **Integer** |  | 

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
