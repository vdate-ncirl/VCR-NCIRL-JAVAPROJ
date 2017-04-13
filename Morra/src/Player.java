	import java.util.*;
public abstract class Player {
	private String playerName;
	private int playAsType;
	private ArrayList<Play> playHistory = new ArrayList<Play>();
	
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
	
	public Play getLastPLay () {
		int last = playHistory.size() -1;
		return playHistory.get(last);
	}
	
	//public int getTotalpoints() {
	//	int total = 0;
	//	
	//	for (int i = 0 ; i< playHistory.size() ; i++) {
	//		total += playHistory.get(i).getPoints();
	//	}
	//	return total;
	//}
	
	abstract Play Play();
}
