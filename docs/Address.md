# Address

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | ID of the address | 
**customerId** | **String** | ID of the customer this address belongs to | 
**customer** | **Object** | Available if the relation &#x60;customer&#x60; is expanded. |  [optional]
**company** | **String** | Company name | 
**firstName** | **String** | First name | 
**lastName** | **String** | Last name | 
**address1** | **String** | Address line 1 | 
**address2** | **String** | Address line 2 | 
**city** | **String** | City | 
**countryCode** | **String** | The 2 character ISO code of the country in lower case | 
**country** | [**Country**](Country.md) |  |  [optional]
**province** | **String** | Province | 
**postalCode** | **String** | Postal Code | 
**phone** | **String** | Phone Number | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
