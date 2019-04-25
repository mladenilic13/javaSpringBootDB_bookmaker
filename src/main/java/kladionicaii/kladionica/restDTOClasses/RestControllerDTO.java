
package kladionicaii.kladionica.restDTOClasses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.pojoDTOClasses.BuyTicketDTO;
import kladionicaii.kladionica.pojoDTOClasses.NotPlayedYetDTO;
import kladionicaii.kladionica.pojoDTOClasses.SearchInputDTO;
import kladionicaii.kladionica.pojoDTOClasses.SearchOutputDTO;
import kladionicaii.kladionica.pojoDTOClasses.DepositWithdrawalDTO;
import kladionicaii.kladionica.serviceSecurityClasses.LoginService;
import kladionicaii.kladionica.servicezDTOClasses.BuyTicketServiceDTO;
import kladionicaii.kladionica.servicezDTOClasses.NotPlayedYetServiceDTO;
import kladionicaii.kladionica.servicezDTOClasses.SearchTransactionsServiceDTO;
import kladionicaii.kladionica.servicezDTOClasses.RegistrationServiceDTO;
import kladionicaii.kladionica.servicezDTOClasses.DepositWithdrawalServiceDTO;

@RestController
@RequestMapping("/api")
//@Controller  // controller only for thymeleaf template ???
public class RestControllerDTO {
	
	@Autowired
	private RegistrationServiceDTO registrationServisDTO;
	@Autowired
	private DepositWithdrawalServiceDTO depositWithdrawalServiceDTO;
	@Autowired
	private BuyTicketServiceDTO buyTicketServiceDTO;
	@Autowired
	private NotPlayedYetServiceDTO notPlayedYetServiceDTO;
	@Autowired
	private SearchTransactionsServiceDTO searchTransactionsServiceDTO;
	
	@PostMapping("/registration")
	public User registration(@RequestBody User user) {
		registrationServisDTO.save(user);
		return user;
	}
	
	@PostMapping("/deposit")
	public DepositWithdrawalDTO deposit(@RequestBody DepositWithdrawalDTO depositWithdrawalDTO) {
		depositWithdrawalServiceDTO.deposit(depositWithdrawalDTO);
		return depositWithdrawalDTO;
	}
	
	@PostMapping("/withdrawal")
	public DepositWithdrawalDTO withdrawal(@RequestBody DepositWithdrawalDTO depositWithdrawalDTO) {
		depositWithdrawalServiceDTO.withdrawal(depositWithdrawalDTO);
		return depositWithdrawalDTO;
	}
	
	@PostMapping("/buyticket")
	public BuyTicketDTO buyTicket(@RequestBody BuyTicketDTO buyTicketDTO) {
		buyTicketServiceDTO.buyTicket(buyTicketDTO);
		return buyTicketDTO;
	}
	
	// test
	@GetMapping("/customtest")
	public BuyTicketDTO customtest() {
		return buyTicketServiceDTO.customOutput();
	}
	
	@GetMapping("/notplayedyet")
	public List<NotPlayedYetDTO> notPlayedYet() {
		return notPlayedYetServiceDTO.notPlayedYet();
	}
	
	@GetMapping("/searchtransactions")
	public List<SearchOutputDTO> searchTransactions(@RequestBody SearchInputDTO searchInputDTO) {
		return searchTransactionsServiceDTO.search(searchInputDTO);
	}
	
	// test
	@GetMapping("/custominput")
	public SearchInputDTO custominput() {
		return searchTransactionsServiceDTO.customInput();
	}
	
	// thymeleaf ???
	@GetMapping("/greeting")
	// seeks and returns model from template folder
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        // returns html page greeting.html
        return "greeting";
    }
	
}
