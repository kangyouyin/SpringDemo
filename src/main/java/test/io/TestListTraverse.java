package test.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kangyouyin on 2018/10/19.
 */
public class TestListTraverse {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("hah");
        list.add("nnnn");

        //第一种遍历
        for (String str: list) {
            System.out.println(str);
        }

        //第二种遍历
        String[] listArrays = new String[list.size()];
        list.toArray(listArrays);
        for (int i = 0; i < listArrays.length; i++) {
            System.out.println(listArrays[i]);
        }

        //第三种遍历
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
