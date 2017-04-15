import java.util.*;
public class MorraApp {
	private Player h;
	private Player v;
	private ArrayList<Game[]> GameHistory ;// This is a difficult data structure to explain.
	/* ITs basically a n-rows two column array.
	 * each of column represents Game object for each of players.
	 * The Game object itself references to player , player play(i.e count picked up by player),  and points scored for that round. 
	 * 
	 * For simplification let just consig=der game object represents the points scored by player
	 * For Our purposes  score of Gamer is in column-0 and Computer score are in column-1
	 * Each row represents round of play 
	 * So [0] 1 2 = round[0] Gamer scored 1 point and Computer scored 
	 *    [1] 2 1 = round[1] Gamer scored 2 and Computer 1
	 */
	
	public MorraApp() {
		h = new HumanPlayer("Gamer");
		v = new VirtualPlayer("Computer");
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
	}
	
	
	
		public void RunApp() {
			Game g [] = new Game[2];
			
			h.Play();
			v.Play();
			
			g[0] = new Game(h, v);
			g[1] = new Game(v,h);
			
			GameHistory.add(g);
		}
}
