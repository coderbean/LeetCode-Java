### [49\. group anagrams](https://leetcode.com/problems/group-anagrams/)

difficulty: **medium**


given an array of strings, group anagrams together.

**example:**

```
input: ["eat", "tea", "tan", "ate", "nat", "bat"],
output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

**note:**

*   all inputs will be in lowercase.
*   the order of your output does not matter.


#### solution

language: **java**

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return resultList;
        }
        Map<String,List<String>> groupsMap = new HashMap<>();
        // 这里的 key 需要是 String，而不能使用数组，如果使用数组的话，key是内存地址，无法满足要求。
        // value 存储的是这个组的字符串的 index
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars); // 排序后得到最新的字符串
            if (groupsMap.containsKey(s)) {
                groupsMap.get(s).add(str);
                continue;
            }
            List<String> resultItem = new ArrayList<>();
            groupsMap.put(s,resultItem);
            resultItem.add(str);
            resultList.add(resultItem);
        }
        return resultList;
    }
}
```
![](http://ww4.sinaimg.cn/large/006tNc79ly1g4tvny2r5uj31b60qiq7l.jpg)