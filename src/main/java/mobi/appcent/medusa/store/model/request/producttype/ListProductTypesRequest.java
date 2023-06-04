package mobi.appcent.medusa.store.model.request.producttype;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.CreatedAt3;
import mobi.appcent.medusa.store.model.response.ProductTagsResponse;
import mobi.appcent.medusa.store.model.response.StoreProductTypesListRes;
import mobi.appcent.medusa.store.model.response.UpdatedAt3;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 10.03.2023
 */
public class ListProductTypesRequest extends BaseRequest<StoreProductTypesListRes> {

    private final MedusaSdkClient client;
    private Integer limit;
    private Integer offset;
    private String order;
    private String discountConditionId;
    private List<String> value;
    private List<String> id;
    private String q;
    private CreatedAt3 createdAt;
    private UpdatedAt3 updatedAt;

    public ListProductTypesRequest(MedusaSdkClient client) {
        this.client = client;
    }

    public ListProductTypesRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public ListProductTypesRequest offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ListProductTypesRequest discountConditionId(String discountConditionId) {
        this.discountConditionId = discountConditionId;
        return this;
    }

    public ListProductTypesRequest order(String order) {
        this.order = order;
        return this;
    }

    public ListProductTypesRequest value(List<String> value) {
        this.value = value;
        return this;
    }

    public ListProductTypesRequest id(List<String> id) {
        this.id = id;
        return this;
    }

    public ListProductTypesRequest q(String q) {
        this.q = q;
        return this;
    }

    public ListProductTypesRequest createdAt(CreatedAt3 createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ListProductTypesRequest updatedAt(UpdatedAt3 updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.PRODUCT_TYPE_PATH;
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
    public ApiResponse<StoreProductTypesListRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call, getType());
    }

    @Override
    public void executeAsync(ApiCallback<StoreProductTypesListRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, getType(), callback);
    }

    @Override
    public Type getType() {
        return new TypeToken<StoreProductTypesListRes>(){}.getType();
    }
}
