package edjdc.portfolio.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edjdc.portfolio.model.Membro;
import edjdc.portfolio.repository.MembroRepository;

@Service
public class MembroService {

	@Autowired
	private MembroRepository repository;
	
	@Transactional
	public void save(Membro membro) {
		repository.save(membro);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}
	
	public Membro findOne(Long id) {
		return repository.findOne(id);
	}
	
}
