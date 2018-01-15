package Contratos;

import Modelo.Pago;
import java.util.List;

public interface PagoContrato {
    public void GuardarPago(Pago pago);
    public void Guardar(Pago pago);
    public List<Pago> Listar(int idParticipantePago);
}
