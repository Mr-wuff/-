import java.util.Date;
import java.util.Scanner;

public class question5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gt,min = 10000000;
        double Loss = 0;
        double A=0,B=0,C=0;
        Double[] DataSet = {11.0 ,5.0, 4.0, 7.0, 16.0, 6.0, 5.0, 7.0, 13.0, 6.0, 5.0, 7.0, 12.0, 5.0, 4.0, 6.0, 9.0, 5.0,
                            5.0, 11.0, 29.0, 21.0, 17.0, 20.0, 27.0, 13.0, 9.0, 10.0, 16.0, 6.0, 5.0, 7.0, 11.0, 5.0, 5.0,
                            6.0, 12.0, 7.0, 7.0, 10.0,15.0, 10.0, 9.0, 11.0, 15.0, 10.0, 10.0, 16.0, 26.0, 21.0, 23.0, 36.0,
                            50.0, 45.0, 45.0, 49.0, 57.0, 43.0, 40.0, 44.0, 52.0, 43.0, 42.0, 45.0, 52.0, 41.0, 39.0, 41.0,
                            48.0, 35.0, 34.0, 35.0, 42.0, 34.0, 36.0, 43.0, 55.0, 48.0, 54.0, 65.0, 80.0, 70.0, 74.0, 85.0,
                            101.0, 89.0, 89.0, 90.0, 100.0, 87.0, 88.0, 89.0, 104.0, 89.0, 89.0, 90.0, 106.0, 96.0, 94.0,
                            99.0, 109.0, 99.0, 96.0, 102.0};
        for (double a = 0; a < 10; a += 0.1) {
            for (double b = 0; b < 10; b += 0.1) {
//                for (double c = 0; c < 200; c += 0.1) {
                    for (double t = 0; t < 104; t++) {
//                        Loss += (DataSet[(int)t] - a * (t * t) + b * t + c) * (DataSet[(int)t] - a * (t * t) + b * t + c);
                        Loss += (DataSet[(int)t] - a * t + b) * (DataSet[(int)t] - a * t + b);
                    }
                    if (Loss < min) {
                        A = a;
                        B = b;
//                        C = c;
                    }
                    min = Math.min(min, (int)Loss);
                    Loss = 0;
//                }
            }
        }

        for (int t = 104; t < 112; t++) {
            System.out.println(A * t + B);
//            System.out.println(A * t * t + B * t + C);
        }
    }
}
