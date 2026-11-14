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
    private Paragraph resultat = new Paragraph();
    private Paragraph meddelande = new Paragraph();
    private Paragraph antal = new Paragraph();
    private VerticalLayout listyta = new VerticalLayout();

    public MainView() {
        Medarbetare sam = new Medarbetare("Sam");
        service.laggTill(new Avvikelse("Trasig lampa", "Öppen", enhet, ansvarig));
        service.laggTill(new Avvikelse("Halt entrégolv", "Avslutad", enhet, sam));

        Button visa = new Button("Förhandsvisa", event -> forhandsvisa());
        Button uppdatera = new Button("Uppdatera visning", event -> visaAvvikelser());
        add(new H1("Kommunens verksamhetssystem"),
            beskrivning, visa, meddelande, resultat, uppdatera, antal, listyta);
        visaAvvikelser();
    }

    private void forhandsvisa() {
        String text = beskrivning.getValue();
        if (service.arTom(text)) {
            meddelande.setText("Beskrivning saknas");
        } else {
            Avvikelse avvikelse = service.skapa(text, enhet, ansvarig);
            resultat.setText(avvikelse.getBeskrivning()
                + " – " + avvikelse.getStatus());
            meddelande.setText("");
        }
    }

    private void visaAvvikelser() {
        antal.setText("Antal avvikelser: " + service.antal());
        listyta.removeAll();
        if (service.antal() == 0) {
            listyta.add(new Paragraph("Inga avvikelser"));
        } else {
            for (Avvikelse avvikelse : service.hamtaAlla()) {
                listyta.add(new Paragraph(avvikelse.getBeskrivning()
                    + " | Status: " + avvikelse.getStatus()));
            }
        }
    }
}
