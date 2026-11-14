package se.kommun;

public class Avvikelse {
    private final int id;
    private final String beskrivning;
    private String status = "Öppen";
    private Enhet enhet;
    private Medarbetare ansvarig;

    public Avvikelse(int id, String beskrivning,
                     Enhet enhet, Medarbetare ansvarig) {
        this.id = id;
        this.beskrivning = beskrivning;
        this.enhet = enhet;
        this.ansvarig = ansvarig;
    }

    public int getId() {
        return id;
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

    public boolean andraStatus(String nyStatus) {
        if ("Öppen".equals(nyStatus)) {
            status = nyStatus;
            return true;
        }
        if ("Avslutad".equals(nyStatus)) {
            status = nyStatus;
            return true;
        }
        return false;
    }
}
