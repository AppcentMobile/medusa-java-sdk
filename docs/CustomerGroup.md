# CustomerGroup

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The customer group&#x27;s ID | 
**name** | **String** | The name of the customer group | 
**customers** | **List&lt;Object&gt;** | The customers that belong to the customer group. Available if the relation &#x60;customers&#x60; is expanded. |  [optional]
**priceLists** | **List&lt;Object&gt;** | The price lists that are associated with the customer group. Available if the relation &#x60;price_lists&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
