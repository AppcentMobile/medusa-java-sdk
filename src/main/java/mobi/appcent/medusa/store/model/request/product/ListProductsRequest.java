package mobi.appcent.medusa.store.model.request.product;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.CreatedAt4;
import mobi.appcent.medusa.store.model.response.Id;
import mobi.appcent.medusa.store.model.response.StoreProductsListRes;
import mobi.appcent.medusa.store.model.response.UpdatedAt4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 10.03.2023
 */
public class ListProductsRequest extends BaseRequest<StoreProductsListRes> {

    private final MedusaSdkClient client;
    private String q;
    private Id id;
    private List<String> salesChannelId;
    private List<String> collectionId;
    private List<String> typeId;
    private List<String> tags;
    private String title;
    private String description;
    private String handle;
    private Boolean isGiftcard;
    private CreatedAt4 createdAt;
    private UpdatedAt4 updatedAt;
    private List<String> categoryId;
    private Boolean includeCategoryChildren;
    private Integer offset;
    private Integer limit;
    private String expand;
    private String fields;
    private String order;
    private String cartId;
    private String regionId;
    private String currencyCode;

    public ListProductsRequest(MedusaSdkClient client) {
        this.client = client;
    }

    public ListProductsRequest q(String q) {
        this.q = q;
        return this;
    }

    public ListProductsRequest id(Id id) {
        this.id = id;
        return this;
    }

    public ListProductsRequest salesChannelId(List<String> salesChannelId) {
        this.salesChannelId = salesChannelId;
        return this;
    }

    public ListProductsRequest collectionId(List<String> collectionId) {
        this.collectionId = collectionId;
        return this;
    }

    public ListProductsRequest typeId(List<String> typeId) {
        this.typeId = typeId;
        return this;
    }

    public ListProductsRequest tags(List<String> tags) {
        this.tags = tags;
        return this;
    }
    public ListProductsRequest title(String title) {
        this.title = title;
        return this;
    }

    public ListProductsRequest description(String description) {
        this.description = description;
        return this;
    }
    public ListProductsRequest handle(String handle) {
        this.handle = handle;
        return this;
    }
    public ListProductsRequest isGiftcard(Boolean isGiftcard) {
        this.isGiftcard = isGiftcard;
        return this;
    }

    public ListProductsRequest createdAt(CreatedAt4 createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ListProductsRequest updatedAt(UpdatedAt4 updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public ListProductsRequest categoryId(List<String> categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public ListProductsRequest includeCategoryChildren(Boolean includeCategoryChildren) {
        this.includeCategoryChildren = includeCategoryChildren;
        return this;
    }

    public ListProductsRequest offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ListProductsRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public ListProductsRequest expand(String expand) {
        this.expand = expand;
        return this;
    }

    public ListProductsRequest fields(String fields) {
        this.fields = fields;
        return this;
    }

    public ListProductsRequest order(String order) {
        this.order = order;
        return this;
    }

    public ListProductsRequest cartId(String cartId) {
        this.cartId = cartId;
        return this;
    }

    public ListProductsRequest regionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    public ListProductsRequest currencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.PRODUCT_PATH;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);


        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (q != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.Q, q));
        if (id != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.ID, id));
        if (salesChannelId != null)
            localVarCollectionQueryParams.addAll(client.parameterToPairs(QueryParamConstant.CSV_FORMAT, QueryParamConstant.SALES_CHANNEL_ID, salesChannelId));
        if (collectionId != null)
            localVarCollectionQueryParams.addAll(client.parameterToPairs(QueryParamConstant.CSV_FORMAT, QueryParamConstant.COLLECTION_ID, collectionId));
        if (typeId != null)
            localVarCollectionQueryParams.addAll(client.parameterToPairs(QueryParamConstant.CSV_FORMAT, QueryParamConstant.TYPE_ID, typeId));
        if (tags != null)
            localVarCollectionQueryParams.addAll(client.parameterToPairs(QueryParamConstant.CSV_FORMAT, QueryParamConstant.TAGS, tags));
        if (title != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.TITLE, title));
        if (description != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.DESCRIPTION, description));
        if (handle != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.HANDLE, handle));
        if (isGiftcard != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.IS_GIFTCARD, isGiftcard));
        if (createdAt != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CREATED_AT, createdAt));
        if (updatedAt != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.UPDATED_AT, updatedAt));
        if (categoryId != null)
            localVarCollectionQueryParams.addAll(client.parameterToPairs(QueryParamConstant.CSV_FORMAT, QueryParamConstant.CATEGORY_ID, categoryId));
        if (includeCategoryChildren != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.INCLUDE_CATEGORY_CHILDREN, includeCategoryChildren));
        if (offset != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.OFFSET, offset));
        if (limit != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.LIMIT, limit));
        if (expand != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.EXPAND, expand));
        if (fields != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.FIELDS, fields));
        if (order != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.ORDER, order));
        if (cartId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CART_ID, cartId));
        if (regionId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.REGION_ID, regionId));
        if (currencyCode != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CURRENCY_CODE, currencyCode));


        return client.buildCall(path, HttpMethod.GET, localVarQueryParams, localVarCollectionQueryParams, null, headers, null);
    }

    @Override
    public ApiResponse<StoreProductsListRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreProductsListRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
