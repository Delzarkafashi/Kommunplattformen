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
    private Enhet enhet = new Enhet("Biblioteket");
    private Medarbetare ansvarig = new Medarbetare("Kim");
    private TextField beskrivning = new TextField("Fiktiv avvikelse");
    private Paragraph meddelande = new Paragraph();
    private Paragraph antal = new Paragraph();
    private VerticalLayout listyta = new VerticalLayout();

    public MainView() {
        Button registrera = new Button("Registrera", event -> registrera());
        Button uppdatera = new Button("Uppdatera visning", event -> visaAvvikelser());
        add(new H1("Kommunens verksamhetssystem"),
            beskrivning, registrera, meddelande, uppdatera, antal, listyta);
        visaAvvikelser();
    }

    private void registrera() {
        if (service.registrera(beskrivning.getValue(), enhet, ansvarig)) {
            meddelande.setText("Avvikelsen registrerades i minnet.");
            beskrivning.setValue("");
        } else {
            meddelande.setText("Beskrivning saknas.");
        }
        visaAvvikelser();
    }

    private void visaAvvikelser() {
        antal.setText("Antal avvikelser: " + service.antal());
        listyta.removeAll();
        if (service.antal() == 0) {
            listyta.add(new Paragraph("Inga avvikelser"));
        } else {
            for (Avvikelse avvikelse : service.hamtaAlla()) {
                Paragraph text = new Paragraph(AvvikelsePresentation.rad(
                    avvikelse.getId(), avvikelse.getBeskrivning(), avvikelse.getStatus()));
                Button avsluta = new Button("Avsluta avvikelse " + avvikelse.getId(),
                    event -> avsluta(avvikelse.getId()));
                listyta.add(text, avsluta);
            }
        }
    }

    private void avsluta(int id) {
        if (service.uppdateraStatus(id, "Avslutad")) {
            meddelande.setText("Avvikelse " + id + " avslutades.");
        } else {
            meddelande.setText("Avvikelse " + id + " hittades inte.");
        }
        visaAvvikelser();
    }
}
