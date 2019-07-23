package leetcode._146_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        // LRUCache lruCache = new LRUCache(2);
        // lruCache.put(1, 1);
        // lruCache.put(2, 2);
        // System.out.println(lruCache.get(1));
        // lruCache.put(3, 3);
        // System.out.println(lruCache.get(2));
        // lruCache.put(4, 4);
        // System.out.println(lruCache.get(1));
        // System.out.println(lruCache.get(3));
        // System.out.println(lruCache.get(4));
        //
        //
        // System.out.println("------------");
        //
        // LRUCache lruCache2 = new LRUCache(2);
        // lruCache2.put(2, 1);
        // lruCache2.put(1, 1);
        // lruCache2.put(2, 3);
        // lruCache2.put(4, 1);
        // System.out.println(lruCache2.get(1));
        // System.out.println(lruCache2.get(2));
        //
        // System.out.println("------------");
        //
        // LRUCache lruCache3 = new LRUCache(2);
        // System.out.println(lruCache3.get(2));
        // lruCache3.put(2, 6);
        // System.out.println(lruCache3.get(1));
        // lruCache3.put(1, 5);
        // lruCache3.put(1, 2);
        // System.out.println(lruCache3.get(1));
        // System.out.println(lruCache3.get(2));
        //
        // System.out.println("------------");

        LRUCache lruCache4 = new LRUCache(3);
        lruCache4.put(1, 1);
        lruCache4.put(2, 2);
        lruCache4.put(3, 3);
        lruCache4.put(4, 4);
        System.out.println(lruCache4.get(4));
        System.out.println(lruCache4.get(3));
        System.out.println(lruCache4.get(2));
        System.out.println(lruCache4.get(1));
        lruCache4.put(5, 5);
        System.out.println(lruCache4.get(1));
        System.out.println(lruCache4.get(2));
        System.out.println(lruCache4.get(3));
        System.out.println(lruCache4.get(4));
        System.out.println(lruCache4.get(5));
    }
}

