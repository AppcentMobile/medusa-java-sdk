# PaymentCollection

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The payment collection&#x27;s ID | 
**type** | [**TypeEnum**](#TypeEnum) | The type of the payment collection | 
**status** | [**StatusEnum**](#StatusEnum) | The type of the payment collection | 
**description** | **String** | Description of the payment collection | 
**amount** | **Integer** | Amount of the payment collection. | 
**authorizedAmount** | **Integer** | Authorized amount of the payment collection. | 
**regionId** | **String** | The region&#x27;s ID | 
**region** | [**Region**](Region.md) |  |  [optional]
**currencyCode** | **String** | The 3 character ISO code for the currency. | 
**currency** | [**Currency**](Currency.md) |  |  [optional]
**paymentSessions** | [**List&lt;PaymentSession&gt;**](PaymentSession.md) | Available if the relation &#x60;payment_sessions&#x60; is expanded. |  [optional]
**payments** | [**List&lt;Payment&gt;**](Payment.md) | Available if the relation &#x60;payments&#x60; is expanded. |  [optional]
**createdBy** | **String** | The ID of the user that created the payment collection. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
ORDER_EDIT | &quot;order_edit&quot;

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
NOT_PAID | &quot;not_paid&quot;
AWAITING | &quot;awaiting&quot;
AUTHORIZED | &quot;authorized&quot;
PARTIALLY_AUTHORIZED | &quot;partially_authorized&quot;
CANCELED | &quot;canceled&quot;
