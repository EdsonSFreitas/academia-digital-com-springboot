package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciciosForm {

    //@NotNull(message = "Preencha o campo corretamente.")
    //@Positive(message = "$
    public String exercicio;
    //@Positive(message = "O Id do aluno precisa ser positivo.")
    private Long alunoId;
    //@NotNull(message = "Preencha o campo corretamente.")
    //@Positive(message = "${validatedValue}' precisa ser positivo.")
    private double peso;
    //@NotNull(message = "Preencha o campo corretamente.")
    //@Positive(message = "${validatedValue}' precisa ser positivo.")
    private double serie;
}