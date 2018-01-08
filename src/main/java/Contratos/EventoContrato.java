package Contratos;

import Modelo.Evento;
import java.util.List;

public interface EventoContrato {
    public void GuardarEvento(Evento evento);
    public List<Evento> ListarEventos();
    public Evento BuscarEvento(Evento evento);
    public void Seleccionar(Evento evento);
}
