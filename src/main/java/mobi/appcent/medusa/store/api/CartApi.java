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


import mobi.appcent.medusa.store.model.response.StoreCartsRes;
import mobi.appcent.medusa.store.model.response.StoreCompleteCartRes;
import mobi.appcent.medusa.store.model.response.StorePostCartReq;
import mobi.appcent.medusa.store.model.response.StorePostCartsCartLineItemsItemReq;
import mobi.appcent.medusa.store.model.response.StorePostCartsCartLineItemsReq;
import mobi.appcent.medusa.store.model.response.StorePostCartsCartPaymentSessionReq;
import mobi.appcent.medusa.store.model.response.StorePostCartsCartPaymentSessionUpdateReq;
import mobi.appcent.medusa.store.model.response.StorePostCartsCartReq;
import mobi.appcent.medusa.store.model.response.StorePostCartsCartShippingMethodReq;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Build call for deleteCartsCartDiscountsDiscount
     * @param id The id of the Cart. (required)
     * @param code The unique Discount code. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteCartsCartDiscountsDiscountCall(String id, String code, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/discounts/{code}"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()))
            .replaceAll("\\{" + "code" + "\\}", medusaSdkClient.escapeString(code.toString()));

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
        return medusaSdkClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteCartsCartDiscountsDiscountValidateBeforeCall(String id, String code, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteCartsCartDiscountsDiscount(Async)");
        }
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling deleteCartsCartDiscountsDiscount(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteCartsCartDiscountsDiscountCall(id, code, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Remove Discount
     * Removes a Discount from a Cart.
     * @param id The id of the Cart. (required)
     * @param code The unique Discount code. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes deleteCartsCartDiscountsDiscount(String id, String code) throws ApiException {
        ApiResponse<StoreCartsRes> resp = deleteCartsCartDiscountsDiscountWithHttpInfo(id, code);
        return resp.getData();
    }

    /**
     * Remove Discount
     * Removes a Discount from a Cart.
     * @param id The id of the Cart. (required)
     * @param code The unique Discount code. (required)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> deleteCartsCartDiscountsDiscountWithHttpInfo(String id, String code) throws ApiException {
        com.squareup.okhttp.Call call = deleteCartsCartDiscountsDiscountValidateBeforeCall(id, code, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Remove Discount (asynchronously)
     * Removes a Discount from a Cart.
     * @param id The id of the Cart. (required)
     * @param code The unique Discount code. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteCartsCartDiscountsDiscountAsync(String id, String code, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteCartsCartDiscountsDiscountValidateBeforeCall(id, code, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteCartsCartLineItemsItem
     * @param id The id of the Cart. (required)
     * @param lineId The id of the Line Item. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteCartsCartLineItemsItemCall(String id, String lineId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/line-items/{line_id}"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()))
            .replaceAll("\\{" + "line_id" + "\\}", medusaSdkClient.escapeString(lineId.toString()));

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
        return medusaSdkClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteCartsCartLineItemsItemValidateBeforeCall(String id, String lineId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteCartsCartLineItemsItem(Async)");
        }
        // verify the required parameter 'lineId' is set
        if (lineId == null) {
            throw new ApiException("Missing the required parameter 'lineId' when calling deleteCartsCartLineItemsItem(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteCartsCartLineItemsItemCall(id, lineId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a Line Item
     * Removes a Line Item from a Cart.
     * @param id The id of the Cart. (required)
     * @param lineId The id of the Line Item. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes deleteCartsCartLineItemsItem(String id, String lineId) throws ApiException {
        ApiResponse<StoreCartsRes> resp = deleteCartsCartLineItemsItemWithHttpInfo(id, lineId);
        return resp.getData();
    }

    /**
     * Delete a Line Item
     * Removes a Line Item from a Cart.
     * @param id The id of the Cart. (required)
     * @param lineId The id of the Line Item. (required)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> deleteCartsCartLineItemsItemWithHttpInfo(String id, String lineId) throws ApiException {
        com.squareup.okhttp.Call call = deleteCartsCartLineItemsItemValidateBeforeCall(id, lineId, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a Line Item (asynchronously)
     * Removes a Line Item from a Cart.
     * @param id The id of the Cart. (required)
     * @param lineId The id of the Line Item. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteCartsCartLineItemsItemAsync(String id, String lineId, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteCartsCartLineItemsItemValidateBeforeCall(id, lineId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteCartsCartPaymentSessionsSession
     * @param id The id of the Cart. (required)
     * @param providerId The id of the Payment Provider used to create the Payment Session to be deleted. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteCartsCartPaymentSessionsSessionCall(String id, String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/payment-sessions/{provider_id}"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()))
            .replaceAll("\\{" + "provider_id" + "\\}", medusaSdkClient.escapeString(providerId.toString()));

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
        return medusaSdkClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteCartsCartPaymentSessionsSessionValidateBeforeCall(String id, String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteCartsCartPaymentSessionsSession(Async)");
        }
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling deleteCartsCartPaymentSessionsSession(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteCartsCartPaymentSessionsSessionCall(id, providerId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a Payment Session
     * Deletes a Payment Session on a Cart. May be useful if a payment has failed.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the Payment Provider used to create the Payment Session to be deleted. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes deleteCartsCartPaymentSessionsSession(String id, String providerId) throws ApiException {
        ApiResponse<StoreCartsRes> resp = deleteCartsCartPaymentSessionsSessionWithHttpInfo(id, providerId);
        return resp.getData();
    }

    /**
     * Delete a Payment Session
     * Deletes a Payment Session on a Cart. May be useful if a payment has failed.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the Payment Provider used to create the Payment Session to be deleted. (required)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> deleteCartsCartPaymentSessionsSessionWithHttpInfo(String id, String providerId) throws ApiException {
        com.squareup.okhttp.Call call = deleteCartsCartPaymentSessionsSessionValidateBeforeCall(id, providerId, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a Payment Session (asynchronously)
     * Deletes a Payment Session on a Cart. May be useful if a payment has failed.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the Payment Provider used to create the Payment Session to be deleted. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteCartsCartPaymentSessionsSessionAsync(String id, String providerId, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteCartsCartPaymentSessionsSessionValidateBeforeCall(id, providerId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCartsCart
     * @param id The id of the Cart. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCartsCartCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/carts/{id}"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()));

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
        return medusaSdkClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCartsCartValidateBeforeCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getCartsCart(Async)");
        }
        
        com.squareup.okhttp.Call call = getCartsCartCall(id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a Cart
     * Retrieves a Cart.
     * @param id The id of the Cart. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes getCartsCart(String id) throws ApiException {
        ApiResponse<StoreCartsRes> resp = getCartsCartWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Get a Cart
     * Retrieves a Cart.
     * @param id The id of the Cart. (required)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> getCartsCartWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = getCartsCartValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Get a Cart (asynchronously)
     * Retrieves a Cart.
     * @param id The id of the Cart. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCartsCartAsync(String id, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getCartsCartValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCart
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCartCall(StorePostCartReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/carts";

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
    private com.squareup.okhttp.Call postCartValidateBeforeCall(StorePostCartReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = postCartCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a Cart
     * Creates a Cart within the given region and with the initial items. If no &#x60;region_id&#x60; is provided the cart will be associated with the first Region available. If no items are provided the cart will be empty after creation. If a user is logged in the cart&#x27;s customer id and email will be set.
     * @param body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes postCart(StorePostCartReq body) throws ApiException {
        ApiResponse<StoreCartsRes> resp = postCartWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Create a Cart
     * Creates a Cart within the given region and with the initial items. If no &#x60;region_id&#x60; is provided the cart will be associated with the first Region available. If no items are provided the cart will be empty after creation. If a user is logged in the cart&#x27;s customer id and email will be set.
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> postCartWithHttpInfo(StorePostCartReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCartValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Create a Cart (asynchronously)
     * Creates a Cart within the given region and with the initial items. If no &#x60;region_id&#x60; is provided the cart will be associated with the first Region available. If no items are provided the cart will be empty after creation. If a user is logged in the cart&#x27;s customer id and email will be set.
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCartAsync(StorePostCartReq body, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCartValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCartsCart
     * @param id The id of the Cart. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCartsCartCall(String id, StorePostCartsCartReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/carts/{id}"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()));

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
    private com.squareup.okhttp.Call postCartsCartValidateBeforeCall(String id, StorePostCartsCartReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling postCartsCart(Async)");
        }
        
        com.squareup.okhttp.Call call = postCartsCartCall(id, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update a Cart
     * Updates a Cart.
     * @param id The id of the Cart. (required)
     * @param body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes postCartsCart(String id, StorePostCartsCartReq body) throws ApiException {
        ApiResponse<StoreCartsRes> resp = postCartsCartWithHttpInfo(id, body);
        return resp.getData();
    }

    /**
     * Update a Cart
     * Updates a Cart.
     * @param id The id of the Cart. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> postCartsCartWithHttpInfo(String id, StorePostCartsCartReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCartsCartValidateBeforeCall(id, body, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Update a Cart (asynchronously)
     * Updates a Cart.
     * @param id The id of the Cart. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCartsCartAsync(String id, StorePostCartsCartReq body, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCartsCartValidateBeforeCall(id, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCartsCartComplete
     * @param id The Cart id. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCartsCartCompleteCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/complete"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()));

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
    private com.squareup.okhttp.Call postCartsCartCompleteValidateBeforeCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling postCartsCartComplete(Async)");
        }
        
        com.squareup.okhttp.Call call = postCartsCartCompleteCall(id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Complete a Cart
     * Completes a cart. The following steps will be performed. Payment authorization is attempted and if more work is required, we simply return the cart for further updates. If payment is authorized and order is not yet created, we make sure to do so. The completion of a cart can be performed idempotently with a provided header &#x60;Idempotency-Key&#x60;. If not provided, we will generate one for the request.
     * @param id The Cart id. (required)
     * @return StoreCompleteCartRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCompleteCartRes postCartsCartComplete(String id) throws ApiException {
        ApiResponse<StoreCompleteCartRes> resp = postCartsCartCompleteWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Complete a Cart
     * Completes a cart. The following steps will be performed. Payment authorization is attempted and if more work is required, we simply return the cart for further updates. If payment is authorized and order is not yet created, we make sure to do so. The completion of a cart can be performed idempotently with a provided header &#x60;Idempotency-Key&#x60;. If not provided, we will generate one for the request.
     * @param id The Cart id. (required)
     * @return ApiResponse&lt;StoreCompleteCartRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCompleteCartRes> postCartsCartCompleteWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = postCartsCartCompleteValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<StoreCompleteCartRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Complete a Cart (asynchronously)
     * Completes a cart. The following steps will be performed. Payment authorization is attempted and if more work is required, we simply return the cart for further updates. If payment is authorized and order is not yet created, we make sure to do so. The completion of a cart can be performed idempotently with a provided header &#x60;Idempotency-Key&#x60;. If not provided, we will generate one for the request.
     * @param id The Cart id. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCartsCartCompleteAsync(String id, final ApiCallback<StoreCompleteCartRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCartsCartCompleteValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCompleteCartRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCartsCartLineItems
     * @param id The id of the Cart to add the Line Item to. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCartsCartLineItemsCall(String id, StorePostCartsCartLineItemsReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/line-items"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()));

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
    private com.squareup.okhttp.Call postCartsCartLineItemsValidateBeforeCall(String id, StorePostCartsCartLineItemsReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling postCartsCartLineItems(Async)");
        }
        
        com.squareup.okhttp.Call call = postCartsCartLineItemsCall(id, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Add a Line Item
     * Generates a Line Item with a given Product Variant and adds it to the Cart
     * @param id The id of the Cart to add the Line Item to. (required)
     * @param body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes postCartsCartLineItems(String id, StorePostCartsCartLineItemsReq body) throws ApiException {
        ApiResponse<StoreCartsRes> resp = postCartsCartLineItemsWithHttpInfo(id, body);
        return resp.getData();
    }

    /**
     * Add a Line Item
     * Generates a Line Item with a given Product Variant and adds it to the Cart
     * @param id The id of the Cart to add the Line Item to. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> postCartsCartLineItemsWithHttpInfo(String id, StorePostCartsCartLineItemsReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCartsCartLineItemsValidateBeforeCall(id, body, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Add a Line Item (asynchronously)
     * Generates a Line Item with a given Product Variant and adds it to the Cart
     * @param id The id of the Cart to add the Line Item to. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCartsCartLineItemsAsync(String id, StorePostCartsCartLineItemsReq body, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCartsCartLineItemsValidateBeforeCall(id, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCartsCartLineItemsItem
     * @param id The id of the Cart. (required)
     * @param lineId The id of the Line Item. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCartsCartLineItemsItemCall(String id, String lineId, StorePostCartsCartLineItemsItemReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/line-items/{line_id}"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()))
            .replaceAll("\\{" + "line_id" + "\\}", medusaSdkClient.escapeString(lineId.toString()));

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
    private com.squareup.okhttp.Call postCartsCartLineItemsItemValidateBeforeCall(String id, String lineId, StorePostCartsCartLineItemsItemReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling postCartsCartLineItemsItem(Async)");
        }
        // verify the required parameter 'lineId' is set
        if (lineId == null) {
            throw new ApiException("Missing the required parameter 'lineId' when calling postCartsCartLineItemsItem(Async)");
        }
        
        com.squareup.okhttp.Call call = postCartsCartLineItemsItemCall(id, lineId, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update a Line Item
     * Updates a Line Item if the desired quantity can be fulfilled.
     * @param id The id of the Cart. (required)
     * @param lineId The id of the Line Item. (required)
     * @param body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes postCartsCartLineItemsItem(String id, String lineId, StorePostCartsCartLineItemsItemReq body) throws ApiException {
        ApiResponse<StoreCartsRes> resp = postCartsCartLineItemsItemWithHttpInfo(id, lineId, body);
        return resp.getData();
    }

    /**
     * Update a Line Item
     * Updates a Line Item if the desired quantity can be fulfilled.
     * @param id The id of the Cart. (required)
     * @param lineId The id of the Line Item. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> postCartsCartLineItemsItemWithHttpInfo(String id, String lineId, StorePostCartsCartLineItemsItemReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCartsCartLineItemsItemValidateBeforeCall(id, lineId, body, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Update a Line Item (asynchronously)
     * Updates a Line Item if the desired quantity can be fulfilled.
     * @param id The id of the Cart. (required)
     * @param lineId The id of the Line Item. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCartsCartLineItemsItemAsync(String id, String lineId, StorePostCartsCartLineItemsItemReq body, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCartsCartLineItemsItemValidateBeforeCall(id, lineId, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCartsCartPaymentSession
     * @param id The ID of the Cart. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCartsCartPaymentSessionCall(String id, StorePostCartsCartPaymentSessionReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/payment-session"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()));

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
    private com.squareup.okhttp.Call postCartsCartPaymentSessionValidateBeforeCall(String id, StorePostCartsCartPaymentSessionReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling postCartsCartPaymentSession(Async)");
        }
        
        com.squareup.okhttp.Call call = postCartsCartPaymentSessionCall(id, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Select a Payment Session
     * Selects a Payment Session as the session intended to be used towards the completion of the Cart.
     * @param id The ID of the Cart. (required)
     * @param body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes postCartsCartPaymentSession(String id, StorePostCartsCartPaymentSessionReq body) throws ApiException {
        ApiResponse<StoreCartsRes> resp = postCartsCartPaymentSessionWithHttpInfo(id, body);
        return resp.getData();
    }

    /**
     * Select a Payment Session
     * Selects a Payment Session as the session intended to be used towards the completion of the Cart.
     * @param id The ID of the Cart. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> postCartsCartPaymentSessionWithHttpInfo(String id, StorePostCartsCartPaymentSessionReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCartsCartPaymentSessionValidateBeforeCall(id, body, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Select a Payment Session (asynchronously)
     * Selects a Payment Session as the session intended to be used towards the completion of the Cart.
     * @param id The ID of the Cart. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCartsCartPaymentSessionAsync(String id, StorePostCartsCartPaymentSessionReq body, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCartsCartPaymentSessionValidateBeforeCall(id, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCartsCartPaymentSessionUpdate
     * @param id The id of the Cart. (required)
     * @param providerId The id of the payment provider. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCartsCartPaymentSessionUpdateCall(String id, String providerId, StorePostCartsCartPaymentSessionUpdateReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/payment-sessions/{provider_id}"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()))
            .replaceAll("\\{" + "provider_id" + "\\}", medusaSdkClient.escapeString(providerId.toString()));

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
    private com.squareup.okhttp.Call postCartsCartPaymentSessionUpdateValidateBeforeCall(String id, String providerId, StorePostCartsCartPaymentSessionUpdateReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling postCartsCartPaymentSessionUpdate(Async)");
        }
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling postCartsCartPaymentSessionUpdate(Async)");
        }
        
        com.squareup.okhttp.Call call = postCartsCartPaymentSessionUpdateCall(id, providerId, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update a Payment Session
     * Updates a Payment Session with additional data.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the payment provider. (required)
     * @param body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes postCartsCartPaymentSessionUpdate(String id, String providerId, StorePostCartsCartPaymentSessionUpdateReq body) throws ApiException {
        ApiResponse<StoreCartsRes> resp = postCartsCartPaymentSessionUpdateWithHttpInfo(id, providerId, body);
        return resp.getData();
    }

    /**
     * Update a Payment Session
     * Updates a Payment Session with additional data.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the payment provider. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> postCartsCartPaymentSessionUpdateWithHttpInfo(String id, String providerId, StorePostCartsCartPaymentSessionUpdateReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCartsCartPaymentSessionUpdateValidateBeforeCall(id, providerId, body, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Update a Payment Session (asynchronously)
     * Updates a Payment Session with additional data.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the payment provider. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCartsCartPaymentSessionUpdateAsync(String id, String providerId, StorePostCartsCartPaymentSessionUpdateReq body, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCartsCartPaymentSessionUpdateValidateBeforeCall(id, providerId, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCartsCartPaymentSessions
     * @param id The id of the Cart. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCartsCartPaymentSessionsCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/payment-sessions"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()));

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
    private com.squareup.okhttp.Call postCartsCartPaymentSessionsValidateBeforeCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling postCartsCartPaymentSessions(Async)");
        }
        
        com.squareup.okhttp.Call call = postCartsCartPaymentSessionsCall(id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create Payment Sessions
     * Creates Payment Sessions for each of the available Payment Providers in the Cart&#x27;s Region.
     * @param id The id of the Cart. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes postCartsCartPaymentSessions(String id) throws ApiException {
        ApiResponse<StoreCartsRes> resp = postCartsCartPaymentSessionsWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Create Payment Sessions
     * Creates Payment Sessions for each of the available Payment Providers in the Cart&#x27;s Region.
     * @param id The id of the Cart. (required)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> postCartsCartPaymentSessionsWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = postCartsCartPaymentSessionsValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Create Payment Sessions (asynchronously)
     * Creates Payment Sessions for each of the available Payment Providers in the Cart&#x27;s Region.
     * @param id The id of the Cart. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCartsCartPaymentSessionsAsync(String id, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCartsCartPaymentSessionsValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCartsCartPaymentSessionsSession
     * @param id The id of the Cart. (required)
     * @param providerId The id of the Payment Provider that created the Payment Session to be refreshed. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCartsCartPaymentSessionsSessionCall(String id, String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/payment-sessions/{provider_id}/refresh"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()))
            .replaceAll("\\{" + "provider_id" + "\\}", medusaSdkClient.escapeString(providerId.toString()));

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
    private com.squareup.okhttp.Call postCartsCartPaymentSessionsSessionValidateBeforeCall(String id, String providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling postCartsCartPaymentSessionsSession(Async)");
        }
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling postCartsCartPaymentSessionsSession(Async)");
        }
        
        com.squareup.okhttp.Call call = postCartsCartPaymentSessionsSessionCall(id, providerId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Refresh a Payment Session
     * Refreshes a Payment Session to ensure that it is in sync with the Cart - this is usually not necessary.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the Payment Provider that created the Payment Session to be refreshed. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes postCartsCartPaymentSessionsSession(String id, String providerId) throws ApiException {
        ApiResponse<StoreCartsRes> resp = postCartsCartPaymentSessionsSessionWithHttpInfo(id, providerId);
        return resp.getData();
    }

    /**
     * Refresh a Payment Session
     * Refreshes a Payment Session to ensure that it is in sync with the Cart - this is usually not necessary.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the Payment Provider that created the Payment Session to be refreshed. (required)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> postCartsCartPaymentSessionsSessionWithHttpInfo(String id, String providerId) throws ApiException {
        com.squareup.okhttp.Call call = postCartsCartPaymentSessionsSessionValidateBeforeCall(id, providerId, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Refresh a Payment Session (asynchronously)
     * Refreshes a Payment Session to ensure that it is in sync with the Cart - this is usually not necessary.
     * @param id The id of the Cart. (required)
     * @param providerId The id of the Payment Provider that created the Payment Session to be refreshed. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCartsCartPaymentSessionsSessionAsync(String id, String providerId, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCartsCartPaymentSessionsSessionValidateBeforeCall(id, providerId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCartsCartShippingMethod
     * @param id The cart ID. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCartsCartShippingMethodCall(String id, StorePostCartsCartShippingMethodReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/shipping-methods"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()));

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
    private com.squareup.okhttp.Call postCartsCartShippingMethodValidateBeforeCall(String id, StorePostCartsCartShippingMethodReq body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling postCartsCartShippingMethod(Async)");
        }
        
        com.squareup.okhttp.Call call = postCartsCartShippingMethodCall(id, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Add a Shipping Method
     * Adds a Shipping Method to the Cart.
     * @param id The cart ID. (required)
     * @param body  (optional)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes postCartsCartShippingMethod(String id, StorePostCartsCartShippingMethodReq body) throws ApiException {
        ApiResponse<StoreCartsRes> resp = postCartsCartShippingMethodWithHttpInfo(id, body);
        return resp.getData();
    }

    /**
     * Add a Shipping Method
     * Adds a Shipping Method to the Cart.
     * @param id The cart ID. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> postCartsCartShippingMethodWithHttpInfo(String id, StorePostCartsCartShippingMethodReq body) throws ApiException {
        com.squareup.okhttp.Call call = postCartsCartShippingMethodValidateBeforeCall(id, body, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Add a Shipping Method (asynchronously)
     * Adds a Shipping Method to the Cart.
     * @param id The cart ID. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCartsCartShippingMethodAsync(String id, StorePostCartsCartShippingMethodReq body, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCartsCartShippingMethodValidateBeforeCall(id, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCartsCartTaxes
     * @param id The Cart ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCartsCartTaxesCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/carts/{id}/taxes"
            .replaceAll("\\{" + "id" + "\\}", medusaSdkClient.escapeString(id.toString()));

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
    private com.squareup.okhttp.Call postCartsCartTaxesValidateBeforeCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling postCartsCartTaxes(Async)");
        }
        
        com.squareup.okhttp.Call call = postCartsCartTaxesCall(id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Calculate Cart Taxes
     * Calculates taxes for a cart. Depending on the cart&#x27;s region this may involve making 3rd party API calls to a Tax Provider service.
     * @param id The Cart ID. (required)
     * @return StoreCartsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCartsRes postCartsCartTaxes(String id) throws ApiException {
        ApiResponse<StoreCartsRes> resp = postCartsCartTaxesWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Calculate Cart Taxes
     * Calculates taxes for a cart. Depending on the cart&#x27;s region this may involve making 3rd party API calls to a Tax Provider service.
     * @param id The Cart ID. (required)
     * @return ApiResponse&lt;StoreCartsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCartsRes> postCartsCartTaxesWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = postCartsCartTaxesValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Calculate Cart Taxes (asynchronously)
     * Calculates taxes for a cart. Depending on the cart&#x27;s region this may involve making 3rd party API calls to a Tax Provider service.
     * @param id The Cart ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCartsCartTaxesAsync(String id, final ApiCallback<StoreCartsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postCartsCartTaxesValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCartsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
