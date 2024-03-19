package br.com.padarqsis.layerbasedapplic.controller;

import br.com.padarqsis.layerbasedapplic.entity.Livro;
import br.com.padarqsis.layerbasedapplic.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping(value = "/livro")
    public List<Livro> get() {
        return livroRepository.findAll();
    }

    @GetMapping(value = "/livro/{id}")
    public ResponseEntity<Livro> getById(@PathVariable(value = "id") long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent())
            return new ResponseEntity<Livro>(livro.get(),

                    HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/livro")
    public Livro post(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @PutMapping(value = "/livro/{id}")
    public ResponseEntity<Livro> put(@PathVariable(value = "id") long id, @RequestBody Livro newLivro) {
        Optional<Livro> oldLivro = livroRepository.findById(id);
        if (oldLivro.isPresent()) {
            Livro livro = oldLivro.get();
            livro.setTitulo(newLivro.getTitulo());
            livro.setPreco(newLivro.getPreco());
            livroRepository.save(livro);
            return new ResponseEntity<Livro>(livro, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/livro/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            livroRepository.delete(livro.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
