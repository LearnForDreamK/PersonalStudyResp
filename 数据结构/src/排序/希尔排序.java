package 排序;

public class 希尔排序 {

    //普通希尔排序的实现 gap的选择为length/2 效率不太理想
    void shellSort(int a[]){

        int j;
        for(int gap=a.length/2;gap>0;gap/=2){

            //里面是插入排序
            for(int i=gap;i<a.length;i++){

                int tmp=a[i];
                for(j=i;j>=gap&&a[j-gap]>tmp;j-=gap){
                    a[j]=a[j-gap];
                }

                a[j]=tmp;

            }

        }

    }

    public static void main(String[] args) {

        int [] c={8,5,2,4,1,7,3,10,9,6};
        new 希尔排序().shellSort(c);
        for(int i=0;i<c.length;i++){
            System.out.printf("%d ",c[i]);
        }
    }




}
