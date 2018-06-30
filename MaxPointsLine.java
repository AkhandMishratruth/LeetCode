/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] po) {
        if(po.length==0)
            return 0;
        if(po.length==1)
            return 1;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int result=0;
        for(int i=0;i<po.length; i++){
            map.clear();
            int max = 0, overlap = 0;
            for(int j = i+1; j<po.length; j++){
                int x = po[i].x - po[j].x;
                int y = po[i].y - po[j].y;
                if(x==0 && y==0){
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x, y);
                if(gcd!=0){
                    x/=gcd;
                    y/=gcd;
                }
                if (map.containsKey(x)){
        				if (map.get(x).containsKey(y)){
        					map.get(x).put(y, map.get(x).get(y)+1);
        				}else{
        					map.get(x).put(y, 1);
        				}   					
        		}else{
        			Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        			m.put(y, 1);
        			map.put(x, m);
        		}
                max=Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max+overlap+1);
        }
        //System.out.println(result);
        return result;
    }
    private int generateGCD(int a,int b){
        if (b==0) return a;
        else return generateGCD(b,a%b);	
    }
}
