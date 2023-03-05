package mobi.appcent.medusa.store.api;

import mobi.appcent.medusa.store.MedusaSdkClient;

/**
 * Created by erenalpaslan on 2.03.2023
 */
abstract class BaseApi {
    protected MedusaSdkClient sdkClient;

    protected void setSdkClient(MedusaSdkClient sdkClient) {
        this.sdkClient = sdkClient;
    }
}
