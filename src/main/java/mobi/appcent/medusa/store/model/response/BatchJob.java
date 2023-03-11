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
import org.threeten.bp.OffsetDateTime;
/**
 * A Batch Job.
 */
@Schema(description = "A Batch Job.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2023-02-24T12:45:51.835798768Z[GMT]")
public class BatchJob {
  @SerializedName("id")
  private String id = null;

  /**
   * The type of batch job.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    IMPORT("product-import"),
    EXPORT("product-export");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static TypeEnum fromValue(String input) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return TypeEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("type")
  private TypeEnum type = null;

  /**
   * The status of the batch job.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    CREATED("created"),
    PRE_PROCESSED("pre_processed"),
    CONFIRMED("confirmed"),
    PROCESSING("processing"),
    COMPLETED("completed"),
    CANCELED("canceled"),
    FAILED("failed");

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
  private StatusEnum status = StatusEnum.CREATED;

  @SerializedName("created_by")
  private String createdBy = null;

  @SerializedName("created_by_user")
  private User createdByUser = null;

  @SerializedName("context")
  private Object context = null;

  @SerializedName("dry_run")
  private Boolean dryRun = false;

  @SerializedName("result")
  private AllOfBatchJobResult result = null;

  @SerializedName("pre_processed_at")
  private OffsetDateTime preProcessedAt = null;

  @SerializedName("processing_at")
  private OffsetDateTime processingAt = null;

  @SerializedName("confirmed_at")
  private OffsetDateTime confirmedAt = null;

  @SerializedName("completed_at")
  private OffsetDateTime completedAt = null;

  @SerializedName("canceled_at")
  private OffsetDateTime canceledAt = null;

  @SerializedName("failed_at")
  private OffsetDateTime failedAt = null;

  @SerializedName("created_at")
  private OffsetDateTime createdAt = null;

  @SerializedName("updated_at")
  private OffsetDateTime updatedAt = null;

  @SerializedName("deleted_at")
  private OffsetDateTime deletedAt = null;

  public BatchJob id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The unique identifier for the batch job.
   * @return id
  **/
  @Schema(example = "batch_01G8T782965PYFG0751G0Z38B4", required = true, description = "The unique identifier for the batch job.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BatchJob type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The type of batch job.
   * @return type
  **/
  @Schema(required = true, description = "The type of batch job.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public BatchJob status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * The status of the batch job.
   * @return status
  **/
  @Schema(required = true, description = "The status of the batch job.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public BatchJob createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

   /**
   * The unique identifier of the user that created the batch job.
   * @return createdBy
  **/
  @Schema(example = "usr_01G1G5V26F5TB3GPAPNJ8X1S3V", required = true, description = "The unique identifier of the user that created the batch job.")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public BatchJob createdByUser(User createdByUser) {
    this.createdByUser = createdByUser;
    return this;
  }

   /**
   * Get createdByUser
   * @return createdByUser
  **/
  @Schema(description = "")
  public User getCreatedByUser() {
    return createdByUser;
  }

  public void setCreatedByUser(User createdByUser) {
    this.createdByUser = createdByUser;
  }

  public BatchJob context(Object context) {
    this.context = context;
    return this;
  }

   /**
   * The context of the batch job, the type of the batch job determines what the context should contain.
   * @return context
  **/
  @Schema(example = "{\"shape\":{\"prices\":[{\"currency_code\":\"eur\"}],\"dynamicImageColumnCount\":4,\"dynamicOptionColumnCount\":2},\"list_config\":{\"skip\":0,\"take\":50,\"order\":{\"created_at\":\"DESC\"},\"relations\":[\"variants\",\"variant.prices\",\"images\"]}}", required = true, description = "The context of the batch job, the type of the batch job determines what the context should contain.")
  public Object getContext() {
    return context;
  }

  public void setContext(Object context) {
    this.context = context;
  }

  public BatchJob dryRun(Boolean dryRun) {
    this.dryRun = dryRun;
    return this;
  }

   /**
   * Specify if the job must apply the modifications or not.
   * @return dryRun
  **/
  @Schema(required = true, description = "Specify if the job must apply the modifications or not.")
  public Boolean isDryRun() {
    return dryRun;
  }

  public void setDryRun(Boolean dryRun) {
    this.dryRun = dryRun;
  }

  public BatchJob result(AllOfBatchJobResult result) {
    this.result = result;
    return this;
  }

   /**
   * The result of the batch job.
   * @return result
  **/
  @Schema(example = "{\"errors\":[{\"err\":[],\"code\":\"unknown\",\"message\":\"Method not implemented.\"}],\"stat_descriptors\":[{\"key\":\"product-export-count\",\"name\":\"Product count to export\",\"message\":\"There will be 8 products exported by this action\"}]}", required = true, description = "The result of the batch job.")
  public AllOfBatchJobResult getResult() {
    return result;
  }

  public void setResult(AllOfBatchJobResult result) {
    this.result = result;
  }

  public BatchJob preProcessedAt(OffsetDateTime preProcessedAt) {
    this.preProcessedAt = preProcessedAt;
    return this;
  }

   /**
   * The date from which the job has been pre-processed.
   * @return preProcessedAt
  **/
  @Schema(required = true, description = "The date from which the job has been pre-processed.")
  public OffsetDateTime getPreProcessedAt() {
    return preProcessedAt;
  }

  public void setPreProcessedAt(OffsetDateTime preProcessedAt) {
    this.preProcessedAt = preProcessedAt;
  }

  public BatchJob processingAt(OffsetDateTime processingAt) {
    this.processingAt = processingAt;
    return this;
  }

   /**
   * The date the job is processing at.
   * @return processingAt
  **/
  @Schema(required = true, description = "The date the job is processing at.")
  public OffsetDateTime getProcessingAt() {
    return processingAt;
  }

  public void setProcessingAt(OffsetDateTime processingAt) {
    this.processingAt = processingAt;
  }

  public BatchJob confirmedAt(OffsetDateTime confirmedAt) {
    this.confirmedAt = confirmedAt;
    return this;
  }

   /**
   * The date when the confirmation has been done.
   * @return confirmedAt
  **/
  @Schema(required = true, description = "The date when the confirmation has been done.")
  public OffsetDateTime getConfirmedAt() {
    return confirmedAt;
  }

  public void setConfirmedAt(OffsetDateTime confirmedAt) {
    this.confirmedAt = confirmedAt;
  }

  public BatchJob completedAt(OffsetDateTime completedAt) {
    this.completedAt = completedAt;
    return this;
  }

   /**
   * The date of the completion.
   * @return completedAt
  **/
  @Schema(required = true, description = "The date of the completion.")
  public OffsetDateTime getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(OffsetDateTime completedAt) {
    this.completedAt = completedAt;
  }

  public BatchJob canceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
    return this;
  }

   /**
   * The date of the concellation.
   * @return canceledAt
  **/
  @Schema(required = true, description = "The date of the concellation.")
  public OffsetDateTime getCanceledAt() {
    return canceledAt;
  }

  public void setCanceledAt(OffsetDateTime canceledAt) {
    this.canceledAt = canceledAt;
  }

  public BatchJob failedAt(OffsetDateTime failedAt) {
    this.failedAt = failedAt;
    return this;
  }

   /**
   * The date when the job failed.
   * @return failedAt
  **/
  @Schema(required = true, description = "The date when the job failed.")
  public OffsetDateTime getFailedAt() {
    return failedAt;
  }

  public void setFailedAt(OffsetDateTime failedAt) {
    this.failedAt = failedAt;
  }

  public BatchJob createdAt(OffsetDateTime createdAt) {
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

  public BatchJob updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * The date with timezone at which the resource was last updated.
   * @return updatedAt
  **/
  @Schema(required = true, description = "The date with timezone at which the resource was last updated.")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public BatchJob deletedAt(OffsetDateTime deletedAt) {
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
    BatchJob batchJob = (BatchJob) o;
    return Objects.equals(this.id, batchJob.id) &&
        Objects.equals(this.type, batchJob.type) &&
        Objects.equals(this.status, batchJob.status) &&
        Objects.equals(this.createdBy, batchJob.createdBy) &&
        Objects.equals(this.createdByUser, batchJob.createdByUser) &&
        Objects.equals(this.context, batchJob.context) &&
        Objects.equals(this.dryRun, batchJob.dryRun) &&
        Objects.equals(this.result, batchJob.result) &&
        Objects.equals(this.preProcessedAt, batchJob.preProcessedAt) &&
        Objects.equals(this.processingAt, batchJob.processingAt) &&
        Objects.equals(this.confirmedAt, batchJob.confirmedAt) &&
        Objects.equals(this.completedAt, batchJob.completedAt) &&
        Objects.equals(this.canceledAt, batchJob.canceledAt) &&
        Objects.equals(this.failedAt, batchJob.failedAt) &&
        Objects.equals(this.createdAt, batchJob.createdAt) &&
        Objects.equals(this.updatedAt, batchJob.updatedAt) &&
        Objects.equals(this.deletedAt, batchJob.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, status, createdBy, createdByUser, context, dryRun, result, preProcessedAt, processingAt, confirmedAt, completedAt, canceledAt, failedAt, createdAt, updatedAt, deletedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchJob {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdByUser: ").append(toIndentedString(createdByUser)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    dryRun: ").append(toIndentedString(dryRun)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    preProcessedAt: ").append(toIndentedString(preProcessedAt)).append("\n");
    sb.append("    processingAt: ").append(toIndentedString(processingAt)).append("\n");
    sb.append("    confirmedAt: ").append(toIndentedString(confirmedAt)).append("\n");
    sb.append("    completedAt: ").append(toIndentedString(completedAt)).append("\n");
    sb.append("    canceledAt: ").append(toIndentedString(canceledAt)).append("\n");
    sb.append("    failedAt: ").append(toIndentedString(failedAt)).append("\n");
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
