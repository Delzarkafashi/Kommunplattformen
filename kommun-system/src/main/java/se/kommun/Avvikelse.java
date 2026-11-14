package se.kommun;

public class Avvikelse {
    private String beskrivning;
    private String status;
    private Enhet enhet;
    private Medarbetare ansvarig;

    public Avvikelse(String beskrivning, String status,
                     Enhet enhet, Medarbetare ansvarig) {
        this.beskrivning = beskrivning;
        this.status = status;
        this.enhet = enhet;
        this.ansvarig = ansvarig;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public String getStatus() {
        return status;
    }

    public Enhet getEnhet() {
        return enhet;
    }

    public Medarbetare getAnsvarig() {
        return ansvarig;
    }
}
