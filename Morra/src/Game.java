
public class Game {
	
	public static final int MAXSCORE = 6;
	private Player player;
	private Play p;
	private int score;
	
	public Game(Player player) {
		this.player = player;
	}
	
	public void Play () {
		p = player.Play();
	}
	
	public Player getPlayer () {
		return player;
	}
	
	public Play getPlay() {
		return p;
	}
	
	public int getScore(){
		return score;
	}
	
	public void ComputeScore(Player otherPlayer){
	
		int myPlayType = player.getPlayAsType();
//		int otherPlayType = otherPlayer.getPlayAsType();
		int myPlay = player.getLastPLay().getplay();
		int otherPlay = otherPlayer.getLastPLay().getplay();
		
		int sum = myPlay + otherPlay;
		
		int sumPlayType  = sum % 2;
		if (myPlayType == sumPlayType) 
			score += 2;
		//Score s = new Score(score); //Typecast (int)score to Score object.
	
		//player.AddPlayScore(s);
	}
}
