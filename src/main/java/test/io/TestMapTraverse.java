package test.io;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kangyouyin on 2018/10/19.
 */
public class TestMapTraverse {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "haha");
        map.put("2", "hehe");

        //第一种遍历
        for (String key: map.keySet()) {
            System.out.println("key:" + key + ", value:" + map.get(key));
        }

        //第二种遍历
        for (String value: map.values()) {
            System.out.println("value:" + value);
        }

        //第三种遍历
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
        }

        //第四种遍历
        for(Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
        }
    }



}
