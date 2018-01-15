package Bean;

import Contratos.EventoParticipantePagoContrato;
import Modelo.EventoParticipantePago;
import Utiles.PdfPrint;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import net.sf.jasperreports.engine.JRException;

@ManagedBean
@Named(value = "eventoParticipanteBean")
@ViewScoped
public class EventoParticipanteBean implements Serializable{

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
    
    public void printPDFListaParticipantesEvento() throws JRException, IOException {
        
        PdfPrint imprimirPdf = new PdfPrint();
        
        List<EventoParticipantePago> participantesEvento = new ArrayList<>();
        participantesEvento = this.listaParticipantesEvento;
        String filename = "ListaParticipantesEvento.pdf";
        String JasperPath = "resources/reportes/ListaParticipantes.jasper";
        imprimirPdf.PDF(null, JasperPath, participantesEvento, filename);
    }
    
}