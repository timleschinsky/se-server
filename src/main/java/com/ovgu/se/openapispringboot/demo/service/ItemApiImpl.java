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

@Service
public class ItemApiImpl implements ItemApiDelegate {

    private ItemRepository itemRepository;
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
        log.info("ID: ", id);
        ItemDbo itemDbo = itemRepository.findById(id).orElseThrow();
        itemRepository.delete(itemDbo);
        log.info("Item deleted");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Item> getItem(Integer id) {
        log.info("Item get");
        ItemDbo itemDbo = itemRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(itemDbo.toItem());
    }

    @Override
    public ResponseEntity<List<Item>> getItems(String name, String manufacturer, String listedStarting, String listedEnding, String description, BigDecimal priceGe, BigDecimal priceLe) {
        log.info("Items get");
        List<ItemDbo> itemDboList = new ArrayList<>();
        List<Item> itemList = new ArrayList<>();
        
        itemDboList = itemRepository.findAll();
        for (ItemDbo item : itemDboList) {
            itemList.add(item.toItem());
        }
        return ResponseEntity.ok(itemList);
    }

    @Override
    public ResponseEntity<Item> updateItem(Integer id, Item item) {
        log.info("Item updated");
        ItemDbo itemDbo = itemRepository.findById(id).orElseThrow();
        ItemDbo saveItem = new ItemDbo(item);
        saveItem = itemRepository.save(saveItem);
        saveItem.setId(id);
        //itemDbo = new ItemDbo(item);
        return ResponseEntity.ok(saveItem.toItem());
    }
}
