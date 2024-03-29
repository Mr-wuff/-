import java.util.Scanner;

public class question3_3 {
    static int B;//B为购入事件，仅存在0和1俩个状态
    public static void main(String[] args) {
        B = 0;//将事件归零
        /*
         * ht：拥有的血管机器人数量；
         * gt：需要的血管机器人数量；
         * count：购入的总量（计数器）；
         * number：当周购入的量（暂存器）
         */
        int ht,gt,count = 0,number = 0,testnumber = 0;
        ht=12;//初始化：原有的血管机器人数量为12个
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();//定义结束的时间为T周
        if (T == 104){
            System.out.println("第"+ T + "周购入的量：" + 0);
            System.out.println("第"+ T + "周训练的操作手量：" + 0);
        }
        /*
        T+1为提前量：因为新购入的设备需要一周准备时间，故第T周的设备是为第T+1周而准备的
         */
        for (int t = 0; t < T+1; t++) {
            gt=sc.nextInt();
            if (ht >= gt) B = 0;//情况1：不需要购入
            else if (ht < gt) B = 1;//情况2：需要购入
            if (B == 1) {number = gt - ht; ht = gt;}
            if (B == 0) {number = 0;}
            ht = getht(gt);//进行损毁计算
            testnumber = number * 4 + (number * 4) / 20 + 1;
            if ((number * 4) % 20 == 0) testnumber--;
            count += testnumber;
        }
        System.out.println("训练的操作手总量：" + count);//输出总购入数
        /*
        输出第T周购入数
         */
        if(B == 1) System.out.println("第"+ T + "周购入的量：" + number);
        if(B == 0) System.out.println("第"+ T + "周购入的量：" + 0);
        if(B == 1) System.out.println("第"+ T + "周训练的操作手量：" + testnumber);
        if(B == 0) System.out.println("第"+ T + "周训练的操作手量：" + 0);
    }

    public static int getht(int gt) {
        /*
        进行10%概率的损毁计算（四舍五入）
         */
        gt = (gt * 9) / 10;
        if ((gt * 9) % 10 >=5) gt++;
        return gt;
    }
}
