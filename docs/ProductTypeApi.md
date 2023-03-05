# ProductTypeApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProductTypes**](ProductTypeApi.md#getProductTypes) | **GET** /product-types | List Product Types

<a name="getProductTypes"></a>
# **getProductTypes**
> StoreProductTypesListRes getProductTypes(limit, offset, order, discountConditionId, value, id, q, createdAt, updatedAt)

List Product Types

Retrieve a list of Product Types.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaSdkClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.ProductTypeApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

ProductTypeApi apiInstance = new ProductTypeApi();
Integer limit = 20; // Integer | The number of types to return.
Integer offset = 0; // Integer | The number of items to skip before the results.
String order = "order_example"; // String | The field to sort items by.
String discountConditionId = "discountConditionId_example"; // String | The discount condition id on which to filter the product types.
List<String> value = Arrays.asList("value_example"); // List<String> | The type values to search for
List<String> id = Arrays.asList("id_example"); // List<String> | The type IDs to search for
String q = "q_example"; // String | A query string to search values for
CreatedAt3 createdAt = new CreatedAt3(); // CreatedAt3 | Date comparison for when resulting product types were created.
UpdatedAt3 updatedAt = new UpdatedAt3(); // UpdatedAt3 | Date comparison for when resulting product types were updated.
try {
    StoreProductTypesListRes result = apiInstance.getProductTypes(limit, offset, order, discountConditionId, value, id, q, createdAt, updatedAt);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductTypeApi#getProductTypes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The number of types to return. | [optional] [default to 20]
 **offset** | **Integer**| The number of items to skip before the results. | [optional] [default to 0]
 **order** | **String**| The field to sort items by. | [optional]
 **discountConditionId** | **String**| The discount condition id on which to filter the product types. | [optional]
 **value** | [**List&lt;String&gt;**](String.md)| The type values to search for | [optional]
 **id** | [**List&lt;String&gt;**](String.md)| The type IDs to search for | [optional]
 **q** | **String**| A query string to search values for | [optional]
 **createdAt** | [**CreatedAt3**](.md)| Date comparison for when resulting product types were created. | [optional]
 **updatedAt** | [**UpdatedAt3**](.md)| Date comparison for when resulting product types were updated. | [optional]

### Return type

[**StoreProductTypesListRes**](StoreProductTypesListRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

