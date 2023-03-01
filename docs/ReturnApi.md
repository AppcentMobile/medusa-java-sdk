# ReturnApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**postReturns**](ReturnApi.md#postReturns) | **POST** /returns | Create Return

<a name="postReturns"></a>
# **postReturns**
> StoreReturnsRes postReturns(body)

Create Return

Creates a Return for an Order.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.ReturnApi;


ReturnApi apiInstance = new ReturnApi();
StorePostReturnsReq body = new StorePostReturnsReq(); // StorePostReturnsReq | 
try {
    StoreReturnsRes result = apiInstance.postReturns(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReturnApi#postReturns");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StorePostReturnsReq**](StorePostReturnsReq.md)|  | [optional]

### Return type

[**StoreReturnsRes**](StoreReturnsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

