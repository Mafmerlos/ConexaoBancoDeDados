package org.example.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoasModel {
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String dataNascimento;
}
