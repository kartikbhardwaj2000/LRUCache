public class LRUUse {
    public static void main(String[] args) {
        LRU<String,String> cache =new LRU<>(3);
        cache.insert("key1", "kartik");
        cache.insert("key2", "ritik");
        cache.insert("key3", "rohan");

        cache.insert("key4", "rohit");
        cache.print();


        System.out.println(cache.get("key2"));
        cache.print();


        System.out.println(cache.get("key3"));
        cache.print();

        System.out.println(cache.get("key4"));
        cache.print();

        System.out.println(cache.get("key2"));
        cache.print();

        cache.insert("5", "shyam");
        cache.print();

        System.out.println(cache.get("key3"));
        System.out.println(cache.get("key2"));
        System.out.println(cache.get("key4"));







    }
    
}