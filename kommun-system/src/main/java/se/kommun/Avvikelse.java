package se.kommun;

public class Avvikelse {
    private String beskrivning;
    private String status;

    public Avvikelse(String beskrivning) {
        this.beskrivning = beskrivning;
        this.status = "Öppen";
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public String getStatus() {
        return status;
    }
}
