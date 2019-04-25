package kladionicaii.kladionica.daoClasses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.pojoDTOClasses.SearchOutputDTO;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByNameAndPass(String name, String pass);
	
	// public ?
	// time in form '2019-01-01 00:00:00'
	@Query(	value = 
					"select idrk, tiprk, iznosrk, vremerk, fkidkorisnik,"
					+"null as idtiket, null as fkidkorisnik, null as idkorisnik,"
					+"null as nazivkorisnik, null as emailkorisnik from racunkorisnik"
					+"where racunkorisnik.fkidkorisnik = ?"
					+"and racunkorisnik.vremerk > ?"
					+"and racunkorisnik.vremerk < ?"
					+"union"
					+"select * from racuntiket"
					+"inner join tiket on racuntiket.fkidtiket = tiket.idtiket"
					+"inner join korisnik on korisnik.idkorisnik = tiket.fkidkorisnik"
					+"where tiket.fkidkorisnik = ?"
					+"and racuntiket.vremert > ?"
					+"and racuntiket.vremert < ?"
					+"order by vremerk",
			nativeQuery = true)
	public List<SearchOutputDTO> pretraga();
	
}
