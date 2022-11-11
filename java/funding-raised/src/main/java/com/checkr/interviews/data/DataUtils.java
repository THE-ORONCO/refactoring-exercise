package com.checkr.interviews.data;

import java.util.HashMap;
import java.util.Map;

public class DataUtils {
    public static <A, B> Map<A, B> zip(A[] firstValues, B[] secondValues) {

        if (firstValues.length == secondValues.length) {
            Map<A, B> result = new HashMap<>();

            for (int i = 0; i < firstValues.length; i++) {
                result.put(firstValues[i], secondValues[i]);
            }

            return result;
        } else
            throw new IllegalArgumentException("There should be the same number of headers and values");

    }
}
