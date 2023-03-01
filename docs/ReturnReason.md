# ReturnReason

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The return reason&#x27;s ID | 
**value** | **String** | The value to identify the reason by. | 
**label** | **String** | A text that can be displayed to the Customer as a reason. | 
**description** | **String** | A description of the Reason. | 
**parentReturnReasonId** | **String** | The ID of the parent reason. | 
**parentReturnReason** | **Object** | Available if the relation &#x60;parent_return_reason&#x60; is expanded. |  [optional]
**returnReasonChildren** | **Object** | Available if the relation &#x60;return_reason_children&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
