package se.kommun;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {
    TextField beskrivning = new TextField("Avvikelsetext");
    Paragraph resultat = new Paragraph("Ingen förhandsvisning ännu.");

    public MainView() {
        Button visa = new Button("Förhandsvisa");
        visa.addClickListener(event -> visaForhandsvisning());
        add(new H2("Kommunens verksamhetssystem"), beskrivning, visa, resultat);
    }

    void visaForhandsvisning() {
        String text = beskrivning.getValue().trim();
        if (text.isEmpty()) {
            resultat.setText("Skriv en fiktiv avvikelsetext.");
        } else {
            resultat.setText("Fiktiv avvikelse: " + text);
        }
    }
}
