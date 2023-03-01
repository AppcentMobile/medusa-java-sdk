# PricedVariant

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**originalPrice** | [**BigDecimal**](BigDecimal.md) | The original price of the variant without any discounted prices applied. |  [optional]
**calculatedPrice** | [**BigDecimal**](BigDecimal.md) | The calculated price of the variant. Can be a discounted price. |  [optional]
**originalPriceInclTax** | [**BigDecimal**](BigDecimal.md) | The original price of the variant including taxes. |  [optional]
**calculatedPriceInclTax** | [**BigDecimal**](BigDecimal.md) | The calculated price of the variant including taxes. |  [optional]
**originalTax** | [**BigDecimal**](BigDecimal.md) | The taxes applied on the original price. |  [optional]
**calculatedTax** | [**BigDecimal**](BigDecimal.md) | The taxes applied on the calculated price. |  [optional]
**taxRates** | [**List&lt;PricedVariantTaxRates&gt;**](PricedVariantTaxRates.md) | An array of applied tax rates |  [optional]
