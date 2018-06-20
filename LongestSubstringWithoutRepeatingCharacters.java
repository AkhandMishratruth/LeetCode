class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int min=0, max = 0;
        for(int i=0;i<l;i++){
            if(map.containsKey(s.charAt(i)))
                min = Math.max(map.get(s.charAt(i))+1, min);
            map.put(s.charAt(i), i);
            max = Math.max(max, i - min + 1);
        }
        return max;
    }
}
