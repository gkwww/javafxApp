package chart;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;
import ldh.fxanimations.FadeInDownBigTransition;


public class LineChartSample extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        yAxis.setLabel("adfadfasdf");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));

        lineChart.setAnimated(true);

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        Node line = lineChart.lookup(".chart-series-line");
        line.setStyle("-fx-stroke-width:15;");

        stage.setScene(scene);
        stage.show();

//        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), line);
//        scaleTransition.setFromX(0.2);
//        scaleTransition.setFromY(0.2);
//        scaleTransition.setToX(1);
//        scaleTransition.setToY(1);
//        scaleTransition.play();

//        FadeInDownBigTransition fadeInDownBigTransition = new FadeInDownBigTransition(line);
//        fadeInDownBigTransition.play();
    }

    public static void main(String[] args)     {
        launch(args);
    }
}
