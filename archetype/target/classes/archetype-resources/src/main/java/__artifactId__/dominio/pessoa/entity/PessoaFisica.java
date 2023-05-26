#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.dominio.pessoa.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;


public class PessoaFisica extends Pessoa {

    private String cpf;

    private Collection<PessoaFisica> dependentes = new LinkedHashSet<>();

    public Collection<PessoaFisica> getDependentes() {
        return Collections.unmodifiableCollection(dependentes);
    }

    public PessoaFisica addDependente(PessoaFisica p) {
        dependentes.add(p);
        return this;
    }

    public PessoaFisica remDependente(PessoaFisica p) {
        dependentes.add(p);
        return this;
    }

    public PessoaFisica() {
    }

    public PessoaFisica(Long id, String nome, LocalDate nascimento, String cpf, Collection<PessoaFisica> dependentes) {
        super(id, nome, nascimento);
        this.cpf = cpf;
        this.dependentes = dependentes;
    }

    public String getCpf() {
        return cpf;
    }

    public PessoaFisica setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + "PessoaFisica{" +
                "cpf='" + cpf + '${symbol_escape}'' +
                //   ", dependentes=" + dependentes +
                "} ";
    }
}
