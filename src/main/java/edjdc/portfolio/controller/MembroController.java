package edjdc.portfolio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edjdc.portfolio.model.Membro;
import edjdc.portfolio.service.MembroService;

@RestController
@RequestMapping("/membro")
public class MembroController {

	@Autowired
	private MembroService service;
	
	@PostMapping
	public ResponseEntity<Membro> save(@Valid @RequestBody Membro membro) {
		service.save(membro);
		return ResponseEntity.status(HttpStatus.CREATED).body(membro);
	}

	@PutMapping
	public ResponseEntity<Membro> update(@Valid @RequestBody Membro membro) {
		service.save(membro);
		return ResponseEntity.ok(membro);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void  delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Membro> findOne(@PathVariable Long id) {
		Membro membro = service.findOne(id);
		return ResponseEntity.status(HttpStatus.OK).body(membro);
	}
	
}
