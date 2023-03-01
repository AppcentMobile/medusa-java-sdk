# PaymentSession

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The payment session&#x27;s ID | 
**cartId** | **String** | The id of the Cart that the Payment Session is created for. | 
**cart** | [**Cart**](Cart.md) |  |  [optional]
**providerId** | **String** | The id of the Payment Provider that is responsible for the Payment Session | 
**isSelected** | **Boolean** | A flag to indicate if the Payment Session has been selected as the method that will be used to complete the purchase. | 
**isInitiated** | **Boolean** | A flag to indicate if a communication with the third party provider has been initiated. | 
**status** | [**StatusEnum**](#StatusEnum) | Indicates the status of the Payment Session. Will default to &#x60;pending&#x60;, and will eventually become &#x60;authorized&#x60;. Payment Sessions may have the status of &#x60;requires_more&#x60; to indicate that further actions are to be completed by the Customer. | 
**data** | **Object** | The data required for the Payment Provider to identify, modify and process the Payment Session. Typically this will be an object that holds an id to the external payment session, but can be an empty object if the Payment Provider doesn&#x27;t hold any state. | 
**idempotencyKey** | **String** | Randomly generated key used to continue the completion of a cart in case of failure. | 
**amount** | **Integer** | The amount that the Payment Session has been authorized for. | 
**paymentAuthorizedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the Payment Session was authorized. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
AUTHORIZED | &quot;authorized&quot;
PENDING | &quot;pending&quot;
REQUIRES_MORE | &quot;requires_more&quot;
ERROR | &quot;error&quot;
CANCELED | &quot;canceled&quot;
