package com.njupt.sort;

import com.njupt.User;

import java.io.ObjectStreamConstants;
import java.util.*;

/**
 * @author zhangqiao
 * 关于图的遍历：深度优先遍历和广度优先遍历
 * */
public class TuDemo {
    //        图结构如下
//          1
//        /   \
//       2     3
//      / \   / \
//     4  5  6  7
//      \ | / \ /
//        8    9
    private Map<String,List<String>> graph = new HashMap<String,List<String>>();
    private Map<String, Boolean> status = new HashMap<String,Boolean>();
    public void init(){
        graph.put("1", Arrays.asList("2", "3"));
        graph.put("2", Arrays.asList("1", "4", "5"));
        graph.put("3", Arrays.asList("1", "6", "7"));
        graph.put("4", Arrays.asList("2", "8"));
        graph.put("5", Arrays.asList("2", "8"));
        graph.put("6", Arrays.asList("3", "8", "9"));
        graph.put("7", Arrays.asList("3", "9"));
        graph.put("8", Arrays.asList("4", "5", "6"));
        graph.put("9", Arrays.asList("6", "7"));

    }
    /**
     * 深度优先遍历*/
    private Stack <String> stack = new Stack<String>();
    public void DFS(String start){
        stack.push(start);
        status.put(start,true);
        System.out.print(start);
        dfsLoop();
    }

    public void dfsLoop(){
        if(stack.empty()){
            return;
        }
        String stackTop = stack.peek();
        List<String> neighborPoints = graph.get(stackTop);
        for (String point:neighborPoints) {
            if(!status.getOrDefault(point,false)){
                stack.push(point);
                status.put(point,true);
                System.out.print(point);
                dfsLoop();
            }
        }
    }


   /**
    * 广度优先遍历*/
   private Queue<String> queue = new LinkedList<String>();
   public void BFS(String start){
       queue.add(start);
       status.put(start,false);
       bfsLoop();
   }
   public void bfsLoop(){
       String queueLeader = queue.poll();
       status.put(queueLeader,true);
       System.out.print(queueLeader);
       List<String> neighborPoints = graph.get(queueLeader);
       for (String point:neighborPoints) {
           if(!status.getOrDefault(point,false)){
               if(queue.contains(point)){
                   continue;
               }
               queue.add(point);
               status.put(point,false);
           }
       }
       if(!queue.isEmpty()){
           bfsLoop();
       }
   }

   public void demo(List<User> list){
       User user = new User();
       user.setLevel(9);
       list.add(user);
   }

    public static void main(String[] args){
       /* TuDemo tuDemo = new TuDemo();
        tuDemo.init();
        //tuDemo.DFS("1");
        tuDemo.BFS("1");*/

      /* List<User> list = new ArrayList<>();
       List<User> list1 = new ArrayList<>();

       User user = new User();
       user.setLevel(1);
       list.add(user);

       user.setLevel(9);
       list1.add(user);*/

      List<User> list = new ArrayList();
      TuDemo tuDemo = new TuDemo();
      tuDemo.demo(list);
        for (User u:list) {
            System.out.println(u.getLevel());
        }





}}
