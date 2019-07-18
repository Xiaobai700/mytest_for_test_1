package com.njupt.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangqiao on 2019/4/10.
 */
public class tips {

    /**
     * @author zhangqiao
     * 题目：把一个0 1 串（只包含0 1的串）进行排序，你可以交换任意两个位置，问最小交换的次数？
     * 思路： 快排 两个标杆  i代表从左往右   j代表 从右往左  ，i碰到0 和 j碰到1进行交换， 由于是0 -- length 所以是线性的。
     */
    public static void zero_1Demo(String str){
        char[] a = str.toCharArray();
        int len = a.length;
        int times= 0;
        for(int i = 0,j = len - 1;i < j;++i,--j){
            for(;i<j&&a[i]=='0';){
                ++i;
            }
            for(;i<j&&a[j]=='1';){
                --j;
            }
            if(i < j){
               ++times;
            }
        }
        System.out.println("最终交换的次数为："+times);
    }
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * */


    public static ArrayList<Integer> printMatrix(int [][] matrix) {
            ArrayList<Integer> list = new ArrayList<>();

            int rows = matrix.length;
            int column = matrix[0].length;

            if(rows == 0){
                return list;
            }

            //计算有多少层
            int ceng_num =(Math.min(rows,column)-1)/2+1;

            for(int k = 0;k < ceng_num;k++){
                //上方 列数递增
                for (int j = k;j<column-k;j++){
                    list.add(matrix[k][j]);
                }
                //右侧 层数递增
                for(int i = k+1;i<rows-k;i++){
                    list.add(matrix[i][column-1-k]);
                }
                //下方 列数递减
                //rows-1-k != k这个条件是为了处理出现一行多列的矩阵
                for(int j = column-2-k;(j>=k)&&(rows-1-k != k);j-- ){
                    list.add(matrix[rows-1-k][j]);
                }
                //左侧 行数递减
                //column-1-k != k这个条件是为了处理出现一列多行的情况
                for(int i =rows-2-k;(i>k)&&(column-1-k != k);i-- ){
                    list.add(matrix[i][k]);
                }
            }
            return list;

        }

       /**
        * 链表反转
        * */
       //一个结点的数据结构
       public static class ListNode {
           int val;
           ListNode next = null;

           ListNode(int val) {
               this.val = val;
           }
       }
       public static ListNode ReverseList(ListNode head) {
           if(head==null)
               return null;
           //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
           ListNode pre = null;
           ListNode next = null;
           //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
           //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
           //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
           //所以需要用到pre和next两个节点
           //1->2->3->4->5
           //1<-2<-3 4->5
           while(head!=null){
               //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
               //如此就可以做到反转链表的效果
               //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
               next = head.next;
               //保存完next，就可以让head从指向next变成指向pre了，代码如下
               head.next = pre;
               //head指向pre后，就继续依次反转下一个节点
               //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
               pre = head;
               head = next;
           }
           //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
           //直接输出pre就是我们想要得到的反转后的链表
           return pre;
       }

       public static ListNode reverse_test(ListNode head){
           if(head == null){
               return head;
           }

           ListNode pre = null;
           ListNode next = null;
           while (head != null){
               next = head.next;
               head.next = pre;
               pre = head;
               head = next;

           }
           return pre;

       }

       /**输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
        * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
        * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
        * */
       public static void reOrderArray(int [] array) {
           ArrayList<Integer> list_ji = new ArrayList<Integer>();
           ArrayList<Integer> list_ou = new ArrayList<Integer>();
           int len = array.length;
           for(int i = 0;i < len;i++){
               if(array[i]%2 != 0){
                   list_ji.add(array[i]);
               }else{
                   list_ou.add(array[i]);
               }
           }
           //把两个list合并
           for(int i:list_ou){
               list_ji.add(i);
           }
           //把list转为数组
           int[] newArray = new int[len];
           for(int i = 0;i<list_ji.size();i++){
               newArray[i] = list_ji.get(i);
           }
           for(int i = 0;i < len;i++){
               array[i] = newArray[i];
           }
       }

       /**输入两个单调递增的链表，输出两个链表合成后的链表，
        * 当然我们需要合成后的链表满足单调不减规则。
        * */
       /**
        * 主要思想就是类似于两路合排序的merge函数，关键就是这里操作的数据结构是单链表
        * 这里涉及了单链表的构造以及主函数里单链表的输出 不多赘述
        * */
       public static ListNode Merge(ListNode list1,ListNode list2) {
           ListNode list = null;
           ListNode p = null;
           ListNode p1 = list1;
           ListNode p2 = list2;
           //让我想起了两路合并排序的Merge函数
           while(p1 != null && p2 != null){
               if(p1.val < p2.val){
                   if(list == null){
                       list = p1;
                       p = list;
                   }else{
                       p.next = p1;
                       p = p1;
                   }
                   p1 = p1.next;
               }else{
                   if(list == null){
                       list = p2;
                       p = list;
                   }else{
                       p.next = p2;
                       p= p2;
                   }
                   p2 = p2.next;
               }
           }
           //把第一个链表中剩余的加到新的链表中
           while(p1 != null){
               p.next = p1;
               p = p1;
               p1 = p1.next;
           }
           //把第二个链表中剩余的加到新的链表中
           while(p2 != null){
               p.next = p2;
               p = p2;
               p2 = p2.next;
           }

           return list;
       }
       /**在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
        * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
        * */
       public static ListNode deleteDuplication(ListNode pHead)
       {
           //在头结点之前添加一个结点
           ListNode beforeH = new ListNode(-1);
           beforeH.next = pHead;
           ListNode beforeP = beforeH;

           ListNode p = pHead;

           while(p != null && p.next != null){
               if(p.next.val == p.val){
                   int val = p.val;
                   //找到一个相等的时候就继续再找
                   while(p != null && val == p.val ){
                       p = p.next;
                   }
                   //因为是有序的链表，所有重复的结点都是紧挨着的，一起找到之后，
                   //把重复结点的前一个结点的next指向重复结点的后一个结点
                   beforeP.next = p;
               }else{
                   beforeP = p;
                   p = p.next;
               }
           }
           return beforeH.next;
       }

       /**
        *有赞笔试题，键盘输入两个字符串，以；分隔，像这样："youzan;zanyou".
        * 将第一个字符串分割成两部分，第一部分放在第二部分后面能否组成第二个字符串，
        * 要是能返回true，否则返回false
        * */
       public static boolean youzan_test(String str1,String str2){
           boolean result = false;
           int len1 = str1.length();
           int len2 = str2.length();

           int i =0;
           int j =0;
           int index = 0;
           if(len1 != len2){
               return false;
           }else{
               while(i<len1 && j<len2){
                   if(str1.charAt(i) == str2.charAt(j)){
                       if(index == 0){
                           index = j;//把分割处的下标记录下来
                       }
                       i++;
                       j++;
                   }else{
                       j++;
                   }
               }
               //判断前一部分是否一致
               if(len2 - index != i){
                   return false;
               }else{
                   int a = 0;
                   while(i < len1 && a < index){
                       if(str1.charAt(i) == str2.charAt(a)){
                           i++;
                           a++;
                       }else{
                           return false;
                       }
                   }
               }
               return true;
           }
       }

       /**链接：https://www.nowcoder.com/questionTerminal/3f99492e23d9403d923e44bb1061cc86
        来源：牛客网

        给定一个非空的整数数组，从数组第一个元素(下标为0的元素)开始遍历进行移动，
        下一次向后或向前移动 该元素的值 的位数（值为正数向后移动，值为负数向前移动，值为零不移动），
        依次类推进行移动，若某次移动数组出现越界，则说明数组可以跳出，返回true；
        不能跳出则返回false；（加分项：也可考虑不增加使用其他集合数组辅助完成算法）
        例1：
        输入数组a[5] = [1,2,3,2,5];从第一个元素开始a[0]=1,下次向后移动1位到第二个元素a[1]=2,
        再次向后移动2位到第四个元素a[3],因为下次向后移动2位(a[3]=2)后,向后数组越界,即跳出数组,输出true;
        例2：
        输入数组a[2] = [1,-3];从第一个元素开始a[0]=1,下次移动1位到第二个元素a[1]=-3,
        再次向前移动3位后,向前数组越界,即跳出数组,输出true;
        * */
       public static boolean move_array(){
           boolean result = false;

           Scanner sc = new Scanner(System.in);
           String numstr = null;
           while (numstr == null || numstr == ""){
               System.out.println("请您输入数字以逗号分割！");
               numstr = sc.nextLine();
           }
           //键盘输入构造数组
           String[] nums = numstr.split(",");
           while (nums.length == 0){
               System.out.println("请您输入数字以逗号分割！");
               numstr = sc.nextLine();
               nums = numstr.split(",");
           }
           List<Integer> real_num = new ArrayList<Integer>();

           for(int i = 0;i < nums.length;i++){
               if(nums[i] != ""){
                   real_num.add(Integer.parseInt(nums[i]));
               }
           }

           int[] a = new int[real_num.size()];
           for (int i = 0;i < real_num.size();i++) {
               a[i] = real_num.get(i);
           }

           int move_index = 0;
           for(int i = 0; i < a.length;i++){
               int n = a[i];
               move_index += n;
           }

           if(!(move_index >= 0 && move_index < a.length)){
              result = true;
           }
           return result;

       }
       /**
        * 趋势的一道题：有一个递增序列，0 1 2 3 4 5.....隔一个删除一个元素、隔两个删除一个元素.....如果疏导最后一个再回到第一个
        * 直到全部删除完  返回最后一个被删除的元素
        * */
       public static int return_last_deleted(int[] a){
           int result = 0;
           int len = a.length;
           int count = 1;
           int index = 0;
           while (count <= len){
               int real = 0;
               while (index >= 0 && index <= len-1 && real < count) {
                   if (a[index] != -1 && index != len-1) {
                       index++;
                       real++;
                   }else if(a[index] == -1 && index != len-1) {
                       index++;
                   }
                   if(index == len-1 && real < count ){
                       if (a[index] != -1) {
                           real++;
                       }
                       index = 0;
                   }
               }
               while (a[index] == -1 && index <= len-1){
                   if(index == len-1){
                       index = 0;
                   }else {
                       index++;
                   }
               }
               count++;
               result = a[index];
               a[index] = -1;
           }
           return result;
       }

       public static int findLongest(String A,String B){
           int n = A.length();
           int m = B.length();

           if(m == 0 || n == 0){
               return 0;
           }
           int result = 0;
           int[][] dp = new int[n+1][m+1];
           //初始状态
           for(int i = 0; i <= n;i++){
               dp[i][0] = 0;
           }
           for(int i = 0; i <= m;i++){
               dp[0][i] = 0;
           }

           for(int i = 1;i <= n;i++){
               for(int j = 1;j <= m;j++){
                   if(A.charAt(i-1) == B.charAt(j-1)){
                       dp[i][j] = dp[i-1][j-1]+1;
                       result = Math.max(result,dp[i][j]);
                   }else {
                       dp[i][j] = 0;
                   }
               }
           }

           return result;
       }
    public static void main(String[] args) throws IOException {
          /* int a[] = {0,1,2,3,4,5,6};
            System.out.println(return_last_deleted(a));*/
          System.out.println(findLongest("HelloWorld","Hello"));

        /*BufferedReader buf = new BufferedReader (new InputStreamReader(System.in));
        String str = buf.readLine();
        buf.close();

        String[] s = str.split(";");
        String str1 = s[0];
        String str2 = s[1];
        System.out.print(youzan_test(str1,str2));*/



       // String str =  "1010000000011111111";
       // zero_1Demo(str);

       /* ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        System.out.println(reverse_test(l1).val);*/

       /*int a[] = {1,8,7,4,66,5,11};
       reOrderArray(a);
        for (int n:a) {
            System.out.print(n+" ");
        }
        System.out.println("\n");*/

        /*ListNode l5 = new ListNode(15);
        ListNode l4 = new ListNode(14);
        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(4);
        ListNode l1 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

        //ListNode ll5 = new ListNode(56);
        //ListNode ll4 = new ListNode(49);
        ListNode ll3 = new ListNode(5);
        ListNode ll2 = new ListNode(3);
        ListNode ll1 = new ListNode(1);

        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = null;
       // ll4.next = ll5;
        //ll5.next = null;*/

        /*ListNode result = Merge(ll1,l1);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }*/

        /*ListNode repeatResult = deleteDuplication(l1);
        while (repeatResult != null){
            System.out.println(repeatResult.val);
            repeatResult = repeatResult.next;
        }*/
        /*int [][] a = {{1,2,3,4,5}};
        ArrayList<Integer> list = printMatrix(a);
        for (int n:list) {
            System.out.println(n);
        }*/
    }
}
