/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Data structure that supports push pop min and max in O(1)
 *  Space traded off for time
 * @author hp
 */
import java.*;
import java.util.ArrayList;
public class MinMaxStack {
    private int max ;
    private int min ;
    ArrayList <Node> myStack ;
    // inner class
    private class Node{
        private int data;
        private int Max;
        private int Min;
        
        public Node(int data){
            this.data = data;       
        }  
    }
    public MinMaxStack(){
        myStack = new ArrayList();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
    
    public void push(int data){
         Node x = new Node(data);
         if(myStack.isEmpty()){
            x.Max = data;
            x.Min = data;
            max = data;
            min = data;
        }
        else{
            if(data > max){
                // incoming more than max        
                x.Max = data;
                x.Min = min;
            }
            if(data < min){
                x.Min = data;
                x.Max = max;
                
            }
             
        }
        myStack.add(x);
    }
    public Node pop(){
        if(myStack.isEmpty()){
            return null;
        }
        else{
            int len = myStack.size() - 1;
            Node tmp = myStack.remove(len);   
                if(!myStack.isEmpty()){
                    if(tmp.data == min){
                //new min 
                    Node x = myStack.get(myStack.size() - 1);
                    min = x.Min;
                }
                if(tmp .data == max){
                    Node x = myStack.get(myStack.size()-1);
                    max = x.Max;
                }
                else{
                    max = Integer.MIN_VALUE;
                    min = Integer.MAX_VALUE;
                }
            }
           return tmp;
        }
    }
}
