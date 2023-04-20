package mobi.appcent.medusa.store.model.request.product;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreProductsRes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 10.03.2023
 */
public class GetProductRequest extends BaseRequest<StoreProductsRes> {

    private final MedusaSdkClient client;
    private final String id;
    private String salesChannelId;
    private String cartId;
    private String regionId;
    private String fields;
    private String expand;
    private String currencyCode;

    public GetProductRequest(MedusaSdkClient client, String id) {
        this.client = client;
        this.id = id;
    }

    public GetProductRequest salesChannelId(String salesChannelId) {
        this.salesChannelId = salesChannelId;
        return this;
    }

    public GetProductRequest cartId(String cartId) {
        this.cartId = cartId;
        return this;
    }

    public GetProductRequest regionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    public GetProductRequest fields(String fields) {
        this.fields = fields;
        return this;
    }

    public GetProductRequest expand(String expand) {
        this.expand = expand;
        return this;
    }

    public GetProductRequest currencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.PRODUCT_PATH + "/" + id;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (salesChannelId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.SALES_CHANNEL_ID, salesChannelId));
        if (cartId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CART_ID, cartId));
        if (regionId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.REGION_ID, regionId));
        if (fields != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.FIELDS, fields));
        if (expand != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.EXPAND, expand));
        if (currencyCode != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CURRENCY_CODE, currencyCode));


        return client.buildCall(path, HttpMethod.GET, localVarQueryParams, null, null, headers, null);
    }

    @Override
    public ApiResponse<StoreProductsRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreProductsRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
