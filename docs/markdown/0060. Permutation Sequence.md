### [60\. Permutation Sequence](https://leetcode.com/problems/permutation-sequence/)

Difficulty: **Medium**


The set `[1,2,3,...,_n_]` contains a total of _n_! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for _n_ = 3:

1.  `"123"`
2.  `"132"`
3.  `"213"`
4.  `"231"`
5.  `"312"`
6.  `"321"`

Given _n_ and _k_, return the _k_<sup>th</sup> permutation sequence.

**Note:**

*   Given _n_ will be between 1 and 9 inclusive.
*   Given _k_ will be between 1 and _n_! inclusive.

**Example 1:**

```
Input: n = 3, k = 3
Output: "213"
```

**Example 2:**

```
Input: n = 4, k = 9
Output: "2314"
```


#### Solution

Language: **Java**

```java
class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        List<Integer> leftNumList = new ArrayList<>();
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            leftNumList.add(i);
            sum *= i;
            factorial[i] = sum;
        }
        StringBuilder stringBuilder = new StringBuilder();
        k--; // Amazing k--
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            k = k % factorial[n - i];
            stringBuilder.append(leftNumList.get(index));
            leftNumList.remove(index);
        }
        return stringBuilder.toString();
    }
}
```
![](http://ww1.sinaimg.cn/large/006tNc79gy1g4zps9z05tj31b40rwjwa.jpg)