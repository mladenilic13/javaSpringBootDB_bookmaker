
package kladionicaii.kladionica.pojoDTOClasses;
  
import java.time.LocalDateTime;

import kladionicaii.kladionica.pojoClasses.User;
  
public class SearchInputDTO {
  
	private LocalDateTime sinceTime;
  
	private LocalDateTime tillTime;
  
	private User user;
  
	public SearchInputDTO() {
	}

	public SearchInputDTO(LocalDateTime sinceTime, LocalDateTime tillTime, User user) {
		this.sinceTime = sinceTime;
		this.tillTime = tillTime;
		this.user = user;
	}

	public LocalDateTime getSinceTime() {
		return sinceTime;
	}

	public void setSinceTime(LocalDateTime sinceTime) {
		this.sinceTime = sinceTime;
	}

	public LocalDateTime getTillTime() {
		return tillTime;
	}

	public void setTillTime(LocalDateTime tillTime) {
		this.tillTime = tillTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SearchInputDTO [sinceTime=" + sinceTime + ", tillTime=" + tillTime + ", user=" + user + "]";
	}

}
 