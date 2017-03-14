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

    ServiciosAlquiler sp = ServiciosAlquiler.getInstance();
    private Map<Integer,Map<Integer,ItemRentado>> CliItemsRentados;//idCliente -> idPeli -> ItemRentado
    private ArrayList<String[]> listaPendientes;
    private int id_pelicula;
    
    @ManagedProperty(value = "#{ClientesBen}")
    private ClientesBean cb;

    public AlquilerItemsBean() {
        id_pelicula=-1;
        CliItemsRentados= new HashMap<>();
    }

    public void guardarAlquiler(){
        
    }
    
    public ArrayList<String[]> getListaPendientes() {
        ItemRentado itemTMP=null;
        LocalDate fechaInicial=null;
        LocalDate fechaEntrega=null;
        long diasRestantes=0;
        Map<Integer,ItemRentado> ItemsRentados= new HashMap<>();
        listaPendientes=new ArrayList<String[]>();
        for(int i=0;i<ItemsRentados.size();i++){
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

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }
    
}
