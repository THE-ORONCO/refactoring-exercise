package com.checkr.interviews;

import com.checkr.interviews.data.DataProvider;
import com.checkr.interviews.data.Filter;
import com.checkr.interviews.data.Filterable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DataFilterer<K, V> {

    private final DataProvider<K, V, Filterable<K, V>> dataProvider;

    public DataFilterer(DataProvider<K, V, Filterable<K, V>> dataProvider) {
        this.dataProvider = dataProvider;

    }

    public List<Map<K, V>> where(Map<K, V> searchConditions) {
        List<Filter<K, V>> filters = convertToFilters(searchConditions);

        List<Filterable<K, V>> parsedData = dataProvider.getParsedData();

        return parsedData.stream()
                .filter(dataPoint -> dataPoint.matches(filters))
                .map(Filterable::getValues)
                .toList();
    }

    private List<Filter<K, V>> convertToFilters(Map<K, V> searchConditions) {
        return searchConditions.entrySet()
                .stream().map(pair -> new Filter<>(pair.getKey(), pair.getValue())).toList();
    }

    public Map<K, V> findBy(Map<K, V> searchConditions) throws NoSuchEntryException {
        Optional<Map<K, V>> result = where(searchConditions).stream().findFirst();

        if (result.isPresent())
            return result.get();
        else
            throw new NoSuchEntryException();
    }
}
