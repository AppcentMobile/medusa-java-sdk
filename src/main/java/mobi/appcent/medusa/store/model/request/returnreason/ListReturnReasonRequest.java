package mobi.appcent.medusa.store.model.request.returnreason;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreReturnReasonsListRes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 11.03.2023
 */
public class ListReturnReasonRequest extends BaseRequest<StoreReturnReasonsListRes> {

    private final MedusaSdkClient client;

    public ListReturnReasonRequest(MedusaSdkClient client) {
        this.client = client;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.RETURN_REASON_PATH;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        return client.buildCall(path, HttpMethod.GET, null, null, null, headers, null, null);
    }

    @Override
    public ApiResponse<StoreReturnReasonsListRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreReturnReasonsListRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
