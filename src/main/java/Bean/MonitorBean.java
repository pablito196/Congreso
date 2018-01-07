package Bean;

import Contratos.MonitorContrato;
import Modelo.Monitor;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "monitorBean")
@ViewScoped
public class MonitorBean implements  Serializable{

    private Monitor monitor;
    
    public MonitorBean() {
        monitor = new Monitor();
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
    
    //METODOS
    public void guardarMonitor()
    {
        MonitorContrato monitorContrato = new Monitor();
        monitorContrato.GuardarMonitor(monitor);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Monitor registrado correctamente"));
        limpiarMonitor();
    }
    
    public void limpiarMonitor()
    {
        monitor = new Monitor();
    }
}
