package Modelo;

import Conexion.Conexion;
import Conexion.Parametros;
import Contratos.EventoParticipanteContrato;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventoParticipante implements EventoParticipanteContrato{

    private int idEventoParticipante;
    private int idEvento;
    private int idParticipante;
    private int idMonitor;
    private Date fechaRegistro;
    private String numeroHabitacion;
    private String observaciones;
    
    private final Conexion con = new Conexion();
    private List<Parametros> parametros;

    public EventoParticipante() {
    }

    public EventoParticipante(int idEventoParticipante, int idEvento, int idParticipante, int idMonitor, Date fechaRegistro, String numeroHabitacion, String observaciones) {
        this.idEventoParticipante = idEventoParticipante;
        this.idEvento = idEvento;
        this.idParticipante = idParticipante;
        this.idMonitor = idMonitor;
        this.fechaRegistro = fechaRegistro;
        this.numeroHabitacion = numeroHabitacion;
        this.observaciones = observaciones;
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

    public int getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(int idMonitor) {
        this.idMonitor = idMonitor;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
    @Override
    public int GuardarEvento(EventoParticipante eventoParticipante) {
        
        int id = 0;
       // System.out.println("entra a guardar modelo hoja ruta");
        parametros = new ArrayList<>();
        parametros.add(new Parametros("_IdEvento",eventoParticipante.idEvento));
        parametros.add(new Parametros("_IdParticipante",eventoParticipante.idParticipante));
        parametros.add(new Parametros("_IdMonitor",eventoParticipante.idMonitor));
        parametros.add(new Parametros("_FechaRegistro",eventoParticipante.fechaRegistro));
        parametros.add(new Parametros("_NumeroHabitacion",eventoParticipante.numeroHabitacion));
        parametros.add(new Parametros("_Observaciones",eventoParticipante.observaciones));
                
        Object objectEventoParticipante = con.PedirEscalar("PaInsertarEventoParticipante", parametros);
        
        id = Integer.parseInt(objectEventoParticipante.toString());
       
        return id;
        
    }

    @Override
    public int GuardarEventoParticipante(EventoParticipante eventoParticipante) {
        int id = 0;
       // System.out.println("entra a guardar modelo hoja ruta");
        parametros = new ArrayList<>();
        parametros.add(new Parametros("_IdEvento",eventoParticipante.idEvento));
        parametros.add(new Parametros("_IdParticipante",eventoParticipante.idParticipante));
        parametros.add(new Parametros("_IdMonitor",eventoParticipante.idMonitor));
        parametros.add(new Parametros("_FechaRegistro",eventoParticipante.fechaRegistro));
        parametros.add(new Parametros("_NumeroHabitacion",eventoParticipante.numeroHabitacion));
        parametros.add(new Parametros("_Observaciones",eventoParticipante.observaciones));
                
        Object objectEventoParticipante = con.PedirEscalar("PaInsertarEventoParticipante", parametros);
        
        id = Integer.parseInt(objectEventoParticipante.toString());
       
        return id;
    }
    
}
