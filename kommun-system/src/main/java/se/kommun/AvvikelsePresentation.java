package se.kommun;

public class AvvikelsePresentation {
    public static String rad(int id, String beskrivning, String status) {
        String grundrad = "Fiktiv avvikelse #" + id + ": " + beskrivning;
        return grundrad + " | Status: " + status;
    }
}
