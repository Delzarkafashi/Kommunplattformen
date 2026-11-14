import java.util.List;
import java.util.ArrayList;

public class AvvikelseService {
    private List<Avvikelse> avvikelser = new ArrayList<>();

    public void laggTill(Avvikelse avvikelse) {
        avvikelser.add(avvikelse);
    }

    public int antal() {
        return avvikelser.size();
    }

    public void skrivOversikt() {
        if (antal() == 0) {
            System.out.println("Inga avvikelser");
        } else {
            for (Avvikelse avvikelse : avvikelser) {
                System.out.println(avvikelse.getBeskrivning()
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
