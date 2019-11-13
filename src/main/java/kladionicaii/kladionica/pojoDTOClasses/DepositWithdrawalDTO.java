package kladionicaii.kladionica.pojoDTOClasses;

import java.math.BigDecimal;

import kladionicaii.kladionica.pojoClasses.User;

public class DepositWithdrawalDTO {

	private BigDecimal amount;

	// convert amount
	private String currency;
	
    private User user;
	
	public DepositWithdrawalDTO() {
	}

	public DepositWithdrawalDTO(BigDecimal amount, User user) {
		this.amount = amount;
		this.user = user;
	}

	public DepositWithdrawalDTO(BigDecimal amount, String currency, User user) {
		this.amount = amount;
		this.currency = currency;
		this.user = user;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "DepositWithdrawalDTO [amount=" + amount + ", currency=" + currency + ", user=" + user + "]";
	}

}
