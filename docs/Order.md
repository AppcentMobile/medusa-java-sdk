# Order

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The order&#x27;s ID | 
**status** | [**StatusEnum**](#StatusEnum) | The order&#x27;s status | 
**fulfillmentStatus** | [**FulfillmentStatusEnum**](#FulfillmentStatusEnum) | The order&#x27;s fulfillment status | 
**paymentStatus** | [**PaymentStatusEnum**](#PaymentStatusEnum) | The order&#x27;s payment status | 
**displayId** | **Integer** | The order&#x27;s display ID | 
**cartId** | **String** | The ID of the cart associated with the order | 
**cart** | **Object** | A cart object. Available if the relation &#x60;cart&#x60; is expanded. |  [optional]
**customerId** | **String** | The ID of the customer associated with the order | 
**customer** | **Object** | A customer object. Available if the relation &#x60;customer&#x60; is expanded. |  [optional]
**email** | **String** | The email associated with the order | 
**billingAddressId** | **String** | The ID of the billing address associated with the order | 
**billingAddress** | [**Address**](Address.md) |  |  [optional]
**shippingAddressId** | **String** | The ID of the shipping address associated with the order | 
**shippingAddress** | [**Address**](Address.md) |  |  [optional]
**regionId** | **String** | The region&#x27;s ID | 
**region** | [**Region**](Region.md) |  |  [optional]
**currencyCode** | **String** | The 3 character currency code that is used in the order | 
**currency** | [**Currency**](Currency.md) |  |  [optional]
**taxRate** | [**BigDecimal**](BigDecimal.md) | The order&#x27;s tax rate | 
**discounts** | [**List&lt;Discount&gt;**](Discount.md) | The discounts used in the order. Available if the relation &#x60;discounts&#x60; is expanded. |  [optional]
**giftCards** | [**List&lt;GiftCard&gt;**](GiftCard.md) | The gift cards used in the order. Available if the relation &#x60;gift_cards&#x60; is expanded. |  [optional]
**shippingMethods** | [**List&lt;ShippingMethod&gt;**](ShippingMethod.md) | The shipping methods used in the order. Available if the relation &#x60;shipping_methods&#x60; is expanded. |  [optional]
**payments** | **List&lt;Object&gt;** | The payments used in the order. Available if the relation &#x60;payments&#x60; is expanded. |  [optional]
**fulfillments** | **List&lt;Object&gt;** | The fulfillments used in the order. Available if the relation &#x60;fulfillments&#x60; is expanded. |  [optional]
**returns** | **List&lt;Object&gt;** | The returns associated with the order. Available if the relation &#x60;returns&#x60; is expanded. |  [optional]
**claims** | **List&lt;Object&gt;** | The claims associated with the order. Available if the relation &#x60;claims&#x60; is expanded. |  [optional]
**refunds** | **List&lt;Object&gt;** | The refunds associated with the order. Available if the relation &#x60;refunds&#x60; is expanded. |  [optional]
**swaps** | **List&lt;Object&gt;** | The swaps associated with the order. Available if the relation &#x60;swaps&#x60; is expanded. |  [optional]
**draftOrderId** | **String** | The ID of the draft order this order is associated with. | 
**draftOrder** | **Object** | A draft order object. Available if the relation &#x60;draft_order&#x60; is expanded. |  [optional]
**items** | [**List&lt;LineItem&gt;**](LineItem.md) | The line items that belong to the order. Available if the relation &#x60;items&#x60; is expanded. |  [optional]
**edits** | **List&lt;Object&gt;** | Order edits done on the order. Available if the relation &#x60;edits&#x60; is expanded. |  [optional]
**giftCardTransactions** | [**List&lt;GiftCardTransaction&gt;**](GiftCardTransaction.md) | The gift card transactions used in the order. Available if the relation &#x60;gift_card_transactions&#x60; is expanded. |  [optional]
**canceledAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date the order was canceled on. | 
**noNotification** | **Boolean** | Flag for describing whether or not notifications related to this should be send. | 
**idempotencyKey** | **String** | Randomly generated key used to continue the processing of the order in case of failure. | 
**externalId** | **String** | The ID of an external order. | 
**salesChannelId** | **String** | The ID of the sales channel this order is associated with. |  [optional]
**salesChannel** | [**SalesChannel**](SalesChannel.md) |  |  [optional]
**shippingTotal** | **Integer** | The total of shipping |  [optional]
**discountTotal** | **Integer** | The total of discount |  [optional]
**taxTotal** | **Integer** | The total of tax |  [optional]
**refundedTotal** | **Integer** | The total amount refunded if the order is returned. |  [optional]
**total** | **Integer** | The total amount of the order |  [optional]
**subtotal** | **Integer** | The subtotal of the order |  [optional]
**paidTotal** | **Integer** | The total amount paid |  [optional]
**refundableAmount** | **Integer** | The amount that can be refunded |  [optional]
**giftCardTotal** | **Integer** | The total of gift cards |  [optional]
**giftCardTaxTotal** | **Integer** | The total of gift cards with taxes |  [optional]
**returnableItems** | [**List&lt;LineItem&gt;**](LineItem.md) | The items that are returnable as part of the order, order swaps or order claims |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
PENDING | &quot;pending&quot;
COMPLETED | &quot;completed&quot;
ARCHIVED | &quot;archived&quot;
CANCELED | &quot;canceled&quot;
REQUIRES_ACTION | &quot;requires_action&quot;

<a name="FulfillmentStatusEnum"></a>
## Enum: FulfillmentStatusEnum
Name | Value
---- | -----
NOT_FULFILLED | &quot;not_fulfilled&quot;
PARTIALLY_FULFILLED | &quot;partially_fulfilled&quot;
FULFILLED | &quot;fulfilled&quot;
PARTIALLY_SHIPPED | &quot;partially_shipped&quot;
SHIPPED | &quot;shipped&quot;
PARTIALLY_RETURNED | &quot;partially_returned&quot;
RETURNED | &quot;returned&quot;
CANCELED | &quot;canceled&quot;
REQUIRES_ACTION | &quot;requires_action&quot;

<a name="PaymentStatusEnum"></a>
## Enum: PaymentStatusEnum
Name | Value
---- | -----
NOT_PAID | &quot;not_paid&quot;
AWAITING | &quot;awaiting&quot;
CAPTURED | &quot;captured&quot;
PARTIALLY_REFUNDED | &quot;partially_refunded&quot;
REFUNDED | &quot;refunded&quot;
CANCELED | &quot;canceled&quot;
REQUIRES_ACTION | &quot;requires_action&quot;
