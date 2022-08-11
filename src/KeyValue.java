import java.util.Date;

public class KeyValue <T,V>{
    private T key;
    private V value;

    public KeyValue(T key,V value){
        this.key = key;
        this.value = value;
    }

    public KeyValue(KeyValueMap2<V, Date> keyValueMap2) {
    }

    public T getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
