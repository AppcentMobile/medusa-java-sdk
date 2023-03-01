# InventoryItemDTO

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**sku** | **String** | The Stock Keeping Unit (SKU) code of the Inventory Item. | 
**hsCode** | **String** | The Harmonized System code of the Inventory Item. May be used by Fulfillment Providers to pass customs information to shipping carriers. |  [optional]
**originCountry** | **String** | The country in which the Inventory Item was produced. May be used by Fulfillment Providers to pass customs information to shipping carriers. |  [optional]
**midCode** | **String** | The Manufacturers Identification code that identifies the manufacturer of the Inventory Item. May be used by Fulfillment Providers to pass customs information to shipping carriers. |  [optional]
**material** | **String** | The material and composition that the Inventory Item is made of, May be used by Fulfillment Providers to pass customs information to shipping carriers. |  [optional]
**weight** | [**BigDecimal**](BigDecimal.md) | The weight of the Inventory Item. May be used in shipping rate calculations. |  [optional]
**height** | [**BigDecimal**](BigDecimal.md) | The height of the Inventory Item. May be used in shipping rate calculations. |  [optional]
**width** | [**BigDecimal**](BigDecimal.md) | The width of the Inventory Item. May be used in shipping rate calculations. |  [optional]
**length** | [**BigDecimal**](BigDecimal.md) | The length of the Inventory Item. May be used in shipping rate calculations. |  [optional]
**requiresShipping** | **Boolean** | Whether the item requires shipping. |  [optional]
**metadata** | **Object** | An optional key-value map with additional details |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. |  [optional]
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. |  [optional]
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. |  [optional]
