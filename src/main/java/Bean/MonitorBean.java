package Bean;

import Modelo.Monitor;
import java.io.Serializable;
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
    
    
}
