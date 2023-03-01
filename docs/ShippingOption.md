# ShippingOption

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The shipping option&#x27;s ID | 
**name** | **String** | The name given to the Shipping Option - this may be displayed to the Customer. | 
**regionId** | **String** | The region&#x27;s ID | 
**region** | **Object** | A region object. Available if the relation &#x60;region&#x60; is expanded. |  [optional]
**profileId** | **String** | The ID of the Shipping Profile that the shipping option belongs to. Shipping Profiles have a set of defined Shipping Options that can be used to Fulfill a given set of Products. | 
**profile** | [**ShippingProfile**](ShippingProfile.md) |  |  [optional]
**providerId** | **String** | The id of the Fulfillment Provider, that will be used to process Fulfillments from the Shipping Option. | 
**provider** | [**FulfillmentProvider**](FulfillmentProvider.md) |  |  [optional]
**priceType** | [**PriceTypeEnum**](#PriceTypeEnum) | The type of pricing calculation that is used when creatin Shipping Methods from the Shipping Option. Can be &#x60;flat_rate&#x60; for fixed prices or &#x60;calculated&#x60; if the Fulfillment Provider can provide price calulations. | 
**amount** | **Integer** | The amount to charge for shipping when the Shipping Option price type is &#x60;flat_rate&#x60;. | 
**isReturn** | **Boolean** | Flag to indicate if the Shipping Option can be used for Return shipments. | 
**adminOnly** | **Boolean** | Flag to indicate if the Shipping Option usage is restricted to admin users. | 
**requirements** | [**List&lt;ShippingOptionRequirement&gt;**](ShippingOptionRequirement.md) | The requirements that must be satisfied for the Shipping Option to be available for a Cart. Available if the relation &#x60;requirements&#x60; is expanded. |  [optional]
**data** | **Object** | The data needed for the Fulfillment Provider to identify the Shipping Option. | 
**includesTax** | **Boolean** | [EXPERIMENTAL] Does the shipping option price include tax |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="PriceTypeEnum"></a>
## Enum: PriceTypeEnum
Name | Value
---- | -----
FLAT_RATE | &quot;flat_rate&quot;
CALCULATED | &quot;calculated&quot;
