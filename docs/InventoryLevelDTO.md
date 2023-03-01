# InventoryLevelDTO

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**locationId** | **String** | the item location ID | 
**stockedQuantity** | [**BigDecimal**](BigDecimal.md) | the total stock quantity of an inventory item at the given location ID | 
**reservedQuantity** | [**BigDecimal**](BigDecimal.md) | the reserved stock quantity of an inventory item at the given location ID | 
**incomingQuantity** | [**BigDecimal**](BigDecimal.md) | the incoming stock quantity of an inventory item at the given location ID | 
**metadata** | **Object** | An optional key-value map with additional details |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. |  [optional]
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. |  [optional]
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. |  [optional]
