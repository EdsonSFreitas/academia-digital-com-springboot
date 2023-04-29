package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {AlunoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AlunoServiceImplTest {
    @MockBean
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoServiceImpl alunoServiceImpl;

    /**
     * Method under test: {@link AlunoServiceImpl#create(AlunoForm)}
     */
    @Test
    void testCreate() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");
        when(alunoRepository.save(Mockito.<Aluno>any())).thenReturn(aluno);
        assertSame(aluno, alunoServiceImpl.create(new AlunoForm()));
        verify(alunoRepository).save(Mockito.<Aluno>any());
    }


    /**
     * Method under test: {@link AlunoServiceImpl#get(Long)}
     */
    @Test
    void testGet() {
        assertNull(alunoServiceImpl.get(1L));
    }


    /**
     * Method under test: {@link AlunoServiceImpl#getAll(String)}
     */
    @Test
    void testGetAll2() {
        ArrayList<Aluno> alunoList = new ArrayList<>();
        when(alunoRepository.findAll()).thenReturn(alunoList);
        List<Aluno> actualAll = alunoServiceImpl.getAll(null);
        assertSame(alunoList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(alunoRepository).findAll();
    }

    /**
     * Method under test: {@link AlunoServiceImpl#update(Long, AlunoUpdateForm)}
     */
    @Test
    void testUpdate() {
        assertNull(alunoServiceImpl.update(1L, new AlunoUpdateForm()));
        assertNull(alunoServiceImpl.update(1L, mock(AlunoUpdateForm.class)));
    }

    /**
     * Method under test: {@link AlunoServiceImpl#getAllAvaliacaoFisicaId(Long)}
     */
    @Test
    void testGetAllAvaliacaoFisicaId() {
        Aluno aluno = new Aluno();
        ArrayList<AvaliacaoFisica> avaliacoes = new ArrayList<>();
        aluno.setAvaliacoes(avaliacoes);
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");
        Optional<Aluno> ofResult = Optional.of(aluno);
        when(alunoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        List<AvaliacaoFisica> actualAllAvaliacaoFisicaId = alunoServiceImpl.getAllAvaliacaoFisicaId(1L);
        assertSame(avaliacoes, actualAllAvaliacaoFisicaId);
        assertTrue(actualAllAvaliacaoFisicaId.isEmpty());
        verify(alunoRepository).findById(Mockito.<Long>any());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link AlunoServiceImpl}
     *   <li>{@link AlunoServiceImpl#delete(Long)}
     * </ul>
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     AlunoServiceImpl.repository

        (new AlunoServiceImpl()).delete(1L);
    }
}