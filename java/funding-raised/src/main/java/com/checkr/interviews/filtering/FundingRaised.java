package com.checkr.interviews.filtering;

import com.checkr.interviews.filtering.exception.NoSuchEntryException;
import com.checkr.interviews.filtering.data.CSVDataProvider;
import com.checkr.interviews.filtering.data.DataFilterer;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FundingRaised{
    public static List<Map<String, String>> where(Map<String, String> searchConditions) throws IOException {
        DataFilterer<String, String> filterer = readData();

        return filterer.where(searchConditions);
    }

    public static Map<String, String> findBy(Map<String, String> searchConditions) throws IOException, NoSuchEntryException {
        DataFilterer<String, String> filterer = readData();

        return filterer.findBy(searchConditions);
    }

    private static DataFilterer<String, String> readData() throws IOException {
        CSVDataProvider dataProvider = new CSVDataProvider(new File("startup_funding.csv"));
        return new DataFilterer<>(dataProvider);
    }


}

