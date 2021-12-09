package br.inatel.cdg.service;


import br.inatel.cdg.model.CD;
import br.inatel.cdg.model.Gravadora;
import br.inatel.cdg.model.Tipo;
import br.inatel.cdg.utils.CsvUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class TesteServiceCD {

    private ServiceCD serviceCD = new ServiceCD();
    private static List<CD> cdList;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("SJ_discografia.csv").toURI());
        cdList = CsvUtils.readCDCsv(caminho);
    }

    @Test
    public void testeCDEstudio(){
        List<CD> tipoEstudio = serviceCD.getByTipo(cdList, Tipo.Estudio);

        Assert.assertEquals(12,tipoEstudio.size());
    }

    @Test
    public void testeCDUniversal(){
        List<CD> gravadoraUniversal = serviceCD.getListByGravadora(cdList, Gravadora.Universal);

        Assert.assertEquals(10,gravadoraUniversal.size());
    }

    @Test
    public void testeCDPolyGram(){
        List<CD> gravadoraPolyGram  = serviceCD.getListByGravadora(cdList, Gravadora.PolyGram);

        Assert.assertEquals(4,gravadoraPolyGram.size());
    }

}
