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
    private List<EventoParticipantePago> listaParticipantesFaltaPago;
    private List<EventoParticipantePago> listaFiltradaParticipantesFaltaPago;
    private List<EventoParticipantePago> listaParticipantesPagoCompleto;
    private List<EventoParticipantePago> listaFiltradaParticipantesPagoCompleto;
    
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

    public List<EventoParticipantePago> getListaParticipantesFaltaPago() {
        EventoParticipantePagoContrato eventoParticipantePago =  new EventoParticipantePago();
        listaParticipantesFaltaPago = eventoParticipantePago.ListarParticipantesPagoPendiente();
        return listaParticipantesFaltaPago;
    }

    public void setListaParticipantesFaltaPago(List<EventoParticipantePago> listaParticipantesFaltaPago) {
        this.listaParticipantesFaltaPago = listaParticipantesFaltaPago;
    }

    public List<EventoParticipantePago> getListaFiltradaParticipantesFaltaPago() {
        return listaFiltradaParticipantesFaltaPago;
    }

    public void setListaFiltradaParticipantesFaltaPago(List<EventoParticipantePago> listaFiltradaParticipantesFaltaPago) {
        this.listaFiltradaParticipantesFaltaPago = listaFiltradaParticipantesFaltaPago;
    }

    public List<EventoParticipantePago> getListaParticipantesPagoCompleto() {
        EventoParticipantePagoContrato eventoParticipantePago =  new EventoParticipantePago();
        listaParticipantesPagoCompleto = eventoParticipantePago.ListarParticipantesCompletoPago();
        return listaParticipantesPagoCompleto;
    }

    public void setListaParticipantesPagoCompleto(List<EventoParticipantePago> listaParticipantesPagoCompleto) {
        this.listaParticipantesPagoCompleto = listaParticipantesPagoCompleto;
    }

    public List<EventoParticipantePago> getListaFiltradaParticipantesPagoCompleto() {
        return listaFiltradaParticipantesPagoCompleto;
    }

    public void setListaFiltradaParticipantesPagoCompleto(List<EventoParticipantePago> listaFiltradaParticipantesPagoCompleto) {
        this.listaFiltradaParticipantesPagoCompleto = listaFiltradaParticipantesPagoCompleto;
    }
    
    
    
    public void printPDFListaParticipantesEvento() throws JRException, IOException {
        
        PdfPrint imprimirPdf = new PdfPrint();
        
        List<EventoParticipantePago> participantesEvento = new ArrayList<>();
        if(listaFiltradaParticipantesEvento == null)
        {
            participantesEvento = listaParticipantesEvento;
        }
        else
        {
            participantesEvento = this.listaFiltradaParticipantesEvento;
        }
        String filename = "ListaParticipantesEvento.pdf";
        String JasperPath = "resources/reportes/ListaParticipantes.jasper";
        imprimirPdf.PDF(null, JasperPath, participantesEvento, filename);
    }
    public void printPDFListaParticipantesEventoFaltaPago() throws JRException, IOException {
        
        PdfPrint imprimirPdf = new PdfPrint();
        
        List<EventoParticipantePago> participantesEvento = new ArrayList<>();
        if(listaFiltradaParticipantesEvento == null)
        {
            participantesEvento = listaParticipantesFaltaPago;
        }
        else
        {
            participantesEvento = this.listaFiltradaParticipantesEvento;
        }
        String filename = "ListaParticipantesDeudores.pdf";
        String JasperPath = "resources/reportes/ListaParticipantesFaltaPago.jasper";
        imprimirPdf.PDF(null, JasperPath, participantesEvento, filename);
    }
    public void printPDFListaParticipantesEventoPagoCompleto() throws JRException, IOException {
        
        PdfPrint imprimirPdf = new PdfPrint();
        
        List<EventoParticipantePago> participantesEvento = new ArrayList<>();
        if(listaFiltradaParticipantesPagoCompleto == null)
        {
            participantesEvento = this.listaParticipantesPagoCompleto;
        }
        else
        {
            participantesEvento = this.listaFiltradaParticipantesPagoCompleto;
        }
        String filename = "ListaParticipantesPagoCompleto.pdf";
        String JasperPath = "resources/reportes/ListaParticipantesPagoCompleto.jasper";
        imprimirPdf.PDF(null, JasperPath, participantesEvento, filename);
    }
    
}
