# MaintenanceApi

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**maintenanceCarCarIdDelete**](MaintenanceApi.md#maintenanceCarCarIdDelete) | **DELETE** /maintenance/car/{carId} | Remove maintenance entry for car
[**maintenanceGet**](MaintenanceApi.md#maintenanceGet) | **GET** /maintenance | Get maintenance entries
[**maintenancePost**](MaintenanceApi.md#maintenancePost) | **POST** /maintenance | Create maintenance entry

<a name="maintenanceCarCarIdDelete"></a>
# **maintenanceCarCarIdDelete**
> SuccessResponse maintenanceCarCarIdDelete(carId)

Remove maintenance entry for car

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MaintenanceApi;


MaintenanceApi apiInstance = new MaintenanceApi();
String carId = "carId_example"; // String | 
try {
    SuccessResponse result = apiInstance.maintenanceCarCarIdDelete(carId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MaintenanceApi#maintenanceCarCarIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **carId** | **String**|  |

### Return type

[**SuccessResponse**](SuccessResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="maintenanceGet"></a>
# **maintenanceGet**
> InlineResponse2005 maintenanceGet(page, limit, carId, search, sortBy, sortOrder)

Get maintenance entries

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MaintenanceApi;


MaintenanceApi apiInstance = new MaintenanceApi();
Integer page = 1; // Integer | Page number (starts from 1)
Integer limit = 20; // Integer | Items per page
String carId = "carId_example"; // String | 
String search = "search_example"; // String | 
String sortBy = "sortBy_example"; // String | Field to sort by
String sortOrder = "asc"; // String | Sort order
try {
    InlineResponse2005 result = apiInstance.maintenanceGet(page, limit, carId, search, sortBy, sortOrder);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MaintenanceApi#maintenanceGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| Page number (starts from 1) | [optional] [default to 1] [enum: 1]
 **limit** | **Integer**| Items per page | [optional] [default to 20] [enum: 1, 100]
 **carId** | **String**|  | [optional]
 **search** | **String**|  | [optional]
 **sortBy** | **String**| Field to sort by | [optional]
 **sortOrder** | **String**| Sort order | [optional] [default to asc] [enum: asc, desc]

### Return type

[**InlineResponse2005**](InlineResponse2005.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="maintenancePost"></a>
# **maintenancePost**
> InlineResponse2014 maintenancePost(body)

Create maintenance entry

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MaintenanceApi;


MaintenanceApi apiInstance = new MaintenanceApi();
MaintenanceEntryCreateRequest body = new MaintenanceEntryCreateRequest(); // MaintenanceEntryCreateRequest | 
try {
    InlineResponse2014 result = apiInstance.maintenancePost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MaintenanceApi#maintenancePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MaintenanceEntryCreateRequest**](MaintenanceEntryCreateRequest.md)|  |

### Return type

[**InlineResponse2014**](InlineResponse2014.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

