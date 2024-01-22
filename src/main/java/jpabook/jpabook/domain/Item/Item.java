package jpabook.jpabook.domain.Item;

import jakarta.persistence.*;
import jpabook.jpabook.domain.Category;
import jpabook.jpabook.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // --- LOGIC
    /**
     * stock 증가
     */
    public  void addStock(int quantity){
        this.stockQuantity = quantity;
    }
    /**
     * stock감소
     */
     public void removeStock(int quantity){
         int restStock = this.stockQuantity - quantity;
         if(restStock < 0){
             throw new NotEnoughStockException("수량이 충분하지 않아요.");
         }
         this.stockQuantity=restStock;
     }




}
