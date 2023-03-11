package mobi.appcent.medusa.store.model.request.auth;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreAuthRes;
import mobi.appcent.medusa.store.model.response.StorePostAuthReq;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by erenalpaslan on 5.03.2023
 */
public class PostAuthRequest extends BaseRequest<StoreAuthRes> {

    private final MedusaSdkClient client;
    private String email;
    private String password;

    public PostAuthRequest(MedusaSdkClient client) {
        this.client = client;
    }

    public PostAuthRequest email(String email) {
        this.email = email;
        return this;
    }

    public PostAuthRequest password(String password) {
        this.password = password;
        return this;
    }


    @Override
    protected Call buildCall() throws ApiException {
        Object body = new StorePostAuthReq()
                .email(email)
                .password(password);

        // create path and map variables
        String path = UrlConstant.AUTH_PATH;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);
        return client.buildCall(path, HttpMethod.POST, null, null, body, headers, null, null);
    }

    @Override
    public ApiResponse<StoreAuthRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreAuthRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
