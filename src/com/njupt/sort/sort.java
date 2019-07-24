package com.njupt.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangqiao on 2019/4/10.
 */
public class sort {
    /**
     * 插入排序
     * */
    public static void insertionSort(int a[]){
        int length = a.length;
        int j;
        for(int i = 1;i < length;++i){
            int value = a[i];
            for(j = i-1;j>=0;j--){
                if(a[j] > value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }
    /**
     * 插入排序法二
     * 在寻找插入位置的时候使用二分查找法
     * 因为是从无序区拿一个元素放到有序区
     * */
    public static void insertSort1(int arr[]){
        for(int idx = 1;idx <= arr.length -1;idx++)
        {
            if(arr[idx] < arr[idx -1])
            {
                int left = 0;
                int right = idx -1;
                int end = arr[idx];
                while(left <= right)
                {
                    int mid = left + ((right - left) >> 1);
                    if(end < arr[mid])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }

                for(int j = idx;j>0 && j>right+1;j--)
                {
                    arr[j] = arr[j-1];
                }
                arr[right+1] = end;
            }
        }
    }

    /**
     * 选择排序
     * */
    public static void chooseSort(int a[]){
        for(int i = 0;i < a.length;i++){
            int min = i;//最小元素的下标
            for(int j = i+1;j <a.length;j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    /**
     * 快速排序
     * */
    public static void quickSort(int a[],int low,int high){
        if(low < high){
            int pivotpos = partition(a,low,high);
            quickSort(a,low,pivotpos-1);
            quickSort(a,pivotpos+1,high);
        }
    }
    public static int partition(int a[],int low,int high){
        int pivot = a[low];
        while (low < high){
            while (low < high && a[high] >= pivot){
               --high;
            }
            a[low] = a[high];
            while (low < high && a[low] <= pivot){
                ++low;
            }
            a[high] = a[low];
        }
        a[low] = pivot;
        return  low;
    }

    /**
     * 冒泡排序
     * */
    public static void bubble_sort(int a[]){
        int len = a.length;
        for(int i = 0;i < len-1;i++){
            for(int j = 0;j < len-1;j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    /**
     * 两路合并排序递归算法（感受了一下js的写法，感觉java真让人头晕啊）
     */
    public static void merge(int a[],int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= high){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        //把左边剩下的移到数组中
        while (i <= mid){
            temp[k++] = a[i++];
        }
        //把右边剩下的移到数组中
        while (j <= high){
            temp[k++] = a[j++];
        }

        //更新原数组
        for (int x = 0;x <temp.length;x++){
            a[x+low] = temp[x];
        }


    }
    public static int[] mergeSort(int a[],int low,int high){
        int mid = (low+high)/2;
        if(low < high){
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            //左右合并
            merge(a,low,mid,high);
        }
        return a;
    }
    /**
     * 堆排序
     */

    public static void heapSort(int[] a){
        for (int i = a.length/2-1;i >= 0;i--){
            adjustHeap(a,i,a.length);
        }

        for(int j = a.length-1;j > 0;j--){
            swap(a,0,j);
            adjustHeap(a,0,j);
        }

    }
     public static void adjustHeap(int[] a,int i,int len){
        int temp = a[i];
        for(int k = 2*i+1;k < len;k = k*2+1){
            if(k+1 < len && a[k] < a[k+1]){
                k++;
            }
            if(a[k] > temp){
                a[i] = a[k];
                i = k;
            }else {
                break;
            }
        }
        a[i] = temp;
     }

    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }


    /**
     * 希尔排序
     * */
    public static void shellSort(int a[]){
        int length = a.length;
        //区间
        int gap = 1;
        while (gap < length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int tmp = a[i];
                int j = i - gap;
                //跨区间排序
                while (j >= 0 && a[j] > tmp) {
                    a[j + gap] = a[j];
                    j -= gap;
                }
                a[j + gap] = tmp;
            }
            gap = gap / 3;
        }
    }
    /**
     * 计数排序
     * */
    public static void jishuSort(int a[]){
       int max = a[0];
       for(int i = 1;i < a.length;i++){
           if(a[i] > max){
               max = a[i];
           }
       }

       int[] countArr = new int[max+1];

       for(int i = 0; i < a.length;i++){
           countArr[a[i]]++;
           a[i] = 0;
       }

       int index = 0;
       for (int i = 0;i < countArr.length;i++){
           if (countArr[i] > 0){
               a[index++] = i;
           }
       }
    }

    /**
     * 桶排序
     * */
    public static void tongSort(int[] a){
        int min = a[0];
        int max = a[0];
        int len = a.length;
        for(int i = 0; i < len;i++){
            if(a[i] > max){
                max = a[i];
            }else if(a[i] < min){
                min = a[i];
            }
        }

        //桶的定义
        ArrayList<ArrayList<Integer>> tong = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < len;i++){
            tong.add(new ArrayList<>());
        }
        //每个桶的存储区间
        float section = (float) (max-min)/(float)(len - 1);

        //数据入桶
        for(int i = 0; i < len;i++){
            //桶的下标
            int num = (int) (a[i]/section)-1;
            if(num < 0){
                num = 0;
            }
            tong.get(num).add(a[i]);
        }

        //桶内排序
        for(int i = 0; i < tong.size();i++){
            Collections.sort(tong.get(i));
        }

        int index = 0;
        for (ArrayList<Integer> list:tong) {
            for (int value:list) {
                a[index] = value;
                index++;
            }
        }


    }
    /**
     * 基数排序
     * */
    public static void CardinalitySort(int[] a){
        int len = a.length;
        int max = a[0];
        for(int i = 0; i < len;i++){
            if(a[i] > max){
                max = a[i];
            }
        }

        int position = 1;

        ArrayList<ArrayList<Integer>> tong = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < 10;i++){
            tong.add(new ArrayList<Integer>());
        }

        while (true){
            int num = (int) Math.pow(10,position-1);
            if(max < num){
                break;
            }

            //数据入桶
            for(int i = 0; i < len; i++){
                int yushu = ((a[i]/num)%10);
                tong.get(yushu).add(a[i]);
            }

            //写回数组
            int index = 0;
            for(int i = 0;i < 10;i++){
                int size = tong.get(i).size();
                for(int j = 0;j < size;j++){
                    a[index++] = tong.get(i).get(j);
                }
                tong.get(i).clear();
            }
            position++;

        }
    }

    public static void main(String[] args){
        int a[] = {8,2,5,9,7,3};
        /*插排*/
       // insertionSort(a);
        insertSort1(a);

        /*快排*/
        //quickSort(a,0,a.length-1);

        /*冒泡*/
        //bubble_sort(a);

        /*归并排序*/
        //mergeSort(a,0,a.length-1);

        /*选排*/
        //chooseSort(a);

        /*希尔排序*/
        //shellSort(a);

        /*计数排序*/
        //jishuSort(a);

        /*桶排序*/
        //tongSort(a);

        /*基数排序*/
        //CardinalitySort(a);

        /*堆排序*/
        //heapSort(a);
        for (int num:a) {
            System.out.print(num);
        }
        //String str ="q ddscnkldclsclsd";
        // StringBuilder stringBuilder = new StringBuilder(str);
        //StringBuffer stringBuffer = new StringBuffer(str);
        //stringBuilder.replace(1,2,"%20");
        //stringBuffer.replace(1,2,"%20");
        //System.out.println(stringBuffer);
    }
}
