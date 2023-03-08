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
 * Holds settings for the Store, such as name, currencies, etc.
 */
@Schema(description = "Holds settings for the Store, such as name, currencies, etc.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class Store {
  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("default_currency_code")
  private String defaultCurrencyCode = null;

  @SerializedName("default_currency")
  private Currency defaultCurrency = null;

  @SerializedName("currencies")
  private List<Currency> currencies = null;

  @SerializedName("swap_link_template")
  private String swapLinkTemplate = null;

  @SerializedName("payment_link_template")
  private String paymentLinkTemplate = null;

  @SerializedName("invite_link_template")
  private String inviteLinkTemplate = null;

  @SerializedName("default_location_id")
  private String defaultLocationId = null;

  @SerializedName("default_sales_channel_id")
  private String defaultSalesChannelId = null;

  @SerializedName("default_sales_channel")
  private SalesChannel defaultSalesChannel = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public Store id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The store&#x27;s ID
   * @return id
  **/
  @Schema(example = "store_01G1G5V21KADXNGH29BJMAJ4B4", required = true, description = "The store's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Store name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the Store - this may be displayed to the Customer.
   * @return name
  **/
  @Schema(example = "Medusa Store", required = true, description = "The name of the Store - this may be displayed to the Customer.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Store defaultCurrencyCode(String defaultCurrencyCode) {
    this.defaultCurrencyCode = defaultCurrencyCode;
    return this;
  }

   /**
   * The 3 character currency code that is the default of the store.
   * @return defaultCurrencyCode
  **/
  @Schema(example = "usd", required = true, description = "The 3 character currency code that is the default of the store.")
  public String getDefaultCurrencyCode() {
    return defaultCurrencyCode;
  }

  public void setDefaultCurrencyCode(String defaultCurrencyCode) {
    this.defaultCurrencyCode = defaultCurrencyCode;
  }

  public Store defaultCurrency(Currency defaultCurrency) {
    this.defaultCurrency = defaultCurrency;
    return this;
  }

   /**
   * Get defaultCurrency
   * @return defaultCurrency
  **/
  @Schema(description = "")
  public Currency getDefaultCurrency() {
    return defaultCurrency;
  }

  public void setDefaultCurrency(Currency defaultCurrency) {
    this.defaultCurrency = defaultCurrency;
  }

  public Store currencies(List<Currency> currencies) {
    this.currencies = currencies;
    return this;
  }

  public Store addCurrenciesItem(Currency currenciesItem) {
    if (this.currencies == null) {
      this.currencies = new ArrayList<Currency>();
    }
    this.currencies.add(currenciesItem);
    return this;
  }

   /**
   * The currencies that are enabled for the Store. Available if the relation &#x60;currencies&#x60; is expanded.
   * @return currencies
  **/
  @Schema(description = "The currencies that are enabled for the Store. Available if the relation `currencies` is expanded.")
  public List<Currency> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(List<Currency> currencies) {
    this.currencies = currencies;
  }

  public Store swapLinkTemplate(String swapLinkTemplate) {
    this.swapLinkTemplate = swapLinkTemplate;
    return this;
  }

   /**
   * A template to generate Swap links from. Use {{cart_id}} to include the Swap&#x27;s &#x60;cart_id&#x60; in the link.
   * @return swapLinkTemplate
  **/
  @Schema(required = true, description = "A template to generate Swap links from. Use {{cart_id}} to include the Swap's `cart_id` in the link.")
  public String getSwapLinkTemplate() {
    return swapLinkTemplate;
  }

  public void setSwapLinkTemplate(String swapLinkTemplate) {
    this.swapLinkTemplate = swapLinkTemplate;
  }

  public Store paymentLinkTemplate(String paymentLinkTemplate) {
    this.paymentLinkTemplate = paymentLinkTemplate;
    return this;
  }

   /**
   * A template to generate Payment links from. Use {{cart_id}} to include the payment&#x27;s &#x60;cart_id&#x60; in the link.
   * @return paymentLinkTemplate
  **/
  @Schema(required = true, description = "A template to generate Payment links from. Use {{cart_id}} to include the payment's `cart_id` in the link.")
  public String getPaymentLinkTemplate() {
    return paymentLinkTemplate;
  }

  public void setPaymentLinkTemplate(String paymentLinkTemplate) {
    this.paymentLinkTemplate = paymentLinkTemplate;
  }

  public Store inviteLinkTemplate(String inviteLinkTemplate) {
    this.inviteLinkTemplate = inviteLinkTemplate;
    return this;
  }

   /**
   * A template to generate Invite links from
   * @return inviteLinkTemplate
  **/
  @Schema(required = true, description = "A template to generate Invite links from")
  public String getInviteLinkTemplate() {
    return inviteLinkTemplate;
  }

  public void setInviteLinkTemplate(String inviteLinkTemplate) {
    this.inviteLinkTemplate = inviteLinkTemplate;
  }

  public Store defaultLocationId(String defaultLocationId) {
    this.defaultLocationId = defaultLocationId;
    return this;
  }

   /**
   * The location ID the store is associated with.
   * @return defaultLocationId
  **/
  @Schema(required = true, description = "The location ID the store is associated with.")
  public String getDefaultLocationId() {
    return defaultLocationId;
  }

  public void setDefaultLocationId(String defaultLocationId) {
    this.defaultLocationId = defaultLocationId;
  }

  public Store defaultSalesChannelId(String defaultSalesChannelId) {
    this.defaultSalesChannelId = defaultSalesChannelId;
    return this;
  }

   /**
   * The sales channel ID the cart is associated with.
   * @return defaultSalesChannelId
  **/
  @Schema(description = "The sales channel ID the cart is associated with.")
  public String getDefaultSalesChannelId() {
    return defaultSalesChannelId;
  }

  public void setDefaultSalesChannelId(String defaultSalesChannelId) {
    this.defaultSalesChannelId = defaultSalesChannelId;
  }

  public Store defaultSalesChannel(SalesChannel defaultSalesChannel) {
    this.defaultSalesChannel = defaultSalesChannel;
    return this;
  }

   /**
   * Get defaultSalesChannel
   * @return defaultSalesChannel
  **/
  @Schema(description = "")
  public SalesChannel getDefaultSalesChannel() {
    return defaultSalesChannel;
  }

  public void setDefaultSalesChannel(SalesChannel defaultSalesChannel) {
    this.defaultSalesChannel = defaultSalesChannel;
  }

  public Store createdAt(OffsetDateTime createdAt) {
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

  public Store updatedAt(OffsetDateTime updatedAt) {
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

  public Store metadata(Object metadata) {
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
    Store store = (Store) o;
    return Objects.equals(this.id, store.id) &&
        Objects.equals(this.name, store.name) &&
        Objects.equals(this.defaultCurrencyCode, store.defaultCurrencyCode) &&
        Objects.equals(this.defaultCurrency, store.defaultCurrency) &&
        Objects.equals(this.currencies, store.currencies) &&
        Objects.equals(this.swapLinkTemplate, store.swapLinkTemplate) &&
        Objects.equals(this.paymentLinkTemplate, store.paymentLinkTemplate) &&
        Objects.equals(this.inviteLinkTemplate, store.inviteLinkTemplate) &&
        Objects.equals(this.defaultLocationId, store.defaultLocationId) &&
        Objects.equals(this.defaultSalesChannelId, store.defaultSalesChannelId) &&
        Objects.equals(this.defaultSalesChannel, store.defaultSalesChannel) &&
        Objects.equals(this.createdAt, store.createdAt) &&
        Objects.equals(this.updatedAt, store.updatedAt) &&
        Objects.equals(this.metadata, store.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, defaultCurrencyCode, defaultCurrency, currencies, swapLinkTemplate, paymentLinkTemplate, inviteLinkTemplate, defaultLocationId, defaultSalesChannelId, defaultSalesChannel, createdAt, updatedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Store {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    defaultCurrencyCode: ").append(toIndentedString(defaultCurrencyCode)).append("\n");
    sb.append("    defaultCurrency: ").append(toIndentedString(defaultCurrency)).append("\n");
    sb.append("    currencies: ").append(toIndentedString(currencies)).append("\n");
    sb.append("    swapLinkTemplate: ").append(toIndentedString(swapLinkTemplate)).append("\n");
    sb.append("    paymentLinkTemplate: ").append(toIndentedString(paymentLinkTemplate)).append("\n");
    sb.append("    inviteLinkTemplate: ").append(toIndentedString(inviteLinkTemplate)).append("\n");
    sb.append("    defaultLocationId: ").append(toIndentedString(defaultLocationId)).append("\n");
    sb.append("    defaultSalesChannelId: ").append(toIndentedString(defaultSalesChannelId)).append("\n");
    sb.append("    defaultSalesChannel: ").append(toIndentedString(defaultSalesChannel)).append("\n");
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
