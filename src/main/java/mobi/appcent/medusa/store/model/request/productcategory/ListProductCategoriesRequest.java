package mobi.appcent.medusa.store.model.request.productcategory;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreProductCategoriesListRes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 10.03.2023
 */
public class ListProductCategoriesRequest extends BaseRequest<StoreProductCategoriesListRes> {

    private final MedusaSdkClient client;
    private String q;
    private String parentCategoryId;
    private Integer offset;
    private Integer limit;

    public ListProductCategoriesRequest(MedusaSdkClient client) {
        this.client = client;
    }

    public ListProductCategoriesRequest q(String q) {
        this.q = q;
        return this;
    }

    public ListProductCategoriesRequest parentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
        return this;
    }

    public ListProductCategoriesRequest offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ListProductCategoriesRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.PRODUCT_CATEGORY_PATH;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (q != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.Q, q));
        if (parentCategoryId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.PARENT_CATEGORY_ID, parentCategoryId));
        if (offset != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.OFFSET, offset));
        if (limit != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.LIMIT, limit));


        String[] localVarAuthNames = new String[] { "cookie_auth" };
        return client.buildCall(path, HttpMethod.GET, localVarQueryParams, null, null, headers, null, localVarAuthNames);
    }

    @Override
    public ApiResponse<StoreProductCategoriesListRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreProductCategoriesListRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
