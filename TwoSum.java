class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        int[] r = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && i!=map.get(target-nums[i])){
                r[0] = i;
                r[1] = map.get(target-nums[i]);        
                return r;
            }
        }
        return r;
    }
}
