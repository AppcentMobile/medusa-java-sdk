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
import mobi.appcent.medusa.store.MedusaApiClient;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import mobi.appcent.medusa.store.model.CreatedAt;
import mobi.appcent.medusa.store.model.StoreCollectionsListRes;
import mobi.appcent.medusa.store.model.StoreCollectionsRes;
import mobi.appcent.medusa.store.model.UpdatedAt;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionApi {
    private MedusaApiClient medusaApiClient;

    public static CollectionApi getInstance() {
        return new CollectionApi();
    }

    public MedusaApiClient getApiClient() {
        return medusaApiClient;
    }

    public void setApiClient(MedusaApiClient medusaApiClient) {
        this.medusaApiClient = medusaApiClient;
    }

    /**
     * Build call for getCollections
     * @param offset The number of collections to skip before starting to collect the collections set (optional, default to 0)
     * @param limit The number of collections to return (optional, default to 10)
     * @param createdAt Date comparison for when resulting collections were created. (optional)
     * @param updatedAt Date comparison for when resulting collections were updated. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCollectionsCall(Integer offset, Integer limit, CreatedAt createdAt, UpdatedAt updatedAt, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/collections";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (offset != null)
        localVarQueryParams.addAll(medusaApiClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(medusaApiClient.parameterToPair("limit", limit));
        if (createdAt != null)
        localVarQueryParams.addAll(medusaApiClient.parameterToPair("created_at", createdAt));
        if (updatedAt != null)
        localVarQueryParams.addAll(medusaApiClient.parameterToPair("updated_at", updatedAt));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = medusaApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = medusaApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaApiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
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
        return medusaApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCollectionsValidateBeforeCall(Integer offset, Integer limit, CreatedAt createdAt, UpdatedAt updatedAt, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = getCollectionsCall(offset, limit, createdAt, updatedAt, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List Collections
     * Retrieve a list of Product Collection.
     * @param offset The number of collections to skip before starting to collect the collections set (optional, default to 0)
     * @param limit The number of collections to return (optional, default to 10)
     * @param createdAt Date comparison for when resulting collections were created. (optional)
     * @param updatedAt Date comparison for when resulting collections were updated. (optional)
     * @return StoreCollectionsListRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCollectionsListRes getCollections(Integer offset, Integer limit, CreatedAt createdAt, UpdatedAt updatedAt) throws ApiException {
        ApiResponse<StoreCollectionsListRes> resp = getCollectionsWithHttpInfo(offset, limit, createdAt, updatedAt);
        return resp.getData();
    }

    /**
     * List Collections
     * Retrieve a list of Product Collection.
     * @param offset The number of collections to skip before starting to collect the collections set (optional, default to 0)
     * @param limit The number of collections to return (optional, default to 10)
     * @param createdAt Date comparison for when resulting collections were created. (optional)
     * @param updatedAt Date comparison for when resulting collections were updated. (optional)
     * @return ApiResponse&lt;StoreCollectionsListRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCollectionsListRes> getCollectionsWithHttpInfo(Integer offset, Integer limit, CreatedAt createdAt, UpdatedAt updatedAt) throws ApiException {
        com.squareup.okhttp.Call call = getCollectionsValidateBeforeCall(offset, limit, createdAt, updatedAt, null, null);
        Type localVarReturnType = new TypeToken<StoreCollectionsListRes>(){}.getType();
        return medusaApiClient.execute(call, localVarReturnType);
    }

    /**
     * List Collections (asynchronously)
     * Retrieve a list of Product Collection.
     * @param offset The number of collections to skip before starting to collect the collections set (optional, default to 0)
     * @param limit The number of collections to return (optional, default to 10)
     * @param createdAt Date comparison for when resulting collections were created. (optional)
     * @param updatedAt Date comparison for when resulting collections were updated. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCollectionsAsync(Integer offset, Integer limit, CreatedAt createdAt, UpdatedAt updatedAt, final ApiCallback<StoreCollectionsListRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getCollectionsValidateBeforeCall(offset, limit, createdAt, updatedAt, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCollectionsListRes>(){}.getType();
        medusaApiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCollectionsCollection
     * @param id The id of the Product Collection (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCollectionsCollectionCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/collections/{id}"
            .replaceAll("\\{" + "id" + "\\}", medusaApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = medusaApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = medusaApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            medusaApiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
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
        return medusaApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCollectionsCollectionValidateBeforeCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getCollectionsCollection(Async)");
        }
        
        com.squareup.okhttp.Call call = getCollectionsCollectionCall(id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a Collection
     * Retrieves a Product Collection.
     * @param id The id of the Product Collection (required)
     * @return StoreCollectionsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreCollectionsRes getCollectionsCollection(String id) throws ApiException {
        ApiResponse<StoreCollectionsRes> resp = getCollectionsCollectionWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Get a Collection
     * Retrieves a Product Collection.
     * @param id The id of the Product Collection (required)
     * @return ApiResponse&lt;StoreCollectionsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreCollectionsRes> getCollectionsCollectionWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = getCollectionsCollectionValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<StoreCollectionsRes>(){}.getType();
        return medusaApiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a Collection (asynchronously)
     * Retrieves a Product Collection.
     * @param id The id of the Product Collection (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCollectionsCollectionAsync(String id, final ApiCallback<StoreCollectionsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getCollectionsCollectionValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreCollectionsRes>(){}.getType();
        medusaApiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
