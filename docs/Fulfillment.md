# Fulfillment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The fulfillment&#x27;s ID | 
**claimOrderId** | **String** | The id of the Claim that the Fulfillment belongs to. | 
**claimOrder** | **Object** | A claim order object. Available if the relation &#x60;claim_order&#x60; is expanded. |  [optional]
**swapId** | **String** | The id of the Swap that the Fulfillment belongs to. | 
**swap** | **Object** | A swap object. Available if the relation &#x60;swap&#x60; is expanded. |  [optional]
**orderId** | **String** | The id of the Order that the Fulfillment belongs to. | 
**order** | **Object** | An order object. Available if the relation &#x60;order&#x60; is expanded. |  [optional]
**providerId** | **String** | The id of the Fulfillment Provider responsible for handling the fulfillment | 
**provider** | [**FulfillmentProvider**](FulfillmentProvider.md) |  |  [optional]
**locationId** | **String** | The id of the stock location the fulfillment will be shipped from | 
**items** | [**List&lt;FulfillmentItem&gt;**](FulfillmentItem.md) | The Fulfillment Items in the Fulfillment - these hold information about how many of each Line Item has been fulfilled. Available if the relation &#x60;items&#x60; is expanded. |  [optional]
**trackingLinks** | [**List&lt;TrackingLink&gt;**](TrackingLink.md) | The Tracking Links that can be used to track the status of the Fulfillment, these will usually be provided by the Fulfillment Provider. Available if the relation &#x60;tracking_links&#x60; is expanded. |  [optional]
**trackingNumbers** | **List&lt;String&gt;** | The tracking numbers that can be used to track the status of the fulfillment. | 
**data** | **Object** | This contains all the data necessary for the Fulfillment provider to handle the fulfillment. | 
**shippedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the Fulfillment was shipped. | 
**noNotification** | **Boolean** | Flag for describing whether or not notifications related to this should be sent. | 
**canceledAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the Fulfillment was canceled. | 
**idempotencyKey** | **String** | Randomly generated key used to continue the completion of the fulfillment in case of failure. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**metadata** | **Object** | An optional key-value map with additional details | 
