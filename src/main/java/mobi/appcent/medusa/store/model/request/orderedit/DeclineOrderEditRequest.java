package mobi.appcent.medusa.store.model.request.orderedit;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreOrderEditsRes;
import mobi.appcent.medusa.store.model.response.StorePostOrderEditsOrderEditDecline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 10.03.2023
 */
public class DeclineOrderEditRequest extends BaseRequest<StoreOrderEditsRes> {

    private final MedusaSdkClient client;
    private final String id;
    private StorePostOrderEditsOrderEditDecline body;

    public DeclineOrderEditRequest(MedusaSdkClient client, String id) {
        this.client = client;
        this.id = id;
    }

    public DeclineOrderEditRequest body(StorePostOrderEditsOrderEditDecline body) {
        this.body = body;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.ORDER_EDIT_PATH + "/" + id + "/decline";
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        return client.buildCall(path, HttpMethod.POST, null, null, body, headers, null, null);
    }

    @Override
    public ApiResponse<StoreOrderEditsRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreOrderEditsRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
