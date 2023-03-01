# ShippingOptionRequirement

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The shipping option requirement&#x27;s ID | 
**shippingOptionId** | **String** | The id of the Shipping Option that the hipping option requirement belongs to | 
**shippingOption** | **Object** | Available if the relation &#x60;shipping_option&#x60; is expanded. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | The type of the requirement, this defines how the value will be compared to the Cart&#x27;s total. &#x60;min_subtotal&#x60; requirements define the minimum subtotal that is needed for the Shipping Option to be available, while the &#x60;max_subtotal&#x60; defines the maximum subtotal that the Cart can have for the Shipping Option to be available. | 
**amount** | **Integer** | The amount to compare the Cart subtotal to. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
MIN_SUBTOTAL | &quot;min_subtotal&quot;
MAX_SUBTOTAL | &quot;max_subtotal&quot;
