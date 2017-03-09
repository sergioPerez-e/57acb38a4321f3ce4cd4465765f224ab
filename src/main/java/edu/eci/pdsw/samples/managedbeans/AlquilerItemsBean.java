/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "AlquilerItems")
@SessionScoped
public class AlquilerItemsBean implements Serializable {

    ServiciosAlquiler sp;
    private Map<Integer,ItemRentado> ItemsRentados;
    private ArrayList<String[]> listaPendientes;
    
    @ManagedProperty(value = "#{ClientesBen}")
    private ClientesBean cb;

    public AlquilerItemsBean() {
        sp = ServiciosAlquiler.getInstance();
        ItemsRentados= new HashMap<>();
    }

    public ArrayList<String[]> getListaPendientes() {
        ItemRentado itemTMP=null;
        LocalDate fechaInicial=null;
        LocalDate fechaEntrega=null;
        long diasRestantes=0;
        listaPendientes=new ArrayList<String[]>();
        for(int i=0;i<listaPendientes.size();i++){
            /*
        this.fechainiciorenta = fechainiciorenta;
        this.fechafinrenta = fechafinrenta;
            */
            itemTMP=ItemsRentados.get(i);
            
            fechaInicial=itemTMP.getFechainiciorenta().toLocalDate();
            fechaEntrega=itemTMP.getFechafinrenta().toLocalDate();
            diasRestantes=ChronoUnit.DAYS.between(fechaInicial, fechaEntrega);
            
            String[] tmp={itemTMP.getItem().getNombre(),Integer.toString((int) diasRestantes)};
            listaPendientes.add(tmp);
        }
        return listaPendientes;
    }

    public ClientesBean getCb() {
        return cb;
    }

    public void setCb(ClientesBean cb) {
        this.cb = cb;
    }
}
