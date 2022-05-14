package testwebapplication;

import java.util.Set;
import java.util.TreeSet;

public class FirstTask {

    public static void inArray() {
        Set<String> matchingList = new TreeSet<>();

        String[] array1 = new String[] {"arp", "live", "strong"};
        String[] array2 = new String[] {"lively", "alive", "harp", "sharp", "armstrong"};

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                String a1 = array1[i];
                String a2 = array2[j];

                if (a2.contains(a1)) {
                    matchingList.add(a1);
                }
            }
        }

        System.out.println(matchingList);
    }
}
