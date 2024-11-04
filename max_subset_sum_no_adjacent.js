var maxSubsetSumNoAdjacent = function (array) {
  if (array.length == 0) return 0;
  if (array.length == 1) return array[0];

  let runningArray = new Array(array.length);
  runningArray[0] = array[0];
  runningArray[1] = Math.max(array[1], array[0]);

  // [30, 25, 50, 55, 100, 120];
  for (let index = 2; index < array.length; index++) {
    let newMax = Math.max(
      array[index] + runningArray[index - 2],
      runningArray[index - 1]
    );
    runningArray[index] = newMax;
  }
  return runningArray[array.length - 1];
};

test("Scenario #1: BaseCase", () => {
  let numbers = [];
  expect(maxSubsetSumNoAdjacent(numbers)).toStrictEqual(0);
});

test("Scenario #2: Happy Path", () => {
  let numbers = [75, 105, 120, 75, 90, 135];
  expect(maxSubsetSumNoAdjacent(numbers)).toStrictEqual(330);
});

test("Scenario #2: Complex Happy Path", () => {
  let numbers = [4, 5, 6, 7, 1, 1, 1, 100];
  expect(maxSubsetSumNoAdjacent(numbers)).toStrictEqual(113);
});

test("Scenario #2: Negative", () => {
  let numbers = [4, 5];
  expect(maxSubsetSumNoAdjacent(numbers)).toStrictEqual(5);
});

test("Scenario #2: Negative", () => {
  let numbers = [30, 25, 50, 55, 100, 120];
  expect(maxSubsetSumNoAdjacent(numbers)).toStrictEqual(205);
});
