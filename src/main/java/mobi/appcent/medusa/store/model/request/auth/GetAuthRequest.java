package mobi.appcent.medusa.store.model.request.auth;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreAuthRes;
import mobi.appcent.medusa.store.model.response.StoreGetAuthEmailRes;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by erenalpaslan on 5.03.2023
 */
public class GetAuthRequest extends BaseRequest<StoreAuthRes> {

    private final MedusaSdkClient client;

    public GetAuthRequest(MedusaSdkClient client) {
        this.client = client;
    }

    @Override
    protected Call buildCall() throws ApiException {

        String path = UrlConstant.AUTH_PATH;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        return client.buildCall(path, HttpMethod.GET, null, null, null, headers, null);
    }

    @Override
    public ApiResponse<StoreAuthRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call, getType());
    }

    @Override
    public void executeAsync(ApiCallback<StoreAuthRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, getType(), callback);
    }

    @Override
    public Type getType() {
        return new TypeToken<StoreAuthRes>(){}.getType();
    }
}
