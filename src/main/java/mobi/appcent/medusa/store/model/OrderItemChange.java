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
import org.threeten.bp.OffsetDateTime;
/**
 * Represents an order edit item change
 */
@Schema(description = "Represents an order edit item change")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class OrderItemChange {
  @SerializedName("id")
  private String id = null;

  /**
   * The order item change&#x27;s status
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    ADD("item_add"),
    REMOVE("item_remove"),
    UPDATE("item_update");

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

  @SerializedName("order_edit_id")
  private String orderEditId = null;

  @SerializedName("order_edit")
  private Object orderEdit = null;

  @SerializedName("original_line_item_id")
  private String originalLineItemId = null;

  @SerializedName("original_line_item")
  private LineItem originalLineItem = null;

  @SerializedName("line_item_id")
  private String lineItemId = null;

  @SerializedName("line_item")
  private LineItem lineItem = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  public OrderItemChange id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The order item change&#x27;s ID
   * @return id
  **/
  @Schema(example = "oic_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The order item change's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public OrderItemChange type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The order item change&#x27;s status
   * @return type
  **/
  @Schema(required = true, description = "The order item change's status")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public OrderItemChange orderEditId(String orderEditId) {
    this.orderEditId = orderEditId;
    return this;
  }

   /**
   * The ID of the order edit
   * @return orderEditId
  **/
  @Schema(example = "oe_01G2SG30J8C85S4A5CHM2S1NS2", required = true, description = "The ID of the order edit")
  public String getOrderEditId() {
    return orderEditId;
  }

  public void setOrderEditId(String orderEditId) {
    this.orderEditId = orderEditId;
  }

  public OrderItemChange orderEdit(Object orderEdit) {
    this.orderEdit = orderEdit;
    return this;
  }

   /**
   * Available if the relation &#x60;order_edit&#x60; is expanded.
   * @return orderEdit
  **/
  @Schema(description = "Available if the relation `order_edit` is expanded.")
  public Object getOrderEdit() {
    return orderEdit;
  }

  public void setOrderEdit(Object orderEdit) {
    this.orderEdit = orderEdit;
  }

  public OrderItemChange originalLineItemId(String originalLineItemId) {
    this.originalLineItemId = originalLineItemId;
    return this;
  }

   /**
   * The ID of the original line item in the order
   * @return originalLineItemId
  **/
  @Schema(example = "item_01G8ZC9GWT6B2GP5FSXRXNFNGN", required = true, description = "The ID of the original line item in the order")
  public String getOriginalLineItemId() {
    return originalLineItemId;
  }

  public void setOriginalLineItemId(String originalLineItemId) {
    this.originalLineItemId = originalLineItemId;
  }

  public OrderItemChange originalLineItem(LineItem originalLineItem) {
    this.originalLineItem = originalLineItem;
    return this;
  }

   /**
   * Get originalLineItem
   * @return originalLineItem
  **/
  @Schema(description = "")
  public LineItem getOriginalLineItem() {
    return originalLineItem;
  }

  public void setOriginalLineItem(LineItem originalLineItem) {
    this.originalLineItem = originalLineItem;
  }

  public OrderItemChange lineItemId(String lineItemId) {
    this.lineItemId = lineItemId;
    return this;
  }

   /**
   * The ID of the cloned line item.
   * @return lineItemId
  **/
  @Schema(example = "item_01G8ZC9GWT6B2GP5FSXRXNFNGN", required = true, description = "The ID of the cloned line item.")
  public String getLineItemId() {
    return lineItemId;
  }

  public void setLineItemId(String lineItemId) {
    this.lineItemId = lineItemId;
  }

  public OrderItemChange lineItem(LineItem lineItem) {
    this.lineItem = lineItem;
    return this;
  }

   /**
   * Get lineItem
   * @return lineItem
  **/
  @Schema(description = "")
  public LineItem getLineItem() {
    return lineItem;
  }

  public void setLineItem(LineItem lineItem) {
    this.lineItem = lineItem;
  }

  public OrderItemChange createdAt(OffsetDateTime createdAt) {
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

  public OrderItemChange updatedAt(OffsetDateTime updatedAt) {
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

  public OrderItemChange deletedAt(OffsetDateTime deletedAt) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItemChange orderItemChange = (OrderItemChange) o;
    return Objects.equals(this.id, orderItemChange.id) &&
        Objects.equals(this.type, orderItemChange.type) &&
        Objects.equals(this.orderEditId, orderItemChange.orderEditId) &&
        Objects.equals(this.orderEdit, orderItemChange.orderEdit) &&
        Objects.equals(this.originalLineItemId, orderItemChange.originalLineItemId) &&
        Objects.equals(this.originalLineItem, orderItemChange.originalLineItem) &&
        Objects.equals(this.lineItemId, orderItemChange.lineItemId) &&
        Objects.equals(this.lineItem, orderItemChange.lineItem) &&
        Objects.equals(this.createdAt, orderItemChange.createdAt) &&
        Objects.equals(this.updatedAt, orderItemChange.updatedAt) &&
        Objects.equals(this.deletedAt, orderItemChange.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, orderEditId, orderEdit, originalLineItemId, originalLineItem, lineItemId, lineItem, createdAt, updatedAt, deletedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItemChange {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    orderEditId: ").append(toIndentedString(orderEditId)).append("\n");
    sb.append("    orderEdit: ").append(toIndentedString(orderEdit)).append("\n");
    sb.append("    originalLineItemId: ").append(toIndentedString(originalLineItemId)).append("\n");
    sb.append("    originalLineItem: ").append(toIndentedString(originalLineItem)).append("\n");
    sb.append("    lineItemId: ").append(toIndentedString(lineItemId)).append("\n");
    sb.append("    lineItem: ").append(toIndentedString(lineItem)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    deletedAt: ").append(toIndentedString(deletedAt)).append("\n");
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
