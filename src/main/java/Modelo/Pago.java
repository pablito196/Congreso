package Modelo;

import Conexion.Conexion;
import Conexion.Parametros;
import Contratos.PagoContrato;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pago implements PagoContrato{

    private int idPago;
    private int idEventoParticipante;
    private Date fecha;
    private BigDecimal montoPagado;
    private BigDecimal saldo;

    private final Conexion con = new Conexion();
    private List<Parametros> parametros;
    
    public Pago() {
    }

    public Pago(int idPago, int idEventoParticipante, Date fecha, BigDecimal montoPagado, BigDecimal saldo) {
        this.idPago = idPago;
        this.idEventoParticipante = idEventoParticipante;
        this.fecha = fecha;
        this.montoPagado = montoPagado;
        this.saldo = saldo;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdEventoParticipante() {
        return idEventoParticipante;
    }

    public void setIdEventoParticipante(int idEventoParticipante) {
        this.idEventoParticipante = idEventoParticipante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
    public void GuardarPago(Pago pago) {
        parametros = new ArrayList<>();
        parametros.add(new Parametros("_IdEventoParticipante",pago.idEventoParticipante));
        parametros.add(new Parametros("_Fecha",pago.fecha));
        parametros.add(new Parametros("_MontoPagado",pago.montoPagado));
        parametros.add(new Parametros("_Saldo",pago.saldo));
        con.Ejecutar("PaInsertarPago", parametros);
    }
    
}
