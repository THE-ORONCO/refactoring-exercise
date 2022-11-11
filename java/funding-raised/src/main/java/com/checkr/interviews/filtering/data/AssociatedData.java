package com.checkr.interviews.filtering.data;

import com.checkr.interviews.filtering.Filterable;

import java.util.Map;

public class AssociatedData<K,V> implements Filterable<K,V> {
    private final Map<K,V> keyValuePairs;

    public AssociatedData(Map<K,V> keyValuePairs) {
        this.keyValuePairs = keyValuePairs;
    }

    @Override
    public Map<K,V> getValues() {
        return keyValuePairs;
    }
}
