module org.javafxtest.javafxtest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.javafxtest.javafxtest to javafx.fxml;
    exports org.javafxtest.javafxtest;
}