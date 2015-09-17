package ivanchan.leetcode.title242;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if(s == null || t == null){
        	return false;
        }
		if(s.length() != t.length()){
        	return false;
        }
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(char ch : s.toCharArray()){
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch)+ 1);
			}else{
				map.put(ch, 1);
			}
		}
		
		for(char ch : t.toCharArray()){
			if(map.get(ch) != null && map.get(ch) > 0){
				map.put(ch, map.get(ch) - 1);
			}else{
				return false;
			}
		}
		return true;
    }
	
	public static void main(String[] args){
		
		String s = "anagram", t = "nagaram";
		
		boolean result = new ValidAnagram().isAnagram(s, t);
		
		System.out.println(result);
	}
}
