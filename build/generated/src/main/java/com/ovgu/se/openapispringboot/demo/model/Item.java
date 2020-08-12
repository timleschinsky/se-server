package com.ovgu.se.openapispringboot.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Item
 */

public class Item   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("tax")
  private Double tax;

  @JsonProperty("listed_since")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate listedSince;

  @JsonProperty("manufacturer")
  private String manufacturer;

  public Item id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(readOnly = true, value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Item name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Size(max=25) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Item description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Item price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * minimum: 0.0
   * @return price
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@DecimalMin("0.0")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Item tax(Double tax) {
    this.tax = tax;
    return this;
  }

  /**
   * Get tax
   * minimum: 0.0
   * @return tax
  */
  @ApiModelProperty(value = "")

@DecimalMin("0.0")
  public Double getTax() {
    return tax;
  }

  public void setTax(Double tax) {
    this.tax = tax;
  }

  public Item listedSince(LocalDate listedSince) {
    this.listedSince = listedSince;
    return this;
  }

  /**
   * Get listedSince
   * @return listedSince
  */
  @ApiModelProperty(readOnly = true, value = "")

  @Valid

  public LocalDate getListedSince() {
    return listedSince;
  }

  public void setListedSince(LocalDate listedSince) {
    this.listedSince = listedSince;
  }

  public Item manufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

  /**
   * Get manufacturer
   * @return manufacturer
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(this.id, item.id) &&
        Objects.equals(this.name, item.name) &&
        Objects.equals(this.description, item.description) &&
        Objects.equals(this.price, item.price) &&
        Objects.equals(this.tax, item.tax) &&
        Objects.equals(this.listedSince, item.listedSince) &&
        Objects.equals(this.manufacturer, item.manufacturer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, price, tax, listedSince, manufacturer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Item {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    tax: ").append(toIndentedString(tax)).append("\n");
    sb.append("    listedSince: ").append(toIndentedString(listedSince)).append("\n");
    sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
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

