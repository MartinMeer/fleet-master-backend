# ServiceOperationCreateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) |  | 
**description** | **String** |  | 
**cost** | **Float** |  | 
**parts** | **List&lt;String&gt;** |  |  [optional]
**laborCost** | **Float** |  |  [optional]
**linkedAlertId** | **String** |  |  [optional]
**recommendations** | **String** |  |  [optional]

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
MAINTENANCE | &quot;maintenance&quot;
REPAIR | &quot;repair&quot;
