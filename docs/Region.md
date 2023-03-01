# Region

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The region&#x27;s ID | 
**name** | **String** | The name of the region as displayed to the customer. If the Region only has one country it is recommended to write the country name. | 
**currencyCode** | **String** | The 3 character currency code that the Region uses. | 
**currency** | [**Currency**](Currency.md) |  |  [optional]
**taxRate** | [**BigDecimal**](BigDecimal.md) | The tax rate that should be charged on purchases in the Region. | 
**taxRates** | [**List&lt;TaxRate&gt;**](TaxRate.md) | The tax rates that are included in the Region. Available if the relation &#x60;tax_rates&#x60; is expanded. |  [optional]
**taxCode** | **String** | The tax code used on purchases in the Region. This may be used by other systems for accounting purposes. | 
**giftCardsTaxable** | **Boolean** | Whether the gift cards are taxable or not in this region. | 
**automaticTaxes** | **Boolean** | Whether taxes should be automated in this region. | 
**countries** | [**List&lt;Country&gt;**](Country.md) | The countries that are included in the Region. Available if the relation &#x60;countries&#x60; is expanded. |  [optional]
**taxProviderId** | **String** | The ID of the tax provider used in this region | 
**taxProvider** | [**TaxProvider**](TaxProvider.md) |  |  [optional]
**paymentProviders** | [**List&lt;PaymentProvider&gt;**](PaymentProvider.md) | The Payment Providers that can be used to process Payments in the Region. Available if the relation &#x60;payment_providers&#x60; is expanded. |  [optional]
**fulfillmentProviders** | [**List&lt;FulfillmentProvider&gt;**](FulfillmentProvider.md) | The Fulfillment Providers that can be used to fulfill orders in the Region. Available if the relation &#x60;fulfillment_providers&#x60; is expanded. |  [optional]
**includesTax** | **Boolean** | [EXPERIMENTAL] Does the prices for the region include tax |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
