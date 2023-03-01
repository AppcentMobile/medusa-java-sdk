# Invite

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The invite&#x27;s ID | 
**userEmail** | **String** | The email of the user being invited. | 
**role** | [**RoleEnum**](#RoleEnum) | The user&#x27;s role. | 
**accepted** | **Boolean** | Whether the invite was accepted or not. | 
**token** | **String** | The token used to accept the invite. | 
**expiresAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date the invite expires at. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="RoleEnum"></a>
## Enum: RoleEnum
Name | Value
---- | -----
ADMIN | &quot;admin&quot;
MEMBER | &quot;member&quot;
DEVELOPER | &quot;developer&quot;
