package Modelo;

import Conexion.Conexion;
import Conexion.Parametros;
import Contratos.MonitorContrato;
import java.util.ArrayList;
import java.util.List;

public class Monitor  implements MonitorContrato{

    private int idMonitor;
    private String ci;
    private String nombreMonitor;
    private String direccion;
    private String institucion;
    private String telefono;
    
    private final Conexion con = new Conexion();
    private List<Parametros> parametros;

    public Monitor() {
    }

    public Monitor(int idMonitor, String ci, String nombreMonitor, String direccion, String institucion, String telefono, List<Parametros> parametros) {
        this.idMonitor = idMonitor;
        this.ci = ci;
        this.nombreMonitor = nombreMonitor;
        this.direccion = direccion;
        this.institucion = institucion;
        this.telefono = telefono;
        this.parametros = parametros;
    }

    public int getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(int idMonitor) {
        this.idMonitor = idMonitor;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombreMonitor() {
        return nombreMonitor;
    }

    public void setNombreMonitor(String nombreMonitor) {
        this.nombreMonitor = nombreMonitor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
       
    @Override
    public void GuardarMonitor(Monitor monitor) {
        parametros = new ArrayList<>();
        parametros.add(new Parametros("_Ci",monitor.ci));
        parametros.add(new Parametros("_NombreMonitor",monitor.nombreMonitor));
        parametros.add(new Parametros("_Direccion",monitor.direccion));
        parametros.add(new Parametros("_Institucion",monitor.institucion));
        parametros.add(new Parametros("_Telefono",monitor.telefono));
        con.Ejecutar("PaInsertarMonitor", parametros);
    }
    
}
