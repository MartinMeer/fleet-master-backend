# ServiceOperation

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier | 
**type** | [**TypeEnum**](#TypeEnum) | Operation type | 
**description** | **String** | Operation description | 
**cost** | **Float** | Operation cost | 
**parts** | **List&lt;String&gt;** | Parts used |  [optional]
**laborCost** | **Float** | Labor cost |  [optional]
**linkedAlertId** | **String** | Linked alert ID |  [optional]
**recommendations** | **String** | Post-service recommendations |  [optional]

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
MAINTENANCE | &quot;maintenance&quot;
REPAIR | &quot;repair&quot;
