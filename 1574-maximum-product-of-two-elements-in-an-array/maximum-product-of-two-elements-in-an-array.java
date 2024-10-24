class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b -a);
        for(int num : nums){
            maxHeap.add(num-1);
        }
        return maxHeap.poll()*maxHeap.poll();
    }
}