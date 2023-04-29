package me.dio.academia.digital.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import me.dio.academia.digital.entity.form.ExerciciosForm;
import me.dio.academia.digital.service.impl.ExerciciosServiceImpl;
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

@ContextConfiguration(classes = {ExerciciosController.class})
@ExtendWith(SpringExtension.class)
class ExerciciosControllerTest {
    @Autowired
    private ExerciciosController exerciciosController;

    @MockBean
    private ExerciciosServiceImpl exerciciosServiceImpl;

    /**
     * Method under test: {@link ExerciciosController#create(ExerciciosForm)}
     */
    @Test
    void testCreate() throws Exception {
        when(exerciciosServiceImpl.getAll()).thenReturn(new ArrayList<>());

        ExerciciosForm exerciciosForm = new ExerciciosForm();
        exerciciosForm.setAlunoId(1L);
        exerciciosForm.setExercicio("Exercicio");
        exerciciosForm.setPeso(10.0d);
        exerciciosForm.setSerie(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(exerciciosForm);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exercicios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(exerciciosController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ExerciciosController#getAll()}
     */
    @Test
    void testGetAll() throws Exception {
        when(exerciciosServiceImpl.getAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exercicios");
        MockMvcBuilders.standaloneSetup(exerciciosController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ExerciciosController#getAll()}
     */
    @Test
    void testGetAll2() throws Exception {
        when(exerciciosServiceImpl.getAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exercicios");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(exerciciosController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}