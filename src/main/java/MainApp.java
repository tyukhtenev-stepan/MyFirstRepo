import java.util.*;

public class MainApp {

    public static void main(String args[]) {
        for (int i=0; i < args.length; i++) {
            System.out.println("args[" + i + "]= " + args[i]);
        }
        List<String> slist = new ArrayList<>();
        for (String s: args) {
            slist.add(s);
        }
        Collections.sort(slist, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (String s : slist) {
            System.out.println(s);
        }
    }
}
