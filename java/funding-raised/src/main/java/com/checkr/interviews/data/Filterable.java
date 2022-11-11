package com.checkr.interviews.data;

import java.util.List;
import java.util.Map;

public interface Filterable<K, V> {

    default boolean matches(Filter<K, V> filter) {
        return getValues().containsKey(filter.key())
                && getValues().get(filter.key()).equals(filter.value());
    }

    default boolean matches(List<Filter<K,V>> filters){
        return filters.stream().allMatch(this::matches);
    }

    Map<K, V> getValues();
}
