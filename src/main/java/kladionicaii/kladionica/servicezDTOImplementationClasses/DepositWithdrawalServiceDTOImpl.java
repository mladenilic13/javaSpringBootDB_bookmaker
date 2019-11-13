
package kladionicaii.kladionica.servicezDTOImplementationClasses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import kladionicaii.kladionica.daoClasses.AccountDao;
import kladionicaii.kladionica.pojoClasses.Account;
import kladionicaii.kladionica.pojoClassesRates.InnerClass;
import kladionicaii.kladionica.pojoClassesRates.OuterClass;
import kladionicaii.kladionica.pojoDTOClasses.DepositWithdrawalDTO;
import kladionicaii.kladionica.servicezDTOClasses.DepositWithdrawalServiceDTO;

@Service
public class DepositWithdrawalServiceDTOImpl implements DepositWithdrawalServiceDTO {
	
	private AccountDao accountRepository;
	
	@Autowired
	public DepositWithdrawalServiceDTOImpl(AccountDao accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	@Transactional
	public DepositWithdrawalDTO deposit(DepositWithdrawalDTO depositWithdrawalDTO) {
		String currency = depositWithdrawalDTO.getCurrency();
		if(currency==null || currency.equals("EUR") || currency.equals("eur")) {
			BigDecimal bigDecimal = depositWithdrawalDTO.getAmount();
			Account account = 
					new Account("deposit", bigDecimal, LocalDateTime.now(), depositWithdrawalDTO.getUser());
			accountRepository.save(account);
			return depositWithdrawalDTO;
		} else {
			RestTemplate restTemplate = new RestTemplate();
			OuterClass outerClass = restTemplate.getForObject("https://api.exchangeratesapi.io/latest", OuterClass.class);
			HashMap<String, BigDecimal> hm = outerClass.getRates().populateMap();
			
			for(Map.Entry<String, BigDecimal> hme : hm.entrySet()){
	            String key = hme.getKey();
	            if(key.equals(currency)) {
	            	BigDecimal amount = depositWithdrawalDTO.getAmount();
	            	BigDecimal rate = hme.getValue(); // kurs
	            	BigDecimal calculated = amount.divide(rate, 10, RoundingMode.FLOOR);
	            	Account account = 
	            			new Account("deposit", calculated, LocalDateTime.now(), 
	            					depositWithdrawalDTO.getUser(), key, rate);
	    			accountRepository.save(account);
	            	break;
	            }
	            
	        }
			return depositWithdrawalDTO;
		}
		
	}

	@Override
	@Transactional
	public DepositWithdrawalDTO withdrawal(DepositWithdrawalDTO depositWithdrawalDTO) {
		String currency = depositWithdrawalDTO.getCurrency();
		if(currency==null || currency.equals("EUR") || currency.equals("eur")) {
			BigDecimal bigDecimal = depositWithdrawalDTO.getAmount();
			Account account = 
					new Account("withdrawal", bigDecimal, LocalDateTime.now(), depositWithdrawalDTO.getUser());
			accountRepository.save(account);
			return depositWithdrawalDTO;
		} else {
			RestTemplate restTemplate = new RestTemplate();
			OuterClass outerClass = restTemplate.getForObject("https://api.exchangeratesapi.io/latest", OuterClass.class);
			HashMap<String, BigDecimal> hm = outerClass.getRates().populateMap();
			
			for(Map.Entry<String, BigDecimal> hme : hm.entrySet()){
	            String key = hme.getKey();
	            if(key.equals(currency)) {
	            	BigDecimal amount = depositWithdrawalDTO.getAmount();
	            	BigDecimal rate = hme.getValue(); // kurs
	            	BigDecimal calculated = amount.divide(rate, 10, RoundingMode.DOWN);
	            	Account account = 
	    					new Account("withdrawal", calculated, LocalDateTime.now(),
	    							depositWithdrawalDTO.getUser(), key, rate);
	    			accountRepository.save(account);
	            	break;
	            }
	            
	        }
			return depositWithdrawalDTO;
		}
	}

}
