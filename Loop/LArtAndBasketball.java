package Loop;


public class LArtAndBasketball {
    
    public static void main(String[] args) {
        int[] monthday={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int[] pen_number={13,1,2,3,5,4,4,2,2,2};
        int month1=12;
        int ans=0;
        for (int i=2000;i<=2024;i++){
            int sumyear=i;
            int sum1=0;
            while (sumyear>0){
                sum1+=pen_number[sumyear%10];
                sumyear/=10;
            }
            if (i==2024){//2024.4.13
                month1=4;
                monthday[4]=13;
            }
            for (int j=1;j<=month1;j++){
                int sum2=0;
                sum2=pen_number[j/10]+pen_number[j%10];
                if (((i%4==0&&i%100!=0)||(i%400==0))&&(j==2)){
                    monthday[2]=29;
                }
                else monthday[2]=28;
                for (int k=1;k<=monthday[j];k++){
                    int sum=0;
                    sum=sum1+sum2+pen_number[k/10]+pen_number[k%10];
                    if (sum>50){
                        ans++;
                    }
                }
            }
        }
        System.out.print(ans);
    }
}
