# TaxRate

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The tax rate&#x27;s ID | 
**rate** | [**BigDecimal**](BigDecimal.md) | The numeric rate to charge | 
**code** | **String** | A code to identify the tax type by | 
**name** | **String** | A human friendly name for the tax | 
**regionId** | **String** | The id of the Region that the rate belongs to | 
**region** | **Object** | A region object. Available if the relation &#x60;region&#x60; is expanded. |  [optional]
**products** | [**List&lt;Product&gt;**](Product.md) | The products that belong to this tax rate. Available if the relation &#x60;products&#x60; is expanded. |  [optional]
**productTypes** | [**List&lt;ProductType&gt;**](ProductType.md) | The product types that belong to this tax rate. Available if the relation &#x60;product_types&#x60; is expanded. |  [optional]
**shippingOptions** | [**List&lt;ShippingOption&gt;**](ShippingOption.md) | The shipping options that belong to this tax rate. Available if the relation &#x60;shipping_options&#x60; is expanded. |  [optional]
**productCount** | **Integer** | The count of products |  [optional]
**productTypeCount** | **Integer** | The count of product types |  [optional]
**shippingOptionCount** | **Integer** | The count of shipping options |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**metadata** | **Object** | An optional key-value map with additional details | 
