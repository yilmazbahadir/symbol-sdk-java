/*
 * Copyright 2019 NEM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Catapult REST API Reference
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.7.15
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.nem.sdk.infrastructure.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import io.nem.sdk.infrastructure.model.SourceDTO;

/**
 * The collection of receipts related to a transaction.
 */
@ApiModel(description = "The collection of receipts related to a transaction.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-06-20T19:56:23.892+01:00[Europe/London]")
public class TransactionStatementDTO {
  public static final String SERIALIZED_NAME_HEIGHT = "height";
  @SerializedName(SERIALIZED_NAME_HEIGHT)
  private List<Integer> height = new ArrayList<Integer>();

  public static final String SERIALIZED_NAME_SOURCE = "source";
  @SerializedName(SERIALIZED_NAME_SOURCE)
  private SourceDTO source = null;

  public static final String SERIALIZED_NAME_RECEIPTS = "receipts";
  @SerializedName(SERIALIZED_NAME_RECEIPTS)
  private List<Object> receipts = new ArrayList<Object>();

  public TransactionStatementDTO height(List<Integer> height) {
    this.height = height;
    return this;
  }

  public TransactionStatementDTO addHeightItem(Integer heightItem) {
    this.height.add(heightItem);
    return this;
  }

   /**
   * Get height
   * @return height
  **/
  @ApiModelProperty(example = "[lower, higher]", required = true, value = "")
  public List<Integer> getHeight() {
    return height;
  }

  public void setHeight(List<Integer> height) {
    this.height = height;
  }

  public TransactionStatementDTO source(SourceDTO source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(required = true, value = "")
  public SourceDTO getSource() {
    return source;
  }

  public void setSource(SourceDTO source) {
    this.source = source;
  }

  public TransactionStatementDTO receipts(List<Object> receipts) {
    this.receipts = receipts;
    return this;
  }

  public TransactionStatementDTO addReceiptsItem(Object receiptsItem) {
    this.receipts.add(receiptsItem);
    return this;
  }

   /**
   * The array of receipts.
   * @return receipts
  **/
  @ApiModelProperty(required = true, value = "The array of receipts.")
  public List<Object> getReceipts() {
    return receipts;
  }

  public void setReceipts(List<Object> receipts) {
    this.receipts = receipts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionStatementDTO transactionStatementDTO = (TransactionStatementDTO) o;
    return Objects.equals(this.height, transactionStatementDTO.height) &&
        Objects.equals(this.source, transactionStatementDTO.source) &&
        Objects.equals(this.receipts, transactionStatementDTO.receipts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(height, source, receipts);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionStatementDTO {\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    receipts: ").append(toIndentedString(receipts)).append("\n");
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
