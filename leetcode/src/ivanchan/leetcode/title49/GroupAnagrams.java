package ivanchan.leetcode.title49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        
        if(strs != null && strs.length > 0){
        	Map<String,Integer> map = new HashMap<String,Integer>(); 
        	Arrays.sort(strs);
        	int  grpNum = 0;
        	for(int i = 0; i < strs.length; i++){
        		char[] temp = strs[i].toCharArray();
        		Arrays.sort(temp);
        		String key = String.valueOf(temp);
        		if(map.containsKey(key)){
        			int grpIndex = map.get(key);
        			list.get(grpIndex).add(strs[i]);
        		}else{
        			map.put(key,grpNum++);
        			List<String> group = new ArrayList<String>();
        			group.add(strs[i]);
        			list.add(group);
        		}        		       		        		
        	}
        }                
        return list;
    }

}
