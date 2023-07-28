module edu.fiuba.algo3 {
    requires transitive javafx.graphics;
    requires javafx.controls;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.controladores;
    exports edu.fiuba.algo3.vistas;
    exports edu.fiuba.algo3.modelo;
	requires json.simple;
}