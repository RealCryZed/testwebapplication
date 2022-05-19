package testwebapplication.Functions;

import org.springframework.stereotype.Service;

@Service
public class SecondTaskCore {

    public int[][] getNewMagicSquare() {
        int n = 3;

        int[][] magicSquare = new int[n][n];

        int i = n / 2;
        int j = n - 1;

        for (int num = 1; num <= n * n;) {
            if (i == -1 && j == n)
            {
                j = n - 2;
                i = 0;
            }
            else {
                if (j == n)
                    j = 0;

                if (i < 0)
                    i = n - 1;
            }

            if (magicSquare[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            }
            else
                magicSquare[i][j] = num++;

            j++;
            i--;
        }

        return magicSquare;
    }

    public int calcSum(int[][] magicSquare) {
        int sum = 0;
        int n = 3;

        int[][] initialSquare = new int[n][n];

        initialSquare[0][0] = 1;
        initialSquare[0][1] = 2;
        initialSquare[0][2] = 3;
        initialSquare[1][0] = 4;
        initialSquare[1][1] = 5;
        initialSquare[1][2] = 6;
        initialSquare[2][0] = 7;
        initialSquare[2][1] = 8;
        initialSquare[2][2] = 9;

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                sum += Math.abs(magicSquare[k][l] - initialSquare[k][l]);
            }
        }

        return sum;
    }
}
