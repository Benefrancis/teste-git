#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dominio.pessoa.dto;

import ${package}.dominio.pessoa.entity.Pessoa;
import ${package}.dominio.pessoa.entity.PessoaJuridica;

import java.time.LocalDate;
import java.util.Collection;

public record PessoaJuridicaDTO(Long id,
                                String nome,
                                LocalDate nascimento,
                                String cnpj,
                                Collection<Pessoa> socios) {

    public static PessoaJuridicaDTO of(PessoaJuridica p) {
        return new PessoaJuridicaDTO(p.getId(),
                p.getNome(),
                p.getNascimento(),
                p.getCnpj(),
                p.getSocios());
    }

    public PessoaJuridica toPessoaJuridica() {

        return new PessoaJuridica(id,
                nome,
                nascimento,
                cnpj,
                socios);
    }

}
