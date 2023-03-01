# IdempotencyKey

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The idempotency key&#x27;s ID | 
**idempotencyKey** | **String** | The unique randomly generated key used to determine the state of a process. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | Date which the idempotency key was locked. | 
**lockedAt** | [**OffsetDateTime**](OffsetDateTime.md) | Date which the idempotency key was locked. | 
**requestMethod** | **String** | The method of the request | 
**requestParams** | **Object** | The parameters passed to the request | 
**requestPath** | **String** | The request&#x27;s path | 
**responseCode** | **String** | The response&#x27;s code. | 
**responseBody** | **Object** | The response&#x27;s body | 
**recoveryPoint** | **String** | Where to continue from. | 
