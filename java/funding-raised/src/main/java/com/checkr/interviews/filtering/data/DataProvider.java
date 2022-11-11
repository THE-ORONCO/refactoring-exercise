package com.checkr.interviews.filtering.data;

import com.checkr.interviews.filtering.Filterable;

import java.util.List;

public interface DataProvider<K, V, F extends Filterable<K, V>> {
    List<F> getParsedData();
}
