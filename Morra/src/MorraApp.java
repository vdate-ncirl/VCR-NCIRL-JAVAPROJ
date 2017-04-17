import java.util.*;
public class MorraApp {
	private Player h;
	private Player v;
	private ArrayList<Game[]> GameHistory ;// This is a difficult data structure to explain.
	/* ITs basically a n-rows two column array.
	 * each of column represents Game object for each of players.
	 * The Game object itself references to player , player play(i.e count picked up by player),  and points scored for that round. 
	 * 
	 * For simplification let just consider game object represents the points scored by player
	 * For Our purposes  score of Gamer is in column-0 and Computer score are in column-1
	 * Each row represents round of play 
	 * So [0] 1 2 = round[0] Gamer scored 1 point and Computer scored 2
	 *    [1] 2 1 = round[1] Gamer scored 2 and Computer 1
	 */
	
	public MorraApp() {
		h = new HumanPlayer("me");
		v = new VirtualPlayer("mac");
		GameHistory = new ArrayList<Game[]>();
	}
	
	public void init() {
		System.out.println("Do you want to play as Even Or Odd. [Even Num entry -> Even Odd Num entry -> Odd]");
		Scanner sc = new Scanner(System.in);
		int playAsType = sc.nextInt();
		int h_playAsType = playAsType % 2;
		int v_playAsType = (++playAsType) % 2;
		h.setPlayAsType(h_playAsType);
		v.setPlayAsType(v_playAsType);
		System.out.println("Player " + " : " + h.getPlayerName() + " : " +  "Choosen Playtype "  + " : " + h.getPlayAsType());
		System.out.println("Player " + " : " + v.getPlayerName() + " : " +  "Choosen Playtype "  + " : " + v.getPlayAsType());
		sc.close(); //This is just a eclipse thingy kept on giving warning sc not closed :)
	}
	
	public void RunApp() {
		  Game [] g =  {new Game(h), new Game(v)}; // Game of Game object for each player.
		  for (int i = 0  ; i < g.length ; i++) 
				g[i].Play();
		  
		  ComputeGameResults(g);
		  GameHistory.add(g);
	}

	private void ComputeGameResults (Game[] g){
		for (int i = 0 ; i < g.length ; i++) {
			  Game [] tmpGameArray = g;
			  for ( int j = 0 ; j < tmpGameArray.length ; j++) {
				  if (tmpGameArray[j] != g[i]) {
					  g[i].ComputeScore(tmpGameArray[j].getPlayer());
				  }
			  }
		  }
	}
	
	public int totalScore(Player p){
		int TotalScore = 0;
		for (int i = 0 ; i <GameHistory.size() ; i++) {
			  Game [] g = GameHistory.get(i);
			  for ( int j = 0 ; j < g.length; j++) {
				  if (g[j].getPlayer() == p) {
					  
					  TotalScore += g[j].getScore();
				  }
			  }
		}
		return TotalScore;
	}
	
	public void DisplayResults() {
		System.out.println("\nPlayer\tPlay\tscore\tPlayer\tPlay\tscore");
		
		for (int i = 0 ; i < GameHistory.size() ; i++) {
			Game [] g = GameHistory.get(i);
			for (int j = 0  ; j < g.length ; j++) {
				System.out.print(g[j].getPlayer().getPlayerName()  +"\t" + g[j].getPlay().getplay() +"\t" + g[j].getScore() +"\t");
			}
			System.out.println();
		}
	System.out.println("Total Score for " + h.getPlayerName() + " " + totalScore(h));
	System.out.println("Total Score for " + v.getPlayerName() + " " + totalScore(v));
	}
}
