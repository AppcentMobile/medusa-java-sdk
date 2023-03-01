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
import org.threeten.bp.OffsetDateTime;
/**
 * Payment Sessions are created when a Customer initilizes the checkout flow, and can be used to hold the state of a payment flow. Each Payment Session is controlled by a Payment Provider, who is responsible for the communication with external payment services. Authorized Payment Sessions will eventually get promoted to Payments to indicate that they are authorized for capture/refunds/etc.
 */
@Schema(description = "Payment Sessions are created when a Customer initilizes the checkout flow, and can be used to hold the state of a payment flow. Each Payment Session is controlled by a Payment Provider, who is responsible for the communication with external payment services. Authorized Payment Sessions will eventually get promoted to Payments to indicate that they are authorized for capture/refunds/etc.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class PaymentSession {
  @SerializedName("id")
  private String id = null;

  @SerializedName("cart_id")
  private String cartId = null;

  @SerializedName("cart")
  private Cart cart = null;

  @SerializedName("provider_id")
  private String providerId = null;

  @SerializedName("is_selected")
  private Boolean isSelected = null;

  @SerializedName("is_initiated")
  private Boolean isInitiated = false;

  /**
   * Indicates the status of the Payment Session. Will default to &#x60;pending&#x60;, and will eventually become &#x60;authorized&#x60;. Payment Sessions may have the status of &#x60;requires_more&#x60; to indicate that further actions are to be completed by the Customer.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    AUTHORIZED("authorized"),
    PENDING("pending"),
    REQUIRES_MORE("requires_more"),
    ERROR("error"),
    CANCELED("canceled");

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
  private StatusEnum status = null;

  @SerializedName("data")
  private Object data = null;

  @SerializedName("idempotency_key")
  private String idempotencyKey = null;

  @SerializedName("amount")
  private Integer amount = null;

  @SerializedName("payment_authorized_at")
  private OffsetDateTime paymentAuthorizedAt = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  public PaymentSession id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The payment session&#x27;s ID
   * @return id
  **/
  @Schema(example = "ps_01G901XNSRM2YS3ASN9H5KG3FZ", required = true, description = "The payment session's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PaymentSession cartId(String cartId) {
    this.cartId = cartId;
    return this;
  }

   /**
   * The id of the Cart that the Payment Session is created for.
   * @return cartId
  **/
  @Schema(example = "cart_01G8ZH853Y6TFXWPG5EYE81X63", required = true, description = "The id of the Cart that the Payment Session is created for.")
  public String getCartId() {
    return cartId;
  }

  public void setCartId(String cartId) {
    this.cartId = cartId;
  }

  public PaymentSession cart(Cart cart) {
    this.cart = cart;
    return this;
  }

   /**
   * Get cart
   * @return cart
  **/
  @Schema(description = "")
  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public PaymentSession providerId(String providerId) {
    this.providerId = providerId;
    return this;
  }

   /**
   * The id of the Payment Provider that is responsible for the Payment Session
   * @return providerId
  **/
  @Schema(example = "manual", required = true, description = "The id of the Payment Provider that is responsible for the Payment Session")
  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public PaymentSession isSelected(Boolean isSelected) {
    this.isSelected = isSelected;
    return this;
  }

   /**
   * A flag to indicate if the Payment Session has been selected as the method that will be used to complete the purchase.
   * @return isSelected
  **/
  @Schema(example = "true", required = true, description = "A flag to indicate if the Payment Session has been selected as the method that will be used to complete the purchase.")
  public Boolean isIsSelected() {
    return isSelected;
  }

  public void setIsSelected(Boolean isSelected) {
    this.isSelected = isSelected;
  }

  public PaymentSession isInitiated(Boolean isInitiated) {
    this.isInitiated = isInitiated;
    return this;
  }

   /**
   * A flag to indicate if a communication with the third party provider has been initiated.
   * @return isInitiated
  **/
  @Schema(example = "true", required = true, description = "A flag to indicate if a communication with the third party provider has been initiated.")
  public Boolean isIsInitiated() {
    return isInitiated;
  }

  public void setIsInitiated(Boolean isInitiated) {
    this.isInitiated = isInitiated;
  }

  public PaymentSession status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Indicates the status of the Payment Session. Will default to &#x60;pending&#x60;, and will eventually become &#x60;authorized&#x60;. Payment Sessions may have the status of &#x60;requires_more&#x60; to indicate that further actions are to be completed by the Customer.
   * @return status
  **/
  @Schema(example = "pending", required = true, description = "Indicates the status of the Payment Session. Will default to `pending`, and will eventually become `authorized`. Payment Sessions may have the status of `requires_more` to indicate that further actions are to be completed by the Customer.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public PaymentSession data(Object data) {
    this.data = data;
    return this;
  }

   /**
   * The data required for the Payment Provider to identify, modify and process the Payment Session. Typically this will be an object that holds an id to the external payment session, but can be an empty object if the Payment Provider doesn&#x27;t hold any state.
   * @return data
  **/
  @Schema(example = "{}", required = true, description = "The data required for the Payment Provider to identify, modify and process the Payment Session. Typically this will be an object that holds an id to the external payment session, but can be an empty object if the Payment Provider doesn't hold any state.")
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public PaymentSession idempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
    return this;
  }

   /**
   * Randomly generated key used to continue the completion of a cart in case of failure.
   * @return idempotencyKey
  **/
  @Schema(required = true, description = "Randomly generated key used to continue the completion of a cart in case of failure.")
  public String getIdempotencyKey() {
    return idempotencyKey;
  }

  public void setIdempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
  }

  public PaymentSession amount(Integer amount) {
    this.amount = amount;
    return this;
  }

   /**
   * The amount that the Payment Session has been authorized for.
   * @return amount
  **/
  @Schema(example = "100", required = true, description = "The amount that the Payment Session has been authorized for.")
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public PaymentSession paymentAuthorizedAt(OffsetDateTime paymentAuthorizedAt) {
    this.paymentAuthorizedAt = paymentAuthorizedAt;
    return this;
  }

   /**
   * The date with timezone at which the Payment Session was authorized.
   * @return paymentAuthorizedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the Payment Session was authorized.")
  public OffsetDateTime getPaymentAuthorizedAt() {
    return paymentAuthorizedAt;
  }

  public void setPaymentAuthorizedAt(OffsetDateTime paymentAuthorizedAt) {
    this.paymentAuthorizedAt = paymentAuthorizedAt;
  }

  public PaymentSession createdAt(OffsetDateTime createdAt) {
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

  public PaymentSession updatedAt(OffsetDateTime updatedAt) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentSession paymentSession = (PaymentSession) o;
    return Objects.equals(this.id, paymentSession.id) &&
        Objects.equals(this.cartId, paymentSession.cartId) &&
        Objects.equals(this.cart, paymentSession.cart) &&
        Objects.equals(this.providerId, paymentSession.providerId) &&
        Objects.equals(this.isSelected, paymentSession.isSelected) &&
        Objects.equals(this.isInitiated, paymentSession.isInitiated) &&
        Objects.equals(this.status, paymentSession.status) &&
        Objects.equals(this.data, paymentSession.data) &&
        Objects.equals(this.idempotencyKey, paymentSession.idempotencyKey) &&
        Objects.equals(this.amount, paymentSession.amount) &&
        Objects.equals(this.paymentAuthorizedAt, paymentSession.paymentAuthorizedAt) &&
        Objects.equals(this.createdAt, paymentSession.createdAt) &&
        Objects.equals(this.updatedAt, paymentSession.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cartId, cart, providerId, isSelected, isInitiated, status, data, idempotencyKey, amount, paymentAuthorizedAt, createdAt, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentSession {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cartId: ").append(toIndentedString(cartId)).append("\n");
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    isSelected: ").append(toIndentedString(isSelected)).append("\n");
    sb.append("    isInitiated: ").append(toIndentedString(isInitiated)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    idempotencyKey: ").append(toIndentedString(idempotencyKey)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    paymentAuthorizedAt: ").append(toIndentedString(paymentAuthorizedAt)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
