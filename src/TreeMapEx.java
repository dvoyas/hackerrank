import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx {

//    public static void main(String[] args) { //A-Z ordered
//        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
//        map.put("Third", 1);
//        map.put("First", 2);
//        map.put("ASecond", 3);
//
//        for (String key : map.keySet()) {
//            System.out.println(key + " ,ID = " + map.get(key));
//        }
//    }

    public static void main(String[] args) { //Ordered according to In (entered by put)
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("Third", 13);
        map.put("First", 200);
        map.put("Second", 3);

        for (String key : map.keySet()) {
            System.out.println(key + " ,ID = " + map.get(key));
        }
    }

}
