package Contratos;

import Modelo.Evento;
import java.util.List;

public interface EventoContrato {
    public void GuardarEvento(Evento evento);
    public List<Evento> ListarEventos();
    public void ModificarEvento(Evento evento);
    public Evento EsSeleccionado();
    public void SeleccionarEvento(Evento evento);
}
