package edjdc.portfolio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edjdc.portfolio.exception.RemoverProjetoComStatusAprovadoException;
import edjdc.portfolio.model.Projeto;
import edjdc.portfolio.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;

	@Transactional
	public void save(Projeto projeto) {
		repository.save(projeto);
	}

	public void delete(Long id) {
		Projeto projeto = repository.findOne(id);
		
		if (projeto.getStatus().hasStatusAprovado()) {
			throw new RemoverProjetoComStatusAprovadoException();
		}
		
        repository.delete(id);
    }
	
	public Projeto findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Projeto> findAll() {
		return repository.findAll();
	}

}
