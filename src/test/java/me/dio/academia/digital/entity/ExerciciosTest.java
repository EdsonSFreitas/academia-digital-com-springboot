package me.dio.academia.digital.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ExerciciosTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Exercicios#Exercicios()}
     *   <li>{@link Exercicios#setAluno(Aluno)}
     *   <li>{@link Exercicios#setExercicio(String)}
     *   <li>{@link Exercicios#setId(Long)}
     *   <li>{@link Exercicios#setPeso(double)}
     *   <li>{@link Exercicios#setSerie(double)}
     *   <li>{@link Exercicios#toString()}
     *   <li>{@link Exercicios#getAluno()}
     *   <li>{@link Exercicios#getExercicio()}
     *   <li>{@link Exercicios#getId()}
     *   <li>{@link Exercicios#getPeso()}
     *   <li>{@link Exercicios#getSerie()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Exercicios actualExercicios = new Exercicios();
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");
        actualExercicios.setAluno(aluno);
        actualExercicios.setExercicio("Exercicio");
        actualExercicios.setId(1L);
        actualExercicios.setPeso(10.0d);
        actualExercicios.setSerie(10.0d);
        String actualToStringResult = actualExercicios.toString();
        assertSame(aluno, actualExercicios.getAluno());
        assertEquals("Exercicio", actualExercicios.getExercicio());
        assertEquals(1L, actualExercicios.getId().longValue());
        assertEquals(10.0d, actualExercicios.getPeso());
        assertEquals(10.0d, actualExercicios.getSerie());
        assertEquals("Exercicios(id=1, aluno=Aluno(id=1, nome=Nome, cpf=Cpf, bairro=Bairro, dataDeNascimento=1970-01-01,"
                + " avaliacoes=[]), exercicio=Exercicio, peso=10.0, serie=10.0)", actualToStringResult);
    }

    /**
     * Method under test: {@link Exercicios#Exercicios(Long, Aluno, String, double, double)}
     */
    @Test
    void testConstructor2() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");
        Exercicios actualExercicios = new Exercicios(1L, aluno, "Exercicio", 10.0d, 10.0d);

        assertSame(aluno, actualExercicios.getAluno());
        assertEquals(10.0d, actualExercicios.getSerie());
        assertEquals("Exercicio", actualExercicios.getExercicio());
        assertEquals(10.0d, actualExercicios.getPeso());
        assertEquals(1L, actualExercicios.getId().longValue());
    }

    /**
     * Method under test: {@link Exercicios#equals(Object)}
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

        Exercicios exercicios = new Exercicios();
        exercicios.setAluno(aluno);
        exercicios.setExercicio("Exercicio");
        exercicios.setId(1L);
        exercicios.setPeso(10.0d);
        exercicios.setSerie(10.0d);
        assertNotEquals(exercicios, null);
    }

    /**
     * Method under test: {@link Exercicios#equals(Object)}
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

        Exercicios exercicios = new Exercicios();
        exercicios.setAluno(aluno);
        exercicios.setExercicio("Exercicio");
        exercicios.setId(1L);
        exercicios.setPeso(10.0d);
        exercicios.setSerie(10.0d);
        assertNotEquals(exercicios, "Different type to Exercicios");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Exercicios#equals(Object)}
     *   <li>{@link Exercicios#hashCode()}
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

        Exercicios exercicios = new Exercicios();
        exercicios.setAluno(aluno);
        exercicios.setExercicio("Exercicio");
        exercicios.setId(1L);
        exercicios.setPeso(10.0d);
        exercicios.setSerie(10.0d);
        assertEquals(exercicios, exercicios);
        int expectedHashCodeResult = exercicios.hashCode();
        assertEquals(expectedHashCodeResult, exercicios.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Exercicios#equals(Object)}
     *   <li>{@link Exercicios#hashCode()}
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

        Exercicios exercicios = new Exercicios();
        exercicios.setAluno(aluno);
        exercicios.setExercicio("Exercicio");
        exercicios.setId(1L);
        exercicios.setPeso(10.0d);
        exercicios.setSerie(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Exercicios exercicios2 = new Exercicios();
        exercicios2.setAluno(aluno2);
        exercicios2.setExercicio("Exercicio");
        exercicios2.setId(1L);
        exercicios2.setPeso(10.0d);
        exercicios2.setSerie(10.0d);
        assertEquals(exercicios, exercicios2);
        int expectedHashCodeResult = exercicios.hashCode();
        assertEquals(expectedHashCodeResult, exercicios2.hashCode());
    }

    /**
     * Method under test: {@link Exercicios#equals(Object)}
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

        Exercicios exercicios = new Exercicios();
        exercicios.setAluno(aluno);
        exercicios.setExercicio("Exercicio");
        exercicios.setId(1L);
        exercicios.setPeso(10.0d);
        exercicios.setSerie(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Exercicios exercicios2 = new Exercicios();
        exercicios2.setAluno(aluno2);
        exercicios2.setExercicio("Exercicio");
        exercicios2.setId(1L);
        exercicios2.setPeso(10.0d);
        exercicios2.setSerie(10.0d);
        assertNotEquals(exercicios, exercicios2);
    }

    /**
     * Method under test: {@link Exercicios#equals(Object)}
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

        Exercicios exercicios = new Exercicios();
        exercicios.setAluno(aluno);
        exercicios.setExercicio("Exercicio");
        exercicios.setId(2L);
        exercicios.setPeso(10.0d);
        exercicios.setSerie(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Exercicios exercicios2 = new Exercicios();
        exercicios2.setAluno(aluno2);
        exercicios2.setExercicio("Exercicio");
        exercicios2.setId(1L);
        exercicios2.setPeso(10.0d);
        exercicios2.setSerie(10.0d);
        assertNotEquals(exercicios, exercicios2);
    }

    /**
     * Method under test: {@link Exercicios#equals(Object)}
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

        Exercicios exercicios = new Exercicios();
        exercicios.setAluno(aluno);
        exercicios.setExercicio("Exercicio");
        exercicios.setId(null);
        exercicios.setPeso(10.0d);
        exercicios.setSerie(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Exercicios exercicios2 = new Exercicios();
        exercicios2.setAluno(aluno2);
        exercicios2.setExercicio("Exercicio");
        exercicios2.setId(1L);
        exercicios2.setPeso(10.0d);
        exercicios2.setSerie(10.0d);
        assertNotEquals(exercicios, exercicios2);
    }

    /**
     * Method under test: {@link Exercicios#equals(Object)}
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

        Exercicios exercicios = new Exercicios();
        exercicios.setAluno(aluno);
        exercicios.setExercicio("Exercicio");
        exercicios.setId(1L);
        exercicios.setPeso(0.5d);
        exercicios.setSerie(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Exercicios exercicios2 = new Exercicios();
        exercicios2.setAluno(aluno2);
        exercicios2.setExercicio("Exercicio");
        exercicios2.setId(1L);
        exercicios2.setPeso(10.0d);
        exercicios2.setSerie(10.0d);
        assertNotEquals(exercicios, exercicios2);
    }

    /**
     * Method under test: {@link Exercicios#equals(Object)}
     */
    @Test
    void testEquals9() {
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

        Exercicios exercicios = new Exercicios();
        exercicios.setAluno(aluno);
        exercicios.setExercicio("Exercicio");
        exercicios.setId(1L);
        exercicios.setPeso(10.0d);
        exercicios.setSerie(0.5d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Exercicios exercicios2 = new Exercicios();
        exercicios2.setAluno(aluno2);
        exercicios2.setExercicio("Exercicio");
        exercicios2.setId(1L);
        exercicios2.setPeso(10.0d);
        exercicios2.setSerie(10.0d);
        assertNotEquals(exercicios, exercicios2);
    }

    /**
     * Method under test: {@link Exercicios#equals(Object)}
     */
    @Test
    void testEquals10() {
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

        Exercicios exercicios = new Exercicios();
        exercicios.setAluno(aluno);
        exercicios.setExercicio("Exercicio");
        exercicios.setId(null);
        exercicios.setPeso(10.0d);
        exercicios.setSerie(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Exercicios exercicios2 = new Exercicios();
        exercicios2.setAluno(aluno2);
        exercicios2.setExercicio("Exercicio");
        exercicios2.setId(null);
        exercicios2.setPeso(10.0d);
        exercicios2.setSerie(10.0d);
        assertNotEquals(exercicios, exercicios2);
    }
}