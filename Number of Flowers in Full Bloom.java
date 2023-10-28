class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sortedArrivalTimes = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedArrivalTimes);

        // Sort the flower intervals based on their start times.
        Arrays.sort(flowers, Comparator.comparingInt(flower -> flower[0]));

        Map<Integer, Integer> bloomCounts = new HashMap<>();  // Map to store counts of flowers in bloom for each arrival time.
        PriorityQueue<Integer> bloomEndTimes = new PriorityQueue<>();  // Min heap to track flower bloom end times.

        int flowerIdx = 0;
        for (int personTime : sortedArrivalTimes) {
            // Add flowers that are in bloom at the person's arrival time.
            while (flowerIdx < flowers.length && flowers[flowerIdx][0] <= personTime) {
                bloomEndTimes.offer(flowers[flowerIdx][1]);
                flowerIdx++;
            }

            // Remove flowers that are no longer in bloom.
            while (!bloomEndTimes.isEmpty() && bloomEndTimes.peek() < personTime) {
                bloomEndTimes.poll();
            }

            // Store the count of flowers in bloom for the person's arrival time.
            bloomCounts.put(personTime, bloomEndTimes.size());
        }

        int[] flowerCounts = new int[people.length];  // Resulting array to store flower counts for each person.
        for (int i = 0; i < people.length; i++) {
            flowerCounts[i] = bloomCounts.get(people[i]);
        }

        return flowerCounts;  // Return the counts of flowers in bloom for each person's arrival time.
    }
}