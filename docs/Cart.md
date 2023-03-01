# Cart

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The cart&#x27;s ID | 
**email** | **String** | The email associated with the cart | 
**billingAddressId** | **String** | The billing address&#x27;s ID | 
**billingAddress** | [**Address**](Address.md) |  |  [optional]
**shippingAddressId** | **String** | The shipping address&#x27;s ID | 
**shippingAddress** | [**Address**](Address.md) |  |  [optional]
**items** | [**List&lt;LineItem&gt;**](LineItem.md) | Available if the relation &#x60;items&#x60; is expanded. |  [optional]
**regionId** | **String** | The region&#x27;s ID | 
**region** | [**Region**](Region.md) |  |  [optional]
**discounts** | [**List&lt;Discount&gt;**](Discount.md) | Available if the relation &#x60;discounts&#x60; is expanded. |  [optional]
**giftCards** | [**List&lt;GiftCard&gt;**](GiftCard.md) | Available if the relation &#x60;gift_cards&#x60; is expanded. |  [optional]
**customerId** | **String** | The customer&#x27;s ID | 
**customer** | **Object** | A customer object. Available if the relation &#x60;customer&#x60; is expanded. |  [optional]
**paymentSession** | **Object** | The selected payment session in the cart. | 
**paymentSessions** | **List&lt;Object&gt;** | The payment sessions created on the cart. |  [optional]
**paymentId** | **String** | The payment&#x27;s ID if available | 
**payment** | **Object** | Available if the relation &#x60;payment&#x60; is expanded. |  [optional]
**shippingMethods** | [**List&lt;ShippingMethod&gt;**](ShippingMethod.md) | The shipping methods added to the cart. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | The cart&#x27;s type. | 
**completedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the cart was completed. | 
**paymentAuthorizedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the payment was authorized. | 
**idempotencyKey** | **String** | Randomly generated key used to continue the completion of a cart in case of failure. | 
**context** | **Object** | The context of the cart which can include info like IP or user agent. | 
**salesChannelId** | **String** | The sales channel ID the cart is associated with. |  [optional]
**salesChannel** | [**SalesChannel**](SalesChannel.md) |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
**shippingTotal** | **Integer** | The total of shipping |  [optional]
**discountTotal** | **Integer** | The total of discount |  [optional]
**itemTaxTotal** | **Integer** | The total of items with taxes |  [optional]
**shippingTaxTotal** | **Integer** | The total of shipping with taxes |  [optional]
**taxTotal** | **Integer** | The total of tax |  [optional]
**refundedTotal** | **Integer** | The total amount refunded if the order associated with this cart is returned. |  [optional]
**total** | **Integer** | The total amount of the cart |  [optional]
**subtotal** | **Integer** | The subtotal of the cart |  [optional]
**refundableAmount** | **Integer** | The amount that can be refunded |  [optional]
**giftCardTotal** | **Integer** | The total of gift cards |  [optional]
**giftCardTaxTotal** | **Integer** | The total of gift cards with taxes |  [optional]

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
DEFAULT | &quot;default&quot;
SWAP | &quot;swap&quot;
DRAFT_ORDER | &quot;draft_order&quot;
PAYMENT_LINK | &quot;payment_link&quot;
CLAIM | &quot;claim&quot;
