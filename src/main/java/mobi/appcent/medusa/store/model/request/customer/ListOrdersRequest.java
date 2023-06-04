package mobi.appcent.medusa.store.model.request.customer;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 9.03.2023
 */
public class ListOrdersRequest extends BaseRequest<StoreCustomersListOrdersRes> {

    private final MedusaSdkClient client;
    private String q;
    private String id;
    private List<String> status;
    private List<String> fulfillmentStatus;
    private List<String> paymentStatus;
    private String displayId;
    private String cartId;
    private String email;
    private String regionId;
    private String currencyCode;
    private String taxRate;
    private CreatedAt1 createdAt;
    private UpdatedAt1 updatedAt;
    private CanceledAt canceledAt;
    private Integer limit;
    private Integer offset;
    private String fields;
    private String expand;

    public ListOrdersRequest(MedusaSdkClient client) {
        this.client = client;
    }

    public ListOrdersRequest q(String q) {
        this.q = q;
        return this;
    }

    public ListOrdersRequest id(String id) {
        this.id = id;
        return this;
    }

    public ListOrdersRequest status(List<String> status) {
        this.status = status;
        return this;
    }

    public ListOrdersRequest fulfillmentStatus(List<String> fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
        return this;
    }

    public ListOrdersRequest paymentStatus(List<String> paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    public ListOrdersRequest displayId(String displayId) {
        this.displayId = displayId;
        return this;
    }

    public ListOrdersRequest cartId(String cartId) {
        this.cartId = cartId;
        return this;
    }

    public ListOrdersRequest email(String email) {
        this.email = email;
        return this;
    }

    public ListOrdersRequest regionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    public ListOrdersRequest currencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public ListOrdersRequest taxRate(String taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    public ListOrdersRequest createdAt(CreatedAt1 createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ListOrdersRequest updatedAt(UpdatedAt1 updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public ListOrdersRequest canceledAt(CanceledAt canceledAt) {
        this.canceledAt = canceledAt;
        return this;
    }

    public ListOrdersRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public ListOrdersRequest offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ListOrdersRequest fields(String fields) {
        this.fields = fields;
        return this;
    }

    public ListOrdersRequest expand(String expand) {
        this.expand = expand;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.CUSTOMER_PATH + "/me/orders";
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);


        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (q != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.Q, q));
        if (id != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.ID, id));
        if (status != null)
            localVarCollectionQueryParams.addAll(client.parameterToPairs(QueryParamConstant.CSV_FORMAT, QueryParamConstant.STATUS, status));
        if (fulfillmentStatus != null)
            localVarCollectionQueryParams.addAll(client.parameterToPairs(QueryParamConstant.CSV_FORMAT, QueryParamConstant.FULFILLMENT_STATUS, fulfillmentStatus));
        if (paymentStatus != null)
            localVarCollectionQueryParams.addAll(client.parameterToPairs(QueryParamConstant.CSV_FORMAT, QueryParamConstant.PAYMENT_STATUS, paymentStatus));
        if (displayId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.DISPLAY_ID, displayId));
        if (cartId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CART_ID, cartId));
        if (email != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.EMAIL, email));
        if (regionId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.REGION_ID, regionId));
        if (currencyCode != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CURRENCY_CODE, currencyCode));
        if (taxRate != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.TAX_RATE, taxRate));
        if (createdAt != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CREATED_AT, createdAt));
        if (updatedAt != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.UPDATED_AT, updatedAt));
        if (canceledAt != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.CANCELED_AT, canceledAt));
        if (limit != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.LIMIT, limit));
        if (offset != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.OFFSET, offset));
        if (fields != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.FIELDS, fields));
        if (expand != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.EXPAND, expand));

        return client.buildCall(path, HttpMethod.GET, localVarQueryParams, localVarCollectionQueryParams, null, headers, null);
    }

    @Override
    public ApiResponse<StoreCustomersListOrdersRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call, getType());
    }

    @Override
    public void executeAsync(ApiCallback<StoreCustomersListOrdersRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, getType(), callback);
    }

    @Override
    public Type getType() {
        return new TypeToken<StoreCustomersListOrdersRes>(){}.getType();
    }
}
