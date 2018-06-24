class Solution {
    public int reverse(int x) {
        boolean isNeg = (x<0?true:false);
        //System.out.println(x+" "+isNeg);
        if(x==Integer.MIN_VALUE)
            return 0;
        if(isNeg)
            x = Math.abs(x);
        StringBuilder sb = new StringBuilder(Integer.toString(x));
        String s = (isNeg?"-"+sb.reverse().toString(): sb.reverse().toString());
        System.out.println(s);
        long l = Long.parseLong(s);
        if(l<Integer.MIN_VALUE || l>Integer.MAX_VALUE)
            return 0;
        else
            return Integer.parseInt(s);
    }
}
