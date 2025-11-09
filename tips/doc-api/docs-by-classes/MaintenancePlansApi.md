# MaintenancePlansApi

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**maintenancePlansGet**](MaintenancePlansApi.md#maintenancePlansGet) | **GET** /maintenance-plans | Get maintenance plans
[**maintenancePlansIdPut**](MaintenancePlansApi.md#maintenancePlansIdPut) | **PUT** /maintenance-plans/{id} | Update maintenance plan
[**maintenancePlansPost**](MaintenancePlansApi.md#maintenancePlansPost) | **POST** /maintenance-plans | Create maintenance plan

<a name="maintenancePlansGet"></a>
# **maintenancePlansGet**
> InlineResponse2006 maintenancePlansGet(page, limit, carId, status, search, sortBy, sortOrder)

Get maintenance plans

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MaintenancePlansApi;


MaintenancePlansApi apiInstance = new MaintenancePlansApi();
Integer page = 1; // Integer | Page number (starts from 1)
Integer limit = 20; // Integer | Items per page
String carId = "carId_example"; // String | 
String status = "status_example"; // String | 
String search = "search_example"; // String | 
String sortBy = "sortBy_example"; // String | Field to sort by
String sortOrder = "asc"; // String | Sort order
try {
    InlineResponse2006 result = apiInstance.maintenancePlansGet(page, limit, carId, status, search, sortBy, sortOrder);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MaintenancePlansApi#maintenancePlansGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Page number (starts from 1) | [optional] [default to 1] [enum: 1]
 **limit** | **Integer**| Items per page | [optional] [default to 20] [enum: 1, 100]
 **carId** | **String**|  | [optional]
 **status** | **String**|  | [optional] [enum: draft, scheduled, in-progress, completed]
 **search** | **String**|  | [optional]
 **sortBy** | **String**| Field to sort by | [optional]
 **sortOrder** | **String**| Sort order | [optional] [default to asc] [enum: asc, desc]

### Return type

[**InlineResponse2006**](InlineResponse2006.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="maintenancePlansIdPut"></a>
# **maintenancePlansIdPut**
> InlineResponse2015 maintenancePlansIdPut(body, id)

Update maintenance plan

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MaintenancePlansApi;


MaintenancePlansApi apiInstance = new MaintenancePlansApi();
MaintenancePlanUpdateRequest body = new MaintenancePlanUpdateRequest(); // MaintenancePlanUpdateRequest | 
String id = "id_example"; // String | 
try {
    InlineResponse2015 result = apiInstance.maintenancePlansIdPut(body, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MaintenancePlansApi#maintenancePlansIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MaintenancePlanUpdateRequest**](MaintenancePlanUpdateRequest.md)|  |
 **id** | **String**|  |

### Return type

[**InlineResponse2015**](InlineResponse2015.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="maintenancePlansPost"></a>
# **maintenancePlansPost**
> InlineResponse2015 maintenancePlansPost(body)

Create maintenance plan

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MaintenancePlansApi;


MaintenancePlansApi apiInstance = new MaintenancePlansApi();
MaintenancePlanCreateRequest body = new MaintenancePlanCreateRequest(); // MaintenancePlanCreateRequest | 
try {
    InlineResponse2015 result = apiInstance.maintenancePlansPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MaintenancePlansApi#maintenancePlansPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MaintenancePlanCreateRequest**](MaintenancePlanCreateRequest.md)|  |

### Return type

[**InlineResponse2015**](InlineResponse2015.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

