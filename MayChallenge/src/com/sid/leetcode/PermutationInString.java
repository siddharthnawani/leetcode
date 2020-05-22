package com.sid.leetcode;

import java.util.HashMap;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character,Integer> c=new HashMap<>(26);

        for(Character a:s2.toCharArray()){
            int v=c.getOrDefault(a,0);
            c.put(a,++v);
        }

        for(Character a:s1.toCharArray()){
            int v=c.getOrDefault(a,-1);
            if(v<=0)
                return Boolean.FALSE;
            else{
                c.put(a,--v);
            }

        }
        return Boolean.TRUE;

    }
}
