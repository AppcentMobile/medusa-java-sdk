# CustomShippingOption

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The custom shipping option&#x27;s ID | 
**price** | **Integer** | The custom price set that will override the shipping option&#x27;s original price | 
**shippingOptionId** | **String** | The ID of the Shipping Option that the custom shipping option overrides | 
**shippingOption** | [**ShippingOption**](ShippingOption.md) |  |  [optional]
**cartId** | **String** | The ID of the Cart that the custom shipping option is attached to | 
**cart** | [**Cart**](Cart.md) |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
