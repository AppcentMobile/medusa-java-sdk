# ShippingProfile

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The shipping profile&#x27;s ID | 
**name** | **String** | The name given to the Shipping profile - this may be displayed to the Customer. | 
**type** | [**TypeEnum**](#TypeEnum) | The type of the Shipping Profile, may be &#x60;default&#x60;, &#x60;gift_card&#x60; or &#x60;custom&#x60;. | 
**products** | **List&lt;Object&gt;** | The Products that the Shipping Profile defines Shipping Options for. Available if the relation &#x60;products&#x60; is expanded. |  [optional]
**shippingOptions** | **List&lt;Object&gt;** | The Shipping Options that can be used to fulfill the Products in the Shipping Profile. Available if the relation &#x60;shipping_options&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
DEFAULT | &quot;default&quot;
GIFT_CARD | &quot;gift_card&quot;
CUSTOM | &quot;custom&quot;
