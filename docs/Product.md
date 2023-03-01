# Product

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The product&#x27;s ID | 
**title** | **String** | A title that can be displayed for easy identification of the Product. | 
**subtitle** | **String** | An optional subtitle that can be used to further specify the Product. | 
**description** | **String** | A short description of the Product. | 
**handle** | **String** | A unique identifier for the Product (e.g. for slug structure). | 
**isGiftcard** | **Boolean** | Whether the Product represents a Gift Card. Products that represent Gift Cards will automatically generate a redeemable Gift Card code once they are purchased. | 
**status** | [**StatusEnum**](#StatusEnum) | The status of the product | 
**images** | [**List&lt;Image&gt;**](Image.md) | Images of the Product. Available if the relation &#x60;images&#x60; is expanded. |  [optional]
**thumbnail** | **String** | A URL to an image file that can be used to identify the Product. | 
**options** | [**List&lt;ProductOption&gt;**](ProductOption.md) | The Product Options that are defined for the Product. Product Variants of the Product will have a unique combination of Product Option Values. Available if the relation &#x60;options&#x60; is expanded. |  [optional]
**variants** | [**List&lt;ProductVariant&gt;**](ProductVariant.md) | The Product Variants that belong to the Product. Each will have a unique combination of Product Option Values. Available if the relation &#x60;variants&#x60; is expanded. |  [optional]
**categories** | [**List&lt;ProductCategory&gt;**](ProductCategory.md) | The product&#x27;s associated categories. Available if the relation &#x60;categories&#x60; are expanded. |  [optional]
**profileId** | **String** | The ID of the Shipping Profile that the Product belongs to. Shipping Profiles have a set of defined Shipping Options that can be used to Fulfill a given set of Products. | 
**profile** | [**ShippingProfile**](ShippingProfile.md) |  |  [optional]
**weight** | [**BigDecimal**](BigDecimal.md) | The weight of the Product Variant. May be used in shipping rate calculations. | 
**length** | [**BigDecimal**](BigDecimal.md) | The length of the Product Variant. May be used in shipping rate calculations. | 
**height** | [**BigDecimal**](BigDecimal.md) | The height of the Product Variant. May be used in shipping rate calculations. | 
**width** | [**BigDecimal**](BigDecimal.md) | The width of the Product Variant. May be used in shipping rate calculations. | 
**hsCode** | **String** | The Harmonized System code of the Product Variant. May be used by Fulfillment Providers to pass customs information to shipping carriers. | 
**originCountry** | **String** | The country in which the Product Variant was produced. May be used by Fulfillment Providers to pass customs information to shipping carriers. | 
**midCode** | **String** | The Manufacturers Identification code that identifies the manufacturer of the Product Variant. May be used by Fulfillment Providers to pass customs information to shipping carriers. | 
**material** | **String** | The material and composition that the Product Variant is made of, May be used by Fulfillment Providers to pass customs information to shipping carriers. | 
**collectionId** | **String** | The Product Collection that the Product belongs to | 
**collection** | [**ProductCollection**](ProductCollection.md) |  |  [optional]
**typeId** | **String** | The Product type that the Product belongs to | 
**type** | [**ProductType**](ProductType.md) |  |  [optional]
**tags** | [**List&lt;ProductTag&gt;**](ProductTag.md) | The Product Tags assigned to the Product. Available if the relation &#x60;tags&#x60; is expanded. |  [optional]
**discountable** | **Boolean** | Whether the Product can be discounted. Discounts will not apply to Line Items of this Product when this flag is set to &#x60;false&#x60;. | 
**externalId** | **String** | The external ID of the product | 
**salesChannels** | [**List&lt;SalesChannel&gt;**](SalesChannel.md) | The sales channels the product is associated with. Available if the relation &#x60;sales_channels&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
DRAFT | &quot;draft&quot;
PROPOSED | &quot;proposed&quot;
PUBLISHED | &quot;published&quot;
REJECTED | &quot;rejected&quot;
