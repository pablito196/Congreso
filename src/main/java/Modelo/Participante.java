package Modelo;

import Conexion.Conexion;
import Conexion.Parametros;
import Contratos.ParticipanteContrato;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Participante implements ParticipanteContrato{

    private int idParticipante;
    private String ci;
    private String nombreParticipante;
    private String ciudad;
    private String correoElectronico;
    private String direccion;
    private String institucion;
    private String telefono;
    
    
    
    private final Conexion con = new Conexion();
    private List<Parametros> parametros;

    public Participante() {
    }

    public Participante(int idParticipante, String ci, String nombreParticipante, String ciudad, String correoElectronico, String direccion, 
            String institucion, String telefono) {
        this.idParticipante = idParticipante;
        this.ci = ci;
        this.nombreParticipante = nombreParticipante;
        this.ciudad = ciudad;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.institucion = institucion;
        this.telefono = telefono;
        
        
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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
    public int GuardarParticipante(Participante participante) {
        int id = 0;
       // System.out.println("entra a guardar modelo hoja ruta");
        parametros = new ArrayList<>();
        parametros.add(new Parametros("_Ci",participante.ci));
        parametros.add(new Parametros("_NombreParticipante",participante.nombreParticipante));
        parametros.add(new Parametros("_Ciudad",participante.ciudad));
        parametros.add(new Parametros("_CorreoElectronico",participante.correoElectronico));
        parametros.add(new Parametros("_Direccion",participante.direccion));
        parametros.add(new Parametros("_Institucion",participante.institucion));
        parametros.add(new Parametros("_Telefono",participante.telefono));
        
        //Object objectHojaRuta = con.PedirEscalar("PaInsertarHojaRuta", parametros, "IdHojaRuta");
        Object objectHojaRuta = con.PedirEscalar("PaInsertarParticipante", parametros);
        /*ResultSet hojasRuta = con.Listar("PaInsertarHojaRuta",parametros);
        try {
            while(hojasRuta.next())
            {
                id = Integer.parseInt(hojasRuta.getObject(1).toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(HojaRuta.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        //Object objectHojaRuta = con.PedirEscalar("PaInsertarHojaRuta", parametros);
        id = Integer.parseInt(objectHojaRuta.toString());
       // System.out.println("idHojaRutaNueva: "+id);
        return id;
        //con.Ejecutar("PaInsertarHojaRuta", parametros);
    }

    @Override
    public List<Participante> ListarParticipantes() {
        
        ResultSet listadoParticipantes = con.Listar("PaListarParticipantes");

        ArrayList<Participante> listaParticipantes = new ArrayList<Participante>();
        try {
            while (listadoParticipantes.next()) {

                listaParticipantes.add(new Participante(listadoParticipantes.getInt("IdParticipante"), listadoParticipantes.getString("CI"), listadoParticipantes.getString("NombreParticipante"), 
                                                        listadoParticipantes.getString("Ciudad"), listadoParticipantes.getString("CorreoElectronico"), listadoParticipantes.getString("Direccion"), 
                                                        listadoParticipantes.getString("Institucion"), listadoParticipantes.getString("Telefono")));
                
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return listaParticipantes;
    }

    @Override
    public Participante BuscarParticipante(String ciParticipante) {
        Participante _participante = null;
        parametros = new ArrayList<>();
        parametros.add(new Parametros("_Ci",ciParticipante));
        ResultSet datosParticipante = con.Listar("PaBuscarParticipante", parametros); 
        try
        {
            while(datosParticipante.next())
            {
                _participante = new Participante(datosParticipante.getInt("IdParticipante"), datosParticipante.getString("CI"), datosParticipante.getString("NombreParticipante"), 
                                                datosParticipante.getString("Ciudad"), datosParticipante.getString("CorreoElectronico"), datosParticipante.getString("Direccion"), 
                                                datosParticipante.getString("Institucion"), telefono);
                
            }
            
        }
        catch(Exception e)
        {
            System.err.println(e);
        }        
        return _participante;
    }

    @Override
    public Participante Buscar(String ci) {
        Participante _participante = null;
        parametros = new ArrayList<>();
        parametros.add(new Parametros("_Ci",ci));
        ResultSet datosParticipante = con.Listar("PaBuscarParticipante", parametros); 
        try
        {
            while(datosParticipante.next())
            {
                _participante = new Participante(datosParticipante.getInt("IdParticipante"), datosParticipante.getString("CI"), datosParticipante.getString("NombreParticipante"), 
                                                datosParticipante.getString("Ciudad"), datosParticipante.getString("CorreoElectronico"), datosParticipante.getString("Direccion"), 
                                                datosParticipante.getString("Institucion"), telefono);
                
            }
            
        }
        catch(Exception e)
        {
            System.err.println(e);
        }        
        return _participante;
    }
    
}
