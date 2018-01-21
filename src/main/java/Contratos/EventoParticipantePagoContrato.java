
package Contratos;

import Modelo.EventoParticipantePago;
import java.util.List;

public interface EventoParticipantePagoContrato {
    public List<EventoParticipantePago> ListarParticipantesEvento();
    public List<EventoParticipantePago> ListarParticipantesPagoPendiente();
    public List<EventoParticipantePago> ListarParticipantesCompletoPago();
}
