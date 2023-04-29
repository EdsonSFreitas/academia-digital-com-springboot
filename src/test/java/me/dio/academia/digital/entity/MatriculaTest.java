package me.dio.academia.digital.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MatriculaTest {
    /**
     * Method under test: {@link Matricula#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Matricula()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Matricula#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
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

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Matricula matricula2 = new Matricula();
        matricula2.setAluno(aluno2);
        matricula2.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula2.setId(1L);
        assertTrue(matricula.canEqual(matricula2));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Matricula#Matricula()}
     *   <li>{@link Matricula#setAluno(Aluno)}
     *   <li>{@link Matricula#setDataDaMatricula(LocalDateTime)}
     *   <li>{@link Matricula#setId(Long)}
     *   <li>{@link Matricula#toString()}
     *   <li>{@link Matricula#getAluno()}
     *   <li>{@link Matricula#getDataDaMatricula()}
     *   <li>{@link Matricula#getId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Matricula actualMatricula = new Matricula();
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");
        actualMatricula.setAluno(aluno);
        LocalDateTime dataDaMatricula = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualMatricula.setDataDaMatricula(dataDaMatricula);
        actualMatricula.setId(1L);
        String actualToStringResult = actualMatricula.toString();
        assertSame(aluno, actualMatricula.getAluno());
        assertSame(dataDaMatricula, actualMatricula.getDataDaMatricula());
        assertEquals(1L, actualMatricula.getId().longValue());
        assertEquals("Matricula(id=1, aluno=Aluno(id=1, nome=Nome, cpf=Cpf, bairro=Bairro, dataDeNascimento=1970-01-01,"
                + " avaliacoes=[]), dataDaMatricula=1970-01-01T00:00)", actualToStringResult);
    }

    /**
     * Method under test: {@link Matricula#Matricula()}
     */
    @Test
    void testConstructor2() {
        Matricula actualMatricula = new Matricula();
        assertNull(actualMatricula.getAluno());
        assertNull(actualMatricula.getId());
    }

    /**
     * Method under test: {@link Matricula#Matricula(Long, Aluno, LocalDateTime)}
     */
    @Test
    void testConstructor3() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");
        Matricula actualMatricula = new Matricula(1L, aluno, LocalDate.of(1970, 1, 1).atStartOfDay());

        assertSame(aluno, actualMatricula.getAluno());
        assertEquals(1L, actualMatricula.getId().longValue());
        assertEquals("1970-01-01", actualMatricula.getDataDaMatricula().toLocalDate().toString());
    }

    /**
     * Method under test: {@link Matricula#equals(Object)}
     */
    @Test
    void testEquals() {
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
        assertNotEquals(matricula, null);
    }

    /**
     * Method under test: {@link Matricula#equals(Object)}
     */
    @Test
    void testEquals2() {
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
        assertNotEquals(matricula, "Different type to Matricula");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Matricula#equals(Object)}
     *   <li>{@link Matricula#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
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
        assertEquals(matricula, matricula);
        int expectedHashCodeResult = matricula.hashCode();
        assertEquals(expectedHashCodeResult, matricula.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Matricula#equals(Object)}
     *   <li>{@link Matricula#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
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

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Matricula matricula2 = new Matricula();
        matricula2.setAluno(aluno2);
        matricula2.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula2.setId(1L);
        assertEquals(matricula, matricula2);
        int expectedHashCodeResult = matricula.hashCode();
        assertEquals(expectedHashCodeResult, matricula2.hashCode());
    }

    /**
     * Method under test: {@link Matricula#equals(Object)}
     */
    @Test
    void testEquals5() {
        Aluno aluno = mock(Aluno.class);
        doNothing().when(aluno).setAvaliacoes(Mockito.<List<AvaliacaoFisica>>any());
        doNothing().when(aluno).setBairro(Mockito.<String>any());
        doNothing().when(aluno).setCpf(Mockito.<String>any());
        doNothing().when(aluno).setDataDeNascimento(Mockito.<LocalDate>any());
        doNothing().when(aluno).setId(Mockito.<Long>any());
        doNothing().when(aluno).setNome(Mockito.<String>any());
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

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Matricula matricula2 = new Matricula();
        matricula2.setAluno(aluno2);
        matricula2.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula2.setId(1L);
        assertNotEquals(matricula, matricula2);
    }

    /**
     * Method under test: {@link Matricula#equals(Object)}
     */
    @Test
    void testEquals6() {
        Aluno aluno = mock(Aluno.class);
        doNothing().when(aluno).setAvaliacoes(Mockito.<List<AvaliacaoFisica>>any());
        doNothing().when(aluno).setBairro(Mockito.<String>any());
        doNothing().when(aluno).setCpf(Mockito.<String>any());
        doNothing().when(aluno).setDataDeNascimento(Mockito.<LocalDate>any());
        doNothing().when(aluno).setId(Mockito.<Long>any());
        doNothing().when(aluno).setNome(Mockito.<String>any());
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula.setId(2L);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Matricula matricula2 = new Matricula();
        matricula2.setAluno(aluno2);
        matricula2.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula2.setId(1L);
        assertNotEquals(matricula, matricula2);
    }

    /**
     * Method under test: {@link Matricula#equals(Object)}
     */
    @Test
    void testEquals7() {
        Aluno aluno = mock(Aluno.class);
        doNothing().when(aluno).setAvaliacoes(Mockito.<List<AvaliacaoFisica>>any());
        doNothing().when(aluno).setBairro(Mockito.<String>any());
        doNothing().when(aluno).setCpf(Mockito.<String>any());
        doNothing().when(aluno).setDataDeNascimento(Mockito.<LocalDate>any());
        doNothing().when(aluno).setId(Mockito.<Long>any());
        doNothing().when(aluno).setNome(Mockito.<String>any());
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula.setId(null);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Matricula matricula2 = new Matricula();
        matricula2.setAluno(aluno2);
        matricula2.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula2.setId(1L);
        assertNotEquals(matricula, matricula2);
    }

    /**
     * Method under test: {@link Matricula#equals(Object)}
     */
    @Test
    void testEquals8() {
        Aluno aluno = mock(Aluno.class);
        doNothing().when(aluno).setAvaliacoes(Mockito.<List<AvaliacaoFisica>>any());
        doNothing().when(aluno).setBairro(Mockito.<String>any());
        doNothing().when(aluno).setCpf(Mockito.<String>any());
        doNothing().when(aluno).setDataDeNascimento(Mockito.<LocalDate>any());
        doNothing().when(aluno).setId(Mockito.<Long>any());
        doNothing().when(aluno).setNome(Mockito.<String>any());
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula.setId(null);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Matricula matricula2 = new Matricula();
        matricula2.setAluno(aluno2);
        matricula2.setDataDaMatricula(LocalDate.of(1970, 1, 1).atStartOfDay());
        matricula2.setId(null);
        assertNotEquals(matricula, matricula2);
    }
}