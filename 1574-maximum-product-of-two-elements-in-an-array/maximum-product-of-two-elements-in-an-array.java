class Solution {
    public int maxProduct(int[] nums) {
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(numbers);
        return (maxHeap.poll()-1)*(maxHeap.poll()-1);
    }
}