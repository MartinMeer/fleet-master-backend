# ServiceRecord

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier | 
**carId** | **String** | Associated car ID | 
**carName** | **String** | Car display name | 
**date** | [**LocalDate**](LocalDate.md) | Service date | 
**mileage** | **Integer** | Mileage at service | 
**serviceProvider** | **String** | Service provider name | 
**totalCost** | **Float** | Total service cost | 
**operations** | [**List&lt;ServiceOperation&gt;**](ServiceOperation.md) | List of operations performed | 
**notes** | **String** | Additional notes |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | Creation timestamp | 
