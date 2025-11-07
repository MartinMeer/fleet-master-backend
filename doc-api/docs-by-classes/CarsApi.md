# CarsApi

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**carsBulkPost**](CarsApi.md#carsBulkPost) | **POST** /cars/bulk | Bulk create cars
[**carsGet**](CarsApi.md#carsGet) | **GET** /cars | Get all cars
[**carsIdDelete**](CarsApi.md#carsIdDelete) | **DELETE** /cars/{id} | Delete car
[**carsIdGet**](CarsApi.md#carsIdGet) | **GET** /cars/{id} | Get car by ID
[**carsIdPut**](CarsApi.md#carsIdPut) | **PUT** /cars/{id} | Update car
[**carsPost**](CarsApi.md#carsPost) | **POST** /cars | Create a new car

<a name="carsBulkPost"></a>
# **carsBulkPost**
> InlineResponse2011 carsBulkPost(body)

Bulk create cars

Create multiple cars in a single request

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarsApi;


CarsApi apiInstance = new CarsApi();
CarsBulkBody body = new CarsBulkBody(); // CarsBulkBody | 
try {
    InlineResponse2011 result = apiInstance.carsBulkPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarsApi#carsBulkPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CarsBulkBody**](CarsBulkBody.md)|  |

### Return type

[**InlineResponse2011**](InlineResponse2011.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="carsGet"></a>
# **carsGet**
> InlineResponse200 carsGet(page, limit, search, brand, year, minMileage, maxMileage, sortBy, sortOrder)

Get all cars

Retrieve all cars with optional filtering, searching, and pagination

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarsApi;


CarsApi apiInstance = new CarsApi();
Integer page = 1; // Integer | Page number (starts from 1)
Integer limit = 20; // Integer | Items per page
String search = "search_example"; // String | Search in name, brand, model, plate number
String brand = "brand_example"; // String | Filter by brand
Integer year = 56; // Integer | Filter by year
Integer minMileage = 56; // Integer | Minimum mileage filter
Integer maxMileage = 56; // Integer | Maximum mileage filter
String sortBy = "sortBy_example"; // String | Field to sort by
String sortOrder = "asc"; // String | Sort order
try {
    InlineResponse200 result = apiInstance.carsGet(page, limit, search, brand, year, minMileage, maxMileage, sortBy, sortOrder);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarsApi#carsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Page number (starts from 1) | [optional] [default to 1] [enum: 1]
 **limit** | **Integer**| Items per page | [optional] [default to 20] [enum: 1, 100]
 **search** | **String**| Search in name, brand, model, plate number | [optional]
 **brand** | **String**| Filter by brand | [optional]
 **year** | **Integer**| Filter by year | [optional]
 **minMileage** | **Integer**| Minimum mileage filter | [optional]
 **maxMileage** | **Integer**| Maximum mileage filter | [optional]
 **sortBy** | **String**| Field to sort by | [optional]
 **sortOrder** | **String**| Sort order | [optional] [default to asc] [enum: asc, desc]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="carsIdDelete"></a>
# **carsIdDelete**
> SuccessResponse carsIdDelete(id)

Delete car

Delete a car and all associated data

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarsApi;


CarsApi apiInstance = new CarsApi();
String id = "id_example"; // String | Car ID
try {
    SuccessResponse result = apiInstance.carsIdDelete(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarsApi#carsIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Car ID |

### Return type

[**SuccessResponse**](SuccessResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="carsIdGet"></a>
# **carsIdGet**
> InlineResponse201 carsIdGet(id)

Get car by ID

Retrieve a specific car by its ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarsApi;


CarsApi apiInstance = new CarsApi();
String id = "id_example"; // String | Car ID
try {
    InlineResponse201 result = apiInstance.carsIdGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarsApi#carsIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Car ID |

### Return type

[**InlineResponse201**](InlineResponse201.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="carsIdPut"></a>
# **carsIdPut**
> InlineResponse201 carsIdPut(name, brand, model, year, vin, plateNumber, mileage, lastService, nextService, image, id)

Update car

Update an existing car with optional image upload

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarsApi;


CarsApi apiInstance = new CarsApi();
String name = "name_example"; // String | 
String brand = "brand_example"; // String | 
String model = "model_example"; // String | 
Integer year = 56; // Integer | 
String vin = "vin_example"; // String | 
String plateNumber = "plateNumber_example"; // String | 
Integer mileage = 56; // Integer | 
LocalDate lastService = new LocalDate(); // LocalDate | 
LocalDate nextService = new LocalDate(); // LocalDate | 
File image = new File("image_example"); // File | 
String id = "id_example"; // String | Car ID
try {
    InlineResponse201 result = apiInstance.carsIdPut(name, brand, model, year, vin, plateNumber, mileage, lastService, nextService, image, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarsApi#carsIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  |
 **brand** | **String**|  |
 **model** | **String**|  |
 **year** | **Integer**|  | [enum: 2024, 1900]
 **vin** | **String**|  |
 **plateNumber** | **String**|  |
 **mileage** | **Integer**|  | [enum: 0]
 **lastService** | **LocalDate**|  |
 **nextService** | **LocalDate**|  |
 **image** | **File**|  |
 **id** | **String**| Car ID |

### Return type

[**InlineResponse201**](InlineResponse201.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="carsPost"></a>
# **carsPost**
> InlineResponse201 carsPost(name, brand, model, year, vin, plateNumber, mileage, lastService, nextService, image)

Create a new car

Create a new car with optional image upload

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CarsApi;


CarsApi apiInstance = new CarsApi();
String name = "name_example"; // String | 
String brand = "brand_example"; // String | 
String model = "model_example"; // String | 
Integer year = 56; // Integer | 
String vin = "vin_example"; // String | 
String plateNumber = "plateNumber_example"; // String | 
Integer mileage = 56; // Integer | 
LocalDate lastService = new LocalDate(); // LocalDate | 
LocalDate nextService = new LocalDate(); // LocalDate | 
File image = new File("image_example"); // File | 
try {
    InlineResponse201 result = apiInstance.carsPost(name, brand, model, year, vin, plateNumber, mileage, lastService, nextService, image);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CarsApi#carsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  |
 **brand** | **String**|  |
 **model** | **String**|  |
 **year** | **Integer**|  | [enum: 2024, 1900]
 **vin** | **String**|  |
 **plateNumber** | **String**|  |
 **mileage** | **Integer**|  | [enum: 0]
 **lastService** | **LocalDate**|  |
 **nextService** | **LocalDate**|  |
 **image** | **File**|  |

### Return type

[**InlineResponse201**](InlineResponse201.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

