# TrackingLink

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The tracking link&#x27;s ID | 
**url** | **String** | The URL at which the status of the shipment can be tracked. | 
**trackingNumber** | **String** | The tracking number given by the shipping carrier. | 
**fulfillmentId** | **String** | The id of the Fulfillment that the Tracking Link references. | 
**fulfillment** | **Object** | Available if the relation &#x60;fulfillment&#x60; is expanded. |  [optional]
**idempotencyKey** | **String** | Randomly generated key used to continue the completion of a process in case of failure. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 
