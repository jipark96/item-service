package hello.itemservice.domain.item;


import lombok.Getter;
import lombok.Setter;

//@Data //getter, setter 다 포함 주의할 필요가 있음
@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
