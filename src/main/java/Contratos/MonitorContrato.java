package Contratos;

import Modelo.Monitor;
import java.util.List;

public interface MonitorContrato {
    public void GuardarMonitor(Monitor monitor);
    public List<Monitor> ListarMonitor();
}
