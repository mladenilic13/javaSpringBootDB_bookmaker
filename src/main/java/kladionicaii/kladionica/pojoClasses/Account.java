package kladionicaii.kladionica.pojoClasses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="purpose")
	private String purpose;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="time")
	private LocalDateTime time;

	@JoinColumn(name = "fkiduser")
    @ManyToOne(optional = false)
    private User user;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "rate")
	private BigDecimal rate;
	
	public Account() {
	}

	public Account(String purpose, BigDecimal amount, LocalDateTime time, User user) {
		this.purpose = purpose;
		this.amount = amount;
		this.time = time;
		this.user = user;
	}

	public Account(Integer id, String purpose, BigDecimal amount, LocalDateTime time, User user) {
		this.id = id;
		this.purpose = purpose;
		this.amount = amount;
		this.time = time;
		this.user = user;
	}

	public Account(Integer id, String purpose, BigDecimal amount, LocalDateTime time, User user, String currency,
			BigDecimal rate) {
		this.id = id;
		this.purpose = purpose;
		this.amount = amount;
		this.time = time;
		this.user = user;
		this.currency = currency;
		this.rate = rate;
	}

	public Account(String purpose, BigDecimal amount, LocalDateTime time, User user, String currency,
			BigDecimal rate) {
		this.purpose = purpose;
		this.amount = amount;
		this.time = time;
		this.user = user;
		this.currency = currency;
		this.rate = rate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", purpose=" + purpose + ", amount=" + amount + ", time=" + time + ", user=" + user
				+ ", currency=" + currency + ", rate=" + rate + "]";
	}
	
}
