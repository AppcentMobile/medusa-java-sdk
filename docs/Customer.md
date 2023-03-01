# Customer

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The customer&#x27;s ID | 
**email** | **String** | The customer&#x27;s email | 
**firstName** | **String** | The customer&#x27;s first name | 
**lastName** | **String** | The customer&#x27;s last name | 
**billingAddressId** | **String** | The customer&#x27;s billing address ID | 
**billingAddress** | [**Address**](Address.md) |  |  [optional]
**shippingAddresses** | [**List&lt;Address&gt;**](Address.md) | Available if the relation &#x60;shipping_addresses&#x60; is expanded. |  [optional]
**phone** | **String** | The customer&#x27;s phone number | 
**hasAccount** | **Boolean** | Whether the customer has an account or not | 
**orders** | **List&lt;Object&gt;** | Available if the relation &#x60;orders&#x60; is expanded. |  [optional]
**groups** | [**List&lt;CustomerGroup&gt;**](CustomerGroup.md) | The customer groups the customer belongs to. Available if the relation &#x60;groups&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
