# FulfillmentItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fulfillmentId** | **String** | The id of the Fulfillment that the Fulfillment Item belongs to. | 
**itemId** | **String** | The id of the Line Item that the Fulfillment Item references. | 
**fulfillment** | **Object** | A fulfillment object. Available if the relation &#x60;fulfillment&#x60; is expanded. |  [optional]
**item** | [**LineItem**](LineItem.md) |  |  [optional]
**quantity** | **Integer** | The quantity of the Line Item that is included in the Fulfillment. | 
