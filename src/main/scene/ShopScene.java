package main.scene;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.SkaterGame;

public class ShopScene extends GeneralScene{

	public ShopScene() {
		super(); 
	}
	
	private void showShopMessage() {
		Font myFont = Font.font("Arial", FontWeight.NORMAL, 32); 
		gc.setFont(myFont);
		gc.setFill(Color.ALICEBLUE);
		gc.fillText("SHOP", 325, 30);
		
		myFont = Font.font("Arial", FontWeight.NORMAL, 20);
		gc.setFont(myFont);
		gc.setFill(Color.WHITE);
		gc.fillText("Press esc to go back to Welcome Scene", 200, 275);
	}
	
	@Override
	public void draw() {
		activeKeys.clear(); 
		new AnimationTimer() {
			@Override
			public void handle(long currentNanoTime) {
				gc.setFill(Color.PURPLE);
				gc.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
				showShopMessage();
				if(activeKeys.contains(KeyCode.ESCAPE)) {
					this.stop(); 
					SkaterGame.setScene(SkaterGame.WELCOME_SCENE); 
				}
			}
		}.start();
	}
	
	
	
}
