package 排序;

public class 插入排序 {


    public void insertionSort(int[] a){
        int j;
        //将数组第一个元素后面的元素一一插入到有序的位置
        for(int p =1;p<a.length;p++){
            int tmp=a[p];
            // 从第二个元素开始 比较自己之前的元素
            for(j=p;j>0&&tmp<a[j-1];j--){

                a[j]=a[j-1];
            }
            a[j]=tmp;
        }

    }

    public void insertSort2(int[] b){

        int j;
        for(int i=1;i<b.length;i++){

            int tmp=b[i];

            for(j=i;j>0&&b[j-1]>tmp;j--){

                b[j]=b[j-1];

            }

                b[j]=tmp;
            }


    }







    public static void main(String[] args) {


        int [] c={8,5,2,4,1,7,3,10,9,6};
        new 插入排序().insertionSort(c);
        for(int i=0;i<c.length;i++){
            System.out.printf("%d ",c[i]);
        }

    }

}
