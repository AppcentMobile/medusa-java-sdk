# PaymentCollectionApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPaymentCollectionsPaymentCollection**](PaymentCollectionApi.md#getPaymentCollectionsPaymentCollection) | **GET** /payment-collections/{id} | Get a PaymentCollection
[**postPaymentCollectionsPaymentCollectionPaymentSessionsSession**](PaymentCollectionApi.md#postPaymentCollectionsPaymentCollectionPaymentSessionsSession) | **POST** /payment-collections/{id}/sessions/{session_id} | Refresh a Payment Session
[**postPaymentCollectionsPaymentCollectionSessionsBatch**](PaymentCollectionApi.md#postPaymentCollectionsPaymentCollectionSessionsBatch) | **POST** /payment-collections/{id}/sessions/batch | Manage Payment Sessions
[**postPaymentCollectionsSessions**](PaymentCollectionApi.md#postPaymentCollectionsSessions) | **POST** /payment-collections/{id}/sessions | Manage a Payment Session
[**postPaymentCollectionsSessionsBatchAuthorize**](PaymentCollectionApi.md#postPaymentCollectionsSessionsBatchAuthorize) | **POST** /payment-collections/{id}/sessions/batch/authorize | Authorize PaymentSessions
[**postPaymentCollectionsSessionsSessionAuthorize**](PaymentCollectionApi.md#postPaymentCollectionsSessionsSessionAuthorize) | **POST** /payment-collections/{id}/sessions/{session_id}/authorize | Authorize Payment Session

<a name="getPaymentCollectionsPaymentCollection"></a>
# **getPaymentCollectionsPaymentCollection**
> StorePaymentCollectionsRes getPaymentCollectionsPaymentCollection(id, expand, fields)

Get a PaymentCollection

Get a Payment Collection

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaSdkClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.PaymentCollectionApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

PaymentCollectionApi apiInstance = new PaymentCollectionApi();
String id = "id_example"; // String | The ID of the PaymentCollection.
String expand = "expand_example"; // String | Comma separated list of relations to include in the results.
String fields = "fields_example"; // String | Comma separated list of fields to include in the results.
try {
    StorePaymentCollectionsRes result = apiInstance.getPaymentCollectionsPaymentCollection(id, expand, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentCollectionApi#getPaymentCollectionsPaymentCollection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the PaymentCollection. |
 **expand** | **String**| Comma separated list of relations to include in the results. | [optional]
 **fields** | **String**| Comma separated list of fields to include in the results. | [optional]

### Return type

[**StorePaymentCollectionsRes**](StorePaymentCollectionsRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="postPaymentCollectionsPaymentCollectionPaymentSessionsSession"></a>
# **postPaymentCollectionsPaymentCollectionPaymentSessionsSession**
> StorePaymentCollectionsSessionRes postPaymentCollectionsPaymentCollectionPaymentSessionsSession(id, sessionId)

Refresh a Payment Session

Refreshes a Payment Session to ensure that it is in sync with the Payment Collection.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.PaymentCollectionApi;


PaymentCollectionApi apiInstance = new PaymentCollectionApi();
String id = "id_example"; // String | The id of the PaymentCollection.
String sessionId = "sessionId_example"; // String | The id of the Payment Session to be refreshed.
try {
    StorePaymentCollectionsSessionRes result = apiInstance.postPaymentCollectionsPaymentCollectionPaymentSessionsSession(id, sessionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentCollectionApi#postPaymentCollectionsPaymentCollectionPaymentSessionsSession");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the PaymentCollection. |
 **sessionId** | **String**| The id of the Payment Session to be refreshed. |

### Return type

[**StorePaymentCollectionsSessionRes**](StorePaymentCollectionsSessionRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postPaymentCollectionsPaymentCollectionSessionsBatch"></a>
# **postPaymentCollectionsPaymentCollectionSessionsBatch**
> StorePaymentCollectionsRes postPaymentCollectionsPaymentCollectionSessionsBatch(id, body)

Manage Payment Sessions

Manages Multiple Payment Sessions from Payment Collections.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaSdkClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.PaymentCollectionApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

PaymentCollectionApi apiInstance = new PaymentCollectionApi();
String id = "id_example"; // String | The ID of the Payment Collections.
StorePostPaymentCollectionsBatchSessionsReq body = new StorePostPaymentCollectionsBatchSessionsReq(); // StorePostPaymentCollectionsBatchSessionsReq | 
try {
    StorePaymentCollectionsRes result = apiInstance.postPaymentCollectionsPaymentCollectionSessionsBatch(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentCollectionApi#postPaymentCollectionsPaymentCollectionSessionsBatch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the Payment Collections. |
 **body** | [**StorePostPaymentCollectionsBatchSessionsReq**](StorePostPaymentCollectionsBatchSessionsReq.md)|  | [optional]

### Return type

[**StorePaymentCollectionsRes**](StorePaymentCollectionsRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="postPaymentCollectionsSessions"></a>
# **postPaymentCollectionsSessions**
> StorePaymentCollectionsRes postPaymentCollectionsSessions(id, body)

Manage a Payment Session

Manages Payment Sessions from Payment Collections.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaSdkClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.PaymentCollectionApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

PaymentCollectionApi apiInstance = new PaymentCollectionApi();
String id = "id_example"; // String | The ID of the Payment Collection.
StorePaymentCollectionSessionsReq body = new StorePaymentCollectionSessionsReq(); // StorePaymentCollectionSessionsReq | 
try {
    StorePaymentCollectionsRes result = apiInstance.postPaymentCollectionsSessions(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentCollectionApi#postPaymentCollectionsSessions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the Payment Collection. |
 **body** | [**StorePaymentCollectionSessionsReq**](StorePaymentCollectionSessionsReq.md)|  | [optional]

### Return type

[**StorePaymentCollectionsRes**](StorePaymentCollectionsRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="postPaymentCollectionsSessionsBatchAuthorize"></a>
# **postPaymentCollectionsSessionsBatchAuthorize**
> StorePaymentCollectionsRes postPaymentCollectionsSessionsBatchAuthorize(id, body)

Authorize PaymentSessions

Authorizes Payment Sessions of a Payment Collection.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaSdkClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.PaymentCollectionApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

PaymentCollectionApi apiInstance = new PaymentCollectionApi();
String id = "id_example"; // String | The ID of the Payment Collections.
StorePostPaymentCollectionsBatchSessionsAuthorizeReq body = new StorePostPaymentCollectionsBatchSessionsAuthorizeReq(); // StorePostPaymentCollectionsBatchSessionsAuthorizeReq | 
try {
    StorePaymentCollectionsRes result = apiInstance.postPaymentCollectionsSessionsBatchAuthorize(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentCollectionApi#postPaymentCollectionsSessionsBatchAuthorize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the Payment Collections. |
 **body** | [**StorePostPaymentCollectionsBatchSessionsAuthorizeReq**](StorePostPaymentCollectionsBatchSessionsAuthorizeReq.md)|  | [optional]

### Return type

[**StorePaymentCollectionsRes**](StorePaymentCollectionsRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="postPaymentCollectionsSessionsSessionAuthorize"></a>
# **postPaymentCollectionsSessionsSessionAuthorize**
> StorePaymentCollectionsSessionRes postPaymentCollectionsSessionsSessionAuthorize(id, sessionId)

Authorize Payment Session

Authorizes a Payment Session of a Payment Collection.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaSdkClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.PaymentCollectionApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

PaymentCollectionApi apiInstance = new PaymentCollectionApi();
String id = "id_example"; // String | The ID of the Payment Collections.
String sessionId = "sessionId_example"; // String | The ID of the Payment Session.
try {
    StorePaymentCollectionsSessionRes result = apiInstance.postPaymentCollectionsSessionsSessionAuthorize(id, sessionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentCollectionApi#postPaymentCollectionsSessionsSessionAuthorize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the Payment Collections. |
 **sessionId** | **String**| The ID of the Payment Session. |

### Return type

[**StorePaymentCollectionsSessionRes**](StorePaymentCollectionsSessionRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

