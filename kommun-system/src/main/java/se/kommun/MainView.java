package se.kommun;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {
    private AvvikelseService service = new AvvikelseService();
    private TextField beskrivning = new TextField("Fiktiv avvikelse");
    private Paragraph resultat = new Paragraph();
    private Paragraph meddelande = new Paragraph();

    public MainView() {
        Button visa = new Button("Förhandsvisa", event -> forhandsvisa());
        add(new H1("Kommunens verksamhetssystem"),
            beskrivning, visa, meddelande, resultat);
    }

    private void forhandsvisa() {
        String text = beskrivning.getValue();
        if (service.arTom(text)) {
            meddelande.setText("Beskrivning saknas");
        } else {
            Avvikelse avvikelse = service.skapa(text);
            resultat.setText(avvikelse.getBeskrivning()
                + " – " + avvikelse.getStatus());
            meddelande.setText("");
        }
    }
}
