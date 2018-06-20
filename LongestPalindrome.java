class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int l = s.length();
        for(int i = 0; i<l; i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }
        boolean oddCount = false;
        int count = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if((entry.getValue())%2==0)
                count += entry.getValue();
            else{
                if(!oddCount){
                    count += entry.getValue();
                    oddCount = true;
                }
                else{
                    count += entry.getValue()-1;
                }
            }
        }
        return count;
    }
}
