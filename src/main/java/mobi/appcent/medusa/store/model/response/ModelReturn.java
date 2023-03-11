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
 * Return orders hold information about Line Items that a Customer wishes to send back, along with how the items will be returned. Returns can be used as part of a Swap.
 */
@Schema(description = "Return orders hold information about Line Items that a Customer wishes to send back, along with how the items will be returned. Returns can be used as part of a Swap.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class ModelReturn {
  @SerializedName("id")
  private String id = null;

  /**
   * Status of the Return.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    REQUESTED("requested"),
    RECEIVED("received"),
    REQUIRES_ACTION("requires_action"),
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
  private StatusEnum status = StatusEnum.REQUESTED;

  @SerializedName("items")
  private List<ReturnItem> items = null;

  @SerializedName("swap_id")
  private String swapId = null;

  @SerializedName("swap")
  private Object swap = null;

  @SerializedName("claim_order_id")
  private String claimOrderId = null;

  @SerializedName("claim_order")
  private Object claimOrder = null;

  @SerializedName("order_id")
  private String orderId = null;

  @SerializedName("order")
  private Object order = null;

  @SerializedName("shipping_method")
  private ShippingMethod shippingMethod = null;

  @SerializedName("shipping_data")
  private Object shippingData = null;

  @SerializedName("location_id")
  private String locationId = null;

  @SerializedName("refund_amount")
  private Integer refundAmount = null;

  @SerializedName("no_notification")
  private Boolean noNotification = null;

  @SerializedName("idempotency_key")
  private String idempotencyKey = null;

  @SerializedName("received_at")
  private OffsetDateTime receivedAt = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public ModelReturn id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The return&#x27;s ID
   * @return id
  **/
  @Schema(example = "ret_01F0YET7XPCMF8RZ0Y151NZV2V", required = true, description = "The return's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ModelReturn status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Status of the Return.
   * @return status
  **/
  @Schema(required = true, description = "Status of the Return.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ModelReturn items(List<ReturnItem> items) {
    this.items = items;
    return this;
  }

  public ModelReturn addItemsItem(ReturnItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<ReturnItem>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * The Return Items that will be shipped back to the warehouse. Available if the relation &#x60;items&#x60; is expanded.
   * @return items
  **/
  @Schema(description = "The Return Items that will be shipped back to the warehouse. Available if the relation `items` is expanded.")
  public List<ReturnItem> getItems() {
    return items;
  }

  public void setItems(List<ReturnItem> items) {
    this.items = items;
  }

  public ModelReturn swapId(String swapId) {
    this.swapId = swapId;
    return this;
  }

   /**
   * The ID of the Swap that the Return is a part of.
   * @return swapId
  **/
  @Schema(required = true, description = "The ID of the Swap that the Return is a part of.")
  public String getSwapId() {
    return swapId;
  }

  public void setSwapId(String swapId) {
    this.swapId = swapId;
  }

  public ModelReturn swap(Object swap) {
    this.swap = swap;
    return this;
  }

   /**
   * A swap object. Available if the relation &#x60;swap&#x60; is expanded.
   * @return swap
  **/
  @Schema(description = "A swap object. Available if the relation `swap` is expanded.")
  public Object getSwap() {
    return swap;
  }

  public void setSwap(Object swap) {
    this.swap = swap;
  }

  public ModelReturn claimOrderId(String claimOrderId) {
    this.claimOrderId = claimOrderId;
    return this;
  }

   /**
   * The ID of the Claim that the Return is a part of.
   * @return claimOrderId
  **/
  @Schema(required = true, description = "The ID of the Claim that the Return is a part of.")
  public String getClaimOrderId() {
    return claimOrderId;
  }

  public void setClaimOrderId(String claimOrderId) {
    this.claimOrderId = claimOrderId;
  }

  public ModelReturn claimOrder(Object claimOrder) {
    this.claimOrder = claimOrder;
    return this;
  }

   /**
   * A claim order object. Available if the relation &#x60;claim_order&#x60; is expanded.
   * @return claimOrder
  **/
  @Schema(description = "A claim order object. Available if the relation `claim_order` is expanded.")
  public Object getClaimOrder() {
    return claimOrder;
  }

  public void setClaimOrder(Object claimOrder) {
    this.claimOrder = claimOrder;
  }

  public ModelReturn orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * The ID of the Order that the Return is made from.
   * @return orderId
  **/
  @Schema(example = "order_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The ID of the Order that the Return is made from.")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public ModelReturn order(Object order) {
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

  public ModelReturn shippingMethod(ShippingMethod shippingMethod) {
    this.shippingMethod = shippingMethod;
    return this;
  }

   /**
   * Get shippingMethod
   * @return shippingMethod
  **/
  @Schema(description = "")
  public ShippingMethod getShippingMethod() {
    return shippingMethod;
  }

  public void setShippingMethod(ShippingMethod shippingMethod) {
    this.shippingMethod = shippingMethod;
  }

  public ModelReturn shippingData(Object shippingData) {
    this.shippingData = shippingData;
    return this;
  }

   /**
   * Data about the return shipment as provided by the Fulfilment Provider that handles the return shipment.
   * @return shippingData
  **/
  @Schema(example = "{}", required = true, description = "Data about the return shipment as provided by the Fulfilment Provider that handles the return shipment.")
  public Object getShippingData() {
    return shippingData;
  }

  public void setShippingData(Object shippingData) {
    this.shippingData = shippingData;
  }

  public ModelReturn locationId(String locationId) {
    this.locationId = locationId;
    return this;
  }

   /**
   * The id of the stock location the return will be added back.
   * @return locationId
  **/
  @Schema(example = "sloc_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The id of the stock location the return will be added back.")
  public String getLocationId() {
    return locationId;
  }

  public void setLocationId(String locationId) {
    this.locationId = locationId;
  }

  public ModelReturn refundAmount(Integer refundAmount) {
    this.refundAmount = refundAmount;
    return this;
  }

   /**
   * The amount that should be refunded as a result of the return.
   * @return refundAmount
  **/
  @Schema(example = "1000", required = true, description = "The amount that should be refunded as a result of the return.")
  public Integer getRefundAmount() {
    return refundAmount;
  }

  public void setRefundAmount(Integer refundAmount) {
    this.refundAmount = refundAmount;
  }

  public ModelReturn noNotification(Boolean noNotification) {
    this.noNotification = noNotification;
    return this;
  }

   /**
   * When set to true, no notification will be sent related to this return.
   * @return noNotification
  **/
  @Schema(example = "false", required = true, description = "When set to true, no notification will be sent related to this return.")
  public Boolean isNoNotification() {
    return noNotification;
  }

  public void setNoNotification(Boolean noNotification) {
    this.noNotification = noNotification;
  }

  public ModelReturn idempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
    return this;
  }

   /**
   * Randomly generated key used to continue the completion of the return in case of failure.
   * @return idempotencyKey
  **/
  @Schema(required = true, description = "Randomly generated key used to continue the completion of the return in case of failure.")
  public String getIdempotencyKey() {
    return idempotencyKey;
  }

  public void setIdempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
  }

  public ModelReturn receivedAt(OffsetDateTime receivedAt) {
    this.receivedAt = receivedAt;
    return this;
  }

   /**
   * The date with timezone at which the return was received.
   * @return receivedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the return was received.")
  public OffsetDateTime getReceivedAt() {
    return receivedAt;
  }

  public void setReceivedAt(OffsetDateTime receivedAt) {
    this.receivedAt = receivedAt;
  }

  public ModelReturn createdAt(OffsetDateTime createdAt) {
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

  public ModelReturn updatedAt(OffsetDateTime updatedAt) {
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

  public ModelReturn metadata(Object metadata) {
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
    ModelReturn _return = (ModelReturn) o;
    return Objects.equals(this.id, _return.id) &&
        Objects.equals(this.status, _return.status) &&
        Objects.equals(this.items, _return.items) &&
        Objects.equals(this.swapId, _return.swapId) &&
        Objects.equals(this.swap, _return.swap) &&
        Objects.equals(this.claimOrderId, _return.claimOrderId) &&
        Objects.equals(this.claimOrder, _return.claimOrder) &&
        Objects.equals(this.orderId, _return.orderId) &&
        Objects.equals(this.order, _return.order) &&
        Objects.equals(this.shippingMethod, _return.shippingMethod) &&
        Objects.equals(this.shippingData, _return.shippingData) &&
        Objects.equals(this.locationId, _return.locationId) &&
        Objects.equals(this.refundAmount, _return.refundAmount) &&
        Objects.equals(this.noNotification, _return.noNotification) &&
        Objects.equals(this.idempotencyKey, _return.idempotencyKey) &&
        Objects.equals(this.receivedAt, _return.receivedAt) &&
        Objects.equals(this.createdAt, _return.createdAt) &&
        Objects.equals(this.updatedAt, _return.updatedAt) &&
        Objects.equals(this.metadata, _return.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, items, swapId, swap, claimOrderId, claimOrder, orderId, order, shippingMethod, shippingData, locationId, refundAmount, noNotification, idempotencyKey, receivedAt, createdAt, updatedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelReturn {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    swapId: ").append(toIndentedString(swapId)).append("\n");
    sb.append("    swap: ").append(toIndentedString(swap)).append("\n");
    sb.append("    claimOrderId: ").append(toIndentedString(claimOrderId)).append("\n");
    sb.append("    claimOrder: ").append(toIndentedString(claimOrder)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    shippingMethod: ").append(toIndentedString(shippingMethod)).append("\n");
    sb.append("    shippingData: ").append(toIndentedString(shippingData)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    refundAmount: ").append(toIndentedString(refundAmount)).append("\n");
    sb.append("    noNotification: ").append(toIndentedString(noNotification)).append("\n");
    sb.append("    idempotencyKey: ").append(toIndentedString(idempotencyKey)).append("\n");
    sb.append("    receivedAt: ").append(toIndentedString(receivedAt)).append("\n");
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
