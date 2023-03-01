# Notification

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The notification&#x27;s ID | 
**eventName** | **String** | The name of the event that the notification was sent for. | 
**resourceType** | **String** | The type of resource that the Notification refers to. | 
**resourceId** | **String** | The ID of the resource that the Notification refers to. | 
**customerId** | **String** | The ID of the Customer that the Notification was sent to. | 
**customer** | [**Customer**](Customer.md) |  |  [optional]
**to** | **String** | The address that the Notification was sent to. This will usually be an email address, but represent other addresses such as a chat bot user id | 
**data** | **Object** | The data that the Notification was sent with. This contains all the data necessary for the Notification Provider to initiate a resend. | 
**parentId** | **String** | The notification&#x27;s parent ID | 
**parentNotification** | **Object** | Available if the relation &#x60;parent_notification&#x60; is expanded. |  [optional]
**resends** | **List&lt;Object&gt;** | The resends that have been completed after the original Notification. Available if the relation &#x60;resends&#x60; is expanded. |  [optional]
**providerId** | **String** | The id of the Notification Provider that handles the Notification. | 
**provider** | [**NotificationProvider**](NotificationProvider.md) |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
