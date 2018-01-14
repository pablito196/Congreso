package Bean;

import Contratos.EventoParticipantePagoContrato;
import Modelo.EventoParticipantePago;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@ManagedBean
@Named(value = "eventoParticipanteBean")
@ViewScoped
public class EventoParticipanteBean {

    private List<EventoParticipantePago> listaParticipantesEvento;
    private List<EventoParticipantePago> listaFiltradaParticipantesEvento;
    
    public EventoParticipanteBean() {
    }

    public List<EventoParticipantePago> getListaParticipantesEvento() {
        EventoParticipantePagoContrato eventoParticipantePago =  new EventoParticipantePago();
        listaParticipantesEvento = eventoParticipantePago.ListarParticipantesEvento();
        return listaParticipantesEvento;
    }

    public void setListaParticipantesEvento(List<EventoParticipantePago> listaParticipantesEvento) {
        this.listaParticipantesEvento = listaParticipantesEvento;
    }

    public List<EventoParticipantePago> getListaFiltradaParticipantesEvento() {
        return listaFiltradaParticipantesEvento;
    }

    public void setListaFiltradaParticipantesEvento(List<EventoParticipantePago> listaFiltradaParticipantesEvento) {
        this.listaFiltradaParticipantesEvento = listaFiltradaParticipantesEvento;
    }
    
    
}
