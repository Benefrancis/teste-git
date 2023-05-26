#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dominio.pessoa.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


public class PessoaJuridica extends Pessoa {

    private String cnpj;

    private Collection<Pessoa> socios = new HashSet<>();

    public PessoaJuridica() {
    }

    public PessoaJuridica(Long id, String nome, LocalDate nascimento, String cnpj, Collection<Pessoa> socios) {
        super(id, nome, nascimento);
        this.cnpj = cnpj;
        this.socios = socios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public PessoaJuridica setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public PessoaJuridica addSocio(Pessoa p) {
        socios.add(p);
        return this;
    }

    public PessoaJuridica removeSocio(Pessoa p) {
        socios.remove(p);
        return this;
    }

    public Collection<Pessoa> getSocios() {
        return Collections.unmodifiableCollection(socios);
    }

    @Override
    public String toString() {
        return super.toString() + "PessoaJuridica{" +
                "cnpj='" + cnpj + '${symbol_escape}'' +
//                ", socios=" + socios +
                "} ";
    }
}
