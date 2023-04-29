package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
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

@ContextConfiguration(classes = {AvaliacaoFisicaServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AvaliacaoFisicaServiceImplTest {
    @MockBean
    private AlunoRepository alunoRepository;

    @MockBean
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AvaliacaoFisicaServiceImpl avaliacaoFisicaServiceImpl;

    /**
     * Method under test: {@link AvaliacaoFisicaServiceImpl#create(AvaliacaoFisicaForm)}
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
        Optional<Aluno> ofResult = Optional.of(aluno);
        when(alunoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno2);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);
        when(avaliacaoFisicaRepository.save(Mockito.<AvaliacaoFisica>any())).thenReturn(avaliacaoFisica);
        assertSame(avaliacaoFisica, avaliacaoFisicaServiceImpl.create(new AvaliacaoFisicaForm()));
        verify(alunoRepository).findById(Mockito.<Long>any());
        verify(avaliacaoFisicaRepository).save(Mockito.<AvaliacaoFisica>any());
    }


    /**
     * Method under test: {@link AvaliacaoFisicaServiceImpl#get(Long)}
     */
    @Test
    void testGet() {
        assertNull(avaliacaoFisicaServiceImpl.get(1L));
    }

    /**
     * Method under test: {@link AvaliacaoFisicaServiceImpl#getAll()}
     */
    @Test
    void testGetAll() {
        ArrayList<AvaliacaoFisica> avaliacaoFisicaList = new ArrayList<>();
        when(avaliacaoFisicaRepository.findAll()).thenReturn(avaliacaoFisicaList);
        List<AvaliacaoFisica> actualAll = avaliacaoFisicaServiceImpl.getAll();
        assertSame(avaliacaoFisicaList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(avaliacaoFisicaRepository).findAll();
    }

    /**
     * Method under test: {@link AvaliacaoFisicaServiceImpl#update(Long, AvaliacaoFisicaUpdateForm)}
     */
    @Test
    void testUpdate() {
        assertNull(avaliacaoFisicaServiceImpl.update(1L, new AvaliacaoFisicaUpdateForm()));
        assertNull(avaliacaoFisicaServiceImpl.update(1L, mock(AvaliacaoFisicaUpdateForm.class)));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link AvaliacaoFisicaServiceImpl}
     *   <li>{@link AvaliacaoFisicaServiceImpl#delete(Long)}
     * </ul>
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     AvaliacaoFisicaServiceImpl.alunoRepository
        //     AvaliacaoFisicaServiceImpl.avaliacaoFisicaRepository

        (new AvaliacaoFisicaServiceImpl()).delete(1L);
    }
}