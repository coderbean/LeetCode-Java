package leetcode._71_;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> strings = new LinkedList<>(); // 使用双端队列
        for (String s : split) {
            if (!s.equals("") && !s.equals(".")) {
                if (s.equals("..")) {
                    if (!strings.isEmpty()) {
                        strings.pop(); // 双端队列可以用作栈，返回上一层目录
                    }
                } else {
                    strings.push(s); // 双端队列压栈写入头部元素
                }
            }
        }
        if (strings.isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!strings.isEmpty()) {
            stringBuilder.append("/");
            stringBuilder.append(strings.pollLast()); // 出尾部元素
        }
        return stringBuilder.toString();
    }
}