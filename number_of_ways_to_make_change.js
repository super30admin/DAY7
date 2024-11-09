var numberOfWaysToMakeChange = function (n, denoms) {
  // Write your code here.
  let array = new Array(n + 1);
  array.fill(0);
  array[0] = 1;

  for (let denomIndex = 0; denomIndex < denoms.length; denomIndex++) {
    for (let amount = 0; amount <= n; amount++) {
      if (denoms[denomIndex] <= amount) {
        array[amount] = array[amount] + array[amount - denoms[denomIndex]];
      }
    }
  }
  return array[n];
};

test("Scenario #1: BaseCase", () => {
  let coins = [];
  let amount = 1;
  expect(numberOfWaysToMakeChange(amount, coins)).toStrictEqual(0);
});
test("Scenario #1: Happy Path", () => {
  let coins = [1, 2, 5];
  // 1x6, 2x3, 2x1 1x4, 2x2 1x2, 5x1 1x1 =
  let amount = 6;
  expect(numberOfWaysToMakeChange(amount, coins)).toStrictEqual(5);
});
