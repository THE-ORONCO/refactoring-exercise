package com.checkr.interviews;

import com.checkr.interviews.data.CSVDataProvider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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

    public static void main(String[] args) {
        try {
            Map<String, String> options = new HashMap<>();
            options.put("company_name", "Facebook");
            options.put("round", "a");
            System.out.print(FundingRaised.where(options).size());
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}

