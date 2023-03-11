package mobi.appcent.medusa.store.model.request.productvariant;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreVariantsRes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 11.03.2023
 */
public class GetProductVariantRequest extends BaseRequest<StoreVariantsRes> {

    private final MedusaSdkClient client;
    private final String variantId;
    private String cartId;
    private String salesChannelId;
    private String regionId;
    private String currencyCode;

    public GetProductVariantRequest(MedusaSdkClient client, String variantId) {
        this.client = client;
        this.variantId = variantId;
    }

    public GetProductVariantRequest cartId(String cartId) {
        this.cartId = cartId;
        return this;
    }

    public GetProductVariantRequest salesChannelId(String salesChannelId) {
        this.salesChannelId = salesChannelId;
        return this;
    }

    public GetProductVariantRequest regionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    public GetProductVariantRequest currencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.PRODUCT_VARIANTS_PATH + "/" + variantId;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (cartId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CART_ID, cartId));
        if (salesChannelId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.SALES_CHANNEL_ID, salesChannelId));
        if (regionId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.REGION_ID, regionId));
        if (currencyCode != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CURRENCY_CODE, currencyCode));


        return client.buildCall(path, HttpMethod.GET, localVarQueryParams, null, null, headers, null, null);
    }

    @Override
    public ApiResponse<StoreVariantsRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreVariantsRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
