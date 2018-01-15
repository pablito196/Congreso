package Bean;

import Contratos.PagoContrato;
import Modelo.EventoParticipante;
import Modelo.EventoParticipantePago;
import Modelo.Pago;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@ManagedBean
@Named(value = "pagoBean")
@ViewScoped
public class PagoBean implements Serializable {

    private Pago pago;
    private EventoParticipantePago eventoParticipantePago;
    private List<Pago> listaPagosPendientes;

    public PagoBean() {
        eventoParticipantePago = new EventoParticipantePago();
        listaPagosPendientes = new ArrayList<>();
        pago = new Pago();
    }

    public EventoParticipantePago getEventoParticipantePago() {
        return eventoParticipantePago;
    }

    public void setEventoParticipantePago(EventoParticipantePago eventoParticipantePago) {
        this.eventoParticipantePago = eventoParticipantePago;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public List<Pago> getListaPagosPendientes() {
        PagoContrato pagoContrato = new Pago();
        listaPagosPendientes = pagoContrato.Listar(eventoParticipantePago.getIdEventoParticipante());
        return listaPagosPendientes;
    }

    public void setListaPagosPendientes(List<Pago> listaPagosPendientes) {
        this.listaPagosPendientes = listaPagosPendientes;
    }

    //METODOS
    public void guardarPago() {
        int idEventoParticipante = 0;
        java.sql.Date fechahoy = new java.sql.Date(new java.util.Date().getTime());
        PagoContrato pagoContrato = new Pago();

        idEventoParticipante = eventoParticipantePago.getIdEventoParticipante();
        pago.setIdEventoParticipante(idEventoParticipante);
        pago.setFecha(fechahoy);
        pagoContrato.Guardar(pago);
        nuevoPago();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Pago registrado correctamente"));
        
    }

    public void nuevoPago()
    {
        pago = new Pago();
    }

}
