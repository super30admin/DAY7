/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  if (nums.length == 0) return -1;

  let robHouse = new Array(nums.length);
  robHouse[0] = nums[0];
  robHouse[1] = Math.max(nums[0], nums[1]);

  for (let index = 2; index <= nums.length; index++) {
    let max = Math.max(robHouse[index - 1], robHouse[index - 2] + nums[index]);
    robHouse[index] = max;
  }

  return robHouse[nums.length - 1];
};

var spaceOptimisedRob = function (nums) {
  if (nums.length == 0) return -1;
  if (nums.length == 1) return nums[0];

  let second = nums[0];
  let first = Math.max(nums[0], nums[1]);

  for (let index = 2; index < nums.length; index++) {
    let current = Math.max(first, second + nums[index]);
    second = first;
    first = current;
  }

  return first;
};

test("Scenario #1: BaseCase", () => {
  let nums = [];
  expect(spaceOptimisedRob(nums)).toStrictEqual(-1);
});

test("Scenario #1: BaseCase", () => {
  let nums = [1, 2];
  expect(spaceOptimisedRob(nums)).toStrictEqual(2);
});

test("Scenario #1: BaseCase", () => {
  let nums = [10, 10, 20, 15, 15, 25];
  //          10  10  30  30  45  55
  expect(spaceOptimisedRob(nums)).toStrictEqual(55);
});

test("Scenario #1: BaseCase", () => {
  let nums = [2, 7, 9, 3, 1];
  //          2 ,7, 11, 11, 12
  expect(spaceOptimisedRob(nums)).toStrictEqual(12);
});
