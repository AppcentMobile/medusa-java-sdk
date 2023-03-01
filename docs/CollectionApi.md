# CollectionApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCollections**](CollectionApi.md#getCollections) | **GET** /collections | List Collections
[**getCollectionsCollection**](CollectionApi.md#getCollectionsCollection) | **GET** /collections/{id} | Get a Collection

<a name="getCollections"></a>
# **getCollections**
> StoreCollectionsListRes getCollections(offset, limit, createdAt, updatedAt)

List Collections

Retrieve a list of Product Collection.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CollectionApi;


CollectionApi apiInstance = new CollectionApi();
Integer offset = 0; // Integer | The number of collections to skip before starting to collect the collections set
Integer limit = 10; // Integer | The number of collections to return
CreatedAt createdAt = new CreatedAt(); // CreatedAt | Date comparison for when resulting collections were created.
UpdatedAt updatedAt = new UpdatedAt(); // UpdatedAt | Date comparison for when resulting collections were updated.
try {
    StoreCollectionsListRes result = apiInstance.getCollections(offset, limit, createdAt, updatedAt);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CollectionApi#getCollections");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **offset** | **Integer**| The number of collections to skip before starting to collect the collections set | [optional] [default to 0]
 **limit** | **Integer**| The number of collections to return | [optional] [default to 10]
 **createdAt** | [**CreatedAt**](.md)| Date comparison for when resulting collections were created. | [optional]
 **updatedAt** | [**UpdatedAt**](.md)| Date comparison for when resulting collections were updated. | [optional]

### Return type

[**StoreCollectionsListRes**](StoreCollectionsListRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCollectionsCollection"></a>
# **getCollectionsCollection**
> StoreCollectionsRes getCollectionsCollection(id)

Get a Collection

Retrieves a Product Collection.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CollectionApi;


CollectionApi apiInstance = new CollectionApi();
String id = "id_example"; // String | The id of the Product Collection
try {
    StoreCollectionsRes result = apiInstance.getCollectionsCollection(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CollectionApi#getCollectionsCollection");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Product Collection |

### Return type

[**StoreCollectionsRes**](StoreCollectionsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

