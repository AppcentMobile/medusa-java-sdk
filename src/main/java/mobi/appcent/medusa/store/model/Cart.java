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
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * Represents a user cart
 */
@Schema(description = "Represents a user cart")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class Cart {
  @SerializedName("id")
  private String id = null;

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

  @SerializedName("items")
  private List<LineItem> items = null;

  @SerializedName("region_id")
  private String regionId = null;

  @SerializedName("region")
  private Region region = null;

  @SerializedName("discounts")
  private List<Discount> discounts = null;

  @SerializedName("gift_cards")
  private List<GiftCard> giftCards = null;

  @SerializedName("customer_id")
  private String customerId = null;

  @SerializedName("customer")
  private Object customer = null;

  @SerializedName("payment_session")
  private Object paymentSession = null;

  @SerializedName("payment_sessions")
  private List<Object> paymentSessions = null;

  @SerializedName("payment_id")
  private String paymentId = null;

  @SerializedName("payment")
  private Object payment = null;

  @SerializedName("shipping_methods")
  private List<ShippingMethod> shippingMethods = null;

  /**
   * The cart&#x27;s type.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    DEFAULT("default"),
    SWAP("swap"),
    DRAFT_ORDER("draft_order"),
    PAYMENT_LINK("payment_link"),
    CLAIM("claim");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static TypeEnum fromValue(String input) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return TypeEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("type")
  private TypeEnum type = TypeEnum.DEFAULT;

  @SerializedName("completed_at")
  private OffsetDateTime completedAt = null;

  @SerializedName("payment_authorized_at")
  private OffsetDateTime paymentAuthorizedAt = null;

  @SerializedName("idempotency_key")
  private String idempotencyKey = null;

  @SerializedName("context")
  private Object context = null;

  @SerializedName("sales_channel_id")
  private String salesChannelId = null;

  @SerializedName("sales_channel")
  private SalesChannel salesChannel = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  @SerializedName("shipping_total")
  private Integer shippingTotal = null;

  @SerializedName("discount_total")
  private Integer discountTotal = null;

  @SerializedName("item_tax_total")
  private Integer itemTaxTotal = null;

  @SerializedName("shipping_tax_total")
  private Integer shippingTaxTotal = null;

  @SerializedName("tax_total")
  private Integer taxTotal = null;

  @SerializedName("refunded_total")
  private Integer refundedTotal = null;

  @SerializedName("total")
  private Integer total = null;

  @SerializedName("subtotal")
  private Integer subtotal = null;

  @SerializedName("refundable_amount")
  private Integer refundableAmount = null;

  @SerializedName("gift_card_total")
  private Integer giftCardTotal = null;

  @SerializedName("gift_card_tax_total")
  private Integer giftCardTaxTotal = null;

  public Cart id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The cart&#x27;s ID
   * @return id
  **/
  @Schema(example = "cart_01G8ZH853Y6TFXWPG5EYE81X63", required = true, description = "The cart's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Cart email(String email) {
    this.email = email;
    return this;
  }

   /**
   * The email associated with the cart
   * @return email
  **/
  @Schema(required = true, description = "The email associated with the cart")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Cart billingAddressId(String billingAddressId) {
    this.billingAddressId = billingAddressId;
    return this;
  }

   /**
   * The billing address&#x27;s ID
   * @return billingAddressId
  **/
  @Schema(example = "addr_01G8ZH853YPY9B94857DY91YGW", required = true, description = "The billing address's ID")
  public String getBillingAddressId() {
    return billingAddressId;
  }

  public void setBillingAddressId(String billingAddressId) {
    this.billingAddressId = billingAddressId;
  }

  public Cart billingAddress(Address billingAddress) {
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

  public Cart shippingAddressId(String shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
    return this;
  }

   /**
   * The shipping address&#x27;s ID
   * @return shippingAddressId
  **/
  @Schema(example = "addr_01G8ZH853YPY9B94857DY91YGW", required = true, description = "The shipping address's ID")
  public String getShippingAddressId() {
    return shippingAddressId;
  }

  public void setShippingAddressId(String shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
  }

  public Cart shippingAddress(Address shippingAddress) {
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

  public Cart items(List<LineItem> items) {
    this.items = items;
    return this;
  }

  public Cart addItemsItem(LineItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<LineItem>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Available if the relation &#x60;items&#x60; is expanded.
   * @return items
  **/
  @Schema(description = "Available if the relation `items` is expanded.")
  public List<LineItem> getItems() {
    return items;
  }

  public void setItems(List<LineItem> items) {
    this.items = items;
  }

  public Cart regionId(String regionId) {
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

  public Cart region(Region region) {
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

  public Cart discounts(List<Discount> discounts) {
    this.discounts = discounts;
    return this;
  }

  public Cart addDiscountsItem(Discount discountsItem) {
    if (this.discounts == null) {
      this.discounts = new ArrayList<Discount>();
    }
    this.discounts.add(discountsItem);
    return this;
  }

   /**
   * Available if the relation &#x60;discounts&#x60; is expanded.
   * @return discounts
  **/
  @Schema(description = "Available if the relation `discounts` is expanded.")
  public List<Discount> getDiscounts() {
    return discounts;
  }

  public void setDiscounts(List<Discount> discounts) {
    this.discounts = discounts;
  }

  public Cart giftCards(List<GiftCard> giftCards) {
    this.giftCards = giftCards;
    return this;
  }

  public Cart addGiftCardsItem(GiftCard giftCardsItem) {
    if (this.giftCards == null) {
      this.giftCards = new ArrayList<GiftCard>();
    }
    this.giftCards.add(giftCardsItem);
    return this;
  }

   /**
   * Available if the relation &#x60;gift_cards&#x60; is expanded.
   * @return giftCards
  **/
  @Schema(description = "Available if the relation `gift_cards` is expanded.")
  public List<GiftCard> getGiftCards() {
    return giftCards;
  }

  public void setGiftCards(List<GiftCard> giftCards) {
    this.giftCards = giftCards;
  }

  public Cart customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * The customer&#x27;s ID
   * @return customerId
  **/
  @Schema(example = "cus_01G2SG30J8C85S4A5CHM2S1NS2", required = true, description = "The customer's ID")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public Cart customer(Object customer) {
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

  public Cart paymentSession(Object paymentSession) {
    this.paymentSession = paymentSession;
    return this;
  }

   /**
   * The selected payment session in the cart.
   * @return paymentSession
  **/
  @Schema(required = true, description = "The selected payment session in the cart.")
  public Object getPaymentSession() {
    return paymentSession;
  }

  public void setPaymentSession(Object paymentSession) {
    this.paymentSession = paymentSession;
  }

  public Cart paymentSessions(List<Object> paymentSessions) {
    this.paymentSessions = paymentSessions;
    return this;
  }

  public Cart addPaymentSessionsItem(Object paymentSessionsItem) {
    if (this.paymentSessions == null) {
      this.paymentSessions = new ArrayList<Object>();
    }
    this.paymentSessions.add(paymentSessionsItem);
    return this;
  }

   /**
   * The payment sessions created on the cart.
   * @return paymentSessions
  **/
  @Schema(description = "The payment sessions created on the cart.")
  public List<Object> getPaymentSessions() {
    return paymentSessions;
  }

  public void setPaymentSessions(List<Object> paymentSessions) {
    this.paymentSessions = paymentSessions;
  }

  public Cart paymentId(String paymentId) {
    this.paymentId = paymentId;
    return this;
  }

   /**
   * The payment&#x27;s ID if available
   * @return paymentId
  **/
  @Schema(example = "pay_01G8ZCC5W42ZNY842124G7P5R9", required = true, description = "The payment's ID if available")
  public String getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  public Cart payment(Object payment) {
    this.payment = payment;
    return this;
  }

   /**
   * Available if the relation &#x60;payment&#x60; is expanded.
   * @return payment
  **/
  @Schema(description = "Available if the relation `payment` is expanded.")
  public Object getPayment() {
    return payment;
  }

  public void setPayment(Object payment) {
    this.payment = payment;
  }

  public Cart shippingMethods(List<ShippingMethod> shippingMethods) {
    this.shippingMethods = shippingMethods;
    return this;
  }

  public Cart addShippingMethodsItem(ShippingMethod shippingMethodsItem) {
    if (this.shippingMethods == null) {
      this.shippingMethods = new ArrayList<ShippingMethod>();
    }
    this.shippingMethods.add(shippingMethodsItem);
    return this;
  }

   /**
   * The shipping methods added to the cart.
   * @return shippingMethods
  **/
  @Schema(description = "The shipping methods added to the cart.")
  public List<ShippingMethod> getShippingMethods() {
    return shippingMethods;
  }

  public void setShippingMethods(List<ShippingMethod> shippingMethods) {
    this.shippingMethods = shippingMethods;
  }

  public Cart type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The cart&#x27;s type.
   * @return type
  **/
  @Schema(required = true, description = "The cart's type.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Cart completedAt(OffsetDateTime completedAt) {
    this.completedAt = completedAt;
    return this;
  }

   /**
   * The date with timezone at which the cart was completed.
   * @return completedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the cart was completed.")
  public OffsetDateTime getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(OffsetDateTime completedAt) {
    this.completedAt = completedAt;
  }

  public Cart paymentAuthorizedAt(OffsetDateTime paymentAuthorizedAt) {
    this.paymentAuthorizedAt = paymentAuthorizedAt;
    return this;
  }

   /**
   * The date with timezone at which the payment was authorized.
   * @return paymentAuthorizedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the payment was authorized.")
  public OffsetDateTime getPaymentAuthorizedAt() {
    return paymentAuthorizedAt;
  }

  public void setPaymentAuthorizedAt(OffsetDateTime paymentAuthorizedAt) {
    this.paymentAuthorizedAt = paymentAuthorizedAt;
  }

  public Cart idempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
    return this;
  }

   /**
   * Randomly generated key used to continue the completion of a cart in case of failure.
   * @return idempotencyKey
  **/
  @Schema(required = true, description = "Randomly generated key used to continue the completion of a cart in case of failure.")
  public String getIdempotencyKey() {
    return idempotencyKey;
  }

  public void setIdempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
  }

  public Cart context(Object context) {
    this.context = context;
    return this;
  }

   /**
   * The context of the cart which can include info like IP or user agent.
   * @return context
  **/
  @Schema(example = "{\"ip\":\"::1\",\"user_agent\":\"PostmanRuntime/7.29.2\"}", required = true, description = "The context of the cart which can include info like IP or user agent.")
  public Object getContext() {
    return context;
  }

  public void setContext(Object context) {
    this.context = context;
  }

  public Cart salesChannelId(String salesChannelId) {
    this.salesChannelId = salesChannelId;
    return this;
  }

   /**
   * The sales channel ID the cart is associated with.
   * @return salesChannelId
  **/
  @Schema(description = "The sales channel ID the cart is associated with.")
  public String getSalesChannelId() {
    return salesChannelId;
  }

  public void setSalesChannelId(String salesChannelId) {
    this.salesChannelId = salesChannelId;
  }

  public Cart salesChannel(SalesChannel salesChannel) {
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

  public Cart createdAt(OffsetDateTime createdAt) {
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

  public Cart updatedAt(OffsetDateTime updatedAt) {
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

  public Cart deletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

   /**
   * The date with timezone at which the resource was deleted.
   * @return deletedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the resource was deleted.")
  public OffsetDateTime getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
  }

  public Cart metadata(Object metadata) {
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

  public Cart shippingTotal(Integer shippingTotal) {
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

  public Cart discountTotal(Integer discountTotal) {
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

  public Cart itemTaxTotal(Integer itemTaxTotal) {
    this.itemTaxTotal = itemTaxTotal;
    return this;
  }

   /**
   * The total of items with taxes
   * @return itemTaxTotal
  **/
  @Schema(example = "8000", description = "The total of items with taxes")
  public Integer getItemTaxTotal() {
    return itemTaxTotal;
  }

  public void setItemTaxTotal(Integer itemTaxTotal) {
    this.itemTaxTotal = itemTaxTotal;
  }

  public Cart shippingTaxTotal(Integer shippingTaxTotal) {
    this.shippingTaxTotal = shippingTaxTotal;
    return this;
  }

   /**
   * The total of shipping with taxes
   * @return shippingTaxTotal
  **/
  @Schema(example = "1000", description = "The total of shipping with taxes")
  public Integer getShippingTaxTotal() {
    return shippingTaxTotal;
  }

  public void setShippingTaxTotal(Integer shippingTaxTotal) {
    this.shippingTaxTotal = shippingTaxTotal;
  }

  public Cart taxTotal(Integer taxTotal) {
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

  public Cart refundedTotal(Integer refundedTotal) {
    this.refundedTotal = refundedTotal;
    return this;
  }

   /**
   * The total amount refunded if the order associated with this cart is returned.
   * @return refundedTotal
  **/
  @Schema(example = "0", description = "The total amount refunded if the order associated with this cart is returned.")
  public Integer getRefundedTotal() {
    return refundedTotal;
  }

  public void setRefundedTotal(Integer refundedTotal) {
    this.refundedTotal = refundedTotal;
  }

  public Cart total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * The total amount of the cart
   * @return total
  **/
  @Schema(example = "8200", description = "The total amount of the cart")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Cart subtotal(Integer subtotal) {
    this.subtotal = subtotal;
    return this;
  }

   /**
   * The subtotal of the cart
   * @return subtotal
  **/
  @Schema(example = "8000", description = "The subtotal of the cart")
  public Integer getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Integer subtotal) {
    this.subtotal = subtotal;
  }

  public Cart refundableAmount(Integer refundableAmount) {
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

  public Cart giftCardTotal(Integer giftCardTotal) {
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

  public Cart giftCardTaxTotal(Integer giftCardTaxTotal) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cart cart = (Cart) o;
    return Objects.equals(this.id, cart.id) &&
        Objects.equals(this.email, cart.email) &&
        Objects.equals(this.billingAddressId, cart.billingAddressId) &&
        Objects.equals(this.billingAddress, cart.billingAddress) &&
        Objects.equals(this.shippingAddressId, cart.shippingAddressId) &&
        Objects.equals(this.shippingAddress, cart.shippingAddress) &&
        Objects.equals(this.items, cart.items) &&
        Objects.equals(this.regionId, cart.regionId) &&
        Objects.equals(this.region, cart.region) &&
        Objects.equals(this.discounts, cart.discounts) &&
        Objects.equals(this.giftCards, cart.giftCards) &&
        Objects.equals(this.customerId, cart.customerId) &&
        Objects.equals(this.customer, cart.customer) &&
        Objects.equals(this.paymentSession, cart.paymentSession) &&
        Objects.equals(this.paymentSessions, cart.paymentSessions) &&
        Objects.equals(this.paymentId, cart.paymentId) &&
        Objects.equals(this.payment, cart.payment) &&
        Objects.equals(this.shippingMethods, cart.shippingMethods) &&
        Objects.equals(this.type, cart.type) &&
        Objects.equals(this.completedAt, cart.completedAt) &&
        Objects.equals(this.paymentAuthorizedAt, cart.paymentAuthorizedAt) &&
        Objects.equals(this.idempotencyKey, cart.idempotencyKey) &&
        Objects.equals(this.context, cart.context) &&
        Objects.equals(this.salesChannelId, cart.salesChannelId) &&
        Objects.equals(this.salesChannel, cart.salesChannel) &&
        Objects.equals(this.createdAt, cart.createdAt) &&
        Objects.equals(this.updatedAt, cart.updatedAt) &&
        Objects.equals(this.deletedAt, cart.deletedAt) &&
        Objects.equals(this.metadata, cart.metadata) &&
        Objects.equals(this.shippingTotal, cart.shippingTotal) &&
        Objects.equals(this.discountTotal, cart.discountTotal) &&
        Objects.equals(this.itemTaxTotal, cart.itemTaxTotal) &&
        Objects.equals(this.shippingTaxTotal, cart.shippingTaxTotal) &&
        Objects.equals(this.taxTotal, cart.taxTotal) &&
        Objects.equals(this.refundedTotal, cart.refundedTotal) &&
        Objects.equals(this.total, cart.total) &&
        Objects.equals(this.subtotal, cart.subtotal) &&
        Objects.equals(this.refundableAmount, cart.refundableAmount) &&
        Objects.equals(this.giftCardTotal, cart.giftCardTotal) &&
        Objects.equals(this.giftCardTaxTotal, cart.giftCardTaxTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, billingAddressId, billingAddress, shippingAddressId, shippingAddress, items, regionId, region, discounts, giftCards, customerId, customer, paymentSession, paymentSessions, paymentId, payment, shippingMethods, type, completedAt, paymentAuthorizedAt, idempotencyKey, context, salesChannelId, salesChannel, createdAt, updatedAt, deletedAt, metadata, shippingTotal, discountTotal, itemTaxTotal, shippingTaxTotal, taxTotal, refundedTotal, total, subtotal, refundableAmount, giftCardTotal, giftCardTaxTotal);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cart {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    billingAddressId: ").append(toIndentedString(billingAddressId)).append("\n");
    sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
    sb.append("    shippingAddressId: ").append(toIndentedString(shippingAddressId)).append("\n");
    sb.append("    shippingAddress: ").append(toIndentedString(shippingAddress)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
    sb.append("    giftCards: ").append(toIndentedString(giftCards)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    paymentSession: ").append(toIndentedString(paymentSession)).append("\n");
    sb.append("    paymentSessions: ").append(toIndentedString(paymentSessions)).append("\n");
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    shippingMethods: ").append(toIndentedString(shippingMethods)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    completedAt: ").append(toIndentedString(completedAt)).append("\n");
    sb.append("    paymentAuthorizedAt: ").append(toIndentedString(paymentAuthorizedAt)).append("\n");
    sb.append("    idempotencyKey: ").append(toIndentedString(idempotencyKey)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    salesChannelId: ").append(toIndentedString(salesChannelId)).append("\n");
    sb.append("    salesChannel: ").append(toIndentedString(salesChannel)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    deletedAt: ").append(toIndentedString(deletedAt)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    shippingTotal: ").append(toIndentedString(shippingTotal)).append("\n");
    sb.append("    discountTotal: ").append(toIndentedString(discountTotal)).append("\n");
    sb.append("    itemTaxTotal: ").append(toIndentedString(itemTaxTotal)).append("\n");
    sb.append("    shippingTaxTotal: ").append(toIndentedString(shippingTaxTotal)).append("\n");
    sb.append("    taxTotal: ").append(toIndentedString(taxTotal)).append("\n");
    sb.append("    refundedTotal: ").append(toIndentedString(refundedTotal)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    subtotal: ").append(toIndentedString(subtotal)).append("\n");
    sb.append("    refundableAmount: ").append(toIndentedString(refundableAmount)).append("\n");
    sb.append("    giftCardTotal: ").append(toIndentedString(giftCardTotal)).append("\n");
    sb.append("    giftCardTaxTotal: ").append(toIndentedString(giftCardTaxTotal)).append("\n");
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
