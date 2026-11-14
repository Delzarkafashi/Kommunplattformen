package se.kommun;

import java.util.List;
import java.util.ArrayList;

public class AvvikelseService {
    private final List<Avvikelse> avvikelser = new ArrayList<>();
    private int nastaId = 1;

    public boolean arTom(String beskrivning) {
        return beskrivning.trim().isEmpty();
    }

    public boolean registrera(String beskrivning, Enhet enhet, Medarbetare ansvarig) {
        if (arTom(beskrivning)) {
            return false;
        }
        laggTill(skapa(beskrivning, enhet, ansvarig));
        nastaId = nastaId + 1;
        return true;
    }

    private Avvikelse skapa(String beskrivning, Enhet enhet, Medarbetare ansvarig) {
        return new Avvikelse(nastaId, beskrivning.trim(), enhet, ansvarig);
    }

    private void laggTill(Avvikelse avvikelse) {
        avvikelser.add(avvikelse);
    }

    public int antal() {
        return avvikelser.size();
    }

    public List<Avvikelse> hamtaAlla() {
        return avvikelser;
    }

    public Avvikelse hitta(int id) {
        for (Avvikelse avvikelse : avvikelser) {
            if (avvikelse.getId() == id) {
                return avvikelse;
            }
        }
        return null;
    }

    public boolean uppdateraStatus(int id, String nyStatus) {
        Avvikelse hittad = hitta(id);
        if (hittad == null) {
            return false;
        }
        return hittad.andraStatus(nyStatus);
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
