class Solution:
    def __init__(self):
        self.dp = [[-1] * 23 for _ in range(23)]

    def solve(self, nums, F, L):
        if F > L:
            return 0
        if F == L:
            return nums[F]
        if self.dp[F][L] != -1:
            return self.dp[F][L]

        F_score = nums[F] - self.solve(nums, F + 1, L)
        L_score = nums[L] - self.solve(nums, F, L - 1)
        self.dp[F][L] = max(F_score, L_score)
        return self.dp[F][L]

    def PredictTheWinner(self, nums:List[int])-> bool:
        n = len(nums) - 1
        return self.solve(nums, 0, n) >= 0