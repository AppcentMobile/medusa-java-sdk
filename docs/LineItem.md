# LineItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The line item&#x27;s ID | 
**cartId** | **String** | The ID of the Cart that the Line Item belongs to. | 
**cart** | **Object** | A cart object. Available if the relation &#x60;cart&#x60; is expanded. |  [optional]
**orderId** | **String** | The ID of the Order that the Line Item belongs to. | 
**order** | **Object** | An order object. Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**swapId** | **String** | The id of the Swap that the Line Item belongs to. | 
**swap** | **Object** | A swap object. Available if the relation &#x60;swap&#x60; is expanded. |  [optional]
**claimOrderId** | **String** | The id of the Claim that the Line Item belongs to. | 
**claimOrder** | **Object** | A claim order object. Available if the relation &#x60;claim_order&#x60; is expanded. |  [optional]
**taxLines** | [**List&lt;LineItemTaxLine&gt;**](LineItemTaxLine.md) | Available if the relation &#x60;tax_lines&#x60; is expanded. |  [optional]
**adjustments** | [**List&lt;LineItemAdjustment&gt;**](LineItemAdjustment.md) | Available if the relation &#x60;adjustments&#x60; is expanded. |  [optional]
**originalItemId** | **String** | The id of the original line item | 
**orderEditId** | **String** | The ID of the order edit to which a cloned item belongs | 
**orderEdit** | **Object** | The order edit joined. Available if the relation &#x60;order_edit&#x60; is expanded. |  [optional]
**title** | **String** | The title of the Line Item, this should be easily identifiable by the Customer. | 
**description** | **String** | A more detailed description of the contents of the Line Item. | 
**thumbnail** | **String** | A URL string to a small image of the contents of the Line Item. | 
**isReturn** | **Boolean** | Is the item being returned | 
**isGiftcard** | **Boolean** | Flag to indicate if the Line Item is a Gift Card. | 
**shouldMerge** | **Boolean** | Flag to indicate if new Line Items with the same variant should be merged or added as an additional Line Item. | 
**allowDiscounts** | **Boolean** | Flag to indicate if the Line Item should be included when doing discount calculations. | 
**hasShipping** | **Boolean** | Flag to indicate if the Line Item has fulfillment associated with it. | 
**unitPrice** | **Integer** | The price of one unit of the content in the Line Item. This should be in the currency defined by the Cart/Order/Swap/Claim that the Line Item belongs to. | 
**variantId** | **String** | The id of the Product Variant contained in the Line Item. | 
**variant** | [**ProductVariant**](ProductVariant.md) |  |  [optional]
**quantity** | **Integer** | The quantity of the content in the Line Item. | 
**fulfilledQuantity** | **Integer** | The quantity of the Line Item that has been fulfilled. | 
**returnedQuantity** | **Integer** | The quantity of the Line Item that has been returned. | 
**shippedQuantity** | **Integer** | The quantity of the Line Item that has been shipped. | 
**refundable** | **Integer** | The amount that can be refunded from the given Line Item. Takes taxes and discounts into consideration. |  [optional]
**subtotal** | **Integer** | The subtotal of the line item |  [optional]
**taxTotal** | **Integer** | The total of tax of the line item |  [optional]
**total** | **Integer** | The total amount of the line item |  [optional]
**originalTotal** | **Integer** | The original total amount of the line item |  [optional]
**originalTaxTotal** | **Integer** | The original tax total amount of the line item |  [optional]
**discountTotal** | **Integer** | The total of discount of the line item |  [optional]
**giftCardTotal** | **Integer** | The total of the gift card of the line item |  [optional]
**includesTax** | **Boolean** | [EXPERIMENTAL] Indicates if the line item unit_price include tax |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**metadata** | **Object** | An optional key-value map with additional details | 
