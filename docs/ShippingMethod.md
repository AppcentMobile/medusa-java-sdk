# ShippingMethod

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The shipping method&#x27;s ID | 
**shippingOptionId** | **String** | The id of the Shipping Option that the Shipping Method is built from. | 
**orderId** | **String** | The id of the Order that the Shipping Method is used on. | 
**order** | **Object** | An order object. Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**claimOrderId** | **String** | The id of the Claim that the Shipping Method is used on. | 
**claimOrder** | **Object** | A claim order object. Available if the relation &#x60;claim_order&#x60; is expanded. |  [optional]
**cartId** | **String** | The id of the Cart that the Shipping Method is used on. | 
**cart** | **Object** | A cart object. Available if the relation &#x60;cart&#x60; is expanded. |  [optional]
**swapId** | **String** | The id of the Swap that the Shipping Method is used on. | 
**swap** | **Object** | A swap object. Available if the relation &#x60;swap&#x60; is expanded. |  [optional]
**returnId** | **String** | The id of the Return that the Shipping Method is used on. | 
**returnOrder** | **Object** | A return object. Available if the relation &#x60;return_order&#x60; is expanded. |  [optional]
**shippingOption** | [**ShippingOption**](ShippingOption.md) |  |  [optional]
**taxLines** | [**List&lt;ShippingMethodTaxLine&gt;**](ShippingMethodTaxLine.md) | Available if the relation &#x60;tax_lines&#x60; is expanded. |  [optional]
**price** | **Integer** | The amount to charge for the Shipping Method. The currency of the price is defined by the Region that the Order that the Shipping Method belongs to is a part of. | 
**data** | **Object** | Additional data that the Fulfillment Provider needs to fulfill the shipment. This is used in combination with the Shipping Options data, and may contain information such as a drop point id. | 
**includesTax** | **Boolean** | [EXPERIMENTAL] Indicates if the shipping method price include tax |  [optional]
**subtotal** | **Integer** | The subtotal of the shipping |  [optional]
**total** | **Integer** | The total amount of the shipping |  [optional]
**taxTotal** | **Integer** | The total of tax |  [optional]
