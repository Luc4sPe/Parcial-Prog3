package modelo;

import excepciones.VehiculoIncompletoException;

public class Vehiculo {
    private int idVehiculo;
    private String marcaModelo;
    private String patente;
    private int anio;

    public Vehiculo(int idVehiculo,String marcaModelo,String patente,int anio){
        this.idVehiculo=idVehiculo;
        this.marcaModelo=marcaModelo;
        this.patente=patente;
        this.anio=anio;
    }
    public static Vehiculo factoryVehiculo(int idVehiculo, String marcaModelo, String patente, int anio)throws VehiculoIncompletoException {
        if(patente==null||patente.length()==0){
            throw new VehiculoIncompletoException("no puede existir vehiculo sin matricula");
        }else return new Vehiculo(idVehiculo,marcaModelo,patente,anio);

    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public int getAnio() {
        return anio;
    }

    public String getPatente() {
        return patente;
    }

    public String mostrarVehiculo() {
        //"VW Golf modelo 2009 - Patente ABC123"
        return this.marcaModelo+" modelo "+this.anio+" - Patente "+this.patente;
    }
}
