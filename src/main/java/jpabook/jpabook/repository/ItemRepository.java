package jpabook.jpabook.repository;

import jpabook.jpabook.domain.Item.Item;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    Optional<Item> findById(Long itemId);

}
