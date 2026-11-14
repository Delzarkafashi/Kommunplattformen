package se.kommun;

public class AvvikelseService {
    public boolean arTom(String beskrivning) {
        return beskrivning.trim().isEmpty();
    }

    public Avvikelse skapa(String beskrivning) {
        return new Avvikelse(beskrivning.trim());
    }
}
