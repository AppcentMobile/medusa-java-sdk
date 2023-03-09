package mobi.appcent.medusa.store.model.request.customer;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreCustomersListPaymentMethodsRes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by erenalpaslan on 9.03.2023
 */
public class GetPaymentMethodsRequest extends BaseRequest<StoreCustomersListPaymentMethodsRes> {

    private final MedusaSdkClient client;

    public GetPaymentMethodsRequest(MedusaSdkClient client) {
        this.client = client;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.CUSTOMER_PATH + "/me/payment-methods";
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        String[] localVarAuthNames = new String[] { "cookie_auth" };
        return client.buildCall(path, HttpMethod.GET, null, null, null, headers, null, localVarAuthNames);
    }

    @Override
    public ApiResponse<StoreCustomersListPaymentMethodsRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreCustomersListPaymentMethodsRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
