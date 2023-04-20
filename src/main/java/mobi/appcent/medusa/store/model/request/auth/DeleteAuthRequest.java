package mobi.appcent.medusa.store.model.request.auth;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by erenalpaslan on 4.03.2023
 */
public class DeleteAuthRequest extends BaseRequest<Void> {

    private final MedusaSdkClient client;

    public DeleteAuthRequest(MedusaSdkClient client) {
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

        return client.buildCall(path, HttpMethod.DELETE, null, null, null, headers, null);
    }

    @Override
    public ApiResponse<Void> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<Void> callback) throws ApiException {
        Call call = buildCall();
        Type type = new TypeToken<ApiResponse<Void>>(){}.getType();
        client.executeAsync(call, type, callback);
    }
}
