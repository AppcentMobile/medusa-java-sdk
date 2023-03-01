# SwapApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getSwapsSwapCartId**](SwapApi.md#getSwapsSwapCartId) | **GET** /swaps/{cart_id} | Get by Cart ID
[**postSwaps**](SwapApi.md#postSwaps) | **POST** /swaps | Create a Swap

<a name="getSwapsSwapCartId"></a>
# **getSwapsSwapCartId**
> StoreSwapsRes getSwapsSwapCartId(cartId)

Get by Cart ID

Retrieves a Swap by the id of the Cart used to confirm the Swap.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.SwapApi;


SwapApi apiInstance = new SwapApi();
String cartId = "cartId_example"; // String | The id of the Cart
try {
    StoreSwapsRes result = apiInstance.getSwapsSwapCartId(cartId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SwapApi#getSwapsSwapCartId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cartId** | **String**| The id of the Cart |

### Return type

[**StoreSwapsRes**](StoreSwapsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postSwaps"></a>
# **postSwaps**
> StoreSwapsRes postSwaps(body)

Create a Swap

Creates a Swap on an Order by providing some items to return along with some items to send back

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.SwapApi;


SwapApi apiInstance = new SwapApi();
StorePostSwapsReq body = new StorePostSwapsReq(); // StorePostSwapsReq | 
try {
    StoreSwapsRes result = apiInstance.postSwaps(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SwapApi#postSwaps");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StorePostSwapsReq**](StorePostSwapsReq.md)|  | [optional]

### Return type

[**StoreSwapsRes**](StoreSwapsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

