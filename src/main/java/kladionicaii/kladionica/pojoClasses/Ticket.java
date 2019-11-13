package kladionicaii.kladionica.pojoClasses;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="processed")
	private Integer processed;
	
	@JoinColumn(name = "fkiduser")
    @ManyToOne(optional = false)
    private User user;
	
	public Ticket() {
	}
	
	public Ticket(BigDecimal amount, User user) {
		this.amount = amount;
		this.user = user;
		this.processed = 0;
	}

	public Ticket(Integer id, BigDecimal amount, User user) {
		this.id = id;
		this.amount = amount;
		this.user = user;
		this.processed = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getProcessed() {
		return processed;
	}

	public void setProcessed(Integer processed) {
		this.processed = processed;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", amount=" + amount + ", processed=" + processed + ", user=" + user + "]";
	}

}
