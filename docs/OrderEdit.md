# OrderEdit

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The order edit&#x27;s ID | 
**orderId** | **String** | The ID of the order that is edited | 
**order** | **Object** | Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**changes** | [**List&lt;OrderItemChange&gt;**](OrderItemChange.md) | Available if the relation &#x60;changes&#x60; is expanded. |  [optional]
**internalNote** | **String** | An optional note with additional details about the order edit. | 
**createdBy** | **String** | The unique identifier of the user or customer who created the order edit. | 
**requestedBy** | **String** | The unique identifier of the user or customer who requested the order edit. | 
**requestedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the edit was requested. | 
**confirmedBy** | **String** | The unique identifier of the user or customer who confirmed the order edit. | 
**confirmedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the edit was confirmed. | 
**declinedBy** | **String** | The unique identifier of the user or customer who declined the order edit. | 
**declinedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the edit was declined. | 
**declinedReason** | **String** | An optional note why  the order edit is declined. | 
**canceledBy** | **String** | The unique identifier of the user or customer who cancelled the order edit. | 
**canceledAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the edit was cancelled. | 
**subtotal** | **Integer** | The total of subtotal |  [optional]
**discountTotal** | **Integer** | The total of discount |  [optional]
**shippingTotal** | **Integer** | The total of the shipping amount |  [optional]
**giftCardTotal** | **Integer** | The total of the gift card amount |  [optional]
**giftCardTaxTotal** | **Integer** | The total of the gift card tax amount |  [optional]
**taxTotal** | **Integer** | The total of tax |  [optional]
**total** | **Integer** | The total amount of the edited order. |  [optional]
**differenceDue** | **Integer** | The difference between the total amount of the order and total amount of edited order. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the order edit. | 
**items** | [**List&lt;LineItem&gt;**](LineItem.md) | Available if the relation &#x60;items&#x60; is expanded. |  [optional]
**paymentCollectionId** | **String** | The ID of the payment collection | 
**paymentCollection** | [**PaymentCollection**](PaymentCollection.md) |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
CONFIRMED | &quot;confirmed&quot;
DECLINED | &quot;declined&quot;
REQUESTED | &quot;requested&quot;
CREATED | &quot;created&quot;
CANCELED | &quot;canceled&quot;
