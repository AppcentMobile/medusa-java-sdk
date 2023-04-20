package mobi.appcent.medusa.store.model.request.swap;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreSwapsRes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by erenalpaslan on 11.03.2023
 */
public class GetSwapByCartIdRequest extends BaseRequest<StoreSwapsRes> {

    private final MedusaSdkClient client;
    private final String cartId;

    public GetSwapByCartIdRequest(MedusaSdkClient client, String cartId) {
        this.client = client;
        this.cartId = cartId;
    }


    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.SWAP_PATH + "/" + cartId;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        return client.buildCall(path, HttpMethod.GET, null, null, null, headers, null);
    }

    @Override
    public ApiResponse<StoreSwapsRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StoreSwapsRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
