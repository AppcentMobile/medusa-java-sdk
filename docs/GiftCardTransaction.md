# GiftCardTransaction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The gift card transaction&#x27;s ID | 
**giftCardId** | **String** | The ID of the Gift Card that was used in the transaction. | 
**giftCard** | **Object** | A gift card object. Available if the relation &#x60;gift_card&#x60; is expanded. |  [optional]
**orderId** | **String** | The ID of the Order that the Gift Card was used to pay for. | 
**order** | **Object** | An order object. Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**amount** | **Integer** | The amount that was used from the Gift Card. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**isTaxable** | **Boolean** | Whether the transaction is taxable or not. | 
**taxRate** | [**BigDecimal**](BigDecimal.md) | The tax rate of the transaction | 
