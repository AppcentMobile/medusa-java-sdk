# OrderEditApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getOrderEditsOrderEdit**](OrderEditApi.md#getOrderEditsOrderEdit) | **GET** /order-edits/{id} | Retrieve an OrderEdit
[**postOrderEditsOrderEditComplete**](OrderEditApi.md#postOrderEditsOrderEditComplete) | **POST** /order-edits/{id}/complete | Completes an OrderEdit
[**postOrderEditsOrderEditDecline**](OrderEditApi.md#postOrderEditsOrderEditDecline) | **POST** /order-edits/{id}/decline | Decline an OrderEdit

<a name="getOrderEditsOrderEdit"></a>
# **getOrderEditsOrderEdit**
> StoreOrderEditsRes getOrderEditsOrderEdit(id)

Retrieve an OrderEdit

Retrieves a OrderEdit.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.OrderEditApi;


OrderEditApi apiInstance = new OrderEditApi();
String id = "id_example"; // String | The ID of the OrderEdit.
try {
    StoreOrderEditsRes result = apiInstance.getOrderEditsOrderEdit(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderEditApi#getOrderEditsOrderEdit");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the OrderEdit. |

### Return type

[**StoreOrderEditsRes**](StoreOrderEditsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="postOrderEditsOrderEditComplete"></a>
# **postOrderEditsOrderEditComplete**
> StoreOrderEditsRes postOrderEditsOrderEditComplete(id)

Completes an OrderEdit

Completes an OrderEdit.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.OrderEditApi;


OrderEditApi apiInstance = new OrderEditApi();
String id = "id_example"; // String | The ID of the Order Edit.
try {
    StoreOrderEditsRes result = apiInstance.postOrderEditsOrderEditComplete(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderEditApi#postOrderEditsOrderEditComplete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the Order Edit. |

### Return type

[**StoreOrderEditsRes**](StoreOrderEditsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="postOrderEditsOrderEditDecline"></a>
# **postOrderEditsOrderEditDecline**
> StoreOrderEditsRes postOrderEditsOrderEditDecline(id, body)

Decline an OrderEdit

Declines an OrderEdit.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.OrderEditApi;


OrderEditApi apiInstance = new OrderEditApi();
String id = "id_example"; // String | The ID of the OrderEdit.
StorePostOrderEditsOrderEditDecline body = new StorePostOrderEditsOrderEditDecline(); // StorePostOrderEditsOrderEditDecline | 
try {
    StoreOrderEditsRes result = apiInstance.postOrderEditsOrderEditDecline(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderEditApi#postOrderEditsOrderEditDecline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the OrderEdit. |
 **body** | [**StorePostOrderEditsOrderEditDecline**](StorePostOrderEditsOrderEditDecline.md)|  | [optional]

### Return type

[**StoreOrderEditsRes**](StoreOrderEditsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

