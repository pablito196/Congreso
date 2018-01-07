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
    private Date fecha;
    private BigDecimal costo;
    private String descripcion;
    
    private final Conexion con = new Conexion();
    private List<Parametros> parametros;

    public Evento() {
    }

    public Evento(int idEvento, String lugar, Date fecha, BigDecimal costo, String descripcion) {
        this.idEvento = idEvento;
        this.lugar = lugar;
        this.fecha = fecha;
        this.costo = costo;
        this.descripcion = descripcion;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
    
    
    
    @Override
    public void GuardarEvento(Evento evento) {
        parametros = new ArrayList<>();
        parametros.add(new Parametros("_NombreEvento",evento.nombreEvento));
        parametros.add(new Parametros("_Lugar",evento.lugar));
        parametros.add(new Parametros("_Fecha",evento.fecha));
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
                listaEventos.add(new Evento(listadoEventos.getInt("IdEvento"), listadoEventos.getString("Lugar"), listadoEventos.getDate("Fecha"), listadoEventos.getBigDecimal("Costo"), listadoEventos.getString("Descripcion")));
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
    
}
