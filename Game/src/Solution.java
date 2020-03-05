import java.util.HashMap;
import java.util.Map;

class Solution {
	public static void main(String[] args) {
		int[] nums = {0,1,0,1};
		System.out.println(findMaxLength(nums));
	}
	public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ones = 0, zeros = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            int j = i + 1;
            if (nums[i] + nums[j] == 1) {
                sum += 2;
                Integer count = map.get(i);
                if (null == count) {
                    if (nums[i] == 0) {
                        zeros ++;
                    } else {
                        ones ++;
                    }
                }
                map.put(i, nums[i]);

                count = map.get(j);
                if (null == count) {
                    if (nums[j] == 0) {
                        zeros ++;
                    } else {
                        ones ++;
                    }
                }
                map.put(j, nums[j]);
            }
        }

        return zeros == ones ? sum : Math.min(sum,Math.max(zeros, ones));
    }
	
//	public static void main(String[] args) {
//		String[] words = {"cat","bt","hat","tree"};
//		String chars = "atach";
//		System.out.println(countCharacters(words, chars));
//	}
//	
//    private static boolean isCount(String src, String des) {
//        int[] count = new int[26];
//        char[] chars = src.toCharArray();
//
//        for (char c : chars)
//            count[c - 'a']++;
//
//        chars = des.toCharArray();
//        for (char c : chars)
//            count[c - 'a']--;
//
//        for (int i : count) {
//            if (i < 0) 
//                return false;
//        }
//
//        return true;
//    }
//
//    public static int countCharacters(String[] words, String chars) {
//        int length = 0;
//
//        for (String w : words) {
//            if (isCount(chars, w))
//                length += w.length();
//        }
//
//        return length;
//    }


//    public static int countCharacters(String[] words, String chars) {
//       List<CharInfo> list = new ArrayList<>();
//       
//
//        int size = 0;
//        for (String str : words) {
//        	for (char c : chars.toCharArray()) {
//                list.add(new CharInfo(c, false));
//            }
//            int length = 0;
//            char[] cs = str.toCharArray();
//            for (char c : cs) {
//                for (CharInfo info : list) {
//                    if(info.trySet(c)) {
//                        length ++;
//                        break;
//                    }
//                }
//            }
//
//            if (cs.length == length) {
//                size += length;
//            }
//        }
//        
//        return size;
//    }
//
//    public static class CharInfo {
//        private char c;
//        private boolean b;
//
//        public CharInfo(char c, boolean b) {
//            this.c = c;
//            this.b = b;
//        }
//
//        public boolean trySet(char tmp) {
//            if (c == tmp && !b) {
//                b = true;
//                return true;
//            }
//            return false;
//        }
//    }
}
