# AlertsApi

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**alertsGet**](AlertsApi.md#alertsGet) | **GET** /alerts | Get all alerts
[**alertsIdDelete**](AlertsApi.md#alertsIdDelete) | **DELETE** /alerts/{id} | Delete alert
[**alertsIdGet**](AlertsApi.md#alertsIdGet) | **GET** /alerts/{id} | Get alert by ID
[**alertsIdPut**](AlertsApi.md#alertsIdPut) | **PUT** /alerts/{id} | Update alert
[**alertsPost**](AlertsApi.md#alertsPost) | **POST** /alerts | Create a new alert
[**alertsStatsGet**](AlertsApi.md#alertsStatsGet) | **GET** /alerts/stats | Get alert statistics

<a name="alertsGet"></a>
# **alertsGet**
> InlineResponse2001 alertsGet(page, limit, carId, type, priority, status, search, sortBy, sortOrder)

Get all alerts

Retrieve all alerts with filtering and pagination

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AlertsApi;


AlertsApi apiInstance = new AlertsApi();
Integer page = 1; // Integer | Page number (starts from 1)
Integer limit = 20; // Integer | Items per page
String carId = "carId_example"; // String | Filter by car ID
String type = "type_example"; // String | Filter by alert type
String priority = "priority_example"; // String | Filter by priority
String status = "active"; // String | Filter by status
String search = "search_example"; // String | Search in description and location
String sortBy = "sortBy_example"; // String | Field to sort by
String sortOrder = "asc"; // String | Sort order
try {
    InlineResponse2001 result = apiInstance.alertsGet(page, limit, carId, type, priority, status, search, sortBy, sortOrder);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertsApi#alertsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Page number (starts from 1) | [optional] [default to 1] [enum: 1]
 **limit** | **Integer**| Items per page | [optional] [default to 20] [enum: 1, 100]
 **carId** | **String**| Filter by car ID | [optional]
 **type** | **String**| Filter by alert type | [optional] [enum: problem, recommendation]
 **priority** | **String**| Filter by priority | [optional] [enum: critical, unclear, can-wait]
 **status** | **String**| Filter by status | [optional] [default to active] [enum: active, archived]
 **search** | **String**| Search in description and location | [optional]
 **sortBy** | **String**| Field to sort by | [optional]
 **sortOrder** | **String**| Sort order | [optional] [default to asc] [enum: asc, desc]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="alertsIdDelete"></a>
# **alertsIdDelete**
> SuccessResponse alertsIdDelete(id)

Delete alert

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AlertsApi;


AlertsApi apiInstance = new AlertsApi();
String id = "id_example"; // String | 
try {
    SuccessResponse result = apiInstance.alertsIdDelete(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertsApi#alertsIdDelete");
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

<a name="alertsIdGet"></a>
# **alertsIdGet**
> InlineResponse2012 alertsIdGet(id)

Get alert by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AlertsApi;


AlertsApi apiInstance = new AlertsApi();
String id = "id_example"; // String | 
try {
    InlineResponse2012 result = apiInstance.alertsIdGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertsApi#alertsIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**InlineResponse2012**](InlineResponse2012.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="alertsIdPut"></a>
# **alertsIdPut**
> InlineResponse2012 alertsIdPut(body, id)

Update alert

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AlertsApi;


AlertsApi apiInstance = new AlertsApi();
AlertUpdateRequest body = new AlertUpdateRequest(); // AlertUpdateRequest | 
String id = "id_example"; // String | 
try {
    InlineResponse2012 result = apiInstance.alertsIdPut(body, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertsApi#alertsIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AlertUpdateRequest**](AlertUpdateRequest.md)|  |
 **id** | **String**|  |

### Return type

[**InlineResponse2012**](InlineResponse2012.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="alertsPost"></a>
# **alertsPost**
> InlineResponse2012 alertsPost(body)

Create a new alert

Create a new alert for a car

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AlertsApi;


AlertsApi apiInstance = new AlertsApi();
AlertCreateRequest body = new AlertCreateRequest(); // AlertCreateRequest | 
try {
    InlineResponse2012 result = apiInstance.alertsPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertsApi#alertsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AlertCreateRequest**](AlertCreateRequest.md)|  |

### Return type

[**InlineResponse2012**](InlineResponse2012.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="alertsStatsGet"></a>
# **alertsStatsGet**
> InlineResponse2002 alertsStatsGet(carId)

Get alert statistics

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AlertsApi;


AlertsApi apiInstance = new AlertsApi();
String carId = "carId_example"; // String | Filter by car ID
try {
    InlineResponse2002 result = apiInstance.alertsStatsGet(carId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertsApi#alertsStatsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **carId** | **String**| Filter by car ID | [optional]

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

