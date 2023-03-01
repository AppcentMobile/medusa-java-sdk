# ProductTagApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProductTags**](ProductTagApi.md#getProductTags) | **GET** /product-tags | List Product Tags

<a name="getProductTags"></a>
# **getProductTags**
> InlineResponse200 getProductTags(limit, offset, order, discountConditionId, value, id, q, createdAt, updatedAt)

List Product Tags

Retrieve a list of Product Tags.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.ProductTagApi;


ProductTagApi apiInstance = new ProductTagApi();
Integer limit = 20; // Integer | The number of types to return.
Integer offset = 0; // Integer | The number of items to skip before the results.
String order = "order_example"; // String | The field to sort items by.
String discountConditionId = "discountConditionId_example"; // String | The discount condition id on which to filter the product tags.
List<String> value = Arrays.asList("value_example"); // List<String> | The tag values to search for
List<String> id = Arrays.asList("id_example"); // List<String> | The tag IDs to search for
String q = "q_example"; // String | A query string to search values for
CreatedAt2 createdAt = new CreatedAt2(); // CreatedAt2 | Date comparison for when resulting product tags were created.
UpdatedAt2 updatedAt = new UpdatedAt2(); // UpdatedAt2 | Date comparison for when resulting product tags were updated.
try {
    InlineResponse200 result = apiInstance.getProductTags(limit, offset, order, discountConditionId, value, id, q, createdAt, updatedAt);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductTagApi#getProductTags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **Integer**| The number of types to return. | [optional] [default to 20]
 **offset** | **Integer**| The number of items to skip before the results. | [optional] [default to 0]
 **order** | **String**| The field to sort items by. | [optional]
 **discountConditionId** | **String**| The discount condition id on which to filter the product tags. | [optional]
 **value** | [**List&lt;String&gt;**](String.md)| The tag values to search for | [optional]
 **id** | [**List&lt;String&gt;**](String.md)| The tag IDs to search for | [optional]
 **q** | **String**| A query string to search values for | [optional]
 **createdAt** | [**CreatedAt2**](.md)| Date comparison for when resulting product tags were created. | [optional]
 **updatedAt** | [**UpdatedAt2**](.md)| Date comparison for when resulting product tags were updated. | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

