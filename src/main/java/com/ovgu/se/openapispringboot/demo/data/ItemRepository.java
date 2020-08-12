package com.ovgu.se.openapispringboot.demo.data;

import com.ovgu.se.openapispringboot.demo.model.ItemDbo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ItemRepository extends JpaRepository<ItemDbo, Integer> {
}
