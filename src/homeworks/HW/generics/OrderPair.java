package homeworks.HW.generics;

public class OrderPair <K,V> implements Pair {

    private K key;
    private V value;

    public OrderPair (K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
