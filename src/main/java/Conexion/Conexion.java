package Conexion;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    static Connection conexion = null; 
    public static Connection getConexion() {
        String url = "jdbc:mysql://localhost/congreso"; 
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("no se puede establecer la conexion, error: "+e.getMessage());
        }
        try
        {
            conexion =  DriverManager.getConnection(url,"root","1c0n37");
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+ e.getMessage());
        }
        
        return conexion;
    }
   /* public String login = "root";
    public String pass = "1c0n37";
    
    //con = DriverManager.getConnection("jdbc:mysql://localhost/TuBaseDeDatos?"+ "user=TuUsuario&password=TuPass");
    public String url = "jdbc:mysql://localhost/origenes";
    Connection cnn = null;

   public Conexion() { }
    
    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection(url,login,pass);
        //(url, login, pass);
            if (cnn != null) {
                System.out.println("Conexion ok");
                //JOptionPane.showMessageDialog(null, "Conexion ok");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }

    }

    public void cerrar() {
        if (cnn != null) {
            try {
                cnn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/
    
    public void cerrar()
    {
        try
        {
            conexion.close();
        } catch(SQLException e){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ResultSet Listar(String nomPA, Parametros[] parametros) {
        //this.conectar();
        Connection cnn = getConexion();
        String invocar = "{call " + nomPA + "(?";
        int in = 1;
        while (in < parametros.length) {
            invocar = invocar + ",?";
            in++;
        }
        invocar = invocar + ")}";
        try {
            CallableStatement cl = cnn.prepareCall(invocar);
            for (Parametros parametro : parametros) {
                cl.setObject(parametro.getNombre(), parametro.getValor());
            }
            cl.execute();
            return cl.getResultSet();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //List<String> lista = new ArrayList<String>();
        this.cerrar();
        return null;
    }
    
    public ResultSet Listar(String nomPA, List<Parametros> parametros) {
       // this.conectar();
        Connection cnn = getConexion();
        String invocar = "{call " + nomPA + "(?";
        int in = 1;
        while (in < parametros.size()) {
            invocar = invocar + ",?";
            in++;
        }
        invocar = invocar + ")}";
        try {
            CallableStatement cl = cnn.prepareCall(invocar);
            for (Parametros parametro : parametros) {
                cl.setObject(parametro.getNombre(), parametro.getValor());
            }
            cl.execute();
            return cl.getResultSet();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //List<String> lista = new ArrayList<String>();
        this.cerrar();
        return null;
    }
    
    public ResultSet Listar(String nomPA) {
        //this.conectar();
        Connection cnn = getConexion();
        String invocar = "{call " + nomPA + "}";

        try {
            CallableStatement cl = cnn.prepareCall(invocar);
            cl.execute();
            return cl.getResultSet();

            //cl.setObject(pass, cl);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //List<String> lista = new ArrayList<String>();
        this.cerrar();
        return null;
    }
    
    public Object PedirEscalar(String nomPA, List<Parametros> parametros){
        //this.conectar();
        Connection cnn = getConexion();
        String invocar = "{call " + nomPA + "(?";
        int in = 1;
        while (in < parametros.size())
        {
            invocar = invocar + ",?";
            in++;
        }
        invocar = invocar + ")}";
        try {
            CallableStatement cl = cnn.prepareCall(invocar);
            for (Parametros parametro : parametros) {
                cl.setObject(parametro.getNombre(), parametro.getValor());
            }
            cl.execute();
            ResultSet rs = cl.getResultSet();
            Object escalar = 0;
             while (rs.next()) {
                 escalar = rs.getObject(1);
             }
            return escalar;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //List<String> lista = new ArrayList<String>();
        this.cerrar();
        return null;              
    }

    public Object PedirEscalar(String nomPA) {
        //this.conectar();
        Connection cnn = getConexion();
        String invocar = "{call " + nomPA + "}";
        
        try {
            CallableStatement cl = cnn.prepareCall(invocar);            
            cl.execute();
            
            ResultSet rs = cl.getResultSet();
            Object escalar = 0;
             while (rs.next()) {
                 escalar = rs.getObject(1);
             }
            return escalar;
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //List<String> lista = new ArrayList<String>();
        this.cerrar();
        return null; 
    }

    public void Ejecutar(String nomPA){
        //this.conectar();
        Connection cnn = getConexion();
        String invocar = "{call " + nomPA + "}";
        
        try {
            CallableStatement cl = cnn.prepareCall(invocar);            
            cl.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //List<String> lista = new ArrayList<String>();
        this.cerrar();
    }
    
    public void Ejecutar(String nomPA, List<Parametros> parametros){
        //this.conectar();
        Connection cnn = getConexion();
        String invocar = "{call " + nomPA + "(?";
        int in = 1;
        while (in < parametros.size())
        {
            invocar = invocar + ",?";
            in++;
        }
        invocar = invocar + ")}";
        try {
            CallableStatement cl = cnn.prepareCall(invocar);
            for (Parametros parametro : parametros) {
                cl.setObject(parametro.getNombre(), parametro.getValor());
            }
            cl.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //List<String> lista = new ArrayList<String>();
        this.cerrar();
    }
    
    
    
    

}
