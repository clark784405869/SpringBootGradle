package org.gradle.repository;


import org.gradle.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

  @Query("SELECT i FROM item i WHERE i.checked=true")
  List<Item> findChecked();
  
  @Query("SELECT i FROM item i WHERE i.checked=true and i.id = ? and i.description = ?")
  List<Item> findCheckedById(String id,String description);
}
