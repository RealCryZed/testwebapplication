package testwebapplication;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class FirstTaskCore {

    public Set<String> getSimilarCharacters(Task1 task) {
        Set<String> matchingSet = new TreeSet<>();

        String[] array1 = task.getSequence1().split("\\s+");
        String[] array2 = task.getSequence2().split("\\s+");

        for (int i = 0; i < array1.length; i++) {
            array1[i] = array1[i].replaceAll("[^\\w]", "");
            array2[i] = array1[i].replaceAll("[^\\w]", "");
        }

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                String a1 = array1[i];
                String a2 = array2[j];

                if (a2.contains(a1)) {
                    matchingSet.add(a1);
                }
            }
        }

        return matchingSet;
    }
}
