# StorePostCartsCartReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**regionId** | **String** | The id of the Region to create the Cart in. |  [optional]
**countryCode** | **String** | The 2 character ISO country code to create the Cart in. |  [optional]
**email** | **String** | An email to be used on the Cart. |  [optional]
**salesChannelId** | **String** | The ID of the Sales channel to update the Cart with. |  [optional]
**billingAddress** | **AnyOfStorePostCartsCartReqBillingAddress** | The Address to be used for billing purposes. |  [optional]
**shippingAddress** | **AnyOfStorePostCartsCartReqShippingAddress** | The Address to be used for shipping. |  [optional]
**giftCards** | [**List&lt;StorePostCartsCartReqGiftCards&gt;**](StorePostCartsCartReqGiftCards.md) | An array of Gift Card codes to add to the Cart. |  [optional]
**discounts** | [**List&lt;StorePostCartsCartReqDiscounts&gt;**](StorePostCartsCartReqDiscounts.md) | An array of Discount codes to add to the Cart. |  [optional]
**customerId** | **String** | The ID of the Customer to associate the Cart with. |  [optional]
**context** | **Object** | An optional object to provide context to the Cart. |  [optional]
