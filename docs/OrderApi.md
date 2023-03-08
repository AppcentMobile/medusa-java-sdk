# OrderApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getOrders**](OrderApi.md#getOrders) | **GET** /orders | Look Up an Order
[**getOrdersOrder**](OrderApi.md#getOrdersOrder) | **GET** /orders/{id} | Get an Order
[**getOrdersOrderCartId**](OrderApi.md#getOrdersOrderCartId) | **GET** /orders/cart/{cart_id} | Get by Cart ID
[**postOrdersCustomerOrderClaimsCustomerOrderClaimAccept**](OrderApi.md#postOrdersCustomerOrderClaimsCustomerOrderClaimAccept) | **POST** /orders/customer/confirm | Verify an Order Claim

<a name="getOrders"></a>
# **getOrders**
> StoreOrdersRes getOrders(displayId, email, fields, expand, shippingAddress)

Look Up an Order

Look up an order using filters.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.OrderApi;


OrderApi apiInstance = new OrderApi();
BigDecimal displayId = new BigDecimal(); // BigDecimal | The display id given to the Order.
String email = "email_example"; // String | The email associated with this order.
String fields = "fields_example"; // String | (Comma separated) Which fields should be included in the result.
String expand = "expand_example"; // String | (Comma separated) Which fields should be expanded in the result.
ShippingAddress shippingAddress = new ShippingAddress(); // ShippingAddress | The shipping address associated with this order.
try {
    StoreOrdersRes result = apiInstance.getOrders(displayId, email, fields, expand, shippingAddress);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#getOrders");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **displayId** | **BigDecimal**| The display id given to the Order. |
 **email** | **String**| The email associated with this order. |
 **fields** | **String**| (Comma separated) Which fields should be included in the result. | [optional]
 **expand** | **String**| (Comma separated) Which fields should be expanded in the result. | [optional]
 **shippingAddress** | [**ShippingAddress**](.md)| The shipping address associated with this order. | [optional]

### Return type

[**StoreOrdersRes**](StoreOrdersRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getOrdersOrder"></a>
# **getOrdersOrder**
> StoreOrdersRes getOrdersOrder(id, fields, expand)

Get an Order

Retrieves an Order

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.OrderApi;


OrderApi apiInstance = new OrderApi();
String id = "id_example"; // String | The id of the Order.
String fields = "fields_example"; // String | (Comma separated) Which fields should be included in the result.
String expand = "expand_example"; // String | (Comma separated) Which fields should be expanded in the result.
try {
    StoreOrdersRes result = apiInstance.getOrdersOrder(id, fields, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#getOrdersOrder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Order. |
 **fields** | **String**| (Comma separated) Which fields should be included in the result. | [optional]
 **expand** | **String**| (Comma separated) Which fields should be expanded in the result. | [optional]

### Return type

[**StoreOrdersRes**](StoreOrdersRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getOrdersOrderCartId"></a>
# **getOrdersOrderCartId**
> StoreOrdersRes getOrdersOrderCartId(cartId)

Get by Cart ID

Retrieves an Order by the id of the Cart that was used to create the Order.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.OrderApi;


OrderApi apiInstance = new OrderApi();
String cartId = "cartId_example"; // String | The ID of Cart.
try {
    StoreOrdersRes result = apiInstance.getOrdersOrderCartId(cartId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#getOrdersOrderCartId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cartId** | **String**| The ID of Cart. |

### Return type

[**StoreOrdersRes**](StoreOrdersRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postOrdersCustomerOrderClaimsCustomerOrderClaimAccept"></a>
# **postOrdersCustomerOrderClaimsCustomerOrderClaimAccept**
> postOrdersCustomerOrderClaimsCustomerOrderClaimAccept(body)

Verify an Order Claim

Verifies the claim order token provided to the customer upon request of order ownership

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaSdkClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.OrderApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

OrderApi apiInstance = new OrderApi();
StorePostCustomersCustomerAcceptClaimReq body = new StorePostCustomersCustomerAcceptClaimReq(); // StorePostCustomersCustomerAcceptClaimReq | 
try {
    apiInstance.postOrdersCustomerOrderClaimsCustomerOrderClaimAccept(body);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#postOrdersCustomerOrderClaimsCustomerOrderClaimAccept");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StorePostCustomersCustomerAcceptClaimReq**](StorePostCustomersCustomerAcceptClaimReq.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

