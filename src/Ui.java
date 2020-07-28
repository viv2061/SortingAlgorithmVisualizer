

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Ui extends HBox {

	Label totalCount;
	Label algorithmName;
	Label delayAmount;
	Label arrayComparisons;
	
	VBox generalDisplay;
	Pane controls;
	
	public Ui(int width, int height) {
		setPrefSize(width, height);
		setStyle("-fx-border-color: grey");
	}
	
	Label addLabel(String text) {
		Label label = new Label(text);
		label.setFont(Font.font("Arial", 15));
		label.setTextFill(Color.WHITE);
		return label;
	}
	
	public void initUi() {
		generalDisplay = new VBox();
		controls = new HBox();
		getChildren().addAll(generalDisplay, controls);
		
		totalCount = addLabel("");
		algorithmName = addLabel("");
		delayAmount = addLabel("");
		arrayComparisons = addLabel("");
		
		totalCount.textProperty().bind(new SimpleStringProperty("Number of elements: ").concat(Main.total.asString()));
		algorithmName.textProperty().bind(new SimpleStringProperty("Algorithm: ").concat(Main.algorithmName));
		delayAmount.textProperty().bind(new SimpleStringProperty("Delay: ").concat(Main.delayTime.asString()).concat(" ms"));
		arrayComparisons.textProperty().bind(new SimpleStringProperty("Array comparisons: ").concat(Main.arrayComparisons.asString()));
		generalDisplay.getChildren().addAll(totalCount, algorithmName, delayAmount, arrayComparisons);
		
	}
}

