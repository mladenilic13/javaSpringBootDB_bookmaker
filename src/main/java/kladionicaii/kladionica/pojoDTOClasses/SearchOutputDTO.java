
package kladionicaii.kladionica.pojoDTOClasses;
  
import java.math.BigDecimal;
import java.time.LocalDateTime;
  
public class SearchOutputDTO {
  
	private Integer accountId;
	
	private String purpose;
	
	private BigDecimal amount;

	private LocalDateTime time;
	
	private String currency;
	
	// not convert takes directly
	private BigDecimal rate;
    
	public SearchOutputDTO() {
	}

	public SearchOutputDTO(String purpuse, BigDecimal amount, LocalDateTime time) {
		this.purpose = purpuse;
		this.amount = amount;
		this.time = time;
	}

	public SearchOutputDTO(Integer accountId, String purpose, BigDecimal amount, LocalDateTime time) {
		this.accountId = accountId;
		this.purpose = purpose;
		this.amount = amount;
		this.time = time;
	}

	public SearchOutputDTO(String purpuse, BigDecimal amount, LocalDateTime time, String currency,
			BigDecimal rate) {
		this.purpose = purpuse;
		this.amount = amount;
		this.time = time;
		this.currency = currency;
		this.rate = rate;
	}

	public SearchOutputDTO(Integer accountId, String purpose, BigDecimal amount, LocalDateTime time,
			String currency, BigDecimal rate) {
		this.accountId = accountId;
		this.purpose = purpose;
		this.amount = amount;
		this.time = time;
		this.currency = currency;
		this.rate = rate;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "SearchOutputDTO [accountId=" + accountId + ", purpose=" + purpose + ", amount=" + amount + ", time="
				+ time + ", currency=" + currency + ", rate=" + rate + "]";
	}
	
}
 