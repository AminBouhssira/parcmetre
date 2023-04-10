package parcmetre;

import java.util.Calendar;
import java.util.Date;

public class Parcmetre implements Imprimante {
    private static final int DUREE_MAX = 8;
    private static final float PRIX_1H = 0.5f;
    private static final float PRIX_2H = 1f;
    private static final float PRIX_3H = 1.5f;
    private static final float PRIX_4H = 2f;
    private static final float PRIX_SUP = 3f;
    private static final int HEURE_OUVERTURE = 9;
    private static final int HEURE_FERMETURE = 19;
    private static final int[] JOURS_FERMES = { Calendar.SUNDAY, Calendar.MAY, Calendar.AUGUST };

    private float montantAPayer;

    public float calculerMontantAPayer(int duree) {
        if (duree < 1) {
            return 0;
        } else if (duree == 1) {
            return PRIX_1H;
        } else if (duree == 2) {
            return PRIX_2H;
        } else if (duree == 3) {
            return PRIX_3H;
        } else if (duree == 4) {
            return PRIX_4H;
        } else {
            return PRIX_4H + (duree - 4) * PRIX_SUP;
        }
    }

    public boolean estStationnementAutorise() {
        Calendar now = Calendar.getInstance();
        int jour = now.get(Calendar.DAY_OF_WEEK);
        int heure = now.get(Calendar.HOUR_OF_DAY);
        return heure >= HEURE_OUVERTURE && heure < HEURE_FERMETURE && !isJourFerme(jour);
    }

    private boolean isJourFerme(int jour) {
        for (int j : JOURS_FERMES) {
            if (jour == j) {
                return true;
            }
        }
        return false;
    }

    public int limiterDureeStationnement(int duree) {
        return Math.min(duree, DUREE_MAX);
    }

    public Ticket genererTicket() {
        Date now = new Date();
        int dureeMax = limiterDureeStationnement(DUREE_MAX);
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.HOUR_OF_DAY, dureeMax);
        return new Ticket(now, cal.getTime());
    }

    public Ticket payer(float montant) {
        if (montant <= 0) {
            return null;
        }
        int duree = (int) (montant / PRIX_1H);
        duree = limiterDureeStationnement(duree);
        montantAPayer = calculerMontantAPayer(duree);
        return genererTicket();
    }

    public void imprimer(Ticket ticket) {
        // code pour l'impression du ticket
        System.out.println("Ticket imprimé : " + ticket.toString());
    }

    public String interrogerAPI(String url) {
        // code pour simuler l'interrogation d'une API
        return "Réponse de l'API pour l'URL " + url;
    }
}



