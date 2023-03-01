# ProductCategory

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The product category&#x27;s ID | 
**name** | **String** | The product category&#x27;s name | 
**handle** | **String** | A unique string that identifies the Product Category - can for example be used in slug structures. | 
**mpath** | **String** | A string for Materialized Paths - used for finding ancestors and descendents | 
**isInternal** | **Boolean** | A flag to make product category an internal category for admins | 
**isActive** | **Boolean** | A flag to make product category visible/hidden in the store front | 
**categoryChildren** | **List&lt;Object&gt;** | Available if the relation &#x60;category_children&#x60; are expanded. | 
**parentCategoryId** | **String** | The ID of the parent category. | 
**parentCategory** | **Object** | A product category object. Available if the relation &#x60;parent_category&#x60; is expanded. |  [optional]
**products** | **List&lt;Object&gt;** | Products associated with category. Available if the relation &#x60;products&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
