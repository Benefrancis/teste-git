#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.dominio.pessoa.controller;

import ${package}.${artifactId}.dominio.pessoa.dto.PessoaJuridicaDTO;
import ${package}.${artifactId}.dominio.pessoa.repository.PessoaJuridicaCollectionRepository;
import ${package}.${artifactId}.dominio.pessoa.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;

@RestController
@RequestMapping(value = {"/pj", "/pj/"})
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaCollectionRepository repo;

    @GetMapping(value = {"/", ""})
    public ResponseEntity<Collection<PessoaJuridicaDTO>> findAll() {
        var pessoas = repo.findAll().stream().map(PessoaJuridicaDTO::of).toList();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaJuridicaDTO> findById(@PathVariable long id) {
        var pessoa = repo.findById(id);
        if (pessoa.isPresent()) return ResponseEntity.ok(PessoaJuridicaDTO.of(pessoa.get()));
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PessoaJuridicaDTO> save(@RequestBody PessoaJuridicaDTO dto, UriComponentsBuilder ucBuilder) {
        var salvo = repo.save(dto.toPessoaJuridica());
        if (salvo.isPresent()) {
            var uri = ucBuilder.path("/pj/{id}").buildAndExpand(salvo.get().getId()).toUri();
            return ResponseEntity.created(uri).body(PessoaJuridicaDTO.of(salvo.get()));
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
