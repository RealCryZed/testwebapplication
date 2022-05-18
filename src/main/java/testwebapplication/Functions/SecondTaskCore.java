package testwebapplication.Functions;

import org.springframework.stereotype.Service;

@Service
public class SecondTaskCore {

    public int[][] getNewMagicCube() {
        int n = 3;
//        int[][] magicSquare = new int[n][n];
//        magicSquare[0][0] = 1;
//        magicSquare[0][1] = 2;
//        magicSquare[0][2] = 3;
//        magicSquare[1][0] = 4;
//        magicSquare[1][1] = 5;
//        magicSquare[1][2] = 6;
//        magicSquare[2][0] = 7;
//        magicSquare[2][1] = 8;
//        magicSquare[2][2] = 9;

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (magicSquare[i][j] < 10)  System.out.print(" ");  // for alignment
//                if (magicSquare[i][j] < 100) System.out.print(" ");  // for alignment
//                System.out.print(magicSquare[i][j] + " ");
//            }
//            System.out.println();
//        }

        int[][] magicSquare = new int[n][n];

        // Initialize position for 1
        int i = n / 2;
        int j = n - 1;

        // One by one put all values in magic square
        for (int num = 1; num <= n * n;) {
            if (i == -1 && j == n) // 3rd condition
            {
                j = n - 2;
                i = 0;
            }
            else {
                // 1st condition helper if next number
                // goes to out of square's right side
                if (j == n)
                    j = 0;

                // 1st condition helper if next number is
                // goes to out of square's upper side
                if (i < 0)
                    i = n - 1;
            }

            // 2nd condition
            if (magicSquare[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            }
            else
                // set number
                magicSquare[i][j] = num++;

            // 1st condition
            j++;
            i--;
        }

        // print magic square
        System.out.println("The Magic Square for " + n
                + ":");
        System.out.println("Sum of each row or column "
                + n * (n * n + 1) / 2 + ":");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                System.out.print(magicSquare[i][j] + " ");
            System.out.println();
        }

        return magicSquare;
    }
}
