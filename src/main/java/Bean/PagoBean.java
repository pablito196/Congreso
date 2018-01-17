package Bean;

import Contratos.PagoContrato;
import Modelo.EventoParticipante;
import Modelo.EventoParticipantePago;
import Modelo.Pago;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private Pago ultimoPago;
    private EventoParticipantePago eventoParticipantePago;
    private List<Pago> listaPagosPendientes;
    
    private BigDecimal montoPagado;
    private BigDecimal saldo;

    public PagoBean() {
        eventoParticipantePago = new EventoParticipantePago();
        listaPagosPendientes = new ArrayList<>();
        pago = new Pago();
        montoPagado = new BigDecimal(0);
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

    public Pago getUltimoPago() {
        //pago = new Pago();
        ultimoPago = new Pago();
        PagoContrato pagoContrato = new Pago();
        ultimoPago = pagoContrato.UltimoPago(eventoParticipantePago.getIdEventoParticipante());
        if (ultimoPago != null) {
            
            //pago.setSaldo(ultimoPago.getSaldo());
            saldo = ultimoPago.getSaldo();
        }
        return ultimoPago;
    }

    public void setUltimoPago(Pago ultimoPago) {
        this.ultimoPago = ultimoPago;
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    //METODOS
    public void guardarPago() {
        int idEventoParticipante = 0;
        java.sql.Date fechahoy = new java.sql.Date(new java.util.Date().getTime());
        PagoContrato pagoContrato = new Pago();

        idEventoParticipante = eventoParticipantePago.getIdEventoParticipante();
        pago.setIdEventoParticipante(idEventoParticipante);
        pago.setFecha(fechahoy);
        pago.setMontoPagado(montoPagado);
        pago.setSaldo(saldo);
        pagoContrato.Guardar(pago);
        nuevoPago();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Pago registrado correctamente"));

    }

    public void nuevoPago() {
        pago = new Pago();
        montoPagado = new BigDecimal(0);
        saldo = new BigDecimal(0);
    }
    
    public void calcularSaldo() {
        if (montoPagado != null) {
            if (montoPagado.compareTo(BigDecimal.ZERO) == 0) {
                saldo = ultimoPago.getSaldo();
            } else {
                saldo = ultimoPago.getSaldo().subtract(montoPagado);
            }
        }
        else
        {
            saldo = ultimoPago.getSaldo();
        }    
        
    }

}
