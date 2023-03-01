# ReturnItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**returnId** | **String** | The id of the Return that the Return Item belongs to. | 
**itemId** | **String** | The id of the Line Item that the Return Item references. | 
**returnOrder** | **Object** | Available if the relation &#x60;return_order&#x60; is expanded. |  [optional]
**item** | [**LineItem**](LineItem.md) |  |  [optional]
**quantity** | **Integer** | The quantity of the Line Item that is included in the Return. | 
**isRequested** | **Boolean** | Whether the Return Item was requested initially or received unexpectedly in the warehouse. | 
**requestedQuantity** | **Integer** | The quantity that was originally requested to be returned. | 
**receivedQuantity** | **Integer** | The quantity that was received in the warehouse. | 
**reasonId** | **String** | The ID of the reason for returning the item. | 
**reason** | [**ReturnReason**](ReturnReason.md) |  |  [optional]
**note** | **String** | An optional note with additional details about the Return. | 
**metadata** | **Object** | An optional key-value map with additional details | 
