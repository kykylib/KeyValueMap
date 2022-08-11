import java.util.Arrays;
import java.util.function.BiConsumer;

public class KeyValueMap2<K, V> {

    private Object[] dataArray = new Object[10];

    public KeyValueMap2() {

    }

    public KeyValueMap2(KeyValueMap2<? extends K, V> keyValueMap2) {
        initialization((KeyValueMap2<K, V>) keyValueMap2);
    }

    private void initialization(KeyValueMap2 <K, V> keyValueMap2){
        if(this.dataArray.length!=keyValueMap2.dataArray.length) {
            Object[] newDataArray = new Object[keyValueMap2.dataArray.length];
            for (int i = 0; i < keyValueMap2.dataArray.length; i++) {
                newDataArray[i] = keyValueMap2.dataArray[i];
            }
            this.dataArray = newDataArray;
            return;
        }
        for(int i = 0; i<keyValueMap2.dataArray.length;i++){
            this.dataArray[i] = keyValueMap2.dataArray[i];
        }
        return;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < dataArray.length; i++) {
            Object[] keyValuePair = (Object[]) dataArray[i];
            if (keyValuePair == null) {
                continue;
            }
            if (keyValuePair[0] == null) {
                continue;
            }
            Object keyCurrent = keyValuePair[0];
            if (keyCurrent.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public void put(K key, V value) {
        int index = getIndexByKey(key);
        if (exists(index)) {
            Object[] keyValueArray = (Object[]) dataArray[index];
            keyValueArray[1] = value;
            return;
        }
        if (hasEmptyBucket()) {
            for (int i = 0; i < dataArray.length; i++) {
                if (dataArray[i] == null) {
                    Object[] keyValuePair = new Object[]{key, value};
                    dataArray[i] = keyValuePair;
                    return;
                }
                Object[] keyValueArray = (Object[]) dataArray[i];
                if (keyValueArray[0] == null) {
                    keyValueArray[0] = key;
                    keyValueArray[1] = value;
                    return;
                }
            }
        }
        Object[] newDataArray = new Object[dataArray.length + 10];
        for (int i = 0; i < dataArray.length; i++) {
            newDataArray[i] = dataArray[i];
        }
        Object[] newKeyValue = new Object[]{key, value};
        newDataArray[dataArray.length] = newKeyValue;
        dataArray = newDataArray;

    }

    private boolean exists(int index) {
        return index != -1;
    }

    private boolean hasEmptyBucket() {
        Object[] keyValueArray = (Object[]) dataArray[dataArray.length - 1];
        return keyValueArray == null || keyValueArray[0] == null;
    }

    public V get(K key) {
        int index = getIndexByKey(key);
        Object[] keyValueArray = (Object[]) dataArray[index];
        return index == -1 ? null : (V) keyValueArray[1];
    }

    public void clear() {
        dataArray = new Object[10];
    }

    public void forEach(BiConsumer<K, V> biConsumer) {

        for (int i = 0; i < dataArray.length; i++) {
            Object[] keyValueArray = (Object[]) dataArray[i];
            if (keyValueArray == null) {
                continue;
            }
            K key = (K) keyValueArray[0];
            V value = (V) keyValueArray[1];
            biConsumer.accept(key, value);
        }

    }


    @Override
    public String toString() {
        String s = "_";
        for (int i = 0; i < dataArray.length; i++) {
            Object[] keyValueArray = (Object[]) dataArray[i];
            s += Arrays.toString(keyValueArray);
        }
        return s;
    }
}
