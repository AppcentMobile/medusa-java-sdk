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
 * Product Variants represent a Product with a specific set of Product Option configurations. The maximum number of Product Variants that a Product can have is given by the number of available Product Option combinations.
 */
@Schema(description = "Product Variants represent a Product with a specific set of Product Option configurations. The maximum number of Product Variants that a Product can have is given by the number of available Product Option combinations.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class ProductVariant {
  @SerializedName("id")
  private String id = null;

  @SerializedName("title")
  private String title = null;

  @SerializedName("product_id")
  private String productId = null;

  @SerializedName("product")
  private Object product = null;

  @SerializedName("prices")
  private List<MoneyAmount> prices = null;

  @SerializedName("sku")
  private String sku = null;

  @SerializedName("barcode")
  private String barcode = null;

  @SerializedName("ean")
  private String ean = null;

  @SerializedName("upc")
  private String upc = null;

  @SerializedName("variant_rank")
  private BigDecimal variantRank = new BigDecimal(0);

  @SerializedName("inventory_quantity")
  private Integer inventoryQuantity = null;

  @SerializedName("allow_backorder")
  private Boolean allowBackorder = false;

  @SerializedName("manage_inventory")
  private Boolean manageInventory = true;

  @SerializedName("hs_code")
  private String hsCode = null;

  @SerializedName("origin_country")
  private String originCountry = null;

  @SerializedName("mid_code")
  private String midCode = null;

  @SerializedName("material")
  private String material = null;

  @SerializedName("weight")
  private BigDecimal weight = null;

  @SerializedName("length")
  private BigDecimal length = null;

  @SerializedName("height")
  private BigDecimal height = null;

  @SerializedName("width")
  private BigDecimal width = null;

  @SerializedName("options")
  private List<ProductOptionValue> options = null;

  @SerializedName("inventory_items")
  private List<ProductVariantInventoryItem> inventoryItems = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public ProductVariant id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The product variant&#x27;s ID
   * @return id
  **/
  @Schema(example = "variant_01G1G5V2MRX2V3PVSR2WXYPFB6", required = true, description = "The product variant's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductVariant title(String title) {
    this.title = title;
    return this;
  }

   /**
   * A title that can be displayed for easy identification of the Product Variant.
   * @return title
  **/
  @Schema(example = "Small", required = true, description = "A title that can be displayed for easy identification of the Product Variant.")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ProductVariant productId(String productId) {
    this.productId = productId;
    return this;
  }

   /**
   * The ID of the Product that the Product Variant belongs to.
   * @return productId
  **/
  @Schema(example = "prod_01G1G5V2MBA328390B5AXJ610F", required = true, description = "The ID of the Product that the Product Variant belongs to.")
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public ProductVariant product(Object product) {
    this.product = product;
    return this;
  }

   /**
   * A product object. Available if the relation &#x60;product&#x60; is expanded.
   * @return product
  **/
  @Schema(description = "A product object. Available if the relation `product` is expanded.")
  public Object getProduct() {
    return product;
  }

  public void setProduct(Object product) {
    this.product = product;
  }

  public ProductVariant prices(List<MoneyAmount> prices) {
    this.prices = prices;
    return this;
  }

  public ProductVariant addPricesItem(MoneyAmount pricesItem) {
    if (this.prices == null) {
      this.prices = new ArrayList<MoneyAmount>();
    }
    this.prices.add(pricesItem);
    return this;
  }

   /**
   * The Money Amounts defined for the Product Variant. Each Money Amount represents a price in a given currency or a price in a specific Region. Available if the relation &#x60;prices&#x60; is expanded.
   * @return prices
  **/
  @Schema(description = "The Money Amounts defined for the Product Variant. Each Money Amount represents a price in a given currency or a price in a specific Region. Available if the relation `prices` is expanded.")
  public List<MoneyAmount> getPrices() {
    return prices;
  }

  public void setPrices(List<MoneyAmount> prices) {
    this.prices = prices;
  }

  public ProductVariant sku(String sku) {
    this.sku = sku;
    return this;
  }

   /**
   * The unique stock keeping unit used to identify the Product Variant. This will usually be a unqiue identifer for the item that is to be shipped, and can be referenced across multiple systems.
   * @return sku
  **/
  @Schema(example = "shirt-123", required = true, description = "The unique stock keeping unit used to identify the Product Variant. This will usually be a unqiue identifer for the item that is to be shipped, and can be referenced across multiple systems.")
  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public ProductVariant barcode(String barcode) {
    this.barcode = barcode;
    return this;
  }

   /**
   * A generic field for a GTIN number that can be used to identify the Product Variant.
   * @return barcode
  **/
  @Schema(required = true, description = "A generic field for a GTIN number that can be used to identify the Product Variant.")
  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public ProductVariant ean(String ean) {
    this.ean = ean;
    return this;
  }

   /**
   * An EAN barcode number that can be used to identify the Product Variant.
   * @return ean
  **/
  @Schema(required = true, description = "An EAN barcode number that can be used to identify the Product Variant.")
  public String getEan() {
    return ean;
  }

  public void setEan(String ean) {
    this.ean = ean;
  }

  public ProductVariant upc(String upc) {
    this.upc = upc;
    return this;
  }

   /**
   * A UPC barcode number that can be used to identify the Product Variant.
   * @return upc
  **/
  @Schema(required = true, description = "A UPC barcode number that can be used to identify the Product Variant.")
  public String getUpc() {
    return upc;
  }

  public void setUpc(String upc) {
    this.upc = upc;
  }

  public ProductVariant variantRank(BigDecimal variantRank) {
    this.variantRank = variantRank;
    return this;
  }

   /**
   * The ranking of this variant
   * @return variantRank
  **/
  @Schema(description = "The ranking of this variant")
  public BigDecimal getVariantRank() {
    return variantRank;
  }

  public void setVariantRank(BigDecimal variantRank) {
    this.variantRank = variantRank;
  }

  public ProductVariant inventoryQuantity(Integer inventoryQuantity) {
    this.inventoryQuantity = inventoryQuantity;
    return this;
  }

   /**
   * The current quantity of the item that is stocked.
   * @return inventoryQuantity
  **/
  @Schema(example = "100", required = true, description = "The current quantity of the item that is stocked.")
  public Integer getInventoryQuantity() {
    return inventoryQuantity;
  }

  public void setInventoryQuantity(Integer inventoryQuantity) {
    this.inventoryQuantity = inventoryQuantity;
  }

  public ProductVariant allowBackorder(Boolean allowBackorder) {
    this.allowBackorder = allowBackorder;
    return this;
  }

   /**
   * Whether the Product Variant should be purchasable when &#x60;inventory_quantity&#x60; is 0.
   * @return allowBackorder
  **/
  @Schema(required = true, description = "Whether the Product Variant should be purchasable when `inventory_quantity` is 0.")
  public Boolean isAllowBackorder() {
    return allowBackorder;
  }

  public void setAllowBackorder(Boolean allowBackorder) {
    this.allowBackorder = allowBackorder;
  }

  public ProductVariant manageInventory(Boolean manageInventory) {
    this.manageInventory = manageInventory;
    return this;
  }

   /**
   * Whether Medusa should manage inventory for the Product Variant.
   * @return manageInventory
  **/
  @Schema(required = true, description = "Whether Medusa should manage inventory for the Product Variant.")
  public Boolean isManageInventory() {
    return manageInventory;
  }

  public void setManageInventory(Boolean manageInventory) {
    this.manageInventory = manageInventory;
  }

  public ProductVariant hsCode(String hsCode) {
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

  public ProductVariant originCountry(String originCountry) {
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

  public ProductVariant midCode(String midCode) {
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

  public ProductVariant material(String material) {
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

  public ProductVariant weight(BigDecimal weight) {
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

  public ProductVariant length(BigDecimal length) {
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

  public ProductVariant height(BigDecimal height) {
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

  public ProductVariant width(BigDecimal width) {
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

  public ProductVariant options(List<ProductOptionValue> options) {
    this.options = options;
    return this;
  }

  public ProductVariant addOptionsItem(ProductOptionValue optionsItem) {
    if (this.options == null) {
      this.options = new ArrayList<ProductOptionValue>();
    }
    this.options.add(optionsItem);
    return this;
  }

   /**
   * The Product Option Values specified for the Product Variant. Available if the relation &#x60;options&#x60; is expanded.
   * @return options
  **/
  @Schema(description = "The Product Option Values specified for the Product Variant. Available if the relation `options` is expanded.")
  public List<ProductOptionValue> getOptions() {
    return options;
  }

  public void setOptions(List<ProductOptionValue> options) {
    this.options = options;
  }

  public ProductVariant inventoryItems(List<ProductVariantInventoryItem> inventoryItems) {
    this.inventoryItems = inventoryItems;
    return this;
  }

  public ProductVariant addInventoryItemsItem(ProductVariantInventoryItem inventoryItemsItem) {
    if (this.inventoryItems == null) {
      this.inventoryItems = new ArrayList<ProductVariantInventoryItem>();
    }
    this.inventoryItems.add(inventoryItemsItem);
    return this;
  }

   /**
   * The Inventory Items related to the product variant. Available if the relation &#x60;inventory_items&#x60; is expanded.
   * @return inventoryItems
  **/
  @Schema(description = "The Inventory Items related to the product variant. Available if the relation `inventory_items` is expanded.")
  public List<ProductVariantInventoryItem> getInventoryItems() {
    return inventoryItems;
  }

  public void setInventoryItems(List<ProductVariantInventoryItem> inventoryItems) {
    this.inventoryItems = inventoryItems;
  }

  public ProductVariant createdAt(OffsetDateTime createdAt) {
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

  public ProductVariant updatedAt(OffsetDateTime updatedAt) {
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

  public ProductVariant deletedAt(OffsetDateTime deletedAt) {
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

  public ProductVariant metadata(Object metadata) {
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
    ProductVariant productVariant = (ProductVariant) o;
    return Objects.equals(this.id, productVariant.id) &&
        Objects.equals(this.title, productVariant.title) &&
        Objects.equals(this.productId, productVariant.productId) &&
        Objects.equals(this.product, productVariant.product) &&
        Objects.equals(this.prices, productVariant.prices) &&
        Objects.equals(this.sku, productVariant.sku) &&
        Objects.equals(this.barcode, productVariant.barcode) &&
        Objects.equals(this.ean, productVariant.ean) &&
        Objects.equals(this.upc, productVariant.upc) &&
        Objects.equals(this.variantRank, productVariant.variantRank) &&
        Objects.equals(this.inventoryQuantity, productVariant.inventoryQuantity) &&
        Objects.equals(this.allowBackorder, productVariant.allowBackorder) &&
        Objects.equals(this.manageInventory, productVariant.manageInventory) &&
        Objects.equals(this.hsCode, productVariant.hsCode) &&
        Objects.equals(this.originCountry, productVariant.originCountry) &&
        Objects.equals(this.midCode, productVariant.midCode) &&
        Objects.equals(this.material, productVariant.material) &&
        Objects.equals(this.weight, productVariant.weight) &&
        Objects.equals(this.length, productVariant.length) &&
        Objects.equals(this.height, productVariant.height) &&
        Objects.equals(this.width, productVariant.width) &&
        Objects.equals(this.options, productVariant.options) &&
        Objects.equals(this.inventoryItems, productVariant.inventoryItems) &&
        Objects.equals(this.createdAt, productVariant.createdAt) &&
        Objects.equals(this.updatedAt, productVariant.updatedAt) &&
        Objects.equals(this.deletedAt, productVariant.deletedAt) &&
        Objects.equals(this.metadata, productVariant.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, productId, product, prices, sku, barcode, ean, upc, variantRank, inventoryQuantity, allowBackorder, manageInventory, hsCode, originCountry, midCode, material, weight, length, height, width, options, inventoryItems, createdAt, updatedAt, deletedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductVariant {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    prices: ").append(toIndentedString(prices)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    barcode: ").append(toIndentedString(barcode)).append("\n");
    sb.append("    ean: ").append(toIndentedString(ean)).append("\n");
    sb.append("    upc: ").append(toIndentedString(upc)).append("\n");
    sb.append("    variantRank: ").append(toIndentedString(variantRank)).append("\n");
    sb.append("    inventoryQuantity: ").append(toIndentedString(inventoryQuantity)).append("\n");
    sb.append("    allowBackorder: ").append(toIndentedString(allowBackorder)).append("\n");
    sb.append("    manageInventory: ").append(toIndentedString(manageInventory)).append("\n");
    sb.append("    hsCode: ").append(toIndentedString(hsCode)).append("\n");
    sb.append("    originCountry: ").append(toIndentedString(originCountry)).append("\n");
    sb.append("    midCode: ").append(toIndentedString(midCode)).append("\n");
    sb.append("    material: ").append(toIndentedString(material)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    inventoryItems: ").append(toIndentedString(inventoryItems)).append("\n");
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
