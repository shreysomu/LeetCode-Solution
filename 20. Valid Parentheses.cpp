# Intuition
To determine if a string of parentheses is valid, we need to ensure every opening bracket has a matching closing bracket in the correct order. A stack is an ideal data structure for this because it allows us to keep track of the most recent unmatched opening bracket.

# Approach
1. Iterate through each character in the string.
2. If it's an opening bracket (`(`, `[`, or `{`), push it onto the stack.
3. If it's a closing bracket (`)`, `]`, or `}`):
   - Check if the stack is empty — if so, return `false` (nothing to match).
   - Otherwise, pop the top and check if it correctly matches the current closing bracket.
   - If it doesn’t match, return `false`.
4. After the loop, if the stack is not empty, return `false` (some brackets weren't closed).
5. If everything matches correctly, return `true`.

# Complexity
- **Time complexity:**  
  $$O(n)$$ — Each character in the string is processed once.

- **Space complexity:**  
  $$O(n)$$ — In the worst case (all opening brackets), we store `n` elements in the stack.


# Code
```cpp []
class Solution {
public:
    bool isValid(string s) {
        stack<char> st;

        for (char c : s) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.empty()) return false;
                char top = st.top();
                st.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return st.empty();
    }
};
```
