# CustomerApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteCustomersCustomerAddressesAddress**](CustomerApi.md#deleteCustomersCustomerAddressesAddress) | **DELETE** /customers/me/addresses/{address_id} | Delete an Address
[**getCustomersCustomer**](CustomerApi.md#getCustomersCustomer) | **GET** /customers/me | Get a Customer
[**getCustomersCustomerOrders**](CustomerApi.md#getCustomersCustomerOrders) | **GET** /customers/me/orders | List Orders
[**getCustomersCustomerPaymentMethods**](CustomerApi.md#getCustomersCustomerPaymentMethods) | **GET** /customers/me/payment-methods | Get Payment Methods
[**postCustomers**](CustomerApi.md#postCustomers) | **POST** /customers | Create a Customer
[**postCustomersCustomer**](CustomerApi.md#postCustomersCustomer) | **POST** /customers/me | Update Customer
[**postCustomersCustomerAddresses**](CustomerApi.md#postCustomersCustomerAddresses) | **POST** /customers/me/addresses | Add a Shipping Address
[**postCustomersCustomerAddressesAddress**](CustomerApi.md#postCustomersCustomerAddressesAddress) | **POST** /customers/me/addresses/{address_id} | Update a Shipping Address
[**postCustomersCustomerPasswordToken**](CustomerApi.md#postCustomersCustomerPasswordToken) | **POST** /customers/password-token | Request Password Reset
[**postCustomersResetPassword**](CustomerApi.md#postCustomersResetPassword) | **POST** /customers/password-reset | Reset Password

<a name="deleteCustomersCustomerAddressesAddress"></a>
# **deleteCustomersCustomerAddressesAddress**
> StoreCustomersRes deleteCustomersCustomerAddressesAddress(addressId)

Delete an Address

Removes an Address from the Customer&#x27;s saved addresses.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaApiClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.CustomerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

CustomerApi apiInstance = new CustomerApi();
String addressId = "addressId_example"; // String | The id of the Address to remove.
try {
    StoreCustomersRes result = apiInstance.deleteCustomersCustomerAddressesAddress(addressId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerApi#deleteCustomersCustomerAddressesAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **addressId** | **String**| The id of the Address to remove. |

### Return type

[**StoreCustomersRes**](StoreCustomersRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="getCustomersCustomer"></a>
# **getCustomersCustomer**
> StoreCustomersRes getCustomersCustomer()

Get a Customer

Retrieves a Customer - the Customer must be logged in to retrieve their details.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaApiClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.CustomerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

CustomerApi apiInstance = new CustomerApi();
try {
    StoreCustomersRes result = apiInstance.getCustomersCustomer();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerApi#getCustomersCustomer");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**StoreCustomersRes**](StoreCustomersRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="getCustomersCustomerOrders"></a>
# **getCustomersCustomerOrders**
> StoreCustomersListOrdersRes getCustomersCustomerOrders(q, id, status, fulfillmentStatus, paymentStatus, displayId, cartId, email, regionId, currencyCode, taxRate, createdAt, updatedAt, canceledAt, limit, offset, fields, expand)

List Orders

Retrieves a list of a Customer&#x27;s Orders.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaApiClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.CustomerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

CustomerApi apiInstance = new CustomerApi();
String q = "q_example"; // String | Query used for searching orders.
String id = "id_example"; // String | Id of the order to search for.
List<String> status = Arrays.asList("status_example"); // List<String> | Status to search for.
List<String> fulfillmentStatus = Arrays.asList("fulfillmentStatus_example"); // List<String> | Fulfillment status to search for.
List<String> paymentStatus = Arrays.asList("paymentStatus_example"); // List<String> | Payment status to search for.
String displayId = "displayId_example"; // String | Display id to search for.
String cartId = "cartId_example"; // String | to search for.
String email = "email_example"; // String | to search for.
String regionId = "regionId_example"; // String | to search for.
String currencyCode = "currencyCode_example"; // String | The 3 character ISO currency code to set prices based on.
String taxRate = "taxRate_example"; // String | to search for.
CreatedAt1 createdAt = new CreatedAt1(); // CreatedAt1 | Date comparison for when resulting collections were created.
UpdatedAt1 updatedAt = new UpdatedAt1(); // UpdatedAt1 | Date comparison for when resulting collections were updated.
CanceledAt canceledAt = new CanceledAt(); // CanceledAt | Date comparison for when resulting collections were canceled.
Integer limit = 10; // Integer | How many orders to return.
Integer offset = 0; // Integer | The offset in the resulting orders.
String fields = "fields_example"; // String | (Comma separated string) Which fields should be included in the resulting orders.
String expand = "expand_example"; // String | (Comma separated string) Which relations should be expanded in the resulting orders.
try {
    StoreCustomersListOrdersRes result = apiInstance.getCustomersCustomerOrders(q, id, status, fulfillmentStatus, paymentStatus, displayId, cartId, email, regionId, currencyCode, taxRate, createdAt, updatedAt, canceledAt, limit, offset, fields, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerApi#getCustomersCustomerOrders");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **String**| Query used for searching orders. | [optional]
 **id** | **String**| Id of the order to search for. | [optional]
 **status** | [**List&lt;String&gt;**](String.md)| Status to search for. | [optional]
 **fulfillmentStatus** | [**List&lt;String&gt;**](String.md)| Fulfillment status to search for. | [optional]
 **paymentStatus** | [**List&lt;String&gt;**](String.md)| Payment status to search for. | [optional]
 **displayId** | **String**| Display id to search for. | [optional]
 **cartId** | **String**| to search for. | [optional]
 **email** | **String**| to search for. | [optional]
 **regionId** | **String**| to search for. | [optional]
 **currencyCode** | **String**| The 3 character ISO currency code to set prices based on. | [optional]
 **taxRate** | **String**| to search for. | [optional]
 **createdAt** | [**CreatedAt1**](.md)| Date comparison for when resulting collections were created. | [optional]
 **updatedAt** | [**UpdatedAt1**](.md)| Date comparison for when resulting collections were updated. | [optional]
 **canceledAt** | [**CanceledAt**](.md)| Date comparison for when resulting collections were canceled. | [optional]
 **limit** | **Integer**| How many orders to return. | [optional] [default to 10]
 **offset** | **Integer**| The offset in the resulting orders. | [optional] [default to 0]
 **fields** | **String**| (Comma separated string) Which fields should be included in the resulting orders. | [optional]
 **expand** | **String**| (Comma separated string) Which relations should be expanded in the resulting orders. | [optional]

### Return type

[**StoreCustomersListOrdersRes**](StoreCustomersListOrdersRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="getCustomersCustomerPaymentMethods"></a>
# **getCustomersCustomerPaymentMethods**
> StoreCustomersListPaymentMethodsRes getCustomersCustomerPaymentMethods()

Get Payment Methods

Retrieves a list of a Customer&#x27;s saved payment methods. Payment methods are saved with Payment Providers and it is their responsibility to fetch saved methods.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaApiClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.CustomerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

CustomerApi apiInstance = new CustomerApi();
try {
    StoreCustomersListPaymentMethodsRes result = apiInstance.getCustomersCustomerPaymentMethods();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerApi#getCustomersCustomerPaymentMethods");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**StoreCustomersListPaymentMethodsRes**](StoreCustomersListPaymentMethodsRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="postCustomers"></a>
# **postCustomers**
> StoreCustomersRes postCustomers(body)

Create a Customer

Creates a Customer account.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CustomerApi;


CustomerApi apiInstance = new CustomerApi();
StorePostCustomersReq body = new StorePostCustomersReq(); // StorePostCustomersReq | 
try {
    StoreCustomersRes result = apiInstance.postCustomers(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerApi#postCustomers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StorePostCustomersReq**](StorePostCustomersReq.md)|  | [optional]

### Return type

[**StoreCustomersRes**](StoreCustomersRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCustomersCustomer"></a>
# **postCustomersCustomer**
> StoreCustomersRes postCustomersCustomer(body)

Update Customer

Updates a Customer&#x27;s saved details.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaApiClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.CustomerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

CustomerApi apiInstance = new CustomerApi();
StorePostCustomersCustomerReq body = new StorePostCustomersCustomerReq(); // StorePostCustomersCustomerReq | 
try {
    StoreCustomersRes result = apiInstance.postCustomersCustomer(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerApi#postCustomersCustomer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StorePostCustomersCustomerReq**](StorePostCustomersCustomerReq.md)|  | [optional]

### Return type

[**StoreCustomersRes**](StoreCustomersRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="postCustomersCustomerAddresses"></a>
# **postCustomersCustomerAddresses**
> StoreCustomersRes postCustomersCustomerAddresses(body)

Add a Shipping Address

Adds a Shipping Address to a Customer&#x27;s saved addresses.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaApiClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import mobi.appcent.medusa.store.api.CustomerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

CustomerApi apiInstance = new CustomerApi();
StorePostCustomersCustomerAddressesReq body = new StorePostCustomersCustomerAddressesReq(); // StorePostCustomersCustomerAddressesReq | 
try {
    StoreCustomersRes result = apiInstance.postCustomersCustomerAddresses(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerApi#postCustomersCustomerAddresses");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StorePostCustomersCustomerAddressesReq**](StorePostCustomersCustomerAddressesReq.md)|  | [optional]

### Return type

[**StoreCustomersRes**](StoreCustomersRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="postCustomersCustomerAddressesAddress"></a>
# **postCustomersCustomerAddressesAddress**
> StoreCustomersRes postCustomersCustomerAddressesAddress(addressId, body)

Update a Shipping Address

Updates a Customer&#x27;s saved Shipping Address.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaApiClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.CustomerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

CustomerApi apiInstance = new CustomerApi();
String addressId = "addressId_example"; // String | The id of the Address to update.
StorePostCustomersCustomerAddressesAddressReq body = new StorePostCustomersCustomerAddressesAddressReq(); // StorePostCustomersCustomerAddressesAddressReq | 
try {
    StoreCustomersRes result = apiInstance.postCustomersCustomerAddressesAddress(addressId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerApi#postCustomersCustomerAddressesAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **addressId** | **String**| The id of the Address to update. |
 **body** | [**StorePostCustomersCustomerAddressesAddressReq**](StorePostCustomersCustomerAddressesAddressReq.md)|  | [optional]

### Return type

[**StoreCustomersRes**](StoreCustomersRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="postCustomersCustomerPasswordToken"></a>
# **postCustomersCustomerPasswordToken**
> postCustomersCustomerPasswordToken(body)

Request Password Reset

Creates a reset password token to be used in a subsequent /reset-password request. The password token should be sent out of band e.g. via email and will not be returned.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CustomerApi;


CustomerApi apiInstance = new CustomerApi();
StorePostCustomersCustomerPasswordTokenReq body = new StorePostCustomersCustomerPasswordTokenReq(); // StorePostCustomersCustomerPasswordTokenReq | 
try {
    apiInstance.postCustomersCustomerPasswordToken(body);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerApi#postCustomersCustomerPasswordToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StorePostCustomersCustomerPasswordTokenReq**](StorePostCustomersCustomerPasswordTokenReq.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="postCustomersResetPassword"></a>
# **postCustomersResetPassword**
> StoreCustomersRes postCustomersResetPassword(body)

Reset Password

Resets a Customer&#x27;s password using a password token created by a previous /password-token request.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CustomerApi;


CustomerApi apiInstance = new CustomerApi();
StorePostCustomersResetPasswordReq body = new StorePostCustomersResetPasswordReq(); // StorePostCustomersResetPasswordReq | 
try {
    StoreCustomersRes result = apiInstance.postCustomersResetPassword(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomerApi#postCustomersResetPassword");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StorePostCustomersResetPasswordReq**](StorePostCustomersResetPasswordReq.md)|  | [optional]

### Return type

[**StoreCustomersRes**](StoreCustomersRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

