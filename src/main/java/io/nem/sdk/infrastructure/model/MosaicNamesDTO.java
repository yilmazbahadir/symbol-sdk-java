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

/**
 * MosaicNamesDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-06-20T19:56:23.892+01:00[Europe/London]")
public class MosaicNamesDTO {
  public static final String SERIALIZED_NAME_MOSAIC_ID = "mosaicId";
  @SerializedName(SERIALIZED_NAME_MOSAIC_ID)
  private List<Integer> mosaicId = new ArrayList<Integer>();

  public static final String SERIALIZED_NAME_NAMES = "names";
  @SerializedName(SERIALIZED_NAME_NAMES)
  private List<String> names = new ArrayList<String>();

  public MosaicNamesDTO mosaicId(List<Integer> mosaicId) {
    this.mosaicId = mosaicId;
    return this;
  }

  public MosaicNamesDTO addMosaicIdItem(Integer mosaicIdItem) {
    this.mosaicId.add(mosaicIdItem);
    return this;
  }

   /**
   * Get mosaicId
   * @return mosaicId
  **/
  @ApiModelProperty(example = "[lower, higher]", required = true, value = "")
  public List<Integer> getMosaicId() {
    return mosaicId;
  }

  public void setMosaicId(List<Integer> mosaicId) {
    this.mosaicId = mosaicId;
  }

  public MosaicNamesDTO names(List<String> names) {
    this.names = names;
    return this;
  }

  public MosaicNamesDTO addNamesItem(String namesItem) {
    this.names.add(namesItem);
    return this;
  }

   /**
   * The mosaic linked namespace names.
   * @return names
  **/
  @ApiModelProperty(example = "[cat.currency]", required = true, value = "The mosaic linked namespace names.")
  public List<String> getNames() {
    return names;
  }

  public void setNames(List<String> names) {
    this.names = names;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MosaicNamesDTO mosaicNamesDTO = (MosaicNamesDTO) o;
    return Objects.equals(this.mosaicId, mosaicNamesDTO.mosaicId) &&
        Objects.equals(this.names, mosaicNamesDTO.names);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mosaicId, names);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MosaicNamesDTO {\n");
    sb.append("    mosaicId: ").append(toIndentedString(mosaicId)).append("\n");
    sb.append("    names: ").append(toIndentedString(names)).append("\n");
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

