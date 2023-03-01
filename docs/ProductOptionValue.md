# ProductOptionValue

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The product option value&#x27;s ID | 
**value** | **String** | The value that the Product Variant has defined for the specific Product Option (e.g. if the Product Option is \\\&quot;Size\\\&quot; this value could be &#x60;Small&#x60;, &#x60;Medium&#x60; or &#x60;Large&#x60;). | 
**optionId** | **String** | The ID of the Product Option that the Product Option Value is defined for. | 
**option** | **Object** | Available if the relation &#x60;option&#x60; is expanded. |  [optional]
**variantId** | **String** | The ID of the Product Variant that the Product Option Value is defined for. | 
**variant** | **Object** | Available if the relation &#x60;variant&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
