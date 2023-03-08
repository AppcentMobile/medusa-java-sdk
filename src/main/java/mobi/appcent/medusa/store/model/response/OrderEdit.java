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

package mobi.appcent.medusa.store.model.response;

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
 * Order edit keeps track of order items changes.
 */
@Schema(description = "Order edit keeps track of order items changes.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class OrderEdit {
  @SerializedName("id")
  private String id = null;

  @SerializedName("order_id")
  private String orderId = null;

  @SerializedName("order")
  private Object order = null;

  @SerializedName("changes")
  private List<OrderItemChange> changes = null;

  @SerializedName("internal_note")
  private String internalNote = null;

  @SerializedName("created_by")
  private String createdBy = null;

  @SerializedName("requested_by")
  private String requestedBy = null;

  @SerializedName("requested_at")
  private OffsetDateTime requestedAt = null;

  @SerializedName("confirmed_by")
  private String confirmedBy = null;

  @SerializedName("confirmed_at")
  private OffsetDateTime confirmedAt = null;

  @SerializedName("declined_by")
  private String declinedBy = null;

  @SerializedName("declined_at")
  private OffsetDateTime declinedAt = null;

  @SerializedName("declined_reason")
  private String declinedReason = null;

  @SerializedName("canceled_by")
  private String canceledBy = null;

  @SerializedName("canceled_at")
  private OffsetDateTime canceledAt = null;

  @SerializedName("subtotal")
  private Integer subtotal = null;

  @SerializedName("discount_total")
  private Integer discountTotal = null;

  @SerializedName("shipping_total")
  private Integer shippingTotal = null;

  @SerializedName("gift_card_total")
  private Integer giftCardTotal = null;

  @SerializedName("gift_card_tax_total")
  private Integer giftCardTaxTotal = null;

  @SerializedName("tax_total")
  private Integer taxTotal = null;

  @SerializedName("total")
  private Integer total = null;

  @SerializedName("difference_due")
  private Integer differenceDue = null;

  /**
   * The status of the order edit.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    CONFIRMED("confirmed"),
    DECLINED("declined"),
    REQUESTED("requested"),
    CREATED("created"),
    CANCELED("canceled");

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
  private StatusEnum status = null;

  @SerializedName("items")
  private List<LineItem> items = null;

  @SerializedName("payment_collection_id")
  private String paymentCollectionId = null;

  @SerializedName("payment_collection")
  private PaymentCollection paymentCollection = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  public OrderEdit id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The order edit&#x27;s ID
   * @return id
  **/
  @Schema(example = "oe_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The order edit's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public OrderEdit orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * The ID of the order that is edited
   * @return orderId
  **/
  @Schema(example = "order_01G2SG30J8C85S4A5CHM2S1NS2", required = true, description = "The ID of the order that is edited")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public OrderEdit order(Object order) {
    this.order = order;
    return this;
  }

   /**
   * Available if the relation &#x60;order&#x60; is expanded.
   * @return order
  **/
  @Schema(description = "Available if the relation `order` is expanded.")
  public Object getOrder() {
    return order;
  }

  public void setOrder(Object order) {
    this.order = order;
  }

  public OrderEdit changes(List<OrderItemChange> changes) {
    this.changes = changes;
    return this;
  }

  public OrderEdit addChangesItem(OrderItemChange changesItem) {
    if (this.changes == null) {
      this.changes = new ArrayList<OrderItemChange>();
    }
    this.changes.add(changesItem);
    return this;
  }

   /**
   * Available if the relation &#x60;changes&#x60; is expanded.
   * @return changes
  **/
  @Schema(description = "Available if the relation `changes` is expanded.")
  public List<OrderItemChange> getChanges() {
    return changes;
  }

  public void setChanges(List<OrderItemChange> changes) {
    this.changes = changes;
  }

  public OrderEdit internalNote(String internalNote) {
    this.internalNote = internalNote;
    return this;
  }

   /**
   * An optional note with additional details about the order edit.
   * @return internalNote
  **/
  @Schema(example = "Included two more items B to the order.", required = true, description = "An optional note with additional details about the order edit.")
  public String getInternalNote() {
    return internalNote;
  }

  public void setInternalNote(String internalNote) {
    this.internalNote = internalNote;
  }

  public OrderEdit createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

   /**
   * The unique identifier of the user or customer who created the order edit.
   * @return createdBy
  **/
  @Schema(required = true, description = "The unique identifier of the user or customer who created the order edit.")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public OrderEdit requestedBy(String requestedBy) {
    this.requestedBy = requestedBy;
    return this;
  }

   /**
   * The unique identifier of the user or customer who requested the order edit.
   * @return requestedBy
  **/
  @Schema(required = true, description = "The unique identifier of the user or customer who requested the order edit.")
  public String getRequestedBy() {
    return requestedBy;
  }

  public void setRequestedBy(String requestedBy) {
    this.requestedBy = requestedBy;
  }

  public OrderEdit requestedAt(OffsetDateTime requestedAt) {
    this.requestedAt = requestedAt;
    return this;
  }

   /**
   * The date with timezone at which the edit was requested.
   * @return requestedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the edit was requested.")
  public OffsetDateTime getRequestedAt() {
    return requestedAt;
  }

  public void setRequestedAt(OffsetDateTime requestedAt) {
    this.requestedAt = requestedAt;
  }

  public OrderEdit confirmedBy(String confirmedBy) {
    this.confirmedBy = confirmedBy;
    return this;
  }

   /**
   * The unique identifier of the user or customer who confirmed the order edit.
   * @return confirmedBy
  **/
  @Schema(required = true, description = "The unique identifier of the user or customer who confirmed the order edit.")
  public String getConfirmedBy() {
    return confirmedBy;
  }

  public void setConfirmedBy(String confirmedBy) {
    this.confirmedBy = confirmedBy;
  }

  public OrderEdit confirmedAt(OffsetDateTime confirmedAt) {
    this.confirmedAt = confirmedAt;
    return this;
  }

   /**
   * The date with timezone at which the edit was confirmed.
   * @return confirmedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the edit was confirmed.")
  public OffsetDateTime getConfirmedAt() {
    return confirmedAt;
  }

  public void setConfirmedAt(OffsetDateTime confirmedAt) {
    this.confirmedAt = confirmedAt;
  }

  public OrderEdit declinedBy(String declinedBy) {
    this.declinedBy = declinedBy;
    return this;
  }

   /**
   * The unique identifier of the user or customer who declined the order edit.
   * @return declinedBy
  **/
  @Schema(required = true, description = "The unique identifier of the user or customer who declined the order edit.")
  public String getDeclinedBy() {
    return declinedBy;
  }

  public void setDeclinedBy(String declinedBy) {
    this.declinedBy = declinedBy;
  }

  public OrderEdit declinedAt(OffsetDateTime declinedAt) {
    this.declinedAt = declinedAt;
    return this;
  }

   /**
   * The date with timezone at which the edit was declined.
   * @return declinedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the edit was declined.")
  public OffsetDateTime getDeclinedAt() {
    return declinedAt;
  }

  public void setDeclinedAt(OffsetDateTime declinedAt) {
    this.declinedAt = declinedAt;
  }

  public OrderEdit declinedReason(String declinedReason) {
    this.declinedReason = declinedReason;
    return this;
  }

   /**
   * An optional note why  the order edit is declined.
   * @return declinedReason
  **/
  @Schema(required = true, description = "An optional note why  the order edit is declined.")
  public String getDeclinedReason() {
    return declinedReason;
  }

  public void setDeclinedReason(String declinedReason) {
    this.declinedReason = declinedReason;
  }

  public OrderEdit canceledBy(String canceledBy) {
    this.canceledBy = canceledBy;
    return this;
  }

   /**
   * The unique identifier of the user or customer who cancelled the order edit.
   * @return canceledBy
  **/
  @Schema(required = true, description = "The unique identifier of the user or customer who cancelled the order edit.")
  public String getCanceledBy() {
    return canceledBy;
  }

  public void setCanceledBy(String canceledBy) {
    this.canceledBy = canceledBy;
  }

  public OrderEdit canceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
    return this;
  }

   /**
   * The date with timezone at which the edit was cancelled.
   * @return canceledAt
  **/
  @Schema(required = true, description = "The date with timezone at which the edit was cancelled.")
  public OffsetDateTime getCanceledAt() {
    return canceledAt;
  }

  public void setCanceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
  }

  public OrderEdit subtotal(Integer subtotal) {
    this.subtotal = subtotal;
    return this;
  }

   /**
   * The total of subtotal
   * @return subtotal
  **/
  @Schema(example = "8000", description = "The total of subtotal")
  public Integer getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Integer subtotal) {
    this.subtotal = subtotal;
  }

  public OrderEdit discountTotal(Integer discountTotal) {
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

  public OrderEdit shippingTotal(Integer shippingTotal) {
    this.shippingTotal = shippingTotal;
    return this;
  }

   /**
   * The total of the shipping amount
   * @return shippingTotal
  **/
  @Schema(example = "800", description = "The total of the shipping amount")
  public Integer getShippingTotal() {
    return shippingTotal;
  }

  public void setShippingTotal(Integer shippingTotal) {
    this.shippingTotal = shippingTotal;
  }

  public OrderEdit giftCardTotal(Integer giftCardTotal) {
    this.giftCardTotal = giftCardTotal;
    return this;
  }

   /**
   * The total of the gift card amount
   * @return giftCardTotal
  **/
  @Schema(example = "800", description = "The total of the gift card amount")
  public Integer getGiftCardTotal() {
    return giftCardTotal;
  }

  public void setGiftCardTotal(Integer giftCardTotal) {
    this.giftCardTotal = giftCardTotal;
  }

  public OrderEdit giftCardTaxTotal(Integer giftCardTaxTotal) {
    this.giftCardTaxTotal = giftCardTaxTotal;
    return this;
  }

   /**
   * The total of the gift card tax amount
   * @return giftCardTaxTotal
  **/
  @Schema(example = "800", description = "The total of the gift card tax amount")
  public Integer getGiftCardTaxTotal() {
    return giftCardTaxTotal;
  }

  public void setGiftCardTaxTotal(Integer giftCardTaxTotal) {
    this.giftCardTaxTotal = giftCardTaxTotal;
  }

  public OrderEdit taxTotal(Integer taxTotal) {
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

  public OrderEdit total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * The total amount of the edited order.
   * @return total
  **/
  @Schema(example = "8200", description = "The total amount of the edited order.")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public OrderEdit differenceDue(Integer differenceDue) {
    this.differenceDue = differenceDue;
    return this;
  }

   /**
   * The difference between the total amount of the order and total amount of edited order.
   * @return differenceDue
  **/
  @Schema(example = "8200", description = "The difference between the total amount of the order and total amount of edited order.")
  public Integer getDifferenceDue() {
    return differenceDue;
  }

  public void setDifferenceDue(Integer differenceDue) {
    this.differenceDue = differenceDue;
  }

  public OrderEdit status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * The status of the order edit.
   * @return status
  **/
  @Schema(required = true, description = "The status of the order edit.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public OrderEdit items(List<LineItem> items) {
    this.items = items;
    return this;
  }

  public OrderEdit addItemsItem(LineItem itemsItem) {
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

  public OrderEdit paymentCollectionId(String paymentCollectionId) {
    this.paymentCollectionId = paymentCollectionId;
    return this;
  }

   /**
   * The ID of the payment collection
   * @return paymentCollectionId
  **/
  @Schema(example = "paycol_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The ID of the payment collection")
  public String getPaymentCollectionId() {
    return paymentCollectionId;
  }

  public void setPaymentCollectionId(String paymentCollectionId) {
    this.paymentCollectionId = paymentCollectionId;
  }

  public OrderEdit paymentCollection(PaymentCollection paymentCollection) {
    this.paymentCollection = paymentCollection;
    return this;
  }

   /**
   * Get paymentCollection
   * @return paymentCollection
  **/
  @Schema(description = "")
  public PaymentCollection getPaymentCollection() {
    return paymentCollection;
  }

  public void setPaymentCollection(PaymentCollection paymentCollection) {
    this.paymentCollection = paymentCollection;
  }

  public OrderEdit createdAt(OffsetDateTime createdAt) {
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

  public OrderEdit updatedAt(OffsetDateTime updatedAt) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderEdit orderEdit = (OrderEdit) o;
    return Objects.equals(this.id, orderEdit.id) &&
        Objects.equals(this.orderId, orderEdit.orderId) &&
        Objects.equals(this.order, orderEdit.order) &&
        Objects.equals(this.changes, orderEdit.changes) &&
        Objects.equals(this.internalNote, orderEdit.internalNote) &&
        Objects.equals(this.createdBy, orderEdit.createdBy) &&
        Objects.equals(this.requestedBy, orderEdit.requestedBy) &&
        Objects.equals(this.requestedAt, orderEdit.requestedAt) &&
        Objects.equals(this.confirmedBy, orderEdit.confirmedBy) &&
        Objects.equals(this.confirmedAt, orderEdit.confirmedAt) &&
        Objects.equals(this.declinedBy, orderEdit.declinedBy) &&
        Objects.equals(this.declinedAt, orderEdit.declinedAt) &&
        Objects.equals(this.declinedReason, orderEdit.declinedReason) &&
        Objects.equals(this.canceledBy, orderEdit.canceledBy) &&
        Objects.equals(this.canceledAt, orderEdit.canceledAt) &&
        Objects.equals(this.subtotal, orderEdit.subtotal) &&
        Objects.equals(this.discountTotal, orderEdit.discountTotal) &&
        Objects.equals(this.shippingTotal, orderEdit.shippingTotal) &&
        Objects.equals(this.giftCardTotal, orderEdit.giftCardTotal) &&
        Objects.equals(this.giftCardTaxTotal, orderEdit.giftCardTaxTotal) &&
        Objects.equals(this.taxTotal, orderEdit.taxTotal) &&
        Objects.equals(this.total, orderEdit.total) &&
        Objects.equals(this.differenceDue, orderEdit.differenceDue) &&
        Objects.equals(this.status, orderEdit.status) &&
        Objects.equals(this.items, orderEdit.items) &&
        Objects.equals(this.paymentCollectionId, orderEdit.paymentCollectionId) &&
        Objects.equals(this.paymentCollection, orderEdit.paymentCollection) &&
        Objects.equals(this.createdAt, orderEdit.createdAt) &&
        Objects.equals(this.updatedAt, orderEdit.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orderId, order, changes, internalNote, createdBy, requestedBy, requestedAt, confirmedBy, confirmedAt, declinedBy, declinedAt, declinedReason, canceledBy, canceledAt, subtotal, discountTotal, shippingTotal, giftCardTotal, giftCardTaxTotal, taxTotal, total, differenceDue, status, items, paymentCollectionId, paymentCollection, createdAt, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderEdit {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    changes: ").append(toIndentedString(changes)).append("\n");
    sb.append("    internalNote: ").append(toIndentedString(internalNote)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    requestedBy: ").append(toIndentedString(requestedBy)).append("\n");
    sb.append("    requestedAt: ").append(toIndentedString(requestedAt)).append("\n");
    sb.append("    confirmedBy: ").append(toIndentedString(confirmedBy)).append("\n");
    sb.append("    confirmedAt: ").append(toIndentedString(confirmedAt)).append("\n");
    sb.append("    declinedBy: ").append(toIndentedString(declinedBy)).append("\n");
    sb.append("    declinedAt: ").append(toIndentedString(declinedAt)).append("\n");
    sb.append("    declinedReason: ").append(toIndentedString(declinedReason)).append("\n");
    sb.append("    canceledBy: ").append(toIndentedString(canceledBy)).append("\n");
    sb.append("    canceledAt: ").append(toIndentedString(canceledAt)).append("\n");
    sb.append("    subtotal: ").append(toIndentedString(subtotal)).append("\n");
    sb.append("    discountTotal: ").append(toIndentedString(discountTotal)).append("\n");
    sb.append("    shippingTotal: ").append(toIndentedString(shippingTotal)).append("\n");
    sb.append("    giftCardTotal: ").append(toIndentedString(giftCardTotal)).append("\n");
    sb.append("    giftCardTaxTotal: ").append(toIndentedString(giftCardTaxTotal)).append("\n");
    sb.append("    taxTotal: ").append(toIndentedString(taxTotal)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    differenceDue: ").append(toIndentedString(differenceDue)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    paymentCollectionId: ").append(toIndentedString(paymentCollectionId)).append("\n");
    sb.append("    paymentCollection: ").append(toIndentedString(paymentCollection)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
