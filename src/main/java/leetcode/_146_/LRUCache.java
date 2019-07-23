package leetcode._146_;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangbo54 on 2019-07-23.
 */
class LRUCache {

    class LRUValue {
        int key;
        int value;
        LRUValue next; //链表下一个节点的key
        LRUValue pre;// 链表上一个节点的key

        public LRUValue(int key, int value, LRUValue next, LRUValue pre) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }

    private Map<Integer, LRUValue> map = new HashMap<>();
    private int capacity;
    private LRUValue head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            LRUValue lruValue = map.get(key);
            if (lruValue != head) { // 如果获取的元素不是在头部，需要将该元素升级到头部
                promotionNode(lruValue);
            }
            return head.value;
        }
    }

    public void put(int key, int value) {
        if (map.size() == 0) {
            LRUValue lruValue = new LRUValue(key, value, null, null);
            lruValue.next = lruValue;
            lruValue.pre = lruValue;
            head = lruValue;
            map.put(key, lruValue);
        } else {
            LRUValue targetValue = map.get(key);
            if (targetValue != null) {// 注意 put 也算是访问，需要把它提到 header
                if (targetValue != head) {
                    promotionNode(targetValue);
                }
                targetValue.value = value;
            } else {
                if (map.size() >= capacity) {
                    int removeKey = head.pre.key;
                    head.pre = head.pre.pre;
                    map.remove(removeKey);
                }
                LRUValue lruValue = new LRUValue(key, value, head, head.pre);
                map.put(key, lruValue);
                head.pre.next = lruValue;
                head.pre = lruValue;
                head = lruValue;
            }
        }
    }

    private void promotionNode(LRUValue lruValue) {
        lruValue.pre.next = lruValue.next;
        lruValue.next.pre = lruValue.pre;
        head.pre.next = lruValue;
        lruValue.next = head;
        lruValue.pre = head.pre;
        head.pre = lruValue;
        head = lruValue;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */