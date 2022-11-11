package com.checkr.interviews.data;

import java.util.Map;

public class AssociatedData<K,V> implements Filterable<K,V>{
    private final Map<K,V> keyValuePairs;

    public AssociatedData(Map<K,V> keyValuePairs) {
        this.keyValuePairs = keyValuePairs;
    }

    @Override
    public Map<K,V> getValues() {
        return keyValuePairs;
    }
}
