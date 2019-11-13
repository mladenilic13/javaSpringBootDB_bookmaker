package kladionicaii.kladionica.pojoClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	// validation
	@NotEmpty(message = "name required")
	@Column(name="name")
	private String name;

	// validation
	@NotEmpty(message = "email required")
	@Column(name="email")
	private String email;

	// validation
	@NotEmpty(message = "pass required")
	@Column(name="pass")
	private String pass;
	
	public User() {
	}

	public User(@NotEmpty(message = "name required") String name,
			@NotEmpty(message = "email required") String email,
			@NotEmpty(message = "pass required") String pass) {
		this.name = name;
		this.email = email;
		this.pass = pass;
	}

	public User(Integer id, @NotEmpty(message = "name required") String name,
			@NotEmpty(message = "email required") String email,
			@NotEmpty(message = "pass required") String pass) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
	}

	public User(@NotEmpty(message = "name required") String name,
			@NotEmpty(message = "pass required") String pass) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + "]";
	}

}
