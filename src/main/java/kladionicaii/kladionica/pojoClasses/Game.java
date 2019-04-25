package kladionicaii.kladionica.pojoClasses;

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
@Table(name="game")
public class Game {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="designation")
	private String designation;

	@Column(name="flag")
	private Integer flag;
	
	@Column(name="time")
	private LocalDateTime time;

	@JoinColumn(name = "fkidoperater")
    @ManyToOne(optional = false)
    private Operater operater;
	
	public Game() {
	}

	public Game(String designation, Integer flag, LocalDateTime time, Operater operater) {
		this.designation = designation;
		this.flag = flag;
		this.time = time;
		this.operater = operater;
	}

	public Game(Integer id, String designation, Integer flag, LocalDateTime time, Operater operater) {
		this.id = id;
		this.designation = designation;
		this.flag = flag;
		this.time = time;
		this.operater = operater;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Operater getOperater() {
		return operater;
	}

	public void setOperater(Operater operater) {
		this.operater = operater;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", designation=" + designation + ", flag=" + flag + ", time=" + time + ", operater="
				+ operater + "]";
	}
	
}
