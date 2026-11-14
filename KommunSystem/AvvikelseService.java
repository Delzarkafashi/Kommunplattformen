import java.util.List;
import java.util.ArrayList;

public class AvvikelseService {
    private final List<Avvikelse> avvikelser = new ArrayList<>();
    private int nastaId = 1;

    public boolean registrera(String beskrivning, Enhet enhet, Medarbetare ansvarig) {
        if (beskrivning.trim().isEmpty()) {
            return false;
        }
        laggTill(new Avvikelse(nastaId, beskrivning.trim(), enhet, ansvarig));
        nastaId = nastaId + 1;
        return true;
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

    public void skrivOversikt() {
        if (antal() == 0) {
            System.out.println("Inga avvikelser");
        } else {
            for (Avvikelse avvikelse : avvikelser) {
                System.out.println(avvikelse.getId() + ": " + avvikelse.getBeskrivning()
                    + " | " + avvikelse.getStatus()
                    + " | " + avvikelse.getEnhet().getNamn()
                    + " | " + avvikelse.getAnsvarig().getNamn());
            }
        }
    }

    public void skrivMedStatus(String status) {
        for (Avvikelse avvikelse : avvikelser) {
            if (avvikelse.getStatus().equals(status)) {
                System.out.println(avvikelse.getBeskrivning()
                    + " | " + avvikelse.getStatus());
            }
        }
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
