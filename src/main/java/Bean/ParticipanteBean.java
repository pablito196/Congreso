package Bean;

import Modelo.Evento;
import Modelo.EventoParticipante;
import Modelo.Participante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "participanteBean")
@ViewScoped
public class ParticipanteBean implements Serializable{

    private Evento evento;
    private Participante participante;
    private EventoParticipante eventoParticipante;
    
    
    public ParticipanteBean() {
        participante = new Participante();
        evento = new Evento();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public EventoParticipante getEventoParticipante() {
        return eventoParticipante;
    }

    public void setEventoParticipante(EventoParticipante eventoParticipante) {
        this.eventoParticipante = eventoParticipante;
    }

    
}
