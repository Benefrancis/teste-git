#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.dominio.pessoa.dto;

import ${package}.${artifactId}.dominio.pessoa.entity.PessoaFisica;

import java.time.LocalDate;
import java.util.Collection;

public record PessoaFisicaDTO(
        Long id,
        String nome,
        LocalDate nascimento,
        String cpf,
        Collection<PessoaFisica> dependentes
) {

    public static PessoaFisicaDTO of(PessoaFisica p) {
        return new PessoaFisicaDTO(p.getId(),
                p.getNome(),
                p.getNascimento(),
                p.getCpf(),
                p.getDependentes());
    }

    public PessoaFisica toPessoaFisica() {

        return new PessoaFisica(id,
                nome,
                nascimento,
                cpf,
                dependentes);
    }
}
