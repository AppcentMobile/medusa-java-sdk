# GiftCard

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The gift card&#x27;s ID | 
**code** | **String** | The unique code that identifies the Gift Card. This is used by the Customer to redeem the value of the Gift Card. | 
**value** | **Integer** | The value that the Gift Card represents. | 
**balance** | **Integer** | The remaining value on the Gift Card. | 
**regionId** | **String** | The id of the Region in which the Gift Card is available. | 
**region** | [**Region**](Region.md) |  |  [optional]
**orderId** | **String** | The id of the Order that the Gift Card was purchased in. | 
**order** | **Object** | An order object. Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**isDisabled** | **Boolean** | Whether the Gift Card has been disabled. Disabled Gift Cards cannot be applied to carts. | 
**endsAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which the Gift Card can no longer be used. | 
**taxRate** | [**BigDecimal**](BigDecimal.md) | The gift card&#x27;s tax rate that will be applied on calculating totals | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
