package org.example.Model;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PessoasModel {
    @NonNull
    private String nome;
    @NonNull
    private String cpf;
    @NonNull
    private String rg;
    @NonNull
    private String endereco;
    @NonNull
    private String dataNascimento;
    private int id;

}
