# GiftCardApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getGiftCardsCode**](GiftCardApi.md#getGiftCardsCode) | **GET** /gift-cards/{code} | Get Gift Card by Code

<a name="getGiftCardsCode"></a>
# **getGiftCardsCode**
> StoreGiftCardsRes getGiftCardsCode(code)

Get Gift Card by Code

Retrieves a Gift Card by its associated unique code.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.GiftCardApi;


GiftCardApi apiInstance = new GiftCardApi();
String code = "code_example"; // String | The unique Gift Card code.
try {
    StoreGiftCardsRes result = apiInstance.getGiftCardsCode(code);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GiftCardApi#getGiftCardsCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **code** | **String**| The unique Gift Card code. |

### Return type

[**StoreGiftCardsRes**](StoreGiftCardsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

