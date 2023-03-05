package mobi.appcent.medusa.store;

import mobi.appcent.medusa.store.api.*;
/**
 * Created by erenalpaslan on 2.03.2023
 */
public class MedusaApi {

    private static MedusaSdkClient defaultMedusaSdkClient = new MedusaSdkClient();
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
        authApi.setApiClient(defaultMedusaSdkClient);
        cartApi.setApiClient(defaultMedusaSdkClient);
        collectionApi.setApiClient(defaultMedusaSdkClient);
        customerApi.setApiClient(defaultMedusaSdkClient);
        giftCardApi.setApiClient(defaultMedusaSdkClient);
        inviteApi.setApiClient(defaultMedusaSdkClient);
        orderApi.setApiClient(defaultMedusaSdkClient);
        orderEditApi.setApiClient(defaultMedusaSdkClient);
        paymentCollectionApi.setApiClient(defaultMedusaSdkClient);
        productApi.setApiClient(defaultMedusaSdkClient);
        productTypeApi.setApiClient(defaultMedusaSdkClient);
        productVariantApi.setApiClient(defaultMedusaSdkClient);
        regionApi.setApiClient(defaultMedusaSdkClient);
        returnApi.setApiClient(defaultMedusaSdkClient);
        returnReasonApi.setApiClient(defaultMedusaSdkClient);
        shippingOptionApi.setApiClient(defaultMedusaSdkClient);
        swapApi.setApiClient(defaultMedusaSdkClient);
    }

    /**
     * Get the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @return Default API client
     */
    public MedusaSdkClient getDefaultApiClient() {
        return defaultMedusaSdkClient;
    }

    /**
     * Set the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @param medusaSdkClient API client
     */
    public void setDefaultApiClient(MedusaSdkClient medusaSdkClient) {
        defaultMedusaSdkClient = medusaSdkClient;
        initializeSdkClients();
    }

    public AuthApi auth() { return authApi; }
    public CartApi carts() { return cartApi; }
    public CollectionApi collections() { return collectionApi; }
    public CustomerApi customers() { return customerApi; }
    public GiftCardApi giftCards() { return giftCardApi; }
    public InviteApi invites() { return inviteApi; }
    public OrderApi orders() { return orderApi; }
    public OrderEditApi orderEdit() { return orderEditApi; }
    public PaymentCollectionApi paymentCollections() { return paymentCollectionApi; }
    public ProductApi products() { return productApi; }
    public ProductCategoryApi productCategories() { return productCategoryApi; }
    public ProductTagApi productTags() { return productTagApi; }
    public ProductTypeApi productTypes() { return productTypeApi; }
    public ProductVariantApi productVariants() { return productVariantApi; }
    public RegionApi regions() { return regionApi; }
    public ReturnApi returns() { return returnApi; }
    public ReturnReasonApi returnReasons() { return returnReasonApi; }
    public ShippingOptionApi shippingOptions() { return shippingOptionApi; }
    public SwapApi swaps() { return swapApi; }


}
