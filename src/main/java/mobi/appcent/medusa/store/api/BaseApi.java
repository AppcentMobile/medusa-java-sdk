package mobi.appcent.medusa.store.api;

import mobi.appcent.medusa.store.MedusaApi;
import mobi.appcent.medusa.store.MedusaApiClient;

/**
 * Created by erenalpaslan on 2.03.2023
 */
abstract class BaseApi {
    protected MedusaApiClient sdkClient;

    protected void setSdkClient(MedusaApiClient sdkClient) {
        this.sdkClient = sdkClient;
    }
}
