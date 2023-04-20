package mobi.appcent.medusa.store.model.request.cart;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreCartsRes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 8.03.2023
 */
public class RefreshPaymentSessionRequest extends BaseRequest<StoreCartsRes> {

    private final MedusaSdkClient client;
    private final String id;
    private final String providerId;

    public RefreshPaymentSessionRequest(MedusaSdkClient client, String id, String providerId) {
        this.client = client;
        this.id = id;
        this.providerId = providerId;
    }

    @Override
    protected Call buildCall() throws ApiException {
        // create path and map variables
        String path = UrlConstant.CART_PATH + "/" + id + "/payment-sessions/" + providerId + "/refresh";
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        return client.buildCall(path, HttpMethod.POST, null, null, null, headers, null);
    }

    @Override
    public ApiResponse<StoreCartsRes> execute() throws ApiException {
        return null;
    }

    @Override
    public void executeAsync(ApiCallback<StoreCartsRes> callback) throws ApiException {

    }
}