# ProductApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProducts**](ProductApi.md#getProducts) | **GET** /products | List Products
[**getProductsProduct**](ProductApi.md#getProductsProduct) | **GET** /products/{id} | Get a Product
[**postProductsSearch**](ProductApi.md#postProductsSearch) | **POST** /products/search | Search Products

<a name="getProducts"></a>
# **getProducts**
> StoreProductsListRes getProducts(q, id, salesChannelId, collectionId, typeId, tags, title, description, handle, isGiftcard, createdAt, updatedAt, categoryId, includeCategoryChildren, offset, limit, expand, fields, order, cartId, regionId, currencyCode)

List Products

Retrieves a list of Products.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.ProductApi;


ProductApi apiInstance = new ProductApi();
String q = "q_example"; // String | Query used for searching products by title, description, variant's title, variant's sku, and collection's title
Id id = new Id(); // Id | product IDs to search for.
List<String> salesChannelId = Arrays.asList("salesChannelId_example"); // List<String> | an array of sales channel IDs to filter the retrieved products by.
List<String> collectionId = Arrays.asList("collectionId_example"); // List<String> | Collection IDs to search for
List<String> typeId = Arrays.asList("typeId_example"); // List<String> | Type IDs to search for
List<String> tags = Arrays.asList("tags_example"); // List<String> | Tag IDs to search for
String title = "title_example"; // String | title to search for.
String description = "description_example"; // String | description to search for.
String handle = "handle_example"; // String | handle to search for.
Boolean isGiftcard = true; // Boolean | Search for giftcards using is_giftcard=true.
CreatedAt4 createdAt = new CreatedAt4(); // CreatedAt4 | Date comparison for when resulting products were created.
UpdatedAt4 updatedAt = new UpdatedAt4(); // UpdatedAt4 | Date comparison for when resulting products were updated.
List<String> categoryId = Arrays.asList("categoryId_example"); // List<String> | Category ids to filter by.
Boolean includeCategoryChildren = true; // Boolean | Include category children when filtering by category_id.
Integer offset = 0; // Integer | How many products to skip in the result.
Integer limit = 100; // Integer | Limit the number of products returned.
String expand = "expand_example"; // String | (Comma separated) Which fields should be expanded in each product of the result.
String fields = "fields_example"; // String | (Comma separated) Which fields should be included in each product of the result.
String order = "order_example"; // String | the field used to order the products.
String cartId = "cartId_example"; // String | The id of the Cart to set prices based on.
String regionId = "regionId_example"; // String | The id of the Region to set prices based on.
String currencyCode = "currencyCode_example"; // String | The currency code to use for price selection.
try {
    StoreProductsListRes result = apiInstance.getProducts(q, id, salesChannelId, collectionId, typeId, tags, title, description, handle, isGiftcard, createdAt, updatedAt, categoryId, includeCategoryChildren, offset, limit, expand, fields, order, cartId, regionId, currencyCode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductApi#getProducts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **String**| Query used for searching products by title, description, variant&#x27;s title, variant&#x27;s sku, and collection&#x27;s title | [optional]
 **id** | [**Id**](.md)| product IDs to search for. | [optional]
 **salesChannelId** | [**List&lt;String&gt;**](String.md)| an array of sales channel IDs to filter the retrieved products by. | [optional]
 **collectionId** | [**List&lt;String&gt;**](String.md)| Collection IDs to search for | [optional]
 **typeId** | [**List&lt;String&gt;**](String.md)| Type IDs to search for | [optional]
 **tags** | [**List&lt;String&gt;**](String.md)| Tag IDs to search for | [optional]
 **title** | **String**| title to search for. | [optional]
 **description** | **String**| description to search for. | [optional]
 **handle** | **String**| handle to search for. | [optional]
 **isGiftcard** | **Boolean**| Search for giftcards using is_giftcard&#x3D;true. | [optional]
 **createdAt** | [**CreatedAt4**](.md)| Date comparison for when resulting products were created. | [optional]
 **updatedAt** | [**UpdatedAt4**](.md)| Date comparison for when resulting products were updated. | [optional]
 **categoryId** | [**List&lt;String&gt;**](String.md)| Category ids to filter by. | [optional]
 **includeCategoryChildren** | **Boolean**| Include category children when filtering by category_id. | [optional]
 **offset** | **Integer**| How many products to skip in the result. | [optional] [default to 0]
 **limit** | **Integer**| Limit the number of products returned. | [optional] [default to 100]
 **expand** | **String**| (Comma separated) Which fields should be expanded in each product of the result. | [optional]
 **fields** | **String**| (Comma separated) Which fields should be included in each product of the result. | [optional]
 **order** | **String**| the field used to order the products. | [optional]
 **cartId** | **String**| The id of the Cart to set prices based on. | [optional]
 **regionId** | **String**| The id of the Region to set prices based on. | [optional]
 **currencyCode** | **String**| The currency code to use for price selection. | [optional]

### Return type

[**StoreProductsListRes**](StoreProductsListRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getProductsProduct"></a>
# **getProductsProduct**
> StoreProductsRes getProductsProduct(id, salesChannelId, cartId, regionId, fields, expand, currencyCode)

Get a Product

Retrieves a Product.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.ProductApi;


ProductApi apiInstance = new ProductApi();
String id = "id_example"; // String | The id of the Product.
String salesChannelId = "salesChannelId_example"; // String | The sales channel used when fetching the product.
String cartId = "cartId_example"; // String | The ID of the customer's cart.
String regionId = "regionId_example"; // String | The ID of the region the customer is using. This is helpful to ensure correct prices are retrieved for a region.
String fields = "fields_example"; // String | (Comma separated) Which fields should be included in the result.
String expand = "expand_example"; // String | (Comma separated) Which fields should be expanded in each product of the result.
String currencyCode = "currencyCode_example"; // String | The 3 character ISO currency code to set prices based on. This is helpful to ensure correct prices are retrieved for a currency.
try {
    StoreProductsRes result = apiInstance.getProductsProduct(id, salesChannelId, cartId, regionId, fields, expand, currencyCode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductApi#getProductsProduct");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Product. |
 **salesChannelId** | **String**| The sales channel used when fetching the product. | [optional]
 **cartId** | **String**| The ID of the customer&#x27;s cart. | [optional]
 **regionId** | **String**| The ID of the region the customer is using. This is helpful to ensure correct prices are retrieved for a region. | [optional]
 **fields** | **String**| (Comma separated) Which fields should be included in the result. | [optional]
 **expand** | **String**| (Comma separated) Which fields should be expanded in each product of the result. | [optional]
 **currencyCode** | **String**| The 3 character ISO currency code to set prices based on. This is helpful to ensure correct prices are retrieved for a currency. | [optional]

### Return type

[**StoreProductsRes**](StoreProductsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postProductsSearch"></a>
# **postProductsSearch**
> StorePostSearchRes postProductsSearch(q, offset, limit)

Search Products

Run a search query on products using the search engine installed on Medusa

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.ProductApi;


ProductApi apiInstance = new ProductApi();
String q = "q_example"; // String | The query to run the search with.
Integer offset = 56; // Integer | How many products to skip in the result.
Integer limit = 56; // Integer | Limit the number of products returned.
try {
    StorePostSearchRes result = apiInstance.postProductsSearch(q, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductApi#postProductsSearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **String**| The query to run the search with. |
 **offset** | **Integer**| How many products to skip in the result. | [optional]
 **limit** | **Integer**| Limit the number of products returned. | [optional]

### Return type

[**StorePostSearchRes**](StorePostSearchRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

