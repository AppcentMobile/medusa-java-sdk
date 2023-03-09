package mobi.appcent.medusa.store.model.request.order;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.QueryParamConstant;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.ShippingAddress;
import mobi.appcent.medusa.store.model.response.StoreOrdersRes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 9.03.2023
 */
public class LookUpOrderByFiltersRequest extends BaseRequest<StoreOrdersRes> {

    private final MedusaSdkClient client;
    private final BigDecimal displayId;
    private final String email;
    private String fields;
    private String expand;
    private ShippingAddress shippingAddress;

    public LookUpOrderByFiltersRequest(MedusaSdkClient client, BigDecimal displayId, String email) {
        this.client = client;
        this.displayId = displayId;
        this.email = email;
    }

    public LookUpOrderByFiltersRequest fields(String fields) {
        this.fields = fields;
        return this;
    }

    public LookUpOrderByFiltersRequest expand(String expand) {
        this.expand = expand;
        return this;
    }

    public LookUpOrderByFiltersRequest expand(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.ORDER_PATH;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (displayId != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.DISPLAY_ID, displayId));
        if (fields != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.FIELDS, fields));
        if (expand != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.EXPAND, expand));
        if (email != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.EMAIL, email));
        if (shippingAddress != null)
            localVarQueryParams.addAll(client.parameterToPair(QueryParamConstant.SHIPPING_ADDRESS, shippingAddress));


        return client.buildCall(path, HttpMethod.GET, localVarQueryParams, null, null, headers, null, null);
    }

    @Override
    public ApiResponse<StoreOrdersRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreOrdersRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
