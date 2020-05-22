package com.sid.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        Set<Integer> a=new HashSet<>();
        
        for(int i=0;i<s.length();i++){
            for(int j=i;(j+p.length() <=s.length());j++ ){
                String sub=s.substring(j,j+p.length());
                if(checkAnagram(sub,p))
                    a.add(j);
            }
        }
        return new ArrayList<Integer>(a);

    }
    private static int CHARACTER_RANGE= 256;

    public boolean checkAnagram(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        int count[] = new int[CHARACTER_RANGE];
        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i)]++;
            count[string2.charAt(i)]--;
        }
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s= "abab", p= "ab";
        System.out.println(new FindAllAnagramsInAString().findAnagrams(s,p));
    }


}
