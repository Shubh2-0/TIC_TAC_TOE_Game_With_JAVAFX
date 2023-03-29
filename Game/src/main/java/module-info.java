module org.openjfx.hellofx {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;

    opens org.openjfx.hellofx to javafx.fxml;
    exports org.openjfx.hellofx;
}
