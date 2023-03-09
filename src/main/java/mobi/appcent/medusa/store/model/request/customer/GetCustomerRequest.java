package mobi.appcent.medusa.store.model.request.customer;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreCustomersRes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 9.03.2023
 */
public class GetCustomerRequest extends BaseRequest<StoreCustomersRes> {

    private final MedusaSdkClient client;

    public GetCustomerRequest(MedusaSdkClient client) {
        this.client = client;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.CUSTOMER_PATH + "/me";
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        String[] localVarAuthNames = new String[] { "cookie_auth" };
        return client.buildCall(path, HttpMethod.GET, null, null, null, headers, null, localVarAuthNames);
    }

    @Override
    public ApiResponse<StoreCustomersRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreCustomersRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
