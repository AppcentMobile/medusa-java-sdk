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
 * Represents a claimed item along with information about the reasons for the claim.
 */
@Schema(description = "Represents a claimed item along with information about the reasons for the claim.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class ClaimItem {
  @SerializedName("id")
  private String id = null;

  @SerializedName("images")
  private List<ClaimImage> images = null;

  @SerializedName("claim_order_id")
  private String claimOrderId = null;

  @SerializedName("claim_order")
  private Object claimOrder = null;

  @SerializedName("item_id")
  private String itemId = null;

  @SerializedName("item")
  private LineItem item = null;

  @SerializedName("variant_id")
  private String variantId = null;

  @SerializedName("variant")
  private ProductVariant variant = null;

  /**
   * The reason for the claim
   */
  @JsonAdapter(ReasonEnum.Adapter.class)
  public enum ReasonEnum {
    MISSING_ITEM("missing_item"),
    WRONG_ITEM("wrong_item"),
    PRODUCTION_FAILURE("production_failure"),
    OTHER("other");

    private String value;

    ReasonEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static ReasonEnum fromValue(String input) {
      for (ReasonEnum b : ReasonEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<ReasonEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ReasonEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public ReasonEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return ReasonEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("reason")
  private ReasonEnum reason = null;

  @SerializedName("note")
  private String note = null;

  @SerializedName("quantity")
  private Integer quantity = null;

  @SerializedName("tags")
  private List<ClaimTag> tags = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public ClaimItem id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The claim item&#x27;s ID
   * @return id
  **/
  @Schema(example = "citm_01G8ZH853Y6TFXWPG5EYE81X63", required = true, description = "The claim item's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ClaimItem images(List<ClaimImage> images) {
    this.images = images;
    return this;
  }

  public ClaimItem addImagesItem(ClaimImage imagesItem) {
    if (this.images == null) {
      this.images = new ArrayList<ClaimImage>();
    }
    this.images.add(imagesItem);
    return this;
  }

   /**
   * Available if the relation &#x60;images&#x60; is expanded.
   * @return images
  **/
  @Schema(description = "Available if the relation `images` is expanded.")
  public List<ClaimImage> getImages() {
    return images;
  }

  public void setImages(List<ClaimImage> images) {
    this.images = images;
  }

  public ClaimItem claimOrderId(String claimOrderId) {
    this.claimOrderId = claimOrderId;
    return this;
  }

   /**
   * The ID of the claim this item is associated with.
   * @return claimOrderId
  **/
  @Schema(required = true, description = "The ID of the claim this item is associated with.")
  public String getClaimOrderId() {
    return claimOrderId;
  }

  public void setClaimOrderId(String claimOrderId) {
    this.claimOrderId = claimOrderId;
  }

  public ClaimItem claimOrder(Object claimOrder) {
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

  public ClaimItem itemId(String itemId) {
    this.itemId = itemId;
    return this;
  }

   /**
   * The ID of the line item that the claim item refers to.
   * @return itemId
  **/
  @Schema(example = "item_01G8ZM25TN49YV9EQBE2NC27KC", required = true, description = "The ID of the line item that the claim item refers to.")
  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public ClaimItem item(LineItem item) {
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

  public ClaimItem variantId(String variantId) {
    this.variantId = variantId;
    return this;
  }

   /**
   * The ID of the product variant that is claimed.
   * @return variantId
  **/
  @Schema(example = "variant_01G1G5V2MRX2V3PVSR2WXYPFB6", required = true, description = "The ID of the product variant that is claimed.")
  public String getVariantId() {
    return variantId;
  }

  public void setVariantId(String variantId) {
    this.variantId = variantId;
  }

  public ClaimItem variant(ProductVariant variant) {
    this.variant = variant;
    return this;
  }

   /**
   * Get variant
   * @return variant
  **/
  @Schema(description = "")
  public ProductVariant getVariant() {
    return variant;
  }

  public void setVariant(ProductVariant variant) {
    this.variant = variant;
  }

  public ClaimItem reason(ReasonEnum reason) {
    this.reason = reason;
    return this;
  }

   /**
   * The reason for the claim
   * @return reason
  **/
  @Schema(required = true, description = "The reason for the claim")
  public ReasonEnum getReason() {
    return reason;
  }

  public void setReason(ReasonEnum reason) {
    this.reason = reason;
  }

  public ClaimItem note(String note) {
    this.note = note;
    return this;
  }

   /**
   * An optional note about the claim, for additional information
   * @return note
  **/
  @Schema(example = "I don't like it.", required = true, description = "An optional note about the claim, for additional information")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public ClaimItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * The quantity of the item that is being claimed; must be less than or equal to the amount purchased in the original order.
   * @return quantity
  **/
  @Schema(example = "1", required = true, description = "The quantity of the item that is being claimed; must be less than or equal to the amount purchased in the original order.")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public ClaimItem tags(List<ClaimTag> tags) {
    this.tags = tags;
    return this;
  }

  public ClaimItem addTagsItem(ClaimTag tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<ClaimTag>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * User defined tags for easy filtering and grouping. Available if the relation &#x27;tags&#x27; is expanded.
   * @return tags
  **/
  @Schema(description = "User defined tags for easy filtering and grouping. Available if the relation 'tags' is expanded.")
  public List<ClaimTag> getTags() {
    return tags;
  }

  public void setTags(List<ClaimTag> tags) {
    this.tags = tags;
  }

  public ClaimItem createdAt(OffsetDateTime createdAt) {
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

  public ClaimItem updatedAt(OffsetDateTime updatedAt) {
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

  public ClaimItem deletedAt(OffsetDateTime deletedAt) {
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

  public ClaimItem metadata(Object metadata) {
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
    ClaimItem claimItem = (ClaimItem) o;
    return Objects.equals(this.id, claimItem.id) &&
        Objects.equals(this.images, claimItem.images) &&
        Objects.equals(this.claimOrderId, claimItem.claimOrderId) &&
        Objects.equals(this.claimOrder, claimItem.claimOrder) &&
        Objects.equals(this.itemId, claimItem.itemId) &&
        Objects.equals(this.item, claimItem.item) &&
        Objects.equals(this.variantId, claimItem.variantId) &&
        Objects.equals(this.variant, claimItem.variant) &&
        Objects.equals(this.reason, claimItem.reason) &&
        Objects.equals(this.note, claimItem.note) &&
        Objects.equals(this.quantity, claimItem.quantity) &&
        Objects.equals(this.tags, claimItem.tags) &&
        Objects.equals(this.createdAt, claimItem.createdAt) &&
        Objects.equals(this.updatedAt, claimItem.updatedAt) &&
        Objects.equals(this.deletedAt, claimItem.deletedAt) &&
        Objects.equals(this.metadata, claimItem.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, images, claimOrderId, claimOrder, itemId, item, variantId, variant, reason, note, quantity, tags, createdAt, updatedAt, deletedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClaimItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
    sb.append("    claimOrderId: ").append(toIndentedString(claimOrderId)).append("\n");
    sb.append("    claimOrder: ").append(toIndentedString(claimOrder)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
    sb.append("    variantId: ").append(toIndentedString(variantId)).append("\n");
    sb.append("    variant: ").append(toIndentedString(variant)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
