# ProductCategoryApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProductCategories**](ProductCategoryApi.md#getProductCategories) | **GET** /product-categories | List Product Categories
[**getProductCategoriesCategory**](ProductCategoryApi.md#getProductCategoriesCategory) | **GET** /product-categories/{id} | Get a Product Category

<a name="getProductCategories"></a>
# **getProductCategories**
> StoreProductCategoriesListRes getProductCategories(q, parentCategoryId, offset, limit)

List Product Categories

Retrieve a list of product categories.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaSdkClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.ProductCategoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

ProductCategoryApi apiInstance = new ProductCategoryApi();
String q = "q_example"; // String | Query used for searching product category names orhandles.
String parentCategoryId = "parentCategoryId_example"; // String | Returns categories scoped by parent
Integer offset = 0; // Integer | How many product categories to skip in the result.
Integer limit = 100; // Integer | Limit the number of product categories returned.
try {
    StoreProductCategoriesListRes result = apiInstance.getProductCategories(q, parentCategoryId, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductCategoryApi#getProductCategories");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **String**| Query used for searching product category names orhandles. | [optional]
 **parentCategoryId** | **String**| Returns categories scoped by parent | [optional]
 **offset** | **Integer**| How many product categories to skip in the result. | [optional] [default to 0]
 **limit** | **Integer**| Limit the number of product categories returned. | [optional] [default to 100]

### Return type

[**StoreProductCategoriesListRes**](StoreProductCategoriesListRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="getProductCategoriesCategory"></a>
# **getProductCategoriesCategory**
> StoreGetProductCategoriesCategoryRes getProductCategoriesCategory(id, expand, fields)

Get a Product Category

Retrieves a Product Category.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.MedusaSdkClient;
//import mobi.appcent.medusa.store.ApiException;
//import mobi.appcent.medusa.store.Configuration;
//import mobi.appcent.medusa.store.auth.*;
//import api.mobi.appcent.medusa.store.ProductCategoryApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: cookie_auth
ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
cookie_auth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//cookie_auth.setApiKeyPrefix("Token");

ProductCategoryApi apiInstance = new ProductCategoryApi();
String id = "id_example"; // String | The ID of the Product Category
String expand = "expand_example"; // String | (Comma separated) Which fields should be expanded in each product category.
String fields = "fields_example"; // String | (Comma separated) Which fields should be retrieved in each product category.
try {
    StoreGetProductCategoriesCategoryRes result = apiInstance.getProductCategoriesCategory(id, expand, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductCategoryApi#getProductCategoriesCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the Product Category |
 **expand** | **String**| (Comma separated) Which fields should be expanded in each product category. | [optional]
 **fields** | **String**| (Comma separated) Which fields should be retrieved in each product category. | [optional]

### Return type

[**StoreGetProductCategoriesCategoryRes**](StoreGetProductCategoriesCategoryRes.md)

### Authorization

[cookie_auth](../README.md#cookie_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

