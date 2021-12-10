package br.com.zup.Zupfy.musica.dtos;

import br.com.zup.Zupfy.enuns.Estilo;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MusicaCadastroDTO {
    @Size(min = 2)
    @NotBlank(message = "O nome precisa ser preenchido")
    private String nome;
    @NotNull(message = "O tipo precisa ser preenchido")
    private Estilo estilo;

    public MusicaCadastroDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }
}
