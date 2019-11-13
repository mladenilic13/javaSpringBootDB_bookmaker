package kladionicaii.kladionica.pojoClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="operater")
public class Operater {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;

	@Column(name="pass")
	private String pass;
	
	public Operater() {
	}

	public Operater(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public Operater(Integer id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Operater [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	
}
