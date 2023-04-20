package mobi.appcent.medusa.store.model.request.region;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.CreatedAt5;
import mobi.appcent.medusa.store.model.response.StoreRegionsListRes;
import mobi.appcent.medusa.store.model.response.UpdatedAt5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 11.03.2023
 */
public class ListRegionsRequest extends BaseRequest<StoreRegionsListRes> {

    private final MedusaSdkClient client;
    private Integer offset;
    private Integer limit;
    private CreatedAt5 createdAt;
    private UpdatedAt5 updatedAt;

    public ListRegionsRequest(MedusaSdkClient client) {
        this.client = client;
    }

    public ListRegionsRequest offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ListRegionsRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public ListRegionsRequest createdAt(CreatedAt5 createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ListRegionsRequest updatedAt(UpdatedAt5 updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.REGION_PATH;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (offset != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.OFFSET, offset));
        if (limit != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.LIMIT, limit));
        if (createdAt != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CREATED_AT, createdAt));
        if (updatedAt != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.UPDATED_AT, updatedAt));

        return client.buildCall(path, HttpMethod.GET, localVarQueryParams, null, null, headers, null);
    }

    @Override
    public ApiResponse<StoreRegionsListRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreRegionsListRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
