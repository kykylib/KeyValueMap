import java.util.function.BiConsumer;

public class KeyValueMap<K, V> {

    private KeyValue[] originMap = new KeyValue[10];

    public KeyValueMap(KeyValueMap originMap) {
        this.originMap = originMap.originMap;
    }

    public KeyValueMap() {
    }

    public void put(K key, V value) {
        KeyValue<K,V> keyValue = new KeyValue<>(key, value);
        if (originMap[originMap.length - 1] != null) {
            KeyValue[] originMap2 = new KeyValue[originMap.length * 2];
            for (int i = 0; i < originMap.length; i++) {
                originMap2[i] = originMap[i];
            }
            originMap = originMap2;
        }
        for (int i = 0; i < originMap.length; i++) {
            if (originMap[i] != null) {
                if (originMap[i].getKey().equals(keyValue.getKey())) {
                    System.out.println("The keys are the same");
                    break;
                }
            }
            if (originMap[i] == null) {
                originMap[i] = keyValue;
                break;
            }
        }
    }

    public V get(K key) {
        for(int i =0; i<originMap.length;i++){
            if(originMap[i] == null){
                break;
            }
            if(originMap[i].getKey().equals(key)){
                System.out.println((V)originMap[i].getValue());
                return (V) originMap[i].getValue();
            }
        }
        return null;
    }

    public void clear() {
        for (int i =0;i<originMap.length;i++){
         originMap[i]=null;
        }
    }

    public void forEach(BiConsumer biConsumer) {
        for (int i=0;i<originMap.length;i++){
            if(originMap[i]!=null){
                biConsumer.accept(originMap[i].getKey(),originMap[i].getValue());
            }
        }

    }

}
