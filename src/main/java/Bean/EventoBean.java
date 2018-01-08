package Bean;

import Contratos.EventoContrato;
import Modelo.Evento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "eventoBean")
@ViewScoped
public class EventoBean implements Serializable{

    private Evento evento;
    private List<SelectItem> lstEventos;
    List<Evento> listaEventos;
    
    public EventoBean() {
        evento = new Evento();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getListaEventos() {
        EventoContrato eventoContrato = new Evento();
        listaEventos = eventoContrato.ListarEventos();
        return listaEventos;
    }

    public void setListaEventos(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }
    
    public List<SelectItem> getLstEventos() throws Exception {
        this.lstEventos = new ArrayList<SelectItem>();
        listar();
        lstEventos.clear();
        for (Evento eventos :listaEventos) 
        {
            SelectItem eventoItem = new SelectItem(eventos.getIdEvento(),eventos.getNombreEvento());
            this.lstEventos.add(eventoItem);
        }
        return lstEventos;
    }
    
    //METODOS
    public void listar() throws Exception
    {
        EventoContrato eventoContrato;
        try
        {
            eventoContrato = new Evento();
            listaEventos = eventoContrato.ListarEventos();
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
    public void guardarEvento()
    {
        EventoContrato eventoContrato = new Evento();
        eventoContrato.GuardarEvento(evento);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Evento registrado correctamente"));
        limpiarEvento();
    }
    
    public void limpiarEvento()
    {
        evento = new Evento();
    }
    
    public void seleccionarEvento()
    {
        EventoContrato eventoContrato = new Evento();
        eventoContrato.Seleccionar(evento);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Evento seleccionado"));
    }
}
