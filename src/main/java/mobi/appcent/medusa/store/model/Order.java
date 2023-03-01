/*
 * Medusa Storefront API
 * API reference for Medusa's Storefront endpoints. All endpoints are prefixed with `/store`.  ## Authentication  To send requests as an authenticated customer, you must use the Cookie Session ID.  <!-- ReDoc-Inject: <SecurityDefinitions> -->  ## Expanding Fields  In many endpoints you'll find an `expand` query parameter that can be passed to the endpoint. You can use the `expand` query parameter to unpack an entity's relations and return them in the response.  Please note that the relations you pass to `expand` replace any relations that are expanded by default in the request.  ### Expanding One Relation  For example, when you retrieve a product, you can retrieve its collection by passing to the `expand` query parameter the value `collection`:  ```bash curl \"http://localhost:9000/store/products/prod_01GDJGP2XPQT2N3JHZQFMH5V45?expand=collection\" ```  ### Expanding Multiple Relations  You can expand more than one relation by separating the relations in the `expand` query parameter with a comma.  For example, to retrieve both the variants and the collection of a product, pass to the `expand` query parameter the value `variants,collection`:  ```bash curl \"http://localhost:9000/store/products/prod_01GDJGP2XPQT2N3JHZQFMH5V45?expand=variants,collection\" ```  ### Prevent Expanding Relations  Some requests expand relations by default. You can prevent that by passing an empty expand value to retrieve an entity without any extra relations.  For example:  ```bash curl \"http://localhost:9000/store/products/prod_01GDJGP2XPQT2N3JHZQFMH5V45?expand\" ```  This would retrieve the product with only its properties, without any relations like `collection`.  ## Selecting Fields  In many endpoints you'll find a `fields` query parameter that can be passed to the endpoint. You can use the `fields` query parameter to specify which fields in the entity should be returned in the response.  Please note that if you pass a `fields` query parameter, only the fields you pass in the value along with the `id` of the entity will be returned in the response.  Also, the `fields` query parameter does not affect the expanded relations. You'll have to use the `expand` parameter instead.  ### Selecting One Field  For example, when you retrieve a list of products, you can retrieve only the titles of the products by passing `title` as a value to the `fields` query parameter:  ```bash curl \"http://localhost:9000/store/products?fields=title\" ```  As mentioned above, the expanded relations such as `variants` will still be returned as they're not affected by the `fields` parameter.  You can ensure that only the `title` field is returned by passing an empty value to the `expand` query parameter. For example:  ```bash curl \"http://localhost:9000/store/products?fields=title&expand\" ```  ### Selecting Multiple Fields  You can pass more than one field by seperating the field names in the `fields` query parameter with a comma.  For example, to select the `title` and `handle` of a product:  ```bash curl \"http://localhost:9000/store/products?fields=title,handle\" ```  ### Retrieve Only the ID  You can pass an empty `fields` query parameter to return only the ID of an entity. For example:  ```bash curl \"http://localhost:9000/store/products?fields\" ```  You can also pair with an empty `expand` query parameter to ensure that the relations aren't retrieved as well. For example:  ```bash curl \"http://localhost:9000/store/products?fields&expand\" ```  ## Query Parameter Types  This section covers how to pass some common data types as query parameters. This is useful if you're sending requests to the API endpoints and not using our JS Client. For example, when using cURL or Postman.  ### Strings  You can pass a string value in the form of `<parameter_name>=<value>`.  For example:  ```bash curl \"http://localhost:9000/store/products?title=Shirt\" ```  If the string has any characters other than letters and numbers, you must encode them.  For example, if the string has spaces, you can encode the space with `+` or `%20`:  ```bash curl \"http://localhost:9000/store/products?title=Blue%20Shirt\" ```  You can use tools like [this one](https://www.urlencoder.org/) to learn how a value can be encoded.  ### Integers  You can pass an integer value in the form of `<parameter_name>=<value>`.  For example:  ```bash curl \"http://localhost:9000/store/products?offset=1\" ```  ### Boolean  You can pass a boolean value in the form of `<parameter_name>=<value>`.  For example:  ```bash curl \"http://localhost:9000/store/products?is_giftcard=true\" ```  ### Date and DateTime  You can pass a date value in the form `<parameter_name>=<value>`. The date must be in the format `YYYY-MM-DD`.  For example:  ```bash curl -g \"http://localhost:9000/store/products?created_at[lt]=2023-02-17\" ```  You can also pass the time using the format `YYYY-MM-DDTHH:MM:SSZ`. Please note that the `T` and `Z` here are fixed.  For example:  ```bash curl -g \"http://localhost:9000/store/products?created_at[lt]=2023-02-17T07:22:30Z\" ```  ### Array  Each array value must be passed as a separate query parameter in the form `<parameter_name>[]=<value>`. You can also specify the index of each parameter in the brackets `<parameter_name>[0]=<value>`.  For example:  ```bash curl -g \"http://localhost:9000/store/products?sales_channel_id[]=sc_01GPGVB42PZ7N3YQEP2WDM7PC7&sales_channel_id[]=sc_234PGVB42PZ7N3YQEP2WDM7PC7\" ```  Note that the `-g` parameter passed to `curl` disables errors being thrown for using the brackets. Read more [here](https://curl.se/docs/manpage.html#-g).  ### Object  Object parameters must be passed as separate query parameters in the form `<parameter_name>[<key>]=<value>`.  For example:  ```bash curl -g \"http://localhost:9000/store/products?created_at[lt]=2023-02-17&created_at[gt]=2022-09-17\" ```  ## Pagination  ### Query Parameters  In listing endpoints, such as list customers or list products, you can control the pagination using the query parameters `limit` and `offset`.  `limit` is used to specify the maximum number of items that can be return in the response. `offset` is used to specify how many items to skip before returning the resulting entities.  You can use the `offset` query parameter to change between pages. For example, if the limit is 50, at page 1 the offset should be 0; at page 2 the offset should be 50, and so on.  For example, to limit the number of products returned in the List Products endpoint:  ```bash curl \"http://localhost:9000/store/products?limit=5\" ```  ### Response Fields  In the response of listing endpoints, aside from the entities retrieved, there are three pagination-related fields returned: `count`, `limit`, and `offset`.  Similar to the query parameters, `limit` is the maximum number of items that can be returned in the response, and `field` is the number of items that were skipped before the entities in the result.  `count` is the total number of available items of this entity. It can be used to determine how many pages are there.  For example, if the `count` is 100 and the `limit` is 50, you can divide the `count` by the `limit` to get the number of pages: `100/50 = 2 pages`. 
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package mobi.appcent.medusa.store.model;

import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * Represents an order
 */
@Schema(description = "Represents an order")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class Order {
  @SerializedName("id")
  private String id = null;

  /**
   * The order&#x27;s status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    PENDING("pending"),
    COMPLETED("completed"),
    ARCHIVED("archived"),
    CANCELED("canceled"),
    REQUIRES_ACTION("requires_action");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static StatusEnum fromValue(String input) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return StatusEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("status")
  private StatusEnum status = StatusEnum.PENDING;

  /**
   * The order&#x27;s fulfillment status
   */
  @JsonAdapter(FulfillmentStatusEnum.Adapter.class)
  public enum FulfillmentStatusEnum {
    NOT_FULFILLED("not_fulfilled"),
    PARTIALLY_FULFILLED("partially_fulfilled"),
    FULFILLED("fulfilled"),
    PARTIALLY_SHIPPED("partially_shipped"),
    SHIPPED("shipped"),
    PARTIALLY_RETURNED("partially_returned"),
    RETURNED("returned"),
    CANCELED("canceled"),
    REQUIRES_ACTION("requires_action");

    private String value;

    FulfillmentStatusEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static FulfillmentStatusEnum fromValue(String input) {
      for (FulfillmentStatusEnum b : FulfillmentStatusEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<FulfillmentStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final FulfillmentStatusEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public FulfillmentStatusEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return FulfillmentStatusEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("fulfillment_status")
  private FulfillmentStatusEnum fulfillmentStatus = FulfillmentStatusEnum.NOT_FULFILLED;

  /**
   * The order&#x27;s payment status
   */
  @JsonAdapter(PaymentStatusEnum.Adapter.class)
  public enum PaymentStatusEnum {
    NOT_PAID("not_paid"),
    AWAITING("awaiting"),
    CAPTURED("captured"),
    PARTIALLY_REFUNDED("partially_refunded"),
    REFUNDED("refunded"),
    CANCELED("canceled"),
    REQUIRES_ACTION("requires_action");

    private String value;

    PaymentStatusEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static PaymentStatusEnum fromValue(String input) {
      for (PaymentStatusEnum b : PaymentStatusEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<PaymentStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PaymentStatusEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public PaymentStatusEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return PaymentStatusEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("payment_status")
  private PaymentStatusEnum paymentStatus = PaymentStatusEnum.NOT_PAID;

  @SerializedName("display_id")
  private Integer displayId = null;

  @SerializedName("cart_id")
  private String cartId = null;

  @SerializedName("cart")
  private Object cart = null;

  @SerializedName("customer_id")
  private String customerId = null;

  @SerializedName("customer")
  private Object customer = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("billing_address_id")
  private String billingAddressId = null;

  @SerializedName("billing_address")
  private Address billingAddress = null;

  @SerializedName("shipping_address_id")
  private String shippingAddressId = null;

  @SerializedName("shipping_address")
  private Address shippingAddress = null;

  @SerializedName("region_id")
  private String regionId = null;

  @SerializedName("region")
  private Region region = null;

  @SerializedName("currency_code")
  private String currencyCode = null;

  @SerializedName("currency")
  private Currency currency = null;

  @SerializedName("tax_rate")
  private BigDecimal taxRate = null;

  @SerializedName("discounts")
  private List<Discount> discounts = null;

  @SerializedName("gift_cards")
  private List<GiftCard> giftCards = null;

  @SerializedName("shipping_methods")
  private List<ShippingMethod> shippingMethods = null;

  @SerializedName("payments")
  private List<Object> payments = null;

  @SerializedName("fulfillments")
  private List<Object> fulfillments = null;

  @SerializedName("returns")
  private List<Object> returns = null;

  @SerializedName("claims")
  private List<Object> claims = null;

  @SerializedName("refunds")
  private List<Object> refunds = null;

  @SerializedName("swaps")
  private List<Object> swaps = null;

  @SerializedName("draft_order_id")
  private String draftOrderId = null;

  @SerializedName("draft_order")
  private Object draftOrder = null;

  @SerializedName("items")
  private List<LineItem> items = null;

  @SerializedName("edits")
  private List<Object> edits = null;

  @SerializedName("gift_card_transactions")
  private List<GiftCardTransaction> giftCardTransactions = null;

  @SerializedName("canceled_at")
  private OffsetDateTime canceledAt = null;

  @SerializedName("no_notification")
  private Boolean noNotification = null;

  @SerializedName("idempotency_key")
  private String idempotencyKey = null;

  @SerializedName("external_id")
  private String externalId = null;

  @SerializedName("sales_channel_id")
  private String salesChannelId = null;

  @SerializedName("sales_channel")
  private SalesChannel salesChannel = null;

  @SerializedName("shipping_total")
  private Integer shippingTotal = null;

  @SerializedName("discount_total")
  private Integer discountTotal = null;

  @SerializedName("tax_total")
  private Integer taxTotal = null;

  @SerializedName("refunded_total")
  private Integer refundedTotal = null;

  @SerializedName("total")
  private Integer total = null;

  @SerializedName("subtotal")
  private Integer subtotal = null;

  @SerializedName("paid_total")
  private Integer paidTotal = null;

  @SerializedName("refundable_amount")
  private Integer refundableAmount = null;

  @SerializedName("gift_card_total")
  private Integer giftCardTotal = null;

  @SerializedName("gift_card_tax_total")
  private Integer giftCardTaxTotal = null;

  @SerializedName("returnable_items")
  private List<LineItem> returnableItems = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public Order id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The order&#x27;s ID
   * @return id
  **/
  @Schema(example = "order_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The order's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Order status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * The order&#x27;s status
   * @return status
  **/
  @Schema(required = true, description = "The order's status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Order fulfillmentStatus(FulfillmentStatusEnum fulfillmentStatus) {
    this.fulfillmentStatus = fulfillmentStatus;
    return this;
  }

   /**
   * The order&#x27;s fulfillment status
   * @return fulfillmentStatus
  **/
  @Schema(required = true, description = "The order's fulfillment status")
  public FulfillmentStatusEnum getFulfillmentStatus() {
    return fulfillmentStatus;
  }

  public void setFulfillmentStatus(FulfillmentStatusEnum fulfillmentStatus) {
    this.fulfillmentStatus = fulfillmentStatus;
  }

  public Order paymentStatus(PaymentStatusEnum paymentStatus) {
    this.paymentStatus = paymentStatus;
    return this;
  }

   /**
   * The order&#x27;s payment status
   * @return paymentStatus
  **/
  @Schema(required = true, description = "The order's payment status")
  public PaymentStatusEnum getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public Order displayId(Integer displayId) {
    this.displayId = displayId;
    return this;
  }

   /**
   * The order&#x27;s display ID
   * @return displayId
  **/
  @Schema(example = "2", required = true, description = "The order's display ID")
  public Integer getDisplayId() {
    return displayId;
  }

  public void setDisplayId(Integer displayId) {
    this.displayId = displayId;
  }

  public Order cartId(String cartId) {
    this.cartId = cartId;
    return this;
  }

   /**
   * The ID of the cart associated with the order
   * @return cartId
  **/
  @Schema(example = "cart_01G8ZH853Y6TFXWPG5EYE81X63", required = true, description = "The ID of the cart associated with the order")
  public String getCartId() {
    return cartId;
  }

  public void setCartId(String cartId) {
    this.cartId = cartId;
  }

  public Order cart(Object cart) {
    this.cart = cart;
    return this;
  }

   /**
   * A cart object. Available if the relation &#x60;cart&#x60; is expanded.
   * @return cart
  **/
  @Schema(description = "A cart object. Available if the relation `cart` is expanded.")
  public Object getCart() {
    return cart;
  }

  public void setCart(Object cart) {
    this.cart = cart;
  }

  public Order customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * The ID of the customer associated with the order
   * @return customerId
  **/
  @Schema(example = "cus_01G2SG30J8C85S4A5CHM2S1NS2", required = true, description = "The ID of the customer associated with the order")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public Order customer(Object customer) {
    this.customer = customer;
    return this;
  }

   /**
   * A customer object. Available if the relation &#x60;customer&#x60; is expanded.
   * @return customer
  **/
  @Schema(description = "A customer object. Available if the relation `customer` is expanded.")
  public Object getCustomer() {
    return customer;
  }

  public void setCustomer(Object customer) {
    this.customer = customer;
  }

  public Order email(String email) {
    this.email = email;
    return this;
  }

   /**
   * The email associated with the order
   * @return email
  **/
  @Schema(required = true, description = "The email associated with the order")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Order billingAddressId(String billingAddressId) {
    this.billingAddressId = billingAddressId;
    return this;
  }

   /**
   * The ID of the billing address associated with the order
   * @return billingAddressId
  **/
  @Schema(example = "addr_01G8ZH853YPY9B94857DY91YGW", required = true, description = "The ID of the billing address associated with the order")
  public String getBillingAddressId() {
    return billingAddressId;
  }

  public void setBillingAddressId(String billingAddressId) {
    this.billingAddressId = billingAddressId;
  }

  public Order billingAddress(Address billingAddress) {
    this.billingAddress = billingAddress;
    return this;
  }

   /**
   * Get billingAddress
   * @return billingAddress
  **/
  @Schema(description = "")
  public Address getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(Address billingAddress) {
    this.billingAddress = billingAddress;
  }

  public Order shippingAddressId(String shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
    return this;
  }

   /**
   * The ID of the shipping address associated with the order
   * @return shippingAddressId
  **/
  @Schema(example = "addr_01G8ZH853YPY9B94857DY91YGW", required = true, description = "The ID of the shipping address associated with the order")
  public String getShippingAddressId() {
    return shippingAddressId;
  }

  public void setShippingAddressId(String shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
  }

  public Order shippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
    return this;
  }

   /**
   * Get shippingAddress
   * @return shippingAddress
  **/
  @Schema(description = "")
  public Address getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public Order regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

   /**
   * The region&#x27;s ID
   * @return regionId
  **/
  @Schema(example = "reg_01G1G5V26T9H8Y0M4JNE3YGA4G", required = true, description = "The region's ID")
  public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public Order region(Region region) {
    this.region = region;
    return this;
  }

   /**
   * Get region
   * @return region
  **/
  @Schema(description = "")
  public Region getRegion() {
    return region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }

  public Order currencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

   /**
   * The 3 character currency code that is used in the order
   * @return currencyCode
  **/
  @Schema(example = "usd", required = true, description = "The 3 character currency code that is used in the order")
  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Order currency(Currency currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Get currency
   * @return currency
  **/
  @Schema(description = "")
  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public Order taxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
    return this;
  }

   /**
   * The order&#x27;s tax rate
   * @return taxRate
  **/
  @Schema(example = "0", required = true, description = "The order's tax rate")
  public BigDecimal getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
  }

  public Order discounts(List<Discount> discounts) {
    this.discounts = discounts;
    return this;
  }

  public Order addDiscountsItem(Discount discountsItem) {
    if (this.discounts == null) {
      this.discounts = new ArrayList<Discount>();
    }
    this.discounts.add(discountsItem);
    return this;
  }

   /**
   * The discounts used in the order. Available if the relation &#x60;discounts&#x60; is expanded.
   * @return discounts
  **/
  @Schema(description = "The discounts used in the order. Available if the relation `discounts` is expanded.")
  public List<Discount> getDiscounts() {
    return discounts;
  }

  public void setDiscounts(List<Discount> discounts) {
    this.discounts = discounts;
  }

  public Order giftCards(List<GiftCard> giftCards) {
    this.giftCards = giftCards;
    return this;
  }

  public Order addGiftCardsItem(GiftCard giftCardsItem) {
    if (this.giftCards == null) {
      this.giftCards = new ArrayList<GiftCard>();
    }
    this.giftCards.add(giftCardsItem);
    return this;
  }

   /**
   * The gift cards used in the order. Available if the relation &#x60;gift_cards&#x60; is expanded.
   * @return giftCards
  **/
  @Schema(description = "The gift cards used in the order. Available if the relation `gift_cards` is expanded.")
  public List<GiftCard> getGiftCards() {
    return giftCards;
  }

  public void setGiftCards(List<GiftCard> giftCards) {
    this.giftCards = giftCards;
  }

  public Order shippingMethods(List<ShippingMethod> shippingMethods) {
    this.shippingMethods = shippingMethods;
    return this;
  }

  public Order addShippingMethodsItem(ShippingMethod shippingMethodsItem) {
    if (this.shippingMethods == null) {
      this.shippingMethods = new ArrayList<ShippingMethod>();
    }
    this.shippingMethods.add(shippingMethodsItem);
    return this;
  }

   /**
   * The shipping methods used in the order. Available if the relation &#x60;shipping_methods&#x60; is expanded.
   * @return shippingMethods
  **/
  @Schema(description = "The shipping methods used in the order. Available if the relation `shipping_methods` is expanded.")
  public List<ShippingMethod> getShippingMethods() {
    return shippingMethods;
  }

  public void setShippingMethods(List<ShippingMethod> shippingMethods) {
    this.shippingMethods = shippingMethods;
  }

  public Order payments(List<Object> payments) {
    this.payments = payments;
    return this;
  }

  public Order addPaymentsItem(Object paymentsItem) {
    if (this.payments == null) {
      this.payments = new ArrayList<Object>();
    }
    this.payments.add(paymentsItem);
    return this;
  }

   /**
   * The payments used in the order. Available if the relation &#x60;payments&#x60; is expanded.
   * @return payments
  **/
  @Schema(description = "The payments used in the order. Available if the relation `payments` is expanded.")
  public List<Object> getPayments() {
    return payments;
  }

  public void setPayments(List<Object> payments) {
    this.payments = payments;
  }

  public Order fulfillments(List<Object> fulfillments) {
    this.fulfillments = fulfillments;
    return this;
  }

  public Order addFulfillmentsItem(Object fulfillmentsItem) {
    if (this.fulfillments == null) {
      this.fulfillments = new ArrayList<Object>();
    }
    this.fulfillments.add(fulfillmentsItem);
    return this;
  }

   /**
   * The fulfillments used in the order. Available if the relation &#x60;fulfillments&#x60; is expanded.
   * @return fulfillments
  **/
  @Schema(description = "The fulfillments used in the order. Available if the relation `fulfillments` is expanded.")
  public List<Object> getFulfillments() {
    return fulfillments;
  }

  public void setFulfillments(List<Object> fulfillments) {
    this.fulfillments = fulfillments;
  }

  public Order returns(List<Object> returns) {
    this.returns = returns;
    return this;
  }

  public Order addReturnsItem(Object returnsItem) {
    if (this.returns == null) {
      this.returns = new ArrayList<Object>();
    }
    this.returns.add(returnsItem);
    return this;
  }

   /**
   * The returns associated with the order. Available if the relation &#x60;returns&#x60; is expanded.
   * @return returns
  **/
  @Schema(description = "The returns associated with the order. Available if the relation `returns` is expanded.")
  public List<Object> getReturns() {
    return returns;
  }

  public void setReturns(List<Object> returns) {
    this.returns = returns;
  }

  public Order claims(List<Object> claims) {
    this.claims = claims;
    return this;
  }

  public Order addClaimsItem(Object claimsItem) {
    if (this.claims == null) {
      this.claims = new ArrayList<Object>();
    }
    this.claims.add(claimsItem);
    return this;
  }

   /**
   * The claims associated with the order. Available if the relation &#x60;claims&#x60; is expanded.
   * @return claims
  **/
  @Schema(description = "The claims associated with the order. Available if the relation `claims` is expanded.")
  public List<Object> getClaims() {
    return claims;
  }

  public void setClaims(List<Object> claims) {
    this.claims = claims;
  }

  public Order refunds(List<Object> refunds) {
    this.refunds = refunds;
    return this;
  }

  public Order addRefundsItem(Object refundsItem) {
    if (this.refunds == null) {
      this.refunds = new ArrayList<Object>();
    }
    this.refunds.add(refundsItem);
    return this;
  }

   /**
   * The refunds associated with the order. Available if the relation &#x60;refunds&#x60; is expanded.
   * @return refunds
  **/
  @Schema(description = "The refunds associated with the order. Available if the relation `refunds` is expanded.")
  public List<Object> getRefunds() {
    return refunds;
  }

  public void setRefunds(List<Object> refunds) {
    this.refunds = refunds;
  }

  public Order swaps(List<Object> swaps) {
    this.swaps = swaps;
    return this;
  }

  public Order addSwapsItem(Object swapsItem) {
    if (this.swaps == null) {
      this.swaps = new ArrayList<Object>();
    }
    this.swaps.add(swapsItem);
    return this;
  }

   /**
   * The swaps associated with the order. Available if the relation &#x60;swaps&#x60; is expanded.
   * @return swaps
  **/
  @Schema(description = "The swaps associated with the order. Available if the relation `swaps` is expanded.")
  public List<Object> getSwaps() {
    return swaps;
  }

  public void setSwaps(List<Object> swaps) {
    this.swaps = swaps;
  }

  public Order draftOrderId(String draftOrderId) {
    this.draftOrderId = draftOrderId;
    return this;
  }

   /**
   * The ID of the draft order this order is associated with.
   * @return draftOrderId
  **/
  @Schema(required = true, description = "The ID of the draft order this order is associated with.")
  public String getDraftOrderId() {
    return draftOrderId;
  }

  public void setDraftOrderId(String draftOrderId) {
    this.draftOrderId = draftOrderId;
  }

  public Order draftOrder(Object draftOrder) {
    this.draftOrder = draftOrder;
    return this;
  }

   /**
   * A draft order object. Available if the relation &#x60;draft_order&#x60; is expanded.
   * @return draftOrder
  **/
  @Schema(description = "A draft order object. Available if the relation `draft_order` is expanded.")
  public Object getDraftOrder() {
    return draftOrder;
  }

  public void setDraftOrder(Object draftOrder) {
    this.draftOrder = draftOrder;
  }

  public Order items(List<LineItem> items) {
    this.items = items;
    return this;
  }

  public Order addItemsItem(LineItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<LineItem>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * The line items that belong to the order. Available if the relation &#x60;items&#x60; is expanded.
   * @return items
  **/
  @Schema(description = "The line items that belong to the order. Available if the relation `items` is expanded.")
  public List<LineItem> getItems() {
    return items;
  }

  public void setItems(List<LineItem> items) {
    this.items = items;
  }

  public Order edits(List<Object> edits) {
    this.edits = edits;
    return this;
  }

  public Order addEditsItem(Object editsItem) {
    if (this.edits == null) {
      this.edits = new ArrayList<Object>();
    }
    this.edits.add(editsItem);
    return this;
  }

   /**
   * Order edits done on the order. Available if the relation &#x60;edits&#x60; is expanded.
   * @return edits
  **/
  @Schema(description = "Order edits done on the order. Available if the relation `edits` is expanded.")
  public List<Object> getEdits() {
    return edits;
  }

  public void setEdits(List<Object> edits) {
    this.edits = edits;
  }

  public Order giftCardTransactions(List<GiftCardTransaction> giftCardTransactions) {
    this.giftCardTransactions = giftCardTransactions;
    return this;
  }

  public Order addGiftCardTransactionsItem(GiftCardTransaction giftCardTransactionsItem) {
    if (this.giftCardTransactions == null) {
      this.giftCardTransactions = new ArrayList<GiftCardTransaction>();
    }
    this.giftCardTransactions.add(giftCardTransactionsItem);
    return this;
  }

   /**
   * The gift card transactions used in the order. Available if the relation &#x60;gift_card_transactions&#x60; is expanded.
   * @return giftCardTransactions
  **/
  @Schema(description = "The gift card transactions used in the order. Available if the relation `gift_card_transactions` is expanded.")
  public List<GiftCardTransaction> getGiftCardTransactions() {
    return giftCardTransactions;
  }

  public void setGiftCardTransactions(List<GiftCardTransaction> giftCardTransactions) {
    this.giftCardTransactions = giftCardTransactions;
  }

  public Order canceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
    return this;
  }

   /**
   * The date the order was canceled on.
   * @return canceledAt
  **/
  @Schema(required = true, description = "The date the order was canceled on.")
  public OffsetDateTime getCanceledAt() {
    return canceledAt;
  }

  public void setCanceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
  }

  public Order noNotification(Boolean noNotification) {
    this.noNotification = noNotification;
    return this;
  }

   /**
   * Flag for describing whether or not notifications related to this should be send.
   * @return noNotification
  **/
  @Schema(example = "false", required = true, description = "Flag for describing whether or not notifications related to this should be send.")
  public Boolean isNoNotification() {
    return noNotification;
  }

  public void setNoNotification(Boolean noNotification) {
    this.noNotification = noNotification;
  }

  public Order idempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
    return this;
  }

   /**
   * Randomly generated key used to continue the processing of the order in case of failure.
   * @return idempotencyKey
  **/
  @Schema(required = true, description = "Randomly generated key used to continue the processing of the order in case of failure.")
  public String getIdempotencyKey() {
    return idempotencyKey;
  }

  public void setIdempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
  }

  public Order externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

   /**
   * The ID of an external order.
   * @return externalId
  **/
  @Schema(required = true, description = "The ID of an external order.")
  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public Order salesChannelId(String salesChannelId) {
    this.salesChannelId = salesChannelId;
    return this;
  }

   /**
   * The ID of the sales channel this order is associated with.
   * @return salesChannelId
  **/
  @Schema(description = "The ID of the sales channel this order is associated with.")
  public String getSalesChannelId() {
    return salesChannelId;
  }

  public void setSalesChannelId(String salesChannelId) {
    this.salesChannelId = salesChannelId;
  }

  public Order salesChannel(SalesChannel salesChannel) {
    this.salesChannel = salesChannel;
    return this;
  }

   /**
   * Get salesChannel
   * @return salesChannel
  **/
  @Schema(description = "")
  public SalesChannel getSalesChannel() {
    return salesChannel;
  }

  public void setSalesChannel(SalesChannel salesChannel) {
    this.salesChannel = salesChannel;
  }

  public Order shippingTotal(Integer shippingTotal) {
    this.shippingTotal = shippingTotal;
    return this;
  }

   /**
   * The total of shipping
   * @return shippingTotal
  **/
  @Schema(example = "1000", description = "The total of shipping")
  public Integer getShippingTotal() {
    return shippingTotal;
  }

  public void setShippingTotal(Integer shippingTotal) {
    this.shippingTotal = shippingTotal;
  }

  public Order discountTotal(Integer discountTotal) {
    this.discountTotal = discountTotal;
    return this;
  }

   /**
   * The total of discount
   * @return discountTotal
  **/
  @Schema(example = "800", description = "The total of discount")
  public Integer getDiscountTotal() {
    return discountTotal;
  }

  public void setDiscountTotal(Integer discountTotal) {
    this.discountTotal = discountTotal;
  }

  public Order taxTotal(Integer taxTotal) {
    this.taxTotal = taxTotal;
    return this;
  }

   /**
   * The total of tax
   * @return taxTotal
  **/
  @Schema(example = "0", description = "The total of tax")
  public Integer getTaxTotal() {
    return taxTotal;
  }

  public void setTaxTotal(Integer taxTotal) {
    this.taxTotal = taxTotal;
  }

  public Order refundedTotal(Integer refundedTotal) {
    this.refundedTotal = refundedTotal;
    return this;
  }

   /**
   * The total amount refunded if the order is returned.
   * @return refundedTotal
  **/
  @Schema(example = "0", description = "The total amount refunded if the order is returned.")
  public Integer getRefundedTotal() {
    return refundedTotal;
  }

  public void setRefundedTotal(Integer refundedTotal) {
    this.refundedTotal = refundedTotal;
  }

  public Order total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * The total amount of the order
   * @return total
  **/
  @Schema(example = "8200", description = "The total amount of the order")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Order subtotal(Integer subtotal) {
    this.subtotal = subtotal;
    return this;
  }

   /**
   * The subtotal of the order
   * @return subtotal
  **/
  @Schema(example = "8000", description = "The subtotal of the order")
  public Integer getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Integer subtotal) {
    this.subtotal = subtotal;
  }

  public Order paidTotal(Integer paidTotal) {
    this.paidTotal = paidTotal;
    return this;
  }

   /**
   * The total amount paid
   * @return paidTotal
  **/
  @Schema(example = "8000", description = "The total amount paid")
  public Integer getPaidTotal() {
    return paidTotal;
  }

  public void setPaidTotal(Integer paidTotal) {
    this.paidTotal = paidTotal;
  }

  public Order refundableAmount(Integer refundableAmount) {
    this.refundableAmount = refundableAmount;
    return this;
  }

   /**
   * The amount that can be refunded
   * @return refundableAmount
  **/
  @Schema(example = "8200", description = "The amount that can be refunded")
  public Integer getRefundableAmount() {
    return refundableAmount;
  }

  public void setRefundableAmount(Integer refundableAmount) {
    this.refundableAmount = refundableAmount;
  }

  public Order giftCardTotal(Integer giftCardTotal) {
    this.giftCardTotal = giftCardTotal;
    return this;
  }

   /**
   * The total of gift cards
   * @return giftCardTotal
  **/
  @Schema(example = "0", description = "The total of gift cards")
  public Integer getGiftCardTotal() {
    return giftCardTotal;
  }

  public void setGiftCardTotal(Integer giftCardTotal) {
    this.giftCardTotal = giftCardTotal;
  }

  public Order giftCardTaxTotal(Integer giftCardTaxTotal) {
    this.giftCardTaxTotal = giftCardTaxTotal;
    return this;
  }

   /**
   * The total of gift cards with taxes
   * @return giftCardTaxTotal
  **/
  @Schema(example = "0", description = "The total of gift cards with taxes")
  public Integer getGiftCardTaxTotal() {
    return giftCardTaxTotal;
  }

  public void setGiftCardTaxTotal(Integer giftCardTaxTotal) {
    this.giftCardTaxTotal = giftCardTaxTotal;
  }

  public Order returnableItems(List<LineItem> returnableItems) {
    this.returnableItems = returnableItems;
    return this;
  }

  public Order addReturnableItemsItem(LineItem returnableItemsItem) {
    if (this.returnableItems == null) {
      this.returnableItems = new ArrayList<LineItem>();
    }
    this.returnableItems.add(returnableItemsItem);
    return this;
  }

   /**
   * The items that are returnable as part of the order, order swaps or order claims
   * @return returnableItems
  **/
  @Schema(description = "The items that are returnable as part of the order, order swaps or order claims")
  public List<LineItem> getReturnableItems() {
    return returnableItems;
  }

  public void setReturnableItems(List<LineItem> returnableItems) {
    this.returnableItems = returnableItems;
  }

  public Order createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * The date with timezone at which the resource was created.
   * @return createdAt
  **/
  @Schema(required = true, description = "The date with timezone at which the resource was created.")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Order updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * The date with timezone at which the resource was updated.
   * @return updatedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the resource was updated.")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Order metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * An optional key-value map with additional details
   * @return metadata
  **/
  @Schema(example = "{\"car\":\"white\"}", required = true, description = "An optional key-value map with additional details")
  public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.status, order.status) &&
        Objects.equals(this.fulfillmentStatus, order.fulfillmentStatus) &&
        Objects.equals(this.paymentStatus, order.paymentStatus) &&
        Objects.equals(this.displayId, order.displayId) &&
        Objects.equals(this.cartId, order.cartId) &&
        Objects.equals(this.cart, order.cart) &&
        Objects.equals(this.customerId, order.customerId) &&
        Objects.equals(this.customer, order.customer) &&
        Objects.equals(this.email, order.email) &&
        Objects.equals(this.billingAddressId, order.billingAddressId) &&
        Objects.equals(this.billingAddress, order.billingAddress) &&
        Objects.equals(this.shippingAddressId, order.shippingAddressId) &&
        Objects.equals(this.shippingAddress, order.shippingAddress) &&
        Objects.equals(this.regionId, order.regionId) &&
        Objects.equals(this.region, order.region) &&
        Objects.equals(this.currencyCode, order.currencyCode) &&
        Objects.equals(this.currency, order.currency) &&
        Objects.equals(this.taxRate, order.taxRate) &&
        Objects.equals(this.discounts, order.discounts) &&
        Objects.equals(this.giftCards, order.giftCards) &&
        Objects.equals(this.shippingMethods, order.shippingMethods) &&
        Objects.equals(this.payments, order.payments) &&
        Objects.equals(this.fulfillments, order.fulfillments) &&
        Objects.equals(this.returns, order.returns) &&
        Objects.equals(this.claims, order.claims) &&
        Objects.equals(this.refunds, order.refunds) &&
        Objects.equals(this.swaps, order.swaps) &&
        Objects.equals(this.draftOrderId, order.draftOrderId) &&
        Objects.equals(this.draftOrder, order.draftOrder) &&
        Objects.equals(this.items, order.items) &&
        Objects.equals(this.edits, order.edits) &&
        Objects.equals(this.giftCardTransactions, order.giftCardTransactions) &&
        Objects.equals(this.canceledAt, order.canceledAt) &&
        Objects.equals(this.noNotification, order.noNotification) &&
        Objects.equals(this.idempotencyKey, order.idempotencyKey) &&
        Objects.equals(this.externalId, order.externalId) &&
        Objects.equals(this.salesChannelId, order.salesChannelId) &&
        Objects.equals(this.salesChannel, order.salesChannel) &&
        Objects.equals(this.shippingTotal, order.shippingTotal) &&
        Objects.equals(this.discountTotal, order.discountTotal) &&
        Objects.equals(this.taxTotal, order.taxTotal) &&
        Objects.equals(this.refundedTotal, order.refundedTotal) &&
        Objects.equals(this.total, order.total) &&
        Objects.equals(this.subtotal, order.subtotal) &&
        Objects.equals(this.paidTotal, order.paidTotal) &&
        Objects.equals(this.refundableAmount, order.refundableAmount) &&
        Objects.equals(this.giftCardTotal, order.giftCardTotal) &&
        Objects.equals(this.giftCardTaxTotal, order.giftCardTaxTotal) &&
        Objects.equals(this.returnableItems, order.returnableItems) &&
        Objects.equals(this.createdAt, order.createdAt) &&
        Objects.equals(this.updatedAt, order.updatedAt) &&
        Objects.equals(this.metadata, order.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, fulfillmentStatus, paymentStatus, displayId, cartId, cart, customerId, customer, email, billingAddressId, billingAddress, shippingAddressId, shippingAddress, regionId, region, currencyCode, currency, taxRate, discounts, giftCards, shippingMethods, payments, fulfillments, returns, claims, refunds, swaps, draftOrderId, draftOrder, items, edits, giftCardTransactions, canceledAt, noNotification, idempotencyKey, externalId, salesChannelId, salesChannel, shippingTotal, discountTotal, taxTotal, refundedTotal, total, subtotal, paidTotal, refundableAmount, giftCardTotal, giftCardTaxTotal, returnableItems, createdAt, updatedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    fulfillmentStatus: ").append(toIndentedString(fulfillmentStatus)).append("\n");
    sb.append("    paymentStatus: ").append(toIndentedString(paymentStatus)).append("\n");
    sb.append("    displayId: ").append(toIndentedString(displayId)).append("\n");
    sb.append("    cartId: ").append(toIndentedString(cartId)).append("\n");
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    billingAddressId: ").append(toIndentedString(billingAddressId)).append("\n");
    sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
    sb.append("    shippingAddressId: ").append(toIndentedString(shippingAddressId)).append("\n");
    sb.append("    shippingAddress: ").append(toIndentedString(shippingAddress)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
    sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
    sb.append("    giftCards: ").append(toIndentedString(giftCards)).append("\n");
    sb.append("    shippingMethods: ").append(toIndentedString(shippingMethods)).append("\n");
    sb.append("    payments: ").append(toIndentedString(payments)).append("\n");
    sb.append("    fulfillments: ").append(toIndentedString(fulfillments)).append("\n");
    sb.append("    returns: ").append(toIndentedString(returns)).append("\n");
    sb.append("    claims: ").append(toIndentedString(claims)).append("\n");
    sb.append("    refunds: ").append(toIndentedString(refunds)).append("\n");
    sb.append("    swaps: ").append(toIndentedString(swaps)).append("\n");
    sb.append("    draftOrderId: ").append(toIndentedString(draftOrderId)).append("\n");
    sb.append("    draftOrder: ").append(toIndentedString(draftOrder)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    edits: ").append(toIndentedString(edits)).append("\n");
    sb.append("    giftCardTransactions: ").append(toIndentedString(giftCardTransactions)).append("\n");
    sb.append("    canceledAt: ").append(toIndentedString(canceledAt)).append("\n");
    sb.append("    noNotification: ").append(toIndentedString(noNotification)).append("\n");
    sb.append("    idempotencyKey: ").append(toIndentedString(idempotencyKey)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    salesChannelId: ").append(toIndentedString(salesChannelId)).append("\n");
    sb.append("    salesChannel: ").append(toIndentedString(salesChannel)).append("\n");
    sb.append("    shippingTotal: ").append(toIndentedString(shippingTotal)).append("\n");
    sb.append("    discountTotal: ").append(toIndentedString(discountTotal)).append("\n");
    sb.append("    taxTotal: ").append(toIndentedString(taxTotal)).append("\n");
    sb.append("    refundedTotal: ").append(toIndentedString(refundedTotal)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    subtotal: ").append(toIndentedString(subtotal)).append("\n");
    sb.append("    paidTotal: ").append(toIndentedString(paidTotal)).append("\n");
    sb.append("    refundableAmount: ").append(toIndentedString(refundableAmount)).append("\n");
    sb.append("    giftCardTotal: ").append(toIndentedString(giftCardTotal)).append("\n");
    sb.append("    giftCardTaxTotal: ").append(toIndentedString(giftCardTaxTotal)).append("\n");
    sb.append("    returnableItems: ").append(toIndentedString(returnableItems)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
