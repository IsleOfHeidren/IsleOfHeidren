package com.github.isleofheidren.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
<<<<<<< HEAD
=======
import com.github.isleofheidren.game.game;
>>>>>>> 4a1c676 (imported project framework)

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
<<<<<<< HEAD
		config.setWindowedMode(1000, 600);
		config.setTitle("IsleOfHeidren");
		new Lwjgl3Application(new Heidren(), config);
=======
		config.setTitle("IsleOfHeidren");
		new Lwjgl3Application(new game(), config);
>>>>>>> 4a1c676 (imported project framework)
	}
}
