package mobi.appcent.medusa.store.model.request.orderedit;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreOrderEditsRes;
import mobi.appcent.medusa.store.model.response.StoreOrdersRes;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 10.03.2023
 */
public class CompletesOrderEditRequest extends BaseRequest<StoreOrderEditsRes> {

    private final MedusaSdkClient client;
    private final String id;

    public CompletesOrderEditRequest(MedusaSdkClient client, String id) {
        this.client = client;
        this.id = id;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.ORDER_EDIT_PATH + "/" + id + "/complete";
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        return client.buildCall(path, HttpMethod.POST, null, null, null, headers, null);
    }

    @Override
    public ApiResponse<StoreOrderEditsRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call, getType());
    }

    @Override
    public void executeAsync(ApiCallback<StoreOrderEditsRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, getType(), callback);
    }

    @Override
    public Type getType() {
        return new TypeToken<StoreOrderEditsRes>(){}.getType();
    }
}
