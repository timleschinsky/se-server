package com.ovgu.se.openapispringboot.demo.service;

import com.ovgu.se.openapispringboot.demo.data.ItemRepository;
import com.ovgu.se.openapispringboot.demo.api.ItemApiDelegate;
import com.ovgu.se.openapispringboot.demo.model.Item;
import com.ovgu.se.openapispringboot.demo.model.ItemDbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemApiImpl implements ItemApiDelegate {

    private final ItemRepository itemRepository;
    private final Logger log = LoggerFactory.getLogger(ItemApiImpl.class);

    @Autowired
    public ItemApiImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ResponseEntity<Item> createItem(Item item) {
        ItemDbo savedItem = new ItemDbo(item);
        savedItem = itemRepository.save(savedItem);
        log.info("Item posted");
        return ResponseEntity.ok(savedItem.toItem());
    }

    @Override
    public ResponseEntity<Void> deleteItem(Integer id) {
        log.info("ID: {} will be deleted", id);
        ItemDbo itemDbo = itemRepository.findById(id).orElseThrow();
        itemRepository.delete(itemDbo);
        log.info("Item deleted");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Item> getItem(Integer id) {
        log.info("Item {} get", id);
        ItemDbo itemDbo = itemRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(itemDbo.toItem());
    }

    @Override
    public ResponseEntity<List<Item>> getItems(String name, String manufacturer, String description, Double priceGe, Double priceLe) {
        log.info("Items get");
        List<Item> itemList = itemRepository
                .findByNameAndManufacturerAndDescriptionAndPriceIsBetween(name, manufacturer, description, priceGe, priceLe)
                .parallelStream()
                .map(ItemDbo::toItem).collect(Collectors.toUnmodifiableList());
        return ResponseEntity.ok(itemList);
    }

    @Override
    public ResponseEntity<Item> updateItem(Integer id, Item item) {
        log.info("Item {} updating", id);
        ItemDbo itemDbo = itemRepository.findById(id).orElseThrow();
        itemDbo.setDescription(item.getDescription());
        itemDbo.setManufacturer(item.getManufacturer());
        itemDbo.setName(item.getName());
        itemDbo.setTax(item.getTax());
        itemDbo.setPrice(item.getPrice());
        itemDbo = itemRepository.save(itemDbo);
        log.info("Item updated");
        return ResponseEntity.ok(itemDbo.toItem());
    }
}
