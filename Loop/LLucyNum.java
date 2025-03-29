package Loop;

public class LLucyNum {
    
    public static void main(String[] args) {
        int res = 0;
        for(long i = 1;i<=100000000;i++){
            long sum1 = 0,sum2 = 0;
            //学会将大数字转换为字符串
            String s = i+"";
            if(s.length()%2==0){
                char c[] = s.toCharArray();
                int len = c.length;
                for(int j  = 0;j<len/2;j++){
                    sum1 += (int)c[j]-'0';
                    sum2 += (int)c[len/2+j]-'0';
                }
                if(sum1==sum2) res++;
            }
        }
        System.out.println(res);
    }
}
