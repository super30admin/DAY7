namespace LeetCodeSubmission.DP1;

public class CoinChange1
{
    public int Memorization2D(int[] coins, int amount)
    {
        // initialize a memorization2D matrix
        int[,] memorization2D = new int[coins.GetLength(0)+1,amount+1];
        
        int rows = memorization2D.GetLength(0);
        int cols = memorization2D.GetLength(1);

        // set r=0 and col 1 to amt to 99999
        for (int c = 1; c < cols; c++)
        {
            memorization2D[0, c] = 99999;
        }

        // fill up the memorization2D matrix
        for (int r = 1; r < rows; r++)
        {
            // get the coins[index] dimension
            int denomination = coins[r - 1];
            
            for (int c = 1; c < cols; c++)
            {
                if (denomination > c)
                {
                    // denomination > amt (i.e. c), copy everything from above
                    memorization2D[r, c] = memorization2D[r - 1, c];
                }
                else
                {
                    // denomination < amt (i.e. c), min (1+denomination-steps-back), 1-step-above)
                    memorization2D[r, c] = Math.Min(memorization2D[r-1,c],1+memorization2D[r,c-denomination]);
                }
            }
        }
        
        // print the memorization2D matrix
        // for (int r = 0; r < rows; r++)
        // {
        //     for (int c = 0; c < cols; c++)
        //     {
        //         Console.Write(memorization2D[r,c]);
        //         Console.Write("\t");
        //     }
        //     Console.WriteLine();
        // }

        if (memorization2D[rows-1,cols-1] >= 99999)
        {
            return -1;
        }
        
        return memorization2D[rows-1,cols-1];
    }
    public int CoinChange(int[] coins, int amount)
    {
        int coinCount = this.Memorization2D(coins,amount);
        return coinCount;
    }
}