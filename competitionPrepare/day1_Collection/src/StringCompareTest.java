import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * 字符串排序
 */
public class StringCompareTest {

    public static void main(String[] args){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ACD");
        arrayList.add("acd");
        arrayList.add("biu");

        //默认情况下，按照升序排序
//        Collections.sort(arrayList);
//        System.out.println(arrayList);

        //改为降序排序
        Collections.sort(arrayList, new Comparator<String>(){
            public int compare(String o1, String o2){
                return o2.charAt(0)-o1.charAt(0);
            }
        });
        System.out.println(arrayList);
    }
}
