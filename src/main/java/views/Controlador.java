package views;

import data.Persistencia;
import domain.Marca;
import domain.Sucursal;
import domain.Vehiculo;
import domain.VehiculoCombustible;
import domain.VehiculoElectrico;
import domain.VehiculoTipo;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class Controlador {
    
    public static ArrayList<VehiculoViewModel> getVehiculos(){
        ArrayList<VehiculoViewModel> vehiculos = new ArrayList<>();
        for(Vehiculo vehiculo : Persistencia.getVehiculos()) {
            vehiculos.add(new VehiculoViewModel(vehiculo));
        }
        return vehiculos;
    }
    
    public static void crearVehiculo(String tipo,String patente, Marca marcaSeleccionada, String modelo,int año,double carga, Sucursal sucursalSeleccionada, double kwhBase, double kmPorLitro, double litroExtra){
        Vehiculo v = null;
        if(tipo.equals("ELECTRICO")){
            v = new VehiculoElectrico(patente,marcaSeleccionada,modelo,año,carga,sucursalSeleccionada,kwhBase); 
        }
        else{
            v = new VehiculoCombustible(patente,marcaSeleccionada,modelo,año,carga,sucursalSeleccionada,kmPorLitro,litroExtra); 
        }
        Persistencia.agregarVehiculo(v);
    }
    
    public static double[] calcularConsumos(Map<String, Double> vehiculos){
        double consumoElectricos = 0;
        double consumoCombustible= 0;
        for(Map.Entry<String, Double> entry : vehiculos.entrySet()){
           double consumo = 0;
           Optional<Vehiculo> vehiculo = Persistencia.getVehiculo(entry.getKey());
           if(vehiculo.isPresent()){
               consumo = vehiculo.get().calcularConsumo(entry.getValue());
               consumoElectricos += vehiculo.get().esDe(VehiculoTipo.ELECTRICO) ? consumo : 0;
               consumoCombustible += vehiculo.get().esDe(VehiculoTipo.COMBUSTIBLE) ? consumo : 0;
           }
        }
        return new double[] {consumoElectricos, consumoCombustible};
    }
}
