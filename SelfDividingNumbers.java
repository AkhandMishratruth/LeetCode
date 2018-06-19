class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i=left; i<=right; i++){
            if(isSelfDriving(i))
                ar.add(i);
        }
        return ar;
    }
    static boolean isSelfDriving(int n){
        int m = n;
        while(n!=0){
            if((n%10)==0 || m%(n%10)!=0){
                return false;
            }
            n = n/10;
        }
        return true;
    }
}
