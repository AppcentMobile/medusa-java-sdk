# User

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The user&#x27;s ID | 
**role** | [**RoleEnum**](#RoleEnum) | The user&#x27;s role | 
**email** | **String** | The email of the User | 
**firstName** | **String** | The first name of the User | 
**lastName** | **String** | The last name of the User | 
**apiToken** | **String** | An API token associated with the user. | 
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
