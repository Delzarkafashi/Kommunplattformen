public class Main {
    public static void main(String[] args) {
        Enhet bibliotek = new Enhet("Biblioteket");
        Medarbetare medarbetare = new Medarbetare("Kim");
        Medarbetare ansvarig = new Handlaggare("Sam");
        AvvikelseService service = new AvvikelseService();
        System.out.println("Antal från start: " + service.antal());
        service.skrivOversikt();
        service.registrera("Trasig lampa", bibliotek, medarbetare);
        service.registrera("   ", bibliotek, medarbetare);
        service.registrera("Trasig lampa", bibliotek, ansvarig);
        service.skrivOversikt();
        visaSokresultat(service, 2);
        visaSokresultat(service, 99);

        System.out.println("Uppdaterad: " + service.uppdateraStatus(2, "Avslutad"));
        System.out.println("Saknat ID: " + service.uppdateraStatus(99, "Avslutad"));
        System.out.println("Ogiltig status: " + service.uppdateraStatus(1, "Klar"));
        service.skrivOversikt();
        service.skrivMedStatus("Öppen");
        System.out.println("Öppna: " + service.antalMedStatus("Öppen"));
        System.out.println("Avslutade: " + service.antalMedStatus("Avslutad"));
        System.out.println("Alla: " + service.antal());

        System.out.println(medarbetare.presentera());
        System.out.println(ansvarig.presentera());
    }

    static void visaSokresultat(AvvikelseService service, int id) {
        Avvikelse hittad = service.hitta(id);
        if (hittad == null) {
            System.out.println("Ingen avvikelse med ID " + id);
        } else {
            System.out.println("Hittad: " + hittad.getId() + " – "
                + hittad.getBeskrivning() + " – " + hittad.getStatus());
        }
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
