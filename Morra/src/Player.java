	import java.util.*;
public abstract class Player {
	private String playerName;
	private int playAsType;
	private ArrayList<Play> playHistory = new ArrayList<Play>();
	//private ArrayList<Score> sscoreHistory = new ArrayList<Score>();
	private int totalScore;
	
	public Player (String playerName) {
	this.playerName = playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName; 
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
	public void setPlayAsType (int playAsType) {
		this.playAsType = playAsType;
	}

	public int getPlayAsType(){
		return playAsType;
	}
	
	public void AddPlayHistory(Play p) {
		playHistory.add(p);
	}
	
	//public void AddPlayScore (Score s) {
	//	sscoreHistory.add(s);
	//}
	
	public Play getLastPLay () {
		int last = playHistory.size() -1;
		return playHistory.get(last);
	}
	
	public int gettotalScore() {
		return totalScore;
	}
	
	abstract Play Play();
}
