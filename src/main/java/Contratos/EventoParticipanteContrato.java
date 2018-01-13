package Contratos;

import Modelo.EventoParticipante;

public interface EventoParticipanteContrato {
    public int GuardarEventoParticipante(EventoParticipante eventoParticipante);
    public EventoParticipante BuscarParticipanteEvento(int idParticipante, int idEvento);
}
