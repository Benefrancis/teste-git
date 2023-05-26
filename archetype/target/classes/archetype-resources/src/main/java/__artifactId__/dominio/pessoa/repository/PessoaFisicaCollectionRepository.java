#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.dominio.pessoa.repository;

import ${package}.${artifactId}.dominio.pessoa.entity.PessoaFisica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class PessoaFisicaCollectionRepository {
    private static final Logger log = LoggerFactory.getLogger(PessoaFisicaCollectionRepository.class);

    private static String buildCPF() {
        String numero = String.valueOf(new Random().nextInt(999999999));
        var valor = Integer.valueOf(numero.substring(numero.length() - 2));
        String digito = valor < 10 ? "0" + valor : String.valueOf(valor >> 2);
        return numero + "-" + digito;
    }

    private static PessoaFisica buildPessoaFisica(String nome, LocalDate nascimento, String cpf) {
        var p1 = new PessoaFisica();
        p1.setNome(nome);
        p1.setNascimento(nascimento);
        p1.setCpf(cpf);
        return p1;
    }

    static private Set<PessoaFisica> pessoas;

    static {

        pessoas = new LinkedHashSet<>();

        var nome = "Benefrancis do Nascimento";
        var nascimento = LocalDate.of(1977, 3, 8);
        var cpf = buildCPF();

        PessoaFisica p1 = buildPessoaFisica(nome, nascimento, cpf);

        nome = "Bruno Sudré do Nascimento";
        cpf = buildCPF();
        nascimento = nascimento.plusYears(24);

        var dep1 = buildPessoaFisica(nome, nascimento, cpf);

        nome = "Erick Sudré do Nascimento";
        cpf = buildCPF();
        nascimento = nascimento.plusYears(30);

        var dep2 = buildPessoaFisica(nome, nascimento, cpf);

        nome = "Davi Lucca Sudré do Nascimento";
        cpf = buildCPF();
        nascimento = nascimento.plusYears(40);

        var dep3 = buildPessoaFisica(nome, nascimento, cpf);


        save(p1);
        save(dep1);
        save(dep2);
        save(dep3);


        p1.addDependente(dep1);
        p1.addDependente(dep2);
        p1.addDependente(dep3);

    }


    public Collection<PessoaFisica> findAll() {
        log.info("Consultando todas as Pessoas Físicas");
        return pessoas;
    }

    public Optional<PessoaFisica> findById(Long id) {
        log.info("Consultando PessoaFisica: {}", id);
        var pessoa = pessoas.stream().filter(p -> p.getId().equals(id)).findFirst();
        return pessoa;
    }

    public static Optional<PessoaFisica> save(PessoaFisica p) {
        log.info("Salvando: {}", p);
        p.setId(pessoas.size() + 1L);
        var feito = pessoas.add(p);
        if (feito) return Optional.of(p);
        return Optional.empty();
    }

    public void deleteById(Long id) {
        log.info("Removendo PessoaFisica: {}", id);
        Optional<PessoaFisica> pessoa = findById(id);
        if (pessoa.isPresent()) pessoas.remove(pessoa.get());
        log.info("PessoaFisica: {} não encontrada", id);
    }

}
