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

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import mobi.appcent.medusa.store.model.response.CanceledAt;
import mobi.appcent.medusa.store.model.response.CreatedAt1;
import mobi.appcent.medusa.store.model.response.StoreCustomersListOrdersRes;
import mobi.appcent.medusa.store.model.response.StoreCustomersListPaymentMethodsRes;
import mobi.appcent.medusa.store.model.response.StoreCustomersRes;
import mobi.appcent.medusa.store.model.response.StorePostCustomersCustomerAddressesAddressReq;
import mobi.appcent.medusa.store.model.response.StorePostCustomersCustomerAddressesReq;
import mobi.appcent.medusa.store.model.response.StorePostCustomersCustomerPasswordTokenReq;
import mobi.appcent.medusa.store.model.response.StorePostCustomersCustomerReq;
import mobi.appcent.medusa.store.model.response.StorePostCustomersReq;
import mobi.appcent.medusa.store.model.response.StorePostCustomersResetPasswordReq;
import mobi.appcent.medusa.store.model.response.UpdatedAt1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Build call for deleteCustomersCustomerAddressesAddress
     * @param addressId The id of the Address to remove. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteCustomersCustomerAddressesAddressCall(String addressId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/customers/me/addresses/{address_id}"
            .replaceAll("\\{" + "address_id" + "\\}", medusaSdkClient.escapeString(addressId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = medusaSdkClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = medusaSdkClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaSdkClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "cookie_auth" };
        return medusaSdkClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteCustomersCustomerAddressesAddressValidateBeforeCall(String addressId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'addressId' is set
        if (addressId == null) {
            throw new ApiException("Missing the required parameter 'addressId' when calling deleteCustomersCustomerAddressesAddress(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteCustomersCustomerAddressesAddressCall(addressId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete an Address
     * Removes an Address from the Customer&#x27;s saved addresses.
     * @param addressId The id of the Address to remove. (required)
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCustomersRes deleteCustomersCustomerAddressesAddress(String addressId) throws ApiException {
        ApiResponse<StoreCustomersRes> resp = deleteCustomersCustomerAddressesAddressWithHttpInfo(addressId);
        return resp.getData();
    }

    /**
     * Delete an Address
     * Removes an Address from the Customer&#x27;s saved addresses.
     * @param addressId The id of the Address to remove. (required)
     * @return ApiResponse&lt;StoreCustomersRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCustomersRes> deleteCustomersCustomerAddressesAddressWithHttpInfo(String addressId) throws ApiException {
        com.squareup.okhttp.Call call = deleteCustomersCustomerAddressesAddressValidateBeforeCall(addressId, null, null);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Delete an Address (asynchronously)
     * Removes an Address from the Customer&#x27;s saved addresses.
     * @param addressId The id of the Address to remove. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteCustomersCustomerAddressesAddressAsync(String addressId, final ApiCallback<StoreCustomersRes> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteCustomersCustomerAddressesAddressValidateBeforeCall(addressId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCustomersCustomer
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCustomersCustomerCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/customers/me";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = medusaSdkClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = medusaSdkClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaSdkClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "cookie_auth" };
        return medusaSdkClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCustomersCustomerValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = getCustomersCustomerCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a Customer
     * Retrieves a Customer - the Customer must be logged in to retrieve their details.
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCustomersRes getCustomersCustomer() throws ApiException {
        ApiResponse<StoreCustomersRes> resp = getCustomersCustomerWithHttpInfo();
        return resp.getData();
    }

    /**
     * Get a Customer
     * Retrieves a Customer - the Customer must be logged in to retrieve their details.
     * @return ApiResponse&lt;StoreCustomersRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCustomersRes> getCustomersCustomerWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = getCustomersCustomerValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Get a Customer (asynchronously)
     * Retrieves a Customer - the Customer must be logged in to retrieve their details.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCustomersCustomerAsync(final ApiCallback<StoreCustomersRes> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCustomersCustomerValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCustomersCustomerOrders
     * @param q Query used for searching orders. (optional)
     * @param id Id of the order to search for. (optional)
     * @param status Status to search for. (optional)
     * @param fulfillmentStatus Fulfillment status to search for. (optional)
     * @param paymentStatus Payment status to search for. (optional)
     * @param displayId Display id to search for. (optional)
     * @param cartId to search for. (optional)
     * @param email to search for. (optional)
     * @param regionId to search for. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. (optional)
     * @param taxRate to search for. (optional)
     * @param createdAt Date comparison for when resulting collections were created. (optional)
     * @param updatedAt Date comparison for when resulting collections were updated. (optional)
     * @param canceledAt Date comparison for when resulting collections were canceled. (optional)
     * @param limit How many orders to return. (optional, default to 10)
     * @param offset The offset in the resulting orders. (optional, default to 0)
     * @param fields (Comma separated string) Which fields should be included in the resulting orders. (optional)
     * @param expand (Comma separated string) Which relations should be expanded in the resulting orders. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCustomersCustomerOrdersCall(String q, String id, List<String> status, List<String> fulfillmentStatus, List<String> paymentStatus, String displayId, String cartId, String email, String regionId, String currencyCode, String taxRate, CreatedAt1 createdAt, UpdatedAt1 updatedAt, CanceledAt canceledAt, Integer limit, Integer offset, String fields, String expand, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/customers/me/orders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (q != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("q", q));
        if (id != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("id", id));
        if (status != null)
        localVarCollectionQueryParams.addAll(medusaSdkClient.parameterToPairs("csv", "status", status));
        if (fulfillmentStatus != null)
        localVarCollectionQueryParams.addAll(medusaSdkClient.parameterToPairs("csv", "fulfillment_status", fulfillmentStatus));
        if (paymentStatus != null)
        localVarCollectionQueryParams.addAll(medusaSdkClient.parameterToPairs("csv", "payment_status", paymentStatus));
        if (displayId != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("display_id", displayId));
        if (cartId != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("cart_id", cartId));
        if (email != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("email", email));
        if (regionId != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("region_id", regionId));
        if (currencyCode != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("currency_code", currencyCode));
        if (taxRate != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("tax_rate", taxRate));
        if (createdAt != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("created_at", createdAt));
        if (updatedAt != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("updated_at", updatedAt));
        if (canceledAt != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("canceled_at", canceledAt));
        if (limit != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("limit", limit));
        if (offset != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("offset", offset));
        if (fields != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("fields", fields));
        if (expand != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("expand", expand));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = medusaSdkClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = medusaSdkClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaSdkClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "cookie_auth" };
        return medusaSdkClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCustomersCustomerOrdersValidateBeforeCall(String q, String id, List<String> status, List<String> fulfillmentStatus, List<String> paymentStatus, String displayId, String cartId, String email, String regionId, String currencyCode, String taxRate, CreatedAt1 createdAt, UpdatedAt1 updatedAt, CanceledAt canceledAt, Integer limit, Integer offset, String fields, String expand, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = getCustomersCustomerOrdersCall(q, id, status, fulfillmentStatus, paymentStatus, displayId, cartId, email, regionId, currencyCode, taxRate, createdAt, updatedAt, canceledAt, limit, offset, fields, expand, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List Orders
     * Retrieves a list of a Customer&#x27;s Orders.
     * @param q Query used for searching orders. (optional)
     * @param id Id of the order to search for. (optional)
     * @param status Status to search for. (optional)
     * @param fulfillmentStatus Fulfillment status to search for. (optional)
     * @param paymentStatus Payment status to search for. (optional)
     * @param displayId Display id to search for. (optional)
     * @param cartId to search for. (optional)
     * @param email to search for. (optional)
     * @param regionId to search for. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. (optional)
     * @param taxRate to search for. (optional)
     * @param createdAt Date comparison for when resulting collections were created. (optional)
     * @param updatedAt Date comparison for when resulting collections were updated. (optional)
     * @param canceledAt Date comparison for when resulting collections were canceled. (optional)
     * @param limit How many orders to return. (optional, default to 10)
     * @param offset The offset in the resulting orders. (optional, default to 0)
     * @param fields (Comma separated string) Which fields should be included in the resulting orders. (optional)
     * @param expand (Comma separated string) Which relations should be expanded in the resulting orders. (optional)
     * @return StoreCustomersListOrdersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCustomersListOrdersRes getCustomersCustomerOrders(String q, String id, List<String> status, List<String> fulfillmentStatus, List<String> paymentStatus, String displayId, String cartId, String email, String regionId, String currencyCode, String taxRate, CreatedAt1 createdAt, UpdatedAt1 updatedAt, CanceledAt canceledAt, Integer limit, Integer offset, String fields, String expand) throws ApiException {
        ApiResponse<StoreCustomersListOrdersRes> resp = getCustomersCustomerOrdersWithHttpInfo(q, id, status, fulfillmentStatus, paymentStatus, displayId, cartId, email, regionId, currencyCode, taxRate, createdAt, updatedAt, canceledAt, limit, offset, fields, expand);
        return resp.getData();
    }

    /**
     * List Orders
     * Retrieves a list of a Customer&#x27;s Orders.
     * @param q Query used for searching orders. (optional)
     * @param id Id of the order to search for. (optional)
     * @param status Status to search for. (optional)
     * @param fulfillmentStatus Fulfillment status to search for. (optional)
     * @param paymentStatus Payment status to search for. (optional)
     * @param displayId Display id to search for. (optional)
     * @param cartId to search for. (optional)
     * @param email to search for. (optional)
     * @param regionId to search for. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. (optional)
     * @param taxRate to search for. (optional)
     * @param createdAt Date comparison for when resulting collections were created. (optional)
     * @param updatedAt Date comparison for when resulting collections were updated. (optional)
     * @param canceledAt Date comparison for when resulting collections were canceled. (optional)
     * @param limit How many orders to return. (optional, default to 10)
     * @param offset The offset in the resulting orders. (optional, default to 0)
     * @param fields (Comma separated string) Which fields should be included in the resulting orders. (optional)
     * @param expand (Comma separated string) Which relations should be expanded in the resulting orders. (optional)
     * @return ApiResponse&lt;StoreCustomersListOrdersRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCustomersListOrdersRes> getCustomersCustomerOrdersWithHttpInfo(String q, String id, List<String> status, List<String> fulfillmentStatus, List<String> paymentStatus, String displayId, String cartId, String email, String regionId, String currencyCode, String taxRate, CreatedAt1 createdAt, UpdatedAt1 updatedAt, CanceledAt canceledAt, Integer limit, Integer offset, String fields, String expand) throws ApiException {
        com.squareup.okhttp.Call call = getCustomersCustomerOrdersValidateBeforeCall(q, id, status, fulfillmentStatus, paymentStatus, displayId, cartId, email, regionId, currencyCode, taxRate, createdAt, updatedAt, canceledAt, limit, offset, fields, expand, null, null);
        Type localVarReturnType = new TypeToken<StoreCustomersListOrdersRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * List Orders (asynchronously)
     * Retrieves a list of a Customer&#x27;s Orders.
     * @param q Query used for searching orders. (optional)
     * @param id Id of the order to search for. (optional)
     * @param status Status to search for. (optional)
     * @param fulfillmentStatus Fulfillment status to search for. (optional)
     * @param paymentStatus Payment status to search for. (optional)
     * @param displayId Display id to search for. (optional)
     * @param cartId to search for. (optional)
     * @param email to search for. (optional)
     * @param regionId to search for. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. (optional)
     * @param taxRate to search for. (optional)
     * @param createdAt Date comparison for when resulting collections were created. (optional)
     * @param updatedAt Date comparison for when resulting collections were updated. (optional)
     * @param canceledAt Date comparison for when resulting collections were canceled. (optional)
     * @param limit How many orders to return. (optional, default to 10)
     * @param offset The offset in the resulting orders. (optional, default to 0)
     * @param fields (Comma separated string) Which fields should be included in the resulting orders. (optional)
     * @param expand (Comma separated string) Which relations should be expanded in the resulting orders. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCustomersCustomerOrdersAsync(String q, String id, List<String> status, List<String> fulfillmentStatus, List<String> paymentStatus, String displayId, String cartId, String email, String regionId, String currencyCode, String taxRate, CreatedAt1 createdAt, UpdatedAt1 updatedAt, CanceledAt canceledAt, Integer limit, Integer offset, String fields, String expand, final ApiCallback<StoreCustomersListOrdersRes> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCustomersCustomerOrdersValidateBeforeCall(q, id, status, fulfillmentStatus, paymentStatus, displayId, cartId, email, regionId, currencyCode, taxRate, createdAt, updatedAt, canceledAt, limit, offset, fields, expand, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCustomersListOrdersRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCustomersCustomerPaymentMethods
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCustomersCustomerPaymentMethodsCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/customers/me/payment-methods";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = medusaSdkClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = medusaSdkClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaSdkClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "cookie_auth" };
        return medusaSdkClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCustomersCustomerPaymentMethodsValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = getCustomersCustomerPaymentMethodsCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get Payment Methods
     * Retrieves a list of a Customer&#x27;s saved payment methods. Payment methods are saved with Payment Providers and it is their responsibility to fetch saved methods.
     * @return StoreCustomersListPaymentMethodsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCustomersListPaymentMethodsRes getCustomersCustomerPaymentMethods() throws ApiException {
        ApiResponse<StoreCustomersListPaymentMethodsRes> resp = getCustomersCustomerPaymentMethodsWithHttpInfo();
        return resp.getData();
    }

    /**
     * Get Payment Methods
     * Retrieves a list of a Customer&#x27;s saved payment methods. Payment methods are saved with Payment Providers and it is their responsibility to fetch saved methods.
     * @return ApiResponse&lt;StoreCustomersListPaymentMethodsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCustomersListPaymentMethodsRes> getCustomersCustomerPaymentMethodsWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = getCustomersCustomerPaymentMethodsValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<StoreCustomersListPaymentMethodsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Get Payment Methods (asynchronously)
     * Retrieves a list of a Customer&#x27;s saved payment methods. Payment methods are saved with Payment Providers and it is their responsibility to fetch saved methods.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCustomersCustomerPaymentMethodsAsync(final ApiCallback<StoreCustomersListPaymentMethodsRes> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCustomersCustomerPaymentMethodsValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCustomersListPaymentMethodsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCustomers
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCustomersCall(StorePostCustomersReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/customers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = medusaSdkClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = medusaSdkClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaSdkClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return medusaSdkClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postCustomersValidateBeforeCall(StorePostCustomersReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = postCustomersCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a Customer
     * Creates a Customer account.
     * @param body  (optional)
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCustomersRes postCustomers(StorePostCustomersReq body) throws ApiException {
        ApiResponse<StoreCustomersRes> resp = postCustomersWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Create a Customer
     * Creates a Customer account.
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCustomersRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCustomersRes> postCustomersWithHttpInfo(StorePostCustomersReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCustomersValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Create a Customer (asynchronously)
     * Creates a Customer account.
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCustomersAsync(StorePostCustomersReq body, final ApiCallback<StoreCustomersRes> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postCustomersValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCustomersCustomer
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCustomersCustomerCall(StorePostCustomersCustomerReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/customers/me";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = medusaSdkClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = medusaSdkClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaSdkClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "cookie_auth" };
        return medusaSdkClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postCustomersCustomerValidateBeforeCall(StorePostCustomersCustomerReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = postCustomersCustomerCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update Customer
     * Updates a Customer&#x27;s saved details.
     * @param body  (optional)
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCustomersRes postCustomersCustomer(StorePostCustomersCustomerReq body) throws ApiException {
        ApiResponse<StoreCustomersRes> resp = postCustomersCustomerWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Update Customer
     * Updates a Customer&#x27;s saved details.
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCustomersRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCustomersRes> postCustomersCustomerWithHttpInfo(StorePostCustomersCustomerReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCustomersCustomerValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Update Customer (asynchronously)
     * Updates a Customer&#x27;s saved details.
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCustomersCustomerAsync(StorePostCustomersCustomerReq body, final ApiCallback<StoreCustomersRes> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postCustomersCustomerValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCustomersCustomerAddresses
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCustomersCustomerAddressesCall(StorePostCustomersCustomerAddressesReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/customers/me/addresses";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = medusaSdkClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = medusaSdkClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaSdkClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "cookie_auth" };
        return medusaSdkClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postCustomersCustomerAddressesValidateBeforeCall(StorePostCustomersCustomerAddressesReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = postCustomersCustomerAddressesCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Add a Shipping Address
     * Adds a Shipping Address to a Customer&#x27;s saved addresses.
     * @param body  (optional)
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCustomersRes postCustomersCustomerAddresses(StorePostCustomersCustomerAddressesReq body) throws ApiException {
        ApiResponse<StoreCustomersRes> resp = postCustomersCustomerAddressesWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Add a Shipping Address
     * Adds a Shipping Address to a Customer&#x27;s saved addresses.
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCustomersRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCustomersRes> postCustomersCustomerAddressesWithHttpInfo(StorePostCustomersCustomerAddressesReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCustomersCustomerAddressesValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Add a Shipping Address (asynchronously)
     * Adds a Shipping Address to a Customer&#x27;s saved addresses.
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCustomersCustomerAddressesAsync(StorePostCustomersCustomerAddressesReq body, final ApiCallback<StoreCustomersRes> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postCustomersCustomerAddressesValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCustomersCustomerAddressesAddress
     * @param addressId The id of the Address to update. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCustomersCustomerAddressesAddressCall(String addressId, StorePostCustomersCustomerAddressesAddressReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/customers/me/addresses/{address_id}"
            .replaceAll("\\{" + "address_id" + "\\}", medusaSdkClient.escapeString(addressId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = medusaSdkClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = medusaSdkClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaSdkClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "cookie_auth" };
        return medusaSdkClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postCustomersCustomerAddressesAddressValidateBeforeCall(String addressId, StorePostCustomersCustomerAddressesAddressReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'addressId' is set
        if (addressId == null) {
            throw new ApiException("Missing the required parameter 'addressId' when calling postCustomersCustomerAddressesAddress(Async)");
        }
        
        com.squareup.okhttp.Call call = postCustomersCustomerAddressesAddressCall(addressId, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update a Shipping Address
     * Updates a Customer&#x27;s saved Shipping Address.
     * @param addressId The id of the Address to update. (required)
     * @param body  (optional)
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCustomersRes postCustomersCustomerAddressesAddress(String addressId, StorePostCustomersCustomerAddressesAddressReq body) throws ApiException {
        ApiResponse<StoreCustomersRes> resp = postCustomersCustomerAddressesAddressWithHttpInfo(addressId, body);
        return resp.getData();
    }

    /**
     * Update a Shipping Address
     * Updates a Customer&#x27;s saved Shipping Address.
     * @param addressId The id of the Address to update. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCustomersRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCustomersRes> postCustomersCustomerAddressesAddressWithHttpInfo(String addressId, StorePostCustomersCustomerAddressesAddressReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCustomersCustomerAddressesAddressValidateBeforeCall(addressId, body, null, null);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Update a Shipping Address (asynchronously)
     * Updates a Customer&#x27;s saved Shipping Address.
     * @param addressId The id of the Address to update. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCustomersCustomerAddressesAddressAsync(String addressId, StorePostCustomersCustomerAddressesAddressReq body, final ApiCallback<StoreCustomersRes> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postCustomersCustomerAddressesAddressValidateBeforeCall(addressId, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCustomersCustomerPasswordToken
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCustomersCustomerPasswordTokenCall(StorePostCustomersCustomerPasswordTokenReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/customers/password-token";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = medusaSdkClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = medusaSdkClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaSdkClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return medusaSdkClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postCustomersCustomerPasswordTokenValidateBeforeCall(StorePostCustomersCustomerPasswordTokenReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = postCustomersCustomerPasswordTokenCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Request Password Reset
     * Creates a reset password token to be used in a subsequent /reset-password request. The password token should be sent out of band e.g. via email and will not be returned.
     * @param body  (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void postCustomersCustomerPasswordToken(StorePostCustomersCustomerPasswordTokenReq body) throws ApiException {
        postCustomersCustomerPasswordTokenWithHttpInfo(body);
    }

    /**
     * Request Password Reset
     * Creates a reset password token to be used in a subsequent /reset-password request. The password token should be sent out of band e.g. via email and will not be returned.
     * @param body  (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> postCustomersCustomerPasswordTokenWithHttpInfo(StorePostCustomersCustomerPasswordTokenReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCustomersCustomerPasswordTokenValidateBeforeCall(body, null, null);
        return medusaSdkClient.execute(call);
    }

    /**
     * Request Password Reset (asynchronously)
     * Creates a reset password token to be used in a subsequent /reset-password request. The password token should be sent out of band e.g. via email and will not be returned.
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCustomersCustomerPasswordTokenAsync(StorePostCustomersCustomerPasswordTokenReq body, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postCustomersCustomerPasswordTokenValidateBeforeCall(body, progressListener, progressRequestListener);
        medusaSdkClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for postCustomersResetPassword
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCustomersResetPasswordCall(StorePostCustomersResetPasswordReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/customers/password-reset";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/plain"
        };
        final String localVarAccept = medusaSdkClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = medusaSdkClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaSdkClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return medusaSdkClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postCustomersResetPasswordValidateBeforeCall(StorePostCustomersResetPasswordReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = postCustomersResetPasswordCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Reset Password
     * Resets a Customer&#x27;s password using a password token created by a previous /password-token request.
     * @param body  (optional)
     * @return StoreCustomersRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCustomersRes postCustomersResetPassword(StorePostCustomersResetPasswordReq body) throws ApiException {
        ApiResponse<StoreCustomersRes> resp = postCustomersResetPasswordWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Reset Password
     * Resets a Customer&#x27;s password using a password token created by a previous /password-token request.
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCustomersRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCustomersRes> postCustomersResetPasswordWithHttpInfo(StorePostCustomersResetPasswordReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCustomersResetPasswordValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Reset Password (asynchronously)
     * Resets a Customer&#x27;s password using a password token created by a previous /password-token request.
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCustomersResetPasswordAsync(StorePostCustomersResetPasswordReq body, final ApiCallback<StoreCustomersRes> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postCustomersResetPasswordValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCustomersRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
