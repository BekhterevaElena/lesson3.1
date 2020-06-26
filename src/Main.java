import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        {
            ArrayList<String> arr = new ArrayList<String>();
            arr.add("test");
            arr.add("tost");
            arr.add("tort");
            arr.add("tirr");
            arr.add("tank");
            arr.add("tass");
            arr.add("tank");
            arr.add("tost");
            arr.add("tost");
            arr.add("tost");
            arr.add("test");
            Map<String, Integer> states = new HashMap<String, Integer>();
            ListIterator<String> iter = arr.listIterator();
            ArrayList<String> arrClone = new ArrayList<String>();
            while (iter.hasNext()) {
                String str = iter.next();
                arrClone.add(str);
            }
            iter = arr.listIterator();
            while (iter.hasNext()) {
                String str = iter.next();
                ListIterator<String> iterInternal = arrClone.listIterator();
                while (iterInternal.hasNext()) {
                    String strInternal = iterInternal.next();
                    if (iter.nextIndex() != iterInternal.nextIndex()) {
                        if (str == strInternal) {
                            if (states.containsKey(str) == false) {
                                states.put(str, 1);
                                iterInternal.remove();
                            } else {
                                Integer f = states.get(str) + 1;
                                states.put(str, f);
                                iterInternal.remove();
                            }
                        }
                    }
                }
            }
            for (Map.Entry<String, Integer> item : states.entrySet()) {
                System.out.printf("Key: %s Value: %d \n", item.getKey(), item.getValue());
            }

        }

// write your code here
    }
}
