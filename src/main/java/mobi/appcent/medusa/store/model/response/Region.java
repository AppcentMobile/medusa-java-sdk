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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * Regions hold settings for how Customers in a given geographical location shop. The is, for example, where currencies and tax rates are defined. A Region can consist of multiple countries to accomodate common shopping settings across countries.
 */
@Schema(description = "Regions hold settings for how Customers in a given geographical location shop. The is, for example, where currencies and tax rates are defined. A Region can consist of multiple countries to accomodate common shopping settings across countries.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class Region {
  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("currency_code")
  private String currencyCode = null;

  @SerializedName("currency")
  private Currency currency = null;

  @SerializedName("tax_rate")
  private BigDecimal taxRate = null;

  @SerializedName("tax_rates")
  private List<TaxRate> taxRates = null;

  @SerializedName("tax_code")
  private String taxCode = null;

  @SerializedName("gift_cards_taxable")
  private Boolean giftCardsTaxable = true;

  @SerializedName("automatic_taxes")
  private Boolean automaticTaxes = true;

  @SerializedName("countries")
  private List<Country> countries = null;

  @SerializedName("tax_provider_id")
  private String taxProviderId = null;

  @SerializedName("tax_provider")
  private TaxProvider taxProvider = null;

  @SerializedName("payment_providers")
  private List<PaymentProvider> paymentProviders = null;

  @SerializedName("fulfillment_providers")
  private List<FulfillmentProvider> fulfillmentProviders = null;

  @SerializedName("includes_tax")
  private Boolean includesTax = false;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public Region id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The region&#x27;s ID
   * @return id
  **/
  @Schema(example = "reg_01G1G5V26T9H8Y0M4JNE3YGA4G", required = true, description = "The region's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Region name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the region as displayed to the customer. If the Region only has one country it is recommended to write the country name.
   * @return name
  **/
  @Schema(example = "EU", required = true, description = "The name of the region as displayed to the customer. If the Region only has one country it is recommended to write the country name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Region currencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

   /**
   * The 3 character currency code that the Region uses.
   * @return currencyCode
  **/
  @Schema(example = "usd", required = true, description = "The 3 character currency code that the Region uses.")
  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Region currency(Currency currency) {
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

  public Region taxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
    return this;
  }

   /**
   * The tax rate that should be charged on purchases in the Region.
   * @return taxRate
  **/
  @Schema(example = "0", required = true, description = "The tax rate that should be charged on purchases in the Region.")
  public BigDecimal getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
  }

  public Region taxRates(List<TaxRate> taxRates) {
    this.taxRates = taxRates;
    return this;
  }

  public Region addTaxRatesItem(TaxRate taxRatesItem) {
    if (this.taxRates == null) {
      this.taxRates = new ArrayList<TaxRate>();
    }
    this.taxRates.add(taxRatesItem);
    return this;
  }

   /**
   * The tax rates that are included in the Region. Available if the relation &#x60;tax_rates&#x60; is expanded.
   * @return taxRates
  **/
  @Schema(description = "The tax rates that are included in the Region. Available if the relation `tax_rates` is expanded.")
  public List<TaxRate> getTaxRates() {
    return taxRates;
  }

  public void setTaxRates(List<TaxRate> taxRates) {
    this.taxRates = taxRates;
  }

  public Region taxCode(String taxCode) {
    this.taxCode = taxCode;
    return this;
  }

   /**
   * The tax code used on purchases in the Region. This may be used by other systems for accounting purposes.
   * @return taxCode
  **/
  @Schema(required = true, description = "The tax code used on purchases in the Region. This may be used by other systems for accounting purposes.")
  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public Region giftCardsTaxable(Boolean giftCardsTaxable) {
    this.giftCardsTaxable = giftCardsTaxable;
    return this;
  }

   /**
   * Whether the gift cards are taxable or not in this region.
   * @return giftCardsTaxable
  **/
  @Schema(required = true, description = "Whether the gift cards are taxable or not in this region.")
  public Boolean isGiftCardsTaxable() {
    return giftCardsTaxable;
  }

  public void setGiftCardsTaxable(Boolean giftCardsTaxable) {
    this.giftCardsTaxable = giftCardsTaxable;
  }

  public Region automaticTaxes(Boolean automaticTaxes) {
    this.automaticTaxes = automaticTaxes;
    return this;
  }

   /**
   * Whether taxes should be automated in this region.
   * @return automaticTaxes
  **/
  @Schema(required = true, description = "Whether taxes should be automated in this region.")
  public Boolean isAutomaticTaxes() {
    return automaticTaxes;
  }

  public void setAutomaticTaxes(Boolean automaticTaxes) {
    this.automaticTaxes = automaticTaxes;
  }

  public Region countries(List<Country> countries) {
    this.countries = countries;
    return this;
  }

  public Region addCountriesItem(Country countriesItem) {
    if (this.countries == null) {
      this.countries = new ArrayList<Country>();
    }
    this.countries.add(countriesItem);
    return this;
  }

   /**
   * The countries that are included in the Region. Available if the relation &#x60;countries&#x60; is expanded.
   * @return countries
  **/
  @Schema(description = "The countries that are included in the Region. Available if the relation `countries` is expanded.")
  public List<Country> getCountries() {
    return countries;
  }

  public void setCountries(List<Country> countries) {
    this.countries = countries;
  }

  public Region taxProviderId(String taxProviderId) {
    this.taxProviderId = taxProviderId;
    return this;
  }

   /**
   * The ID of the tax provider used in this region
   * @return taxProviderId
  **/
  @Schema(required = true, description = "The ID of the tax provider used in this region")
  public String getTaxProviderId() {
    return taxProviderId;
  }

  public void setTaxProviderId(String taxProviderId) {
    this.taxProviderId = taxProviderId;
  }

  public Region taxProvider(TaxProvider taxProvider) {
    this.taxProvider = taxProvider;
    return this;
  }

   /**
   * Get taxProvider
   * @return taxProvider
  **/
  @Schema(description = "")
  public TaxProvider getTaxProvider() {
    return taxProvider;
  }

  public void setTaxProvider(TaxProvider taxProvider) {
    this.taxProvider = taxProvider;
  }

  public Region paymentProviders(List<PaymentProvider> paymentProviders) {
    this.paymentProviders = paymentProviders;
    return this;
  }

  public Region addPaymentProvidersItem(PaymentProvider paymentProvidersItem) {
    if (this.paymentProviders == null) {
      this.paymentProviders = new ArrayList<PaymentProvider>();
    }
    this.paymentProviders.add(paymentProvidersItem);
    return this;
  }

   /**
   * The Payment Providers that can be used to process Payments in the Region. Available if the relation &#x60;payment_providers&#x60; is expanded.
   * @return paymentProviders
  **/
  @Schema(description = "The Payment Providers that can be used to process Payments in the Region. Available if the relation `payment_providers` is expanded.")
  public List<PaymentProvider> getPaymentProviders() {
    return paymentProviders;
  }

  public void setPaymentProviders(List<PaymentProvider> paymentProviders) {
    this.paymentProviders = paymentProviders;
  }

  public Region fulfillmentProviders(List<FulfillmentProvider> fulfillmentProviders) {
    this.fulfillmentProviders = fulfillmentProviders;
    return this;
  }

  public Region addFulfillmentProvidersItem(FulfillmentProvider fulfillmentProvidersItem) {
    if (this.fulfillmentProviders == null) {
      this.fulfillmentProviders = new ArrayList<FulfillmentProvider>();
    }
    this.fulfillmentProviders.add(fulfillmentProvidersItem);
    return this;
  }

   /**
   * The Fulfillment Providers that can be used to fulfill orders in the Region. Available if the relation &#x60;fulfillment_providers&#x60; is expanded.
   * @return fulfillmentProviders
  **/
  @Schema(description = "The Fulfillment Providers that can be used to fulfill orders in the Region. Available if the relation `fulfillment_providers` is expanded.")
  public List<FulfillmentProvider> getFulfillmentProviders() {
    return fulfillmentProviders;
  }

  public void setFulfillmentProviders(List<FulfillmentProvider> fulfillmentProviders) {
    this.fulfillmentProviders = fulfillmentProviders;
  }

  public Region includesTax(Boolean includesTax) {
    this.includesTax = includesTax;
    return this;
  }

   /**
   * [EXPERIMENTAL] Does the prices for the region include tax
   * @return includesTax
  **/
  @Schema(description = "[EXPERIMENTAL] Does the prices for the region include tax")
  public Boolean isIncludesTax() {
    return includesTax;
  }

  public void setIncludesTax(Boolean includesTax) {
    this.includesTax = includesTax;
  }

  public Region createdAt(OffsetDateTime createdAt) {
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

  public Region updatedAt(OffsetDateTime updatedAt) {
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

  public Region deletedAt(OffsetDateTime deletedAt) {
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

  public Region metadata(Object metadata) {
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
    Region region = (Region) o;
    return Objects.equals(this.id, region.id) &&
        Objects.equals(this.name, region.name) &&
        Objects.equals(this.currencyCode, region.currencyCode) &&
        Objects.equals(this.currency, region.currency) &&
        Objects.equals(this.taxRate, region.taxRate) &&
        Objects.equals(this.taxRates, region.taxRates) &&
        Objects.equals(this.taxCode, region.taxCode) &&
        Objects.equals(this.giftCardsTaxable, region.giftCardsTaxable) &&
        Objects.equals(this.automaticTaxes, region.automaticTaxes) &&
        Objects.equals(this.countries, region.countries) &&
        Objects.equals(this.taxProviderId, region.taxProviderId) &&
        Objects.equals(this.taxProvider, region.taxProvider) &&
        Objects.equals(this.paymentProviders, region.paymentProviders) &&
        Objects.equals(this.fulfillmentProviders, region.fulfillmentProviders) &&
        Objects.equals(this.includesTax, region.includesTax) &&
        Objects.equals(this.createdAt, region.createdAt) &&
        Objects.equals(this.updatedAt, region.updatedAt) &&
        Objects.equals(this.deletedAt, region.deletedAt) &&
        Objects.equals(this.metadata, region.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, currencyCode, currency, taxRate, taxRates, taxCode, giftCardsTaxable, automaticTaxes, countries, taxProviderId, taxProvider, paymentProviders, fulfillmentProviders, includesTax, createdAt, updatedAt, deletedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Region {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
    sb.append("    taxRates: ").append(toIndentedString(taxRates)).append("\n");
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    giftCardsTaxable: ").append(toIndentedString(giftCardsTaxable)).append("\n");
    sb.append("    automaticTaxes: ").append(toIndentedString(automaticTaxes)).append("\n");
    sb.append("    countries: ").append(toIndentedString(countries)).append("\n");
    sb.append("    taxProviderId: ").append(toIndentedString(taxProviderId)).append("\n");
    sb.append("    taxProvider: ").append(toIndentedString(taxProvider)).append("\n");
    sb.append("    paymentProviders: ").append(toIndentedString(paymentProviders)).append("\n");
    sb.append("    fulfillmentProviders: ").append(toIndentedString(fulfillmentProviders)).append("\n");
    sb.append("    includesTax: ").append(toIndentedString(includesTax)).append("\n");
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
