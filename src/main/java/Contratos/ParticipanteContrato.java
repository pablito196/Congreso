package Contratos;

import Modelo.Participante;
import java.util.List;

public interface ParticipanteContrato {
    public int GuardarParticipante(Participante participante);
    public List<Participante> ListarParticipantes();
    public Participante BuscarParticipante(Participante participante);
}
