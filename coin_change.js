/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function (coins, amount) {
  let array = new Array(amount + 1);
  array.fill(Number.MAX_SAFE_INTEGER);
  array[0] = 0;

  for (let coinIndex = 0; coinIndex < coins.length; coinIndex++) {
    let coin = coins[coinIndex];
    for (let runningAmt = 0; runningAmt <= amount; runningAmt++) {
      if (coin <= runningAmt) {
        array[runningAmt] = Math.min(
          array[runningAmt],
          1 + array[runningAmt - coin]
        );
      }
    }
  }

  return array[amount];
};

test("Scenario #1: BaseCase", () => {
  let coins = [];
  let amount = 1;
  expect(coinChange(coins, amount)).toStrictEqual(-1);
});

test("Scenario #2: Happy Path", () => {
  let coins = [1, 2, 4];
  let amount = 7;
  expect(coinChange(coins, amount)).toStrictEqual(3);
});

test("Scenario #2: Complex Happy Path", () => {
  let coins = [4, 2, 1];
  let amount = 7;
  expect(coinChange(coins, amount)).toStrictEqual(3);
});

test("Scenario #3: Negative", () => {
  let coins = [2, 4];
  let amount = 7;
  expect(coinChange(coins, amount)).toStrictEqual(-1);
});
