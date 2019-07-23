### [146\. LRU Cache](https://leetcode.com/problems/lru-cache/)

> 我使用双向循环链表和 hashtable 完成了，这里有一个小细节就是 put 的时候也是访问，需要将对应的 Node 提取到 head 上。

Difficulty: **Medium**


Design and implement a data structure for . It should support the following operations: `get` and `put`.

`get(key)` - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.  
`put(key, value)` - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a **positive** capacity.

**Follow up:**  
Could you do both operations in **O(1)** time complexity?

**Example:**

```
LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
```


#### Solution

Language: **Java**

```java
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
```
![](https://raw.githubusercontent.com/PicGoBed/PicBed/master/20190724010539.png)
