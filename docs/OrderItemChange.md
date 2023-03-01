# OrderItemChange

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The order item change&#x27;s ID | 
**type** | [**TypeEnum**](#TypeEnum) | The order item change&#x27;s status | 
**orderEditId** | **String** | The ID of the order edit | 
**orderEdit** | **Object** | Available if the relation &#x60;order_edit&#x60; is expanded. |  [optional]
**originalLineItemId** | **String** | The ID of the original line item in the order | 
**originalLineItem** | [**LineItem**](LineItem.md) |  |  [optional]
**lineItemId** | **String** | The ID of the cloned line item. | 
**lineItem** | [**LineItem**](LineItem.md) |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
ADD | &quot;item_add&quot;
REMOVE | &quot;item_remove&quot;
UPDATE | &quot;item_update&quot;
