# RegionApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getRegions**](RegionApi.md#getRegions) | **GET** /regions | List Regions
[**getRegionsRegion**](RegionApi.md#getRegionsRegion) | **GET** /regions/{id} | Get a Region

<a name="getRegions"></a>
# **getRegions**
> StoreRegionsListRes getRegions(offset, limit, createdAt, updatedAt)

List Regions

Retrieves a list of Regions.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.RegionApi;


RegionApi apiInstance = new RegionApi();
Integer offset = 0; // Integer | How many regions to skip in the result.
Integer limit = 100; // Integer | Limit the number of regions returned.
CreatedAt5 createdAt = new CreatedAt5(); // CreatedAt5 | Date comparison for when resulting regions were created.
UpdatedAt5 updatedAt = new UpdatedAt5(); // UpdatedAt5 | Date comparison for when resulting regions were updated.
try {
    StoreRegionsListRes result = apiInstance.getRegions(offset, limit, createdAt, updatedAt);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RegionApi#getRegions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **offset** | **Integer**| How many regions to skip in the result. | [optional] [default to 0]
 **limit** | **Integer**| Limit the number of regions returned. | [optional] [default to 100]
 **createdAt** | [**CreatedAt5**](.md)| Date comparison for when resulting regions were created. | [optional]
 **updatedAt** | [**UpdatedAt5**](.md)| Date comparison for when resulting regions were updated. | [optional]

### Return type

[**StoreRegionsListRes**](StoreRegionsListRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRegionsRegion"></a>
# **getRegionsRegion**
> StoreRegionsRes getRegionsRegion(id)

Get a Region

Retrieves a Region.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.RegionApi;


RegionApi apiInstance = new RegionApi();
String id = "id_example"; // String | The id of the Region.
try {
    StoreRegionsRes result = apiInstance.getRegionsRegion(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RegionApi#getRegionsRegion");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Region. |

### Return type

[**StoreRegionsRes**](StoreRegionsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

