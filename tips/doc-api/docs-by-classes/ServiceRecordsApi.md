# ServiceRecordsApi

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**serviceRecordsGet**](ServiceRecordsApi.md#serviceRecordsGet) | **GET** /service-records | Get all service records
[**serviceRecordsIdDelete**](ServiceRecordsApi.md#serviceRecordsIdDelete) | **DELETE** /service-records/{id} | Delete service record
[**serviceRecordsIdGet**](ServiceRecordsApi.md#serviceRecordsIdGet) | **GET** /service-records/{id} | Get service record by ID
[**serviceRecordsIdPut**](ServiceRecordsApi.md#serviceRecordsIdPut) | **PUT** /service-records/{id} | Update service record
[**serviceRecordsPost**](ServiceRecordsApi.md#serviceRecordsPost) | **POST** /service-records | Create service record
[**serviceRecordsStatsGet**](ServiceRecordsApi.md#serviceRecordsStatsGet) | **GET** /service-records/stats | Get service record statistics

<a name="serviceRecordsGet"></a>
# **serviceRecordsGet**
> InlineResponse2003 serviceRecordsGet(page, limit, carId, serviceProvider, type, startDate, endDate, minCost, maxCost, search, sortBy, sortOrder)

Get all service records

Retrieve all service records with filtering and pagination

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServiceRecordsApi;


ServiceRecordsApi apiInstance = new ServiceRecordsApi();
Integer page = 1; // Integer | Page number (starts from 1)
Integer limit = 20; // Integer | Items per page
String carId = "carId_example"; // String | 
String serviceProvider = "serviceProvider_example"; // String | 
String type = "type_example"; // String | 
LocalDate startDate = new LocalDate(); // LocalDate | 
LocalDate endDate = new LocalDate(); // LocalDate | 
BigDecimal minCost = new BigDecimal(); // BigDecimal | 
BigDecimal maxCost = new BigDecimal(); // BigDecimal | 
String search = "search_example"; // String | 
String sortBy = "sortBy_example"; // String | Field to sort by
String sortOrder = "asc"; // String | Sort order
try {
    InlineResponse2003 result = apiInstance.serviceRecordsGet(page, limit, carId, serviceProvider, type, startDate, endDate, minCost, maxCost, search, sortBy, sortOrder);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceRecordsApi#serviceRecordsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Page number (starts from 1) | [optional] [default to 1] [enum: 1]
 **limit** | **Integer**| Items per page | [optional] [default to 20] [enum: 1, 100]
 **carId** | **String**|  | [optional]
 **serviceProvider** | **String**|  | [optional]
 **type** | **String**|  | [optional] [enum: maintenance, repair]
 **startDate** | **LocalDate**|  | [optional]
 **endDate** | **LocalDate**|  | [optional]
 **minCost** | **BigDecimal**|  | [optional]
 **maxCost** | **BigDecimal**|  | [optional]
 **search** | **String**|  | [optional]
 **sortBy** | **String**| Field to sort by | [optional]
 **sortOrder** | **String**| Sort order | [optional] [default to asc] [enum: asc, desc]

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="serviceRecordsIdDelete"></a>
# **serviceRecordsIdDelete**
> SuccessResponse serviceRecordsIdDelete(id)

Delete service record

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServiceRecordsApi;


ServiceRecordsApi apiInstance = new ServiceRecordsApi();
String id = "id_example"; // String | 
try {
    SuccessResponse result = apiInstance.serviceRecordsIdDelete(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceRecordsApi#serviceRecordsIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**SuccessResponse**](SuccessResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="serviceRecordsIdGet"></a>
# **serviceRecordsIdGet**
> InlineResponse2013 serviceRecordsIdGet(id)

Get service record by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServiceRecordsApi;


ServiceRecordsApi apiInstance = new ServiceRecordsApi();
String id = "id_example"; // String | 
try {
    InlineResponse2013 result = apiInstance.serviceRecordsIdGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceRecordsApi#serviceRecordsIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**InlineResponse2013**](InlineResponse2013.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="serviceRecordsIdPut"></a>
# **serviceRecordsIdPut**
> InlineResponse2013 serviceRecordsIdPut(body, id)

Update service record

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServiceRecordsApi;


ServiceRecordsApi apiInstance = new ServiceRecordsApi();
ServiceRecordUpdateRequest body = new ServiceRecordUpdateRequest(); // ServiceRecordUpdateRequest | 
String id = "id_example"; // String | 
try {
    InlineResponse2013 result = apiInstance.serviceRecordsIdPut(body, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceRecordsApi#serviceRecordsIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ServiceRecordUpdateRequest**](ServiceRecordUpdateRequest.md)|  |
 **id** | **String**|  |

### Return type

[**InlineResponse2013**](InlineResponse2013.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="serviceRecordsPost"></a>
# **serviceRecordsPost**
> InlineResponse2013 serviceRecordsPost(body)

Create service record

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServiceRecordsApi;


ServiceRecordsApi apiInstance = new ServiceRecordsApi();
ServiceRecordCreateRequest body = new ServiceRecordCreateRequest(); // ServiceRecordCreateRequest | 
try {
    InlineResponse2013 result = apiInstance.serviceRecordsPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceRecordsApi#serviceRecordsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ServiceRecordCreateRequest**](ServiceRecordCreateRequest.md)|  |

### Return type

[**InlineResponse2013**](InlineResponse2013.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="serviceRecordsStatsGet"></a>
# **serviceRecordsStatsGet**
> InlineResponse2004 serviceRecordsStatsGet(carId, startDate, endDate)

Get service record statistics

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServiceRecordsApi;


ServiceRecordsApi apiInstance = new ServiceRecordsApi();
String carId = "carId_example"; // String | 
LocalDate startDate = new LocalDate(); // LocalDate | 
LocalDate endDate = new LocalDate(); // LocalDate | 
try {
    InlineResponse2004 result = apiInstance.serviceRecordsStatsGet(carId, startDate, endDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceRecordsApi#serviceRecordsStatsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **carId** | **String**|  | [optional]
 **startDate** | **LocalDate**|  | [optional]
 **endDate** | **LocalDate**|  | [optional]

### Return type

[**InlineResponse2004**](InlineResponse2004.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

