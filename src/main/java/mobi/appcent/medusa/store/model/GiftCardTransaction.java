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
 * Gift Card Transactions are created once a Customer uses a Gift Card to pay for their Order
 */
@Schema(description = "Gift Card Transactions are created once a Customer uses a Gift Card to pay for their Order")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class GiftCardTransaction {
  @SerializedName("id")
  private String id = null;

  @SerializedName("gift_card_id")
  private String giftCardId = null;

  @SerializedName("gift_card")
  private Object giftCard = null;

  @SerializedName("order_id")
  private String orderId = null;

  @SerializedName("order")
  private Object order = null;

  @SerializedName("amount")
  private Integer amount = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("is_taxable")
  private Boolean isTaxable = null;

  @SerializedName("tax_rate")
  private BigDecimal taxRate = null;

  public GiftCardTransaction id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The gift card transaction&#x27;s ID
   * @return id
  **/
  @Schema(example = "gct_01G8X9A7ESKAJXG2H0E6F1MW7A", required = true, description = "The gift card transaction's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GiftCardTransaction giftCardId(String giftCardId) {
    this.giftCardId = giftCardId;
    return this;
  }

   /**
   * The ID of the Gift Card that was used in the transaction.
   * @return giftCardId
  **/
  @Schema(example = "gift_01G8XKBPBQY2R7RBET4J7E0XQZ", required = true, description = "The ID of the Gift Card that was used in the transaction.")
  public String getGiftCardId() {
    return giftCardId;
  }

  public void setGiftCardId(String giftCardId) {
    this.giftCardId = giftCardId;
  }

  public GiftCardTransaction giftCard(Object giftCard) {
    this.giftCard = giftCard;
    return this;
  }

   /**
   * A gift card object. Available if the relation &#x60;gift_card&#x60; is expanded.
   * @return giftCard
  **/
  @Schema(description = "A gift card object. Available if the relation `gift_card` is expanded.")
  public Object getGiftCard() {
    return giftCard;
  }

  public void setGiftCard(Object giftCard) {
    this.giftCard = giftCard;
  }

  public GiftCardTransaction orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * The ID of the Order that the Gift Card was used to pay for.
   * @return orderId
  **/
  @Schema(example = "order_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The ID of the Order that the Gift Card was used to pay for.")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public GiftCardTransaction order(Object order) {
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

  public GiftCardTransaction amount(Integer amount) {
    this.amount = amount;
    return this;
  }

   /**
   * The amount that was used from the Gift Card.
   * @return amount
  **/
  @Schema(example = "10", required = true, description = "The amount that was used from the Gift Card.")
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public GiftCardTransaction createdAt(OffsetDateTime createdAt) {
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

  public GiftCardTransaction isTaxable(Boolean isTaxable) {
    this.isTaxable = isTaxable;
    return this;
  }

   /**
   * Whether the transaction is taxable or not.
   * @return isTaxable
  **/
  @Schema(example = "false", required = true, description = "Whether the transaction is taxable or not.")
  public Boolean isIsTaxable() {
    return isTaxable;
  }

  public void setIsTaxable(Boolean isTaxable) {
    this.isTaxable = isTaxable;
  }

  public GiftCardTransaction taxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
    return this;
  }

   /**
   * The tax rate of the transaction
   * @return taxRate
  **/
  @Schema(example = "0", required = true, description = "The tax rate of the transaction")
  public BigDecimal getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GiftCardTransaction giftCardTransaction = (GiftCardTransaction) o;
    return Objects.equals(this.id, giftCardTransaction.id) &&
        Objects.equals(this.giftCardId, giftCardTransaction.giftCardId) &&
        Objects.equals(this.giftCard, giftCardTransaction.giftCard) &&
        Objects.equals(this.orderId, giftCardTransaction.orderId) &&
        Objects.equals(this.order, giftCardTransaction.order) &&
        Objects.equals(this.amount, giftCardTransaction.amount) &&
        Objects.equals(this.createdAt, giftCardTransaction.createdAt) &&
        Objects.equals(this.isTaxable, giftCardTransaction.isTaxable) &&
        Objects.equals(this.taxRate, giftCardTransaction.taxRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, giftCardId, giftCard, orderId, order, amount, createdAt, isTaxable, taxRate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GiftCardTransaction {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    giftCardId: ").append(toIndentedString(giftCardId)).append("\n");
    sb.append("    giftCard: ").append(toIndentedString(giftCard)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    isTaxable: ").append(toIndentedString(isTaxable)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
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
