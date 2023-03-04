package mobi.appcent.medusa.store;

import mobi.appcent.medusa.store.api.*;
/**
 * Created by erenalpaslan on 2.03.2023
 */
public class MedusaApi {

    private static MedusaApiClient defaultMedusaApiClient = new MedusaApiClient();
    private final AuthApi authApi = AuthApi.getInstance();
    private final CartApi cartApi = CartApi.getInstance();
    private final CollectionApi collectionApi = CollectionApi.getInstance();
    private final CustomerApi customerApi = CustomerApi.getInstance();
    private final GiftCardApi giftCardApi = GiftCardApi.getInstance();
    private final InviteApi inviteApi = InviteApi.getInstance();
    private final OrderApi orderApi = OrderApi.getInstance();
    private final OrderEditApi orderEditApi = OrderEditApi.getInstance();
    private final PaymentCollectionApi paymentCollectionApi = PaymentCollectionApi.getInstance();
    private final ProductApi productApi = ProductApi.getInstance();
    private final ProductCategoryApi productCategoryApi = ProductCategoryApi.getInstance();
    private final ProductTagApi productTagApi = ProductTagApi.getInstance();
    private final ProductTypeApi productTypeApi = ProductTypeApi.getInstance();
    private final ProductVariantApi productVariantApi = ProductVariantApi.getInstance();
    private final RegionApi regionApi = RegionApi.getInstance();
    private final ReturnApi returnApi = ReturnApi.getInstance();
    private final ReturnReasonApi returnReasonApi = ReturnReasonApi.getInstance();
    private final ShippingOptionApi shippingOptionApi = ShippingOptionApi.getInstance();
    private final SwapApi swapApi = SwapApi.getInstance();

    public MedusaApi() {
        initializeSdkClients();
    }

    private void initializeSdkClients() {
        authApi.setApiClient(defaultMedusaApiClient);
        cartApi.setApiClient(defaultMedusaApiClient);
        collectionApi.setApiClient(defaultMedusaApiClient);
        customerApi.setApiClient(defaultMedusaApiClient);
        giftCardApi.setApiClient(defaultMedusaApiClient);
        inviteApi.setApiClient(defaultMedusaApiClient);
        orderApi.setApiClient(defaultMedusaApiClient);
        orderEditApi.setApiClient(defaultMedusaApiClient);
        paymentCollectionApi.setApiClient(defaultMedusaApiClient);
        productApi.setApiClient(defaultMedusaApiClient);
        productTypeApi.setApiClient(defaultMedusaApiClient);
        productVariantApi.setApiClient(defaultMedusaApiClient);
        regionApi.setApiClient(defaultMedusaApiClient);
        returnApi.setApiClient(defaultMedusaApiClient);
        returnReasonApi.setApiClient(defaultMedusaApiClient);
        shippingOptionApi.setApiClient(defaultMedusaApiClient);
        swapApi.setApiClient(defaultMedusaApiClient);
    }

    /**
     * Get the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @return Default API client
     */
    public MedusaApiClient getDefaultApiClient() {
        return defaultMedusaApiClient;
    }

    /**
     * Set the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @param medusaApiClient API client
     */
    public void setDefaultApiClient(MedusaApiClient medusaApiClient) {
        defaultMedusaApiClient = medusaApiClient;
        initializeSdkClients();
    }

    public AuthApi auth() { return authApi; }
    public CartApi cart() { return cartApi; }
    public CollectionApi collection() { return collectionApi; }
    public CustomerApi customer() { return customerApi; }
    public GiftCardApi giftCard() { return giftCardApi; }
    public InviteApi invite() { return inviteApi; }
    public OrderApi order() { return orderApi; }
    public OrderEditApi orderEdit() { return orderEditApi; }
    public PaymentCollectionApi paymentCollection() { return paymentCollectionApi; }
    public ProductApi product() { return productApi; }
    public ProductCategoryApi productCategory() { return productCategoryApi; }
    public ProductTagApi productTag() { return productTagApi; }
    public ProductTypeApi productTypeApi() { return productTypeApi; }
    public ProductVariantApi productVariant() { return productVariantApi; }
    public RegionApi region() { return regionApi; }
    public ReturnApi returnApi() { return returnApi; }
    public ReturnReasonApi returnReason() { return returnReasonApi; }
    public ShippingOptionApi shippingOption() { return shippingOptionApi; }
    public SwapApi swap() { return swapApi; }


}
