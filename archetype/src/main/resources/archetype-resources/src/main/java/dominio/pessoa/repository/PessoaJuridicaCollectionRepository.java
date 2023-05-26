#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dominio.pessoa.repository;


import ${package}.dominio.pessoa.entity.PessoaJuridica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class PessoaJuridicaCollectionRepository {
    private static final Logger log = LoggerFactory.getLogger(PessoaFisicaCollectionRepository.class);

    private static String buildCNPJ() {
        String numero = String.valueOf(new Random().nextInt(999999999));
        var valor = Integer.valueOf(numero.substring(numero.length() - 2));
        String digito = valor < 10 ? "0" + valor : String.valueOf(valor >> 2);
        return numero + "-" + digito;
    }

    private static PessoaJuridica buildPessoaJuridica(String nome, LocalDate nascimento, String cnpj) {
        var p1 = new PessoaJuridica();
        p1.setNome(nome);
        p1.setNascimento(nascimento);
        p1.setCnpj(cnpj);
        return p1;
    }

    static private Set<PessoaJuridica> pessoas;

    static {

        pessoas = new LinkedHashSet<>();

        var empresa = new PessoaJuridica();
        empresa.setNascimento(LocalDate.now().minusYears(5));
        empresa.setNome("Benezinho Holding");
        empresa.setCnpj("132132132154");


        save(empresa);

    }


    public Collection<PessoaJuridica> findAll() {
        log.info("Consultando todas as Pessoas Jurídicas");
        return pessoas;
    }

    public Optional<PessoaJuridica> findById(Long id) {
        log.info("Consultando PessoaJuridica: {}", id);
        var pessoa = pessoas.stream().filter(p -> p.getId().equals(id)).findFirst();
        return pessoa;
    }

    public static Optional<PessoaJuridica> save(PessoaJuridica p) {
        log.info("Salvando: {}", p);
        p.setId(pessoas.size() + 1L);
        var feito = pessoas.add(p);
        if (feito) return Optional.of(p);
        return Optional.empty();
    }

    public void deleteById(Long id) {
        log.info("Removendo PessoaJuridica: {}", id);
        Optional<PessoaJuridica> pessoa = findById(id);
        if (pessoa.isPresent()) pessoas.remove(pessoa.get());
        log.info("PessoaJuridica: {} não encontrada", id);
    }

}
