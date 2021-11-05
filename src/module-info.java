//module-info.java É apenas para o intellij
//botao direito em src => new => java-module.info
//Instanciar controles e fxml depois abrir sample(View)
module ProjetoOficialUdemyJavaFx {
    requires javafx.fxml;
    requires javafx.controls;
    opens sample;
}
