package test.io;

import java.util.Scanner;

/**
 * Created by kangyouyin on 2018/10/18.
 */
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = 0;
        double sum = 0;

        while (scan.hasNextDouble()) {
            double temp = scan.nextDouble();
            sum += temp;
            n++;
        }

        System.out.println("共有：" + n);
        System.out.println("和为：" + sum);
        scan.close();
    }
}
