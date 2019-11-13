package kladionicaii.kladionica.pojoClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="gameticket")
public class GameTicket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="prediction")
	private Integer prediction;

	@JoinColumn(name = "fkidticket")  //, referencedColumnName="idtiket")
    @ManyToOne(optional = false)
    private Ticket ticket;
	
	@JoinColumn(name = "fkidgame")
    @ManyToOne(optional = false)
    private Game game;
	
	public GameTicket() {
	}

	public GameTicket(Integer prediction, Game game) {
		this.prediction = prediction;
		this.game = game;
	}

	public GameTicket(Integer id, Integer prediction, Game game) {
		this.id = id;
		this.prediction = prediction;
		this.game = game;
	}

	public GameTicket(Integer prediction, Ticket ticket, Game game) {
		this.prediction = prediction;
		this.ticket = ticket;
		this.game = game;
	}

	public GameTicket(Integer id, Integer prediction, Ticket ticket, Game game) {
		this.id = id;
		this.prediction = prediction;
		this.ticket = ticket;
		this.game = game;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrediction() {
		return prediction;
	}

	public void setPrediction(Integer prediction) {
		this.prediction = prediction;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public String toString() {
		return "GameTicket [id=" + id + ", prediction=" + prediction + ", ticket=" + ticket + ", game=" + game + "]";
	}
	
}
