package br.inatel.cdg.service;


import br.inatel.cdg.model.CD;
import br.inatel.cdg.model.Gravadora;
import br.inatel.cdg.model.Tipo;
import br.inatel.cdg.utils.CsvUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TesteServiceCDMock {


    @Mock
    ServiceCD serviceCD;

    private static List<CD> cdList;

    @Test
    public void testeCDEstudio(){
        when(serviceCD.getByTipo(any(), any())).thenReturn(Arrays.asList(new CD(), new CD()));

        List<CD> tipoEstudio = serviceCD.getByTipo(cdList, Tipo.Estudio);

        Assert.assertEquals(2,tipoEstudio.size());
    }

    @Test
    public void testeCDUniversal(){
        when(serviceCD.getListByGravadora(any(), any())).thenReturn(Arrays.asList(new CD(), new CD(), new CD()));

        List<CD> gravadoraUniversal = serviceCD.getListByGravadora(cdList, Gravadora.Universal);

        Assert.assertEquals(3,gravadoraUniversal.size());
    }

}
