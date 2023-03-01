# Discount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The discount&#x27;s ID | 
**code** | **String** | A unique code for the discount - this will be used by the customer to apply the discount | 
**isDynamic** | **Boolean** | A flag to indicate if multiple instances of the discount can be generated. I.e. for newsletter discounts | 
**ruleId** | **String** | The Discount Rule that governs the behaviour of the Discount | 
**rule** | [**DiscountRule**](DiscountRule.md) |  |  [optional]
**isDisabled** | **Boolean** | Whether the Discount has been disabled. Disabled discounts cannot be applied to carts | 
**parentDiscountId** | **String** | The Discount that the discount was created from. This will always be a dynamic discount | 
**parentDiscount** | **Object** | Available if the relation &#x60;parent_discount&#x60; is expanded. |  [optional]
**startsAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which the discount can be used. | 
**endsAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time at which the discount can no longer be used. | 
**validDuration** | **String** | Duration the discount runs between | 
**regions** | [**List&lt;Region&gt;**](Region.md) | The Regions in which the Discount can be used. Available if the relation &#x60;regions&#x60; is expanded. |  [optional]
**usageLimit** | **Integer** | The maximum number of times that a discount can be used. | 
**usageCount** | **Integer** | The number of times a discount has been used. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
