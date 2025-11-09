# Car

## Properties
| Name            | Type                                    | Description                   | Notes      |
|-----------------|-----------------------------------------|-------------------------------|------------|
| **id**          | **String**                              | Unique identifier             |            |
| **name**        | **String**                              | Display name                  |            |
| **brand**       | **String**                              | Manufacturer                  |            |
| **model**       | **String**                              | Model name                    |            |
| **year**        | **Integer**                             | Manufacturing year            |            |
| **vin**         | **String**                              | Vehicle Identification Number | [optional] |
| **plateNumber** | **String**                              | License plate                 | [optional] |
| **mileage**     | **Integer**                             | Current mileage               |            |
| **image**       | **String**                              | Image URL/path                | [optional] |
| **lastService** | [**LocalDate**](LocalDate.md)           | Last service date             | [optional] |
| **nextService** | [**LocalDate**](LocalDate.md)           | Next service date             | [optional] |
| **createdAt**   | [**OffsetDateTime**](OffsetDateTime.md) | Creation timestamp            |            | 
