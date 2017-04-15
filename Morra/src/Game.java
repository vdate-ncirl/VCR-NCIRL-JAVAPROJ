
public class Game {
	
	Player player;
	Play play;
	Score score;
	
	public Game(Player p1, Player p2) {
		this.player = p1;
		play = this.player.getLastPLay();
		int playerType =  player.getPlayAsType();
		
		score = new Score();

		
		if (play.getplay() == ((p2.getLastPLay().getplay()) % 2)) {
			score.addToScore(2);
		}
	}
}
