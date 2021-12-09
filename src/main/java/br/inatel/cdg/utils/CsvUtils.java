package br.inatel.cdg.utils;

import br.inatel.cdg.model.CD;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
    public static List<CD> readCDCsv(Path csvFilePath){

        List<CD> cdList = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(csvFilePath);
            CsvToBean<CD> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CD.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            cdList = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cdList;
    }

}
