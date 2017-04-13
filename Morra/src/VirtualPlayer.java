import java.util.*;
public class VirtualPlayer extends Player {

	public VirtualPlayer(String playerName) {
		super(playerName);
	}

	@Override
	public Play Play() {
		Random rand = new Random();
		int play= rand.nextInt(10) + 1;
		Play p = new Play(play);
		AddPlayHistory(p);
		return p;
	}
}
