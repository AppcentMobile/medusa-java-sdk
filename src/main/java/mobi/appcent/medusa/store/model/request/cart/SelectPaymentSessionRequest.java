package mobi.appcent.medusa.store.model.request.cart;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreCartsRes;
import mobi.appcent.medusa.store.model.response.StorePostCartsCartPaymentSessionReq;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by erenalpaslan on 8.03.2023
 */
public class SelectPaymentSessionRequest extends BaseRequest<StoreCartsRes> {

    private final MedusaSdkClient client;
    private final String id;
    private StorePostCartsCartPaymentSessionReq body;

    public SelectPaymentSessionRequest(MedusaSdkClient client, String id) {
        this.client = client;
        this.id = id;
    }

    public SelectPaymentSessionRequest body(StorePostCartsCartPaymentSessionReq body) {
        this.body = body;
        return this;
    }


    @Override
    protected Call buildCall() throws ApiException {
        // create path and map variables
        String path = UrlConstant.CART_PATH + "/" + id + "/payment-session";
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        return client.buildCall(path, HttpMethod.POST, null, null, body, headers, null);
    }

    @Override
    public ApiResponse<StoreCartsRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call, getType());
    }

    @Override
    public void executeAsync(ApiCallback<StoreCartsRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, getType(), callback);
    }

    @Override
    public Type getType() {
        return new TypeToken<StoreCartsRes>(){}.getType();
    }
}
