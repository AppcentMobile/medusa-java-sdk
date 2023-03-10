package mobi.appcent.medusa.store.model.request.paymentcollection;

import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.*;
import mobi.appcent.medusa.store.common.HeaderConstant;
import mobi.appcent.medusa.store.common.HttpMethod;
import mobi.appcent.medusa.store.common.UrlConstant;
import mobi.appcent.medusa.store.model.request.BaseRequest;
import mobi.appcent.medusa.store.model.response.StorePaymentCollectionsRes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by erenalpaslan on 10.03.2023
 */
public class GetPaymentCollectionRequest extends BaseRequest<StorePaymentCollectionsRes> {

    private final MedusaSdkClient client;
    private final String id;
    private String expand;
    private String fields;

    public GetPaymentCollectionRequest(MedusaSdkClient client, String id) {
        this.client = client;
        this.id = id;
    }

    public GetPaymentCollectionRequest expand(String expand) {
        this.expand = expand;
        return this;
    }

    public GetPaymentCollectionRequest fields(String fields) {
        this.fields = fields;
        return this;
    }

    @Override
    protected Call buildCall() throws ApiException {
        String path = UrlConstant.PAYMENT_COLLECTION_PATH + "/" + id;
        Map<String, String> headers = new HashMap<>();

        final String[] localVarAccepts = { HeaderConstant.APPLICATION_JSON, HeaderConstant.TEXT_PLAIN };
        final String localVarAccept = client.selectHeaderAccept(localVarAccepts);

        if (localVarAccept != null) headers.put(HeaderConstant.ACCEPT, localVarAccept);
        headers.put(HeaderConstant.CONTENT_TYPE, HeaderConstant.APPLICATION_JSON);


        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (expand != null)
            localVarQueryParams.addAll(client.parameterToPair("expand", expand));
        if (fields != null)
            localVarQueryParams.addAll(client.parameterToPair("fields", fields));

        String[] localVarAuthNames = new String[] { "cookie_auth" };
        return client.buildCall(path, HttpMethod.GET, localVarQueryParams, null, null, headers, null, localVarAuthNames);
    }

    @Override
    public ApiResponse<StorePaymentCollectionsRes> execute() throws ApiException {
        Call call = buildCall();
        return client.execute(call);
    }

    @Override
    public void executeAsync(ApiCallback<StorePaymentCollectionsRes> callback) throws ApiException {
        Call call = buildCall();
        client.executeAsync(call, callback);
    }
}
