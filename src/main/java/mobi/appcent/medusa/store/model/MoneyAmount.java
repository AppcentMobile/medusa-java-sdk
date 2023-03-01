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
import org.threeten.bp.OffsetDateTime;
/**
 * Money Amounts represents an amount that a given Product Variant can be purcased for. Each Money Amount either has a Currency or Region associated with it to indicate the pricing in a given Currency or, for fully region-based pricing, the given price in a specific Region. If region-based pricing is used the amount will be in the currency defined for the Reigon.
 */
@Schema(description = "Money Amounts represents an amount that a given Product Variant can be purcased for. Each Money Amount either has a Currency or Region associated with it to indicate the pricing in a given Currency or, for fully region-based pricing, the given price in a specific Region. If region-based pricing is used the amount will be in the currency defined for the Reigon.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class MoneyAmount {
  @SerializedName("id")
  private String id = null;

  @SerializedName("currency_code")
  private String currencyCode = null;

  @SerializedName("currency")
  private Currency currency = null;

  @SerializedName("amount")
  private Integer amount = null;

  @SerializedName("min_quantity")
  private Integer minQuantity = null;

  @SerializedName("max_quantity")
  private Integer maxQuantity = null;

  @SerializedName("price_list_id")
  private String priceListId = null;

  @SerializedName("price_list")
  private Object priceList = null;

  @SerializedName("variant_id")
  private String variantId = null;

  @SerializedName("variant")
  private Object variant = null;

  @SerializedName("region_id")
  private String regionId = null;

  @SerializedName("region")
  private Object region = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  public MoneyAmount id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The money amount&#x27;s ID
   * @return id
  **/
  @Schema(example = "ma_01F0YESHRFQNH5S8Q0PK84YYZN", required = true, description = "The money amount's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MoneyAmount currencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

   /**
   * The 3 character currency code that the Money Amount is given in.
   * @return currencyCode
  **/
  @Schema(example = "usd", required = true, description = "The 3 character currency code that the Money Amount is given in.")
  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public MoneyAmount currency(Currency currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Get currency
   * @return currency
  **/
  @Schema(description = "")
  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public MoneyAmount amount(Integer amount) {
    this.amount = amount;
    return this;
  }

   /**
   * The amount in the smallest currecny unit (e.g. cents 100 cents to charge $1) that the Product Variant will cost.
   * @return amount
  **/
  @Schema(example = "100", required = true, description = "The amount in the smallest currecny unit (e.g. cents 100 cents to charge $1) that the Product Variant will cost.")
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public MoneyAmount minQuantity(Integer minQuantity) {
    this.minQuantity = minQuantity;
    return this;
  }

   /**
   * The minimum quantity that the Money Amount applies to. If this value is not set, the Money Amount applies to all quantities.
   * @return minQuantity
  **/
  @Schema(example = "1", required = true, description = "The minimum quantity that the Money Amount applies to. If this value is not set, the Money Amount applies to all quantities.")
  public Integer getMinQuantity() {
    return minQuantity;
  }

  public void setMinQuantity(Integer minQuantity) {
    this.minQuantity = minQuantity;
  }

  public MoneyAmount maxQuantity(Integer maxQuantity) {
    this.maxQuantity = maxQuantity;
    return this;
  }

   /**
   * The maximum quantity that the Money Amount applies to. If this value is not set, the Money Amount applies to all quantities.
   * @return maxQuantity
  **/
  @Schema(example = "1", required = true, description = "The maximum quantity that the Money Amount applies to. If this value is not set, the Money Amount applies to all quantities.")
  public Integer getMaxQuantity() {
    return maxQuantity;
  }

  public void setMaxQuantity(Integer maxQuantity) {
    this.maxQuantity = maxQuantity;
  }

  public MoneyAmount priceListId(String priceListId) {
    this.priceListId = priceListId;
    return this;
  }

   /**
   * The ID of the price list associated with the money amount
   * @return priceListId
  **/
  @Schema(example = "pl_01G8X3CKJXCG5VXVZ87H9KC09W", required = true, description = "The ID of the price list associated with the money amount")
  public String getPriceListId() {
    return priceListId;
  }

  public void setPriceListId(String priceListId) {
    this.priceListId = priceListId;
  }

  public MoneyAmount priceList(Object priceList) {
    this.priceList = priceList;
    return this;
  }

   /**
   * Available if the relation &#x60;price_list&#x60; is expanded.
   * @return priceList
  **/
  @Schema(description = "Available if the relation `price_list` is expanded.")
  public Object getPriceList() {
    return priceList;
  }

  public void setPriceList(Object priceList) {
    this.priceList = priceList;
  }

  public MoneyAmount variantId(String variantId) {
    this.variantId = variantId;
    return this;
  }

   /**
   * The id of the Product Variant contained in the Line Item.
   * @return variantId
  **/
  @Schema(example = "variant_01G1G5V2MRX2V3PVSR2WXYPFB6", required = true, description = "The id of the Product Variant contained in the Line Item.")
  public String getVariantId() {
    return variantId;
  }

  public void setVariantId(String variantId) {
    this.variantId = variantId;
  }

  public MoneyAmount variant(Object variant) {
    this.variant = variant;
    return this;
  }

   /**
   * The Product Variant contained in the Line Item. Available if the relation &#x60;variant&#x60; is expanded.
   * @return variant
  **/
  @Schema(description = "The Product Variant contained in the Line Item. Available if the relation `variant` is expanded.")
  public Object getVariant() {
    return variant;
  }

  public void setVariant(Object variant) {
    this.variant = variant;
  }

  public MoneyAmount regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

   /**
   * The region&#x27;s ID
   * @return regionId
  **/
  @Schema(example = "reg_01G1G5V26T9H8Y0M4JNE3YGA4G", required = true, description = "The region's ID")
  public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public MoneyAmount region(Object region) {
    this.region = region;
    return this;
  }

   /**
   * A region object. Available if the relation &#x60;region&#x60; is expanded.
   * @return region
  **/
  @Schema(description = "A region object. Available if the relation `region` is expanded.")
  public Object getRegion() {
    return region;
  }

  public void setRegion(Object region) {
    this.region = region;
  }

  public MoneyAmount createdAt(OffsetDateTime createdAt) {
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

  public MoneyAmount updatedAt(OffsetDateTime updatedAt) {
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

  public MoneyAmount deletedAt(OffsetDateTime deletedAt) {
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
    MoneyAmount moneyAmount = (MoneyAmount) o;
    return Objects.equals(this.id, moneyAmount.id) &&
        Objects.equals(this.currencyCode, moneyAmount.currencyCode) &&
        Objects.equals(this.currency, moneyAmount.currency) &&
        Objects.equals(this.amount, moneyAmount.amount) &&
        Objects.equals(this.minQuantity, moneyAmount.minQuantity) &&
        Objects.equals(this.maxQuantity, moneyAmount.maxQuantity) &&
        Objects.equals(this.priceListId, moneyAmount.priceListId) &&
        Objects.equals(this.priceList, moneyAmount.priceList) &&
        Objects.equals(this.variantId, moneyAmount.variantId) &&
        Objects.equals(this.variant, moneyAmount.variant) &&
        Objects.equals(this.regionId, moneyAmount.regionId) &&
        Objects.equals(this.region, moneyAmount.region) &&
        Objects.equals(this.createdAt, moneyAmount.createdAt) &&
        Objects.equals(this.updatedAt, moneyAmount.updatedAt) &&
        Objects.equals(this.deletedAt, moneyAmount.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, currencyCode, currency, amount, minQuantity, maxQuantity, priceListId, priceList, variantId, variant, regionId, region, createdAt, updatedAt, deletedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoneyAmount {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    minQuantity: ").append(toIndentedString(minQuantity)).append("\n");
    sb.append("    maxQuantity: ").append(toIndentedString(maxQuantity)).append("\n");
    sb.append("    priceListId: ").append(toIndentedString(priceListId)).append("\n");
    sb.append("    priceList: ").append(toIndentedString(priceList)).append("\n");
    sb.append("    variantId: ").append(toIndentedString(variantId)).append("\n");
    sb.append("    variant: ").append(toIndentedString(variant)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
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
