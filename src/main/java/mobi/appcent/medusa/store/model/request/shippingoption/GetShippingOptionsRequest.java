package mobi.appcent.medusa.store.model.request.shippingoption;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreShippingOptionsListRes;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 11.03.2023
 */
public class GetShippingOptionsRequest extends BaseRequest<StoreShippingOptionsListRes> {

    private final MedusaSdkClient client;
    private Boolean isReturn;
    private String productIds;
    private String regionId;

    public GetShippingOptionsRequest(MedusaSdkClient client) {
        this.client = client;
    }

    public GetShippingOptionsRequest isReturn(Boolean isReturn) {
        this.isReturn = isReturn;
        return this;
    }

    public GetShippingOptionsRequest productIds(String productIds) {
        this.productIds = productIds;
        return this;
    }

    public GetShippingOptionsRequest regionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.SHIPPING_OPTION_PATH;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (isReturn != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.IS_RETURN, isReturn));
        if (productIds != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.PRODUCT_IDS, productIds));
        if (regionId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.REGION_ID, regionId));


        return client.buildCall(path, HttpMethod.GET, localVarQueryParams, null, null, headers, null);
    }

    @Override
    public ApiResponse<StoreShippingOptionsListRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call, getType());
    }

    @Override
    public void executeAsync(ApiCallback<StoreShippingOptionsListRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, getType(), callback);
    }

    @Override
    public Type getType() {
        return new TypeToken<StoreShippingOptionsListRes>(){}.getType();
    }
}
