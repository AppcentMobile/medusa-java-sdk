# DraftOrder

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The draft order&#x27;s ID | 
**status** | [**StatusEnum**](#StatusEnum) | The status of the draft order | 
**displayId** | **String** | The draft order&#x27;s display ID | 
**cartId** | **String** | The ID of the cart associated with the draft order. | 
**cart** | **Object** | A cart object. Available if the relation &#x60;cart&#x60; is expanded. |  [optional]
**orderId** | **String** | The ID of the order associated with the draft order. | 
**order** | **Object** | An order object. Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**canceledAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date the draft order was canceled at. | 
**completedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date the draft order was completed at. | 
**noNotificationOrder** | **Boolean** | Whether to send the customer notifications regarding order updates. | 
**idempotencyKey** | **String** | Randomly generated key used to continue the completion of the cart associated with the draft order in case of failure. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
OPEN | &quot;open&quot;
COMPLETED | &quot;completed&quot;
