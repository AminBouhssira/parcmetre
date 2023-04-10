package parcmetre;

import java.time.LocalDateTime;
import java.util.Date;

public class Ticket {
    private LocalDateTime heurePaiement;
    private LocalDateTime heureLimiteStationnement;
    private String numero;
    
    public Ticket(LocalDateTime heurePaiement, LocalDateTime heureLimiteStationnement, String numero) {
        this.heurePaiement = heurePaiement;
        this.heureLimiteStationnement = heureLimiteStationnement;
        this.numero = numero;
    }
    
    public Ticket(Date now, Date time) {
		// TODO Auto-generated constructor stub
	}

	public LocalDateTime getHeurePaiement() {
        return heurePaiement;
    }
    
    public LocalDateTime getHeureLimiteStationnement() {
        return heureLimiteStationnement;
    }
    
    public String getNumero() {
        return numero;
    }
    
    // Autres méthodes de la classe Ticket, si besoin
}