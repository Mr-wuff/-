import java.util.Scanner;

public class question2_6 {
    static int B;//B为购入事件，仅存在0和1俩个状态
    public static void main(String[] args) {
        B = 0;//将事件归零
        /*
         * ht：拥有的血管机器人数量；
         * gt：需要的血管机器人数量；
         * count：购入的总量（计数器）；
         * number：当周购入的量（暂存器）
         * lastgt: 上一周工作的机器人数量；
         * cost：保养的总消费
         */
        int ht,lastgt = 0,gt = 0,count = 0,restnumber = 0,cost = 0,number = 0,restcount=0;
        ht=50;//初始化：原有的血管机器人数量为12个
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();//定义结束的时间为T周
        /*
        T+1为提前量：因为新购入的设备需要一周准备时间，故第T周的设备是为第T+1周而准备的
         */
        if (T == 104){
            for (int t = 0; t < T; t++) {
                gt=sc.nextInt();
                gt = gt * 4;
                if (ht >= gt) B = 0;//情况1：不需要购入
                else if (ht < gt) B = 1;//情况2：需要购入
                if (B == 1) {count += (ht - gt) + getht(lastgt); ht = gt;}
                if (B == 0) {count += (ht - gt) + getht(lastgt);}
                ht = getht(gt) + restnumber;//进行损毁计算
                lastgt = gt;
                cost += gt * (1*10+4*5);
            }
            count += gt;
            System.out.println("保养的总量：" + count);//输出总购入数
            System.out.println("第"+ T + "周保养的量：" + getht(lastgt));
            System.out.println("保养的消费：" + cost);
        }
        for (int t = 0; t < T+1; t++) {
            gt=sc.nextInt();
            gt = gt * 4;
            if (ht >= gt) B = 0;//情况1：不需要购入
            else if (ht < gt) B = 1;//情况2：需要购入
            if (B == 1) {count += gt - ht; number = gt - ht; ht = gt;}
            if (B == 1) {restnumber = (ht-gt)+getht(lastgt); restcount += restnumber; ht = gt;}
            if (B == 0) {restnumber = (ht-gt)+getht(lastgt); restcount += restnumber;}
            ht = getht(gt) + restnumber;//进行损毁计算
            lastgt = gt;
        }
        System.out.println("保养的总量：" + restcount);//输出总购入数
        /*
        输出第T周购入数
         */
        System.out.println("第"+ T + "周保养的量：" + getht(lastgt));
    }

    public static int getht(int gt) {
        /*
        进行20%概率的损毁计算（四舍五入）
         */
        gt = (gt * 8) / 10;
        if ((gt * 8) % 10 >=5) gt++;
        return gt;
    }
}