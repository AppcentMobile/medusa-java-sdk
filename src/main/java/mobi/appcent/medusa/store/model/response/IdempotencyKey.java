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
import org.threeten.bp.OffsetDateTime;
/**
 * Idempotency Key is used to continue a process in case of any failure that might occur.
 */
@Schema(description = "Idempotency Key is used to continue a process in case of any failure that might occur.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class IdempotencyKey {
  @SerializedName("id")
  private String id = null;

  @SerializedName("idempotency_key")
  private String idempotencyKey = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("locked_at")
  private OffsetDateTime lockedAt = null;

  @SerializedName("request_method")
  private String requestMethod = null;

  @SerializedName("request_params")
  private Object requestParams = null;

  @SerializedName("request_path")
  private String requestPath = null;

  @SerializedName("response_code")
  private String responseCode = null;

  @SerializedName("response_body")
  private Object responseBody = null;

  @SerializedName("recovery_point")
  private String recoveryPoint = "started";

  public IdempotencyKey id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The idempotency key&#x27;s ID
   * @return id
  **/
  @Schema(example = "ikey_01G8X9A7ESKAJXG2H0E6F1MW7A", required = true, description = "The idempotency key's ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public IdempotencyKey idempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
    return this;
  }

   /**
   * The unique randomly generated key used to determine the state of a process.
   * @return idempotencyKey
  **/
  @Schema(required = true, description = "The unique randomly generated key used to determine the state of a process.")
  public String getIdempotencyKey() {
    return idempotencyKey;
  }

  public void setIdempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
  }

  public IdempotencyKey createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Date which the idempotency key was locked.
   * @return createdAt
  **/
  @Schema(required = true, description = "Date which the idempotency key was locked.")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public IdempotencyKey lockedAt(OffsetDateTime lockedAt) {
    this.lockedAt = lockedAt;
    return this;
  }

   /**
   * Date which the idempotency key was locked.
   * @return lockedAt
  **/
  @Schema(required = true, description = "Date which the idempotency key was locked.")
  public OffsetDateTime getLockedAt() {
    return lockedAt;
  }

  public void setLockedAt(OffsetDateTime lockedAt) {
    this.lockedAt = lockedAt;
  }

  public IdempotencyKey requestMethod(String requestMethod) {
    this.requestMethod = requestMethod;
    return this;
  }

   /**
   * The method of the request
   * @return requestMethod
  **/
  @Schema(example = "POST", required = true, description = "The method of the request")
  public String getRequestMethod() {
    return requestMethod;
  }

  public void setRequestMethod(String requestMethod) {
    this.requestMethod = requestMethod;
  }

  public IdempotencyKey requestParams(Object requestParams) {
    this.requestParams = requestParams;
    return this;
  }

   /**
   * The parameters passed to the request
   * @return requestParams
  **/
  @Schema(example = "{\"id\":\"cart_01G8ZH853Y6TFXWPG5EYE81X63\"}", required = true, description = "The parameters passed to the request")
  public Object getRequestParams() {
    return requestParams;
  }

  public void setRequestParams(Object requestParams) {
    this.requestParams = requestParams;
  }

  public IdempotencyKey requestPath(String requestPath) {
    this.requestPath = requestPath;
    return this;
  }

   /**
   * The request&#x27;s path
   * @return requestPath
  **/
  @Schema(example = "/store/carts/cart_01G8ZH853Y6TFXWPG5EYE81X63/complete", required = true, description = "The request's path")
  public String getRequestPath() {
    return requestPath;
  }

  public void setRequestPath(String requestPath) {
    this.requestPath = requestPath;
  }

  public IdempotencyKey responseCode(String responseCode) {
    this.responseCode = responseCode;
    return this;
  }

   /**
   * The response&#x27;s code.
   * @return responseCode
  **/
  @Schema(example = "200", required = true, description = "The response's code.")
  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  public IdempotencyKey responseBody(Object responseBody) {
    this.responseBody = responseBody;
    return this;
  }

   /**
   * The response&#x27;s body
   * @return responseBody
  **/
  @Schema(example = "{\"id\":\"cart_01G8ZH853Y6TFXWPG5EYE81X63\"}", required = true, description = "The response's body")
  public Object getResponseBody() {
    return responseBody;
  }

  public void setResponseBody(Object responseBody) {
    this.responseBody = responseBody;
  }

  public IdempotencyKey recoveryPoint(String recoveryPoint) {
    this.recoveryPoint = recoveryPoint;
    return this;
  }

   /**
   * Where to continue from.
   * @return recoveryPoint
  **/
  @Schema(required = true, description = "Where to continue from.")
  public String getRecoveryPoint() {
    return recoveryPoint;
  }

  public void setRecoveryPoint(String recoveryPoint) {
    this.recoveryPoint = recoveryPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdempotencyKey idempotencyKey = (IdempotencyKey) o;
    return Objects.equals(this.id, idempotencyKey.id) &&
        Objects.equals(this.idempotencyKey, idempotencyKey.idempotencyKey) &&
        Objects.equals(this.createdAt, idempotencyKey.createdAt) &&
        Objects.equals(this.lockedAt, idempotencyKey.lockedAt) &&
        Objects.equals(this.requestMethod, idempotencyKey.requestMethod) &&
        Objects.equals(this.requestParams, idempotencyKey.requestParams) &&
        Objects.equals(this.requestPath, idempotencyKey.requestPath) &&
        Objects.equals(this.responseCode, idempotencyKey.responseCode) &&
        Objects.equals(this.responseBody, idempotencyKey.responseBody) &&
        Objects.equals(this.recoveryPoint, idempotencyKey.recoveryPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idempotencyKey, createdAt, lockedAt, requestMethod, requestParams, requestPath, responseCode, responseBody, recoveryPoint);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdempotencyKey {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idempotencyKey: ").append(toIndentedString(idempotencyKey)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    lockedAt: ").append(toIndentedString(lockedAt)).append("\n");
    sb.append("    requestMethod: ").append(toIndentedString(requestMethod)).append("\n");
    sb.append("    requestParams: ").append(toIndentedString(requestParams)).append("\n");
    sb.append("    requestPath: ").append(toIndentedString(requestPath)).append("\n");
    sb.append("    responseCode: ").append(toIndentedString(responseCode)).append("\n");
    sb.append("    responseBody: ").append(toIndentedString(responseBody)).append("\n");
    sb.append("    recoveryPoint: ").append(toIndentedString(recoveryPoint)).append("\n");
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
