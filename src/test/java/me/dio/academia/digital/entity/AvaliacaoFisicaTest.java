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

class AvaliacaoFisicaTest {
    /**
     * Method under test: {@link AvaliacaoFisica#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new AvaliacaoFisica()).canEqual("Other"));
    }

    /**
     * Method under test: {@link AvaliacaoFisica#canEqual(Object)}
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

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        AvaliacaoFisica avaliacaoFisica2 = new AvaliacaoFisica();
        avaliacaoFisica2.setAltura(10.0d);
        avaliacaoFisica2.setAluno(aluno2);
        avaliacaoFisica2.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica2.setId(1L);
        avaliacaoFisica2.setPeso(10.0d);
        assertTrue(avaliacaoFisica.canEqual(avaliacaoFisica2));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AvaliacaoFisica#AvaliacaoFisica()}
     *   <li>{@link AvaliacaoFisica#setAltura(double)}
     *   <li>{@link AvaliacaoFisica#setAluno(Aluno)}
     *   <li>{@link AvaliacaoFisica#setDataDaAvaliacao(LocalDateTime)}
     *   <li>{@link AvaliacaoFisica#setId(Long)}
     *   <li>{@link AvaliacaoFisica#setPeso(double)}
     *   <li>{@link AvaliacaoFisica#toString()}
     *   <li>{@link AvaliacaoFisica#getAltura()}
     *   <li>{@link AvaliacaoFisica#getAluno()}
     *   <li>{@link AvaliacaoFisica#getDataDaAvaliacao()}
     *   <li>{@link AvaliacaoFisica#getId()}
     *   <li>{@link AvaliacaoFisica#getPeso()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AvaliacaoFisica actualAvaliacaoFisica = new AvaliacaoFisica();
        actualAvaliacaoFisica.setAltura(10.0d);
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");
        actualAvaliacaoFisica.setAluno(aluno);
        LocalDateTime dataDaAvaliacao = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualAvaliacaoFisica.setDataDaAvaliacao(dataDaAvaliacao);
        actualAvaliacaoFisica.setId(1L);
        actualAvaliacaoFisica.setPeso(10.0d);
        String actualToStringResult = actualAvaliacaoFisica.toString();
        assertEquals(10.0d, actualAvaliacaoFisica.getAltura());
        assertSame(aluno, actualAvaliacaoFisica.getAluno());
        assertSame(dataDaAvaliacao, actualAvaliacaoFisica.getDataDaAvaliacao());
        assertEquals(1L, actualAvaliacaoFisica.getId().longValue());
        assertEquals(10.0d, actualAvaliacaoFisica.getPeso());
        assertEquals(
                "AvaliacaoFisica(id=1, aluno=Aluno(id=1, nome=Nome, cpf=Cpf, bairro=Bairro, dataDeNascimento=1970-01-01,"
                        + " avaliacoes=[]), dataDaAvaliacao=1970-01-01T00:00, peso=10.0, altura=10.0)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link AvaliacaoFisica#AvaliacaoFisica()}
     */
    @Test
    void testConstructor2() {
        AvaliacaoFisica actualAvaliacaoFisica = new AvaliacaoFisica();
        assertEquals(0.0d, actualAvaliacaoFisica.getAltura());
        assertEquals(0.0d, actualAvaliacaoFisica.getPeso());
        assertNull(actualAvaliacaoFisica.getId());
        assertNull(actualAvaliacaoFisica.getAluno());
    }

    /**
     * Method under test: {@link AvaliacaoFisica#AvaliacaoFisica(Long, Aluno, LocalDateTime, double, double)}
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
        AvaliacaoFisica actualAvaliacaoFisica = new AvaliacaoFisica(1L, aluno, LocalDate.of(1970, 1, 1).atStartOfDay(),
                10.0d, 10.0d);

        assertEquals(10.0d, actualAvaliacaoFisica.getAltura());
        assertEquals(10.0d, actualAvaliacaoFisica.getPeso());
        assertEquals(1L, actualAvaliacaoFisica.getId().longValue());
        assertSame(aluno, actualAvaliacaoFisica.getAluno());
        assertEquals("00:00", actualAvaliacaoFisica.getDataDaAvaliacao().toLocalTime().toString());
    }

    /**
     * Method under test: {@link AvaliacaoFisica#equals(Object)}
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

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);
        assertNotEquals(avaliacaoFisica, null);
    }

    /**
     * Method under test: {@link AvaliacaoFisica#equals(Object)}
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

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);
        assertNotEquals(avaliacaoFisica, "Different type to AvaliacaoFisica");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AvaliacaoFisica#equals(Object)}
     *   <li>{@link AvaliacaoFisica#hashCode()}
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

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);
        assertEquals(avaliacaoFisica, avaliacaoFisica);
        int expectedHashCodeResult = avaliacaoFisica.hashCode();
        assertEquals(expectedHashCodeResult, avaliacaoFisica.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AvaliacaoFisica#equals(Object)}
     *   <li>{@link AvaliacaoFisica#hashCode()}
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

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        AvaliacaoFisica avaliacaoFisica2 = new AvaliacaoFisica();
        avaliacaoFisica2.setAltura(10.0d);
        avaliacaoFisica2.setAluno(aluno2);
        avaliacaoFisica2.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica2.setId(1L);
        avaliacaoFisica2.setPeso(10.0d);
        assertEquals(avaliacaoFisica, avaliacaoFisica2);
        int expectedHashCodeResult = avaliacaoFisica.hashCode();
        assertEquals(expectedHashCodeResult, avaliacaoFisica2.hashCode());
    }

    /**
     * Method under test: {@link AvaliacaoFisica#equals(Object)}
     */
    @Test
    void testEquals5() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(0.5d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        AvaliacaoFisica avaliacaoFisica2 = new AvaliacaoFisica();
        avaliacaoFisica2.setAltura(10.0d);
        avaliacaoFisica2.setAluno(aluno2);
        avaliacaoFisica2.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica2.setId(1L);
        avaliacaoFisica2.setPeso(10.0d);
        assertNotEquals(avaliacaoFisica, avaliacaoFisica2);
    }

    /**
     * Method under test: {@link AvaliacaoFisica#equals(Object)}
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

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        AvaliacaoFisica avaliacaoFisica2 = new AvaliacaoFisica();
        avaliacaoFisica2.setAltura(10.0d);
        avaliacaoFisica2.setAluno(aluno2);
        avaliacaoFisica2.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica2.setId(1L);
        avaliacaoFisica2.setPeso(10.0d);
        assertNotEquals(avaliacaoFisica, avaliacaoFisica2);
    }

    /**
     * Method under test: {@link AvaliacaoFisica#equals(Object)}
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

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(2L);
        avaliacaoFisica.setPeso(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        AvaliacaoFisica avaliacaoFisica2 = new AvaliacaoFisica();
        avaliacaoFisica2.setAltura(10.0d);
        avaliacaoFisica2.setAluno(aluno2);
        avaliacaoFisica2.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica2.setId(1L);
        avaliacaoFisica2.setPeso(10.0d);
        assertNotEquals(avaliacaoFisica, avaliacaoFisica2);
    }

    /**
     * Method under test: {@link AvaliacaoFisica#equals(Object)}
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

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(null);
        avaliacaoFisica.setPeso(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        AvaliacaoFisica avaliacaoFisica2 = new AvaliacaoFisica();
        avaliacaoFisica2.setAltura(10.0d);
        avaliacaoFisica2.setAluno(aluno2);
        avaliacaoFisica2.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica2.setId(1L);
        avaliacaoFisica2.setPeso(10.0d);
        assertNotEquals(avaliacaoFisica, avaliacaoFisica2);
    }

    /**
     * Method under test: {@link AvaliacaoFisica#equals(Object)}
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

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(0.5d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        AvaliacaoFisica avaliacaoFisica2 = new AvaliacaoFisica();
        avaliacaoFisica2.setAltura(10.0d);
        avaliacaoFisica2.setAluno(aluno2);
        avaliacaoFisica2.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica2.setId(1L);
        avaliacaoFisica2.setPeso(10.0d);
        assertNotEquals(avaliacaoFisica, avaliacaoFisica2);
    }

    /**
     * Method under test: {@link AvaliacaoFisica#equals(Object)}
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

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(null);
        avaliacaoFisica.setPeso(10.0d);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        AvaliacaoFisica avaliacaoFisica2 = new AvaliacaoFisica();
        avaliacaoFisica2.setAltura(10.0d);
        avaliacaoFisica2.setAluno(aluno2);
        avaliacaoFisica2.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica2.setId(null);
        avaliacaoFisica2.setPeso(10.0d);
        assertNotEquals(avaliacaoFisica, avaliacaoFisica2);
    }
}