# ClaimOrder

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The claim&#x27;s ID | 
**type** | [**TypeEnum**](#TypeEnum) | The claim&#x27;s type | 
**paymentStatus** | [**PaymentStatusEnum**](#PaymentStatusEnum) | The status of the claim&#x27;s payment | 
**fulfillmentStatus** | [**FulfillmentStatusEnum**](#FulfillmentStatusEnum) | The claim&#x27;s fulfillment status | 
**claimItems** | [**List&lt;ClaimItem&gt;**](ClaimItem.md) | The items that have been claimed |  [optional]
**additionalItems** | [**List&lt;LineItem&gt;**](LineItem.md) | Refers to the new items to be shipped when the claim order has the type &#x60;replace&#x60; |  [optional]
**orderId** | **String** | The ID of the order that the claim comes from. | 
**order** | **Object** | An order object. Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**returnOrder** | **Object** | A return object. Holds information about the return if the claim is to be returned. Available if the relation &#x27;return_order&#x27; is expanded |  [optional]
**shippingAddressId** | **String** | The ID of the address that the new items should be shipped to | 
**shippingAddress** | [**Address**](Address.md) |  |  [optional]
**shippingMethods** | [**List&lt;ShippingMethod&gt;**](ShippingMethod.md) | The shipping methods that the claim order will be shipped with. |  [optional]
**fulfillments** | **List&lt;Object&gt;** | The fulfillments of the new items to be shipped |  [optional]
**refundAmount** | **Integer** | The amount that will be refunded in conjunction with the claim | 
**canceledAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the claim was canceled. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
**noNotification** | **Boolean** | Flag for describing whether or not notifications related to this should be send. | 
**idempotencyKey** | **String** | Randomly generated key used to continue the completion of the cart associated with the claim in case of failure. | 

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
REFUND | &quot;refund&quot;
REPLACE | &quot;replace&quot;

<a name="PaymentStatusEnum"></a>
## Enum: PaymentStatusEnum
Name | Value
---- | -----
NA | &quot;na&quot;
NOT_REFUNDED | &quot;not_refunded&quot;
REFUNDED | &quot;refunded&quot;

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
