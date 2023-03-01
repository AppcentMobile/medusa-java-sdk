# ShippingOptionApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getShippingOptions**](ShippingOptionApi.md#getShippingOptions) | **GET** /shipping-options | Get Shipping Options
[**getShippingOptionsCartId**](ShippingOptionApi.md#getShippingOptionsCartId) | **GET** /shipping-options/{cart_id} | List for Cart

<a name="getShippingOptions"></a>
# **getShippingOptions**
> StoreShippingOptionsListRes getShippingOptions(isReturn, productIds, regionId)

Get Shipping Options

Retrieves a list of Shipping Options.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.ShippingOptionApi;


ShippingOptionApi apiInstance = new ShippingOptionApi();
Boolean isReturn = true; // Boolean | Whether return Shipping Options should be included. By default all Shipping Options are returned.
String productIds = "productIds_example"; // String | A comma separated list of Product ids to filter Shipping Options by.
String regionId = "regionId_example"; // String | the Region to retrieve Shipping Options from.
try {
    StoreShippingOptionsListRes result = apiInstance.getShippingOptions(isReturn, productIds, regionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShippingOptionApi#getShippingOptions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **isReturn** | **Boolean**| Whether return Shipping Options should be included. By default all Shipping Options are returned. | [optional]
 **productIds** | **String**| A comma separated list of Product ids to filter Shipping Options by. | [optional]
 **regionId** | **String**| the Region to retrieve Shipping Options from. | [optional]

### Return type

[**StoreShippingOptionsListRes**](StoreShippingOptionsListRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getShippingOptionsCartId"></a>
# **getShippingOptionsCartId**
> StoreShippingOptionsListRes getShippingOptionsCartId(cartId)

List for Cart

Retrieves a list of Shipping Options available to a cart.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.ShippingOptionApi;


ShippingOptionApi apiInstance = new ShippingOptionApi();
String cartId = "cartId_example"; // String | The id of the Cart.
try {
    StoreShippingOptionsListRes result = apiInstance.getShippingOptionsCartId(cartId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShippingOptionApi#getShippingOptionsCartId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cartId** | **String**| The id of the Cart. |

### Return type

[**StoreShippingOptionsListRes**](StoreShippingOptionsListRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

