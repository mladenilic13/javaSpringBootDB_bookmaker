package kladionicaii.kladionica.daoClasses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.querydsl.core.types.Predicate;

import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.pojoDTOClasses.SearchOutputDTO;

// after inclusion of querydsl dependencies in pom reimport project using maven
public interface UserDao extends JpaRepository<User, Integer>, QuerydslPredicateExecutor<User>{
	
	User findByNameAndPass(String name, String pass);
	
	User findByName(String name);

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
