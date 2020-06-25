import java.util.Arrays;

public class point {

    public String Decor[] = new String[5];
    public int num[] = new int[5];
    private String[] str= new String[5];;
    public int D[] = new int[]{0,0,0};                 //用于存储对子的相关信息，第一位表示最大的对子点数，
                                                        // 第二位是次之的对子点数，第三位是三条点数，若无对子则相应位为零

    public point(String a){                             //构造函数，同时构建点数数组和花色数组
        str = a.split(" ");
        for (int i =0;i<5;i++){    //将点数转化为数字方便比较大小，花色保留
            if(str[i].substring(0,1).equals("T"))
                num[i] = 10;
            else if(str[i].substring(0,1).equals("J"))
                num[i] = 11;
            else if(str[i].substring(0,1).equals("Q"))
                num[i] = 12;
            else if(str[i].substring(0,1).equals("K"))
                num[i] = 13;
            else if(str[i].substring(0,1).equals("A"))
                num[i] = 14;
            else
                num[i] = Integer.parseInt(str[i].substring(0,1));

            Decor[i] = str[i].substring(1,2);
        }
    }

    public int Decorstatus(){
        //判断是否是同花
        if (!Decor[0].equals(Decor[1]))
            return 0;
        if (!Decor[1].equals(Decor[2]))
            return 0;
        if (!Decor[2].equals(Decor[3]))
            return 0;
        if (!Decor[3].equals(Decor[4]))
            return 0;        
        return 1;
    }

    public int numstatus(){
        //判断是否是顺子
        if (pairstatus() == 0){             //在没有对子的前提下
            Arrays.sort(num); //对数组排序，在此问题中，初始的顺序无关紧要
            int max = num[num.length-1];
            int min = num[0];
            if (max - min == 4)             //若最大值减去最小值等于4，说明数字连续的
                return 1;
        }
        return 0;
    }

    public int pairstatus(){
        //判断对子数
        int a[] = new int[]{0,0,0,0};
        int n = 0;
        int k = 0;
        for(int i = 0; i<4; i++){
            for(int j = i+1; j<5; j++){
                if(num [i]==num[j]){
                    k++;
                    a[n++] = num [i];
                }
            }
        }
        if (k>=3)  {
            //三带一对和炸弹都记为三条
            D[2] = a[1];
            return 3;
        }

        else if (k==2){
            D[0] = a[0];
            D[1] = a[1];
            int temp = 0;
            if (D[1]>D[0]){
                temp = D[1];
                D[1] = D[0];
                D[0] = temp;
            }
            return k;
        }
        else if (k==1){
            D[0] = a[0];
            return k;
        }
        else{
            return k;
        }
    }

    public int kindofcard(){                           //判断牌的大小
        int same = Decorstatus();           //返回01表示是否是同花
        int order = numstatus();            //返回01表示是否是顺子
        int pair = pairstatus();            //返回0123表示对子数
        if (pair == 0){  //没有对子
            if(same == 1){   //花色均相同
                if(order == 1){
                    return 7;                   //同花顺
                }
                else
                    return 6;                   //同花
            }
            else{            //花色不全相同
                if(order == 1)   //有序
                    return 5;                   //顺子
                else
                    return 1;                   //散牌
            }

        }
        else if (pair == 1)
            return 2;                       //对子
        else if (pair == 2)
            return 3;                       //两对
        else
            return 4;                       //三条
    }

    public static void main(String[] args) {
//        point card = new point("2H 2D 4S 4H 4D");
//        System.out.println(card.kindofcard());
//        System.out.println(D[0]+","+D[1]+","+D[2]);
//
//        for (int i =0;i<5;i++){
//            System.out.println(Decor[i]+num[i]);
//        }
    }
}
