### [71\. Simplify Path](https://leetcode.com/problems/simplify-path/)

Difficulty: **Medium**


Given an **absolute path** for a file (Unix-style), simplify it. Or in other words, convert it to the **canonical path**.

In a UNIX-style file system, a period `.` refers to the current directory. Furthermore, a double period `..` moves the directory up a level. For more information, see: 

Note that the returned canonical path must always begin with a slash `/`, and there must be only a single slash `/` between two directory names. The last directory name (if it exists) **must not** end with a trailing `/`. Also, the canonical path must be the **shortest** string representing the absolute path.

**Example 1:**

```
Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
```

**Example 2:**

```
Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
```

**Example 3:**

```
Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
```

**Example 4:**

```
Input: "/a/./b/../../c/"
Output: "/c"
```

**Example 5:**

```
Input: "/a/../../b/../c//.//"
Output: "/c"
```

**Example 6:**

```
Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
```


#### Solution

Language: **Java**

```java
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
```
![](https://raw.githubusercontent.com/PicGoBed/PicBed/master/20190721232339.png)