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
 * Line Items represent purchasable units that can be added to a Cart for checkout. When Line Items are purchased they will get copied to the resulting order and can eventually be referenced in Fulfillments and Returns. Line Items may also be created when processing Swaps and Claims.
 */
@Schema(description = "Line Items represent purchasable units that can be added to a Cart for checkout. When Line Items are purchased they will get copied to the resulting order and can eventually be referenced in Fulfillments and Returns. Line Items may also be created when processing Swaps and Claims.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class LineItem {
  @SerializedName("id")
  private String id = null;

  @SerializedName("cart_id")
  private String cartId = null;

  @SerializedName("cart")
  private Object cart = null;

  @SerializedName("order_id")
  private String orderId = null;

  @SerializedName("order")
  private Object order = null;

  @SerializedName("swap_id")
  private String swapId = null;

  @SerializedName("swap")
  private Object swap = null;

  @SerializedName("claim_order_id")
  private String claimOrderId = null;

  @SerializedName("claim_order")
  private Object claimOrder = null;

  @SerializedName("tax_lines")
  private List<LineItemTaxLine> taxLines = null;

  @SerializedName("adjustments")
  private List<LineItemAdjustment> adjustments = null;

  @SerializedName("original_item_id")
  private String originalItemId = null;

  @SerializedName("order_edit_id")
  private String orderEditId = null;

  @SerializedName("order_edit")
  private Object orderEdit = null;

  @SerializedName("title")
  private String title = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("thumbnail")
  private String thumbnail = null;

  @SerializedName("is_return")
  private Boolean isReturn = false;

  @SerializedName("is_giftcard")
  private Boolean isGiftcard = false;

  @SerializedName("should_merge")
  private Boolean shouldMerge = true;

  @SerializedName("allow_discounts")
  private Boolean allowDiscounts = true;

  @SerializedName("has_shipping")
  private Boolean hasShipping = null;

  @SerializedName("unit_price")
  private Integer unitPrice = null;

  @SerializedName("variant_id")
  private String variantId = null;

  @SerializedName("variant")
  private ProductVariant variant = null;

  @SerializedName("quantity")
  private Integer quantity = null;

  @SerializedName("fulfilled_quantity")
  private Integer fulfilledQuantity = null;

  @SerializedName("returned_quantity")
  private Integer returnedQuantity = null;

  @SerializedName("shipped_quantity")
  private Integer shippedQuantity = null;

  @SerializedName("refundable")
  private Integer refundable = null;

  @SerializedName("subtotal")
  private Integer subtotal = null;

  @SerializedName("tax_total")
  private Integer taxTotal = null;

  @SerializedName("total")
  private Integer total = null;

  @SerializedName("original_total")
  private Integer originalTotal = null;

  @SerializedName("original_tax_total")
  private Integer originalTaxTotal = null;

  @SerializedName("discount_total")
  private Integer discountTotal = null;

  @SerializedName("gift_card_total")
  private Integer giftCardTotal = null;

  @SerializedName("includes_tax")
  private Boolean includesTax = false;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public LineItem id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The line item&#x27;s ID
   * @return id
  **/
  @Schema(example = "item_01G8ZC9GWT6B2GP5FSXRXNFNGN", required = true, description = "The line item's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LineItem cartId(String cartId) {
    this.cartId = cartId;
    return this;
  }

   /**
   * The ID of the Cart that the Line Item belongs to.
   * @return cartId
  **/
  @Schema(example = "cart_01G8ZH853Y6TFXWPG5EYE81X63", required = true, description = "The ID of the Cart that the Line Item belongs to.")
  public String getCartId() {
    return cartId;
  }

  public void setCartId(String cartId) {
    this.cartId = cartId;
  }

  public LineItem cart(Object cart) {
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

  public LineItem orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * The ID of the Order that the Line Item belongs to.
   * @return orderId
  **/
  @Schema(example = "order_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The ID of the Order that the Line Item belongs to.")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public LineItem order(Object order) {
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

  public LineItem swapId(String swapId) {
    this.swapId = swapId;
    return this;
  }

   /**
   * The id of the Swap that the Line Item belongs to.
   * @return swapId
  **/
  @Schema(required = true, description = "The id of the Swap that the Line Item belongs to.")
  public String getSwapId() {
    return swapId;
  }

  public void setSwapId(String swapId) {
    this.swapId = swapId;
  }

  public LineItem swap(Object swap) {
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

  public LineItem claimOrderId(String claimOrderId) {
    this.claimOrderId = claimOrderId;
    return this;
  }

   /**
   * The id of the Claim that the Line Item belongs to.
   * @return claimOrderId
  **/
  @Schema(required = true, description = "The id of the Claim that the Line Item belongs to.")
  public String getClaimOrderId() {
    return claimOrderId;
  }

  public void setClaimOrderId(String claimOrderId) {
    this.claimOrderId = claimOrderId;
  }

  public LineItem claimOrder(Object claimOrder) {
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

  public LineItem taxLines(List<LineItemTaxLine> taxLines) {
    this.taxLines = taxLines;
    return this;
  }

  public LineItem addTaxLinesItem(LineItemTaxLine taxLinesItem) {
    if (this.taxLines == null) {
      this.taxLines = new ArrayList<LineItemTaxLine>();
    }
    this.taxLines.add(taxLinesItem);
    return this;
  }

   /**
   * Available if the relation &#x60;tax_lines&#x60; is expanded.
   * @return taxLines
  **/
  @Schema(description = "Available if the relation `tax_lines` is expanded.")
  public List<LineItemTaxLine> getTaxLines() {
    return taxLines;
  }

  public void setTaxLines(List<LineItemTaxLine> taxLines) {
    this.taxLines = taxLines;
  }

  public LineItem adjustments(List<LineItemAdjustment> adjustments) {
    this.adjustments = adjustments;
    return this;
  }

  public LineItem addAdjustmentsItem(LineItemAdjustment adjustmentsItem) {
    if (this.adjustments == null) {
      this.adjustments = new ArrayList<LineItemAdjustment>();
    }
    this.adjustments.add(adjustmentsItem);
    return this;
  }

   /**
   * Available if the relation &#x60;adjustments&#x60; is expanded.
   * @return adjustments
  **/
  @Schema(description = "Available if the relation `adjustments` is expanded.")
  public List<LineItemAdjustment> getAdjustments() {
    return adjustments;
  }

  public void setAdjustments(List<LineItemAdjustment> adjustments) {
    this.adjustments = adjustments;
  }

  public LineItem originalItemId(String originalItemId) {
    this.originalItemId = originalItemId;
    return this;
  }

   /**
   * The id of the original line item
   * @return originalItemId
  **/
  @Schema(required = true, description = "The id of the original line item")
  public String getOriginalItemId() {
    return originalItemId;
  }

  public void setOriginalItemId(String originalItemId) {
    this.originalItemId = originalItemId;
  }

  public LineItem orderEditId(String orderEditId) {
    this.orderEditId = orderEditId;
    return this;
  }

   /**
   * The ID of the order edit to which a cloned item belongs
   * @return orderEditId
  **/
  @Schema(required = true, description = "The ID of the order edit to which a cloned item belongs")
  public String getOrderEditId() {
    return orderEditId;
  }

  public void setOrderEditId(String orderEditId) {
    this.orderEditId = orderEditId;
  }

  public LineItem orderEdit(Object orderEdit) {
    this.orderEdit = orderEdit;
    return this;
  }

   /**
   * The order edit joined. Available if the relation &#x60;order_edit&#x60; is expanded.
   * @return orderEdit
  **/
  @Schema(description = "The order edit joined. Available if the relation `order_edit` is expanded.")
  public Object getOrderEdit() {
    return orderEdit;
  }

  public void setOrderEdit(Object orderEdit) {
    this.orderEdit = orderEdit;
  }

  public LineItem title(String title) {
    this.title = title;
    return this;
  }

   /**
   * The title of the Line Item, this should be easily identifiable by the Customer.
   * @return title
  **/
  @Schema(example = "Medusa Coffee Mug", required = true, description = "The title of the Line Item, this should be easily identifiable by the Customer.")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LineItem description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A more detailed description of the contents of the Line Item.
   * @return description
  **/
  @Schema(example = "One Size", required = true, description = "A more detailed description of the contents of the Line Item.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LineItem thumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
    return this;
  }

   /**
   * A URL string to a small image of the contents of the Line Item.
   * @return thumbnail
  **/
  @Schema(example = "https://medusa-public-images.s3.eu-west-1.amazonaws.com/coffee-mug.png", required = true, description = "A URL string to a small image of the contents of the Line Item.")
  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public LineItem isReturn(Boolean isReturn) {
    this.isReturn = isReturn;
    return this;
  }

   /**
   * Is the item being returned
   * @return isReturn
  **/
  @Schema(required = true, description = "Is the item being returned")
  public Boolean isIsReturn() {
    return isReturn;
  }

  public void setIsReturn(Boolean isReturn) {
    this.isReturn = isReturn;
  }

  public LineItem isGiftcard(Boolean isGiftcard) {
    this.isGiftcard = isGiftcard;
    return this;
  }

   /**
   * Flag to indicate if the Line Item is a Gift Card.
   * @return isGiftcard
  **/
  @Schema(required = true, description = "Flag to indicate if the Line Item is a Gift Card.")
  public Boolean isIsGiftcard() {
    return isGiftcard;
  }

  public void setIsGiftcard(Boolean isGiftcard) {
    this.isGiftcard = isGiftcard;
  }

  public LineItem shouldMerge(Boolean shouldMerge) {
    this.shouldMerge = shouldMerge;
    return this;
  }

   /**
   * Flag to indicate if new Line Items with the same variant should be merged or added as an additional Line Item.
   * @return shouldMerge
  **/
  @Schema(required = true, description = "Flag to indicate if new Line Items with the same variant should be merged or added as an additional Line Item.")
  public Boolean isShouldMerge() {
    return shouldMerge;
  }

  public void setShouldMerge(Boolean shouldMerge) {
    this.shouldMerge = shouldMerge;
  }

  public LineItem allowDiscounts(Boolean allowDiscounts) {
    this.allowDiscounts = allowDiscounts;
    return this;
  }

   /**
   * Flag to indicate if the Line Item should be included when doing discount calculations.
   * @return allowDiscounts
  **/
  @Schema(required = true, description = "Flag to indicate if the Line Item should be included when doing discount calculations.")
  public Boolean isAllowDiscounts() {
    return allowDiscounts;
  }

  public void setAllowDiscounts(Boolean allowDiscounts) {
    this.allowDiscounts = allowDiscounts;
  }

  public LineItem hasShipping(Boolean hasShipping) {
    this.hasShipping = hasShipping;
    return this;
  }

   /**
   * Flag to indicate if the Line Item has fulfillment associated with it.
   * @return hasShipping
  **/
  @Schema(example = "false", required = true, description = "Flag to indicate if the Line Item has fulfillment associated with it.")
  public Boolean isHasShipping() {
    return hasShipping;
  }

  public void setHasShipping(Boolean hasShipping) {
    this.hasShipping = hasShipping;
  }

  public LineItem unitPrice(Integer unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

   /**
   * The price of one unit of the content in the Line Item. This should be in the currency defined by the Cart/Order/Swap/Claim that the Line Item belongs to.
   * @return unitPrice
  **/
  @Schema(example = "8000", required = true, description = "The price of one unit of the content in the Line Item. This should be in the currency defined by the Cart/Order/Swap/Claim that the Line Item belongs to.")
  public Integer getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Integer unitPrice) {
    this.unitPrice = unitPrice;
  }

  public LineItem variantId(String variantId) {
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

  public LineItem variant(ProductVariant variant) {
    this.variant = variant;
    return this;
  }

   /**
   * Get variant
   * @return variant
  **/
  @Schema(description = "")
  public ProductVariant getVariant() {
    return variant;
  }

  public void setVariant(ProductVariant variant) {
    this.variant = variant;
  }

  public LineItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * The quantity of the content in the Line Item.
   * @return quantity
  **/
  @Schema(example = "1", required = true, description = "The quantity of the content in the Line Item.")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public LineItem fulfilledQuantity(Integer fulfilledQuantity) {
    this.fulfilledQuantity = fulfilledQuantity;
    return this;
  }

   /**
   * The quantity of the Line Item that has been fulfilled.
   * @return fulfilledQuantity
  **/
  @Schema(example = "0", required = true, description = "The quantity of the Line Item that has been fulfilled.")
  public Integer getFulfilledQuantity() {
    return fulfilledQuantity;
  }

  public void setFulfilledQuantity(Integer fulfilledQuantity) {
    this.fulfilledQuantity = fulfilledQuantity;
  }

  public LineItem returnedQuantity(Integer returnedQuantity) {
    this.returnedQuantity = returnedQuantity;
    return this;
  }

   /**
   * The quantity of the Line Item that has been returned.
   * @return returnedQuantity
  **/
  @Schema(example = "0", required = true, description = "The quantity of the Line Item that has been returned.")
  public Integer getReturnedQuantity() {
    return returnedQuantity;
  }

  public void setReturnedQuantity(Integer returnedQuantity) {
    this.returnedQuantity = returnedQuantity;
  }

  public LineItem shippedQuantity(Integer shippedQuantity) {
    this.shippedQuantity = shippedQuantity;
    return this;
  }

   /**
   * The quantity of the Line Item that has been shipped.
   * @return shippedQuantity
  **/
  @Schema(example = "0", required = true, description = "The quantity of the Line Item that has been shipped.")
  public Integer getShippedQuantity() {
    return shippedQuantity;
  }

  public void setShippedQuantity(Integer shippedQuantity) {
    this.shippedQuantity = shippedQuantity;
  }

  public LineItem refundable(Integer refundable) {
    this.refundable = refundable;
    return this;
  }

   /**
   * The amount that can be refunded from the given Line Item. Takes taxes and discounts into consideration.
   * @return refundable
  **/
  @Schema(example = "0", description = "The amount that can be refunded from the given Line Item. Takes taxes and discounts into consideration.")
  public Integer getRefundable() {
    return refundable;
  }

  public void setRefundable(Integer refundable) {
    this.refundable = refundable;
  }

  public LineItem subtotal(Integer subtotal) {
    this.subtotal = subtotal;
    return this;
  }

   /**
   * The subtotal of the line item
   * @return subtotal
  **/
  @Schema(example = "8000", description = "The subtotal of the line item")
  public Integer getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Integer subtotal) {
    this.subtotal = subtotal;
  }

  public LineItem taxTotal(Integer taxTotal) {
    this.taxTotal = taxTotal;
    return this;
  }

   /**
   * The total of tax of the line item
   * @return taxTotal
  **/
  @Schema(example = "0", description = "The total of tax of the line item")
  public Integer getTaxTotal() {
    return taxTotal;
  }

  public void setTaxTotal(Integer taxTotal) {
    this.taxTotal = taxTotal;
  }

  public LineItem total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * The total amount of the line item
   * @return total
  **/
  @Schema(example = "8000", description = "The total amount of the line item")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public LineItem originalTotal(Integer originalTotal) {
    this.originalTotal = originalTotal;
    return this;
  }

   /**
   * The original total amount of the line item
   * @return originalTotal
  **/
  @Schema(example = "8000", description = "The original total amount of the line item")
  public Integer getOriginalTotal() {
    return originalTotal;
  }

  public void setOriginalTotal(Integer originalTotal) {
    this.originalTotal = originalTotal;
  }

  public LineItem originalTaxTotal(Integer originalTaxTotal) {
    this.originalTaxTotal = originalTaxTotal;
    return this;
  }

   /**
   * The original tax total amount of the line item
   * @return originalTaxTotal
  **/
  @Schema(example = "0", description = "The original tax total amount of the line item")
  public Integer getOriginalTaxTotal() {
    return originalTaxTotal;
  }

  public void setOriginalTaxTotal(Integer originalTaxTotal) {
    this.originalTaxTotal = originalTaxTotal;
  }

  public LineItem discountTotal(Integer discountTotal) {
    this.discountTotal = discountTotal;
    return this;
  }

   /**
   * The total of discount of the line item
   * @return discountTotal
  **/
  @Schema(example = "0", description = "The total of discount of the line item")
  public Integer getDiscountTotal() {
    return discountTotal;
  }

  public void setDiscountTotal(Integer discountTotal) {
    this.discountTotal = discountTotal;
  }

  public LineItem giftCardTotal(Integer giftCardTotal) {
    this.giftCardTotal = giftCardTotal;
    return this;
  }

   /**
   * The total of the gift card of the line item
   * @return giftCardTotal
  **/
  @Schema(example = "0", description = "The total of the gift card of the line item")
  public Integer getGiftCardTotal() {
    return giftCardTotal;
  }

  public void setGiftCardTotal(Integer giftCardTotal) {
    this.giftCardTotal = giftCardTotal;
  }

  public LineItem includesTax(Boolean includesTax) {
    this.includesTax = includesTax;
    return this;
  }

   /**
   * [EXPERIMENTAL] Indicates if the line item unit_price include tax
   * @return includesTax
  **/
  @Schema(description = "[EXPERIMENTAL] Indicates if the line item unit_price include tax")
  public Boolean isIncludesTax() {
    return includesTax;
  }

  public void setIncludesTax(Boolean includesTax) {
    this.includesTax = includesTax;
  }

  public LineItem createdAt(OffsetDateTime createdAt) {
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

  public LineItem updatedAt(OffsetDateTime updatedAt) {
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

  public LineItem metadata(Object metadata) {
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
    LineItem lineItem = (LineItem) o;
    return Objects.equals(this.id, lineItem.id) &&
        Objects.equals(this.cartId, lineItem.cartId) &&
        Objects.equals(this.cart, lineItem.cart) &&
        Objects.equals(this.orderId, lineItem.orderId) &&
        Objects.equals(this.order, lineItem.order) &&
        Objects.equals(this.swapId, lineItem.swapId) &&
        Objects.equals(this.swap, lineItem.swap) &&
        Objects.equals(this.claimOrderId, lineItem.claimOrderId) &&
        Objects.equals(this.claimOrder, lineItem.claimOrder) &&
        Objects.equals(this.taxLines, lineItem.taxLines) &&
        Objects.equals(this.adjustments, lineItem.adjustments) &&
        Objects.equals(this.originalItemId, lineItem.originalItemId) &&
        Objects.equals(this.orderEditId, lineItem.orderEditId) &&
        Objects.equals(this.orderEdit, lineItem.orderEdit) &&
        Objects.equals(this.title, lineItem.title) &&
        Objects.equals(this.description, lineItem.description) &&
        Objects.equals(this.thumbnail, lineItem.thumbnail) &&
        Objects.equals(this.isReturn, lineItem.isReturn) &&
        Objects.equals(this.isGiftcard, lineItem.isGiftcard) &&
        Objects.equals(this.shouldMerge, lineItem.shouldMerge) &&
        Objects.equals(this.allowDiscounts, lineItem.allowDiscounts) &&
        Objects.equals(this.hasShipping, lineItem.hasShipping) &&
        Objects.equals(this.unitPrice, lineItem.unitPrice) &&
        Objects.equals(this.variantId, lineItem.variantId) &&
        Objects.equals(this.variant, lineItem.variant) &&
        Objects.equals(this.quantity, lineItem.quantity) &&
        Objects.equals(this.fulfilledQuantity, lineItem.fulfilledQuantity) &&
        Objects.equals(this.returnedQuantity, lineItem.returnedQuantity) &&
        Objects.equals(this.shippedQuantity, lineItem.shippedQuantity) &&
        Objects.equals(this.refundable, lineItem.refundable) &&
        Objects.equals(this.subtotal, lineItem.subtotal) &&
        Objects.equals(this.taxTotal, lineItem.taxTotal) &&
        Objects.equals(this.total, lineItem.total) &&
        Objects.equals(this.originalTotal, lineItem.originalTotal) &&
        Objects.equals(this.originalTaxTotal, lineItem.originalTaxTotal) &&
        Objects.equals(this.discountTotal, lineItem.discountTotal) &&
        Objects.equals(this.giftCardTotal, lineItem.giftCardTotal) &&
        Objects.equals(this.includesTax, lineItem.includesTax) &&
        Objects.equals(this.createdAt, lineItem.createdAt) &&
        Objects.equals(this.updatedAt, lineItem.updatedAt) &&
        Objects.equals(this.metadata, lineItem.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cartId, cart, orderId, order, swapId, swap, claimOrderId, claimOrder, taxLines, adjustments, originalItemId, orderEditId, orderEdit, title, description, thumbnail, isReturn, isGiftcard, shouldMerge, allowDiscounts, hasShipping, unitPrice, variantId, variant, quantity, fulfilledQuantity, returnedQuantity, shippedQuantity, refundable, subtotal, taxTotal, total, originalTotal, originalTaxTotal, discountTotal, giftCardTotal, includesTax, createdAt, updatedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cartId: ").append(toIndentedString(cartId)).append("\n");
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    swapId: ").append(toIndentedString(swapId)).append("\n");
    sb.append("    swap: ").append(toIndentedString(swap)).append("\n");
    sb.append("    claimOrderId: ").append(toIndentedString(claimOrderId)).append("\n");
    sb.append("    claimOrder: ").append(toIndentedString(claimOrder)).append("\n");
    sb.append("    taxLines: ").append(toIndentedString(taxLines)).append("\n");
    sb.append("    adjustments: ").append(toIndentedString(adjustments)).append("\n");
    sb.append("    originalItemId: ").append(toIndentedString(originalItemId)).append("\n");
    sb.append("    orderEditId: ").append(toIndentedString(orderEditId)).append("\n");
    sb.append("    orderEdit: ").append(toIndentedString(orderEdit)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
    sb.append("    isReturn: ").append(toIndentedString(isReturn)).append("\n");
    sb.append("    isGiftcard: ").append(toIndentedString(isGiftcard)).append("\n");
    sb.append("    shouldMerge: ").append(toIndentedString(shouldMerge)).append("\n");
    sb.append("    allowDiscounts: ").append(toIndentedString(allowDiscounts)).append("\n");
    sb.append("    hasShipping: ").append(toIndentedString(hasShipping)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    variantId: ").append(toIndentedString(variantId)).append("\n");
    sb.append("    variant: ").append(toIndentedString(variant)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    fulfilledQuantity: ").append(toIndentedString(fulfilledQuantity)).append("\n");
    sb.append("    returnedQuantity: ").append(toIndentedString(returnedQuantity)).append("\n");
    sb.append("    shippedQuantity: ").append(toIndentedString(shippedQuantity)).append("\n");
    sb.append("    refundable: ").append(toIndentedString(refundable)).append("\n");
    sb.append("    subtotal: ").append(toIndentedString(subtotal)).append("\n");
    sb.append("    taxTotal: ").append(toIndentedString(taxTotal)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    originalTotal: ").append(toIndentedString(originalTotal)).append("\n");
    sb.append("    originalTaxTotal: ").append(toIndentedString(originalTaxTotal)).append("\n");
    sb.append("    discountTotal: ").append(toIndentedString(discountTotal)).append("\n");
    sb.append("    giftCardTotal: ").append(toIndentedString(giftCardTotal)).append("\n");
    sb.append("    includesTax: ").append(toIndentedString(includesTax)).append("\n");
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
