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

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * Fulfillments are created once store operators can prepare the purchased goods. Fulfillments will eventually be shipped and hold information about how to track shipments. Fulfillments are created through a provider, which is typically an external shipping aggregator, shipping partner og 3PL, most plugins will have asynchronous communications with these providers through webhooks in order to automatically update and synchronize the state of Fulfillments.
 */
@Schema(description = "Fulfillments are created once store operators can prepare the purchased goods. Fulfillments will eventually be shipped and hold information about how to track shipments. Fulfillments are created through a provider, which is typically an external shipping aggregator, shipping partner og 3PL, most plugins will have asynchronous communications with these providers through webhooks in order to automatically update and synchronize the state of Fulfillments.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class Fulfillment {
  @SerializedName("id")
  private String id = null;

  @SerializedName("claim_order_id")
  private String claimOrderId = null;

  @SerializedName("claim_order")
  private Object claimOrder = null;

  @SerializedName("swap_id")
  private String swapId = null;

  @SerializedName("swap")
  private Object swap = null;

  @SerializedName("order_id")
  private String orderId = null;

  @SerializedName("order")
  private Object order = null;

  @SerializedName("provider_id")
  private String providerId = null;

  @SerializedName("provider")
  private FulfillmentProvider provider = null;

  @SerializedName("location_id")
  private String locationId = null;

  @SerializedName("items")
  private List<FulfillmentItem> items = null;

  @SerializedName("tracking_links")
  private List<TrackingLink> trackingLinks = null;

  @SerializedName("tracking_numbers")
  private List<String> trackingNumbers = new ArrayList<String>();

  @SerializedName("data")
  private Object data = null;

  @SerializedName("shipped_at")
  private OffsetDateTime shippedAt = null;

  @SerializedName("no_notification")
  private Boolean noNotification = null;

  @SerializedName("canceled_at")
  private OffsetDateTime canceledAt = null;

  @SerializedName("idempotency_key")
  private String idempotencyKey = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public Fulfillment id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The fulfillment&#x27;s ID
   * @return id
  **/
  @Schema(example = "ful_01G8ZRTMQCA76TXNAT81KPJZRF", required = true, description = "The fulfillment's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Fulfillment claimOrderId(String claimOrderId) {
    this.claimOrderId = claimOrderId;
    return this;
  }

   /**
   * The id of the Claim that the Fulfillment belongs to.
   * @return claimOrderId
  **/
  @Schema(required = true, description = "The id of the Claim that the Fulfillment belongs to.")
  public String getClaimOrderId() {
    return claimOrderId;
  }

  public void setClaimOrderId(String claimOrderId) {
    this.claimOrderId = claimOrderId;
  }

  public Fulfillment claimOrder(Object claimOrder) {
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

  public Fulfillment swapId(String swapId) {
    this.swapId = swapId;
    return this;
  }

   /**
   * The id of the Swap that the Fulfillment belongs to.
   * @return swapId
  **/
  @Schema(required = true, description = "The id of the Swap that the Fulfillment belongs to.")
  public String getSwapId() {
    return swapId;
  }

  public void setSwapId(String swapId) {
    this.swapId = swapId;
  }

  public Fulfillment swap(Object swap) {
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

  public Fulfillment orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * The id of the Order that the Fulfillment belongs to.
   * @return orderId
  **/
  @Schema(example = "order_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The id of the Order that the Fulfillment belongs to.")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Fulfillment order(Object order) {
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

  public Fulfillment providerId(String providerId) {
    this.providerId = providerId;
    return this;
  }

   /**
   * The id of the Fulfillment Provider responsible for handling the fulfillment
   * @return providerId
  **/
  @Schema(example = "manual", required = true, description = "The id of the Fulfillment Provider responsible for handling the fulfillment")
  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public Fulfillment provider(FulfillmentProvider provider) {
    this.provider = provider;
    return this;
  }

   /**
   * Get provider
   * @return provider
  **/
  @Schema(description = "")
  public FulfillmentProvider getProvider() {
    return provider;
  }

  public void setProvider(FulfillmentProvider provider) {
    this.provider = provider;
  }

  public Fulfillment locationId(String locationId) {
    this.locationId = locationId;
    return this;
  }

   /**
   * The id of the stock location the fulfillment will be shipped from
   * @return locationId
  **/
  @Schema(example = "sloc_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The id of the stock location the fulfillment will be shipped from")
  public String getLocationId() {
    return locationId;
  }

  public void setLocationId(String locationId) {
    this.locationId = locationId;
  }

  public Fulfillment items(List<FulfillmentItem> items) {
    this.items = items;
    return this;
  }

  public Fulfillment addItemsItem(FulfillmentItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<FulfillmentItem>();
    }
    this.items.add(itemsItem);
    return this;
  }

   /**
   * The Fulfillment Items in the Fulfillment - these hold information about how many of each Line Item has been fulfilled. Available if the relation &#x60;items&#x60; is expanded.
   * @return items
  **/
  @Schema(description = "The Fulfillment Items in the Fulfillment - these hold information about how many of each Line Item has been fulfilled. Available if the relation `items` is expanded.")
  public List<FulfillmentItem> getItems() {
    return items;
  }

  public void setItems(List<FulfillmentItem> items) {
    this.items = items;
  }

  public Fulfillment trackingLinks(List<TrackingLink> trackingLinks) {
    this.trackingLinks = trackingLinks;
    return this;
  }

  public Fulfillment addTrackingLinksItem(TrackingLink trackingLinksItem) {
    if (this.trackingLinks == null) {
      this.trackingLinks = new ArrayList<TrackingLink>();
    }
    this.trackingLinks.add(trackingLinksItem);
    return this;
  }

   /**
   * The Tracking Links that can be used to track the status of the Fulfillment, these will usually be provided by the Fulfillment Provider. Available if the relation &#x60;tracking_links&#x60; is expanded.
   * @return trackingLinks
  **/
  @Schema(description = "The Tracking Links that can be used to track the status of the Fulfillment, these will usually be provided by the Fulfillment Provider. Available if the relation `tracking_links` is expanded.")
  public List<TrackingLink> getTrackingLinks() {
    return trackingLinks;
  }

  public void setTrackingLinks(List<TrackingLink> trackingLinks) {
    this.trackingLinks = trackingLinks;
  }

  public Fulfillment trackingNumbers(List<String> trackingNumbers) {
    this.trackingNumbers = trackingNumbers;
    return this;
  }

  public Fulfillment addTrackingNumbersItem(String trackingNumbersItem) {
    this.trackingNumbers.add(trackingNumbersItem);
    return this;
  }

   /**
   * The tracking numbers that can be used to track the status of the fulfillment.
   * @return trackingNumbers
  **/
  @Schema(required = true, description = "The tracking numbers that can be used to track the status of the fulfillment.")
  public List<String> getTrackingNumbers() {
    return trackingNumbers;
  }

  public void setTrackingNumbers(List<String> trackingNumbers) {
    this.trackingNumbers = trackingNumbers;
  }

  public Fulfillment data(Object data) {
    this.data = data;
    return this;
  }

   /**
   * This contains all the data necessary for the Fulfillment provider to handle the fulfillment.
   * @return data
  **/
  @Schema(example = "{}", required = true, description = "This contains all the data necessary for the Fulfillment provider to handle the fulfillment.")
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Fulfillment shippedAt(OffsetDateTime shippedAt) {
    this.shippedAt = shippedAt;
    return this;
  }

   /**
   * The date with timezone at which the Fulfillment was shipped.
   * @return shippedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the Fulfillment was shipped.")
  public OffsetDateTime getShippedAt() {
    return shippedAt;
  }

  public void setShippedAt(OffsetDateTime shippedAt) {
    this.shippedAt = shippedAt;
  }

  public Fulfillment noNotification(Boolean noNotification) {
    this.noNotification = noNotification;
    return this;
  }

   /**
   * Flag for describing whether or not notifications related to this should be sent.
   * @return noNotification
  **/
  @Schema(example = "false", required = true, description = "Flag for describing whether or not notifications related to this should be sent.")
  public Boolean isNoNotification() {
    return noNotification;
  }

  public void setNoNotification(Boolean noNotification) {
    this.noNotification = noNotification;
  }

  public Fulfillment canceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
    return this;
  }

   /**
   * The date with timezone at which the Fulfillment was canceled.
   * @return canceledAt
  **/
  @Schema(required = true, description = "The date with timezone at which the Fulfillment was canceled.")
  public OffsetDateTime getCanceledAt() {
    return canceledAt;
  }

  public void setCanceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
  }

  public Fulfillment idempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
    return this;
  }

   /**
   * Randomly generated key used to continue the completion of the fulfillment in case of failure.
   * @return idempotencyKey
  **/
  @Schema(required = true, description = "Randomly generated key used to continue the completion of the fulfillment in case of failure.")
  public String getIdempotencyKey() {
    return idempotencyKey;
  }

  public void setIdempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
  }

  public Fulfillment createdAt(OffsetDateTime createdAt) {
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

  public Fulfillment updatedAt(OffsetDateTime updatedAt) {
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

  public Fulfillment metadata(Object metadata) {
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
    Fulfillment fulfillment = (Fulfillment) o;
    return Objects.equals(this.id, fulfillment.id) &&
        Objects.equals(this.claimOrderId, fulfillment.claimOrderId) &&
        Objects.equals(this.claimOrder, fulfillment.claimOrder) &&
        Objects.equals(this.swapId, fulfillment.swapId) &&
        Objects.equals(this.swap, fulfillment.swap) &&
        Objects.equals(this.orderId, fulfillment.orderId) &&
        Objects.equals(this.order, fulfillment.order) &&
        Objects.equals(this.providerId, fulfillment.providerId) &&
        Objects.equals(this.provider, fulfillment.provider) &&
        Objects.equals(this.locationId, fulfillment.locationId) &&
        Objects.equals(this.items, fulfillment.items) &&
        Objects.equals(this.trackingLinks, fulfillment.trackingLinks) &&
        Objects.equals(this.trackingNumbers, fulfillment.trackingNumbers) &&
        Objects.equals(this.data, fulfillment.data) &&
        Objects.equals(this.shippedAt, fulfillment.shippedAt) &&
        Objects.equals(this.noNotification, fulfillment.noNotification) &&
        Objects.equals(this.canceledAt, fulfillment.canceledAt) &&
        Objects.equals(this.idempotencyKey, fulfillment.idempotencyKey) &&
        Objects.equals(this.createdAt, fulfillment.createdAt) &&
        Objects.equals(this.updatedAt, fulfillment.updatedAt) &&
        Objects.equals(this.metadata, fulfillment.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, claimOrderId, claimOrder, swapId, swap, orderId, order, providerId, provider, locationId, items, trackingLinks, trackingNumbers, data, shippedAt, noNotification, canceledAt, idempotencyKey, createdAt, updatedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fulfillment {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    claimOrderId: ").append(toIndentedString(claimOrderId)).append("\n");
    sb.append("    claimOrder: ").append(toIndentedString(claimOrder)).append("\n");
    sb.append("    swapId: ").append(toIndentedString(swapId)).append("\n");
    sb.append("    swap: ").append(toIndentedString(swap)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    trackingLinks: ").append(toIndentedString(trackingLinks)).append("\n");
    sb.append("    trackingNumbers: ").append(toIndentedString(trackingNumbers)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    shippedAt: ").append(toIndentedString(shippedAt)).append("\n");
    sb.append("    noNotification: ").append(toIndentedString(noNotification)).append("\n");
    sb.append("    canceledAt: ").append(toIndentedString(canceledAt)).append("\n");
    sb.append("    idempotencyKey: ").append(toIndentedString(idempotencyKey)).append("\n");
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
