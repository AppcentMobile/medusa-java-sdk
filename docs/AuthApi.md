# AuthApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteAuth**](AuthApi.md#deleteAuth) | **DELETE** /auth | Customer Log out
[**getAuth**](AuthApi.md#getAuth) | **GET** /auth | Get Current Customer
[**getAuthEmail**](AuthApi.md#getAuthEmail) | **GET** /auth/{email} | Check if email exists
[**postAuth**](AuthApi.md#postAuth) | **POST** /auth | Customer Login

<a name="deleteAuth"></a>
# **deleteAuth**
> deleteAuth()

Customer Log out

Destroys a Customer&#x27;s authenticated session.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaApiClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.AuthApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

AuthApi apiInstance = new AuthApi();
try {
    apiInstance.deleteAuth();
} catch (ApiException e) {
    System.err.println("Exception when calling AuthApi#deleteAuth");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="getAuth"></a>
# **getAuth**
> StoreAuthRes getAuth()

Get Current Customer

Gets the currently logged in Customer.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaApiClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.AuthApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

AuthApi apiInstance = new AuthApi();
try {
    StoreAuthRes result = apiInstance.getAuth();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthApi#getAuth");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**StoreAuthRes**](StoreAuthRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="getAuthEmail"></a>
# **getAuthEmail**
> StoreGetAuthEmailRes getAuthEmail(email)

Check if email exists

Checks if a Customer with the given email has signed up.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.AuthApi;


AuthApi apiInstance = new AuthApi();
String email = "email_example"; // String | The email to check if exists.
try {
    StoreGetAuthEmailRes result = apiInstance.getAuthEmail(email);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthApi#getAuthEmail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**| The email to check if exists. |

### Return type

[**StoreGetAuthEmailRes**](StoreGetAuthEmailRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postAuth"></a>
# **postAuth**
> StoreAuthRes postAuth(body)

Customer Login

Logs a Customer in and authorizes them to view their details. Successful authentication will set a session cookie in the Customer&#x27;s browser.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.AuthApi;


AuthApi apiInstance = new AuthApi();
StorePostAuthReq body = new StorePostAuthReq(); // StorePostAuthReq | 
try {
    StoreAuthRes result = apiInstance.postAuth(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthApi#postAuth");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StorePostAuthReq**](StorePostAuthReq.md)|  | [optional]

### Return type

[**StoreAuthRes**](StoreAuthRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

