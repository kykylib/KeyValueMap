public class Generic1 <T,V> {
    private T key;
    private V value;

    public Generic1(T key,V value){
        this.key = key;
        this.value = value;
    }

    public T getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
