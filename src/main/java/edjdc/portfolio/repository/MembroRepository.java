package edjdc.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edjdc.portfolio.model.Membro;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long>  {

}
