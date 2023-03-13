# InviteApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**postOrdersCustomerOrderClaim**](InviteApi.md#postOrdersCustomerOrderClaim) | **POST** /orders/batch/customer/token | Claim an Order

<a name="postOrdersCustomerOrderClaim"></a>
# **postOrdersCustomerOrderClaim**
> postOrdersCustomerOrderClaim(body)

Claim an Order

Sends an email to emails registered to orders provided with link to transfer order ownership

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaSdkClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.InviteApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

InviteApi apiInstance = new InviteApi();
StorePostCustomersCustomerOrderClaimReq body = new StorePostCustomersCustomerOrderClaimReq(); // StorePostCustomersCustomerOrderClaimReq | 
try {
    apiInstance.postOrdersCustomerOrderClaim(body);
} catch (ApiException e) {
    System.err.println("Exception when calling InviteApi#postOrdersCustomerOrderClaim");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StorePostCustomersCustomerOrderClaimReq**](StorePostCustomersCustomerOrderClaimReq.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

