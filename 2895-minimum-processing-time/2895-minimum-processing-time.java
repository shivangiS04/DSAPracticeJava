class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());
        int sum = 0;

        for (int i = 0; i < tasks.size(); i++) {
            sum = Math.max(sum, processorTime.get(i / 4) + tasks.get(i));
        }
        return sum;
    }
}