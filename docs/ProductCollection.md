# ProductCollection

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The product collection&#x27;s ID | 
**title** | **String** | The title that the Product Collection is identified by. | 
**handle** | **String** | A unique string that identifies the Product Collection - can for example be used in slug structures. | 
**products** | **List&lt;Object&gt;** | The Products contained in the Product Collection. Available if the relation &#x60;products&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
