public class Node<U,V> {
     U key;
    V data;
    Node<U,V> next;
    Node<U,V> prev;
    Node(U key,V data){
        this.key=key;
     this.data=data;
    }
}