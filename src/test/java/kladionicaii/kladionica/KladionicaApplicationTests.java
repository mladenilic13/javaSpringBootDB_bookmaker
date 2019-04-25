package kladionicaii.kladionica;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import kladionicaii.kladionica.daoClasses.UserDao;
import kladionicaii.kladionica.daoClasses.OperaterDao;
import kladionicaii.kladionica.daoClasses.AccountDao;
import kladionicaii.kladionica.daoClasses.TicketDao;
import kladionicaii.kladionica.daoClasses.GameDao;
import kladionicaii.kladionica.daoClasses.GameTicketDao;
import kladionicaii.kladionica.pojoClasses.Operater;
import kladionicaii.kladionica.restClasses.UserRestController;
import kladionicaii.kladionica.restClasses.OperaterRestController;
import kladionicaii.kladionica.restClasses.AccountRestController;
import kladionicaii.kladionica.restClasses.TicketRestController;
import kladionicaii.kladionica.restClasses.GameRestController;
import kladionicaii.kladionica.restClasses.GameTicketRestController;
import kladionicaii.kladionica.restDTOClasses.RestControllerDTO;
import kladionicaii.kladionica.serviceClasses.UserService;
import kladionicaii.kladionica.serviceClasses.OperaterService;
import kladionicaii.kladionica.serviceClasses.AccountService;
import kladionicaii.kladionica.serviceClasses.TicketService;
import kladionicaii.kladionica.serviceClasses.GameService;
import kladionicaii.kladionica.serviceClasses.GameTicketService;
import kladionicaii.kladionica.serviceImplementationClasses.OperaterServiceImpl;
import kladionicaii.kladionica.serviceSecurityClasses.LoginService;
import kladionicaii.kladionica.servicezDTOClasses.BuyTicketServiceDTO;
import kladionicaii.kladionica.servicezDTOClasses.NotPlayedYetServiceDTO;
import kladionicaii.kladionica.servicezDTOClasses.SearchTransactionsServiceDTO;
import kladionicaii.kladionica.servicezDTOClasses.RegistrationServiceDTO;
import kladionicaii.kladionica.servicezDTOClasses.DepositWithdrawalServiceDTO;

@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// dodato
//@DataJpaTest
public class KladionicaApplicationTests {

//	@Autowired
//    private TestEntityManager entityManager;
	
	@Autowired
    private UserRestController korisnikRestController;
	@Autowired
    private OperaterRestController operaterRestController;
	@Autowired
    private AccountRestController racunRestController;
	@Autowired
    private TicketRestController tiketRestController;
	@Autowired
    private GameRestController utakmicaRestController;
	@Autowired
    private GameTicketRestController utamicaTiketRestController;
	@Autowired
    private RestControllerDTO restControllerDTO;
	
	// dodato
//	@MockBean
	@Autowired
	private GameTicketDao utakmicaTiketRepository;
//	@MockBean
	@Autowired
	private AccountDao racunRepository;
//	@MockBean
	@Autowired
	private TicketDao tiketRepository;
//	@MockBean
	@Autowired
	private UserDao korisnikRepository;
//	@MockBean
	@Autowired
	private GameDao utakmicaRepository;
//	@MockBean
	@Autowired
	// static ??
	private static OperaterDao operaterRepository;
	
	@Autowired
	private UserService korisnikService;
	@Autowired
	private OperaterService operaterService;
	@Autowired
	private AccountService racunService;
	@Autowired
	private TicketService tiketService;
	@Autowired
	private GameService utakmicaService;
	@Autowired
	private GameTicketService utakmicaTiketService;
	
	@Autowired
	private RegistrationServiceDTO registracijaServisDTO;
	@Autowired
	private DepositWithdrawalServiceDTO uplataIsplataServiceDTO;
	@Autowired
	private BuyTicketServiceDTO kupovinaTiketaServiceDTO;
	@Autowired
	private NotPlayedYetServiceDTO neOdigraneServiceDTO;
	@Autowired
	private SearchTransactionsServiceDTO novcaneTransakcijeServiceDTO;
	@Autowired
	private LoginService loginService;
	
//	@TestConfiguration
//    static class OperaterServiceImplTestContextConfiguration {
//  
//        @Bean
//        public OperaterService employeeService() {
//            return new OperaterServiceImpl(operaterRepository);
//        }
//    }
	
	@Test
    public void contextLoads() {
		assertThat(korisnikRestController).isNotNull();
		assertThat(operaterRestController).isNotNull();
		assertThat(racunRestController).isNotNull();
		assertThat(tiketRestController).isNotNull();
		assertThat(utakmicaRestController).isNotNull();
		assertThat(utamicaTiketRestController).isNotNull();
		assertThat(restControllerDTO).isNotNull();
    }
	
//	@Test
//	public void operaterTest() {
//		Operater alex = new Operater("alex", "lozinka");
//		entityManager.persist(alex);
//		entityManager.flush();
//		
//		Operater pera = operaterRepository.findByNazivAndPassword("alex", "lozinka");
//		assertThat(pera.getNaziv()).isEqualTo(alex.getNaziv());
//	}

}
