package Modelo;

import Conexion.Conexion;
import Conexion.Parametros;
import Contratos.EventoContrato;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento implements EventoContrato{

    private int idEvento;
    private String nombreEvento;
    private String lugar;
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal costo;
    private String descripcion;
    private boolean seleccionado;
    
    private final Conexion con = new Conexion();
    private List<Parametros> parametros;

    public Evento() {
    }

    public Evento(int idEvento, String nombreEvento, String lugar, Date fechaInicio , Date fechaFin, BigDecimal costo, String descripcion, boolean seleccionado) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.descripcion = descripcion;
        this.seleccionado = seleccionado;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    @Override
    public void GuardarEvento(Evento evento) {
        parametros = new ArrayList<>();
        parametros.add(new Parametros("_NombreEvento",evento.nombreEvento));
        parametros.add(new Parametros("_Lugar",evento.lugar));
        parametros.add(new Parametros("_FechaInicio",evento.fechaInicio));
        parametros.add(new Parametros("_FechaFin",evento.fechaFin));
        parametros.add(new Parametros("_Costo",evento.costo));
        parametros.add(new Parametros("_Descripcion",evento.descripcion));
        con.Ejecutar("PaInsertarEvento", parametros);
    }

    @Override
    public List<Evento> ListarEventos() {
        
        ResultSet listadoEventos = con.Listar("PaListarEventos"); 
        ArrayList<Evento> listaEventos = new ArrayList<Evento>();
        try
        {
            while(listadoEventos.next())
            {
                listaEventos.add(new Evento(listadoEventos.getInt("IdEvento"), listadoEventos.getString("NombreEvento"), listadoEventos.getString("Lugar"), 
                                            listadoEventos.getDate("FechaInicio") , listadoEventos.getDate("FechaFin"), listadoEventos.getBigDecimal("Costo"), 
                                            listadoEventos.getString("Descripcion"), listadoEventos.getBoolean("Seleccionado")));
            }
            
        }
        catch(Exception e)
        {
            System.err.println(e);
        }        
        return listaEventos;
    }

    @Override
    public Evento BuscarEvento(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Seleccionar(Evento evento) {
        parametros = new ArrayList<>();
        parametros.add(new Parametros("_IdEvento",evento.idEvento));
        con.Ejecutar("PaInsertarEvento", parametros);
    }
    
}
