package principal;

import java.util.logging.Level;
import java.util.logging.Logger;


public class TesteJogo {
	public static void main(String[] args){
		Game game = new Game();
            try {
                game.play();
            } catch (InvalidCommandException ex) {
                Logger.getLogger(TesteJogo.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

}
