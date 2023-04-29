package me.dio.academia.digital.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import java.util.ArrayList;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;

import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MatriculaController.class})
@ExtendWith(SpringExtension.class)
class MatriculaControllerTest {
    @Autowired
    private MatriculaController matriculaController;

    @MockBean
    private MatriculaServiceImpl matriculaServiceImpl;

    /**
     * Method under test: {@link MatriculaController#create(MatriculaForm)}
     */
    @Test
    void testCreate() throws Exception {
        when(matriculaServiceImpl.getAll(Mockito.<String>any())).thenReturn(new ArrayList<>());

        MatriculaForm matriculaForm = new MatriculaForm();
        matriculaForm.setAlunoId(1L);
        String content = (new ObjectMapper()).writeValueAsString(matriculaForm);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/matriculas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(matriculaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link MatriculaController#getAll(String)}
     */
    @Test
    void testGetAll() throws Exception {
        when(matriculaServiceImpl.getAll(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/matriculas");
        MockMvcBuilders.standaloneSetup(matriculaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link MatriculaController#getAll(String)}
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

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula.setId(1L);

        ArrayList<Matricula> matriculaList = new ArrayList<>();
        matriculaList.add(matricula);
        when(matriculaServiceImpl.getAll(Mockito.<String>any())).thenReturn(matriculaList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/matriculas");
        MockMvcBuilders.standaloneSetup(matriculaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"aluno\":{\"id\":1,\"nome\":\"?\",\"cpf\":\"?\",\"bairro\":\"?\",\"dataDeNascimento\":[1970,1,1]},\"dataDaMatricula"
                                        + "\":[1970,1,1,0,0]}]"));
    }

    /**
     * Method under test: {@link MatriculaController#create(MatriculaForm)}
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

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula.setId(1L);

        ArrayList<Matricula> matriculaList = new ArrayList<>();
        matriculaList.add(matricula);
        when(matriculaServiceImpl.getAll(Mockito.<String>any())).thenReturn(matriculaList);

        MatriculaForm matriculaForm = new MatriculaForm();
        matriculaForm.setAlunoId(1L);
        String content = (new ObjectMapper()).writeValueAsString(matriculaForm);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/matriculas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(matriculaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"aluno\":{\"id\":1,\"nome\":\"?\",\"cpf\":\"?\",\"bairro\":\"?\",\"dataDeNascimento\":[1970,1,1]},\"dataDaMatricula"
                                        + "\":[1970,1,1,0,0]}]"));
    }
}