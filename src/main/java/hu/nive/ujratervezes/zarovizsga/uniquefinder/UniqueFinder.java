package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> uniqueChars(String str) {
        if (str==null) {
            throw new IllegalArgumentException("String is empty!");
        }
        List<Character> result = new ArrayList<>();
        for (char item : str.toCharArray()) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
