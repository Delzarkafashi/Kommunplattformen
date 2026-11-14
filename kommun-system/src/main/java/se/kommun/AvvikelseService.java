package se.kommun;

import java.util.List;
import java.util.ArrayList;

public class AvvikelseService {
    private List<Avvikelse> avvikelser = new ArrayList<>();

    public boolean arTom(String beskrivning) {
        return beskrivning.trim().isEmpty();
    }

    public Avvikelse skapa(String beskrivning, Enhet enhet, Medarbetare ansvarig) {
        return new Avvikelse(beskrivning.trim(), "Öppen", enhet, ansvarig);
    }

    public void laggTill(Avvikelse avvikelse) {
        avvikelser.add(avvikelse);
    }

    public int antal() {
        return avvikelser.size();
    }

    public List<Avvikelse> hamtaAlla() {
        return avvikelser;
    }

    public int antalMedStatus(String status) {
        int raknare = 0;
        for (Avvikelse avvikelse : avvikelser) {
            if (avvikelse.getStatus().equals(status)) {
                raknare = raknare + 1;
            }
        }
        return raknare;
    }
}
