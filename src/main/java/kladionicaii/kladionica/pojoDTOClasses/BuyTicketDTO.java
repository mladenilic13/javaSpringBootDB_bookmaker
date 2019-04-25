
package kladionicaii.kladionica.pojoDTOClasses;

import java.math.BigDecimal;
import java.util.Arrays;

public class BuyTicketDTO {

	private Integer userId;

	private BigDecimal amount;

	// convert amount
	private String currency;
	
	private Integer[] arrayGameId;
	
	private Integer[] arrayPrediction;
	
	public BuyTicketDTO() {
	}

	public BuyTicketDTO(Integer userId, BigDecimal amount, Integer[] arrayGameId,
			Integer[] arrayPrediction) {
		this.userId = userId;
		this.amount = amount;
		this.arrayGameId = arrayGameId;
		this.arrayPrediction = arrayPrediction;
	}

	public BuyTicketDTO(Integer userId, BigDecimal amount, String currency, Integer[] arrayGameId,
			Integer[] arrayPrediction) {
		this.userId = userId;
		this.amount = amount;
		this.currency = currency;
		this.arrayGameId = arrayGameId;
		this.arrayPrediction = arrayPrediction;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer[] getArrayGameId() {
		return arrayGameId;
	}

	public void setArrayGameId(Integer[] arrayGameId) {
		this.arrayGameId = arrayGameId;
	}

	public Integer[] getArrayPrediction() {
		return arrayPrediction;
	}

	public void setArrayPrediction(Integer[] arrayPrediction) {
		this.arrayPrediction = arrayPrediction;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "BuyTicketDTO [userId=" + userId + ", amount=" + amount + ", currency=" + currency + ", arrayGameId="
				+ Arrays.toString(arrayGameId) + ", arrayPrediction=" + Arrays.toString(arrayPrediction) + "]";
	}

}
