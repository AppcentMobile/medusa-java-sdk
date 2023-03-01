# ModelReturn

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The return&#x27;s ID | 
**status** | [**StatusEnum**](#StatusEnum) | Status of the Return. | 
**items** | [**List&lt;ReturnItem&gt;**](ReturnItem.md) | The Return Items that will be shipped back to the warehouse. Available if the relation &#x60;items&#x60; is expanded. |  [optional]
**swapId** | **String** | The ID of the Swap that the Return is a part of. | 
**swap** | **Object** | A swap object. Available if the relation &#x60;swap&#x60; is expanded. |  [optional]
**claimOrderId** | **String** | The ID of the Claim that the Return is a part of. | 
**claimOrder** | **Object** | A claim order object. Available if the relation &#x60;claim_order&#x60; is expanded. |  [optional]
**orderId** | **String** | The ID of the Order that the Return is made from. | 
**order** | **Object** | An order object. Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**shippingMethod** | [**ShippingMethod**](ShippingMethod.md) |  |  [optional]
**shippingData** | **Object** | Data about the return shipment as provided by the Fulfilment Provider that handles the return shipment. | 
**locationId** | **String** | The id of the stock location the return will be added back. | 
**refundAmount** | **Integer** | The amount that should be refunded as a result of the return. | 
**noNotification** | **Boolean** | When set to true, no notification will be sent related to this return. | 
**idempotencyKey** | **String** | Randomly generated key used to continue the completion of the return in case of failure. | 
**receivedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the return was received. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
REQUESTED | &quot;requested&quot;
RECEIVED | &quot;received&quot;
REQUIRES_ACTION | &quot;requires_action&quot;
CANCELED | &quot;canceled&quot;
