package mobi.appcent.medusa.store.auth;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;
import mobi.appcent.medusa.store.MedusaSdkClient;

import java.io.IOException;

public class ReceivedCookiesInterceptor implements Interceptor {

    private MedusaSdkClient client;

    public ReceivedCookiesInterceptor(MedusaSdkClient client) {
        this.client = client;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            String authCookie = originalResponse.headers("Set-Cookie").get(0);
            client.setAuth(authCookie);
        }

        return originalResponse;
    }
}