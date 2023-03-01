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
 * Payments represent an amount authorized with a given payment method, Payments can be captured, canceled or refunded.
 */
@Schema(description = "Payments represent an amount authorized with a given payment method, Payments can be captured, canceled or refunded.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class Payment {
  @SerializedName("id")
  private String id = null;

  @SerializedName("swap_id")
  private String swapId = null;

  @SerializedName("swap")
  private Object swap = null;

  @SerializedName("cart_id")
  private String cartId = null;

  @SerializedName("cart")
  private Object cart = null;

  @SerializedName("order_id")
  private String orderId = null;

  @SerializedName("order")
  private Object order = null;

  @SerializedName("amount")
  private Integer amount = null;

  @SerializedName("currency_code")
  private String currencyCode = null;

  @SerializedName("currency")
  private Currency currency = null;

  @SerializedName("amount_refunded")
  private Integer amountRefunded = 0;

  @SerializedName("provider_id")
  private String providerId = null;

  @SerializedName("data")
  private Object data = null;

  @SerializedName("captured_at")
  private OffsetDateTime capturedAt = null;

  @SerializedName("canceled_at")
  private OffsetDateTime canceledAt = null;

  @SerializedName("idempotency_key")
  private String idempotencyKey = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("metadata")
  private Object metadata = null;

  public Payment id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The payment&#x27;s ID
   * @return id
  **/
  @Schema(example = "pay_01G2SJNT6DEEWDFNAJ4XWDTHKE", required = true, description = "The payment's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Payment swapId(String swapId) {
    this.swapId = swapId;
    return this;
  }

   /**
   * The ID of the Swap that the Payment is used for.
   * @return swapId
  **/
  @Schema(required = true, description = "The ID of the Swap that the Payment is used for.")
  public String getSwapId() {
    return swapId;
  }

  public void setSwapId(String swapId) {
    this.swapId = swapId;
  }

  public Payment swap(Object swap) {
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

  public Payment cartId(String cartId) {
    this.cartId = cartId;
    return this;
  }

   /**
   * The id of the Cart that the Payment Session is created for.
   * @return cartId
  **/
  @Schema(required = true, description = "The id of the Cart that the Payment Session is created for.")
  public String getCartId() {
    return cartId;
  }

  public void setCartId(String cartId) {
    this.cartId = cartId;
  }

  public Payment cart(Object cart) {
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

  public Payment orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

   /**
   * The ID of the Order that the Payment is used for.
   * @return orderId
  **/
  @Schema(example = "order_01G8TJSYT9M6AVS5N4EMNFS1EK", required = true, description = "The ID of the Order that the Payment is used for.")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Payment order(Object order) {
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

  public Payment amount(Integer amount) {
    this.amount = amount;
    return this;
  }

   /**
   * The amount that the Payment has been authorized for.
   * @return amount
  **/
  @Schema(example = "100", required = true, description = "The amount that the Payment has been authorized for.")
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Payment currencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

   /**
   * The 3 character ISO currency code that the Payment is completed in.
   * @return currencyCode
  **/
  @Schema(example = "usd", required = true, description = "The 3 character ISO currency code that the Payment is completed in.")
  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Payment currency(Currency currency) {
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

  public Payment amountRefunded(Integer amountRefunded) {
    this.amountRefunded = amountRefunded;
    return this;
  }

   /**
   * The amount of the original Payment amount that has been refunded back to the Customer.
   * @return amountRefunded
  **/
  @Schema(example = "0", required = true, description = "The amount of the original Payment amount that has been refunded back to the Customer.")
  public Integer getAmountRefunded() {
    return amountRefunded;
  }

  public void setAmountRefunded(Integer amountRefunded) {
    this.amountRefunded = amountRefunded;
  }

  public Payment providerId(String providerId) {
    this.providerId = providerId;
    return this;
  }

   /**
   * The id of the Payment Provider that is responsible for the Payment
   * @return providerId
  **/
  @Schema(example = "manual", required = true, description = "The id of the Payment Provider that is responsible for the Payment")
  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public Payment data(Object data) {
    this.data = data;
    return this;
  }

   /**
   * The data required for the Payment Provider to identify, modify and process the Payment. Typically this will be an object that holds an id to the external payment session, but can be an empty object if the Payment Provider doesn&#x27;t hold any state.
   * @return data
  **/
  @Schema(example = "{}", required = true, description = "The data required for the Payment Provider to identify, modify and process the Payment. Typically this will be an object that holds an id to the external payment session, but can be an empty object if the Payment Provider doesn't hold any state.")
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Payment capturedAt(OffsetDateTime capturedAt) {
    this.capturedAt = capturedAt;
    return this;
  }

   /**
   * The date with timezone at which the Payment was captured.
   * @return capturedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the Payment was captured.")
  public OffsetDateTime getCapturedAt() {
    return capturedAt;
  }

  public void setCapturedAt(OffsetDateTime capturedAt) {
    this.capturedAt = capturedAt;
  }

  public Payment canceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
    return this;
  }

   /**
   * The date with timezone at which the Payment was canceled.
   * @return canceledAt
  **/
  @Schema(required = true, description = "The date with timezone at which the Payment was canceled.")
  public OffsetDateTime getCanceledAt() {
    return canceledAt;
  }

  public void setCanceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
  }

  public Payment idempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
    return this;
  }

   /**
   * Randomly generated key used to continue the completion of a payment in case of failure.
   * @return idempotencyKey
  **/
  @Schema(required = true, description = "Randomly generated key used to continue the completion of a payment in case of failure.")
  public String getIdempotencyKey() {
    return idempotencyKey;
  }

  public void setIdempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
  }

  public Payment createdAt(OffsetDateTime createdAt) {
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

  public Payment updatedAt(OffsetDateTime updatedAt) {
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

  public Payment metadata(Object metadata) {
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
    Payment payment = (Payment) o;
    return Objects.equals(this.id, payment.id) &&
        Objects.equals(this.swapId, payment.swapId) &&
        Objects.equals(this.swap, payment.swap) &&
        Objects.equals(this.cartId, payment.cartId) &&
        Objects.equals(this.cart, payment.cart) &&
        Objects.equals(this.orderId, payment.orderId) &&
        Objects.equals(this.order, payment.order) &&
        Objects.equals(this.amount, payment.amount) &&
        Objects.equals(this.currencyCode, payment.currencyCode) &&
        Objects.equals(this.currency, payment.currency) &&
        Objects.equals(this.amountRefunded, payment.amountRefunded) &&
        Objects.equals(this.providerId, payment.providerId) &&
        Objects.equals(this.data, payment.data) &&
        Objects.equals(this.capturedAt, payment.capturedAt) &&
        Objects.equals(this.canceledAt, payment.canceledAt) &&
        Objects.equals(this.idempotencyKey, payment.idempotencyKey) &&
        Objects.equals(this.createdAt, payment.createdAt) &&
        Objects.equals(this.updatedAt, payment.updatedAt) &&
        Objects.equals(this.metadata, payment.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, swapId, swap, cartId, cart, orderId, order, amount, currencyCode, currency, amountRefunded, providerId, data, capturedAt, canceledAt, idempotencyKey, createdAt, updatedAt, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    swapId: ").append(toIndentedString(swapId)).append("\n");
    sb.append("    swap: ").append(toIndentedString(swap)).append("\n");
    sb.append("    cartId: ").append(toIndentedString(cartId)).append("\n");
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    amountRefunded: ").append(toIndentedString(amountRefunded)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    capturedAt: ").append(toIndentedString(capturedAt)).append("\n");
    sb.append("    canceledAt: ").append(toIndentedString(canceledAt)).append("\n");
    sb.append("    idempotencyKey: ").append(toIndentedString(idempotencyKey)).append("\n");
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
