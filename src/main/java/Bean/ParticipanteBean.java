package Bean;

import Contratos.EventoContrato;
import Contratos.EventoParticipanteContrato;
import Contratos.PagoContrato;
import Contratos.ParticipanteContrato;
import Modelo.Evento;
import Modelo.EventoParticipante;
import Modelo.Pago;
import Modelo.Participante;
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
@Named(value = "participanteBean")
@ViewScoped
public class ParticipanteBean implements Serializable {

    private List<Participante> listaParticipantes;
    private List<Participante> listaFiltradaParticipantes;
    private Evento evento;
    private Participante participante;
    private EventoParticipante eventoParticipante;
    private Pago pago;

    private String ciParticipante;
    private BigDecimal montoPagado;
    private BigDecimal saldo;

    public ParticipanteBean() {
        participante = new Participante();
        evento = new Evento();
        eventoParticipante = new EventoParticipante();
        pago = new Pago();
        ciParticipante = "";
        montoPagado = new BigDecimal(0);
        saldo = new BigDecimal(0);
        listaParticipantes = new ArrayList<>();
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

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public String getCiParticipante() {
        return ciParticipante;
    }

    public void setCiParticipante(String ciParticipante) {
        this.ciParticipante = ciParticipante;
    }

    public List<Participante> getListaParticipantes() {
        ParticipanteContrato participanteContrato = new Participante();
        listaParticipantes = participanteContrato.ListarParticipantes();
        return listaParticipantes;
    }

    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public List<Participante> getListaFiltradaParticipantes() {
        return listaFiltradaParticipantes;
    }

    public void setListaFiltradaParticipantes(List<Participante> listaFiltradaParticipantes) {
        this.listaFiltradaParticipantes = listaFiltradaParticipantes;
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
    public void guardarParticipante() {
        ParticipanteContrato participanteContrato = new Participante();
        participante.setIdParticipante(participanteContrato.GuardarParticipante(participante));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Persona registrada correctamente"));
    }

    public void nuevoParticipante() {
        participante = new Participante();
    }

    //Metodo para mostrar los datos de participante por medio del campo de texto ciparticipante
    public void buscarParticipanteCi() {
        participante = new Participante();
        if (ciParticipante.equals("")) {
            return;
        }
        ParticipanteContrato participanteContrato = new Participante();

        //Obtener los datos del participante en la variable objeto participante
        // participante = participanteContrato.BuscarParticipante(ciParticipante);
        participante = participanteContrato.Buscar(ciParticipante);
        if (participante != null) {
            ciParticipante = "";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del participante agregados"));

        } else {
            ciParticipante = "";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Participante no encontrado"));
        }
    }

    //Metodo para mostrar los datos de participante por medio del dialog participante
    public void agregarDatosParticipante(String nit) {

        ParticipanteContrato participanteContrato = new Participante();
        //Obtener los datos del participante en la variable objeto participante
        participante = participanteContrato.Buscar(nit);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos del participante agregados"));
    }

    public void registroEventoParticipante() {
        int idEventoParticipante = 0;
        EventoContrato eventoContrato = new Evento();
        EventoParticipanteContrato eventoParticipanteContrato = new EventoParticipante();
        PagoContrato pagoContrato = new Pago();

        evento = eventoContrato.EsSeleccionado();
        if (evento != null) {
            eventoParticipante.setIdParticipante(participante.getIdParticipante());
            eventoParticipante.setIdEvento(evento.getIdEvento());
            idEventoParticipante = eventoParticipanteContrato.GuardarEventoParticipante(eventoParticipante);
            pago.setIdEventoParticipante(idEventoParticipante);
            pago.setFecha(eventoParticipante.getFechaRegistro());
            pagoContrato.GuardarPago(pago);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Participante registrado en el evento correctamente"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar un congreso"));
        }
    }
}
