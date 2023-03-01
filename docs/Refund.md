# Refund

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The refund&#x27;s ID | 
**orderId** | **String** | The id of the Order that the Refund is related to. | 
**order** | **Object** | An order object. Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**paymentId** | **String** | The payment&#x27;s ID if available | 
**payment** | **Object** | Available if the relation &#x60;payment&#x60; is expanded. |  [optional]
**amount** | **Integer** | The amount that has be refunded to the Customer. | 
**note** | **String** | An optional note explaining why the amount was refunded. | 
**reason** | [**ReasonEnum**](#ReasonEnum) | The reason given for the Refund, will automatically be set when processed as part of a Swap, Claim or Return. | 
**idempotencyKey** | **String** | Randomly generated key used to continue the completion of the refund in case of failure. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="ReasonEnum"></a>
## Enum: ReasonEnum
Name | Value
---- | -----
DISCOUNT | &quot;discount&quot;
RETURN | &quot;return&quot;
SWAP | &quot;swap&quot;
CLAIM | &quot;claim&quot;
OTHER | &quot;other&quot;
