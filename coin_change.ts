function coinChange(coins: number[], amount: number): number {
  let result = Infinity;

  function dfs(remaining: number, count: number): void {
    if (remaining === 0) {
      result = Math.min(result, count);
      return;
    }

    if (remaining < 0) {
      return;
    }

    for (const coin of coins) {
      dfs(remaining - coin, count + 1);
    }
  }

  dfs(amount, 0);
  return result === Infinity ? -1 : result;
}

function coinChange_memorization(coins: number[], amount: number): number {
  // Memoization map to store results for subproblems
  const memo: Map<number, number> = new Map();

  // Recursive helper function with memoization
  function dfs(remaining: number): number {
      // If the amount is already computed, return it
      if (memo.has(remaining)) {
          return memo.get(remaining)!;
      }

      // Base cases
      if (remaining === 0) return 0; // No more coins needed
      if (remaining < 0) return Infinity; // Invalid path

      // Try all coins to find the minimum number of coins
      let minCoins = Infinity;
      for (const coin of coins) {
          const res = dfs(remaining - coin);
          if (res !== Infinity) {
              minCoins = Math.min(minCoins, res + 1);
          }
      }

      // Store the result in memo and return
      memo.set(remaining, minCoins);
      return minCoins;
  }

  const result = dfs(amount);
  return result === Infinity ? -1 : result;
}

// Example usage
const coins = [1, 2, 5];
const amount = 11;
console.log(coinChange(coins, amount)); // Output: 3 (5 + 5 + 1)


describe("322. Coin Change", () => {
  it("Happy Path", () => {
    expect(coinChange([1, 2, 5], 11)).toStrictEqual(3);
  });

  it("Negative", () => {
    expect(coinChange([2], 3)).toStrictEqual(-1);
  });

  it("Negative 2", () => {
    expect(coinChange([2], 3)).toStrictEqual(-1);
  });
});
