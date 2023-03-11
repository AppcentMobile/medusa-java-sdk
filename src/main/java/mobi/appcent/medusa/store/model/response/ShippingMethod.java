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
 * Shipping Methods represent a way in which an Order or Return can be shipped. Shipping Methods are built from a Shipping Option, but may contain additional details, that can be necessary for the Fulfillment Provider to handle the shipment.
 */
@Schema(description = "Shipping Methods represent a way in which an Order or Return can be shipped. Shipping Methods are built from a Shipping Option, but may contain additional details, that can be necessary for the Fulfillment Provider to handle the shipment.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class ShippingMethod {
  @SerializedName("id")
  private String id = null;

  @SerializedName("shipping_option_id")
  private String shippingOptionId = null;

  @SerializedName("order_id")
  private String orderId = null;

  @SerializedName("order")
  private Object order = null;

  @SerializedName("claim_order_id")
  private String claimOrderId = null;

  @SerializedName("claim_order")
  private Object claimOrder = null;

  @SerializedName("cart_id")
  private String cartId = null;

  @SerializedName("cart")
  private Object cart = null;

  @SerializedName("swap_id")
  private String swapId = null;

  @SerializedName("swap")
  private Object swap = null;

  @SerializedName("return_id")
  private String returnId = null;

  @SerializedName("return_order")
  private Object returnOrder = null;

  @SerializedName("shipping_option")
  private ShippingOption shippingOption = null;

  @SerializedName("tax_lines")
  private List<ShippingMethodTaxLine> taxLines = null;

  @SerializedName("price")
  private Integer price = null;

  @SerializedName("data")
  private Object data = null;

  @SerializedName("includes_tax")
  private Boolean includesTax = false;

  @SerializedName("subtotal")
  private Integer subtotal = null;

  @SerializedName("total")
  private Integer total = null;

  @SerializedName("tax_total")
  private Integer taxTotal = null;

  public ShippingMethod id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The shipping method&#x27;s ID
   * @return id
  **/
  @Schema(example = "sm_01F0YET7DR2E7CYVSDHM593QG2", required = true, description = "The shipping method's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ShippingMethod shippingOptionId(String shippingOptionId) {
    this.shippingOptionId = shippingOptionId;
    return this;
  }

   /**
   * The id of the Shipping Option that the Shipping Method is built from.
   * @return shippingOptionId
  **/
  @Schema(example = "so_01G1G5V27GYX4QXNARRQCW1N8T", required = true, description = "The id of the Shipping Option that the Shipping Method is built from.")
  public String getShippingOptionId() {
    return shippingOptionId;
  }

  public void setShippingOptionId(String shippingOptionId) {
    this.shippingOptionId = shippingOptionId;
  }

  public ShippingMethod orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * The id of the Order that the Shipping Method is used on.
   * @return orderId
  **/
  @Schema(example = "order_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The id of the Order that the Shipping Method is used on.")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public ShippingMethod order(Object order) {
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

  public ShippingMethod claimOrderId(String claimOrderId) {
    this.claimOrderId = claimOrderId;
    return this;
  }

   /**
   * The id of the Claim that the Shipping Method is used on.
   * @return claimOrderId
  **/
  @Schema(required = true, description = "The id of the Claim that the Shipping Method is used on.")
  public String getClaimOrderId() {
    return claimOrderId;
  }

  public void setClaimOrderId(String claimOrderId) {
    this.claimOrderId = claimOrderId;
  }

  public ShippingMethod claimOrder(Object claimOrder) {
    this.claimOrder = claimOrder;
    return this;
  }

   /**
   * A claim order object. Available if the relation &#x60;claim_order&#x60; is expanded.
   * @return claimOrder
  **/
  @Schema(description = "A claim order object. Available if the relation `claim_order` is expanded.")
  public Object getClaimOrder() {
    return claimOrder;
  }

  public void setClaimOrder(Object claimOrder) {
    this.claimOrder = claimOrder;
  }

  public ShippingMethod cartId(String cartId) {
    this.cartId = cartId;
    return this;
  }

   /**
   * The id of the Cart that the Shipping Method is used on.
   * @return cartId
  **/
  @Schema(example = "cart_01G8ZH853Y6TFXWPG5EYE81X63", required = true, description = "The id of the Cart that the Shipping Method is used on.")
  public String getCartId() {
    return cartId;
  }

  public void setCartId(String cartId) {
    this.cartId = cartId;
  }

  public ShippingMethod cart(Object cart) {
    this.cart = cart;
    return this;
  }

   /**
   * A cart object. Available if the relation &#x60;cart&#x60; is expanded.
   * @return cart
  **/
  @Schema(description = "A cart object. Available if the relation `cart` is expanded.")
  public Object getCart() {
    return cart;
  }

  public void setCart(Object cart) {
    this.cart = cart;
  }

  public ShippingMethod swapId(String swapId) {
    this.swapId = swapId;
    return this;
  }

   /**
   * The id of the Swap that the Shipping Method is used on.
   * @return swapId
  **/
  @Schema(required = true, description = "The id of the Swap that the Shipping Method is used on.")
  public String getSwapId() {
    return swapId;
  }

  public void setSwapId(String swapId) {
    this.swapId = swapId;
  }

  public ShippingMethod swap(Object swap) {
    this.swap = swap;
    return this;
  }

   /**
   * A swap object. Available if the relation &#x60;swap&#x60; is expanded.
   * @return swap
  **/
  @Schema(description = "A swap object. Available if the relation `swap` is expanded.")
  public Object getSwap() {
    return swap;
  }

  public void setSwap(Object swap) {
    this.swap = swap;
  }

  public ShippingMethod returnId(String returnId) {
    this.returnId = returnId;
    return this;
  }

   /**
   * The id of the Return that the Shipping Method is used on.
   * @return returnId
  **/
  @Schema(required = true, description = "The id of the Return that the Shipping Method is used on.")
  public String getReturnId() {
    return returnId;
  }

  public void setReturnId(String returnId) {
    this.returnId = returnId;
  }

  public ShippingMethod returnOrder(Object returnOrder) {
    this.returnOrder = returnOrder;
    return this;
  }

   /**
   * A return object. Available if the relation &#x60;return_order&#x60; is expanded.
   * @return returnOrder
  **/
  @Schema(description = "A return object. Available if the relation `return_order` is expanded.")
  public Object getReturnOrder() {
    return returnOrder;
  }

  public void setReturnOrder(Object returnOrder) {
    this.returnOrder = returnOrder;
  }

  public ShippingMethod shippingOption(ShippingOption shippingOption) {
    this.shippingOption = shippingOption;
    return this;
  }

   /**
   * Get shippingOption
   * @return shippingOption
  **/
  @Schema(description = "")
  public ShippingOption getShippingOption() {
    return shippingOption;
  }

  public void setShippingOption(ShippingOption shippingOption) {
    this.shippingOption = shippingOption;
  }

  public ShippingMethod taxLines(List<ShippingMethodTaxLine> taxLines) {
    this.taxLines = taxLines;
    return this;
  }

  public ShippingMethod addTaxLinesItem(ShippingMethodTaxLine taxLinesItem) {
    if (this.taxLines == null) {
      this.taxLines = new ArrayList<ShippingMethodTaxLine>();
    }
    this.taxLines.add(taxLinesItem);
    return this;
  }

   /**
   * Available if the relation &#x60;tax_lines&#x60; is expanded.
   * @return taxLines
  **/
  @Schema(description = "Available if the relation `tax_lines` is expanded.")
  public List<ShippingMethodTaxLine> getTaxLines() {
    return taxLines;
  }

  public void setTaxLines(List<ShippingMethodTaxLine> taxLines) {
    this.taxLines = taxLines;
  }

  public ShippingMethod price(Integer price) {
    this.price = price;
    return this;
  }

   /**
   * The amount to charge for the Shipping Method. The currency of the price is defined by the Region that the Order that the Shipping Method belongs to is a part of.
   * @return price
  **/
  @Schema(example = "200", required = true, description = "The amount to charge for the Shipping Method. The currency of the price is defined by the Region that the Order that the Shipping Method belongs to is a part of.")
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public ShippingMethod data(Object data) {
    this.data = data;
    return this;
  }

   /**
   * Additional data that the Fulfillment Provider needs to fulfill the shipment. This is used in combination with the Shipping Options data, and may contain information such as a drop point id.
   * @return data
  **/
  @Schema(example = "{}", required = true, description = "Additional data that the Fulfillment Provider needs to fulfill the shipment. This is used in combination with the Shipping Options data, and may contain information such as a drop point id.")
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public ShippingMethod includesTax(Boolean includesTax) {
    this.includesTax = includesTax;
    return this;
  }

   /**
   * [EXPERIMENTAL] Indicates if the shipping method price include tax
   * @return includesTax
  **/
  @Schema(description = "[EXPERIMENTAL] Indicates if the shipping method price include tax")
  public Boolean isIncludesTax() {
    return includesTax;
  }

  public void setIncludesTax(Boolean includesTax) {
    this.includesTax = includesTax;
  }

  public ShippingMethod subtotal(Integer subtotal) {
    this.subtotal = subtotal;
    return this;
  }

   /**
   * The subtotal of the shipping
   * @return subtotal
  **/
  @Schema(example = "8000", description = "The subtotal of the shipping")
  public Integer getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Integer subtotal) {
    this.subtotal = subtotal;
  }

  public ShippingMethod total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * The total amount of the shipping
   * @return total
  **/
  @Schema(example = "8200", description = "The total amount of the shipping")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public ShippingMethod taxTotal(Integer taxTotal) {
    this.taxTotal = taxTotal;
    return this;
  }

   /**
   * The total of tax
   * @return taxTotal
  **/
  @Schema(example = "0", description = "The total of tax")
  public Integer getTaxTotal() {
    return taxTotal;
  }

  public void setTaxTotal(Integer taxTotal) {
    this.taxTotal = taxTotal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShippingMethod shippingMethod = (ShippingMethod) o;
    return Objects.equals(this.id, shippingMethod.id) &&
        Objects.equals(this.shippingOptionId, shippingMethod.shippingOptionId) &&
        Objects.equals(this.orderId, shippingMethod.orderId) &&
        Objects.equals(this.order, shippingMethod.order) &&
        Objects.equals(this.claimOrderId, shippingMethod.claimOrderId) &&
        Objects.equals(this.claimOrder, shippingMethod.claimOrder) &&
        Objects.equals(this.cartId, shippingMethod.cartId) &&
        Objects.equals(this.cart, shippingMethod.cart) &&
        Objects.equals(this.swapId, shippingMethod.swapId) &&
        Objects.equals(this.swap, shippingMethod.swap) &&
        Objects.equals(this.returnId, shippingMethod.returnId) &&
        Objects.equals(this.returnOrder, shippingMethod.returnOrder) &&
        Objects.equals(this.shippingOption, shippingMethod.shippingOption) &&
        Objects.equals(this.taxLines, shippingMethod.taxLines) &&
        Objects.equals(this.price, shippingMethod.price) &&
        Objects.equals(this.data, shippingMethod.data) &&
        Objects.equals(this.includesTax, shippingMethod.includesTax) &&
        Objects.equals(this.subtotal, shippingMethod.subtotal) &&
        Objects.equals(this.total, shippingMethod.total) &&
        Objects.equals(this.taxTotal, shippingMethod.taxTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, shippingOptionId, orderId, order, claimOrderId, claimOrder, cartId, cart, swapId, swap, returnId, returnOrder, shippingOption, taxLines, price, data, includesTax, subtotal, total, taxTotal);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShippingMethod {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    shippingOptionId: ").append(toIndentedString(shippingOptionId)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    claimOrderId: ").append(toIndentedString(claimOrderId)).append("\n");
    sb.append("    claimOrder: ").append(toIndentedString(claimOrder)).append("\n");
    sb.append("    cartId: ").append(toIndentedString(cartId)).append("\n");
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
    sb.append("    swapId: ").append(toIndentedString(swapId)).append("\n");
    sb.append("    swap: ").append(toIndentedString(swap)).append("\n");
    sb.append("    returnId: ").append(toIndentedString(returnId)).append("\n");
    sb.append("    returnOrder: ").append(toIndentedString(returnOrder)).append("\n");
    sb.append("    shippingOption: ").append(toIndentedString(shippingOption)).append("\n");
    sb.append("    taxLines: ").append(toIndentedString(taxLines)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    includesTax: ").append(toIndentedString(includesTax)).append("\n");
    sb.append("    subtotal: ").append(toIndentedString(subtotal)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    taxTotal: ").append(toIndentedString(taxTotal)).append("\n");
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
