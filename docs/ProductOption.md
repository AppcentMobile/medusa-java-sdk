# ProductOption

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The product option&#x27;s ID | 
**title** | **String** | The title that the Product Option is defined by (e.g. &#x60;Size&#x60;). | 
**values** | [**List&lt;ProductOptionValue&gt;**](ProductOptionValue.md) | The Product Option Values that are defined for the Product Option. Available if the relation &#x60;values&#x60; is expanded. |  [optional]
**productId** | **String** | The ID of the Product that the Product Option is defined for. | 
**product** | **Object** | A product object. Available if the relation &#x60;product&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
