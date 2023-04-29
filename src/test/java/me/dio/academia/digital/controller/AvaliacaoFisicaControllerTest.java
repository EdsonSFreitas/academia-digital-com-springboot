package me.dio.academia.digital.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import java.util.ArrayList;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;

import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AvaliacaoFisicaController.class})
@ExtendWith(SpringExtension.class)
class AvaliacaoFisicaControllerTest {
    @Autowired
    private AvaliacaoFisicaController avaliacaoFisicaController;

    @MockBean
    private AvaliacaoFisicaServiceImpl avaliacaoFisicaServiceImpl;

    /**
     * Method under test: {@link AvaliacaoFisicaController#create(AvaliacaoFisicaForm)}
     */
    @Test
    void testCreate() throws Exception {
        when(avaliacaoFisicaServiceImpl.getAll()).thenReturn(new ArrayList<>());

        AvaliacaoFisicaForm avaliacaoFisicaForm = new AvaliacaoFisicaForm();
        avaliacaoFisicaForm.setAltura(10.0d);
        avaliacaoFisicaForm.setAlunoId(1L);
        avaliacaoFisicaForm.setPeso(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(avaliacaoFisicaForm);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/avaliacoes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(avaliacaoFisicaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AvaliacaoFisicaController#getAll()}
     */
    @Test
    void testGetAll() throws Exception {
        when(avaliacaoFisicaServiceImpl.getAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/avaliacoes");
        MockMvcBuilders.standaloneSetup(avaliacaoFisicaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AvaliacaoFisicaController#getAll()}
     */
    @Test
    void testGetAll2() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("?");
        aluno.setCpf("?");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("?");

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);

        ArrayList<AvaliacaoFisica> avaliacaoFisicaList = new ArrayList<>();
        avaliacaoFisicaList.add(avaliacaoFisica);
        when(avaliacaoFisicaServiceImpl.getAll()).thenReturn(avaliacaoFisicaList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/avaliacoes");
        MockMvcBuilders.standaloneSetup(avaliacaoFisicaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"aluno\":{\"id\":1,\"nome\":\"?\",\"cpf\":\"?\",\"bairro\":\"?\",\"dataDeNascimento\":[1970,1,1]},\"dataDaAvaliacao"
                                        + "\":[1970,1,1,0,0],\"peso\":10.0,\"altura\":10.0}]"));
    }

    /**
     * Method under test: {@link AvaliacaoFisicaController#create(AvaliacaoFisicaForm)}
     */
    @Test
    void testCreate2() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("?");
        aluno.setCpf("?");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("?");

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);

        ArrayList<AvaliacaoFisica> avaliacaoFisicaList = new ArrayList<>();
        avaliacaoFisicaList.add(avaliacaoFisica);
        when(avaliacaoFisicaServiceImpl.getAll()).thenReturn(avaliacaoFisicaList);

        AvaliacaoFisicaForm avaliacaoFisicaForm = new AvaliacaoFisicaForm();
        avaliacaoFisicaForm.setAltura(10.0d);
        avaliacaoFisicaForm.setAlunoId(1L);
        avaliacaoFisicaForm.setPeso(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(avaliacaoFisicaForm);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/avaliacoes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(avaliacaoFisicaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"aluno\":{\"id\":1,\"nome\":\"?\",\"cpf\":\"?\",\"bairro\":\"?\",\"dataDeNascimento\":[1970,1,1]},\"dataDaAvaliacao"
                                        + "\":[1970,1,1,0,0],\"peso\":10.0,\"altura\":10.0}]"));
    }
}