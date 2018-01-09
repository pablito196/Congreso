package Modelo;

import Contratos.PagoContrato;
import java.math.BigDecimal;
import java.util.Date;

public class Pago implements PagoContrato{

    private int idPago;
    private int idEventoParticipante;
    private Date fecha;
    private BigDecimal montoPagado;
    private BigDecimal saldo;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
