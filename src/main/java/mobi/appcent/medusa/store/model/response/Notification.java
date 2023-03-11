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
 * Notifications a communications sent via Notification Providers as a reaction to internal events such as &#x60;order.placed&#x60;. Notifications can be used to show a chronological timeline for communications sent to a Customer regarding an Order, and enables resends.
 */
@Schema(description = "Notifications a communications sent via Notification Providers as a reaction to internal events such as `order.placed`. Notifications can be used to show a chronological timeline for communications sent to a Customer regarding an Order, and enables resends.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class Notification {
  @SerializedName("id")
  private String id = null;

  @SerializedName("event_name")
  private String eventName = null;

  @SerializedName("resource_type")
  private String resourceType = null;

  @SerializedName("resource_id")
  private String resourceId = null;

  @SerializedName("customer_id")
  private String customerId = null;

  @SerializedName("customer")
  private Customer customer = null;

  @SerializedName("to")
  private String to = null;

  @SerializedName("data")
  private Object data = null;

  @SerializedName("parent_id")
  private String parentId = null;

  @SerializedName("parent_notification")
  private Object parentNotification = null;

  @SerializedName("resends")
  private List<Object> resends = null;

  @SerializedName("provider_id")
  private String providerId = null;

  @SerializedName("provider")
  private NotificationProvider provider = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  public Notification id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The notification&#x27;s ID
   * @return id
  **/
  @Schema(example = "noti_01G53V9Y6CKMCGBM1P0X7C28RX", required = true, description = "The notification's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Notification eventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

   /**
   * The name of the event that the notification was sent for.
   * @return eventName
  **/
  @Schema(example = "order.placed", required = true, description = "The name of the event that the notification was sent for.")
  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public Notification resourceType(String resourceType) {
    this.resourceType = resourceType;
    return this;
  }

   /**
   * The type of resource that the Notification refers to.
   * @return resourceType
  **/
  @Schema(example = "order", required = true, description = "The type of resource that the Notification refers to.")
  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public Notification resourceId(String resourceId) {
    this.resourceId = resourceId;
    return this;
  }

   /**
   * The ID of the resource that the Notification refers to.
   * @return resourceId
  **/
  @Schema(example = "order_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The ID of the resource that the Notification refers to.")
  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public Notification customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * The ID of the Customer that the Notification was sent to.
   * @return customerId
  **/
  @Schema(example = "cus_01G2SG30J8C85S4A5CHM2S1NS2", required = true, description = "The ID of the Customer that the Notification was sent to.")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public Notification customer(Customer customer) {
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @Schema(description = "")
  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Notification to(String to) {
    this.to = to;
    return this;
  }

   /**
   * The address that the Notification was sent to. This will usually be an email address, but represent other addresses such as a chat bot user id
   * @return to
  **/
  @Schema(example = "user@example.com", required = true, description = "The address that the Notification was sent to. This will usually be an email address, but represent other addresses such as a chat bot user id")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Notification data(Object data) {
    this.data = data;
    return this;
  }

   /**
   * The data that the Notification was sent with. This contains all the data necessary for the Notification Provider to initiate a resend.
   * @return data
  **/
  @Schema(example = "{}", required = true, description = "The data that the Notification was sent with. This contains all the data necessary for the Notification Provider to initiate a resend.")
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Notification parentId(String parentId) {
    this.parentId = parentId;
    return this;
  }

   /**
   * The notification&#x27;s parent ID
   * @return parentId
  **/
  @Schema(example = "noti_01G53V9Y6CKMCGBM1P0X7C28RX", required = true, description = "The notification's parent ID")
  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public Notification parentNotification(Object parentNotification) {
    this.parentNotification = parentNotification;
    return this;
  }

   /**
   * Available if the relation &#x60;parent_notification&#x60; is expanded.
   * @return parentNotification
  **/
  @Schema(description = "Available if the relation `parent_notification` is expanded.")
  public Object getParentNotification() {
    return parentNotification;
  }

  public void setParentNotification(Object parentNotification) {
    this.parentNotification = parentNotification;
  }

  public Notification resends(List<Object> resends) {
    this.resends = resends;
    return this;
  }

  public Notification addResendsItem(Object resendsItem) {
    if (this.resends == null) {
      this.resends = new ArrayList<Object>();
    }
    this.resends.add(resendsItem);
    return this;
  }

   /**
   * The resends that have been completed after the original Notification. Available if the relation &#x60;resends&#x60; is expanded.
   * @return resends
  **/
  @Schema(description = "The resends that have been completed after the original Notification. Available if the relation `resends` is expanded.")
  public List<Object> getResends() {
    return resends;
  }

  public void setResends(List<Object> resends) {
    this.resends = resends;
  }

  public Notification providerId(String providerId) {
    this.providerId = providerId;
    return this;
  }

   /**
   * The id of the Notification Provider that handles the Notification.
   * @return providerId
  **/
  @Schema(example = "sengrid", required = true, description = "The id of the Notification Provider that handles the Notification.")
  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public Notification provider(NotificationProvider provider) {
    this.provider = provider;
    return this;
  }

   /**
   * Get provider
   * @return provider
  **/
  @Schema(description = "")
  public NotificationProvider getProvider() {
    return provider;
  }

  public void setProvider(NotificationProvider provider) {
    this.provider = provider;
  }

  public Notification createdAt(OffsetDateTime createdAt) {
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

  public Notification updatedAt(OffsetDateTime updatedAt) {
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
    Notification notification = (Notification) o;
    return Objects.equals(this.id, notification.id) &&
        Objects.equals(this.eventName, notification.eventName) &&
        Objects.equals(this.resourceType, notification.resourceType) &&
        Objects.equals(this.resourceId, notification.resourceId) &&
        Objects.equals(this.customerId, notification.customerId) &&
        Objects.equals(this.customer, notification.customer) &&
        Objects.equals(this.to, notification.to) &&
        Objects.equals(this.data, notification.data) &&
        Objects.equals(this.parentId, notification.parentId) &&
        Objects.equals(this.parentNotification, notification.parentNotification) &&
        Objects.equals(this.resends, notification.resends) &&
        Objects.equals(this.providerId, notification.providerId) &&
        Objects.equals(this.provider, notification.provider) &&
        Objects.equals(this.createdAt, notification.createdAt) &&
        Objects.equals(this.updatedAt, notification.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, eventName, resourceType, resourceId, customerId, customer, to, data, parentId, parentNotification, resends, providerId, provider, createdAt, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Notification {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    parentNotification: ").append(toIndentedString(parentNotification)).append("\n");
    sb.append("    resends: ").append(toIndentedString(resends)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
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
