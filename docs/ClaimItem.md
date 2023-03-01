# ClaimItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The claim item&#x27;s ID | 
**images** | [**List&lt;ClaimImage&gt;**](ClaimImage.md) | Available if the relation &#x60;images&#x60; is expanded. |  [optional]
**claimOrderId** | **String** | The ID of the claim this item is associated with. | 
**claimOrder** | **Object** | A claim order object. Available if the relation &#x60;claim_order&#x60; is expanded. |  [optional]
**itemId** | **String** | The ID of the line item that the claim item refers to. | 
**item** | [**LineItem**](LineItem.md) |  |  [optional]
**variantId** | **String** | The ID of the product variant that is claimed. | 
**variant** | [**ProductVariant**](ProductVariant.md) |  |  [optional]
**reason** | [**ReasonEnum**](#ReasonEnum) | The reason for the claim | 
**note** | **String** | An optional note about the claim, for additional information | 
**quantity** | **Integer** | The quantity of the item that is being claimed; must be less than or equal to the amount purchased in the original order. | 
**tags** | [**List&lt;ClaimTag&gt;**](ClaimTag.md) | User defined tags for easy filtering and grouping. Available if the relation &#x27;tags&#x27; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="ReasonEnum"></a>
## Enum: ReasonEnum
Name | Value
---- | -----
MISSING_ITEM | &quot;missing_item&quot;
WRONG_ITEM | &quot;wrong_item&quot;
PRODUCTION_FAILURE | &quot;production_failure&quot;
OTHER | &quot;other&quot;
