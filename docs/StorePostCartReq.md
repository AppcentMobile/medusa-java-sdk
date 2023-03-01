# StorePostCartReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**regionId** | **String** | The ID of the Region to create the Cart in. |  [optional]
**salesChannelId** | **String** | [EXPERIMENTAL] The ID of the Sales channel to create the Cart in. |  [optional]
**countryCode** | **String** | The 2 character ISO country code to create the Cart in. |  [optional]
**items** | [**List&lt;StorePostCartReqItems&gt;**](StorePostCartReqItems.md) | An optional array of &#x60;variant_id&#x60;, &#x60;quantity&#x60; pairs to generate Line Items from. |  [optional]
**context** | **Object** | An optional object to provide context to the Cart. The &#x60;context&#x60; field is automatically populated with &#x60;ip&#x60; and &#x60;user_agent&#x60; |  [optional]
