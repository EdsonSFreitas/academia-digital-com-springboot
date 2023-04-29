package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
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

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {MatriculaServiceImpl.class})
@ExtendWith(SpringExtension.class)
class MatriculaServiceImplTest {
    @MockBean
    private AlunoRepository alunoRepository;

    @MockBean
    private MatriculaRepository matriculaRepository;

    @Autowired
    private MatriculaServiceImpl matriculaServiceImpl;

    /**
     * Method under test: {@link MatriculaServiceImpl#create(MatriculaForm)}
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

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno2);
        matricula.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula.setId(1L);
        when(matriculaRepository.save(Mockito.<Matricula>any())).thenReturn(matricula);
        assertSame(matricula, matriculaServiceImpl.create(new MatriculaForm()));
        verify(alunoRepository).findById(Mockito.<Long>any());
        verify(matriculaRepository).save(Mockito.<Matricula>any());
    }

    /**
     * Method under test: {@link MatriculaServiceImpl#get(Long)}
     */
    @Test
    void testGet() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula.setId(1L);
        Optional<Matricula> ofResult = Optional.of(matricula);
        when(matriculaRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertSame(matricula, matriculaServiceImpl.get(1L));
        verify(matriculaRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link MatriculaServiceImpl#getAll(String)}
     */
    @Test
    void testGetAll() {
        ArrayList<Matricula> matriculaList = new ArrayList<>();
        when(matriculaRepository.findAlunosMatriculadosBairro(Mockito.<String>any())).thenReturn(matriculaList);
        List<Matricula> actualAll = matriculaServiceImpl.getAll("Bairro");
        assertSame(matriculaList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(matriculaRepository).findAlunosMatriculadosBairro(Mockito.<String>any());
    }

    /**
     * Method under test: {@link MatriculaServiceImpl#getAll(String)}
     */
    @Test
    void testGetAll2() {
        ArrayList<Matricula> matriculaList = new ArrayList<>();
        when(matriculaRepository.findAll()).thenReturn(matriculaList);
        when(matriculaRepository.findAlunosMatriculadosBairro(Mockito.<String>any())).thenReturn(new ArrayList<>());
        List<Matricula> actualAll = matriculaServiceImpl.getAll(null);
        assertSame(matriculaList, actualAll);
        assertTrue(actualAll.isEmpty());
        verify(matriculaRepository).findAll();
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link MatriculaServiceImpl}
     *   <li>{@link MatriculaServiceImpl#delete(Long)}
     * </ul>
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     MatriculaServiceImpl.alunoRepository
        //     MatriculaServiceImpl.matriculaRepository

        (new MatriculaServiceImpl()).delete(1L);
    }
}