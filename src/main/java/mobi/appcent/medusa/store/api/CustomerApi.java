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


import mobi.appcent.medusa.store.model.request.customer.*;

public class CustomerApi {
    private MedusaSdkClient medusaSdkClient;

    public static CustomerApi getInstance() {
        return new CustomerApi();
    }

    public MedusaSdkClient getApiClient() {
        return medusaSdkClient;
    }

    public void setApiClient(MedusaSdkClient medusaSdkClient) {
        this.medusaSdkClient = medusaSdkClient;
    }

    /**
     * Delete an Address
     * Removes an Address from the Customer&#x27;s saved addresses.
     *
     * @param addressId The id of the Address to remove. (required)
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DeleteAddressRequest deleteAddressRequest(String addressId) throws ApiException {
        return new DeleteAddressRequest(medusaSdkClient, addressId);
    }

    /**
     * Get a Customer
     * Retrieves a Customer - the Customer must be logged in to retrieve their details.
     *
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetCustomerRequest getCustomer() throws ApiException {
        return new GetCustomerRequest(medusaSdkClient);
    }

    /**
     * List Orders
     * Retrieves a list of a Customer&#x27;s Orders.
     * q Query used for searching orders. (optional)
     * id Id of the order to search for. (optional)
     * status Status to search for. (optional)
     * fulfillmentStatus Fulfillment status to search for. (optional)
     * paymentStatus Payment status to search for. (optional)
     * displayId Display id to search for. (optional)
     * cartId to search for. (optional)
     * email to search for. (optional)
     * regionId to search for. (optional)
     * currencyCode The 3 character ISO currency code to set prices based on. (optional)
     * taxRate to search for. (optional)
     * createdAt Date comparison for when resulting collections were created. (optional)
     * updatedAt Date comparison for when resulting collections were updated. (optional)
     * canceledAt Date comparison for when resulting collections were canceled. (optional)
     * limit How many orders to return. (optional, default to 10)
     * offset The offset in the resulting orders. (optional, default to 0)
     * fields (Comma separated string) Which fields should be included in the resulting orders. (optional)
     * expand (Comma separated string) Which relations should be expanded in the resulting orders. (optional)
     *
     * @return StoreCustomersListOrdersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ListOrdersRequest listOrders() throws ApiException {
        return new ListOrdersRequest(medusaSdkClient);
    }

    /**
     * Get Payment Methods
     * Retrieves a list of a Customer&#x27;s saved payment methods. Payment methods are saved with Payment Providers and it is their responsibility to fetch saved methods.
     *
     * @return StoreCustomersListPaymentMethodsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetPaymentMethodsRequest getPaymentMethods() throws ApiException {
        return new GetPaymentMethodsRequest(medusaSdkClient);
    }

    /**
     * Create a Customer
     * Creates a Customer account.
     * body  (optional)
     *
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CreateCustomerRequest createCustomer() throws ApiException {
        return new CreateCustomerRequest(medusaSdkClient);
    }

    /**
     * Update Customer
     * Updates a Customer&#x27;s saved details.
     * body  (optional)
     *
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UpdateCustomerRequest updateCustomer() throws ApiException {
        return new UpdateCustomerRequest(medusaSdkClient);
    }

    /**
     * Add a Shipping Address
     * Adds a Shipping Address to a Customer&#x27;s saved addresses.
     * body  (optional)
     *
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AddShippingAddress addShippingAddress() throws ApiException {
        return new AddShippingAddress(medusaSdkClient);
    }

    /**
     * Update a Shipping Address
     * Updates a Customer&#x27;s saved Shipping Address.
     *
     * @param addressId The id of the Address to update. (required)
     *                  body  (optional)
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UpdateShippingAddressRequest updateShippingAddress(String addressId) throws ApiException {
        return new UpdateShippingAddressRequest(medusaSdkClient, addressId);
    }

    /**
     * Request Password Reset
     * Creates a reset password token to be used in a subsequent /reset-password request. The password token should be sent out of band e.g. via email and will not be returned.
     * body  (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PasswordResetRequest passwordResetRequest() throws ApiException {
        return new PasswordResetRequest(medusaSdkClient);
    }


    /**
     * Reset Password
     * Resets a Customer&#x27;s password using a password token created by a previous /password-token request.
     * body (optional)
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResetPasswordRequest resetPassword() throws ApiException {
        return new ResetPasswordRequest(medusaSdkClient);
    }


}
