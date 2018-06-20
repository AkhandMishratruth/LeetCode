class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int l = s.length();
        ArrayList<String> ar = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        HashSet<String> temp = new HashSet<String>();
        for(int i = 0;i<=l-10;i++){
            String st = s.substring(i, i+10);
            if(set.contains(st) && !temp.contains(st)){
                ar.add(st);
                temp.add(st);
            }
            else{
                set.add(st);
            }
        }
        return ar;
    }
}
