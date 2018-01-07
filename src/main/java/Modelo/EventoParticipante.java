package Modelo;

import Contratos.EventoParticipanteContrato;
import java.util.Date;

public class EventoParticipante implements EventoParticipanteContrato{

    private int idEventoParticipante;
    private int idEvento;
    private int idParticipante;
    private Date fechaRegistro;

    public EventoParticipante() {
    }

    public EventoParticipante(int idEventoParticipante, int idEvento, int idParticipante, Date fechaRegistro) {
        this.idEventoParticipante = idEventoParticipante;
        this.idEvento = idEvento;
        this.idParticipante = idParticipante;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdEventoParticipante() {
        return idEventoParticipante;
    }

    public void setIdEventoParticipante(int idEventoParticipante) {
        this.idEventoParticipante = idEventoParticipante;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    
    @Override
    public void GuardarEvento(EventoParticipante eventoParticipante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
