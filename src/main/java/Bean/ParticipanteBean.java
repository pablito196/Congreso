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
    private List<Participante> listaCompletaParticipantes;
    private List<Participante> listaFiltradaCompletaParticipantes;
    private Evento evento;
    private Participante participante;
    private EventoParticipante eventoParticipante;
    private Pago pago;
    private Evento eventoSeleccionado;

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
        
        listaParticipantes = new ArrayList<>();
        listaCompletaParticipantes =  new ArrayList<>();
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
        listaParticipantes = participanteContrato.ListarParticipantesActivos();
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

    public Evento getEventoSeleccionado() {
        EventoContrato eventoContrato = new Evento();
        eventoSeleccionado = eventoContrato.EsSeleccionado();
        saldo = eventoSeleccionado.getCosto();
        return eventoSeleccionado;
    }

    public void setEventoSeleccionado(Evento eventoSeleccionado) {
        this.eventoSeleccionado = eventoSeleccionado;
    }

    public List<Participante> getListaCompletaParticipantes() {
        ParticipanteContrato participanteContrato = new Participante();
        listaCompletaParticipantes = participanteContrato.ListarParticipantes();
        return listaCompletaParticipantes;
    }

    public void setListaCompletaParticipantes(List<Participante> listaCompletaParticipantes) {
        this.listaCompletaParticipantes = listaCompletaParticipantes;
    }

    public List<Participante> getListaFiltradaCompletaParticipantes() {
        return listaFiltradaCompletaParticipantes;
    }

    public void setListaFiltradaCompletaParticipantes(List<Participante> listaFiltradaCompletaParticipantes) {
        this.listaFiltradaCompletaParticipantes = listaFiltradaCompletaParticipantes;
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
        EventoParticipante _eventoParticipante = new EventoParticipante();

        evento = eventoContrato.EsSeleccionado();
        if (evento != null) {
            _eventoParticipante = eventoParticipanteContrato.BuscarParticipanteEvento(participante.getIdParticipante(), evento.getIdEvento());
            if (_eventoParticipante == null) {
                eventoParticipante.setIdParticipante(participante.getIdParticipante());
                eventoParticipante.setIdEvento(evento.getIdEvento());
                idEventoParticipante = eventoParticipanteContrato.GuardarEventoParticipante(eventoParticipante);
                pago.setIdEventoParticipante(idEventoParticipante);
                pago.setFecha(eventoParticipante.getFechaRegistro());
                pago.setMontoPagado(montoPagado);
                pago.setSaldo(saldo);
                pagoContrato.Guardar(pago);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Participante registrado en el evento correctamente"));
                nuevoRegistroParticipanteEvento();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El participante ingresado ya se encuentra registrado en el evento"));
                nuevoRegistroParticipanteEvento();
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe seleccionar un congreso"));
        }
    }

    public void nuevoRegistroParticipanteEvento() {
        participante = new Participante();
        eventoParticipante = new EventoParticipante();
        pago = new Pago();
        montoPagado = new BigDecimal(0);
        saldo = new BigDecimal(0);
    }

    public void calcularSaldo() {
        if (montoPagado != null) {
            if (montoPagado.compareTo(BigDecimal.ZERO) == 0) {
                saldo = eventoSeleccionado.getCosto();
            } else {
                saldo = eventoSeleccionado.getCosto().subtract(montoPagado);
            }
        }
        else
        {
            saldo = eventoSeleccionado.getCosto();
        }    
        
    }

    public void modificarParticipante() {
        ParticipanteContrato participanteContrato = new Participante();
       participanteContrato.ModificarParticipante(participante);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Persona modificada correctamente"));
    }
    
    public void desactivarParticipante(){
        ParticipanteContrato participanteContrato = new Participante();
        participanteContrato.DesactivarParticipante(participante);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Persona eliminada correctamente"));    
        listaParticipantes = new ArrayList<>();
        listaFiltradaParticipantes = new ArrayList<>();
    }
}
