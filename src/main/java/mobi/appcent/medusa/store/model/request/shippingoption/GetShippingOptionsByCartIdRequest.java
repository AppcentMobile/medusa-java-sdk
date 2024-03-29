package mobi.appcent.medusa.store.model.request.shippingoption;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreReturnsRes;
import mobi.appcent.medusa.store.model.response.StoreShippingOptionsListRes;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by erenalpaslan on 11.03.2023
 */
public class GetShippingOptionsByCartIdRequest extends BaseRequest<StoreShippingOptionsListRes> {

    private final MedusaSdkClient client;
    private final String cartId;

    public GetShippingOptionsByCartIdRequest(MedusaSdkClient client, String cartId) {
        this.client = client;
        this.cartId = cartId;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.SHIPPING_OPTION_PATH + "/" + cartId;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        return client.buildCall(path, HttpMethod.GET, null, null, null, headers, null);
    }

    @Override
    public ApiResponse<StoreShippingOptionsListRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call, getType());
    }

    @Override
    public void executeAsync(ApiCallback<StoreShippingOptionsListRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, getType(), callback);
    }

    @Override
    public Type getType() {
        return new TypeToken<StoreShippingOptionsListRes>(){}.getType();
    }
}
