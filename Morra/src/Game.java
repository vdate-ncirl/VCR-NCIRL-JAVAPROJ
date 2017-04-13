
public class Game {
	
	Player player;
	Play play;
	Score score;
	
	//public Game(int sessionID){
	//	this.sessionID = sessionID;
	//}
	
	public Game(Player p1, Player p2) {
		this.player = p1;
		play = this.player.getLastPLay();
		
		int playerType =  player.getPlayAsType();
		
		if (play.getplay() == ((p2.getLastPLay().getplay()) % 2)) {
			score = new Score(2);
		}
		else  score = new Score(0);
	}
}
