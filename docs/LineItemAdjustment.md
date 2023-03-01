# LineItemAdjustment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The Line Item Adjustment&#x27;s ID | 
**itemId** | **String** | The ID of the line item | 
**item** | **Object** | Available if the relation &#x60;item&#x60; is expanded. |  [optional]
**description** | **String** | The line item&#x27;s adjustment description | 
**discountId** | **String** | The ID of the discount associated with the adjustment | 
**discount** | [**Discount**](Discount.md) |  |  [optional]
**amount** | **Integer** | The adjustment amount | 
**metadata** | **Object** | An optional key-value map with additional details | 
