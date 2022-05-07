import java.util.Scanner;

public class question4_1 {
    static int B;//B为购入事件，仅存在0和1俩个状态
    public static void main(String[] args) {
        B = 0;//将事件归零
        /*
         * ht：拥有的血管机器人数量；
         * gt：需要的血管机器人数量；
         * count：购入的总量（计数器）；
         * number：当周购入的量（暂存器）
         * minum：最小的总价
         * cost：总消费
         */
        int ht,count = 0,number = 0,cost = 0,minum,money;
        ht=12;//初始化：原有的血管机器人数量为12个
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[104];
        int[] need = new int[104];
        for (int i = 0; i < 104; i++) {
            need[i]=sc.nextInt();
        }
        /*
        T+1为提前量：因为新购入的设备需要一周准备时间，故第T周的设备是为第T+1周而准备的
         */
        for (int t = 0; t < 104; t++) {
            for (int n = 0; n < 110; n++) {
                //情况1：供大于求
                if (ht < need[t] - n) break;//情况2：供不应求
                ht = getht(need[t]);//进行损毁计算
                cost += getmoney(number);
            }
        }
        System.out.println("购入的总量：" + count);//输出总购入数
        /*
        输出第T周购入数
        System.out.println("第"+ T + "周购入的量：" + number);
         */
        if(B == 1)
        if(B == 0) number=0;
    }

    public static int getht(int ht) {
        /*
        进行10%概率的损毁计算（四舍五入）
         */
        ht = (ht * 9) / 10;
        if ((ht * 9) % 10 >=5) ht++;
        return ht;
    }

    public static int getmin(int T,int t,int cost) {
        int min;
        min = cost;
        return min;
    }

    public static int getmoney(int number) {
        int money;
        if (number > 5 && number <= 10) money = 180*(number - 5) + 200 * 5;
        else if (number > 10) money = 160*(number - 10) + 180*5 + 200*5;
        else money = 200 * number;
        return money;
    }
}
