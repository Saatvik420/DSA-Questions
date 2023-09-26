class Solution {
	int[] nums, cost; // input to minCost()

	/**
	 * Finds the cost to make all elements in the array equal to the given value.
	 * @param val given value to make all elements equal to
	 * @return cost to make all elements equal to val
	 */
	private long cost(int val) {
		long totalCost = 0L;
		for (int i = 0; i < nums.length; i++) {
			totalCost += 1L * Math.abs(nums[i] - val) * cost[i];
		}
		return totalCost;
	}

	/**
	 * Finds the minimum cost to make all elements in the array equal.
	 * @param nums elements of the array
	 * @param cost cost[i] = cost of changing nums[i] by 1
	 * @return minimum cost to make all elements equal
	 */
	public long minCost(int[] nums, int[] cost) {
		// pass by reference
		this.nums = nums;
		this.cost = cost;

		// find max and min element
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int elem : nums) {
			if (elem < min) min = elem;
			if (elem > max) max = elem;
		}

		// binary search
		int mid;
		while (max - min > 1) {
			mid = (min + max) / 2;
			if (cost(mid) < cost(mid + 1)) max = mid; // positive slope
			else min = mid; // negative slope
		}

		// return minimum cost
		return Math.min(cost(min), cost(max));
	}
}