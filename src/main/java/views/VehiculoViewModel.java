package views;

import domain.*;

public class VehiculoViewModel {
    private String patente;
    private String vehiculo;
    private String nombre;
    private String pais;
    private String tipo;
    private String sucursal;
    private double capacidadCarga;
    private double kmPorLitro;
    private int anio;
    private double litrosExtra;
    private double kmARecorrer;
    
    public VehiculoViewModel(Vehiculo vehiculo){
        if(vehiculo == null)return;
        patente = vehiculo.getPatente();
        nombre = vehiculo.getMarcaNombre();
        pais = vehiculo.getMarcaPais();
        tipo = vehiculo.getTipo().name();
        sucursal = vehiculo.getCodigoSucursal();
        capacidadCarga = vehiculo.getCapacidadCarga();
        anio = vehiculo.getAnio();
        kmPorLitro = vehiculo instanceof VehiculoCombustible ? ((VehiculoCombustible)vehiculo).getKilometrosPorLitro() : 0;
        litrosExtra = vehiculo instanceof VehiculoCombustible ? ((VehiculoCombustible)vehiculo).getLitrosExtra() : 0;
        kmARecorrer = 100;
    }

    public String getPatente() {
        return patente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }
    
    public String getVehiculo() {
        return vehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public double getKmPorLitro() {
        return kmPorLitro;
    }

    public int getAnio() {
        return anio;
    }

    public double getLitrosExtra() {
        return litrosExtra;
    }

    public double getKmARecorrer() {
        return kmARecorrer;
    }

    public String getSucursal() {
        return sucursal;
    }
}
