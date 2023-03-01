# Store

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The store&#x27;s ID | 
**name** | **String** | The name of the Store - this may be displayed to the Customer. | 
**defaultCurrencyCode** | **String** | The 3 character currency code that is the default of the store. | 
**defaultCurrency** | [**Currency**](Currency.md) |  |  [optional]
**currencies** | [**List&lt;Currency&gt;**](Currency.md) | The currencies that are enabled for the Store. Available if the relation &#x60;currencies&#x60; is expanded. |  [optional]
**swapLinkTemplate** | **String** | A template to generate Swap links from. Use {{cart_id}} to include the Swap&#x27;s &#x60;cart_id&#x60; in the link. | 
**paymentLinkTemplate** | **String** | A template to generate Payment links from. Use {{cart_id}} to include the payment&#x27;s &#x60;cart_id&#x60; in the link. | 
**inviteLinkTemplate** | **String** | A template to generate Invite links from | 
**defaultLocationId** | **String** | The location ID the store is associated with. | 
**defaultSalesChannelId** | **String** | The sales channel ID the cart is associated with. |  [optional]
**defaultSalesChannel** | [**SalesChannel**](SalesChannel.md) |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**metadata** | **Object** | An optional key-value map with additional details | 
