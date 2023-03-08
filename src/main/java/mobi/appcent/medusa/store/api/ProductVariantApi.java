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

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import java.math.BigDecimal;

import mobi.appcent.medusa.store.model.response.InventoryQuantity;
import mobi.appcent.medusa.store.model.response.StoreVariantsListRes;
import mobi.appcent.medusa.store.model.response.StoreVariantsRes;
import mobi.appcent.medusa.store.model.response.Title;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductVariantApi {
    private MedusaSdkClient medusaSdkClient;

    public static ProductVariantApi getInstance() {
        return new ProductVariantApi();
    }

    public MedusaSdkClient getApiClient() {
        return medusaSdkClient;
    }

    public void setApiClient(MedusaSdkClient medusaSdkClient) {
        this.medusaSdkClient = medusaSdkClient;
    }

    /**
     * Build call for getVariants
     * @param ids A comma separated list of Product Variant ids to filter by. (optional)
     * @param salesChannelId A sales channel id for result configuration. (optional)
     * @param expand A comma separated list of Product Variant relations to load. (optional)
     * @param offset How many product variants to skip in the result. (optional)
     * @param limit Maximum number of Product Variants to return. (optional)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The currency code to use for price selection. (optional)
     * @param title product variant title to search for. (optional)
     * @param inventoryQuantity Filter by available inventory quantity (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getVariantsCall(String ids, String salesChannelId, String expand, BigDecimal offset, BigDecimal limit, String cartId, String regionId, String currencyCode, Title title, InventoryQuantity inventoryQuantity, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/variants";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (ids != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("ids", ids));
        if (salesChannelId != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("sales_channel_id", salesChannelId));
        if (expand != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("expand", expand));
        if (offset != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("limit", limit));
        if (cartId != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("cart_id", cartId));
        if (regionId != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("region_id", regionId));
        if (currencyCode != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("currency_code", currencyCode));
        if (title != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("title", title));
        if (inventoryQuantity != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("inventory_quantity", inventoryQuantity));

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
    private com.squareup.okhttp.Call getVariantsValidateBeforeCall(String ids, String salesChannelId, String expand, BigDecimal offset, BigDecimal limit, String cartId, String regionId, String currencyCode, Title title, InventoryQuantity inventoryQuantity, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = getVariantsCall(ids, salesChannelId, expand, offset, limit, cartId, regionId, currencyCode, title, inventoryQuantity, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get Product Variants
     * Retrieves a list of Product Variants
     * @param ids A comma separated list of Product Variant ids to filter by. (optional)
     * @param salesChannelId A sales channel id for result configuration. (optional)
     * @param expand A comma separated list of Product Variant relations to load. (optional)
     * @param offset How many product variants to skip in the result. (optional)
     * @param limit Maximum number of Product Variants to return. (optional)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The currency code to use for price selection. (optional)
     * @param title product variant title to search for. (optional)
     * @param inventoryQuantity Filter by available inventory quantity (optional)
     * @return StoreVariantsListRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreVariantsListRes getVariants(String ids, String salesChannelId, String expand, BigDecimal offset, BigDecimal limit, String cartId, String regionId, String currencyCode, Title title, InventoryQuantity inventoryQuantity) throws ApiException {
        ApiResponse<StoreVariantsListRes> resp = getVariantsWithHttpInfo(ids, salesChannelId, expand, offset, limit, cartId, regionId, currencyCode, title, inventoryQuantity);
        return resp.getData();
    }

    /**
     * Get Product Variants
     * Retrieves a list of Product Variants
     * @param ids A comma separated list of Product Variant ids to filter by. (optional)
     * @param salesChannelId A sales channel id for result configuration. (optional)
     * @param expand A comma separated list of Product Variant relations to load. (optional)
     * @param offset How many product variants to skip in the result. (optional)
     * @param limit Maximum number of Product Variants to return. (optional)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The currency code to use for price selection. (optional)
     * @param title product variant title to search for. (optional)
     * @param inventoryQuantity Filter by available inventory quantity (optional)
     * @return ApiResponse&lt;StoreVariantsListRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreVariantsListRes> getVariantsWithHttpInfo(String ids, String salesChannelId, String expand, BigDecimal offset, BigDecimal limit, String cartId, String regionId, String currencyCode, Title title, InventoryQuantity inventoryQuantity) throws ApiException {
        com.squareup.okhttp.Call call = getVariantsValidateBeforeCall(ids, salesChannelId, expand, offset, limit, cartId, regionId, currencyCode, title, inventoryQuantity, null, null);
        Type localVarReturnType = new TypeToken<StoreVariantsListRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Get Product Variants (asynchronously)
     * Retrieves a list of Product Variants
     * @param ids A comma separated list of Product Variant ids to filter by. (optional)
     * @param salesChannelId A sales channel id for result configuration. (optional)
     * @param expand A comma separated list of Product Variant relations to load. (optional)
     * @param offset How many product variants to skip in the result. (optional)
     * @param limit Maximum number of Product Variants to return. (optional)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The currency code to use for price selection. (optional)
     * @param title product variant title to search for. (optional)
     * @param inventoryQuantity Filter by available inventory quantity (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getVariantsAsync(String ids, String salesChannelId, String expand, BigDecimal offset, BigDecimal limit, String cartId, String regionId, String currencyCode, Title title, InventoryQuantity inventoryQuantity, final ApiCallback<StoreVariantsListRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getVariantsValidateBeforeCall(ids, salesChannelId, expand, offset, limit, cartId, regionId, currencyCode, title, inventoryQuantity, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreVariantsListRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getVariantsVariant
     * @param variantId The id of the Product Variant. (required)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param salesChannelId A sales channel id for result configuration. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getVariantsVariantCall(String variantId, String cartId, String salesChannelId, String regionId, String currencyCode, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/variants/{variant_id}"
            .replaceAll("\\{" + "variant_id" + "\\}", medusaSdkClient.escapeString(variantId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (cartId != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("cart_id", cartId));
        if (salesChannelId != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("sales_channel_id", salesChannelId));
        if (regionId != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("region_id", regionId));
        if (currencyCode != null)
        localVarQueryParams.addAll(medusaSdkClient.parameterToPair("currency_code", currencyCode));

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
    private com.squareup.okhttp.Call getVariantsVariantValidateBeforeCall(String variantId, String cartId, String salesChannelId, String regionId, String currencyCode, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'variantId' is set
        if (variantId == null) {
            throw new ApiException("Missing the required parameter 'variantId' when calling getVariantsVariant(Async)");
        }
        
        com.squareup.okhttp.Call call = getVariantsVariantCall(variantId, cartId, salesChannelId, regionId, currencyCode, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a Product Variant
     * Retrieves a Product Variant by id
     * @param variantId The id of the Product Variant. (required)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param salesChannelId A sales channel id for result configuration. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. (optional)
     * @return StoreVariantsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreVariantsRes getVariantsVariant(String variantId, String cartId, String salesChannelId, String regionId, String currencyCode) throws ApiException {
        ApiResponse<StoreVariantsRes> resp = getVariantsVariantWithHttpInfo(variantId, cartId, salesChannelId, regionId, currencyCode);
        return resp.getData();
    }

    /**
     * Get a Product Variant
     * Retrieves a Product Variant by id
     * @param variantId The id of the Product Variant. (required)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param salesChannelId A sales channel id for result configuration. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. (optional)
     * @return ApiResponse&lt;StoreVariantsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreVariantsRes> getVariantsVariantWithHttpInfo(String variantId, String cartId, String salesChannelId, String regionId, String currencyCode) throws ApiException {
        com.squareup.okhttp.Call call = getVariantsVariantValidateBeforeCall(variantId, cartId, salesChannelId, regionId, currencyCode, null, null);
        Type localVarReturnType = new TypeToken<StoreVariantsRes>(){}.getType();
        return medusaSdkClient.execute(call, localVarReturnType);
    }

    /**
     * Get a Product Variant (asynchronously)
     * Retrieves a Product Variant by id
     * @param variantId The id of the Product Variant. (required)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param salesChannelId A sales channel id for result configuration. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getVariantsVariantAsync(String variantId, String cartId, String salesChannelId, String regionId, String currencyCode, final ApiCallback<StoreVariantsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getVariantsVariantValidateBeforeCall(variantId, cartId, salesChannelId, regionId, currencyCode, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreVariantsRes>(){}.getType();
        medusaSdkClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
