package leetcode._49_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return resultList;
        }
        Map<String,Integer> groupsMap = new HashMap<>();
        // 这里的 key 需要是 String，而不能使用数组，如果使用数组的话，key是内存地址，无法满足要求。
        // value 存储的是这个组的字符串的 index
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars); // 排序后得到最新的字符串
            if (groupsMap.containsKey(s)) {
                resultList.get(groupsMap.get(s)).add(str);
                continue;
            }
            groupsMap.put(s,resultList.size());
            List<String> resultItem = new ArrayList<>();
            resultItem.add(str);
            resultList.add(resultItem);
        }
        return resultList;
    }
}