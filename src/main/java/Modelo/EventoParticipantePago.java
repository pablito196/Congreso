package Modelo;

import Conexion.Conexion;
import Conexion.Parametros;
import Contratos.EventoParticipantePagoContrato;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventoParticipantePago implements EventoParticipantePagoContrato{

    private int idEventoParticipante;
    private String ci;
    private String nombreParticipante;
    private String ciudad;
    private String telefono;
    private String institucion;
    private String numeroHabitacion;
    private Date fechaRegistro;
    private String nombreMonitor;
    private BigDecimal montoPagado;
    private BigDecimal saldo;
    
    private final Conexion con = new Conexion();
    private List<Parametros> parametros;

    public EventoParticipantePago() {
    }

    public EventoParticipantePago(int idEventoParticipante, String ci, String nombreParticipante, String ciudad, String telefono, String numeroHabitacion, Date fechaRegistro, String nombreMonitor, BigDecimal montoPagado, BigDecimal saldo, String institucion) {
        this.idEventoParticipante = idEventoParticipante;
        this.ci = ci;
        this.nombreParticipante = nombreParticipante;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.numeroHabitacion = numeroHabitacion;
        this.fechaRegistro = fechaRegistro;
        this.nombreMonitor = nombreMonitor;
        this.montoPagado = montoPagado;
        this.saldo = saldo;
        this.institucion = institucion;
    }

    public int getIdEventoParticipante() {
        return idEventoParticipante;
    }

    public void setIdEventoParticipante(int idEventoParticipante) {
        this.idEventoParticipante = idEventoParticipante;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreMonitor() {
        return nombreMonitor;
    }

    public void setNombreMonitor(String nombreMonitor) {
        this.nombreMonitor = nombreMonitor;
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
    
    
    
    @Override
    public List<EventoParticipantePago> ListarParticipantesEvento() {
        ResultSet listadoEventoParticipantes = con.Listar("PaParticipantesListarEvento"); 
        ArrayList<EventoParticipantePago> listaEventoParticipantes = new ArrayList<EventoParticipantePago>();
        try
        {
            while(listadoEventoParticipantes.next())
            {
                listaEventoParticipantes.add(new EventoParticipantePago(listadoEventoParticipantes.getInt("IdEventoParticipante"), listadoEventoParticipantes.getString("CI"), 
                                                        listadoEventoParticipantes.getString("NombreParticipante"), listadoEventoParticipantes.getString("Ciudad"), listadoEventoParticipantes.getString("Telefono"), 
                                                        listadoEventoParticipantes.getString("NumeroHabitacion"), listadoEventoParticipantes.getDate("FechaRegistro"), listadoEventoParticipantes.getString("NombreMonitor"),
                                                        listadoEventoParticipantes.getBigDecimal("MontoPagado"), listadoEventoParticipantes.getBigDecimal("Saldo"),
                                                        listadoEventoParticipantes.getString("Institucion")));
            }
            
        }
        catch(Exception e)
        {
            System.err.println(e);
        }        
        return listaEventoParticipantes;
    }

    @Override
    public List<EventoParticipantePago> ListarParticipantesPagoPendiente() {
        ResultSet listadoEventoParticipantes = con.Listar("PaListarParticipantesPagoPendiente"); 
        ArrayList<EventoParticipantePago> listaEventoParticipantes = new ArrayList<EventoParticipantePago>();
        try
        {
            while(listadoEventoParticipantes.next())
            {
                listaEventoParticipantes.add(new EventoParticipantePago(listadoEventoParticipantes.getInt("IdEventoParticipante"), listadoEventoParticipantes.getString("CI"), 
                                                        listadoEventoParticipantes.getString("NombreParticipante"), listadoEventoParticipantes.getString("Ciudad"), listadoEventoParticipantes.getString("Telefono"), 
                                                        listadoEventoParticipantes.getString("NumeroHabitacion"), listadoEventoParticipantes.getDate("FechaRegistro"), listadoEventoParticipantes.getString("NombreMonitor"),
                                                        listadoEventoParticipantes.getBigDecimal("MontoPagado"), listadoEventoParticipantes.getBigDecimal("Saldo"),
                                                        listadoEventoParticipantes.getString("Institucion")));
            }
            
        }
        catch(Exception e)
        {
            System.err.println(e);
        }        
        return listaEventoParticipantes;
    }
    
}
