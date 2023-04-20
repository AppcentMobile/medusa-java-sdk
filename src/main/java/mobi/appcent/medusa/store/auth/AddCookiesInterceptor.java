package mobi.appcent.medusa.store.auth;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import mobi.appcent.medusa.store.MedusaSdkClient;

import java.io.IOException;
import java.util.HashSet;

public class AddCookiesInterceptor implements Interceptor {

    private MedusaSdkClient client;

    public AddCookiesInterceptor(MedusaSdkClient client) {
        this.client = client;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        String authCookie = client.getAuth();
        String publishableApiKey = client.getPublishableApiKey();
        if (authCookie != null) {
            builder.addHeader("Cookie", authCookie);
            if (client.isDebugging()) {
                System.out.println("OkHttp" + " Adding Header: " + authCookie);
            }
        }

        if (publishableApiKey != null) {
            builder.addHeader("x-publishable-api-key", publishableApiKey);
            if (client.isDebugging()) {
                System.out.println("OkHttp" + " Adding Header: " + publishableApiKey);
            }
        }

        return chain.proceed(builder.build());
    }
}