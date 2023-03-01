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

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Correlates a Line Item with a Return, keeping track of the quantity of the Line Item that will be returned.
 */
@Schema(description = "Correlates a Line Item with a Return, keeping track of the quantity of the Line Item that will be returned.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class ReturnItem {
  @SerializedName("return_id")
  private String returnId = null;

  @SerializedName("item_id")
  private String itemId = null;

  @SerializedName("return_order")
  private Object returnOrder = null;

  @SerializedName("item")
  private LineItem item = null;

  @SerializedName("quantity")
  private Integer quantity = null;

  @SerializedName("is_requested")
  private Boolean isRequested = true;

  @SerializedName("requested_quantity")
  private Integer requestedQuantity = null;

  @SerializedName("received_quantity")
  private Integer receivedQuantity = null;

  @SerializedName("reason_id")
  private String reasonId = null;

  @SerializedName("reason")
  private ReturnReason reason = null;

  @SerializedName("note")
  private String note = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public ReturnItem returnId(String returnId) {
    this.returnId = returnId;
    return this;
  }

   /**
   * The id of the Return that the Return Item belongs to.
   * @return returnId
  **/
  @Schema(example = "ret_01F0YET7XPCMF8RZ0Y151NZV2V", required = true, description = "The id of the Return that the Return Item belongs to.")
  public String getReturnId() {
    return returnId;
  }

  public void setReturnId(String returnId) {
    this.returnId = returnId;
  }

  public ReturnItem itemId(String itemId) {
    this.itemId = itemId;
    return this;
  }

   /**
   * The id of the Line Item that the Return Item references.
   * @return itemId
  **/
  @Schema(example = "item_01G8ZC9GWT6B2GP5FSXRXNFNGN", required = true, description = "The id of the Line Item that the Return Item references.")
  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public ReturnItem returnOrder(Object returnOrder) {
    this.returnOrder = returnOrder;
    return this;
  }

   /**
   * Available if the relation &#x60;return_order&#x60; is expanded.
   * @return returnOrder
  **/
  @Schema(description = "Available if the relation `return_order` is expanded.")
  public Object getReturnOrder() {
    return returnOrder;
  }

  public void setReturnOrder(Object returnOrder) {
    this.returnOrder = returnOrder;
  }

  public ReturnItem item(LineItem item) {
    this.item = item;
    return this;
  }

   /**
   * Get item
   * @return item
  **/
  @Schema(description = "")
  public LineItem getItem() {
    return item;
  }

  public void setItem(LineItem item) {
    this.item = item;
  }

  public ReturnItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * The quantity of the Line Item that is included in the Return.
   * @return quantity
  **/
  @Schema(example = "1", required = true, description = "The quantity of the Line Item that is included in the Return.")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public ReturnItem isRequested(Boolean isRequested) {
    this.isRequested = isRequested;
    return this;
  }

   /**
   * Whether the Return Item was requested initially or received unexpectedly in the warehouse.
   * @return isRequested
  **/
  @Schema(required = true, description = "Whether the Return Item was requested initially or received unexpectedly in the warehouse.")
  public Boolean isIsRequested() {
    return isRequested;
  }

  public void setIsRequested(Boolean isRequested) {
    this.isRequested = isRequested;
  }

  public ReturnItem requestedQuantity(Integer requestedQuantity) {
    this.requestedQuantity = requestedQuantity;
    return this;
  }

   /**
   * The quantity that was originally requested to be returned.
   * @return requestedQuantity
  **/
  @Schema(example = "1", required = true, description = "The quantity that was originally requested to be returned.")
  public Integer getRequestedQuantity() {
    return requestedQuantity;
  }

  public void setRequestedQuantity(Integer requestedQuantity) {
    this.requestedQuantity = requestedQuantity;
  }

  public ReturnItem receivedQuantity(Integer receivedQuantity) {
    this.receivedQuantity = receivedQuantity;
    return this;
  }

   /**
   * The quantity that was received in the warehouse.
   * @return receivedQuantity
  **/
  @Schema(example = "1", required = true, description = "The quantity that was received in the warehouse.")
  public Integer getReceivedQuantity() {
    return receivedQuantity;
  }

  public void setReceivedQuantity(Integer receivedQuantity) {
    this.receivedQuantity = receivedQuantity;
  }

  public ReturnItem reasonId(String reasonId) {
    this.reasonId = reasonId;
    return this;
  }

   /**
   * The ID of the reason for returning the item.
   * @return reasonId
  **/
  @Schema(example = "rr_01G8X82GCCV2KSQHDBHSSAH5TQ", required = true, description = "The ID of the reason for returning the item.")
  public String getReasonId() {
    return reasonId;
  }

  public void setReasonId(String reasonId) {
    this.reasonId = reasonId;
  }

  public ReturnItem reason(ReturnReason reason) {
    this.reason = reason;
    return this;
  }

   /**
   * Get reason
   * @return reason
  **/
  @Schema(description = "")
  public ReturnReason getReason() {
    return reason;
  }

  public void setReason(ReturnReason reason) {
    this.reason = reason;
  }

  public ReturnItem note(String note) {
    this.note = note;
    return this;
  }

   /**
   * An optional note with additional details about the Return.
   * @return note
  **/
  @Schema(example = "I didn't like it.", required = true, description = "An optional note with additional details about the Return.")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public ReturnItem metadata(Object metadata) {
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
    ReturnItem returnItem = (ReturnItem) o;
    return Objects.equals(this.returnId, returnItem.returnId) &&
        Objects.equals(this.itemId, returnItem.itemId) &&
        Objects.equals(this.returnOrder, returnItem.returnOrder) &&
        Objects.equals(this.item, returnItem.item) &&
        Objects.equals(this.quantity, returnItem.quantity) &&
        Objects.equals(this.isRequested, returnItem.isRequested) &&
        Objects.equals(this.requestedQuantity, returnItem.requestedQuantity) &&
        Objects.equals(this.receivedQuantity, returnItem.receivedQuantity) &&
        Objects.equals(this.reasonId, returnItem.reasonId) &&
        Objects.equals(this.reason, returnItem.reason) &&
        Objects.equals(this.note, returnItem.note) &&
        Objects.equals(this.metadata, returnItem.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(returnId, itemId, returnOrder, item, quantity, isRequested, requestedQuantity, receivedQuantity, reasonId, reason, note, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReturnItem {\n");
    
    sb.append("    returnId: ").append(toIndentedString(returnId)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    returnOrder: ").append(toIndentedString(returnOrder)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    isRequested: ").append(toIndentedString(isRequested)).append("\n");
    sb.append("    requestedQuantity: ").append(toIndentedString(requestedQuantity)).append("\n");
    sb.append("    receivedQuantity: ").append(toIndentedString(receivedQuantity)).append("\n");
    sb.append("    reasonId: ").append(toIndentedString(reasonId)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
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
