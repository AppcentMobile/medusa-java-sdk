# SalesChannel

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The sales channel&#x27;s ID | 
**name** | **String** | The name of the sales channel. | 
**description** | **String** | The description of the sales channel. | 
**isDisabled** | **Boolean** | Specify if the sales channel is enabled or disabled. | 
**locations** | [**List&lt;SalesChannelLocation&gt;**](SalesChannelLocation.md) | The Stock Locations related to the sales channel. Available if the relation &#x60;locations&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
