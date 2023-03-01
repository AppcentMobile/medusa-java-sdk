package mobi.appcent.medusa.store;

import mobi.appcent.medusa.store.api.AuthApi;
import mobi.appcent.medusa.store.api.CustomerApi;

/**
 * Created by erenalpaslan on 25.02.2023
 */
public class Main {
    public static void main(String[] args) {
        Configuration.getDefaultApiClient()
                .setDebugging(true)
                .setBasePath("http://localhost:9000/store")
                .setVerifyingSsl(false);

        AuthApi authApi = new AuthApi();
        CustomerApi customerApi = new CustomerApi();
    }
}
