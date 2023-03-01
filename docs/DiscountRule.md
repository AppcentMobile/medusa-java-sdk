# DiscountRule

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The discount rule&#x27;s ID | 
**type** | [**TypeEnum**](#TypeEnum) | The type of the Discount, can be &#x60;fixed&#x60; for discounts that reduce the price by a fixed amount, &#x60;percentage&#x60; for percentage reductions or &#x60;free_shipping&#x60; for shipping vouchers. | 
**description** | **String** | A short description of the discount | 
**value** | **Integer** | The value that the discount represents; this will depend on the type of the discount | 
**allocation** | [**AllocationEnum**](#AllocationEnum) | The scope that the discount should apply to. | 
**conditions** | **List&lt;Object&gt;** | A set of conditions that can be used to limit when  the discount can be used. Available if the relation &#x60;conditions&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
FIXED | &quot;fixed&quot;
PERCENTAGE | &quot;percentage&quot;
FREE_SHIPPING | &quot;free_shipping&quot;

<a name="AllocationEnum"></a>
## Enum: AllocationEnum
Name | Value
---- | -----
TOTAL | &quot;total&quot;
ITEM | &quot;item&quot;
