namespace LeetCodeSubmission.DP1;

public class ClassHouseRobber
{
    public int Memorization(int[] nums)
    {
        int[,] memorization2D = new int[nums.GetLength(0), 3];
        int rows = nums.GetLength(0);
        
        for (int r = 0; r < rows; r++)
        {
            if (r == 0)
            {
                memorization2D[r, 0] = 0;
                memorization2D[r, 1] = nums[r];
            }
            else if (r == 1)
            {
                memorization2D[r, 0] = memorization2D[r - 1,2]; // 1-step back
                memorization2D[r, 1] = nums[r];
            }
            else
            {
                memorization2D[r, 0] = memorization2D[r - 1,2]; // 1-step back
                memorization2D[r, 1] = nums[r]+memorization2D[r - 2,2]; // 2-step back
            }

            memorization2D[r, 2] = Math.Max(memorization2D[r, 0],memorization2D[r, 1]);
        }

        return memorization2D[rows - 1, 2];
    }
    
    public int Rob(int[] nums)
    {
        return Memorization(nums);
    }
}