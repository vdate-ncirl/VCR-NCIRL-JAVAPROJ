import java.util.*;
public class MorraApp {

	//private final int MaxPoints = 6;
	private HumanPlayer h;
	private VirtualPlayer v;
	
	public MorraApp() {
		final HumanPlayer h = new HumanPlayer("Gamer");
		final VirtualPlayer v = new VirtualPlayer("Computer");
		this.h = h;
		this.v = v;
	}
	
	public void init() {
		System.out.println("Do you want to play as Even Or Odd. [Even Num entry -> Even Odd Num entry -> Odd]");
		Scanner sc = new Scanner(System.in);
		int playAsType = sc.nextInt();
		int h_playAsType = playAsType % 2;
		int v_playAsType = (++playAsType) % 2;
		h.setPlayAsType(h_playAsType);
		v.setPlayAsType(v_playAsType);
		System.out.println("Choosen Playtype " + h.getPlayerName() + " : " + h.getPlayAsType() + " " + v.getPlayerName() + " : " + v.getPlayAsType());
	}
	
	

	public void RunApp() {
		
		Play hPlay = h.Play();
		Play vPlay = v.Play();
		
		
	}
}
