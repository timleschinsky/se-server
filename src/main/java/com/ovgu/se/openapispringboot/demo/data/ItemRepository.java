package com.ovgu.se.openapispringboot.demo.data;

import com.ovgu.se.openapispringboot.demo.model.ItemDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Transactional
public interface ItemRepository extends JpaRepository<ItemDbo, Integer> {

    @Query("SELECT i FROM ItemDbo i WHERE (:name is null or i.name = :name) and (:manufacturer is null"
            + " or i.manufacturer = :manufacturer) and (:description is null or i.description = :description)" +
            "and (:priceGe is null or i.price > :priceGe) and (:priceLe is null or i.price < :priceLe)")
    List<ItemDbo> findByNameAndManufacturerAndDescriptionAndPriceIsBetween(
            @Param("name") String name,
            @Param("manufacturer") String manufacturer,
            @Param("description") String description,
            @Param("priceGe") Double priceGe,
            @Param("priceLe") Double priceLe);
}
