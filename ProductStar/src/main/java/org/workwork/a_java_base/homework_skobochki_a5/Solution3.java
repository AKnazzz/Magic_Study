package org.workwork.a_java_base.homework_skobochki_a5;

import java.util.Stack;

public class Solution3 {
    public void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();
        String str = new String(s);
        for (int i = 0; i < str.length(); i++) {
            st.push(s[i]);
        }
        char ans[] = new char[s.length];
        int i = 0;
        while (st.size() > 0) {
            s[i++] = st.pop();
        }
        for (int j = 0; j < str.length(); j++) {
            ans[j] = str.charAt(j);
        }
    }
}
