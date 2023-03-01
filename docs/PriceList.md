# PriceList

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The price list&#x27;s ID | 
**name** | **String** | The price list&#x27;s name | 
**description** | **String** | The price list&#x27;s description | 
**type** | [**TypeEnum**](#TypeEnum) | The type of Price List. This can be one of either &#x60;sale&#x60; or &#x60;override&#x60;. | 
**status** | [**StatusEnum**](#StatusEnum) | The status of the Price List | 
**startsAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone that the Price List starts being valid. | 
**endsAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone that the Price List stops being valid. | 
**customerGroups** | [**List&lt;CustomerGroup&gt;**](CustomerGroup.md) | The Customer Groups that the Price List applies to. Available if the relation &#x60;customer_groups&#x60; is expanded. |  [optional]
**prices** | [**List&lt;MoneyAmount&gt;**](MoneyAmount.md) | The Money Amounts that are associated with the Price List. Available if the relation &#x60;prices&#x60; is expanded. |  [optional]
**includesTax** | **Boolean** | [EXPERIMENTAL] Does the price list prices include tax |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
SALE | &quot;sale&quot;
OVERRIDE | &quot;override&quot;

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;active&quot;
DRAFT | &quot;draft&quot;
