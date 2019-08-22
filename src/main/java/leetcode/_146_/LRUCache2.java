package leetcode._146_;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhangbo54 on 2019-07-23.
 */
class LRUCache2<K, V> extends LinkedHashMap<K, V> {

    private int maxSize;

    public LRUCache2(int maxSize) {
        // 第三个参数表示是否按照访问顺序组织链表
        super(maxSize, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > maxSize;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */