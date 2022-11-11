package com.checkr.interviews.filtering.data;

import com.checkr.interviews.filtering.Filterable;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static com.checkr.interviews.filtering.data.DataUtils.zip;

public class CSVDataProvider implements DataProvider<String, String, Filterable<String, String>> {
    private static final long HEADER_SIZE = 1L;
    List<Filterable<String, String>> parsedData;


    public CSVDataProvider(File csvFile) throws IOException {
        CSVReader csvReader = createCSVReader(csvFile);

        List<String[]> csvData = csvReader.readAll();
        parseData(csvData);

        csvReader.close();
    }

    private static CSVReader createCSVReader(File csvFile) throws FileNotFoundException {
        FileReader fileReader = new FileReader(csvFile);
        return new CSVReader(fileReader);
    }

    private void parseData(List<String[]> csvData) {
        if (csvData.isEmpty())
            parsedData = List.of();
        else
            parsedData = headerMappedData(csvData);
    }

    private List<Filterable<String, String>> headerMappedData(List<String[]> csvData) {
        String[] headers = csvData.get(0);

        return csvData.stream()
                .skip(HEADER_SIZE)
                .map(values -> associate(headers, values))
                .toList();
    }

    private Filterable<String, String> associate(String[] headers, String[] values) {
        if (headers.length != values.length)
            throw new IllegalArgumentException("There should be the same number of headers and values");

        else
            return new AssociatedData<>(zip(headers, values));

    }

    @Override
    public List<Filterable<String, String>> getParsedData() {
        return parsedData;
    }
}
