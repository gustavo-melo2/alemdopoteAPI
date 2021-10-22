package br.com.youngdevs.alemdopoteapi.controller.api;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.youngdevs.alemdopoteapi.models.Pote;
import br.com.youngdevs.alemdopoteapi.repository.PoteRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/pote")
@Slf4j
public class ApiPoteController {

	@Autowired
	private PoteRepository repository;
	
	
	@GetMapping
	public Page<Pote> index(@PageableDefault Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@PostMapping
	public ResponseEntity<Pote> create(@RequestBody @Valid Pote pote, UriComponentsBuilder uriBuilder) {
		repository.save(pote);
		URI uri = uriBuilder.path("/api/pote/{id}").buildAndExpand(pote.getId()).toUri();
		return ResponseEntity.created(uri).body(pote);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pote> get(@PathVariable Long id) {
		return ResponseEntity.of(repository.findById(id)); // Se o optional estiver vazio retorna notfound se não retorna ok
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Pote> delete(@PathVariable Long id){
		Optional<Pote> pote = repository.findById(id);
		if(pote.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Pote> update(@RequestBody @Valid Pote newPote, @PathVariable Long id) {
		Optional<Pote> optional = repository.findById(id);
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Pote pote = optional.get();
		
		pote.setNome(newPote.getNome());
		pote.setNumConsumidores(newPote.getNumConsumidores());
		pote.setNumPorcentagemAlerta(newPote.getNumPorcentagemAlerta());
		pote.setConteudo(newPote.getConteudo());
		
		repository.save(pote);
		
		log.info("Pote alterado para "+pote.toString());
		return ResponseEntity.ok(pote);
	}
	
	
	
	
	
}
