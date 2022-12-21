package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ItemRepository { // ctrl + Shift + t 바로 테스트 만들기

    private static final Map<Long, Item> store = new HashMap<>(); //static, 실무에서는 멀티스레드이기 때문에 HashMap대신 ConcurrentHashMap<>() 사용
    private static long sequence = 0L; //static, 실무에서는 어토미 등 사용

    // [상품 저장]
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    //[조회]
    public Item findById(Long id) {
        return store.get(id);
    }

    //[전체 조회]
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    //[수정]
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }
    //[삭제]
    public void clearStore() {
        store.clear();
    }
}
