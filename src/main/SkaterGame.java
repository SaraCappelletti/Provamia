package main;

import javax.security.auth.login.CredentialException;

import javafx.application.Application;
import javafx.stage.Stage;
import main.scene.CreditsScene;
import main.scene.GameScene;
import main.scene.GeneralScene;
import main.scene.ShopScene;
import main.scene.WelcomeScene;

public class SkaterGame extends Application {
	
	//creo delle constanti per le mie schermate di gioco
	public static final int MAX_SCENES = 4;
	public static final int WELCOME_SCENE = 0;
	public static final int GAME_SCENE = 1;
	public static final int CREDITS_SCENE = 2;
	public static final int SHOP_SCENE = 3; 
	
	public static final GeneralScene[] scenes = new GeneralScene[MAX_SCENES];
	
	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		//creo lo stage
		this.stage = stage;
		//gli metto le mie schermate
		scenes[0] = new WelcomeScene();
		scenes[1] = new GameScene();
		scenes[2] = new CreditsScene();
		scenes[3] = new ShopScene(); 
		
		stage.setTitle("Skater Game");
		setScene(WELCOME_SCENE);
		stage.show();
	}
	
	//per cambiare schermata
	public static void setScene(int numScene) {
		stage.setScene(scenes[numScene]);
		scenes[numScene].draw();
	}
	
	public static void exit() {
		stage.hide();
	}

}
