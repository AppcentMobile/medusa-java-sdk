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
/**
 * StorePostCartsCartReq
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class StorePostCartsCartReq {
  @SerializedName("region_id")
  private String regionId = null;

  @SerializedName("country_code")
  private String countryCode = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("sales_channel_id")
  private String salesChannelId = null;

  @SerializedName("billing_address")
  private AnyOfStorePostCartsCartReqBillingAddress billingAddress = null;

  @SerializedName("shipping_address")
  private AnyOfStorePostCartsCartReqShippingAddress shippingAddress = null;

  @SerializedName("gift_cards")
  private List<StorePostCartsCartReqGiftCards> giftCards = null;

  @SerializedName("discounts")
  private List<StorePostCartsCartReqDiscounts> discounts = null;

  @SerializedName("customer_id")
  private String customerId = null;

  @SerializedName("context")
  private Object context = null;

  public StorePostCartsCartReq regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

   /**
   * The id of the Region to create the Cart in.
   * @return regionId
  **/
  @Schema(description = "The id of the Region to create the Cart in.")
  public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public StorePostCartsCartReq countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

   /**
   * The 2 character ISO country code to create the Cart in.
   * @return countryCode
  **/
  @Schema(description = "The 2 character ISO country code to create the Cart in.")
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public StorePostCartsCartReq email(String email) {
    this.email = email;
    return this;
  }

   /**
   * An email to be used on the Cart.
   * @return email
  **/
  @Schema(description = "An email to be used on the Cart.")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public StorePostCartsCartReq salesChannelId(String salesChannelId) {
    this.salesChannelId = salesChannelId;
    return this;
  }

   /**
   * The ID of the Sales channel to update the Cart with.
   * @return salesChannelId
  **/
  @Schema(description = "The ID of the Sales channel to update the Cart with.")
  public String getSalesChannelId() {
    return salesChannelId;
  }

  public void setSalesChannelId(String salesChannelId) {
    this.salesChannelId = salesChannelId;
  }

  public StorePostCartsCartReq billingAddress(AnyOfStorePostCartsCartReqBillingAddress billingAddress) {
    this.billingAddress = billingAddress;
    return this;
  }

   /**
   * The Address to be used for billing purposes.
   * @return billingAddress
  **/
  @Schema(description = "The Address to be used for billing purposes.")
  public AnyOfStorePostCartsCartReqBillingAddress getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(AnyOfStorePostCartsCartReqBillingAddress billingAddress) {
    this.billingAddress = billingAddress;
  }

  public StorePostCartsCartReq shippingAddress(AnyOfStorePostCartsCartReqShippingAddress shippingAddress) {
    this.shippingAddress = shippingAddress;
    return this;
  }

   /**
   * The Address to be used for shipping.
   * @return shippingAddress
  **/
  @Schema(description = "The Address to be used for shipping.")
  public AnyOfStorePostCartsCartReqShippingAddress getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(AnyOfStorePostCartsCartReqShippingAddress shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public StorePostCartsCartReq giftCards(List<StorePostCartsCartReqGiftCards> giftCards) {
    this.giftCards = giftCards;
    return this;
  }

  public StorePostCartsCartReq addGiftCardsItem(StorePostCartsCartReqGiftCards giftCardsItem) {
    if (this.giftCards == null) {
      this.giftCards = new ArrayList<StorePostCartsCartReqGiftCards>();
    }
    this.giftCards.add(giftCardsItem);
    return this;
  }

   /**
   * An array of Gift Card codes to add to the Cart.
   * @return giftCards
  **/
  @Schema(description = "An array of Gift Card codes to add to the Cart.")
  public List<StorePostCartsCartReqGiftCards> getGiftCards() {
    return giftCards;
  }

  public void setGiftCards(List<StorePostCartsCartReqGiftCards> giftCards) {
    this.giftCards = giftCards;
  }

  public StorePostCartsCartReq discounts(List<StorePostCartsCartReqDiscounts> discounts) {
    this.discounts = discounts;
    return this;
  }

  public StorePostCartsCartReq addDiscountsItem(StorePostCartsCartReqDiscounts discountsItem) {
    if (this.discounts == null) {
      this.discounts = new ArrayList<StorePostCartsCartReqDiscounts>();
    }
    this.discounts.add(discountsItem);
    return this;
  }

   /**
   * An array of Discount codes to add to the Cart.
   * @return discounts
  **/
  @Schema(description = "An array of Discount codes to add to the Cart.")
  public List<StorePostCartsCartReqDiscounts> getDiscounts() {
    return discounts;
  }

  public void setDiscounts(List<StorePostCartsCartReqDiscounts> discounts) {
    this.discounts = discounts;
  }

  public StorePostCartsCartReq customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * The ID of the Customer to associate the Cart with.
   * @return customerId
  **/
  @Schema(description = "The ID of the Customer to associate the Cart with.")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public StorePostCartsCartReq context(Object context) {
    this.context = context;
    return this;
  }

   /**
   * An optional object to provide context to the Cart.
   * @return context
  **/
  @Schema(example = "{\"ip\":\"::1\",\"user_agent\":\"Chrome\"}", description = "An optional object to provide context to the Cart.")
  public Object getContext() {
    return context;
  }

  public void setContext(Object context) {
    this.context = context;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StorePostCartsCartReq storePostCartsCartReq = (StorePostCartsCartReq) o;
    return Objects.equals(this.regionId, storePostCartsCartReq.regionId) &&
        Objects.equals(this.countryCode, storePostCartsCartReq.countryCode) &&
        Objects.equals(this.email, storePostCartsCartReq.email) &&
        Objects.equals(this.salesChannelId, storePostCartsCartReq.salesChannelId) &&
        Objects.equals(this.billingAddress, storePostCartsCartReq.billingAddress) &&
        Objects.equals(this.shippingAddress, storePostCartsCartReq.shippingAddress) &&
        Objects.equals(this.giftCards, storePostCartsCartReq.giftCards) &&
        Objects.equals(this.discounts, storePostCartsCartReq.discounts) &&
        Objects.equals(this.customerId, storePostCartsCartReq.customerId) &&
        Objects.equals(this.context, storePostCartsCartReq.context);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionId, countryCode, email, salesChannelId, billingAddress, shippingAddress, giftCards, discounts, customerId, context);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StorePostCartsCartReq {\n");
    
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    salesChannelId: ").append(toIndentedString(salesChannelId)).append("\n");
    sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
    sb.append("    shippingAddress: ").append(toIndentedString(shippingAddress)).append("\n");
    sb.append("    giftCards: ").append(toIndentedString(giftCards)).append("\n");
    sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
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
