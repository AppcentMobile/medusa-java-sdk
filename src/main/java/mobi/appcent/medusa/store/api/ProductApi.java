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

import mobi.appcent.medusa.store.ApiCallback;
import mobi.appcent.medusa.store.ApiClient;
import mobi.appcent.medusa.store.ApiException;
import mobi.appcent.medusa.store.ApiResponse;
import mobi.appcent.medusa.store.Configuration;
import mobi.appcent.medusa.store.Pair;
import mobi.appcent.medusa.store.ProgressRequestBody;
import mobi.appcent.medusa.store.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import mobi.appcent.medusa.store.model.CreatedAt4;
import mobi.appcent.medusa.store.model.Id;
import mobi.appcent.medusa.store.model.StorePostSearchRes;
import mobi.appcent.medusa.store.model.StoreProductsListRes;
import mobi.appcent.medusa.store.model.StoreProductsRes;
import mobi.appcent.medusa.store.model.UpdatedAt4;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductApi {
    private ApiClient apiClient;

    public ProductApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ProductApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getProducts
     * @param q Query used for searching products by title, description, variant&#x27;s title, variant&#x27;s sku, and collection&#x27;s title (optional)
     * @param id product IDs to search for. (optional)
     * @param salesChannelId an array of sales channel IDs to filter the retrieved products by. (optional)
     * @param collectionId Collection IDs to search for (optional)
     * @param typeId Type IDs to search for (optional)
     * @param tags Tag IDs to search for (optional)
     * @param title title to search for. (optional)
     * @param description description to search for. (optional)
     * @param handle handle to search for. (optional)
     * @param isGiftcard Search for giftcards using is_giftcard&#x3D;true. (optional)
     * @param createdAt Date comparison for when resulting products were created. (optional)
     * @param updatedAt Date comparison for when resulting products were updated. (optional)
     * @param categoryId Category ids to filter by. (optional)
     * @param includeCategoryChildren Include category children when filtering by category_id. (optional)
     * @param offset How many products to skip in the result. (optional, default to 0)
     * @param limit Limit the number of products returned. (optional, default to 100)
     * @param expand (Comma separated) Which fields should be expanded in each product of the result. (optional)
     * @param fields (Comma separated) Which fields should be included in each product of the result. (optional)
     * @param order the field used to order the products. (optional)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The currency code to use for price selection. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getProductsCall(String q, Id id, List<String> salesChannelId, List<String> collectionId, List<String> typeId, List<String> tags, String title, String description, String handle, Boolean isGiftcard, CreatedAt4 createdAt, UpdatedAt4 updatedAt, List<String> categoryId, Boolean includeCategoryChildren, Integer offset, Integer limit, String expand, String fields, String order, String cartId, String regionId, String currencyCode, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/products";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (q != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("q", q));
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("id", id));
        if (salesChannelId != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "sales_channel_id", salesChannelId));
        if (collectionId != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "collection_id", collectionId));
        if (typeId != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "type_id", typeId));
        if (tags != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "tags", tags));
        if (title != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("title", title));
        if (description != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("description", description));
        if (handle != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("handle", handle));
        if (isGiftcard != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("is_giftcard", isGiftcard));
        if (createdAt != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("created_at", createdAt));
        if (updatedAt != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("updated_at", updatedAt));
        if (categoryId != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "category_id", categoryId));
        if (includeCategoryChildren != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("include_category_children", includeCategoryChildren));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (expand != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("expand", expand));
        if (fields != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fields", fields));
        if (order != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("order", order));
        if (cartId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("cart_id", cartId));
        if (regionId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("region_id", regionId));
        if (currencyCode != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("currency_code", currencyCode));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getProductsValidateBeforeCall(String q, Id id, List<String> salesChannelId, List<String> collectionId, List<String> typeId, List<String> tags, String title, String description, String handle, Boolean isGiftcard, CreatedAt4 createdAt, UpdatedAt4 updatedAt, List<String> categoryId, Boolean includeCategoryChildren, Integer offset, Integer limit, String expand, String fields, String order, String cartId, String regionId, String currencyCode, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = getProductsCall(q, id, salesChannelId, collectionId, typeId, tags, title, description, handle, isGiftcard, createdAt, updatedAt, categoryId, includeCategoryChildren, offset, limit, expand, fields, order, cartId, regionId, currencyCode, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List Products
     * Retrieves a list of Products.
     * @param q Query used for searching products by title, description, variant&#x27;s title, variant&#x27;s sku, and collection&#x27;s title (optional)
     * @param id product IDs to search for. (optional)
     * @param salesChannelId an array of sales channel IDs to filter the retrieved products by. (optional)
     * @param collectionId Collection IDs to search for (optional)
     * @param typeId Type IDs to search for (optional)
     * @param tags Tag IDs to search for (optional)
     * @param title title to search for. (optional)
     * @param description description to search for. (optional)
     * @param handle handle to search for. (optional)
     * @param isGiftcard Search for giftcards using is_giftcard&#x3D;true. (optional)
     * @param createdAt Date comparison for when resulting products were created. (optional)
     * @param updatedAt Date comparison for when resulting products were updated. (optional)
     * @param categoryId Category ids to filter by. (optional)
     * @param includeCategoryChildren Include category children when filtering by category_id. (optional)
     * @param offset How many products to skip in the result. (optional, default to 0)
     * @param limit Limit the number of products returned. (optional, default to 100)
     * @param expand (Comma separated) Which fields should be expanded in each product of the result. (optional)
     * @param fields (Comma separated) Which fields should be included in each product of the result. (optional)
     * @param order the field used to order the products. (optional)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The currency code to use for price selection. (optional)
     * @return StoreProductsListRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreProductsListRes getProducts(String q, Id id, List<String> salesChannelId, List<String> collectionId, List<String> typeId, List<String> tags, String title, String description, String handle, Boolean isGiftcard, CreatedAt4 createdAt, UpdatedAt4 updatedAt, List<String> categoryId, Boolean includeCategoryChildren, Integer offset, Integer limit, String expand, String fields, String order, String cartId, String regionId, String currencyCode) throws ApiException {
        ApiResponse<StoreProductsListRes> resp = getProductsWithHttpInfo(q, id, salesChannelId, collectionId, typeId, tags, title, description, handle, isGiftcard, createdAt, updatedAt, categoryId, includeCategoryChildren, offset, limit, expand, fields, order, cartId, regionId, currencyCode);
        return resp.getData();
    }

    /**
     * List Products
     * Retrieves a list of Products.
     * @param q Query used for searching products by title, description, variant&#x27;s title, variant&#x27;s sku, and collection&#x27;s title (optional)
     * @param id product IDs to search for. (optional)
     * @param salesChannelId an array of sales channel IDs to filter the retrieved products by. (optional)
     * @param collectionId Collection IDs to search for (optional)
     * @param typeId Type IDs to search for (optional)
     * @param tags Tag IDs to search for (optional)
     * @param title title to search for. (optional)
     * @param description description to search for. (optional)
     * @param handle handle to search for. (optional)
     * @param isGiftcard Search for giftcards using is_giftcard&#x3D;true. (optional)
     * @param createdAt Date comparison for when resulting products were created. (optional)
     * @param updatedAt Date comparison for when resulting products were updated. (optional)
     * @param categoryId Category ids to filter by. (optional)
     * @param includeCategoryChildren Include category children when filtering by category_id. (optional)
     * @param offset How many products to skip in the result. (optional, default to 0)
     * @param limit Limit the number of products returned. (optional, default to 100)
     * @param expand (Comma separated) Which fields should be expanded in each product of the result. (optional)
     * @param fields (Comma separated) Which fields should be included in each product of the result. (optional)
     * @param order the field used to order the products. (optional)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The currency code to use for price selection. (optional)
     * @return ApiResponse&lt;StoreProductsListRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreProductsListRes> getProductsWithHttpInfo(String q, Id id, List<String> salesChannelId, List<String> collectionId, List<String> typeId, List<String> tags, String title, String description, String handle, Boolean isGiftcard, CreatedAt4 createdAt, UpdatedAt4 updatedAt, List<String> categoryId, Boolean includeCategoryChildren, Integer offset, Integer limit, String expand, String fields, String order, String cartId, String regionId, String currencyCode) throws ApiException {
        com.squareup.okhttp.Call call = getProductsValidateBeforeCall(q, id, salesChannelId, collectionId, typeId, tags, title, description, handle, isGiftcard, createdAt, updatedAt, categoryId, includeCategoryChildren, offset, limit, expand, fields, order, cartId, regionId, currencyCode, null, null);
        Type localVarReturnType = new TypeToken<StoreProductsListRes>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List Products (asynchronously)
     * Retrieves a list of Products.
     * @param q Query used for searching products by title, description, variant&#x27;s title, variant&#x27;s sku, and collection&#x27;s title (optional)
     * @param id product IDs to search for. (optional)
     * @param salesChannelId an array of sales channel IDs to filter the retrieved products by. (optional)
     * @param collectionId Collection IDs to search for (optional)
     * @param typeId Type IDs to search for (optional)
     * @param tags Tag IDs to search for (optional)
     * @param title title to search for. (optional)
     * @param description description to search for. (optional)
     * @param handle handle to search for. (optional)
     * @param isGiftcard Search for giftcards using is_giftcard&#x3D;true. (optional)
     * @param createdAt Date comparison for when resulting products were created. (optional)
     * @param updatedAt Date comparison for when resulting products were updated. (optional)
     * @param categoryId Category ids to filter by. (optional)
     * @param includeCategoryChildren Include category children when filtering by category_id. (optional)
     * @param offset How many products to skip in the result. (optional, default to 0)
     * @param limit Limit the number of products returned. (optional, default to 100)
     * @param expand (Comma separated) Which fields should be expanded in each product of the result. (optional)
     * @param fields (Comma separated) Which fields should be included in each product of the result. (optional)
     * @param order the field used to order the products. (optional)
     * @param cartId The id of the Cart to set prices based on. (optional)
     * @param regionId The id of the Region to set prices based on. (optional)
     * @param currencyCode The currency code to use for price selection. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getProductsAsync(String q, Id id, List<String> salesChannelId, List<String> collectionId, List<String> typeId, List<String> tags, String title, String description, String handle, Boolean isGiftcard, CreatedAt4 createdAt, UpdatedAt4 updatedAt, List<String> categoryId, Boolean includeCategoryChildren, Integer offset, Integer limit, String expand, String fields, String order, String cartId, String regionId, String currencyCode, final ApiCallback<StoreProductsListRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getProductsValidateBeforeCall(q, id, salesChannelId, collectionId, typeId, tags, title, description, handle, isGiftcard, createdAt, updatedAt, categoryId, includeCategoryChildren, offset, limit, expand, fields, order, cartId, regionId, currencyCode, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreProductsListRes>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getProductsProduct
     * @param id The id of the Product. (required)
     * @param salesChannelId The sales channel used when fetching the product. (optional)
     * @param cartId The ID of the customer&#x27;s cart. (optional)
     * @param regionId The ID of the region the customer is using. This is helpful to ensure correct prices are retrieved for a region. (optional)
     * @param fields (Comma separated) Which fields should be included in the result. (optional)
     * @param expand (Comma separated) Which fields should be expanded in each product of the result. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. This is helpful to ensure correct prices are retrieved for a currency. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getProductsProductCall(String id, String salesChannelId, String cartId, String regionId, String fields, String expand, String currencyCode, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/products/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (salesChannelId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sales_channel_id", salesChannelId));
        if (cartId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("cart_id", cartId));
        if (regionId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("region_id", regionId));
        if (fields != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fields", fields));
        if (expand != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("expand", expand));
        if (currencyCode != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("currency_code", currencyCode));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getProductsProductValidateBeforeCall(String id, String salesChannelId, String cartId, String regionId, String fields, String expand, String currencyCode, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getProductsProduct(Async)");
        }
        
        com.squareup.okhttp.Call call = getProductsProductCall(id, salesChannelId, cartId, regionId, fields, expand, currencyCode, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a Product
     * Retrieves a Product.
     * @param id The id of the Product. (required)
     * @param salesChannelId The sales channel used when fetching the product. (optional)
     * @param cartId The ID of the customer&#x27;s cart. (optional)
     * @param regionId The ID of the region the customer is using. This is helpful to ensure correct prices are retrieved for a region. (optional)
     * @param fields (Comma separated) Which fields should be included in the result. (optional)
     * @param expand (Comma separated) Which fields should be expanded in each product of the result. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. This is helpful to ensure correct prices are retrieved for a currency. (optional)
     * @return StoreProductsRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StoreProductsRes getProductsProduct(String id, String salesChannelId, String cartId, String regionId, String fields, String expand, String currencyCode) throws ApiException {
        ApiResponse<StoreProductsRes> resp = getProductsProductWithHttpInfo(id, salesChannelId, cartId, regionId, fields, expand, currencyCode);
        return resp.getData();
    }

    /**
     * Get a Product
     * Retrieves a Product.
     * @param id The id of the Product. (required)
     * @param salesChannelId The sales channel used when fetching the product. (optional)
     * @param cartId The ID of the customer&#x27;s cart. (optional)
     * @param regionId The ID of the region the customer is using. This is helpful to ensure correct prices are retrieved for a region. (optional)
     * @param fields (Comma separated) Which fields should be included in the result. (optional)
     * @param expand (Comma separated) Which fields should be expanded in each product of the result. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. This is helpful to ensure correct prices are retrieved for a currency. (optional)
     * @return ApiResponse&lt;StoreProductsRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StoreProductsRes> getProductsProductWithHttpInfo(String id, String salesChannelId, String cartId, String regionId, String fields, String expand, String currencyCode) throws ApiException {
        com.squareup.okhttp.Call call = getProductsProductValidateBeforeCall(id, salesChannelId, cartId, regionId, fields, expand, currencyCode, null, null);
        Type localVarReturnType = new TypeToken<StoreProductsRes>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a Product (asynchronously)
     * Retrieves a Product.
     * @param id The id of the Product. (required)
     * @param salesChannelId The sales channel used when fetching the product. (optional)
     * @param cartId The ID of the customer&#x27;s cart. (optional)
     * @param regionId The ID of the region the customer is using. This is helpful to ensure correct prices are retrieved for a region. (optional)
     * @param fields (Comma separated) Which fields should be included in the result. (optional)
     * @param expand (Comma separated) Which fields should be expanded in each product of the result. (optional)
     * @param currencyCode The 3 character ISO currency code to set prices based on. This is helpful to ensure correct prices are retrieved for a currency. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getProductsProductAsync(String id, String salesChannelId, String cartId, String regionId, String fields, String expand, String currencyCode, final ApiCallback<StoreProductsRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getProductsProductValidateBeforeCall(id, salesChannelId, cartId, regionId, fields, expand, currencyCode, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StoreProductsRes>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postProductsSearch
     * @param q The query to run the search with. (required)
     * @param offset How many products to skip in the result. (optional)
     * @param limit Limit the number of products returned. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postProductsSearchCall(String q, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/products/search";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (q != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("q", q));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postProductsSearchValidateBeforeCall(String q, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'q' is set
        if (q == null) {
            throw new ApiException("Missing the required parameter 'q' when calling postProductsSearch(Async)");
        }
        
        com.squareup.okhttp.Call call = postProductsSearchCall(q, offset, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Search Products
     * Run a search query on products using the search engine installed on Medusa
     * @param q The query to run the search with. (required)
     * @param offset How many products to skip in the result. (optional)
     * @param limit Limit the number of products returned. (optional)
     * @return StorePostSearchRes
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public StorePostSearchRes postProductsSearch(String q, Integer offset, Integer limit) throws ApiException {
        ApiResponse<StorePostSearchRes> resp = postProductsSearchWithHttpInfo(q, offset, limit);
        return resp.getData();
    }

    /**
     * Search Products
     * Run a search query on products using the search engine installed on Medusa
     * @param q The query to run the search with. (required)
     * @param offset How many products to skip in the result. (optional)
     * @param limit Limit the number of products returned. (optional)
     * @return ApiResponse&lt;StorePostSearchRes&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<StorePostSearchRes> postProductsSearchWithHttpInfo(String q, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = postProductsSearchValidateBeforeCall(q, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<StorePostSearchRes>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Search Products (asynchronously)
     * Run a search query on products using the search engine installed on Medusa
     * @param q The query to run the search with. (required)
     * @param offset How many products to skip in the result. (optional)
     * @param limit Limit the number of products returned. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postProductsSearchAsync(String q, Integer offset, Integer limit, final ApiCallback<StorePostSearchRes> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postProductsSearchValidateBeforeCall(q, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<StorePostSearchRes>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
