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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * Products are a grouping of Product Variants that have common properties such as images and descriptions. Products can have multiple options which define the properties that Product Variants differ by.
 */
@Schema(description = "Products are a grouping of Product Variants that have common properties such as images and descriptions. Products can have multiple options which define the properties that Product Variants differ by.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class Product {
  @SerializedName("id")
  private String id = null;

  @SerializedName("title")
  private String title = null;

  @SerializedName("subtitle")
  private String subtitle = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("handle")
  private String handle = null;

  @SerializedName("is_giftcard")
  private Boolean isGiftcard = false;

  /**
   * The status of the product
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    DRAFT("draft"),
    PROPOSED("proposed"),
    PUBLISHED("published"),
    REJECTED("rejected");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static StatusEnum fromValue(String input) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return StatusEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("status")
  private StatusEnum status = StatusEnum.DRAFT;

  @SerializedName("images")
  private List<Image> images = null;

  @SerializedName("thumbnail")
  private String thumbnail = null;

  @SerializedName("options")
  private List<ProductOption> options = null;

  @SerializedName("variants")
  private List<ProductVariant> variants = null;

  @SerializedName("categories")
  private List<ProductCategory> categories = null;

  @SerializedName("profile_id")
  private String profileId = null;

  @SerializedName("profile")
  private ShippingProfile profile = null;

  @SerializedName("weight")
  private BigDecimal weight = null;

  @SerializedName("length")
  private BigDecimal length = null;

  @SerializedName("height")
  private BigDecimal height = null;

  @SerializedName("width")
  private BigDecimal width = null;

  @SerializedName("hs_code")
  private String hsCode = null;

  @SerializedName("origin_country")
  private String originCountry = null;

  @SerializedName("mid_code")
  private String midCode = null;

  @SerializedName("material")
  private String material = null;

  @SerializedName("collection_id")
  private String collectionId = null;

  @SerializedName("collection")
  private ProductCollection collection = null;

  @SerializedName("type_id")
  private String typeId = null;

  @SerializedName("type")
  private ProductType type = null;

  @SerializedName("tags")
  private List<ProductTag> tags = null;

  @SerializedName("discountable")
  private Boolean discountable = true;

  @SerializedName("external_id")
  private String externalId = null;

  @SerializedName("sales_channels")
  private List<SalesChannel> salesChannels = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public Product id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The product&#x27;s ID
   * @return id
  **/
  @Schema(example = "prod_01G1G5V2MBA328390B5AXJ610F", required = true, description = "The product's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Product title(String title) {
    this.title = title;
    return this;
  }

   /**
   * A title that can be displayed for easy identification of the Product.
   * @return title
  **/
  @Schema(example = "Medusa Coffee Mug", required = true, description = "A title that can be displayed for easy identification of the Product.")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Product subtitle(String subtitle) {
    this.subtitle = subtitle;
    return this;
  }

   /**
   * An optional subtitle that can be used to further specify the Product.
   * @return subtitle
  **/
  @Schema(required = true, description = "An optional subtitle that can be used to further specify the Product.")
  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public Product description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A short description of the Product.
   * @return description
  **/
  @Schema(example = "Every programmer's best friend.", required = true, description = "A short description of the Product.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Product handle(String handle) {
    this.handle = handle;
    return this;
  }

   /**
   * A unique identifier for the Product (e.g. for slug structure).
   * @return handle
  **/
  @Schema(example = "coffee-mug", required = true, description = "A unique identifier for the Product (e.g. for slug structure).")
  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public Product isGiftcard(Boolean isGiftcard) {
    this.isGiftcard = isGiftcard;
    return this;
  }

   /**
   * Whether the Product represents a Gift Card. Products that represent Gift Cards will automatically generate a redeemable Gift Card code once they are purchased.
   * @return isGiftcard
  **/
  @Schema(required = true, description = "Whether the Product represents a Gift Card. Products that represent Gift Cards will automatically generate a redeemable Gift Card code once they are purchased.")
  public Boolean isIsGiftcard() {
    return isGiftcard;
  }

  public void setIsGiftcard(Boolean isGiftcard) {
    this.isGiftcard = isGiftcard;
  }

  public Product status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * The status of the product
   * @return status
  **/
  @Schema(required = true, description = "The status of the product")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Product images(List<Image> images) {
    this.images = images;
    return this;
  }

  public Product addImagesItem(Image imagesItem) {
    if (this.images == null) {
      this.images = new ArrayList<Image>();
    }
    this.images.add(imagesItem);
    return this;
  }

   /**
   * Images of the Product. Available if the relation &#x60;images&#x60; is expanded.
   * @return images
  **/
  @Schema(description = "Images of the Product. Available if the relation `images` is expanded.")
  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }

  public Product thumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
    return this;
  }

   /**
   * A URL to an image file that can be used to identify the Product.
   * @return thumbnail
  **/
  @Schema(required = true, description = "A URL to an image file that can be used to identify the Product.")
  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public Product options(List<ProductOption> options) {
    this.options = options;
    return this;
  }

  public Product addOptionsItem(ProductOption optionsItem) {
    if (this.options == null) {
      this.options = new ArrayList<ProductOption>();
    }
    this.options.add(optionsItem);
    return this;
  }

   /**
   * The Product Options that are defined for the Product. Product Variants of the Product will have a unique combination of Product Option Values. Available if the relation &#x60;options&#x60; is expanded.
   * @return options
  **/
  @Schema(description = "The Product Options that are defined for the Product. Product Variants of the Product will have a unique combination of Product Option Values. Available if the relation `options` is expanded.")
  public List<ProductOption> getOptions() {
    return options;
  }

  public void setOptions(List<ProductOption> options) {
    this.options = options;
  }

  public Product variants(List<ProductVariant> variants) {
    this.variants = variants;
    return this;
  }

  public Product addVariantsItem(ProductVariant variantsItem) {
    if (this.variants == null) {
      this.variants = new ArrayList<ProductVariant>();
    }
    this.variants.add(variantsItem);
    return this;
  }

   /**
   * The Product Variants that belong to the Product. Each will have a unique combination of Product Option Values. Available if the relation &#x60;variants&#x60; is expanded.
   * @return variants
  **/
  @Schema(description = "The Product Variants that belong to the Product. Each will have a unique combination of Product Option Values. Available if the relation `variants` is expanded.")
  public List<ProductVariant> getVariants() {
    return variants;
  }

  public void setVariants(List<ProductVariant> variants) {
    this.variants = variants;
  }

  public Product categories(List<ProductCategory> categories) {
    this.categories = categories;
    return this;
  }

  public Product addCategoriesItem(ProductCategory categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<ProductCategory>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

   /**
   * The product&#x27;s associated categories. Available if the relation &#x60;categories&#x60; are expanded.
   * @return categories
  **/
  @Schema(description = "The product's associated categories. Available if the relation `categories` are expanded.")
  public List<ProductCategory> getCategories() {
    return categories;
  }

  public void setCategories(List<ProductCategory> categories) {
    this.categories = categories;
  }

  public Product profileId(String profileId) {
    this.profileId = profileId;
    return this;
  }

   /**
   * The ID of the Shipping Profile that the Product belongs to. Shipping Profiles have a set of defined Shipping Options that can be used to Fulfill a given set of Products.
   * @return profileId
  **/
  @Schema(example = "sp_01G1G5V239ENSZ5MV4JAR737BM", required = true, description = "The ID of the Shipping Profile that the Product belongs to. Shipping Profiles have a set of defined Shipping Options that can be used to Fulfill a given set of Products.")
  public String getProfileId() {
    return profileId;
  }

  public void setProfileId(String profileId) {
    this.profileId = profileId;
  }

  public Product profile(ShippingProfile profile) {
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

  public Product weight(BigDecimal weight) {
    this.weight = weight;
    return this;
  }

   /**
   * The weight of the Product Variant. May be used in shipping rate calculations.
   * @return weight
  **/
  @Schema(required = true, description = "The weight of the Product Variant. May be used in shipping rate calculations.")
  public BigDecimal getWeight() {
    return weight;
  }

  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }

  public Product length(BigDecimal length) {
    this.length = length;
    return this;
  }

   /**
   * The length of the Product Variant. May be used in shipping rate calculations.
   * @return length
  **/
  @Schema(required = true, description = "The length of the Product Variant. May be used in shipping rate calculations.")
  public BigDecimal getLength() {
    return length;
  }

  public void setLength(BigDecimal length) {
    this.length = length;
  }

  public Product height(BigDecimal height) {
    this.height = height;
    return this;
  }

   /**
   * The height of the Product Variant. May be used in shipping rate calculations.
   * @return height
  **/
  @Schema(required = true, description = "The height of the Product Variant. May be used in shipping rate calculations.")
  public BigDecimal getHeight() {
    return height;
  }

  public void setHeight(BigDecimal height) {
    this.height = height;
  }

  public Product width(BigDecimal width) {
    this.width = width;
    return this;
  }

   /**
   * The width of the Product Variant. May be used in shipping rate calculations.
   * @return width
  **/
  @Schema(required = true, description = "The width of the Product Variant. May be used in shipping rate calculations.")
  public BigDecimal getWidth() {
    return width;
  }

  public void setWidth(BigDecimal width) {
    this.width = width;
  }

  public Product hsCode(String hsCode) {
    this.hsCode = hsCode;
    return this;
  }

   /**
   * The Harmonized System code of the Product Variant. May be used by Fulfillment Providers to pass customs information to shipping carriers.
   * @return hsCode
  **/
  @Schema(required = true, description = "The Harmonized System code of the Product Variant. May be used by Fulfillment Providers to pass customs information to shipping carriers.")
  public String getHsCode() {
    return hsCode;
  }

  public void setHsCode(String hsCode) {
    this.hsCode = hsCode;
  }

  public Product originCountry(String originCountry) {
    this.originCountry = originCountry;
    return this;
  }

   /**
   * The country in which the Product Variant was produced. May be used by Fulfillment Providers to pass customs information to shipping carriers.
   * @return originCountry
  **/
  @Schema(required = true, description = "The country in which the Product Variant was produced. May be used by Fulfillment Providers to pass customs information to shipping carriers.")
  public String getOriginCountry() {
    return originCountry;
  }

  public void setOriginCountry(String originCountry) {
    this.originCountry = originCountry;
  }

  public Product midCode(String midCode) {
    this.midCode = midCode;
    return this;
  }

   /**
   * The Manufacturers Identification code that identifies the manufacturer of the Product Variant. May be used by Fulfillment Providers to pass customs information to shipping carriers.
   * @return midCode
  **/
  @Schema(required = true, description = "The Manufacturers Identification code that identifies the manufacturer of the Product Variant. May be used by Fulfillment Providers to pass customs information to shipping carriers.")
  public String getMidCode() {
    return midCode;
  }

  public void setMidCode(String midCode) {
    this.midCode = midCode;
  }

  public Product material(String material) {
    this.material = material;
    return this;
  }

   /**
   * The material and composition that the Product Variant is made of, May be used by Fulfillment Providers to pass customs information to shipping carriers.
   * @return material
  **/
  @Schema(required = true, description = "The material and composition that the Product Variant is made of, May be used by Fulfillment Providers to pass customs information to shipping carriers.")
  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public Product collectionId(String collectionId) {
    this.collectionId = collectionId;
    return this;
  }

   /**
   * The Product Collection that the Product belongs to
   * @return collectionId
  **/
  @Schema(example = "pcol_01F0YESBFAZ0DV6V831JXWH0BG", required = true, description = "The Product Collection that the Product belongs to")
  public String getCollectionId() {
    return collectionId;
  }

  public void setCollectionId(String collectionId) {
    this.collectionId = collectionId;
  }

  public Product collection(ProductCollection collection) {
    this.collection = collection;
    return this;
  }

   /**
   * Get collection
   * @return collection
  **/
  @Schema(description = "")
  public ProductCollection getCollection() {
    return collection;
  }

  public void setCollection(ProductCollection collection) {
    this.collection = collection;
  }

  public Product typeId(String typeId) {
    this.typeId = typeId;
    return this;
  }

   /**
   * The Product type that the Product belongs to
   * @return typeId
  **/
  @Schema(example = "ptyp_01G8X9A7ESKAJXG2H0E6F1MW7A", required = true, description = "The Product type that the Product belongs to")
  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  public Product type(ProductType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @Schema(description = "")
  public ProductType getType() {
    return type;
  }

  public void setType(ProductType type) {
    this.type = type;
  }

  public Product tags(List<ProductTag> tags) {
    this.tags = tags;
    return this;
  }

  public Product addTagsItem(ProductTag tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<ProductTag>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * The Product Tags assigned to the Product. Available if the relation &#x60;tags&#x60; is expanded.
   * @return tags
  **/
  @Schema(description = "The Product Tags assigned to the Product. Available if the relation `tags` is expanded.")
  public List<ProductTag> getTags() {
    return tags;
  }

  public void setTags(List<ProductTag> tags) {
    this.tags = tags;
  }

  public Product discountable(Boolean discountable) {
    this.discountable = discountable;
    return this;
  }

   /**
   * Whether the Product can be discounted. Discounts will not apply to Line Items of this Product when this flag is set to &#x60;false&#x60;.
   * @return discountable
  **/
  @Schema(required = true, description = "Whether the Product can be discounted. Discounts will not apply to Line Items of this Product when this flag is set to `false`.")
  public Boolean isDiscountable() {
    return discountable;
  }

  public void setDiscountable(Boolean discountable) {
    this.discountable = discountable;
  }

  public Product externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

   /**
   * The external ID of the product
   * @return externalId
  **/
  @Schema(required = true, description = "The external ID of the product")
  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public Product salesChannels(List<SalesChannel> salesChannels) {
    this.salesChannels = salesChannels;
    return this;
  }

  public Product addSalesChannelsItem(SalesChannel salesChannelsItem) {
    if (this.salesChannels == null) {
      this.salesChannels = new ArrayList<SalesChannel>();
    }
    this.salesChannels.add(salesChannelsItem);
    return this;
  }

   /**
   * The sales channels the product is associated with. Available if the relation &#x60;sales_channels&#x60; is expanded.
   * @return salesChannels
  **/
  @Schema(description = "The sales channels the product is associated with. Available if the relation `sales_channels` is expanded.")
  public List<SalesChannel> getSalesChannels() {
    return salesChannels;
  }

  public void setSalesChannels(List<SalesChannel> salesChannels) {
    this.salesChannels = salesChannels;
  }

  public Product createdAt(OffsetDateTime createdAt) {
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

  public Product updatedAt(OffsetDateTime updatedAt) {
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

  public Product deletedAt(OffsetDateTime deletedAt) {
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

  public Product metadata(Object metadata) {
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
    Product product = (Product) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.title, product.title) &&
        Objects.equals(this.subtitle, product.subtitle) &&
        Objects.equals(this.description, product.description) &&
        Objects.equals(this.handle, product.handle) &&
        Objects.equals(this.isGiftcard, product.isGiftcard) &&
        Objects.equals(this.status, product.status) &&
        Objects.equals(this.images, product.images) &&
        Objects.equals(this.thumbnail, product.thumbnail) &&
        Objects.equals(this.options, product.options) &&
        Objects.equals(this.variants, product.variants) &&
        Objects.equals(this.categories, product.categories) &&
        Objects.equals(this.profileId, product.profileId) &&
        Objects.equals(this.profile, product.profile) &&
        Objects.equals(this.weight, product.weight) &&
        Objects.equals(this.length, product.length) &&
        Objects.equals(this.height, product.height) &&
        Objects.equals(this.width, product.width) &&
        Objects.equals(this.hsCode, product.hsCode) &&
        Objects.equals(this.originCountry, product.originCountry) &&
        Objects.equals(this.midCode, product.midCode) &&
        Objects.equals(this.material, product.material) &&
        Objects.equals(this.collectionId, product.collectionId) &&
        Objects.equals(this.collection, product.collection) &&
        Objects.equals(this.typeId, product.typeId) &&
        Objects.equals(this.type, product.type) &&
        Objects.equals(this.tags, product.tags) &&
        Objects.equals(this.discountable, product.discountable) &&
        Objects.equals(this.externalId, product.externalId) &&
        Objects.equals(this.salesChannels, product.salesChannels) &&
        Objects.equals(this.createdAt, product.createdAt) &&
        Objects.equals(this.updatedAt, product.updatedAt) &&
        Objects.equals(this.deletedAt, product.deletedAt) &&
        Objects.equals(this.metadata, product.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, subtitle, description, handle, isGiftcard, status, images, thumbnail, options, variants, categories, profileId, profile, weight, length, height, width, hsCode, originCountry, midCode, material, collectionId, collection, typeId, type, tags, discountable, externalId, salesChannels, createdAt, updatedAt, deletedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    subtitle: ").append(toIndentedString(subtitle)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    handle: ").append(toIndentedString(handle)).append("\n");
    sb.append("    isGiftcard: ").append(toIndentedString(isGiftcard)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
    sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    variants: ").append(toIndentedString(variants)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    hsCode: ").append(toIndentedString(hsCode)).append("\n");
    sb.append("    originCountry: ").append(toIndentedString(originCountry)).append("\n");
    sb.append("    midCode: ").append(toIndentedString(midCode)).append("\n");
    sb.append("    material: ").append(toIndentedString(material)).append("\n");
    sb.append("    collectionId: ").append(toIndentedString(collectionId)).append("\n");
    sb.append("    collection: ").append(toIndentedString(collection)).append("\n");
    sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    discountable: ").append(toIndentedString(discountable)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    salesChannels: ").append(toIndentedString(salesChannels)).append("\n");
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
