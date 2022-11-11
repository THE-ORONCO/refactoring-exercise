package com.checkr.interviews.data;

import java.util.List;

public interface DataProvider<K, V, F extends Filterable<K, V>> {
    List<F> getParsedData();
}
