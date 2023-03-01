# Swap

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The swap&#x27;s ID | 
**fulfillmentStatus** | [**FulfillmentStatusEnum**](#FulfillmentStatusEnum) | The status of the Fulfillment of the Swap. | 
**paymentStatus** | [**PaymentStatusEnum**](#PaymentStatusEnum) | The status of the Payment of the Swap. The payment may either refer to the refund of an amount or the authorization of a new amount. | 
**orderId** | **String** | The ID of the Order where the Line Items to be returned where purchased. | 
**order** | **Object** | An order object. Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**additionalItems** | [**List&lt;LineItem&gt;**](LineItem.md) | The new Line Items to ship to the Customer. Available if the relation &#x60;additional_items&#x60; is expanded. |  [optional]
**returnOrder** | **Object** | A return order object. The Return that is issued for the return part of the Swap. Available if the relation &#x60;return_order&#x60; is expanded. |  [optional]
**fulfillments** | **List&lt;Object&gt;** | The Fulfillments used to send the new Line Items. Available if the relation &#x60;fulfillments&#x60; is expanded. |  [optional]
**payment** | **Object** | The Payment authorized when the Swap requires an additional amount to be charged from the Customer. Available if the relation &#x60;payment&#x60; is expanded. |  [optional]
**differenceDue** | **Integer** | The difference that is paid or refunded as a result of the Swap. May be negative when the amount paid for the returned items exceed the total of the new Products. | 
**shippingAddressId** | **String** | The Address to send the new Line Items to - in most cases this will be the same as the shipping address on the Order. | 
**shippingAddress** | [**Address**](Address.md) |  |  [optional]
**shippingMethods** | [**List&lt;ShippingMethod&gt;**](ShippingMethod.md) | The Shipping Methods used to fulfill the additional items purchased. Available if the relation &#x60;shipping_methods&#x60; is expanded. |  [optional]
**cartId** | **String** | The id of the Cart that the Customer will use to confirm the Swap. | 
**cart** | **Object** | A cart object. Available if the relation &#x60;cart&#x60; is expanded. |  [optional]
**confirmedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the Swap was confirmed by the Customer. | 
**canceledAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the Swap was canceled. | 
**noNotification** | **Boolean** | If set to true, no notification will be sent related to this swap | 
**allowBackorder** | **Boolean** | If true, swaps can be completed with items out of stock | 
**idempotencyKey** | **String** | Randomly generated key used to continue the completion of the swap in case of failure. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="FulfillmentStatusEnum"></a>
## Enum: FulfillmentStatusEnum
Name | Value
---- | -----
NOT_FULFILLED | &quot;not_fulfilled&quot;
FULFILLED | &quot;fulfilled&quot;
SHIPPED | &quot;shipped&quot;
PARTIALLY_SHIPPED | &quot;partially_shipped&quot;
CANCELED | &quot;canceled&quot;
REQUIRES_ACTION | &quot;requires_action&quot;

<a name="PaymentStatusEnum"></a>
## Enum: PaymentStatusEnum
Name | Value
---- | -----
NOT_PAID | &quot;not_paid&quot;
AWAITING | &quot;awaiting&quot;
CAPTURED | &quot;captured&quot;
CONFIRMED | &quot;confirmed&quot;
CANCELED | &quot;canceled&quot;
DIFFERENCE_REFUNDED | &quot;difference_refunded&quot;
PARTIALLY_REFUNDED | &quot;partially_refunded&quot;
REFUNDED | &quot;refunded&quot;
REQUIRES_ACTION | &quot;requires_action&quot;
