class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length()==0)
            return false;
        if(s.startsWith("e") || s.endsWith("e"))
            return false;
        String[] ar = s.split("e");
        if(ar.length==1)
            return isValidFirst(ar[0]);
        if(ar.length==2)
            return isValidFirst(ar[0]) && isValidSecond(ar[1]);
        else
            return false;
    }
    static boolean isValidFirst(String s){
        int l = s.length();
        if((s.startsWith("+") || s.startsWith("-")) && l>1){   
            s = s.substring(1, l);
            l--;
        }
        if(l==1){
            if(Character.isDigit(s.charAt(0)))
                return true;
            else 
                return false;
        }
        boolean isDecDiscovered = false;
        for(int i=0;i<l;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c) || (c=='.' && !isDecDiscovered)){
                if(c=='.')
                    isDecDiscovered = true;
            }
            else
                return false;
        }
        return true;
    }
    static boolean isValidSecond(String s){
        int l = s.length();
        if((s.startsWith("+") || s.startsWith("-")) && l>1){
            s = s.substring(1, l);
            l--;
        }
        
        for(int i=0;i<l;i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
