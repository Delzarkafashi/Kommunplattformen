public class Main {
    public static void main(String[] args) {
        Avvikelse forsta = new Avvikelse("Trasig lampa", "Öppen");
        Avvikelse andra = new Avvikelse("Trasig dörr", "Pågår");

        System.out.println(forsta.getBeskrivning());
        System.out.println(forsta.getStatus());

        forsta.uppdateraStatus("Okänd");
        System.out.println(forsta.getStatus());

        forsta.uppdateraStatus("Avslutad");
        System.out.println(forsta.hamtaText());
        System.out.println(andra.hamtaText());

        Medarbetare medarbetare = new Medarbetare("Alex");
        Medarbetare ansvarig = new Handlaggare("Sam");

        System.out.println(medarbetare.presentera());
        System.out.println(ansvarig.presentera());
    }
}

class Medarbetare {
    private String namn;

    public Medarbetare(String namn) {
        this.namn = namn;
    }

    public String getNamn() {
        return namn;
    }

    public String presentera() {
        return "Medarbetare: " + getNamn();
    }
}

class Handlaggare extends Medarbetare {
    public Handlaggare(String namn) {
        super(namn);
    }

    @Override
    public String presentera() {
        return "Handläggare: " + getNamn();
    }
}
