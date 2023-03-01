# ProductVariantApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getVariants**](ProductVariantApi.md#getVariants) | **GET** /variants | Get Product Variants
[**getVariantsVariant**](ProductVariantApi.md#getVariantsVariant) | **GET** /variants/{variant_id} | Get a Product Variant

<a name="getVariants"></a>
# **getVariants**
> StoreVariantsListRes getVariants(ids, salesChannelId, expand, offset, limit, cartId, regionId, currencyCode, title, inventoryQuantity)

Get Product Variants

Retrieves a list of Product Variants

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.ProductVariantApi;


ProductVariantApi apiInstance = new ProductVariantApi();
String ids = "ids_example"; // String | A comma separated list of Product Variant ids to filter by.
String salesChannelId = "salesChannelId_example"; // String | A sales channel id for result configuration.
String expand = "expand_example"; // String | A comma separated list of Product Variant relations to load.
BigDecimal offset = new BigDecimal(); // BigDecimal | How many product variants to skip in the result.
BigDecimal limit = new BigDecimal(); // BigDecimal | Maximum number of Product Variants to return.
String cartId = "cartId_example"; // String | The id of the Cart to set prices based on.
String regionId = "regionId_example"; // String | The id of the Region to set prices based on.
String currencyCode = "currencyCode_example"; // String | The currency code to use for price selection.
Title title = new Title(); // Title | product variant title to search for.
InventoryQuantity inventoryQuantity = new InventoryQuantity(); // InventoryQuantity | Filter by available inventory quantity
try {
    StoreVariantsListRes result = apiInstance.getVariants(ids, salesChannelId, expand, offset, limit, cartId, regionId, currencyCode, title, inventoryQuantity);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductVariantApi#getVariants");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ids** | **String**| A comma separated list of Product Variant ids to filter by. | [optional]
 **salesChannelId** | **String**| A sales channel id for result configuration. | [optional]
 **expand** | **String**| A comma separated list of Product Variant relations to load. | [optional]
 **offset** | **BigDecimal**| How many product variants to skip in the result. | [optional]
 **limit** | **BigDecimal**| Maximum number of Product Variants to return. | [optional]
 **cartId** | **String**| The id of the Cart to set prices based on. | [optional]
 **regionId** | **String**| The id of the Region to set prices based on. | [optional]
 **currencyCode** | **String**| The currency code to use for price selection. | [optional]
 **title** | [**Title**](.md)| product variant title to search for. | [optional]
 **inventoryQuantity** | [**InventoryQuantity**](.md)| Filter by available inventory quantity | [optional]

### Return type

[**StoreVariantsListRes**](StoreVariantsListRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getVariantsVariant"></a>
# **getVariantsVariant**
> StoreVariantsRes getVariantsVariant(variantId, cartId, salesChannelId, regionId, currencyCode)

Get a Product Variant

Retrieves a Product Variant by id

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.ProductVariantApi;


ProductVariantApi apiInstance = new ProductVariantApi();
String variantId = "variantId_example"; // String | The id of the Product Variant.
String cartId = "cartId_example"; // String | The id of the Cart to set prices based on.
String salesChannelId = "salesChannelId_example"; // String | A sales channel id for result configuration.
String regionId = "regionId_example"; // String | The id of the Region to set prices based on.
String currencyCode = "currencyCode_example"; // String | The 3 character ISO currency code to set prices based on.
try {
    StoreVariantsRes result = apiInstance.getVariantsVariant(variantId, cartId, salesChannelId, regionId, currencyCode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductVariantApi#getVariantsVariant");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **variantId** | **String**| The id of the Product Variant. |
 **cartId** | **String**| The id of the Cart to set prices based on. | [optional]
 **salesChannelId** | **String**| A sales channel id for result configuration. | [optional]
 **regionId** | **String**| The id of the Region to set prices based on. | [optional]
 **currencyCode** | **String**| The 3 character ISO currency code to set prices based on. | [optional]

### Return type

[**StoreVariantsRes**](StoreVariantsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

