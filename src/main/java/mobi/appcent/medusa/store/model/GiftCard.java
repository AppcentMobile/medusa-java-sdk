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

import java.math.BigDecimal;
import org.threeten.bp.OffsetDateTime;
/**
 * Gift Cards are redeemable and represent a value that can be used towards the payment of an Order.
 */
@Schema(description = "Gift Cards are redeemable and represent a value that can be used towards the payment of an Order.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class GiftCard {
  @SerializedName("id")
  private String id = null;

  @SerializedName("code")
  private String code = null;

  @SerializedName("value")
  private Integer value = null;

  @SerializedName("balance")
  private Integer balance = null;

  @SerializedName("region_id")
  private String regionId = null;

  @SerializedName("region")
  private Region region = null;

  @SerializedName("order_id")
  private String orderId = null;

  @SerializedName("order")
  private Object order = null;

  @SerializedName("is_disabled")
  private Boolean isDisabled = false;

  @SerializedName("ends_at")
  private OffsetDateTime endsAt = null;

  @SerializedName("tax_rate")
  private BigDecimal taxRate = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public GiftCard id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The gift card&#x27;s ID
   * @return id
  **/
  @Schema(example = "gift_01G8XKBPBQY2R7RBET4J7E0XQZ", required = true, description = "The gift card's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GiftCard code(String code) {
    this.code = code;
    return this;
  }

   /**
   * The unique code that identifies the Gift Card. This is used by the Customer to redeem the value of the Gift Card.
   * @return code
  **/
  @Schema(example = "3RFT-MH2C-Y4YZ-XMN4", required = true, description = "The unique code that identifies the Gift Card. This is used by the Customer to redeem the value of the Gift Card.")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public GiftCard value(Integer value) {
    this.value = value;
    return this;
  }

   /**
   * The value that the Gift Card represents.
   * @return value
  **/
  @Schema(example = "10", required = true, description = "The value that the Gift Card represents.")
  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public GiftCard balance(Integer balance) {
    this.balance = balance;
    return this;
  }

   /**
   * The remaining value on the Gift Card.
   * @return balance
  **/
  @Schema(example = "10", required = true, description = "The remaining value on the Gift Card.")
  public Integer getBalance() {
    return balance;
  }

  public void setBalance(Integer balance) {
    this.balance = balance;
  }

  public GiftCard regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

   /**
   * The id of the Region in which the Gift Card is available.
   * @return regionId
  **/
  @Schema(example = "reg_01G1G5V26T9H8Y0M4JNE3YGA4G", required = true, description = "The id of the Region in which the Gift Card is available.")
  public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public GiftCard region(Region region) {
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

  public GiftCard orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * The id of the Order that the Gift Card was purchased in.
   * @return orderId
  **/
  @Schema(example = "order_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The id of the Order that the Gift Card was purchased in.")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public GiftCard order(Object order) {
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

  public GiftCard isDisabled(Boolean isDisabled) {
    this.isDisabled = isDisabled;
    return this;
  }

   /**
   * Whether the Gift Card has been disabled. Disabled Gift Cards cannot be applied to carts.
   * @return isDisabled
  **/
  @Schema(required = true, description = "Whether the Gift Card has been disabled. Disabled Gift Cards cannot be applied to carts.")
  public Boolean isIsDisabled() {
    return isDisabled;
  }

  public void setIsDisabled(Boolean isDisabled) {
    this.isDisabled = isDisabled;
  }

  public GiftCard endsAt(OffsetDateTime endsAt) {
    this.endsAt = endsAt;
    return this;
  }

   /**
   * The time at which the Gift Card can no longer be used.
   * @return endsAt
  **/
  @Schema(required = true, description = "The time at which the Gift Card can no longer be used.")
  public OffsetDateTime getEndsAt() {
    return endsAt;
  }

  public void setEndsAt(OffsetDateTime endsAt) {
    this.endsAt = endsAt;
  }

  public GiftCard taxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
    return this;
  }

   /**
   * The gift card&#x27;s tax rate that will be applied on calculating totals
   * @return taxRate
  **/
  @Schema(example = "0", required = true, description = "The gift card's tax rate that will be applied on calculating totals")
  public BigDecimal getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
  }

  public GiftCard createdAt(OffsetDateTime createdAt) {
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

  public GiftCard updatedAt(OffsetDateTime updatedAt) {
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

  public GiftCard deletedAt(OffsetDateTime deletedAt) {
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

  public GiftCard metadata(Object metadata) {
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
    GiftCard giftCard = (GiftCard) o;
    return Objects.equals(this.id, giftCard.id) &&
        Objects.equals(this.code, giftCard.code) &&
        Objects.equals(this.value, giftCard.value) &&
        Objects.equals(this.balance, giftCard.balance) &&
        Objects.equals(this.regionId, giftCard.regionId) &&
        Objects.equals(this.region, giftCard.region) &&
        Objects.equals(this.orderId, giftCard.orderId) &&
        Objects.equals(this.order, giftCard.order) &&
        Objects.equals(this.isDisabled, giftCard.isDisabled) &&
        Objects.equals(this.endsAt, giftCard.endsAt) &&
        Objects.equals(this.taxRate, giftCard.taxRate) &&
        Objects.equals(this.createdAt, giftCard.createdAt) &&
        Objects.equals(this.updatedAt, giftCard.updatedAt) &&
        Objects.equals(this.deletedAt, giftCard.deletedAt) &&
        Objects.equals(this.metadata, giftCard.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, value, balance, regionId, region, orderId, order, isDisabled, endsAt, taxRate, createdAt, updatedAt, deletedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GiftCard {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    isDisabled: ").append(toIndentedString(isDisabled)).append("\n");
    sb.append("    endsAt: ").append(toIndentedString(endsAt)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
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
