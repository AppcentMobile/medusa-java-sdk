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
 * Claim Orders represent a group of faulty or missing items. Each claim order consists of a subset of items associated with an original order, and can contain additional information about fulfillments and returns.
 */
@Schema(description = "Claim Orders represent a group of faulty or missing items. Each claim order consists of a subset of items associated with an original order, and can contain additional information about fulfillments and returns.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class ClaimOrder {
  @SerializedName("id")
  private String id = null;

  /**
   * The claim&#x27;s type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    REFUND("refund"),
    REPLACE("replace");

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
  private TypeEnum type = null;

  /**
   * The status of the claim&#x27;s payment
   */
  @JsonAdapter(PaymentStatusEnum.Adapter.class)
  public enum PaymentStatusEnum {
    NA("na"),
    NOT_REFUNDED("not_refunded"),
    REFUNDED("refunded");

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
  private PaymentStatusEnum paymentStatus = PaymentStatusEnum.NA;

  /**
   * The claim&#x27;s fulfillment status
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

  @SerializedName("claim_items")
  private List<ClaimItem> claimItems = null;

  @SerializedName("additional_items")
  private List<LineItem> additionalItems = null;

  @SerializedName("order_id")
  private String orderId = null;

  @SerializedName("order")
  private Object order = null;

  @SerializedName("return_order")
  private Object returnOrder = null;

  @SerializedName("shipping_address_id")
  private String shippingAddressId = null;

  @SerializedName("shipping_address")
  private Address shippingAddress = null;

  @SerializedName("shipping_methods")
  private List<ShippingMethod> shippingMethods = null;

  @SerializedName("fulfillments")
  private List<Object> fulfillments = null;

  @SerializedName("refund_amount")
  private Integer refundAmount = null;

  @SerializedName("canceled_at")
  private OffsetDateTime canceledAt = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  @SerializedName("no_notification")
  private Boolean noNotification = null;

  @SerializedName("idempotency_key")
  private String idempotencyKey = null;

  public ClaimOrder id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The claim&#x27;s ID
   * @return id
  **/
  @Schema(example = "claim_01G8ZH853Y6TFXWPG5EYE81X63", required = true, description = "The claim's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ClaimOrder type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The claim&#x27;s type
   * @return type
  **/
  @Schema(required = true, description = "The claim's type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ClaimOrder paymentStatus(PaymentStatusEnum paymentStatus) {
    this.paymentStatus = paymentStatus;
    return this;
  }

   /**
   * The status of the claim&#x27;s payment
   * @return paymentStatus
  **/
  @Schema(required = true, description = "The status of the claim's payment")
  public PaymentStatusEnum getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public ClaimOrder fulfillmentStatus(FulfillmentStatusEnum fulfillmentStatus) {
    this.fulfillmentStatus = fulfillmentStatus;
    return this;
  }

   /**
   * The claim&#x27;s fulfillment status
   * @return fulfillmentStatus
  **/
  @Schema(required = true, description = "The claim's fulfillment status")
  public FulfillmentStatusEnum getFulfillmentStatus() {
    return fulfillmentStatus;
  }

  public void setFulfillmentStatus(FulfillmentStatusEnum fulfillmentStatus) {
    this.fulfillmentStatus = fulfillmentStatus;
  }

  public ClaimOrder claimItems(List<ClaimItem> claimItems) {
    this.claimItems = claimItems;
    return this;
  }

  public ClaimOrder addClaimItemsItem(ClaimItem claimItemsItem) {
    if (this.claimItems == null) {
      this.claimItems = new ArrayList<ClaimItem>();
    }
    this.claimItems.add(claimItemsItem);
    return this;
  }

   /**
   * The items that have been claimed
   * @return claimItems
  **/
  @Schema(description = "The items that have been claimed")
  public List<ClaimItem> getClaimItems() {
    return claimItems;
  }

  public void setClaimItems(List<ClaimItem> claimItems) {
    this.claimItems = claimItems;
  }

  public ClaimOrder additionalItems(List<LineItem> additionalItems) {
    this.additionalItems = additionalItems;
    return this;
  }

  public ClaimOrder addAdditionalItemsItem(LineItem additionalItemsItem) {
    if (this.additionalItems == null) {
      this.additionalItems = new ArrayList<LineItem>();
    }
    this.additionalItems.add(additionalItemsItem);
    return this;
  }

   /**
   * Refers to the new items to be shipped when the claim order has the type &#x60;replace&#x60;
   * @return additionalItems
  **/
  @Schema(description = "Refers to the new items to be shipped when the claim order has the type `replace`")
  public List<LineItem> getAdditionalItems() {
    return additionalItems;
  }

  public void setAdditionalItems(List<LineItem> additionalItems) {
    this.additionalItems = additionalItems;
  }

  public ClaimOrder orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * The ID of the order that the claim comes from.
   * @return orderId
  **/
  @Schema(example = "order_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The ID of the order that the claim comes from.")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public ClaimOrder order(Object order) {
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

  public ClaimOrder returnOrder(Object returnOrder) {
    this.returnOrder = returnOrder;
    return this;
  }

   /**
   * A return object. Holds information about the return if the claim is to be returned. Available if the relation &#x27;return_order&#x27; is expanded
   * @return returnOrder
  **/
  @Schema(description = "A return object. Holds information about the return if the claim is to be returned. Available if the relation 'return_order' is expanded")
  public Object getReturnOrder() {
    return returnOrder;
  }

  public void setReturnOrder(Object returnOrder) {
    this.returnOrder = returnOrder;
  }

  public ClaimOrder shippingAddressId(String shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
    return this;
  }

   /**
   * The ID of the address that the new items should be shipped to
   * @return shippingAddressId
  **/
  @Schema(example = "addr_01G8ZH853YPY9B94857DY91YGW", required = true, description = "The ID of the address that the new items should be shipped to")
  public String getShippingAddressId() {
    return shippingAddressId;
  }

  public void setShippingAddressId(String shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
  }

  public ClaimOrder shippingAddress(Address shippingAddress) {
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

  public ClaimOrder shippingMethods(List<ShippingMethod> shippingMethods) {
    this.shippingMethods = shippingMethods;
    return this;
  }

  public ClaimOrder addShippingMethodsItem(ShippingMethod shippingMethodsItem) {
    if (this.shippingMethods == null) {
      this.shippingMethods = new ArrayList<ShippingMethod>();
    }
    this.shippingMethods.add(shippingMethodsItem);
    return this;
  }

   /**
   * The shipping methods that the claim order will be shipped with.
   * @return shippingMethods
  **/
  @Schema(description = "The shipping methods that the claim order will be shipped with.")
  public List<ShippingMethod> getShippingMethods() {
    return shippingMethods;
  }

  public void setShippingMethods(List<ShippingMethod> shippingMethods) {
    this.shippingMethods = shippingMethods;
  }

  public ClaimOrder fulfillments(List<Object> fulfillments) {
    this.fulfillments = fulfillments;
    return this;
  }

  public ClaimOrder addFulfillmentsItem(Object fulfillmentsItem) {
    if (this.fulfillments == null) {
      this.fulfillments = new ArrayList<Object>();
    }
    this.fulfillments.add(fulfillmentsItem);
    return this;
  }

   /**
   * The fulfillments of the new items to be shipped
   * @return fulfillments
  **/
  @Schema(description = "The fulfillments of the new items to be shipped")
  public List<Object> getFulfillments() {
    return fulfillments;
  }

  public void setFulfillments(List<Object> fulfillments) {
    this.fulfillments = fulfillments;
  }

  public ClaimOrder refundAmount(Integer refundAmount) {
    this.refundAmount = refundAmount;
    return this;
  }

   /**
   * The amount that will be refunded in conjunction with the claim
   * @return refundAmount
  **/
  @Schema(example = "1000", required = true, description = "The amount that will be refunded in conjunction with the claim")
  public Integer getRefundAmount() {
    return refundAmount;
  }

  public void setRefundAmount(Integer refundAmount) {
    this.refundAmount = refundAmount;
  }

  public ClaimOrder canceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
    return this;
  }

   /**
   * The date with timezone at which the claim was canceled.
   * @return canceledAt
  **/
  @Schema(required = true, description = "The date with timezone at which the claim was canceled.")
  public OffsetDateTime getCanceledAt() {
    return canceledAt;
  }

  public void setCanceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
  }

  public ClaimOrder createdAt(OffsetDateTime createdAt) {
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

  public ClaimOrder updatedAt(OffsetDateTime updatedAt) {
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

  public ClaimOrder deletedAt(OffsetDateTime deletedAt) {
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

  public ClaimOrder metadata(Object metadata) {
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

  public ClaimOrder noNotification(Boolean noNotification) {
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

  public ClaimOrder idempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
    return this;
  }

   /**
   * Randomly generated key used to continue the completion of the cart associated with the claim in case of failure.
   * @return idempotencyKey
  **/
  @Schema(required = true, description = "Randomly generated key used to continue the completion of the cart associated with the claim in case of failure.")
  public String getIdempotencyKey() {
    return idempotencyKey;
  }

  public void setIdempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClaimOrder claimOrder = (ClaimOrder) o;
    return Objects.equals(this.id, claimOrder.id) &&
        Objects.equals(this.type, claimOrder.type) &&
        Objects.equals(this.paymentStatus, claimOrder.paymentStatus) &&
        Objects.equals(this.fulfillmentStatus, claimOrder.fulfillmentStatus) &&
        Objects.equals(this.claimItems, claimOrder.claimItems) &&
        Objects.equals(this.additionalItems, claimOrder.additionalItems) &&
        Objects.equals(this.orderId, claimOrder.orderId) &&
        Objects.equals(this.order, claimOrder.order) &&
        Objects.equals(this.returnOrder, claimOrder.returnOrder) &&
        Objects.equals(this.shippingAddressId, claimOrder.shippingAddressId) &&
        Objects.equals(this.shippingAddress, claimOrder.shippingAddress) &&
        Objects.equals(this.shippingMethods, claimOrder.shippingMethods) &&
        Objects.equals(this.fulfillments, claimOrder.fulfillments) &&
        Objects.equals(this.refundAmount, claimOrder.refundAmount) &&
        Objects.equals(this.canceledAt, claimOrder.canceledAt) &&
        Objects.equals(this.createdAt, claimOrder.createdAt) &&
        Objects.equals(this.updatedAt, claimOrder.updatedAt) &&
        Objects.equals(this.deletedAt, claimOrder.deletedAt) &&
        Objects.equals(this.metadata, claimOrder.metadata) &&
        Objects.equals(this.noNotification, claimOrder.noNotification) &&
        Objects.equals(this.idempotencyKey, claimOrder.idempotencyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, paymentStatus, fulfillmentStatus, claimItems, additionalItems, orderId, order, returnOrder, shippingAddressId, shippingAddress, shippingMethods, fulfillments, refundAmount, canceledAt, createdAt, updatedAt, deletedAt, metadata, noNotification, idempotencyKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClaimOrder {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    paymentStatus: ").append(toIndentedString(paymentStatus)).append("\n");
    sb.append("    fulfillmentStatus: ").append(toIndentedString(fulfillmentStatus)).append("\n");
    sb.append("    claimItems: ").append(toIndentedString(claimItems)).append("\n");
    sb.append("    additionalItems: ").append(toIndentedString(additionalItems)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    returnOrder: ").append(toIndentedString(returnOrder)).append("\n");
    sb.append("    shippingAddressId: ").append(toIndentedString(shippingAddressId)).append("\n");
    sb.append("    shippingAddress: ").append(toIndentedString(shippingAddress)).append("\n");
    sb.append("    shippingMethods: ").append(toIndentedString(shippingMethods)).append("\n");
    sb.append("    fulfillments: ").append(toIndentedString(fulfillments)).append("\n");
    sb.append("    refundAmount: ").append(toIndentedString(refundAmount)).append("\n");
    sb.append("    canceledAt: ").append(toIndentedString(canceledAt)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    deletedAt: ").append(toIndentedString(deletedAt)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    noNotification: ").append(toIndentedString(noNotification)).append("\n");
    sb.append("    idempotencyKey: ").append(toIndentedString(idempotencyKey)).append("\n");
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
