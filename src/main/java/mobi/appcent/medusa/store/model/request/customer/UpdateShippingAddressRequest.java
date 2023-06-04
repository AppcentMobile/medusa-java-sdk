package mobi.appcent.medusa.store.model.request.customer;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreCustomersRes;
import mobi.appcent.medusa.store.model.response.StorePostCustomersCustomerAddressesAddressReq;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by erenalpaslan on 9.03.2023
 */
public class UpdateShippingAddressRequest extends BaseRequest<StoreCustomersRes> {

    private final MedusaSdkClient client;
    private final String addressId;
    private StorePostCustomersCustomerAddressesAddressReq body;

    public UpdateShippingAddressRequest(MedusaSdkClient client, String addressId) {
        this.client = client;
        this.addressId = addressId;
    }

    public UpdateShippingAddressRequest body(StorePostCustomersCustomerAddressesAddressReq body) {
        this.body = body;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.CUSTOMER_PATH + "/me/addresses/" + addressId;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        return client.buildCall(path, HttpMethod.POST, null, null, body, headers, null);
    }

    @Override
    public ApiResponse<StoreCustomersRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call, getType());
    }

    @Override
    public void executeAsync(ApiCallback<StoreCustomersRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, getType(), callback);
    }

    @Override
    public Type getType() {
        return new TypeToken<StoreCustomersRes>(){}.getType();
    }
}
