package kladionicaii.kladionica.pojoDTOClasses;

import java.time.LocalDateTime;

public class NotPlayedYetDTO {

	private Integer gameId;
	
	private String designation;
	
	private LocalDateTime time;

	public NotPlayedYetDTO() {
	}

	public NotPlayedYetDTO(Integer gameId, String designation, LocalDateTime time) {
		this.gameId = gameId;
		this.designation = designation;
		this.time = time;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "NotPlayedYetDTO [gameId=" + gameId + ", designation=" + designation + ", time=" + time + "]";
	}

}
