package me.dio.academia.digital.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AlunoTest {
    /**
     * Method under test: {@link Aluno#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Aluno()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Aluno#canEqual(Object)}
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

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertTrue(aluno.canEqual(aluno2));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Aluno#Aluno()}
     *   <li>{@link Aluno#setAvaliacoes(List)}
     *   <li>{@link Aluno#setBairro(String)}
     *   <li>{@link Aluno#setCpf(String)}
     *   <li>{@link Aluno#setDataDeNascimento(LocalDate)}
     *   <li>{@link Aluno#setId(Long)}
     *   <li>{@link Aluno#setNome(String)}
     *   <li>{@link Aluno#toString()}
     *   <li>{@link Aluno#getAvaliacoes()}
     *   <li>{@link Aluno#getBairro()}
     *   <li>{@link Aluno#getCpf()}
     *   <li>{@link Aluno#getDataDeNascimento()}
     *   <li>{@link Aluno#getId()}
     *   <li>{@link Aluno#getNome()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Aluno actualAluno = new Aluno();
        ArrayList<AvaliacaoFisica> avaliacoes = new ArrayList<>();
        actualAluno.setAvaliacoes(avaliacoes);
        actualAluno.setBairro("Bairro");
        actualAluno.setCpf("Cpf");
        LocalDate dataDeNascimento = LocalDate.of(1970, 1, 1);
        actualAluno.setDataDeNascimento(dataDeNascimento);
        actualAluno.setId(1L);
        actualAluno.setNome("Nome");
        String actualToStringResult = actualAluno.toString();
        assertSame(avaliacoes, actualAluno.getAvaliacoes());
        assertEquals("Bairro", actualAluno.getBairro());
        assertEquals("Cpf", actualAluno.getCpf());
        assertSame(dataDeNascimento, actualAluno.getDataDeNascimento());
        assertEquals(1L, actualAluno.getId().longValue());
        assertEquals("Nome", actualAluno.getNome());
        assertEquals("Aluno(id=1, nome=Nome, cpf=Cpf, bairro=Bairro, dataDeNascimento=1970-01-01, avaliacoes=[])",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Aluno#Aluno(Long, String, String, String, LocalDate, List)}
     *   <li>{@link Aluno#setAvaliacoes(List)}
     *   <li>{@link Aluno#setBairro(String)}
     *   <li>{@link Aluno#setCpf(String)}
     *   <li>{@link Aluno#setDataDeNascimento(LocalDate)}
     *   <li>{@link Aluno#setId(Long)}
     *   <li>{@link Aluno#setNome(String)}
     *   <li>{@link Aluno#toString()}
     *   <li>{@link Aluno#getAvaliacoes()}
     *   <li>{@link Aluno#getBairro()}
     *   <li>{@link Aluno#getCpf()}
     *   <li>{@link Aluno#getDataDeNascimento()}
     *   <li>{@link Aluno#getId()}
     *   <li>{@link Aluno#getNome()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDate dataDeNascimento = LocalDate.of(1970, 1, 1);
        ArrayList<AvaliacaoFisica> avaliacoes = new ArrayList<>();
        Aluno actualAluno = new Aluno(1L, "Nome", "Cpf", "Bairro", dataDeNascimento, avaliacoes);
        ArrayList<AvaliacaoFisica> avaliacoes2 = new ArrayList<>();
        actualAluno.setAvaliacoes(avaliacoes2);
        actualAluno.setBairro("Bairro");
        actualAluno.setCpf("Cpf");
        LocalDate dataDeNascimento2 = LocalDate.of(1970, 1, 1);
        actualAluno.setDataDeNascimento(dataDeNascimento2);
        actualAluno.setId(1L);
        actualAluno.setNome("Nome");
        String actualToStringResult = actualAluno.toString();
        List<AvaliacaoFisica> avaliacoes3 = actualAluno.getAvaliacoes();
        assertSame(avaliacoes2, avaliacoes3);
        assertEquals(avaliacoes, avaliacoes3);
        assertEquals("Bairro", actualAluno.getBairro());
        assertEquals("Cpf", actualAluno.getCpf());
        assertSame(dataDeNascimento2, actualAluno.getDataDeNascimento());
        assertEquals(1L, actualAluno.getId().longValue());
        assertEquals("Nome", actualAluno.getNome());
        assertEquals("Aluno(id=1, nome=Nome, cpf=Cpf, bairro=Bairro, dataDeNascimento=1970-01-01, avaliacoes=[])",
                actualToStringResult);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
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
        assertNotEquals(aluno, null);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
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
        assertNotEquals(aluno, "Different type to Aluno");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Aluno#equals(Object)}
     *   <li>{@link Aluno#hashCode()}
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
        assertEquals(aluno, aluno);
        int expectedHashCodeResult = aluno.hashCode();
        assertEquals(expectedHashCodeResult, aluno.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Aluno#equals(Object)}
     *   <li>{@link Aluno#hashCode()}
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

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertEquals(aluno, aluno2);
        int expectedHashCodeResult = aluno.hashCode();
        assertEquals(expectedHashCodeResult, aluno2.hashCode());
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals5() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Nome");
        aluno.setCpf("Nome");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);

        ArrayList<AvaliacaoFisica> avaliacoes = new ArrayList<>();
        avaliacoes.add(avaliacaoFisica);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(avaliacoes);
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Aluno aluno3 = new Aluno();
        aluno3.setAvaliacoes(new ArrayList<>());
        aluno3.setBairro("Bairro");
        aluno3.setCpf("Cpf");
        aluno3.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno3.setId(1L);
        aluno3.setNome("Nome");
        assertNotEquals(aluno2, aluno3);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals6() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Nome");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertNotEquals(aluno, aluno2);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals7() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro(null);
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertNotEquals(aluno, aluno2);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals8() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Nome");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertNotEquals(aluno, aluno2);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals9() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf(null);
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertNotEquals(aluno, aluno2);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals10() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.now());
        aluno.setId(1L);
        aluno.setNome("Nome");

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertNotEquals(aluno, aluno2);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals11() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(null);
        aluno.setId(1L);
        aluno.setNome("Nome");

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertNotEquals(aluno, aluno2);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals12() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(2L);
        aluno.setNome("Nome");

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertNotEquals(aluno, aluno2);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals13() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(null);
        aluno.setNome("Nome");

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertNotEquals(aluno, aluno2);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals14() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Cpf");

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertNotEquals(aluno, aluno2);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals15() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Bairro");
        aluno.setCpf("Cpf");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome(null);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(new ArrayList<>());
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");
        assertNotEquals(aluno, aluno2);
    }

    /**
     * Method under test: {@link Aluno#equals(Object)}
     */
    @Test
    void testEquals16() {
        Aluno aluno = new Aluno();
        aluno.setAvaliacoes(new ArrayList<>());
        aluno.setBairro("Nome");
        aluno.setCpf("Nome");
        aluno.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno.setId(1L);
        aluno.setNome("Nome");
        AvaliacaoFisica avaliacaoFisica = mock(AvaliacaoFisica.class);
        doNothing().when(avaliacaoFisica).setAltura(anyDouble());
        doNothing().when(avaliacaoFisica).setAluno(Mockito.<Aluno>any());
        doNothing().when(avaliacaoFisica).setDataDaAvaliacao(Mockito.<LocalDateTime>any());
        doNothing().when(avaliacaoFisica).setId(Mockito.<Long>any());
        doNothing().when(avaliacaoFisica).setPeso(anyDouble());
        avaliacaoFisica.setAltura(10.0d);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataDaAvaliacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        avaliacaoFisica.setId(1L);
        avaliacaoFisica.setPeso(10.0d);

        ArrayList<AvaliacaoFisica> avaliacoes = new ArrayList<>();
        avaliacoes.add(avaliacaoFisica);

        Aluno aluno2 = new Aluno();
        aluno2.setAvaliacoes(avaliacoes);
        aluno2.setBairro("Bairro");
        aluno2.setCpf("Cpf");
        aluno2.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno2.setId(1L);
        aluno2.setNome("Nome");

        Aluno aluno3 = new Aluno();
        aluno3.setAvaliacoes(new ArrayList<>());
        aluno3.setBairro("Bairro");
        aluno3.setCpf("Cpf");
        aluno3.setDataDeNascimento(LocalDate.of(1970, 1, 1));
        aluno3.setId(1L);
        aluno3.setNome("Nome");
        assertNotEquals(aluno2, aluno3);
    }
}