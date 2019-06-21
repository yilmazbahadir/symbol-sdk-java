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
import io.nem.sdk.infrastructure.model.AccountPropertyTypeEnum;

/**
 * AccountPropertyDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-06-20T19:56:23.892+01:00[Europe/London]")
public class AccountPropertyDTO {
  public static final String SERIALIZED_NAME_PROPERTY_TYPE = "propertyType";
  @SerializedName(SERIALIZED_NAME_PROPERTY_TYPE)
  private AccountPropertyTypeEnum propertyType;

  public static final String SERIALIZED_NAME_VALUES = "values";
  @SerializedName(SERIALIZED_NAME_VALUES)
  private List<Object> values = new ArrayList<Object>();

  public AccountPropertyDTO propertyType(AccountPropertyTypeEnum propertyType) {
    this.propertyType = propertyType;
    return this;
  }

   /**
   * Get propertyType
   * @return propertyType
  **/
  @ApiModelProperty(required = true, value = "")
  public AccountPropertyTypeEnum getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(AccountPropertyTypeEnum propertyType) {
    this.propertyType = propertyType;
  }

  public AccountPropertyDTO values(List<Object> values) {
    this.values = values;
    return this;
  }

  public AccountPropertyDTO addValuesItem(Object valuesItem) {
    this.values.add(valuesItem);
    return this;
  }

   /**
   * The address, transaction type or mosaic id to filter.
   * @return values
  **/
  @ApiModelProperty(required = true, value = "The address, transaction type or mosaic id to filter.")
  public List<Object> getValues() {
    return values;
  }

  public void setValues(List<Object> values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountPropertyDTO accountPropertyDTO = (AccountPropertyDTO) o;
    return Objects.equals(this.propertyType, accountPropertyDTO.propertyType) &&
        Objects.equals(this.values, accountPropertyDTO.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyType, values);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountPropertyDTO {\n");
    sb.append("    propertyType: ").append(toIndentedString(propertyType)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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
