package mobi.appcent.medusa.store;

import mobi.appcent.medusa.store.api.AuthApi;
import mobi.appcent.medusa.store.api.CustomerApi;
import mobi.appcent.medusa.store.model.StoreAuthRes;
import mobi.appcent.medusa.store.model.StoreCustomersRes;
import mobi.appcent.medusa.store.model.StorePostAuthReq;
import mobi.appcent.medusa.store.model.StorePostCustomersReq;

/**
 * Created by erenalpaslan on 25.02.2023
 */
public class Main {
    public static void main(String[] args) {
        MedusaApi medusaApi = new MedusaApi();

        medusaApi.getDefaultApiClient()
                .setDebugging(true)
                .setVerifyingSsl(false)
                .setBasePath("http://localhost:9000/store");

        try {
            StoreAuthRes res = medusaApi.auth().postAuth(new StorePostAuthReq()
                    .email("test@gmail.com")
                    .password("supersecret")
            );
            System.out.println(res.getCustomer());
        } catch (ApiException exception) {
            exception.printStackTrace();
        }
    }
}
