import java.util.Date;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        KeyValueMap2 <String, Date> keyValueMap2 = new KeyValueMap2 <> ();

        keyValueMap2.put("str1",new Date(2000,1,13));
        keyValueMap2.put("str2",new Date(20));
        keyValueMap2.put("str3",new Date(30));
        keyValueMap2.put("str4",new Date(40));
        keyValueMap2.put("str5",new Date(50));
        keyValueMap2.put("str6",new Date(60));
        keyValueMap2.put("str7",new Date(2010,2,17));
        keyValueMap2.put("str8",new Date(80));
        keyValueMap2.put("str9",new Date(90));
        keyValueMap2.put("str0",new Date(100));
        keyValueMap2.put("str10",new Date(2020,3,18));


        System.out.println(keyValueMap2.get("str1"));
        System.out.println(keyValueMap2.get("str7"));
        System.out.println(keyValueMap2.get("str10"));

        keyValueMap2.put("str7", new Date(1000,2,12));
        System.out.println(keyValueMap2.get("str7"));

        BiConsumer <String,Date> biConsumer = new BiConsumer <> () {
            @Override
            public void accept(String s, Date date) {
                keyValueMap2.toString();
            }
        };

        keyValueMap2.forEach(biConsumer);

        System.out.println(keyValueMap2);

        KeyValueMap2 <String, Date> objectKeyValue = new KeyValueMap2 <String, Date> (keyValueMap2);

        objectKeyValue.put("xsaxsa",new Date(90));
        System.out.println(objectKeyValue);

    }
}
