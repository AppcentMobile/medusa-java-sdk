package mobi.appcent.medusa.store.model.request.productvariant;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.InventoryQuantity;
import mobi.appcent.medusa.store.model.response.StoreVariantsListRes;
import mobi.appcent.medusa.store.model.response.Title;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 11.03.2023
 */
public class GetProductVariantsRequest extends BaseRequest<StoreVariantsListRes> {

    private final MedusaSdkClient client;
    private String ids;
    private String salesChannelId;
    private String expand;
    private BigDecimal offset;
    private BigDecimal limit;
    private String cartId;
    private String regionId;
    private String currencyCode;
    private Title title;
    private InventoryQuantity inventoryQuantity;

    public GetProductVariantsRequest(MedusaSdkClient client) {
        this.client = client;
    }

    public GetProductVariantsRequest ids(String ids) {
        this.ids = ids;
        return this;
    }

    public GetProductVariantsRequest salesChannelId(String salesChannelId) {
        this.salesChannelId = salesChannelId;
        return this;
    }

    public GetProductVariantsRequest expand(String expand) {
        this.expand = expand;
        return this;
    }

    public GetProductVariantsRequest offset(BigDecimal offset) {
        this.offset = offset;
        return this;
    }

    public GetProductVariantsRequest limit(BigDecimal limit) {
        this.limit = limit;
        return this;
    }

    public GetProductVariantsRequest cartId(String cartId) {
        this.cartId = cartId;
        return this;
    }

    public GetProductVariantsRequest regionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    public GetProductVariantsRequest currencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public GetProductVariantsRequest title(Title title) {
        this.title = title;
        return this;
    }

    public GetProductVariantsRequest inventoryQuantity(InventoryQuantity inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.PRODUCT_VARIANTS_PATH;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (ids != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.IDS, ids));
        if (salesChannelId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.SALES_CHANNEL_ID, salesChannelId));
        if (expand != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.EXPAND, expand));
        if (offset != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.OFFSET, offset));
        if (limit != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.LIMIT, limit));
        if (cartId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CART_ID, cartId));
        if (regionId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.REGION_ID, regionId));
        if (currencyCode != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CURRENCY_CODE, currencyCode));
        if (title != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.TITLE, title));
        if (inventoryQuantity != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.INVENTORY_QUANTITY, inventoryQuantity));


        return client.buildCall(path, HttpMethod.GET, localVarQueryParams, null, null, headers, null);
    }

    @Override
    public ApiResponse<StoreVariantsListRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreVariantsListRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
