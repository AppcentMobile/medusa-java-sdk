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

import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * Represents a product category
 */
@Schema(description = "Represents a product category")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class ProductCategory {
  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("handle")
  private String handle = null;

  @SerializedName("mpath")
  private String mpath = null;

  @SerializedName("is_internal")
  private Boolean isInternal = false;

  @SerializedName("is_active")
  private Boolean isActive = false;

  @SerializedName("category_children")
  private List<Object> categoryChildren = new ArrayList<Object>();

  @SerializedName("parent_category_id")
  private String parentCategoryId = null;

  @SerializedName("parent_category")
  private Object parentCategory = null;

  @SerializedName("products")
  private List<Object> products = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  public ProductCategory id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The product category&#x27;s ID
   * @return id
  **/
  @Schema(example = "pcat_01G2SG30J8C85S4A5CHM2S1NS2", required = true, description = "The product category's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductCategory name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The product category&#x27;s name
   * @return name
  **/
  @Schema(example = "Regular Fit", required = true, description = "The product category's name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductCategory handle(String handle) {
    this.handle = handle;
    return this;
  }

   /**
   * A unique string that identifies the Product Category - can for example be used in slug structures.
   * @return handle
  **/
  @Schema(example = "regular-fit", required = true, description = "A unique string that identifies the Product Category - can for example be used in slug structures.")
  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public ProductCategory mpath(String mpath) {
    this.mpath = mpath;
    return this;
  }

   /**
   * A string for Materialized Paths - used for finding ancestors and descendents
   * @return mpath
  **/
  @Schema(example = "pcat_id1.pcat_id2.pcat_id3", required = true, description = "A string for Materialized Paths - used for finding ancestors and descendents")
  public String getMpath() {
    return mpath;
  }

  public void setMpath(String mpath) {
    this.mpath = mpath;
  }

  public ProductCategory isInternal(Boolean isInternal) {
    this.isInternal = isInternal;
    return this;
  }

   /**
   * A flag to make product category an internal category for admins
   * @return isInternal
  **/
  @Schema(required = true, description = "A flag to make product category an internal category for admins")
  public Boolean isIsInternal() {
    return isInternal;
  }

  public void setIsInternal(Boolean isInternal) {
    this.isInternal = isInternal;
  }

  public ProductCategory isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

   /**
   * A flag to make product category visible/hidden in the store front
   * @return isActive
  **/
  @Schema(required = true, description = "A flag to make product category visible/hidden in the store front")
  public Boolean isIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public ProductCategory categoryChildren(List<Object> categoryChildren) {
    this.categoryChildren = categoryChildren;
    return this;
  }

  public ProductCategory addCategoryChildrenItem(Object categoryChildrenItem) {
    this.categoryChildren.add(categoryChildrenItem);
    return this;
  }

   /**
   * Available if the relation &#x60;category_children&#x60; are expanded.
   * @return categoryChildren
  **/
  @Schema(required = true, description = "Available if the relation `category_children` are expanded.")
  public List<Object> getCategoryChildren() {
    return categoryChildren;
  }

  public void setCategoryChildren(List<Object> categoryChildren) {
    this.categoryChildren = categoryChildren;
  }

  public ProductCategory parentCategoryId(String parentCategoryId) {
    this.parentCategoryId = parentCategoryId;
    return this;
  }

   /**
   * The ID of the parent category.
   * @return parentCategoryId
  **/
  @Schema(required = true, description = "The ID of the parent category.")
  public String getParentCategoryId() {
    return parentCategoryId;
  }

  public void setParentCategoryId(String parentCategoryId) {
    this.parentCategoryId = parentCategoryId;
  }

  public ProductCategory parentCategory(Object parentCategory) {
    this.parentCategory = parentCategory;
    return this;
  }

   /**
   * A product category object. Available if the relation &#x60;parent_category&#x60; is expanded.
   * @return parentCategory
  **/
  @Schema(description = "A product category object. Available if the relation `parent_category` is expanded.")
  public Object getParentCategory() {
    return parentCategory;
  }

  public void setParentCategory(Object parentCategory) {
    this.parentCategory = parentCategory;
  }

  public ProductCategory products(List<Object> products) {
    this.products = products;
    return this;
  }

  public ProductCategory addProductsItem(Object productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<Object>();
    }
    this.products.add(productsItem);
    return this;
  }

   /**
   * Products associated with category. Available if the relation &#x60;products&#x60; is expanded.
   * @return products
  **/
  @Schema(description = "Products associated with category. Available if the relation `products` is expanded.")
  public List<Object> getProducts() {
    return products;
  }

  public void setProducts(List<Object> products) {
    this.products = products;
  }

  public ProductCategory createdAt(OffsetDateTime createdAt) {
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

  public ProductCategory updatedAt(OffsetDateTime updatedAt) {
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

  public ProductCategory deletedAt(OffsetDateTime deletedAt) {
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
    ProductCategory productCategory = (ProductCategory) o;
    return Objects.equals(this.id, productCategory.id) &&
        Objects.equals(this.name, productCategory.name) &&
        Objects.equals(this.handle, productCategory.handle) &&
        Objects.equals(this.mpath, productCategory.mpath) &&
        Objects.equals(this.isInternal, productCategory.isInternal) &&
        Objects.equals(this.isActive, productCategory.isActive) &&
        Objects.equals(this.categoryChildren, productCategory.categoryChildren) &&
        Objects.equals(this.parentCategoryId, productCategory.parentCategoryId) &&
        Objects.equals(this.parentCategory, productCategory.parentCategory) &&
        Objects.equals(this.products, productCategory.products) &&
        Objects.equals(this.createdAt, productCategory.createdAt) &&
        Objects.equals(this.updatedAt, productCategory.updatedAt) &&
        Objects.equals(this.deletedAt, productCategory.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, handle, mpath, isInternal, isActive, categoryChildren, parentCategoryId, parentCategory, products, createdAt, updatedAt, deletedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductCategory {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    handle: ").append(toIndentedString(handle)).append("\n");
    sb.append("    mpath: ").append(toIndentedString(mpath)).append("\n");
    sb.append("    isInternal: ").append(toIndentedString(isInternal)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("    categoryChildren: ").append(toIndentedString(categoryChildren)).append("\n");
    sb.append("    parentCategoryId: ").append(toIndentedString(parentCategoryId)).append("\n");
    sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
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
