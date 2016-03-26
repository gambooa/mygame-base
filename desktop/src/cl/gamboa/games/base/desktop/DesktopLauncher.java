package cl.gamboa.games.base.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import cl.gamboa.games.base.MyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.height = MyGame.HEIGHT;
                config.width = MyGame.WIDTH;
                config.title = MyGame.TITLE;
		new LwjglApplication(new MyGame(), config);
	}
}
