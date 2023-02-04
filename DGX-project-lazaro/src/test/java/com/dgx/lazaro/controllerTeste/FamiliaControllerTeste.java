package com.dgx.lazaro.controllerTeste;

import com.dgx.lazaro.controller.FamiliaController;
import com.dgx.lazaro.dto.FamiliaDTO;
import com.dgx.lazaro.service.FamiliaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class FamiliaControllerTeste {

    private MockMvc mockMvc;

    @Mock
    private FamiliaService familiaService;

    @InjectMocks
    private FamiliaController familiaController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(familiaController)
                .build();
    }

    @Test
    public void testConsultarRank_WhenListIsNotEmpty_ShouldReturn200() throws Exception {
        List<FamiliaDTO> familiaDTOList = new ArrayList<>();
        familiaDTOList.add(new FamiliaDTO());

        when(familiaService.getListaOrdenada()).thenReturn(familiaDTOList);

        mockMvc.perform(get("/familia/rank")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testConsultarRank_WhenListIsEmpty_ShouldReturn204() throws Exception {
        List<FamiliaDTO> familiaDTOList = new ArrayList<>();

        when(familiaService.getListaOrdenada()).thenReturn(familiaDTOList);

        mockMvc.perform(get("/familia/rank")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testConsultarRank_WhenExceptionIsThrown_ShouldReturn500() throws Exception {
        when(familiaService.getListaOrdenada()).thenThrow(new Exception());

        mockMvc.perform(get("/familia/rank")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}

