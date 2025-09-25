module edu.westga.cs1302.project_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens edu.westga.cs1302.project_1.model.views to javafx.fxml;
    exports edu.westga.cs1302.project_1.model;
}
