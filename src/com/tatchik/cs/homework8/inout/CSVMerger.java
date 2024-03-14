package com.tatchik.cs.homework8.inout;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVMerger {
    public static Map<Integer, String[]> readCsv(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                .skip(1) // Skip header line
                .map(line -> line.split(","))
                .collect(Collectors.toMap(arr -> Integer.parseInt(arr[0]), Function.identity()));
    }

    public static void mergeCsv(Map<Integer, String[]> prices, Map<Integer, String[]> names, String resultFilename, String errorsFilename) {
        try {
            Files.write(Paths.get(resultFilename), Stream.concat(Stream.of("ID,NAME,PRICE"),
                            prices.entrySet().stream()
                                    .filter(entry -> names.containsKey(entry.getKey()))
                                    .map(entry -> {
                                        String[] priceData = entry.getValue();
                                        String[] nameData = names.get(entry.getKey());
                                        return entry.getKey() + "," + nameData[1] + "," + priceData[1];
                                    }))
                    .collect(Collectors.toList()));

            Files.write(Paths.get(errorsFilename), Stream.concat(Stream.of("ID"),
                            prices.entrySet().stream()
                                    .filter(entry -> !names.containsKey(entry.getKey()))
                                    .map(entry -> String.valueOf(entry.getKey())))
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

