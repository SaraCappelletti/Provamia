package main.scene;


import java.util.HashSet;
import java.util.Set;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

public abstract class GeneralScene extends Scene {
	
	public static final int GAME_WIDTH = 816;
	public static final int GAME_HEIGHT = 480;
	
	protected StackPane root = new StackPane();//container che conterrà il canvas con le immmagini
	protected GraphicsContext gc;//mi fa disegnare i vari elementi dentro al canvas
	
	protected Set<KeyCode> activeKeys; //bottoni premuti
	protected Set<KeyCode> releasedKeys; //bottoni lasciati
	
	public GeneralScene() {
		
		//chiamo il costruttore di Scene per inizializzare il mio
		super(new StackPane(), GAME_WIDTH, GAME_HEIGHT);
		
		//metto la mia root come root di Scene
		root = new StackPane();
		this.setRoot(root);
		
		//inizializzo il canvas e la grafica
		Canvas canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
		root.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		
		//inizializzo i set dei bottoni
		activeKeys = new HashSet<>();
		releasedKeys = new HashSet<>();
		//quando premo un tasto lo aggiungo al set
		this.setOnKeyPressed(e -> {
			activeKeys.add(e.getCode());
		});
		//quando lo lascio lo tolgo dai premuti e lo metto nell'altro set
		this.setOnKeyReleased(e -> {
			activeKeys.remove(e.getCode());
			releasedKeys.add(e.getCode());
		});
	}
	
	public abstract void draw();
}
