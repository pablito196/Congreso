package Contratos;

import Modelo.Evento;
import java.util.List;

public interface EventoContrato {
    public void GuardarEvento(Evento evento);
    public List<Evento> ListarEventos();
    public void Seleccionar(Evento evento);
    public void ModificarEvento(Evento evento);
    public Evento EsSeleccionado();
}
