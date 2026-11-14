public class Avvikelse {
    private String beskrivning;
    private String status;

    public Avvikelse(String beskrivning, String status) {
        this.beskrivning = beskrivning;
        this.status = status;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public String getStatus() {
        return status;
    }

    public void uppdateraStatus(String nyStatus) {
        if ("Avslutad".equals(nyStatus)) {
            this.status = nyStatus;
        }
    }

    public String hamtaText() {
        return beskrivning + " | " + status;
    }
}
