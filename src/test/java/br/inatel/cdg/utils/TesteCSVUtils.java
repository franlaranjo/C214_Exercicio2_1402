package br.inatel.cdg.utils;

import br.inatel.cdg.model.CD;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TesteCSVUtils
{
    private static List<CD> cdList;


    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("SJ_discografia.csv").toURI());
        cdList = CsvUtils.readCDCsv(caminho);
    }

    @Test
    public void testNumberOfLines(){
        int numLines = cdList.size();
        Assert.assertEquals(18,numLines);
    }

}
