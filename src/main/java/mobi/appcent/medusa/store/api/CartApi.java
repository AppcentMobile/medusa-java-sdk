/*
 * Medusa Storefront API
 * API reference for Medusa's Storefront endpoints. All endpoints are prefixed with `/store`.  ## Authentication  To send requests as an authenticated customer, you must use the Cookie Session ID.  <!-- ReDoc-Inject: <SecurityDefinitions> -->  ## Expanding Fields  In many endpoints you'll find an `expand` query parameter that can be passed to the endpoint. You can use the `expand` query parameter to unpack an entity's relations and return them in the response.  Please note that the relations you pass to `expand` replace any relations that are expanded by default in the request.  ### Expanding One Relation  For example, when you retrieve a product, you can retrieve its collection by passing to the `expand` query parameter the value `collection`:  ```bash curl \"http://localhost:9000/store/products/prod_01GDJGP2XPQT2N3JHZQFMH5V45?expand=collection\" ```  ### Expanding Multiple Relations  You can expand more than one relation by separating the relations in the `expand` query parameter with a comma.  For example, to retrieve both the variants and the collection of a product, pass to the `expand` query parameter the value `variants,collection`:  ```bash curl \"http://localhost:9000/store/products/prod_01GDJGP2XPQT2N3JHZQFMH5V45?expand=variants,collection\" ```  ### Prevent Expanding Relations  Some requests expand relations by default. You can prevent that by passing an empty expand value to retrieve an entity without any extra relations.  For example:  ```bash curl \"http://localhost:9000/store/products/prod_01GDJGP2XPQT2N3JHZQFMH5V45?expand\" ```  This would retrieve the product with only its properties, without any relations like `collection`.  ## Selecting Fields  In many endpoints you'll find a `fields` query parameter that can be passed to the endpoint. You can use the `fields` query parameter to specify which fields in the entity should be returned in the response.  Please note that if you pass a `fields` query parameter, only the fields you pass in the value along with the `id` of the entity will be returned in the response.  Also, the `fields` query parameter does not affect the expanded relations. You'll have to use the `expand` parameter instead.  ### Selecting One Field  For example, when you retrieve a list of products, you can retrieve only the titles of the products by passing `title` as a value to the `fields` query parameter:  ```bash curl \"http://localhost:9000/store/products?fields=title\" ```  As mentioned above, the expanded relations such as `variants` will still be returned as they're not affected by the `fields` parameter.  You can ensure that only the `title` field is returned by passing an empty value to the `expand` query parameter. For example:  ```bash curl \"http://localhost:9000/store/products?fields=title&expand\" ```  ### Selecting Multiple Fields  You can pass more than one field by seperating the field names in the `fields` query parameter with a comma.  For example, to select the `title` and `handle` of a product:  ```bash curl \"http://localhost:9000/store/products?fields=title,handle\" ```  ### Retrieve Only the ID  You can pass an empty `fields` query parameter to return only the ID of an entity. For example:  ```bash curl \"http://localhost:9000/store/products?fields\" ```  You can also pair with an empty `expand` query parameter to ensure that the relations aren't retrieved as well. For example:  ```bash curl \"http://localhost:9000/store/products?fields&expand\" ```  ## Query Parameter Types  This section covers how to pass some common data types as query parameters. This is useful if you're sending requests to the API endpoints and not using our JS Client. For example, when using cURL or Postman.  ### Strings  You can pass a string value in the form of `<parameter_name>=<value>`.  For example:  ```bash curl \"http://localhost:9000/store/products?title=Shirt\" ```  If the string has any characters other than letters and numbers, you must encode them.  For example, if the string has spaces, you can encode the space with `+` or `%20`:  ```bash curl \"http://localhost:9000/store/products?title=Blue%20Shirt\" ```  You can use tools like [this one](https://www.urlencoder.org/) to learn how a value can be encoded.  ### Integers  You can pass an integer value in the form of `<parameter_name>=<value>`.  For example:  ```bash curl \"http://localhost:9000/store/products?offset=1\" ```  ### Boolean  You can pass a boolean value in the form of `<parameter_name>=<value>`.  For example:  ```bash curl \"http://localhost:9000/store/products?is_giftcard=true\" ```  ### Date and DateTime  You can pass a date value in the form `<parameter_name>=<value>`. The date must be in the format `YYYY-MM-DD`.  For example:  ```bash curl -g \"http://localhost:9000/store/products?created_at[lt]=2023-02-17\" ```  You can also pass the time using the format `YYYY-MM-DDTHH:MM:SSZ`. Please note that the `T` and `Z` here are fixed.  For example:  ```bash curl -g \"http://localhost:9000/store/products?created_at[lt]=2023-02-17T07:22:30Z\" ```  ### Array  Each array value must be passed as a separate query parameter in the form `<parameter_name>[]=<value>`. You can also specify the index of each parameter in the brackets `<parameter_name>[0]=<value>`.  For example:  ```bash curl -g \"http://localhost:9000/store/products?sales_channel_id[]=sc_01GPGVB42PZ7N3YQEP2WDM7PC7&sales_channel_id[]=sc_234PGVB42PZ7N3YQEP2WDM7PC7\" ```  Note that the `-g` parameter passed to `curl` disables errors being thrown for using the brackets. Read more [here](https://curl.se/docs/manpage.html#-g).  ### Object  Object parameters must be passed as separate query parameters in the form `<parameter_name>[<key>]=<value>`.  For example:  ```bash curl -g \"http://localhost:9000/store/products?created_at[lt]=2023-02-17&created_at[gt]=2022-09-17\" ```  ## Pagination  ### Query Parameters  In listing endpoints, such as list customers or list products, you can control the pagination using the query parameters `limit` and `offset`.  `limit` is used to specify the maximum number of items that can be return in the response. `offset` is used to specify how many items to skip before returning the resulting entities.  You can use the `offset` query parameter to change between pages. For example, if the limit is 50, at page 1 the offset should be 0; at page 2 the offset should be 50, and so on.  For example, to limit the number of products returned in the List Products endpoint:  ```bash curl \"http://localhost:9000/store/products?limit=5\" ```  ### Response Fields  In the response of listing endpoints, aside from the entities retrieved, there are three pagination-related fields returned: `count`, `limit`, and `offset`.  Similar to the query parameters, `limit` is the maximum number of items that can be returned in the response, and `field` is the number of items that were skipped before the entities in the result.  `count` is the total number of available items of this entity. It can be used to determine how many pages are there.  For example, if the `count` is 100 and the `limit` is 50, you can divide the `count` by the `limit` to get the number of pages: `100/50 = 2 pages`. 
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package mobi.appcent.medusa.store.api;

import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.MedusaSdkClient;


import mobi.appcent.medusa.store.model.request.cart.*;

public class CartApi extends BaseApi {
    private MedusaSdkClient medusaSdkClient;

    public static CartApi getInstance() {
        return new CartApi();
    }

    public MedusaSdkClient getApiClient() {
        return medusaSdkClient;
    }

    public void setApiClient(MedusaSdkClient medusaSdkClient) {
        this.medusaSdkClient = medusaSdkClient;
    }

    /**
     * Remove Discount
     * Removes a Discount from a Cart.
     * @param id The id of the Cart. (required)
     * @param code The unique Discount code. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RemoveDiscountRequest removeDiscount(String id, String code) throws ApiException {
        return new RemoveDiscountRequest(medusaSdkClient, id, code);
    }

    /**
     * Delete a Line Item
     * Removes a Line Item from a Cart.
     * @param id The id of the Cart. (required)
     * @param lineId The id of the Line Item. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DeleteLineItemRequest deleteLineItem(String id, String lineId) throws ApiException {
        return new DeleteLineItemRequest(medusaSdkClient, id, lineId);
    }

    /**
     * Delete a Payment Session
     * Deletes a Payment Session on a Cart. May be useful if a payment has failed.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the Payment Provider used to create the Payment Session to be deleted. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DeletePaymentSessionRequest deletePaymentSession(String id, String providerId) throws ApiException {
        return new DeletePaymentSessionRequest(medusaSdkClient, id, providerId);
    }

    /**
     * Get a Cart
     * Retrieves a Cart.
     * @param id The id of the Cart. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetCartRequest getCart(String id) throws ApiException {
        return new GetCartRequest(medusaSdkClient, id);
    }

    /**
     * Create a Cart
     * Creates a Cart within the given region and with the initial items. If no &#x60;region_id&#x60; is provided the cart will be associated with the first Region available. If no items are provided the cart will be empty after creation. If a user is logged in the cart&#x27;s customer id and email will be set.
     * body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CreateCartRequest createCart() throws ApiException {
        return new CreateCartRequest(medusaSdkClient);
    }

    /**
     * Update a Cart
     * Updates a Cart.
     * @param id The id of the Cart. (required)
     * body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UpdateCartRequest updateCart(String id) throws ApiException {
        return new UpdateCartRequest(medusaSdkClient, id);
    }

    /**
     * Complete a Cart
     * Completes a cart. The following steps will be performed. Payment authorization is attempted and if more work is required, we simply return the cart for further updates. If payment is authorized and order is not yet created, we make sure to do so. The completion of a cart can be performed idempotently with a provided header &#x60;Idempotency-Key&#x60;. If not provided, we will generate one for the request.
     * @param id The Cart id. (required)
     * @return StoreCompleteCartRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CompleteCartRequest completeCart(String id) throws ApiException {
        return new CompleteCartRequest(medusaSdkClient, id);
    }

    /**
     * Add a Line Item
     * Generates a Line Item with a given Product Variant and adds it to the Cart
     * @param id The id of the Cart to add the Line Item to. (required)
     * body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AddLineItemRequest addLineItem(String id) throws ApiException {
        return new AddLineItemRequest(medusaSdkClient, id);
    }

    /**
     * Update a Line Item
     * Updates a Line Item if the desired quantity can be fulfilled.
     * @param id The id of the Cart. (required)
     * @param lineId The id of the Line Item. (required)
     * body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UpdateLineItemRequest updateLineItem(String id, String lineId) throws ApiException {
        return new UpdateLineItemRequest(medusaSdkClient, id, lineId);
    }

    /**
     * Select a Payment Session
     * Selects a Payment Session as the session intended to be used towards the completion of the Cart.
     * @param id The ID of the Cart. (required)
     * body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SelectPaymentSessionRequest selectPaymentSession(String id) throws ApiException {
        return new SelectPaymentSessionRequest(medusaSdkClient, id);
    }

    /**
     * Update a Payment Session
     * Updates a Payment Session with additional data.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the payment provider. (required)
     * body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UpdatePaymentSessionRequest updatePaymentSession(String id, String providerId) throws ApiException {
        return new UpdatePaymentSessionRequest(medusaSdkClient, id, providerId);
    }

    /**
     * Create Payment Sessions
     * Creates Payment Sessions for each of the available Payment Providers in the Cart&#x27;s Region.
     * @param id The id of the Cart. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CreatePaymentSessionsRequest createPaymentSessions(String id) throws ApiException {
        return new CreatePaymentSessionsRequest(medusaSdkClient, id);
    }

    /**
     * Refresh a Payment Session
     * Refreshes a Payment Session to ensure that it is in sync with the Cart - this is usually not necessary.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the Payment Provider that created the Payment Session to be refreshed. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RefreshPaymentSessionRequest refreshPaymentSession(String id, String providerId) throws ApiException {
        return new RefreshPaymentSessionRequest(medusaSdkClient, id, providerId);
    }

    /**
     * Add a Shipping Method
     * Adds a Shipping Method to the Cart.
     * @param id The cart ID. (required)
     * body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AddShippingMethodRequest addShippingMethod(String id) throws ApiException {
        return new AddShippingMethodRequest(medusaSdkClient, id);
    }

    /**
     * Calculate Cart Taxes
     * Calculates taxes for a cart. Depending on the cart&#x27;s region this may involve making 3rd party API calls to a Tax Provider service.
     * @param id The Cart ID. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CalculateCartTaxesRequest calculateCartTaxes(String id) throws ApiException {
        return new CalculateCartTaxesRequest(medusaSdkClient, id);
    }
}
