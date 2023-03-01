# ProductVariant

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The product variant&#x27;s ID | 
**title** | **String** | A title that can be displayed for easy identification of the Product Variant. | 
**productId** | **String** | The ID of the Product that the Product Variant belongs to. | 
**product** | **Object** | A product object. Available if the relation &#x60;product&#x60; is expanded. |  [optional]
**prices** | [**List&lt;MoneyAmount&gt;**](MoneyAmount.md) | The Money Amounts defined for the Product Variant. Each Money Amount represents a price in a given currency or a price in a specific Region. Available if the relation &#x60;prices&#x60; is expanded. |  [optional]
**sku** | **String** | The unique stock keeping unit used to identify the Product Variant. This will usually be a unqiue identifer for the item that is to be shipped, and can be referenced across multiple systems. | 
**barcode** | **String** | A generic field for a GTIN number that can be used to identify the Product Variant. | 
**ean** | **String** | An EAN barcode number that can be used to identify the Product Variant. | 
**upc** | **String** | A UPC barcode number that can be used to identify the Product Variant. | 
**variantRank** | [**BigDecimal**](BigDecimal.md) | The ranking of this variant |  [optional]
**inventoryQuantity** | **Integer** | The current quantity of the item that is stocked. | 
**allowBackorder** | **Boolean** | Whether the Product Variant should be purchasable when &#x60;inventory_quantity&#x60; is 0. | 
**manageInventory** | **Boolean** | Whether Medusa should manage inventory for the Product Variant. | 
**hsCode** | **String** | The Harmonized System code of the Product Variant. May be used by Fulfillment Providers to pass customs information to shipping carriers. | 
**originCountry** | **String** | The country in which the Product Variant was produced. May be used by Fulfillment Providers to pass customs information to shipping carriers. | 
**midCode** | **String** | The Manufacturers Identification code that identifies the manufacturer of the Product Variant. May be used by Fulfillment Providers to pass customs information to shipping carriers. | 
**material** | **String** | The material and composition that the Product Variant is made of, May be used by Fulfillment Providers to pass customs information to shipping carriers. | 
**weight** | [**BigDecimal**](BigDecimal.md) | The weight of the Product Variant. May be used in shipping rate calculations. | 
**length** | [**BigDecimal**](BigDecimal.md) | The length of the Product Variant. May be used in shipping rate calculations. | 
**height** | [**BigDecimal**](BigDecimal.md) | The height of the Product Variant. May be used in shipping rate calculations. | 
**width** | [**BigDecimal**](BigDecimal.md) | The width of the Product Variant. May be used in shipping rate calculations. | 
**options** | [**List&lt;ProductOptionValue&gt;**](ProductOptionValue.md) | The Product Option Values specified for the Product Variant. Available if the relation &#x60;options&#x60; is expanded. |  [optional]
**inventoryItems** | [**List&lt;ProductVariantInventoryItem&gt;**](ProductVariantInventoryItem.md) | The Inventory Items related to the product variant. Available if the relation &#x60;inventory_items&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
