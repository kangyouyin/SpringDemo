package test.jdbc;

/**
 * Created by kangyouyin on 2018/10/24.
 */
public class CacheTest {
    public static void main(String[] args) {
        DaoTest.poiCache.put("0100", "dm");

        for (int i = 0; i < 3; i++) {
            System.out.println("--- " + i + " ---");
            System.out.println(DaoTest.getPOIList("0100"));
            System.out.println(DaoTest.getPOIList("0101"));
            System.out.println(DaoTest.getPOIList("0102"));
            System.out.println(DaoTest.getPOIList("0103"));
            System.out.println();
        }
    }
}
