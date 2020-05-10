import java.util.HashMap;

public class LRU<U,V>{

 HashMap<U,Node<U,V>> map;
 Node<U,V> head;
 Node<U,V> tail;
 int maxsize;
 int size;

 LRU(int size){
    this.maxsize=size;
    map=new HashMap<>();

 }
 public void insert(U key,V value){
     if(map.containsKey(key)){
        Node<U,V> node =map.get(key);
        node.data=value;
     }else {
         
        Node<U,V> newNode = new Node<U,V>(key,value);
        if(size==0)
        {
               head=newNode;
               tail=newNode;
               map.put(key, newNode);
               size++;

               
        }else
        {

            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            size++;
            map.put(key, newNode);



        if(size>maxsize){
         
            Node<U,V> temp =tail;
            U tailkey =temp.key;
            map.remove(tailkey);
            
            tail =temp.prev;
            tail.next=null;
            size--;

        }

        }
        
        
     }
 }
 public void print(){
     Node<U,V> temp =head;
     System.out.println("printing straight");
     while(temp!=null)
     {
         System.out.println(temp.data);
         temp=temp.next;
     }
     Node<U,V> temp2=tail;
     System.out.println("printing reverse");
     while(temp2!=null)
     {
         System.out.println(temp2.data);
         temp2=temp2.prev;
     }

 }

 public void printrv(){
    
 }

 public V get(U key){
     if(!map.containsKey(key)){
         return null;
     }
     Node<U,V> currNode=map.get(key);
     if(head==currNode)
     {
         return currNode.data;
     }
      
        Node<U,V> prevNode=currNode.prev;
        Node<U,V> nextNode=currNode.next;
        if(nextNode!=null){
            //if curr node is not at tail
            nextNode.prev=prevNode;
        prevNode.next=nextNode;
        currNode.prev=null;
        currNode.next=head;
        head.prev=currNode;
        head=currNode;
        }else{
            //if curr node is tail
            prevNode.next=nextNode;
            currNode.prev=null;
            currNode.next=head;
            head.prev=currNode;
            head=currNode;
            tail=prevNode;
        }

     return currNode.data;

     


 }



}