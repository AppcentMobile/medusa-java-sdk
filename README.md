# medusa-java-sdk

Medusa Storefront API
- API version: 1.0.0
  - Build date: 2023-02-24T12:45:51.835798768Z[GMT]

API reference for Medusa's Storefront endpoints. All endpoints are prefixed with `/store`.  ## Authentication  To send requests as an authenticated customer, you must use the Cookie Session ID.  <!-- ReDoc-Inject: <SecurityDefinitions> -->  ## Expanding Fields  In many endpoints you'll find an `expand` query parameter that can be passed to the endpoint. You can use the `expand` query parameter to unpack an entity's relations and return them in the response.  Please note that the relations you pass to `expand` replace any relations that are expanded by default in the request.  ### Expanding One Relation  For example, when you retrieve a product, you can retrieve its collection by passing to the `expand` query parameter the value `collection`:  ```bash curl \"http://localhost:9000/store/products/prod_01GDJGP2XPQT2N3JHZQFMH5V45?expand=collection\" ```  ### Expanding Multiple Relations  You can expand more than one relation by separating the relations in the `expand` query parameter with a comma.  For example, to retrieve both the variants and the collection of a product, pass to the `expand` query parameter the value `variants,collection`:  ```bash curl \"http://localhost:9000/store/products/prod_01GDJGP2XPQT2N3JHZQFMH5V45?expand=variants,collection\" ```  ### Prevent Expanding Relations  Some requests expand relations by default. You can prevent that by passing an empty expand value to retrieve an entity without any extra relations.  For example:  ```bash curl \"http://localhost:9000/store/products/prod_01GDJGP2XPQT2N3JHZQFMH5V45?expand\" ```  This would retrieve the product with only its properties, without any relations like `collection`.  ## Selecting Fields  In many endpoints you'll find a `fields` query parameter that can be passed to the endpoint. You can use the `fields` query parameter to specify which fields in the entity should be returned in the response.  Please note that if you pass a `fields` query parameter, only the fields you pass in the value along with the `id` of the entity will be returned in the response.  Also, the `fields` query parameter does not affect the expanded relations. You'll have to use the `expand` parameter instead.  ### Selecting One Field  For example, when you retrieve a list of products, you can retrieve only the titles of the products by passing `title` as a value to the `fields` query parameter:  ```bash curl \"http://localhost:9000/store/products?fields=title\" ```  As mentioned above, the expanded relations such as `variants` will still be returned as they're not affected by the `fields` parameter.  You can ensure that only the `title` field is returned by passing an empty value to the `expand` query parameter. For example:  ```bash curl \"http://localhost:9000/store/products?fields=title&expand\" ```  ### Selecting Multiple Fields  You can pass more than one field by seperating the field names in the `fields` query parameter with a comma.  For example, to select the `title` and `handle` of a product:  ```bash curl \"http://localhost:9000/store/products?fields=title,handle\" ```  ### Retrieve Only the ID  You can pass an empty `fields` query parameter to return only the ID of an entity. For example:  ```bash curl \"http://localhost:9000/store/products?fields\" ```  You can also pair with an empty `expand` query parameter to ensure that the relations aren't retrieved as well. For example:  ```bash curl \"http://localhost:9000/store/products?fields&expand\" ```  ## Query Parameter Types  This section covers how to pass some common data types as query parameters. This is useful if you're sending requests to the API endpoints and not using our JS Client. For example, when using cURL or Postman.  ### Strings  You can pass a string value in the form of `<parameter_name>=<value>`.  For example:  ```bash curl \"http://localhost:9000/store/products?title=Shirt\" ```  If the string has any characters other than letters and numbers, you must encode them.  For example, if the string has spaces, you can encode the space with `+` or `%20`:  ```bash curl \"http://localhost:9000/store/products?title=Blue%20Shirt\" ```  You can use tools like [this one](https://www.urlencoder.org/) to learn how a value can be encoded.  ### Integers  You can pass an integer value in the form of `<parameter_name>=<value>`.  For example:  ```bash curl \"http://localhost:9000/store/products?offset=1\" ```  ### Boolean  You can pass a boolean value in the form of `<parameter_name>=<value>`.  For example:  ```bash curl \"http://localhost:9000/store/products?is_giftcard=true\" ```  ### Date and DateTime  You can pass a date value in the form `<parameter_name>=<value>`. The date must be in the format `YYYY-MM-DD`.  For example:  ```bash curl -g \"http://localhost:9000/store/products?created_at[lt]=2023-02-17\" ```  You can also pass the time using the format `YYYY-MM-DDTHH:MM:SSZ`. Please note that the `T` and `Z` here are fixed.  For example:  ```bash curl -g \"http://localhost:9000/store/products?created_at[lt]=2023-02-17T07:22:30Z\" ```  ### Array  Each array value must be passed as a separate query parameter in the form `<parameter_name>[]=<value>`. You can also specify the index of each parameter in the brackets `<parameter_name>[0]=<value>`.  For example:  ```bash curl -g \"http://localhost:9000/store/products?sales_channel_id[]=sc_01GPGVB42PZ7N3YQEP2WDM7PC7&sales_channel_id[]=sc_234PGVB42PZ7N3YQEP2WDM7PC7\" ```  Note that the `-g` parameter passed to `curl` disables errors being thrown for using the brackets. Read more [here](https://curl.se/docs/manpage.html#-g).  ### Object  Object parameters must be passed as separate query parameters in the form `<parameter_name>[<key>]=<value>`.  For example:  ```bash curl -g \"http://localhost:9000/store/products?created_at[lt]=2023-02-17&created_at[gt]=2022-09-17\" ```  ## Pagination  ### Query Parameters  In listing endpoints, such as list customers or list products, you can control the pagination using the query parameters `limit` and `offset`.  `limit` is used to specify the maximum number of items that can be return in the response. `offset` is used to specify how many items to skip before returning the resulting entities.  You can use the `offset` query parameter to change between pages. For example, if the limit is 50, at page 1 the offset should be 0; at page 2 the offset should be 50, and so on.  For example, to limit the number of products returned in the List Products endpoint:  ```bash curl \"http://localhost:9000/store/products?limit=5\" ```  ### Response Fields  In the response of listing endpoints, aside from the entities retrieved, there are three pagination-related fields returned: `count`, `limit`, and `offset`.  Similar to the query parameters, `limit` is the maximum number of items that can be returned in the response, and `field` is the number of items that were skipped before the entities in the result.  `count` is the total number of available items of this entity. It can be used to determine how many pages are there.  For example, if the `count` is 100 and the `limit` is 50, you can divide the `count` by the `limit` to get the number of pages: `100/50 = 2 pages`. 


*Automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>mobi.appcent</groupId>
  <artifactId>medusa-java-sdk</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "mobi.appcent:medusa-java-sdk:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/medusa-java-sdk-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import mobi.appcent.medusa.store.MedusaApiClient;
import mobi.appcent.medusa.store.ApiException;
import mobi.appcent.medusa.store.api.AuthApi;
import mobi.appcent.medusa.store.auth.ApiKeyAuth;
import mobi.appcent.medusa.store.model.StoreAuthRes;
import mobi.appcent.medusa.store.model.StoreGetAuthEmailRes;
import mobi.appcent.medusa.store.model.StorePostAuthReq;

public class AuthApiExample {

    public static void main(String[] args) {
        MedusaApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: cookie_auth
        ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
        cookie_auth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //cookie_auth.setApiKeyPrefix("Token");

        AuthApi apiInstance = new AuthApi();
        try {
            apiInstance.deleteAuth();
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthApi#deleteAuth");
            e.printStackTrace();
        }
    }
}
import mobi.appcent.medusa.store.*;
        import mobi.appcent.medusa.store.auth.*;
        import mobi.appcent.medusa.store.model.*;
        import mobi.appcent.medusa.store.api.AuthApi;

        import java.io.File;
        import java.util.*;

public class AuthApiExample {

    public static void main(String[] args) {
        MedusaApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: cookie_auth
        ApiKeyAuth cookie_auth = (ApiKeyAuth) defaultClient.getAuthentication("cookie_auth");
        cookie_auth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //cookie_auth.setApiKeyPrefix("Token");

        AuthApi apiInstance = new AuthApi();
        try {
            StoreAuthRes result = apiInstance.getAuth();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthApi#getAuth");
            e.printStackTrace();
        }
    }
}
import mobi.appcent.medusa.store.*;
        import mobi.appcent.medusa.store.auth.*;
        import mobi.appcent.medusa.store.model.*;
        import mobi.appcent.medusa.store.api.AuthApi;

        import java.io.File;
        import java.util.*;

public class AuthApiExample {

    public static void main(String[] args) {

        AuthApi apiInstance = new AuthApi();
        String email = "email_example"; // String | The email to check if exists.
        try {
            StoreGetAuthEmailRes result = apiInstance.getAuthEmail(email);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthApi#getAuthEmail");
            e.printStackTrace();
        }
    }
}
import mobi.appcent.medusa.store.*;
        import mobi.appcent.medusa.store.auth.*;
        import mobi.appcent.medusa.store.model.*;
        import mobi.appcent.medusa.store.api.AuthApi;

        import java.io.File;
        import java.util.*;

public class AuthApiExample {

    public static void main(String[] args) {

        AuthApi apiInstance = new AuthApi();
        StorePostAuthReq body = new StorePostAuthReq(); // StorePostAuthReq | 
        try {
            StoreAuthRes result = apiInstance.postAuth(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AuthApi#postAuth");
            e.printStackTrace();
        }
    }
}
```

## Documentation for API Endpoints

All URIs are relative to *https://api.medusa-commerce.com/store*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AuthApi* | [**deleteAuth**](docs/AuthApi.md#deleteAuth) | **DELETE** /auth | Customer Log out
*AuthApi* | [**getAuth**](docs/AuthApi.md#getAuth) | **GET** /auth | Get Current Customer
*AuthApi* | [**getAuthEmail**](docs/AuthApi.md#getAuthEmail) | **GET** /auth/{email} | Check if email exists
*AuthApi* | [**postAuth**](docs/AuthApi.md#postAuth) | **POST** /auth | Customer Login
*CartApi* | [**deleteCartsCartDiscountsDiscount**](docs/CartApi.md#deleteCartsCartDiscountsDiscount) | **DELETE** /carts/{id}/discounts/{code} | Remove Discount
*CartApi* | [**deleteCartsCartLineItemsItem**](docs/CartApi.md#deleteCartsCartLineItemsItem) | **DELETE** /carts/{id}/line-items/{line_id} | Delete a Line Item
*CartApi* | [**deleteCartsCartPaymentSessionsSession**](docs/CartApi.md#deleteCartsCartPaymentSessionsSession) | **DELETE** /carts/{id}/payment-sessions/{provider_id} | Delete a Payment Session
*CartApi* | [**getCartsCart**](docs/CartApi.md#getCartsCart) | **GET** /carts/{id} | Get a Cart
*CartApi* | [**postCart**](docs/CartApi.md#postCart) | **POST** /carts | Create a Cart
*CartApi* | [**postCartsCart**](docs/CartApi.md#postCartsCart) | **POST** /carts/{id} | Update a Cart
*CartApi* | [**postCartsCartComplete**](docs/CartApi.md#postCartsCartComplete) | **POST** /carts/{id}/complete | Complete a Cart
*CartApi* | [**postCartsCartLineItems**](docs/CartApi.md#postCartsCartLineItems) | **POST** /carts/{id}/line-items | Add a Line Item
*CartApi* | [**postCartsCartLineItemsItem**](docs/CartApi.md#postCartsCartLineItemsItem) | **POST** /carts/{id}/line-items/{line_id} | Update a Line Item
*CartApi* | [**postCartsCartPaymentSession**](docs/CartApi.md#postCartsCartPaymentSession) | **POST** /carts/{id}/payment-session | Select a Payment Session
*CartApi* | [**postCartsCartPaymentSessionUpdate**](docs/CartApi.md#postCartsCartPaymentSessionUpdate) | **POST** /carts/{id}/payment-sessions/{provider_id} | Update a Payment Session
*CartApi* | [**postCartsCartPaymentSessions**](docs/CartApi.md#postCartsCartPaymentSessions) | **POST** /carts/{id}/payment-sessions | Create Payment Sessions
*CartApi* | [**postCartsCartPaymentSessionsSession**](docs/CartApi.md#postCartsCartPaymentSessionsSession) | **POST** /carts/{id}/payment-sessions/{provider_id}/refresh | Refresh a Payment Session
*CartApi* | [**postCartsCartShippingMethod**](docs/CartApi.md#postCartsCartShippingMethod) | **POST** /carts/{id}/shipping-methods | Add a Shipping Method
*CartApi* | [**postCartsCartTaxes**](docs/CartApi.md#postCartsCartTaxes) | **POST** /carts/{id}/taxes | Calculate Cart Taxes
*CollectionApi* | [**getCollections**](docs/CollectionApi.md#getCollections) | **GET** /collections | List Collections
*CollectionApi* | [**getCollectionsCollection**](docs/CollectionApi.md#getCollectionsCollection) | **GET** /collections/{id} | Get a Collection
*CustomerApi* | [**deleteCustomersCustomerAddressesAddress**](docs/CustomerApi.md#deleteCustomersCustomerAddressesAddress) | **DELETE** /customers/me/addresses/{address_id} | Delete an Address
*CustomerApi* | [**getCustomersCustomer**](docs/CustomerApi.md#getCustomersCustomer) | **GET** /customers/me | Get a Customer
*CustomerApi* | [**getCustomersCustomerOrders**](docs/CustomerApi.md#getCustomersCustomerOrders) | **GET** /customers/me/orders | List Orders
*CustomerApi* | [**getCustomersCustomerPaymentMethods**](docs/CustomerApi.md#getCustomersCustomerPaymentMethods) | **GET** /customers/me/payment-methods | Get Payment Methods
*CustomerApi* | [**postCustomers**](docs/CustomerApi.md#postCustomers) | **POST** /customers | Create a Customer
*CustomerApi* | [**postCustomersCustomer**](docs/CustomerApi.md#postCustomersCustomer) | **POST** /customers/me | Update Customer
*CustomerApi* | [**postCustomersCustomerAddresses**](docs/CustomerApi.md#postCustomersCustomerAddresses) | **POST** /customers/me/addresses | Add a Shipping Address
*CustomerApi* | [**postCustomersCustomerAddressesAddress**](docs/CustomerApi.md#postCustomersCustomerAddressesAddress) | **POST** /customers/me/addresses/{address_id} | Update a Shipping Address
*CustomerApi* | [**postCustomersCustomerPasswordToken**](docs/CustomerApi.md#postCustomersCustomerPasswordToken) | **POST** /customers/password-token | Request Password Reset
*CustomerApi* | [**postCustomersResetPassword**](docs/CustomerApi.md#postCustomersResetPassword) | **POST** /customers/password-reset | Reset Password
*GiftCardApi* | [**getGiftCardsCode**](docs/GiftCardApi.md#getGiftCardsCode) | **GET** /gift-cards/{code} | Get Gift Card by Code
*InviteApi* | [**postOrdersCustomerOrderClaim**](docs/InviteApi.md#postOrdersCustomerOrderClaim) | **POST** /orders/batch/customer/token | Claim an Order
*OrderApi* | [**getOrders**](docs/OrderApi.md#getOrders) | **GET** /orders | Look Up an Order
*OrderApi* | [**getOrdersOrder**](docs/OrderApi.md#getOrdersOrder) | **GET** /orders/{id} | Get an Order
*OrderApi* | [**getOrdersOrderCartId**](docs/OrderApi.md#getOrdersOrderCartId) | **GET** /orders/cart/{cart_id} | Get by Cart ID
*OrderApi* | [**postOrdersCustomerOrderClaimsCustomerOrderClaimAccept**](docs/OrderApi.md#postOrdersCustomerOrderClaimsCustomerOrderClaimAccept) | **POST** /orders/customer/confirm | Verify an Order Claim
*OrderEditApi* | [**getOrderEditsOrderEdit**](docs/OrderEditApi.md#getOrderEditsOrderEdit) | **GET** /order-edits/{id} | Retrieve an OrderEdit
*OrderEditApi* | [**postOrderEditsOrderEditComplete**](docs/OrderEditApi.md#postOrderEditsOrderEditComplete) | **POST** /order-edits/{id}/complete | Completes an OrderEdit
*OrderEditApi* | [**postOrderEditsOrderEditDecline**](docs/OrderEditApi.md#postOrderEditsOrderEditDecline) | **POST** /order-edits/{id}/decline | Decline an OrderEdit
*PaymentCollectionApi* | [**getPaymentCollectionsPaymentCollection**](docs/PaymentCollectionApi.md#getPaymentCollectionsPaymentCollection) | **GET** /payment-collections/{id} | Get a PaymentCollection
*PaymentCollectionApi* | [**postPaymentCollectionsPaymentCollectionPaymentSessionsSession**](docs/PaymentCollectionApi.md#postPaymentCollectionsPaymentCollectionPaymentSessionsSession) | **POST** /payment-collections/{id}/sessions/{session_id} | Refresh a Payment Session
*PaymentCollectionApi* | [**postPaymentCollectionsPaymentCollectionSessionsBatch**](docs/PaymentCollectionApi.md#postPaymentCollectionsPaymentCollectionSessionsBatch) | **POST** /payment-collections/{id}/sessions/batch | Manage Payment Sessions
*PaymentCollectionApi* | [**postPaymentCollectionsSessions**](docs/PaymentCollectionApi.md#postPaymentCollectionsSessions) | **POST** /payment-collections/{id}/sessions | Manage a Payment Session
*PaymentCollectionApi* | [**postPaymentCollectionsSessionsBatchAuthorize**](docs/PaymentCollectionApi.md#postPaymentCollectionsSessionsBatchAuthorize) | **POST** /payment-collections/{id}/sessions/batch/authorize | Authorize PaymentSessions
*PaymentCollectionApi* | [**postPaymentCollectionsSessionsSessionAuthorize**](docs/PaymentCollectionApi.md#postPaymentCollectionsSessionsSessionAuthorize) | **POST** /payment-collections/{id}/sessions/{session_id}/authorize | Authorize Payment Session
*ProductApi* | [**getProducts**](docs/ProductApi.md#getProducts) | **GET** /products | List Products
*ProductApi* | [**getProductsProduct**](docs/ProductApi.md#getProductsProduct) | **GET** /products/{id} | Get a Product
*ProductApi* | [**postProductsSearch**](docs/ProductApi.md#postProductsSearch) | **POST** /products/search | Search Products
*ProductCategoryApi* | [**getProductCategories**](docs/ProductCategoryApi.md#getProductCategories) | **GET** /product-categories | List Product Categories
*ProductCategoryApi* | [**getProductCategoriesCategory**](docs/ProductCategoryApi.md#getProductCategoriesCategory) | **GET** /product-categories/{id} | Get a Product Category
*ProductTagApi* | [**getProductTags**](docs/ProductTagApi.md#getProductTags) | **GET** /product-tags | List Product Tags
*ProductTypeApi* | [**getProductTypes**](docs/ProductTypeApi.md#getProductTypes) | **GET** /product-types | List Product Types
*ProductVariantApi* | [**getVariants**](docs/ProductVariantApi.md#getVariants) | **GET** /variants | Get Product Variants
*ProductVariantApi* | [**getVariantsVariant**](docs/ProductVariantApi.md#getVariantsVariant) | **GET** /variants/{variant_id} | Get a Product Variant
*RegionApi* | [**getRegions**](docs/RegionApi.md#getRegions) | **GET** /regions | List Regions
*RegionApi* | [**getRegionsRegion**](docs/RegionApi.md#getRegionsRegion) | **GET** /regions/{id} | Get a Region
*ReturnApi* | [**postReturns**](docs/ReturnApi.md#postReturns) | **POST** /returns | Create Return
*ReturnReasonApi* | [**getReturnReasons**](docs/ReturnReasonApi.md#getReturnReasons) | **GET** /return-reasons | List Return Reasons
*ReturnReasonApi* | [**getReturnReasonsReason**](docs/ReturnReasonApi.md#getReturnReasonsReason) | **GET** /return-reasons/{id} | Get a Return Reason
*ShippingOptionApi* | [**getShippingOptions**](docs/ShippingOptionApi.md#getShippingOptions) | **GET** /shipping-options | Get Shipping Options
*ShippingOptionApi* | [**getShippingOptionsCartId**](docs/ShippingOptionApi.md#getShippingOptionsCartId) | **GET** /shipping-options/{cart_id} | List for Cart
*SwapApi* | [**getSwapsSwapCartId**](docs/SwapApi.md#getSwapsSwapCartId) | **GET** /swaps/{cart_id} | Get by Cart ID
*SwapApi* | [**postSwaps**](docs/SwapApi.md#postSwaps) | **POST** /swaps | Create a Swap

## Documentation for Models

 - [Address](docs/Address.md)
 - [AddressFields](docs/AddressFields.md)
 - [AllOfBatchJobResult](docs/AllOfBatchJobResult.md)
 - [AllOfCreateStockLocationInputAddress](docs/AllOfCreateStockLocationInputAddress.md)
 - [AllOfStockLocationDTOAddress](docs/AllOfStockLocationDTOAddress.md)
 - [AllOfStorePostCustomersCustomerAddressesReqAddress](docs/AllOfStorePostCustomersCustomerAddressesReqAddress.md)
 - [AllOfUpdateStockLocationInputAddress](docs/AllOfUpdateStockLocationInputAddress.md)
 - [AnyOfStorePostCartsCartReqBillingAddress](docs/AnyOfStorePostCartsCartReqBillingAddress.md)
 - [AnyOfStorePostCartsCartReqShippingAddress](docs/AnyOfStorePostCartsCartReqShippingAddress.md)
 - [AnyOfStorePostCustomersCustomerReqBillingAddress](docs/AnyOfStorePostCustomersCustomerReqBillingAddress.md)
 - [BatchJob](docs/BatchJob.md)
 - [CanceledAt](docs/CanceledAt.md)
 - [Cart](docs/Cart.md)
 - [ClaimImage](docs/ClaimImage.md)
 - [ClaimItem](docs/ClaimItem.md)
 - [ClaimOrder](docs/ClaimOrder.md)
 - [ClaimTag](docs/ClaimTag.md)
 - [Country](docs/Country.md)
 - [CreateStockLocationInput](docs/CreateStockLocationInput.md)
 - [CreatedAt](docs/CreatedAt.md)
 - [CreatedAt1](docs/CreatedAt1.md)
 - [CreatedAt2](docs/CreatedAt2.md)
 - [CreatedAt3](docs/CreatedAt3.md)
 - [CreatedAt4](docs/CreatedAt4.md)
 - [CreatedAt5](docs/CreatedAt5.md)
 - [Currency](docs/Currency.md)
 - [CustomShippingOption](docs/CustomShippingOption.md)
 - [Customer](docs/Customer.md)
 - [CustomerGroup](docs/CustomerGroup.md)
 - [Discount](docs/Discount.md)
 - [DiscountCondition](docs/DiscountCondition.md)
 - [DiscountConditionCustomerGroup](docs/DiscountConditionCustomerGroup.md)
 - [DiscountConditionProduct](docs/DiscountConditionProduct.md)
 - [DiscountConditionProductCollection](docs/DiscountConditionProductCollection.md)
 - [DiscountConditionProductTag](docs/DiscountConditionProductTag.md)
 - [DiscountConditionProductType](docs/DiscountConditionProductType.md)
 - [DiscountRule](docs/DiscountRule.md)
 - [DraftOrder](docs/DraftOrder.md)
 - [Error](docs/Error.md)
 - [Fulfillment](docs/Fulfillment.md)
 - [FulfillmentItem](docs/FulfillmentItem.md)
 - [FulfillmentProvider](docs/FulfillmentProvider.md)
 - [GiftCard](docs/GiftCard.md)
 - [GiftCardTransaction](docs/GiftCardTransaction.md)
 - [Id](docs/Id.md)
 - [IdempotencyKey](docs/IdempotencyKey.md)
 - [Image](docs/Image.md)
 - [InlineResponse200](docs/InlineResponse200.md)
 - [InlineResponse400](docs/InlineResponse400.md)
 - [InlineResponse422](docs/InlineResponse422.md)
 - [InventoryItemDTO](docs/InventoryItemDTO.md)
 - [InventoryLevelDTO](docs/InventoryLevelDTO.md)
 - [InventoryQuantity](docs/InventoryQuantity.md)
 - [Invite](docs/Invite.md)
 - [LineItem](docs/LineItem.md)
 - [LineItemAdjustment](docs/LineItemAdjustment.md)
 - [LineItemTaxLine](docs/LineItemTaxLine.md)
 - [ModelReturn](docs/ModelReturn.md)
 - [MoneyAmount](docs/MoneyAmount.md)
 - [MultipleErrors](docs/MultipleErrors.md)
 - [Note](docs/Note.md)
 - [Notification](docs/Notification.md)
 - [NotificationProvider](docs/NotificationProvider.md)
 - [OAuth](docs/OAuth.md)
 - [OneOfStoreCompleteCartResData](docs/OneOfStoreCompleteCartResData.md)
 - [Order](docs/Order.md)
 - [OrderEdit](docs/OrderEdit.md)
 - [OrderItemChange](docs/OrderItemChange.md)
 - [Payment](docs/Payment.md)
 - [PaymentCollection](docs/PaymentCollection.md)
 - [PaymentProvider](docs/PaymentProvider.md)
 - [PaymentSession](docs/PaymentSession.md)
 - [PriceList](docs/PriceList.md)
 - [PricedProduct](docs/PricedProduct.md)
 - [PricedVariant](docs/PricedVariant.md)
 - [PricedVariantTaxRates](docs/PricedVariantTaxRates.md)
 - [Product](docs/Product.md)
 - [ProductCategory](docs/ProductCategory.md)
 - [ProductCollection](docs/ProductCollection.md)
 - [ProductOption](docs/ProductOption.md)
 - [ProductOptionValue](docs/ProductOptionValue.md)
 - [ProductTag](docs/ProductTag.md)
 - [ProductTaxRate](docs/ProductTaxRate.md)
 - [ProductType](docs/ProductType.md)
 - [ProductTypeTaxRate](docs/ProductTypeTaxRate.md)
 - [ProductVariant](docs/ProductVariant.md)
 - [ProductVariantInventoryItem](docs/ProductVariantInventoryItem.md)
 - [PublishableApiKey](docs/PublishableApiKey.md)
 - [PublishableApiKeySalesChannel](docs/PublishableApiKeySalesChannel.md)
 - [Refund](docs/Refund.md)
 - [Region](docs/Region.md)
 - [ReservationItemDTO](docs/ReservationItemDTO.md)
 - [ReturnItem](docs/ReturnItem.md)
 - [ReturnReason](docs/ReturnReason.md)
 - [SalesChannel](docs/SalesChannel.md)
 - [SalesChannelLocation](docs/SalesChannelLocation.md)
 - [ShippingAddress](docs/ShippingAddress.md)
 - [ShippingMethod](docs/ShippingMethod.md)
 - [ShippingMethodTaxLine](docs/ShippingMethodTaxLine.md)
 - [ShippingOption](docs/ShippingOption.md)
 - [ShippingOptionRequirement](docs/ShippingOptionRequirement.md)
 - [ShippingProfile](docs/ShippingProfile.md)
 - [ShippingTaxRate](docs/ShippingTaxRate.md)
 - [StagedJob](docs/StagedJob.md)
 - [StockLocationAddressDTO](docs/StockLocationAddressDTO.md)
 - [StockLocationAddressInput](docs/StockLocationAddressInput.md)
 - [StockLocationDTO](docs/StockLocationDTO.md)
 - [Store](docs/Store.md)
 - [StoreAuthRes](docs/StoreAuthRes.md)
 - [StoreCartsRes](docs/StoreCartsRes.md)
 - [StoreCollectionsListRes](docs/StoreCollectionsListRes.md)
 - [StoreCollectionsRes](docs/StoreCollectionsRes.md)
 - [StoreCompleteCartRes](docs/StoreCompleteCartRes.md)
 - [StoreCustomersListOrdersRes](docs/StoreCustomersListOrdersRes.md)
 - [StoreCustomersListPaymentMethodsRes](docs/StoreCustomersListPaymentMethodsRes.md)
 - [StoreCustomersListPaymentMethodsResPaymentMethods](docs/StoreCustomersListPaymentMethodsResPaymentMethods.md)
 - [StoreCustomersRes](docs/StoreCustomersRes.md)
 - [StoreGetAuthEmailRes](docs/StoreGetAuthEmailRes.md)
 - [StoreGetProductCategoriesCategoryRes](docs/StoreGetProductCategoriesCategoryRes.md)
 - [StoreGiftCardsRes](docs/StoreGiftCardsRes.md)
 - [StoreOrderEditsRes](docs/StoreOrderEditsRes.md)
 - [StoreOrdersRes](docs/StoreOrdersRes.md)
 - [StorePaymentCollectionSessionsReq](docs/StorePaymentCollectionSessionsReq.md)
 - [StorePaymentCollectionsRes](docs/StorePaymentCollectionsRes.md)
 - [StorePaymentCollectionsSessionRes](docs/StorePaymentCollectionsSessionRes.md)
 - [StorePostAuthReq](docs/StorePostAuthReq.md)
 - [StorePostCartReq](docs/StorePostCartReq.md)
 - [StorePostCartReqItems](docs/StorePostCartReqItems.md)
 - [StorePostCartsCartLineItemsItemReq](docs/StorePostCartsCartLineItemsItemReq.md)
 - [StorePostCartsCartLineItemsReq](docs/StorePostCartsCartLineItemsReq.md)
 - [StorePostCartsCartPaymentSessionReq](docs/StorePostCartsCartPaymentSessionReq.md)
 - [StorePostCartsCartPaymentSessionUpdateReq](docs/StorePostCartsCartPaymentSessionUpdateReq.md)
 - [StorePostCartsCartReq](docs/StorePostCartsCartReq.md)
 - [StorePostCartsCartReqDiscounts](docs/StorePostCartsCartReqDiscounts.md)
 - [StorePostCartsCartReqGiftCards](docs/StorePostCartsCartReqGiftCards.md)
 - [StorePostCartsCartShippingMethodReq](docs/StorePostCartsCartShippingMethodReq.md)
 - [StorePostCustomersCustomerAcceptClaimReq](docs/StorePostCustomersCustomerAcceptClaimReq.md)
 - [StorePostCustomersCustomerAddressesAddressReq](docs/StorePostCustomersCustomerAddressesAddressReq.md)
 - [StorePostCustomersCustomerAddressesReq](docs/StorePostCustomersCustomerAddressesReq.md)
 - [StorePostCustomersCustomerOrderClaimReq](docs/StorePostCustomersCustomerOrderClaimReq.md)
 - [StorePostCustomersCustomerPasswordTokenReq](docs/StorePostCustomersCustomerPasswordTokenReq.md)
 - [StorePostCustomersCustomerReq](docs/StorePostCustomersCustomerReq.md)
 - [StorePostCustomersReq](docs/StorePostCustomersReq.md)
 - [StorePostCustomersResetPasswordReq](docs/StorePostCustomersResetPasswordReq.md)
 - [StorePostOrderEditsOrderEditDecline](docs/StorePostOrderEditsOrderEditDecline.md)
 - [StorePostPaymentCollectionsBatchSessionsAuthorizeReq](docs/StorePostPaymentCollectionsBatchSessionsAuthorizeReq.md)
 - [StorePostPaymentCollectionsBatchSessionsReq](docs/StorePostPaymentCollectionsBatchSessionsReq.md)
 - [StorePostPaymentCollectionsBatchSessionsReqSessions](docs/StorePostPaymentCollectionsBatchSessionsReqSessions.md)
 - [StorePostReturnsReq](docs/StorePostReturnsReq.md)
 - [StorePostReturnsReqItems](docs/StorePostReturnsReqItems.md)
 - [StorePostReturnsReqReturnShipping](docs/StorePostReturnsReqReturnShipping.md)
 - [StorePostSearchRes](docs/StorePostSearchRes.md)
 - [StorePostSwapsReq](docs/StorePostSwapsReq.md)
 - [StorePostSwapsReqAdditionalItems](docs/StorePostSwapsReqAdditionalItems.md)
 - [StorePostSwapsReqReturnItems](docs/StorePostSwapsReqReturnItems.md)
 - [StoreProductCategoriesListRes](docs/StoreProductCategoriesListRes.md)
 - [StoreProductTypesListRes](docs/StoreProductTypesListRes.md)
 - [StoreProductsListRes](docs/StoreProductsListRes.md)
 - [StoreProductsRes](docs/StoreProductsRes.md)
 - [StoreRegionsListRes](docs/StoreRegionsListRes.md)
 - [StoreRegionsRes](docs/StoreRegionsRes.md)
 - [StoreReturnReasonsListRes](docs/StoreReturnReasonsListRes.md)
 - [StoreReturnReasonsRes](docs/StoreReturnReasonsRes.md)
 - [StoreReturnsRes](docs/StoreReturnsRes.md)
 - [StoreShippingOptionsListRes](docs/StoreShippingOptionsListRes.md)
 - [StoreSwapsRes](docs/StoreSwapsRes.md)
 - [StoreVariantsListRes](docs/StoreVariantsListRes.md)
 - [StoreVariantsRes](docs/StoreVariantsRes.md)
 - [Swap](docs/Swap.md)
 - [TaxLine](docs/TaxLine.md)
 - [TaxProvider](docs/TaxProvider.md)
 - [TaxRate](docs/TaxRate.md)
 - [Title](docs/Title.md)
 - [TrackingLink](docs/TrackingLink.md)
 - [UpdateStockLocationInput](docs/UpdateStockLocationInput.md)
 - [UpdatedAt](docs/UpdatedAt.md)
 - [UpdatedAt1](docs/UpdatedAt1.md)
 - [UpdatedAt2](docs/UpdatedAt2.md)
 - [UpdatedAt3](docs/UpdatedAt3.md)
 - [UpdatedAt4](docs/UpdatedAt4.md)
 - [UpdatedAt5](docs/UpdatedAt5.md)
 - [User](docs/User.md)

## Documentation for Authorization

Authentication schemes defined for the API:
### cookie_auth

- **Type**: API key
- **API key parameter name**: connect.sid
- **Location**: URL query string


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


