# DiscountCondition

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The discount condition&#x27;s ID | 
**type** | [**TypeEnum**](#TypeEnum) | The type of the Condition | 
**operator** | [**OperatorEnum**](#OperatorEnum) | The operator of the Condition | 
**discountRuleId** | **String** | The ID of the discount rule associated with the condition | 
**discountRule** | [**DiscountRule**](DiscountRule.md) |  |  [optional]
**products** | [**List&lt;Product&gt;**](Product.md) | products associated with this condition if type &#x3D; products. Available if the relation &#x60;products&#x60; is expanded. |  [optional]
**productTypes** | [**List&lt;ProductType&gt;**](ProductType.md) | Product types associated with this condition if type &#x3D; product_types. Available if the relation &#x60;product_types&#x60; is expanded. |  [optional]
**productTags** | [**List&lt;ProductTag&gt;**](ProductTag.md) | Product tags associated with this condition if type &#x3D; product_tags. Available if the relation &#x60;product_tags&#x60; is expanded. |  [optional]
**productCollections** | [**List&lt;ProductCollection&gt;**](ProductCollection.md) | Product collections associated with this condition if type &#x3D; product_collections. Available if the relation &#x60;product_collections&#x60; is expanded. |  [optional]
**customerGroups** | [**List&lt;CustomerGroup&gt;**](CustomerGroup.md) | Customer groups associated with this condition if type &#x3D; customer_groups. Available if the relation &#x60;customer_groups&#x60; is expanded. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was created. | 
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was updated. | 
**deletedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date with timezone at which the resource was deleted. | 
**metadata** | **Object** | An optional key-value map with additional details | 

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
PRODUCTS | &quot;products&quot;
PRODUCT_TYPES | &quot;product_types&quot;
PRODUCT_COLLECTIONS | &quot;product_collections&quot;
PRODUCT_TAGS | &quot;product_tags&quot;
CUSTOMER_GROUPS | &quot;customer_groups&quot;

<a name="OperatorEnum"></a>
## Enum: OperatorEnum
Name | Value
---- | -----
IN | &quot;in&quot;
NOT_IN | &quot;not_in&quot;
