package mobi.appcent.medusa.store.model.request.producttag;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.CreatedAt2;
import mobi.appcent.medusa.store.model.response.ProductTagsResponse;
import mobi.appcent.medusa.store.model.response.StoreProductCategoriesListRes;
import mobi.appcent.medusa.store.model.response.UpdatedAt2;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 10.03.2023
 */
public class ListProductTagsRequest extends BaseRequest<ProductTagsResponse> {

    private final MedusaSdkClient client;
    private Integer limit;
    private Integer offset;
    private String order;
    private String discountConditionId;
    private List<String> value;
    private List<String> id;
    private String q;
    private CreatedAt2 createdAt;
    private UpdatedAt2 updatedAt;

    public ListProductTagsRequest(MedusaSdkClient client) {
        this.client = client;
    }

    public ListProductTagsRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public ListProductTagsRequest offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ListProductTagsRequest order(String order) {
        this.order = order;
        return this;
    }

    public ListProductTagsRequest discountConditionId(String discountConditionId) {
        this.discountConditionId = discountConditionId;
        return this;
    }

    public ListProductTagsRequest value(List<String> value) {
        this.value = value;
        return this;
    }

    public ListProductTagsRequest id(List<String> id) {
        this.id = id;
        return this;
    }

    public ListProductTagsRequest q(String q) {
        this.q = q;
        return this;
    }

    public ListProductTagsRequest createdAt(CreatedAt2 createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ListProductTagsRequest updatedAt(UpdatedAt2 updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.PRODUCT_TAG_PATH;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (limit != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.LIMIT, limit));
        if (offset != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.OFFSET, offset));
        if (order != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.ORDER, order));
        if (discountConditionId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.DISCOUNT_CONDITION_ID, discountConditionId));
        if (value != null)
            localVarCollectionQueryParams.addAll(client.parameterToPairs(QueryParamConstant.CSV_FORMAT, QueryParamConstant.VALUE, value));
        if (id != null)
            localVarCollectionQueryParams.addAll(client.parameterToPairs(QueryParamConstant.CSV_FORMAT, QueryParamConstant.ID, id));
        if (q != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.Q, q));
        if (createdAt != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CREATED_AT, createdAt));
        if (updatedAt != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.UPDATED_AT, updatedAt));


        return client.buildCall(path, HttpMethod.GET, localVarQueryParams, localVarCollectionQueryParams, null, headers, null);
    }

    @Override
    public ApiResponse<ProductTagsResponse> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call, getType());
    }

    @Override
    public void executeAsync(ApiCallback<ProductTagsResponse> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, getType(), callback);
    }

    @Override
    public Type getType() {
        return new TypeToken<ProductTagsResponse>(){}.getType();
    }
}
