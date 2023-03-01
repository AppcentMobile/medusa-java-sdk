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
 * Swaps can be created when a Customer wishes to exchange Products that they have purchased to different Products. Swaps consist of a Return of previously purchased Products and a Fulfillment of new Products, the amount paid for the Products being returned will be used towards payment for the new Products. In the case where the amount paid for the the Products being returned exceed the amount to be paid for the new Products, a Refund will be issued for the difference.
 */
@Schema(description = "Swaps can be created when a Customer wishes to exchange Products that they have purchased to different Products. Swaps consist of a Return of previously purchased Products and a Fulfillment of new Products, the amount paid for the Products being returned will be used towards payment for the new Products. In the case where the amount paid for the the Products being returned exceed the amount to be paid for the new Products, a Refund will be issued for the difference.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class Swap {
  @SerializedName("id")
  private String id = null;

  /**
   * The status of the Fulfillment of the Swap.
   */
  @JsonAdapter(FulfillmentStatusEnum.Adapter.class)
  public enum FulfillmentStatusEnum {
    NOT_FULFILLED("not_fulfilled"),
    FULFILLED("fulfilled"),
    SHIPPED("shipped"),
    PARTIALLY_SHIPPED("partially_shipped"),
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
  private FulfillmentStatusEnum fulfillmentStatus = null;

  /**
   * The status of the Payment of the Swap. The payment may either refer to the refund of an amount or the authorization of a new amount.
   */
  @JsonAdapter(PaymentStatusEnum.Adapter.class)
  public enum PaymentStatusEnum {
    NOT_PAID("not_paid"),
    AWAITING("awaiting"),
    CAPTURED("captured"),
    CONFIRMED("confirmed"),
    CANCELED("canceled"),
    DIFFERENCE_REFUNDED("difference_refunded"),
    PARTIALLY_REFUNDED("partially_refunded"),
    REFUNDED("refunded"),
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
  private PaymentStatusEnum paymentStatus = null;

  @SerializedName("order_id")
  private String orderId = null;

  @SerializedName("order")
  private Object order = null;

  @SerializedName("additional_items")
  private List<LineItem> additionalItems = null;

  @SerializedName("return_order")
  private Object returnOrder = null;

  @SerializedName("fulfillments")
  private List<Object> fulfillments = null;

  @SerializedName("payment")
  private Object payment = null;

  @SerializedName("difference_due")
  private Integer differenceDue = null;

  @SerializedName("shipping_address_id")
  private String shippingAddressId = null;

  @SerializedName("shipping_address")
  private Address shippingAddress = null;

  @SerializedName("shipping_methods")
  private List<ShippingMethod> shippingMethods = null;

  @SerializedName("cart_id")
  private String cartId = null;

  @SerializedName("cart")
  private Object cart = null;

  @SerializedName("confirmed_at")
  private OffsetDateTime confirmedAt = null;

  @SerializedName("canceled_at")
  private OffsetDateTime canceledAt = null;

  @SerializedName("no_notification")
  private Boolean noNotification = null;

  @SerializedName("allow_backorder")
  private Boolean allowBackorder = false;

  @SerializedName("idempotency_key")
  private String idempotencyKey = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public Swap id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The swap&#x27;s ID
   * @return id
  **/
  @Schema(example = "swap_01F0YET86Y9G92D3YDR9Y6V676", required = true, description = "The swap's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Swap fulfillmentStatus(FulfillmentStatusEnum fulfillmentStatus) {
    this.fulfillmentStatus = fulfillmentStatus;
    return this;
  }

   /**
   * The status of the Fulfillment of the Swap.
   * @return fulfillmentStatus
  **/
  @Schema(example = "not_fulfilled", required = true, description = "The status of the Fulfillment of the Swap.")
  public FulfillmentStatusEnum getFulfillmentStatus() {
    return fulfillmentStatus;
  }

  public void setFulfillmentStatus(FulfillmentStatusEnum fulfillmentStatus) {
    this.fulfillmentStatus = fulfillmentStatus;
  }

  public Swap paymentStatus(PaymentStatusEnum paymentStatus) {
    this.paymentStatus = paymentStatus;
    return this;
  }

   /**
   * The status of the Payment of the Swap. The payment may either refer to the refund of an amount or the authorization of a new amount.
   * @return paymentStatus
  **/
  @Schema(example = "not_paid", required = true, description = "The status of the Payment of the Swap. The payment may either refer to the refund of an amount or the authorization of a new amount.")
  public PaymentStatusEnum getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public Swap orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * The ID of the Order where the Line Items to be returned where purchased.
   * @return orderId
  **/
  @Schema(example = "order_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The ID of the Order where the Line Items to be returned where purchased.")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Swap order(Object order) {
    this.order = order;
    return this;
  }

   /**
   * An order object. Available if the relation &#x60;order&#x60; is expanded.
   * @return order
  **/
  @Schema(description = "An order object. Available if the relation `order` is expanded.")
  public Object getOrder() {
    return order;
  }

  public void setOrder(Object order) {
    this.order = order;
  }

  public Swap additionalItems(List<LineItem> additionalItems) {
    this.additionalItems = additionalItems;
    return this;
  }

  public Swap addAdditionalItemsItem(LineItem additionalItemsItem) {
    if (this.additionalItems == null) {
      this.additionalItems = new ArrayList<LineItem>();
    }
    this.additionalItems.add(additionalItemsItem);
    return this;
  }

   /**
   * The new Line Items to ship to the Customer. Available if the relation &#x60;additional_items&#x60; is expanded.
   * @return additionalItems
  **/
  @Schema(description = "The new Line Items to ship to the Customer. Available if the relation `additional_items` is expanded.")
  public List<LineItem> getAdditionalItems() {
    return additionalItems;
  }

  public void setAdditionalItems(List<LineItem> additionalItems) {
    this.additionalItems = additionalItems;
  }

  public Swap returnOrder(Object returnOrder) {
    this.returnOrder = returnOrder;
    return this;
  }

   /**
   * A return order object. The Return that is issued for the return part of the Swap. Available if the relation &#x60;return_order&#x60; is expanded.
   * @return returnOrder
  **/
  @Schema(description = "A return order object. The Return that is issued for the return part of the Swap. Available if the relation `return_order` is expanded.")
  public Object getReturnOrder() {
    return returnOrder;
  }

  public void setReturnOrder(Object returnOrder) {
    this.returnOrder = returnOrder;
  }

  public Swap fulfillments(List<Object> fulfillments) {
    this.fulfillments = fulfillments;
    return this;
  }

  public Swap addFulfillmentsItem(Object fulfillmentsItem) {
    if (this.fulfillments == null) {
      this.fulfillments = new ArrayList<Object>();
    }
    this.fulfillments.add(fulfillmentsItem);
    return this;
  }

   /**
   * The Fulfillments used to send the new Line Items. Available if the relation &#x60;fulfillments&#x60; is expanded.
   * @return fulfillments
  **/
  @Schema(description = "The Fulfillments used to send the new Line Items. Available if the relation `fulfillments` is expanded.")
  public List<Object> getFulfillments() {
    return fulfillments;
  }

  public void setFulfillments(List<Object> fulfillments) {
    this.fulfillments = fulfillments;
  }

  public Swap payment(Object payment) {
    this.payment = payment;
    return this;
  }

   /**
   * The Payment authorized when the Swap requires an additional amount to be charged from the Customer. Available if the relation &#x60;payment&#x60; is expanded.
   * @return payment
  **/
  @Schema(description = "The Payment authorized when the Swap requires an additional amount to be charged from the Customer. Available if the relation `payment` is expanded.")
  public Object getPayment() {
    return payment;
  }

  public void setPayment(Object payment) {
    this.payment = payment;
  }

  public Swap differenceDue(Integer differenceDue) {
    this.differenceDue = differenceDue;
    return this;
  }

   /**
   * The difference that is paid or refunded as a result of the Swap. May be negative when the amount paid for the returned items exceed the total of the new Products.
   * @return differenceDue
  **/
  @Schema(example = "0", required = true, description = "The difference that is paid or refunded as a result of the Swap. May be negative when the amount paid for the returned items exceed the total of the new Products.")
  public Integer getDifferenceDue() {
    return differenceDue;
  }

  public void setDifferenceDue(Integer differenceDue) {
    this.differenceDue = differenceDue;
  }

  public Swap shippingAddressId(String shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
    return this;
  }

   /**
   * The Address to send the new Line Items to - in most cases this will be the same as the shipping address on the Order.
   * @return shippingAddressId
  **/
  @Schema(example = "addr_01G8ZH853YPY9B94857DY91YGW", required = true, description = "The Address to send the new Line Items to - in most cases this will be the same as the shipping address on the Order.")
  public String getShippingAddressId() {
    return shippingAddressId;
  }

  public void setShippingAddressId(String shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
  }

  public Swap shippingAddress(Address shippingAddress) {
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

  public Swap shippingMethods(List<ShippingMethod> shippingMethods) {
    this.shippingMethods = shippingMethods;
    return this;
  }

  public Swap addShippingMethodsItem(ShippingMethod shippingMethodsItem) {
    if (this.shippingMethods == null) {
      this.shippingMethods = new ArrayList<ShippingMethod>();
    }
    this.shippingMethods.add(shippingMethodsItem);
    return this;
  }

   /**
   * The Shipping Methods used to fulfill the additional items purchased. Available if the relation &#x60;shipping_methods&#x60; is expanded.
   * @return shippingMethods
  **/
  @Schema(description = "The Shipping Methods used to fulfill the additional items purchased. Available if the relation `shipping_methods` is expanded.")
  public List<ShippingMethod> getShippingMethods() {
    return shippingMethods;
  }

  public void setShippingMethods(List<ShippingMethod> shippingMethods) {
    this.shippingMethods = shippingMethods;
  }

  public Swap cartId(String cartId) {
    this.cartId = cartId;
    return this;
  }

   /**
   * The id of the Cart that the Customer will use to confirm the Swap.
   * @return cartId
  **/
  @Schema(example = "cart_01G8ZH853Y6TFXWPG5EYE81X63", required = true, description = "The id of the Cart that the Customer will use to confirm the Swap.")
  public String getCartId() {
    return cartId;
  }

  public void setCartId(String cartId) {
    this.cartId = cartId;
  }

  public Swap cart(Object cart) {
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

  public Swap confirmedAt(OffsetDateTime confirmedAt) {
    this.confirmedAt = confirmedAt;
    return this;
  }

   /**
   * The date with timezone at which the Swap was confirmed by the Customer.
   * @return confirmedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the Swap was confirmed by the Customer.")
  public OffsetDateTime getConfirmedAt() {
    return confirmedAt;
  }

  public void setConfirmedAt(OffsetDateTime confirmedAt) {
    this.confirmedAt = confirmedAt;
  }

  public Swap canceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
    return this;
  }

   /**
   * The date with timezone at which the Swap was canceled.
   * @return canceledAt
  **/
  @Schema(required = true, description = "The date with timezone at which the Swap was canceled.")
  public OffsetDateTime getCanceledAt() {
    return canceledAt;
  }

  public void setCanceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
  }

  public Swap noNotification(Boolean noNotification) {
    this.noNotification = noNotification;
    return this;
  }

   /**
   * If set to true, no notification will be sent related to this swap
   * @return noNotification
  **/
  @Schema(example = "false", required = true, description = "If set to true, no notification will be sent related to this swap")
  public Boolean isNoNotification() {
    return noNotification;
  }

  public void setNoNotification(Boolean noNotification) {
    this.noNotification = noNotification;
  }

  public Swap allowBackorder(Boolean allowBackorder) {
    this.allowBackorder = allowBackorder;
    return this;
  }

   /**
   * If true, swaps can be completed with items out of stock
   * @return allowBackorder
  **/
  @Schema(required = true, description = "If true, swaps can be completed with items out of stock")
  public Boolean isAllowBackorder() {
    return allowBackorder;
  }

  public void setAllowBackorder(Boolean allowBackorder) {
    this.allowBackorder = allowBackorder;
  }

  public Swap idempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
    return this;
  }

   /**
   * Randomly generated key used to continue the completion of the swap in case of failure.
   * @return idempotencyKey
  **/
  @Schema(required = true, description = "Randomly generated key used to continue the completion of the swap in case of failure.")
  public String getIdempotencyKey() {
    return idempotencyKey;
  }

  public void setIdempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
  }

  public Swap createdAt(OffsetDateTime createdAt) {
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

  public Swap updatedAt(OffsetDateTime updatedAt) {
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

  public Swap deletedAt(OffsetDateTime deletedAt) {
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

  public Swap metadata(Object metadata) {
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
    Swap swap = (Swap) o;
    return Objects.equals(this.id, swap.id) &&
        Objects.equals(this.fulfillmentStatus, swap.fulfillmentStatus) &&
        Objects.equals(this.paymentStatus, swap.paymentStatus) &&
        Objects.equals(this.orderId, swap.orderId) &&
        Objects.equals(this.order, swap.order) &&
        Objects.equals(this.additionalItems, swap.additionalItems) &&
        Objects.equals(this.returnOrder, swap.returnOrder) &&
        Objects.equals(this.fulfillments, swap.fulfillments) &&
        Objects.equals(this.payment, swap.payment) &&
        Objects.equals(this.differenceDue, swap.differenceDue) &&
        Objects.equals(this.shippingAddressId, swap.shippingAddressId) &&
        Objects.equals(this.shippingAddress, swap.shippingAddress) &&
        Objects.equals(this.shippingMethods, swap.shippingMethods) &&
        Objects.equals(this.cartId, swap.cartId) &&
        Objects.equals(this.cart, swap.cart) &&
        Objects.equals(this.confirmedAt, swap.confirmedAt) &&
        Objects.equals(this.canceledAt, swap.canceledAt) &&
        Objects.equals(this.noNotification, swap.noNotification) &&
        Objects.equals(this.allowBackorder, swap.allowBackorder) &&
        Objects.equals(this.idempotencyKey, swap.idempotencyKey) &&
        Objects.equals(this.createdAt, swap.createdAt) &&
        Objects.equals(this.updatedAt, swap.updatedAt) &&
        Objects.equals(this.deletedAt, swap.deletedAt) &&
        Objects.equals(this.metadata, swap.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fulfillmentStatus, paymentStatus, orderId, order, additionalItems, returnOrder, fulfillments, payment, differenceDue, shippingAddressId, shippingAddress, shippingMethods, cartId, cart, confirmedAt, canceledAt, noNotification, allowBackorder, idempotencyKey, createdAt, updatedAt, deletedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Swap {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    fulfillmentStatus: ").append(toIndentedString(fulfillmentStatus)).append("\n");
    sb.append("    paymentStatus: ").append(toIndentedString(paymentStatus)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    additionalItems: ").append(toIndentedString(additionalItems)).append("\n");
    sb.append("    returnOrder: ").append(toIndentedString(returnOrder)).append("\n");
    sb.append("    fulfillments: ").append(toIndentedString(fulfillments)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    differenceDue: ").append(toIndentedString(differenceDue)).append("\n");
    sb.append("    shippingAddressId: ").append(toIndentedString(shippingAddressId)).append("\n");
    sb.append("    shippingAddress: ").append(toIndentedString(shippingAddress)).append("\n");
    sb.append("    shippingMethods: ").append(toIndentedString(shippingMethods)).append("\n");
    sb.append("    cartId: ").append(toIndentedString(cartId)).append("\n");
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
    sb.append("    confirmedAt: ").append(toIndentedString(confirmedAt)).append("\n");
    sb.append("    canceledAt: ").append(toIndentedString(canceledAt)).append("\n");
    sb.append("    noNotification: ").append(toIndentedString(noNotification)).append("\n");
    sb.append("    allowBackorder: ").append(toIndentedString(allowBackorder)).append("\n");
    sb.append("    idempotencyKey: ").append(toIndentedString(idempotencyKey)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    deletedAt: ").append(toIndentedString(deletedAt)).append("\n");
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
