package googleJam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
//NotSoRandom
public class NotSoRandom {
    public static void main(String[] args) throws Exception {//可以在main函数里面throws异常
    	FileInputStream file = new FileInputStream("C-small-practice.in");
    	PrintStream outfile = new PrintStream(new FileOutputStream("C-small-practice-out.txt"));//写到文件中，同名文件会覆盖
    	System.setIn(file);//重定向了输入流System.in变量的路径，此时输入流in路径为file变量
    	System.setOut(outfile);//同理重定向输出流System.out路径
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int t = 1; t <= T; t++) {
                int N = scanner.nextInt();
                int X = scanner.nextInt();
                int K = scanner.nextInt();
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                int C = scanner.nextInt();
                Matrix bitZero = new Matrix(100, 0, A, B + C);
                Matrix bitOne = new Matrix(A, B + C, C, A + B);
                Matrix bitZeroAfterK = bitZero;
                Matrix bitOneAfterK = bitOne;
                for (int n = 1; n < N; n++) {   // Maybe some Fast-Matrix-Multiplication will do it faster.
                    bitZeroAfterK = multiply(bitZeroAfterK, bitZero);
                    bitOneAfterK = multiply(bitOneAfterK, bitOne);
                }
                double result = 0;
                for (int i = 31; i >= 0; i--) {
                    result *= 2;
                    Matrix matrix = isLastZero(K, i) ? bitZeroAfterK : bitOneAfterK;
                    double chanceOfOne = (isLastZero(X, i) ? matrix.b : matrix.d) / 100;
                    result += chanceOfOne;
                }
                System.out.println("Case #"+t+": "+result);//写到文件中，同名文件会覆盖
            }
        }
        scanner.close();
    }

    private static boolean isLastZero(int num, int position) {
        return (num >>> position) % 2 == 0;
    }
    /*
    private static void print(int t, double result) {
        System.out.println("Case #" + (t + 1) + ": " + result);
    }*/

    private static Matrix multiply(Matrix m1, Matrix m2) {
        double a = (m1.a * m2.a + m1.b * m2.c) / 100;
        double b = (m1.a * m2.b + m1.b * m2.d) / 100;
        double c = (m1.c * m2.a + m1.d * m2.c) / 100;
        double d = (m1.c * m2.b + m1.d * m2.d) / 100;
        return new Matrix(a, b, c, d);
    }

    private static class Matrix {
        private double a, b, c, d;
        public Matrix(double a, double b, double c, double d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
}