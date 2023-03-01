# ProductVariantInventoryItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The product variant inventory item&#x27;s ID | 
**inventoryItemId** | **String** | The id of the inventory item | 
**variantId** | **String** | The id of the variant. | 
**variant** | **Object** | A ProductVariant object. Available if the relation &#x60;variant&#x60; is expanded. |  [optional]
**requiredQuantity** | **Integer** | The quantity of an inventory item required for one quantity of the variant. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
