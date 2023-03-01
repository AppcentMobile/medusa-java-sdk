# LineItemTaxLine

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The line item tax line&#x27;s ID | 
**code** | **String** | A code to identify the tax type by | 
**name** | **String** | A human friendly name for the tax | 
**rate** | [**BigDecimal**](BigDecimal.md) | The numeric rate to charge tax by | 
**itemId** | **String** | The ID of the line item | 
**item** | **Object** | Available if the relation &#x60;item&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**metadata** | **Object** | An optional key-value map with additional details | 
