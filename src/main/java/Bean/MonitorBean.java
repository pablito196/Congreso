package Bean;

import Contratos.MonitorContrato;
import Modelo.Monitor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@ManagedBean
@Named(value = "monitorBean")
@ViewScoped
public class MonitorBean implements  Serializable{

    private Monitor monitor;
    List<Monitor> listaMonitores;
    private List<SelectItem> lstMonitores;
    
    public MonitorBean() {
        monitor = new Monitor();
        listaMonitores = new ArrayList<>();
        //lstMonitores = new ArrayList<SelectItem>();
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public List<Monitor> getListaMonitores() {
        return listaMonitores;
    }

    public void setListaMonitores(List<Monitor> listaMonitores) {
        this.listaMonitores = listaMonitores;
    }

    public List<SelectItem> getLstMonitores() throws Exception {
        this.lstMonitores = new ArrayList<SelectItem>();
        listar();
        lstMonitores.clear();
        for (Monitor monitores :listaMonitores) 
        {
            SelectItem monitorItem = new SelectItem(monitores.getIdMonitor(),monitores.getNombreMonitor());
            this.lstMonitores.add(monitorItem);
        }
        return lstMonitores;
    }
    
    //METODOS
    public void listar() throws Exception
    {
        MonitorContrato monitorContrato;
        try
        {
            monitorContrato = new Monitor();
            listaMonitores = monitorContrato.ListarMonitor();
        }
        catch(Exception e)
        {
            throw e;
        }
    }
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
