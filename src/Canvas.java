import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Canvas extends Pane {

	Rectangle[] bars;
	
	public Canvas (int width, int height) {
		setPrefSize(width, height);
		setStyle("-fx-border-color: grey");
	}
	
	Rectangle drawBar(double x, double width, double height, Color color) {
		Rectangle bar = new Rectangle(x, getHeight() - height, width, height);
//		Rectangle bar = new Rectangle();
		bar.xProperty().bind(widthProperty().multiply(x / getWidth()));
		bar.widthProperty().bind(widthProperty().multiply(width / getWidth()));
//		bar.yProperty().bind(heightProperty().multiply((getHeight() - height) / getHeight()));
//		bar.heightProperty().bind(heightProperty().multiply(height / getHeight()));
		bar.setFill(color);
		getChildren().add(bar);
		return bar;
	}
	
	public void initBars(int[] numList) {
		bars = new Rectangle[numList.length];
		for (int i = 0; i < bars.length; i++) {
			double barWidth = getWidth() / bars.length;
			bars[i] = drawBar(barWidth * i, barWidth, getHeight() / bars.length * (i + 1), Color.WHITE);
		}
	}
	
	public void updateBars(int[] numList) {
		for (int i = 0; i < bars.length; i++) {
			double newHeight = getHeight() / bars.length * (numList[i] + 1);
			bars[i].setY(getHeight() - newHeight);
			bars[i].setHeight(newHeight);
		}
	}
	
//	class Bar {
//		Rectangle bar;
//		public Bar(IntegerProperty index, IntegerProperty barsTotal, double width, double height, Color color) {
//			bar = new Rectangle();
//			bar.xProperty().bind(index.divide(barsTotal).multiply(widthProperty()));
//			bar.yProperty().bind(index.divide(barsTotal).multiply(heightProperty()));
//		}
//	}
}
