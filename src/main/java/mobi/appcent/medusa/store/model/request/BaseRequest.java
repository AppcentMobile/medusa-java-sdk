package mobi.appcent.medusa.store.model.request;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import mobi.appcent.medusa.store.ApiCallback;
import mobi.appcent.medusa.store.ApiException;
import mobi.appcent.medusa.store.ApiResponse;
import mobi.appcent.medusa.store.MedusaSdkClient;

import java.lang.reflect.Type;

/**
 * Created by erenalpaslan on 4.03.2023
 */
abstract public class BaseRequest <T> {

    protected abstract Call buildCall() throws ApiException;

    public abstract ApiResponse<T> execute() throws ApiException;

    public abstract void executeAsync(final ApiCallback<T> callback) throws ApiException;

    public abstract Type getType();

}
