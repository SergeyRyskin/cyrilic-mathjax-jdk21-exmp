# Cyrillic Math Formula Display

This JavaFX application displays Cyrillic mathematical formulas using the MathJax library and a WebView component. The application showcases how to render complex mathematical expressions along with Cyrillic text in a JavaFX desktop application.

> [MathJax Detailed Documentation](https://www.mathjax.org/)

## Prerequisites

- JDK 21 or later
- Maven (if using Maven for dependency management)

## Setup

### Maven Configuration

Add the following dependencies to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>21</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-web</artifactId>
        <version>21</version>
    </dependency>
</dependencies>
```

### Project Structure

Ensure your project structure looks like this:

```
CyrillicMathFormulaDisplay
├── pom.xml
└── src
    └── main
        └── java
            └── MathFormulaDisplay.java
```

### Code

Create the `MathFormulaDisplay.java` file with the following content:

```java
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
```

## Explanation

The code is a JavaFX application that displays mathematical formulas and Cyrillic text using a WebView component. Here’s a breakdown of the key components:

### `MathFormulaDisplay` Class

- **Extends `Application`:** This class extends the JavaFX `Application` class, making it a JavaFX application.

### `start(Stage primaryStage)` Method

- **WebView and WebEngine:**
    - `WebView webView = new WebView();` creates a WebView component for displaying web content.
    - `WebEngine webEngine = webView.getEngine();` gets the WebEngine associated with the WebView for loading content.

- **HTML Content:**
    - The `htmlContent` string contains the HTML content to be displayed in the WebView. It includes:
        - `<meta charset='UTF-8'>` to ensure Cyrillic characters are displayed correctly.
        - A `<script>` tag to load MathJax from a CDN for rendering LaTeX formulas.
        - Two paragraphs: one with a simple mathematical formula and another combining Cyrillic text and a formula.

- **Loading HTML Content:**
    - `webEngine.loadContent(htmlContent);` loads the HTML content into the WebEngine.

### Creating and Showing the Scene

- **Scene Setup:**
    - `Scene scene = new Scene(webView, 800, 600);` creates a new Scene with the WebView as the root node and sets its size to 800x600 pixels.
    - `primaryStage.setTitle("Cyrillic Math Formula Display");` sets the title of the primary stage.
    - `primaryStage.setScene(scene);` sets the Scene to be displayed on the primary stage.

- **Showing the Stage:**
    - `primaryStage.show();` makes the primary stage visible.

### `main` Method

- **Launch Application:**
    - `launch(args);` launches the JavaFX application.

## Running the Application

1. **Using Maven:**
    - Navigate to the project directory.
    - Run the following command to compile and run the application:
      ```sh
      mvn clean javafx:run
      ```

2. **Using IDE:**
    - Import the project into your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
    - Ensure the JavaFX SDK is configured correctly in your IDE.
    - Run the `MathFormulaDisplay` class.
