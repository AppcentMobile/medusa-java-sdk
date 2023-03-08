package mobi.appcent.medusa.store;

import mobi.appcent.medusa.store.model.response.StoreAuthRes;
import mobi.appcent.medusa.store.model.response.StorePostAuthReq;

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
            ApiResponse<StoreAuthRes> res = medusaApi
                    .auth()
                    .postAuth()
                    .email("test@gmail.com")
                    .password("supersecret")
                    .execute();
            System.out.println(res.getData());
        } catch (ApiException exception) {
            System.err.println(exception);
        }
    }
}
