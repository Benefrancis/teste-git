#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dominio.pessoa.controller;


import ${package}.dominio.pessoa.dto.PessoaFisicaDTO;
import ${package}.dominio.pessoa.dto.PessoaJuridicaDTO;
import ${package}.dominio.pessoa.repository.PessoaFisicaCollectionRepository;
import ${package}.dominio.pessoa.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;

@RestController
@RequestMapping(value = {"/pf", "/pf/"})
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaCollectionRepository repo;

    @GetMapping(value = {"/", ""})
    public ResponseEntity<Collection<PessoaFisicaDTO>> findAll() {
        var pessoas = repo.findAll().stream().map(PessoaFisicaDTO::of).toList();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaFisicaDTO> findById(@PathVariable long id) {
        var pessoa = repo.findById(id);
        if (pessoa.isPresent()) return ResponseEntity.ok(PessoaFisicaDTO.of(pessoa.get()));
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PessoaFisicaDTO> save(@RequestBody PessoaFisicaDTO dto, UriComponentsBuilder ucBuilder) {
        var salvo = repo.save(dto.toPessoaFisica());
        if (salvo.isPresent()) {
            var uri = ucBuilder.path("/pf/{id}").buildAndExpand(salvo.get().getId()).toUri();
            return ResponseEntity.created(uri).body(PessoaFisicaDTO.of(salvo.get()));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        var pessoa = repo.findById(id);
        if (pessoa.isPresent()) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        //   return ApiError.notFound("Pessoa não encontrada");
        return ResponseEntity.notFound().build();
    }

}
