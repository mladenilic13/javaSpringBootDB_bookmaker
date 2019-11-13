package kladionicaii.kladionica.daoClasses;

import org.springframework.data.jpa.repository.JpaRepository;

import kladionicaii.kladionica.pojoClasses.Operater;

// custom endpoint for all data jpa ???
//@RepositoryRestResource(path="members")
public interface OperaterDao extends JpaRepository<Operater, Integer>{
	
	Operater findByNameAndPass(String name, String pass);

}
