package com.leetcode.algorithms;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {

        int start = s.length();
        int end = p.length();

        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()) return result;

        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> pCount = new HashMap<>();

        for(char ch : p.toCharArray()){
            if(pCount.containsKey(ch)){
                pCount.put(ch, pCount.getOrDefault(ch, 0)+1);
            }else{
                pCount.put(ch, 1);
            }
        }

        for(int  i = 0; i < start ; i++){
            char ch = s.charAt(i);
            if(sCount.containsKey(ch)){
                sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);
            }else{
                sCount.put(ch, 1);
            }
            if(i>=p.length()){
                ch = s.charAt(i - p.length());
                if(sCount.get(ch) == 1){
                    sCount.remove(ch);
                }else{
                    sCount.put(ch, sCount.get(ch) - 1);
                }

            }
            if(pCount.equals(sCount)){
                result.add(i - end+1);

            }

        }
        return result;
        
    }

    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";

        System.out.print(findAnagrams(s, p));
    }

    
}