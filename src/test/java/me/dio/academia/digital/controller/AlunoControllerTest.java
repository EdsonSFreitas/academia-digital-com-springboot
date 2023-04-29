package me.dio.academia.digital.controller;

import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {AlunoController.class})
@ExtendWith(SpringExtension.class)
class AlunoControllerTest {
    @Autowired
    private AlunoController alunoController;

    @MockBean
    private AlunoServiceImpl alunoServiceImpl;

    /**
     * Method under test: {@link AlunoController#getAllAvaliacaoFisicaId(Long)}
     */
    @Test
    void testGetAllAvaliacaoFisicaId() throws Exception {
        when(alunoServiceImpl.getAllAvaliacaoFisicaId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/alunos/avaliacoes/{id}", 1L);
        MockMvcBuilders.standaloneSetup(alunoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AlunoController#getAllAvaliacaoFisicaId(Long)}
     */
    @Test
    void testGetAllAvaliacaoFisicaId2() throws Exception {
        when(alunoServiceImpl.getAllAvaliacaoFisicaId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/alunos/avaliacoes/{id}", 1L);
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(alunoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AlunoController#getAll(String)}
     */
    @Test
    void testGetAll() throws Exception {
        when(alunoServiceImpl.getAll(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/alunos");
        MockMvcBuilders.standaloneSetup(alunoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AlunoController#getAll(String)}
     */
    @Test
    void testGetAll2() throws Exception {
        when(alunoServiceImpl.getAll(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/alunos");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(alunoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}