# MoneyAmount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The money amount&#x27;s ID | 
**currencyCode** | **String** | The 3 character currency code that the Money Amount is given in. | 
**currency** | [**Currency**](Currency.md) |  |  [optional]
**amount** | **Integer** | The amount in the smallest currecny unit (e.g. cents 100 cents to charge $1) that the Product Variant will cost. | 
**minQuantity** | **Integer** | The minimum quantity that the Money Amount applies to. If this value is not set, the Money Amount applies to all quantities. | 
**maxQuantity** | **Integer** | The maximum quantity that the Money Amount applies to. If this value is not set, the Money Amount applies to all quantities. | 
**priceListId** | **String** | The ID of the price list associated with the money amount | 
**priceList** | **Object** | Available if the relation &#x60;price_list&#x60; is expanded. |  [optional]
**variantId** | **String** | The id of the Product Variant contained in the Line Item. | 
**variant** | **Object** | The Product Variant contained in the Line Item. Available if the relation &#x60;variant&#x60; is expanded. |  [optional]
**regionId** | **String** | The region&#x27;s ID | 
**region** | **Object** | A region object. Available if the relation &#x60;region&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
