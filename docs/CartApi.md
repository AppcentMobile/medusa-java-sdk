# CartApi

All URIs are relative to *https://api.medusa-commerce.com/store*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteCartsCartDiscountsDiscount**](CartApi.md#deleteCartsCartDiscountsDiscount) | **DELETE** /carts/{id}/discounts/{code} | Remove Discount
[**deleteCartsCartLineItemsItem**](CartApi.md#deleteCartsCartLineItemsItem) | **DELETE** /carts/{id}/line-items/{line_id} | Delete a Line Item
[**deleteCartsCartPaymentSessionsSession**](CartApi.md#deleteCartsCartPaymentSessionsSession) | **DELETE** /carts/{id}/payment-sessions/{provider_id} | Delete a Payment Session
[**getCartsCart**](CartApi.md#getCartsCart) | **GET** /carts/{id} | Get a Cart
[**postCart**](CartApi.md#postCart) | **POST** /carts | Create a Cart
[**postCartsCart**](CartApi.md#postCartsCart) | **POST** /carts/{id} | Update a Cart
[**postCartsCartComplete**](CartApi.md#postCartsCartComplete) | **POST** /carts/{id}/complete | Complete a Cart
[**postCartsCartLineItems**](CartApi.md#postCartsCartLineItems) | **POST** /carts/{id}/line-items | Add a Line Item
[**postCartsCartLineItemsItem**](CartApi.md#postCartsCartLineItemsItem) | **POST** /carts/{id}/line-items/{line_id} | Update a Line Item
[**postCartsCartPaymentSession**](CartApi.md#postCartsCartPaymentSession) | **POST** /carts/{id}/payment-session | Select a Payment Session
[**postCartsCartPaymentSessionUpdate**](CartApi.md#postCartsCartPaymentSessionUpdate) | **POST** /carts/{id}/payment-sessions/{provider_id} | Update a Payment Session
[**postCartsCartPaymentSessions**](CartApi.md#postCartsCartPaymentSessions) | **POST** /carts/{id}/payment-sessions | Create Payment Sessions
[**postCartsCartPaymentSessionsSession**](CartApi.md#postCartsCartPaymentSessionsSession) | **POST** /carts/{id}/payment-sessions/{provider_id}/refresh | Refresh a Payment Session
[**postCartsCartShippingMethod**](CartApi.md#postCartsCartShippingMethod) | **POST** /carts/{id}/shipping-methods | Add a Shipping Method
[**postCartsCartTaxes**](CartApi.md#postCartsCartTaxes) | **POST** /carts/{id}/taxes | Calculate Cart Taxes

<a name="deleteCartsCartDiscountsDiscount"></a>
# **deleteCartsCartDiscountsDiscount**
> StoreCartsRes deleteCartsCartDiscountsDiscount(id, code)

Remove Discount

Removes a Discount from a Cart.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The id of the Cart.
String code = "code_example"; // String | The unique Discount code.
try {
    StoreCartsRes result = apiInstance.deleteCartsCartDiscountsDiscount(id, code);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#deleteCartsCartDiscountsDiscount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Cart. |
 **code** | **String**| The unique Discount code. |

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteCartsCartLineItemsItem"></a>
# **deleteCartsCartLineItemsItem**
> StoreCartsRes deleteCartsCartLineItemsItem(id, lineId)

Delete a Line Item

Removes a Line Item from a Cart.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The id of the Cart.
String lineId = "lineId_example"; // String | The id of the Line Item.
try {
    StoreCartsRes result = apiInstance.deleteCartsCartLineItemsItem(id, lineId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#deleteCartsCartLineItemsItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Cart. |
 **lineId** | **String**| The id of the Line Item. |

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteCartsCartPaymentSessionsSession"></a>
# **deleteCartsCartPaymentSessionsSession**
> StoreCartsRes deleteCartsCartPaymentSessionsSession(id, providerId)

Delete a Payment Session

Deletes a Payment Session on a Cart. May be useful if a payment has failed.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The id of the Cart.
String providerId = "providerId_example"; // String | The id of the Payment Provider used to create the Payment Session to be deleted.
try {
    StoreCartsRes result = apiInstance.deleteCartsCartPaymentSessionsSession(id, providerId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#deleteCartsCartPaymentSessionsSession");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Cart. |
 **providerId** | **String**| The id of the Payment Provider used to create the Payment Session to be deleted. |

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCartsCart"></a>
# **getCartsCart**
> StoreCartsRes getCartsCart(id)

Get a Cart

Retrieves a Cart.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The id of the Cart.
try {
    StoreCartsRes result = apiInstance.getCartsCart(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#getCartsCart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Cart. |

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postCart"></a>
# **postCart**
> StoreCartsRes postCart(body)

Create a Cart

Creates a Cart within the given region and with the initial items. If no &#x60;region_id&#x60; is provided the cart will be associated with the first Region available. If no items are provided the cart will be empty after creation. If a user is logged in the cart&#x27;s customer id and email will be set.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
StorePostCartReq body = new StorePostCartReq(); // StorePostCartReq | 
try {
    StoreCartsRes result = apiInstance.postCart(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#postCart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StorePostCartReq**](StorePostCartReq.md)|  | [optional]

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCartsCart"></a>
# **postCartsCart**
> StoreCartsRes postCartsCart(id, body)

Update a Cart

Updates a Cart.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The id of the Cart.
StorePostCartsCartReq body = new StorePostCartsCartReq(); // StorePostCartsCartReq | 
try {
    StoreCartsRes result = apiInstance.postCartsCart(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#postCartsCart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Cart. |
 **body** | [**StorePostCartsCartReq**](StorePostCartsCartReq.md)|  | [optional]

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCartsCartComplete"></a>
# **postCartsCartComplete**
> StoreCompleteCartRes postCartsCartComplete(id)

Complete a Cart

Completes a cart. The following steps will be performed. Payment authorization is attempted and if more work is required, we simply return the cart for further updates. If payment is authorized and order is not yet created, we make sure to do so. The completion of a cart can be performed idempotently with a provided header &#x60;Idempotency-Key&#x60;. If not provided, we will generate one for the request.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The Cart id.
try {
    StoreCompleteCartRes result = apiInstance.postCartsCartComplete(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#postCartsCartComplete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The Cart id. |

### Return type

[**StoreCompleteCartRes**](StoreCompleteCartRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postCartsCartLineItems"></a>
# **postCartsCartLineItems**
> StoreCartsRes postCartsCartLineItems(id, body)

Add a Line Item

Generates a Line Item with a given Product Variant and adds it to the Cart

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The id of the Cart to add the Line Item to.
StorePostCartsCartLineItemsReq body = new StorePostCartsCartLineItemsReq(); // StorePostCartsCartLineItemsReq | 
try {
    StoreCartsRes result = apiInstance.postCartsCartLineItems(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#postCartsCartLineItems");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Cart to add the Line Item to. |
 **body** | [**StorePostCartsCartLineItemsReq**](StorePostCartsCartLineItemsReq.md)|  | [optional]

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCartsCartLineItemsItem"></a>
# **postCartsCartLineItemsItem**
> StoreCartsRes postCartsCartLineItemsItem(id, lineId, body)

Update a Line Item

Updates a Line Item if the desired quantity can be fulfilled.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The id of the Cart.
String lineId = "lineId_example"; // String | The id of the Line Item.
StorePostCartsCartLineItemsItemReq body = new StorePostCartsCartLineItemsItemReq(); // StorePostCartsCartLineItemsItemReq | 
try {
    StoreCartsRes result = apiInstance.postCartsCartLineItemsItem(id, lineId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#postCartsCartLineItemsItem");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Cart. |
 **lineId** | **String**| The id of the Line Item. |
 **body** | [**StorePostCartsCartLineItemsItemReq**](StorePostCartsCartLineItemsItemReq.md)|  | [optional]

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCartsCartPaymentSession"></a>
# **postCartsCartPaymentSession**
> StoreCartsRes postCartsCartPaymentSession(id, body)

Select a Payment Session

Selects a Payment Session as the session intended to be used towards the completion of the Cart.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The ID of the Cart.
StorePostCartsCartPaymentSessionReq body = new StorePostCartsCartPaymentSessionReq(); // StorePostCartsCartPaymentSessionReq | 
try {
    StoreCartsRes result = apiInstance.postCartsCartPaymentSession(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#postCartsCartPaymentSession");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the Cart. |
 **body** | [**StorePostCartsCartPaymentSessionReq**](StorePostCartsCartPaymentSessionReq.md)|  | [optional]

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCartsCartPaymentSessionUpdate"></a>
# **postCartsCartPaymentSessionUpdate**
> StoreCartsRes postCartsCartPaymentSessionUpdate(id, providerId, body)

Update a Payment Session

Updates a Payment Session with additional data.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The id of the Cart.
String providerId = "providerId_example"; // String | The id of the payment provider.
StorePostCartsCartPaymentSessionUpdateReq body = new StorePostCartsCartPaymentSessionUpdateReq(); // StorePostCartsCartPaymentSessionUpdateReq | 
try {
    StoreCartsRes result = apiInstance.postCartsCartPaymentSessionUpdate(id, providerId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#postCartsCartPaymentSessionUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Cart. |
 **providerId** | **String**| The id of the payment provider. |
 **body** | [**StorePostCartsCartPaymentSessionUpdateReq**](StorePostCartsCartPaymentSessionUpdateReq.md)|  | [optional]

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCartsCartPaymentSessions"></a>
# **postCartsCartPaymentSessions**
> StoreCartsRes postCartsCartPaymentSessions(id)

Create Payment Sessions

Creates Payment Sessions for each of the available Payment Providers in the Cart&#x27;s Region.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The id of the Cart.
try {
    StoreCartsRes result = apiInstance.postCartsCartPaymentSessions(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#postCartsCartPaymentSessions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Cart. |

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postCartsCartPaymentSessionsSession"></a>
# **postCartsCartPaymentSessionsSession**
> StoreCartsRes postCartsCartPaymentSessionsSession(id, providerId)

Refresh a Payment Session

Refreshes a Payment Session to ensure that it is in sync with the Cart - this is usually not necessary.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The id of the Cart.
String providerId = "providerId_example"; // String | The id of the Payment Provider that created the Payment Session to be refreshed.
try {
    StoreCartsRes result = apiInstance.postCartsCartPaymentSessionsSession(id, providerId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#postCartsCartPaymentSessionsSession");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The id of the Cart. |
 **providerId** | **String**| The id of the Payment Provider that created the Payment Session to be refreshed. |

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postCartsCartShippingMethod"></a>
# **postCartsCartShippingMethod**
> StoreCartsRes postCartsCartShippingMethod(id, body)

Add a Shipping Method

Adds a Shipping Method to the Cart.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The cart ID.
StorePostCartsCartShippingMethodReq body = new StorePostCartsCartShippingMethodReq(); // StorePostCartsCartShippingMethodReq | 
try {
    StoreCartsRes result = apiInstance.postCartsCartShippingMethod(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#postCartsCartShippingMethod");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The cart ID. |
 **body** | [**StorePostCartsCartShippingMethodReq**](StorePostCartsCartShippingMethodReq.md)|  | [optional]

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCartsCartTaxes"></a>
# **postCartsCartTaxes**
> StoreCartsRes postCartsCartTaxes(id)

Calculate Cart Taxes

Calculates taxes for a cart. Depending on the cart&#x27;s region this may involve making 3rd party API calls to a Tax Provider service.

### Example
```java
// Import classes:
//import mobi.appcent.medusa.store.ApiException;
//import api.mobi.appcent.medusa.store.CartApi;


CartApi apiInstance = new CartApi();
String id = "id_example"; // String | The Cart ID.
try {
    StoreCartsRes result = apiInstance.postCartsCartTaxes(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CartApi#postCartsCartTaxes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The Cart ID. |

### Return type

[**StoreCartsRes**](StoreCartsRes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

