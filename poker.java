import java.util.Arrays;

public class poker {
    point a;
    point b;

    public poker(point black,point white){
        this.a = black;
        this.b = white;
    }

    public void compare(){
        if(a.kindofcard() > b.kindofcard()){       //明显黑大
            System.out.println("blackwins");
        }
        else if(a.kindofcard() < b.kindofcard()){  //明显白大
            System.out.println("whitewins");
        }
        else{                                      //牌的类型相同，需进一步对比点数
            int win = 2;
            if(a.kindofcard() == 1 || a.kindofcard() == 6){
                //均为散牌时
                Arrays.sort(a.num);
                Arrays.sort(b.num);
                for(int i=0;i<5;i++){
                    win = comparenum(a.num[4-i] , b.num[4-i]);
                    if (win!=0)break;
                }
                if (win==0) System.out.println("Tie");
            }
            else if(a.kindofcard() == 2){
                //均为对子时
                win = comparenum(a.D[0] , b.D[0]);
                if(win==0){              //对子点数相同
                    int[] an = new int[5];
                    int[] bn = new int[5];
                    System.arraycopy(a.num, 0, an , 0, 5);
                    System.arraycopy(b.num, 0, bn , 0, 5);

                    an=volume(an,a.D[0]);
                    bn=volume(bn,b.D[0]);
                    Arrays.sort(an);
                    Arrays.sort(bn);


                    for(int i=0;i<3;i++){
                        win = comparenum(an[2-i] , bn[2-i]);
                        if (win!=0)break;
                    }
                    if (win==0) System.out.println("Tie");
                }
            }
            else if(a.kindofcard() == 3){
                //均为两对时
                win = comparenum(a.D[0] , b.D[0]);
                if(win == 0){
                    win = comparenum(a.D[1] , b.D[1]);
                }
                if(win==0){              //两个对子点数相同
                    int[] an = new int[5];
                    int[] bn = new int[5];
                    System.arraycopy(a.num, 0, an , 0, 5);
                    System.arraycopy(b.num, 0, bn , 0, 5);

                    int last_a = 0;
                    int last_b = 0;
                    for(int i=0;i<5;i++){                              //取出对子之外余下来的数
                        if (an[i]!=a.D[0]&&an[i]!=a.D[1])
                            last_a = an[i];
                        if (bn[i]!=b.D[0]&&bn[i]!=b.D[1])
                            last_b = bn[i];
                    }

                    win = comparenum(last_a , last_b);                 //对比最后的数
                    if (win==0) System.out.println("Tie");
                }
            }
            else if(a.kindofcard() == 4){
                //均为三条时
                win = comparenum(a.D[2] , b.D[2]);
                if(win==0){              //三条点数相同
                    int[] an = new int[5];
                    int[] bn = new int[5];
                    System.arraycopy(a.num, 0, an , 0, 5);
                    System.arraycopy(b.num, 0, bn , 0, 5);

                    an=volume(an,a.D[2]);
                    bn=volume(bn,b.D[2]);
                    Arrays.sort(an);
                    Arrays.sort(bn);

                    win = comparenum(an[1] , bn[1]);
                    if (win==0) System.out.println("Tie");
                    else {
                        win = comparenum(an[0] , bn[0]);
                        if (win==0) System.out.println("Tie");
                    }
                }
            }
            else if(a.kindofcard() == 5 || a.kindofcard() == 7){
                //均为顺子 或 同花顺时
                Arrays.sort(a.num);
                Arrays.sort(b.num);
                win = comparenum(a.num[4] , b.num[4]);   //其实比01234哪个都行
                if (win==0) System.out.println("Tie");
            }
            else{
               System.out.println("error");
            }
        }
    }

    public int comparenum(int a,int b){              //判断两个数的大小，若不同直接输出结果，否则暂不输出
        if(a>b){
            System.out.println("blackwins");
            return 1;
        }
        else if(a<b){
            System.out.println("whitewins");
            return -1;
        }
        else
            return 0;
    }

    private static int[] volume(int[] arr, int key) {                 //引用了网上的一个函数，用于除去函数中的某个数
        int count = 0;
        for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
            if (arr[i] == key && i != j)
                count++;
            if (arr[j] == key && i != j)
                count++;
            if (arr[i] == key && i == j)
                count++;
        }
        //上面就是计算0的个数
        int nrr[] = new int[arr.length - count];
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                continue;
            else
                nrr[count++] = arr[i];
        }
        return arr = nrr;
    }


    public static void main(String[] args) {
        point black = new point("1H 2H 3H 4H 5H"  );
        point white = new point("3C 4C 5C 6C 7C"  );
        poker a = new poker(black,white);
        a.compare();
    }
}
