package com.example.examplemathjaxjdk21;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MathFormulaDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        String htmlContent = "<html>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<script type='text/javascript' async " +
                "src='https://cdnjs.cloudflare.com/ajax/libs/mathjax/3.2.0/es5/tex-mml-chtml.js'>" +
                "</script>" +
                "</head>" +
                "<body>" +
                "<p>Вот формула: \\(\\int_0^\\infty x^2 dx\\)</p>" +
                "<p>Кириллический текст и формула: \\(\\sum_{i=1}^n a_i = b\\)</p>" +
                "</body>" +
                "</html>";

        webEngine.loadContent(htmlContent);

        Scene scene = new Scene(webView, 800, 600);
        primaryStage.setTitle("Cyrillic Math Formula Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
