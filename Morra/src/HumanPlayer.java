import java.util.Random;

public class HumanPlayer extends Player {

	public HumanPlayer(String playerName) {
		super(playerName);
	}

	@Override
	public Play Play() {
		Random rand = new Random();
		int play= rand.nextInt(10) + 1;
		Play p = new Play(this, play );
		return p;
	}
}
