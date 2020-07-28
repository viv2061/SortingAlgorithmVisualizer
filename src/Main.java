import java.util.Random;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	// pane and window sizes
	static int windowWidth = 1200;
	static int windowHeight = 700;
	static int uiHeight = 70;
	
	// adding all panes
	public static VBox rootPane;
	public static Ui ui;
	public static Canvas canvas;
	
	public static IntegerProperty total = new SimpleIntegerProperty(50);
	public static DoubleProperty delayTime = new SimpleDoubleProperty(100);
	public static StringProperty algorithmName = new SimpleStringProperty("None");
	public static IntegerProperty arrayComparisons = new SimpleIntegerProperty(0);
	int[] numList;
	
	Random random;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage stage) {
		rootPane = new VBox();
		ui = new Ui(windowWidth, uiHeight);
		canvas = new Canvas(windowWidth, windowHeight - uiHeight);
		
		rootPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		rootPane.getChildren().addAll(ui, canvas);
		Scene scene = new Scene(rootPane, windowWidth, windowHeight);
		stage.setScene(scene);
		stage.setTitle("Sorting Algorithm Visualizer");
		stage.show();
		
		initNumList();
		canvas.initBars(numList);
		ui.initUi();
		
		randommizeList();
		printList();
	}
	
	void initNumList() {
		numList = new int[total.get()];
		for (int i = 0; i < numList.length; i++) {
			numList[i] = i;
		}
	}
	
	void randommizeList() {
		if (random == null) {
			random = new Random();
		}
		for (int i = 0; i < numList.length; i++) {
			swapNumbers(i, random.nextInt(numList.length));
		}
	}
	
	void swapNumbers(int i, int j) {
		int temp = numList[i];
		numList[i] = numList[j];
		numList[j] = temp;
		canvas.updateBars(numList);
	}
	
	void printList() {
		System.out.println();
		for (int num : numList) {
			System.out.print(num + ", ");
		}
	}
}
