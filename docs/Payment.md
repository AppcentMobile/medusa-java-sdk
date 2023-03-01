# Payment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The payment&#x27;s ID | 
**swapId** | **String** | The ID of the Swap that the Payment is used for. | 
**swap** | **Object** | A swap object. Available if the relation &#x60;swap&#x60; is expanded. |  [optional]
**cartId** | **String** | The id of the Cart that the Payment Session is created for. | 
**cart** | **Object** | A cart object. Available if the relation &#x60;cart&#x60; is expanded. |  [optional]
**orderId** | **String** | The ID of the Order that the Payment is used for. | 
**order** | **Object** | An order object. Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**amount** | **Integer** | The amount that the Payment has been authorized for. | 
**currencyCode** | **String** | The 3 character ISO currency code that the Payment is completed in. | 
**currency** | [**Currency**](Currency.md) |  |  [optional]
**amountRefunded** | **Integer** | The amount of the original Payment amount that has been refunded back to the Customer. | 
**providerId** | **String** | The id of the Payment Provider that is responsible for the Payment | 
**data** | **Object** | The data required for the Payment Provider to identify, modify and process the Payment. Typically this will be an object that holds an id to the external payment session, but can be an empty object if the Payment Provider doesn&#x27;t hold any state. | 
**capturedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the Payment was captured. | 
**canceledAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the Payment was canceled. | 
**idempotencyKey** | **String** | Randomly generated key used to continue the completion of a payment in case of failure. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**metadata** | **Object** | An optional key-value map with additional details | 
