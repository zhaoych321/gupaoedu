package suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {
	public static boolean isValidSudoku(char[][] board) {
        //数据存放map中 key是行 或者 列 或者 是 第几个九宫格 value是 具体数字


        Map<Integer, Integer> rows = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cols = new HashMap<Integer, Integer>();
        Map<Integer, HashSet<Integer>> block = new HashMap<>();

        for (int i = 0; i < 9; ++ i) {
            for (int j = 0; j < 9; ++ j) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                int blockIdx = i / 3 * 3 + j / 3;
                if (rows.get(i)!=null || cols.get(j)!=null || (block.get(blockIdx) != null && block.get(blockIdx).contains(num))) {
                    return false;
                } else {
                    rows.put(i, num);
                    cols.put(j, num);
                    HashSet<Integer> set = block.get(blockIdx);
                    if (set == null) {
                        set = new HashSet<Integer>();
                        block.put(blockIdx, set);
                    }

                    set.add(num);
                }
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
//		char [][] cs ={{'5','3','.','.','7','.','.','.','.'},
//						{'6','.','.','1','9','5','.','.','.'},
//						{'.','9','8','.','.','.','.','6','.'},
//						{'8','.','.','.','6','.','.','.','3'},
//						{'4','.','.','8','.','3','.','.','1'},
//						{'7','.','.','.','2','.','.','.','6'},
//						{'.','6','.','.','.','.','2','8','.'},
//						{'.','.','.','4','1','9','.','.','5'},
//						{'.','.','.','.','8','.','.','7','9'}};
//		System.out.println("============ is " + isValidSudoku(cs));
		
		String [] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
	}
	
	
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) 
            	map.put(key, new ArrayList<>());
            map.get(key).add(s);
            System.out.println("str = " + s + " key = " + key + " value = " + map.get(key));
        }
        return new ArrayList(map.values());
    }
}
