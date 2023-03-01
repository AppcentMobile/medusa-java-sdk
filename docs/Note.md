# Note

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The note&#x27;s ID | 
**resourceType** | **String** | The type of resource that the Note refers to. | 
**resourceId** | **String** | The ID of the resource that the Note refers to. | 
**value** | **String** | The contents of the note. | 
**authorId** | **String** | The ID of the author (user) | 
**author** | [**User**](User.md) |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
