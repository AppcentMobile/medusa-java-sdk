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
 * Shipping Options represent a way in which an Order or Return can be shipped. Shipping Options have an associated Fulfillment Provider that will be used when the fulfillment of an Order is initiated. Shipping Options themselves cannot be added to Carts, but serve as a template for Shipping Methods. This distinction makes it possible to customize individual Shipping Methods with additional information.
 */
@Schema(description = "Shipping Options represent a way in which an Order or Return can be shipped. Shipping Options have an associated Fulfillment Provider that will be used when the fulfillment of an Order is initiated. Shipping Options themselves cannot be added to Carts, but serve as a template for Shipping Methods. This distinction makes it possible to customize individual Shipping Methods with additional information.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class ShippingOption {
  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("region_id")
  private String regionId = null;

  @SerializedName("region")
  private Object region = null;

  @SerializedName("profile_id")
  private String profileId = null;

  @SerializedName("profile")
  private ShippingProfile profile = null;

  @SerializedName("provider_id")
  private String providerId = null;

  @SerializedName("provider")
  private FulfillmentProvider provider = null;

  /**
   * The type of pricing calculation that is used when creatin Shipping Methods from the Shipping Option. Can be &#x60;flat_rate&#x60; for fixed prices or &#x60;calculated&#x60; if the Fulfillment Provider can provide price calulations.
   */
  @JsonAdapter(PriceTypeEnum.Adapter.class)
  public enum PriceTypeEnum {
    FLAT_RATE("flat_rate"),
    CALCULATED("calculated");

    private String value;

    PriceTypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static PriceTypeEnum fromValue(String input) {
      for (PriceTypeEnum b : PriceTypeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<PriceTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PriceTypeEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public PriceTypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return PriceTypeEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("price_type")
  private PriceTypeEnum priceType = null;

  @SerializedName("amount")
  private Integer amount = null;

  @SerializedName("is_return")
  private Boolean isReturn = false;

  @SerializedName("admin_only")
  private Boolean adminOnly = false;

  @SerializedName("requirements")
  private List<ShippingOptionRequirement> requirements = null;

  @SerializedName("data")
  private Object data = null;

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

  public ShippingOption id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The shipping option&#x27;s ID
   * @return id
  **/
  @Schema(example = "so_01G1G5V27GYX4QXNARRQCW1N8T", required = true, description = "The shipping option's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ShippingOption name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name given to the Shipping Option - this may be displayed to the Customer.
   * @return name
  **/
  @Schema(example = "PostFake Standard", required = true, description = "The name given to the Shipping Option - this may be displayed to the Customer.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ShippingOption regionId(String regionId) {
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

  public ShippingOption region(Object region) {
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

  public ShippingOption profileId(String profileId) {
    this.profileId = profileId;
    return this;
  }

   /**
   * The ID of the Shipping Profile that the shipping option belongs to. Shipping Profiles have a set of defined Shipping Options that can be used to Fulfill a given set of Products.
   * @return profileId
  **/
  @Schema(example = "sp_01G1G5V239ENSZ5MV4JAR737BM", required = true, description = "The ID of the Shipping Profile that the shipping option belongs to. Shipping Profiles have a set of defined Shipping Options that can be used to Fulfill a given set of Products.")
  public String getProfileId() {
    return profileId;
  }

  public void setProfileId(String profileId) {
    this.profileId = profileId;
  }

  public ShippingOption profile(ShippingProfile profile) {
    this.profile = profile;
    return this;
  }

   /**
   * Get profile
   * @return profile
  **/
  @Schema(description = "")
  public ShippingProfile getProfile() {
    return profile;
  }

  public void setProfile(ShippingProfile profile) {
    this.profile = profile;
  }

  public ShippingOption providerId(String providerId) {
    this.providerId = providerId;
    return this;
  }

   /**
   * The id of the Fulfillment Provider, that will be used to process Fulfillments from the Shipping Option.
   * @return providerId
  **/
  @Schema(example = "manual", required = true, description = "The id of the Fulfillment Provider, that will be used to process Fulfillments from the Shipping Option.")
  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public ShippingOption provider(FulfillmentProvider provider) {
    this.provider = provider;
    return this;
  }

   /**
   * Get provider
   * @return provider
  **/
  @Schema(description = "")
  public FulfillmentProvider getProvider() {
    return provider;
  }

  public void setProvider(FulfillmentProvider provider) {
    this.provider = provider;
  }

  public ShippingOption priceType(PriceTypeEnum priceType) {
    this.priceType = priceType;
    return this;
  }

   /**
   * The type of pricing calculation that is used when creatin Shipping Methods from the Shipping Option. Can be &#x60;flat_rate&#x60; for fixed prices or &#x60;calculated&#x60; if the Fulfillment Provider can provide price calulations.
   * @return priceType
  **/
  @Schema(example = "flat_rate", required = true, description = "The type of pricing calculation that is used when creatin Shipping Methods from the Shipping Option. Can be `flat_rate` for fixed prices or `calculated` if the Fulfillment Provider can provide price calulations.")
  public PriceTypeEnum getPriceType() {
    return priceType;
  }

  public void setPriceType(PriceTypeEnum priceType) {
    this.priceType = priceType;
  }

  public ShippingOption amount(Integer amount) {
    this.amount = amount;
    return this;
  }

   /**
   * The amount to charge for shipping when the Shipping Option price type is &#x60;flat_rate&#x60;.
   * @return amount
  **/
  @Schema(example = "200", required = true, description = "The amount to charge for shipping when the Shipping Option price type is `flat_rate`.")
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public ShippingOption isReturn(Boolean isReturn) {
    this.isReturn = isReturn;
    return this;
  }

   /**
   * Flag to indicate if the Shipping Option can be used for Return shipments.
   * @return isReturn
  **/
  @Schema(required = true, description = "Flag to indicate if the Shipping Option can be used for Return shipments.")
  public Boolean isIsReturn() {
    return isReturn;
  }

  public void setIsReturn(Boolean isReturn) {
    this.isReturn = isReturn;
  }

  public ShippingOption adminOnly(Boolean adminOnly) {
    this.adminOnly = adminOnly;
    return this;
  }

   /**
   * Flag to indicate if the Shipping Option usage is restricted to admin users.
   * @return adminOnly
  **/
  @Schema(required = true, description = "Flag to indicate if the Shipping Option usage is restricted to admin users.")
  public Boolean isAdminOnly() {
    return adminOnly;
  }

  public void setAdminOnly(Boolean adminOnly) {
    this.adminOnly = adminOnly;
  }

  public ShippingOption requirements(List<ShippingOptionRequirement> requirements) {
    this.requirements = requirements;
    return this;
  }

  public ShippingOption addRequirementsItem(ShippingOptionRequirement requirementsItem) {
    if (this.requirements == null) {
      this.requirements = new ArrayList<ShippingOptionRequirement>();
    }
    this.requirements.add(requirementsItem);
    return this;
  }

   /**
   * The requirements that must be satisfied for the Shipping Option to be available for a Cart. Available if the relation &#x60;requirements&#x60; is expanded.
   * @return requirements
  **/
  @Schema(description = "The requirements that must be satisfied for the Shipping Option to be available for a Cart. Available if the relation `requirements` is expanded.")
  public List<ShippingOptionRequirement> getRequirements() {
    return requirements;
  }

  public void setRequirements(List<ShippingOptionRequirement> requirements) {
    this.requirements = requirements;
  }

  public ShippingOption data(Object data) {
    this.data = data;
    return this;
  }

   /**
   * The data needed for the Fulfillment Provider to identify the Shipping Option.
   * @return data
  **/
  @Schema(example = "{}", required = true, description = "The data needed for the Fulfillment Provider to identify the Shipping Option.")
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public ShippingOption includesTax(Boolean includesTax) {
    this.includesTax = includesTax;
    return this;
  }

   /**
   * [EXPERIMENTAL] Does the shipping option price include tax
   * @return includesTax
  **/
  @Schema(description = "[EXPERIMENTAL] Does the shipping option price include tax")
  public Boolean isIncludesTax() {
    return includesTax;
  }

  public void setIncludesTax(Boolean includesTax) {
    this.includesTax = includesTax;
  }

  public ShippingOption createdAt(OffsetDateTime createdAt) {
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

  public ShippingOption updatedAt(OffsetDateTime updatedAt) {
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

  public ShippingOption deletedAt(OffsetDateTime deletedAt) {
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

  public ShippingOption metadata(Object metadata) {
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
    ShippingOption shippingOption = (ShippingOption) o;
    return Objects.equals(this.id, shippingOption.id) &&
        Objects.equals(this.name, shippingOption.name) &&
        Objects.equals(this.regionId, shippingOption.regionId) &&
        Objects.equals(this.region, shippingOption.region) &&
        Objects.equals(this.profileId, shippingOption.profileId) &&
        Objects.equals(this.profile, shippingOption.profile) &&
        Objects.equals(this.providerId, shippingOption.providerId) &&
        Objects.equals(this.provider, shippingOption.provider) &&
        Objects.equals(this.priceType, shippingOption.priceType) &&
        Objects.equals(this.amount, shippingOption.amount) &&
        Objects.equals(this.isReturn, shippingOption.isReturn) &&
        Objects.equals(this.adminOnly, shippingOption.adminOnly) &&
        Objects.equals(this.requirements, shippingOption.requirements) &&
        Objects.equals(this.data, shippingOption.data) &&
        Objects.equals(this.includesTax, shippingOption.includesTax) &&
        Objects.equals(this.createdAt, shippingOption.createdAt) &&
        Objects.equals(this.updatedAt, shippingOption.updatedAt) &&
        Objects.equals(this.deletedAt, shippingOption.deletedAt) &&
        Objects.equals(this.metadata, shippingOption.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, regionId, region, profileId, profile, providerId, provider, priceType, amount, isReturn, adminOnly, requirements, data, includesTax, createdAt, updatedAt, deletedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShippingOption {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    isReturn: ").append(toIndentedString(isReturn)).append("\n");
    sb.append("    adminOnly: ").append(toIndentedString(adminOnly)).append("\n");
    sb.append("    requirements: ").append(toIndentedString(requirements)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
