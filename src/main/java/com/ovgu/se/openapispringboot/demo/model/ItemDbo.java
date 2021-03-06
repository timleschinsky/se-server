package com.ovgu.se.openapispringboot.demo.model;

import io.swagger.models.auth.In;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class ItemDbo {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String name;

    private String description;

    private Double price;

    private Double tax;

    private LocalDate listedSince;

    private String manufacturer;

    public Item toItem() {
        return new Item()
                .id(id)
                .name(name)
                .price(price)
                .tax(tax)
                .listedSince(listedSince)
                .manufacturer(manufacturer)
                .description(description);
    }

    public ItemDbo(Item item) {
        name = item.getName();
        description = item.getDescription();
        price = item.getPrice();
        tax = item.getTax();
        listedSince = LocalDate.now();
        manufacturer = item.getManufacturer();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
