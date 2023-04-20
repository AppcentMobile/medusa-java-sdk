package mobi.appcent.medusa.store.model.request.product;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StorePostSearchRes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 10.03.2023
 */
public class SearchProductsRequest extends BaseRequest<StorePostSearchRes> {

    private final MedusaSdkClient client;
    private final String q;
    private Integer offset;
    private Integer limit;

    public SearchProductsRequest(MedusaSdkClient client, String q) {
        this.client = client;
        this.q = q;
    }

    public SearchProductsRequest offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public SearchProductsRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.PRODUCT_PATH + "/search";
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (q != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.Q, q));
        if (offset != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.OFFSET, offset));
        if (limit != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.LIMIT, limit));

        return client.buildCall(path, HttpMethod.POST, localVarQueryParams, null, null, headers, null);
    }

    @Override
    public ApiResponse<StorePostSearchRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StorePostSearchRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
