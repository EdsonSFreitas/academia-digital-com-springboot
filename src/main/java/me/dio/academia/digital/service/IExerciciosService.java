package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Exercicios;
import me.dio.academia.digital.entity.form.ExerciciosForm;
import me.dio.academia.digital.entity.form.ExerciciosUpdateForm;

import java.util.List;

public interface IExerciciosService {
    /**
     * Cria um exercicio e salva no banco de dados.
     *
     * @param form - formulário referente aos dados para criação de exercicio no banco de dados.
     * @return - Exercicio recém-criada.
     */
    Exercicios create(ExerciciosForm form);

    /**
     * Retorna um Exercicio que está no banco de dados de acordo com seu Id.
     *
     * @param id - id d Exercicio que será exibida.
     * @return - Exercicio de acordo com o Id fornecido.
     */
    Exercicios get(Long id);

    /**
     * Retorna todas os Exercicios que estão no banco de dados.
     *
     * @return - Uma lista com todas os Exercicios que estão salvas no DB.
     */
    List<Exercicios> getAll();

    /**
     * Atualiza  Exercicio.
     *
     * @param id         - id do Exercicio que será atualizada.
     * @param formUpdate - formulário referente aos dados necessários para atualização do Exercicio
     *                   no banco de dados.
     * @return - Exercicio recém-atualizado.
     */
    Exercicios update(Long id, ExerciciosUpdateForm formUpdate);

    /**
     * Deleta um exercicio específico.
     *
     * @param id - id do exercicio que será removido.
     */
    void delete(Long id);
}