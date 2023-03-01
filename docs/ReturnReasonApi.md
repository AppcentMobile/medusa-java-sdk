# ReturnReasonApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getReturnReasons**](ReturnReasonApi.md#getReturnReasons) | **GET** /return-reasons | List Return Reasons
[**getReturnReasonsReason**](ReturnReasonApi.md#getReturnReasonsReason) | **GET** /return-reasons/{id} | Get a Return Reason

<a name="getReturnReasons"></a>
# **getReturnReasons**
> StoreReturnReasonsListRes getReturnReasons()

List Return Reasons

Retrieves a list of Return Reasons.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.ReturnReasonApi;


ReturnReasonApi apiInstance = new ReturnReasonApi();
try {
    StoreReturnReasonsListRes result = apiInstance.getReturnReasons();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReturnReasonApi#getReturnReasons");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**StoreReturnReasonsListRes**](StoreReturnReasonsListRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getReturnReasonsReason"></a>
# **getReturnReasonsReason**
> StoreReturnReasonsRes getReturnReasonsReason(id)

Get a Return Reason

Retrieves a Return Reason.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.ReturnReasonApi;


ReturnReasonApi apiInstance = new ReturnReasonApi();
String id = "id_example"; // String | The id of the Return Reason.
try {
    StoreReturnReasonsRes result = apiInstance.getReturnReasonsReason(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReturnReasonApi#getReturnReasonsReason");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Return Reason. |

### Return type

[**StoreReturnReasonsRes**](StoreReturnReasonsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

