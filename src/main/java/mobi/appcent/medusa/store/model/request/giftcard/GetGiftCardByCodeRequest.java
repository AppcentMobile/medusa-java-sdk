package mobi.appcent.medusa.store.model.request.giftcard;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StoreCustomersRes;
import mobi.appcent.medusa.store.model.response.StoreGiftCardsRes;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 9.03.2023
 */
public class GetGiftCardByCodeRequest extends BaseRequest<StoreGiftCardsRes> {

    private final MedusaSdkClient client;
    private final String code;

    public GetGiftCardByCodeRequest(MedusaSdkClient client, String code) {
        this.client = client;
        this.code = code;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.GIFT_CARD_PATH + "/" + code;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);

        return client.buildCall(path, HttpMethod.GET, null, null, null, headers, null);
    }

    @Override
    public ApiResponse<StoreGiftCardsRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call, getType());
    }

    @Override
    public void executeAsync(ApiCallback<StoreGiftCardsRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }

    @Override
    public Type getType() {
        return new TypeToken<StoreGiftCardsRes>(){}.getType();
    }
}
