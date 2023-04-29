package me.dio.academia.digital.entity.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ExerciciosFormTest {
    /**
     * Method under test: {@link ExerciciosForm#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new ExerciciosForm()).canEqual("Other"));
    }

    /**
     * Method under test: {@link ExerciciosForm#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        ExerciciosForm exerciciosForm = new ExerciciosForm();
        assertTrue(exerciciosForm.canEqual(new ExerciciosForm()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExerciciosForm#ExerciciosForm()}
     *   <li>{@link ExerciciosForm#setAlunoId(Long)}
     *   <li>{@link ExerciciosForm#setExercicio(String)}
     *   <li>{@link ExerciciosForm#setPeso(double)}
     *   <li>{@link ExerciciosForm#setSerie(double)}
     *   <li>{@link ExerciciosForm#toString()}
     *   <li>{@link ExerciciosForm#getAlunoId()}
     *   <li>{@link ExerciciosForm#getExercicio()}
     *   <li>{@link ExerciciosForm#getPeso()}
     *   <li>{@link ExerciciosForm#getSerie()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ExerciciosForm actualExerciciosForm = new ExerciciosForm();
        actualExerciciosForm.setAlunoId(1L);
        actualExerciciosForm.setExercicio("Exercicio");
        actualExerciciosForm.setPeso(10.0d);
        actualExerciciosForm.setSerie(10.0d);
        String actualToStringResult = actualExerciciosForm.toString();
        assertEquals(1L, actualExerciciosForm.getAlunoId().longValue());
        assertEquals("Exercicio", actualExerciciosForm.getExercicio());
        assertEquals(10.0d, actualExerciciosForm.getPeso());
        assertEquals(10.0d, actualExerciciosForm.getSerie());
        assertEquals("ExerciciosForm(exercicio=Exercicio, alunoId=1, peso=10.0, serie=10.0)", actualToStringResult);
    }

    /**
     * Method under test: {@link ExerciciosForm#ExerciciosForm(String, Long, double, double)}
     */
    @Test
    void testConstructor2() {
        ExerciciosForm actualExerciciosForm = new ExerciciosForm("Exercicio", 1L, 10.0d, 10.0d);

        assertEquals(1L, actualExerciciosForm.getAlunoId().longValue());
        assertEquals(10.0d, actualExerciciosForm.getSerie());
        assertEquals(10.0d, actualExerciciosForm.getPeso());
        assertEquals("Exercicio", actualExerciciosForm.getExercicio());
    }

    /**
     * Method under test: {@link ExerciciosForm#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new ExerciciosForm(), null);
        assertNotEquals(new ExerciciosForm(), "Different type to ExerciciosForm");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExerciciosForm#equals(Object)}
     *   <li>{@link ExerciciosForm#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        ExerciciosForm exerciciosForm = new ExerciciosForm();
        assertEquals(exerciciosForm, exerciciosForm);
        int expectedHashCodeResult = exerciciosForm.hashCode();
        assertEquals(expectedHashCodeResult, exerciciosForm.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExerciciosForm#equals(Object)}
     *   <li>{@link ExerciciosForm#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        ExerciciosForm exerciciosForm = new ExerciciosForm();
        ExerciciosForm exerciciosForm2 = new ExerciciosForm();
        assertEquals(exerciciosForm, exerciciosForm2);
        int expectedHashCodeResult = exerciciosForm.hashCode();
        assertEquals(expectedHashCodeResult, exerciciosForm2.hashCode());
    }

    /**
     * Method under test: {@link ExerciciosForm#equals(Object)}
     */
    @Test
    void testEquals4() {
        ExerciciosForm exerciciosForm = new ExerciciosForm("Exercicio", 1L, 10.0d, 10.0d);
        assertNotEquals(exerciciosForm, new ExerciciosForm());
    }

    /**
     * Method under test: {@link ExerciciosForm#equals(Object)}
     */
    @Test
    void testEquals5() {
        ExerciciosForm exerciciosForm = new ExerciciosForm();
        exerciciosForm.setExercicio("Exercicio");
        assertNotEquals(exerciciosForm, new ExerciciosForm());
    }

    /**
     * Method under test: {@link ExerciciosForm#equals(Object)}
     */
    @Test
    void testEquals6() {
        ExerciciosForm exerciciosForm = new ExerciciosForm();
        exerciciosForm.setAlunoId(1L);
        assertNotEquals(exerciciosForm, new ExerciciosForm());
    }

    /**
     * Method under test: {@link ExerciciosForm#equals(Object)}
     */
    @Test
    void testEquals7() {
        ExerciciosForm exerciciosForm = new ExerciciosForm();
        exerciciosForm.setSerie(10.0d);
        assertNotEquals(exerciciosForm, new ExerciciosForm());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ExerciciosForm#equals(Object)}
     *   <li>{@link ExerciciosForm#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        ExerciciosForm exerciciosForm = new ExerciciosForm("Exercicio", 1L, 10.0d, 10.0d);
        ExerciciosForm exerciciosForm2 = new ExerciciosForm("Exercicio", 1L, 10.0d, 10.0d);

        assertEquals(exerciciosForm, exerciciosForm2);
        int expectedHashCodeResult = exerciciosForm.hashCode();
        assertEquals(expectedHashCodeResult, exerciciosForm2.hashCode());
    }

    /**
     * Method under test: {@link ExerciciosForm#equals(Object)}
     */
    @Test
    void testEquals9() {
        ExerciciosForm exerciciosForm = new ExerciciosForm();

        ExerciciosForm exerciciosForm2 = new ExerciciosForm();
        exerciciosForm2.setExercicio("Exercicio");
        assertNotEquals(exerciciosForm, exerciciosForm2);
    }

    /**
     * Method under test: {@link ExerciciosForm#equals(Object)}
     */
    @Test
    void testEquals10() {
        ExerciciosForm exerciciosForm = new ExerciciosForm();

        ExerciciosForm exerciciosForm2 = new ExerciciosForm();
        exerciciosForm2.setAlunoId(1L);
        assertNotEquals(exerciciosForm, exerciciosForm2);
    }
}