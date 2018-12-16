package com.mikey.sort;

import java.util.Arrays;

/**
 * @author Mikey
 * @date 2018/12/16 15:24
 */
public class QuicklySort {
    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubblingSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int midel=arr[i];
                    arr[i]=arr[j];
                    arr[j]=midel;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 快速排序
     * @param arr
     */
    public static void quickSort(int[] arr,int p,int q)
    {
        int i = p;
        int j = q;
        int temp = arr[p];

        while(i < j)
        {
            // 越过不小于基准值的数据
            while( arr[j] >= temp && j > i ) j--;

            if( j > i )
            {
                arr[i] = arr[j];
                i++;
                // 越过小于基准值的数据
                while(arr[i] <= temp && i < j )  i++;
                if( i < j )
                {
                    arr[j] = arr[i];
                    j--;
                }
            }
        }
        arr[i] = temp;

        if( p < (i-1))quickSort(arr,p,i-1);
        if((j+1) < q )quickSort(arr,j+1,q);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr={1,2,3,6,5,4,7,8,9,5,4,5};
//		bubblingSort(arr);
        quickSort(arr, 0, 11);
        System.out.println(Arrays.toString(arr));

    }
}
