# BatchJob

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The unique identifier for the batch job. | 
**type** | [**TypeEnum**](#TypeEnum) | The type of batch job. | 
**status** | [**StatusEnum**](#StatusEnum) | The status of the batch job. | 
**createdBy** | **String** | The unique identifier of the user that created the batch job. | 
**createdByUser** | [**User**](User.md) |  |  [optional]
**context** | **Object** | The context of the batch job, the type of the batch job determines what the context should contain. | 
**dryRun** | **Boolean** | Specify if the job must apply the modifications or not. | 
**result** | **AllOfBatchJobResult** | The result of the batch job. | 
**preProcessedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date from which the job has been pre-processed. | 
**processingAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date the job is processing at. | 
**confirmedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date when the confirmation has been done. | 
**completedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date of the completion. | 
**canceledAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date of the concellation. | 
**failedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date when the job failed. | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was last updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
IMPORT | &quot;product-import&quot;
EXPORT | &quot;product-export&quot;

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
CREATED | &quot;created&quot;
PRE_PROCESSED | &quot;pre_processed&quot;
CONFIRMED | &quot;confirmed&quot;
PROCESSING | &quot;processing&quot;
COMPLETED | &quot;completed&quot;
CANCELED | &quot;canceled&quot;
FAILED | &quot;failed&quot;
