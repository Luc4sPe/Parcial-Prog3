package modelo;

import excepciones.ServiceIncompletoException;

import java.time.LocalDate;

public class Service {

    private int idService;
    private Vehiculo elVehiculo;
    private Cliente elCliente;
    private LocalDate fechaService;
    private String detalleService;
    private float precio;

    public Service(int idService, Vehiculo elVehiculo,Cliente elCliente, LocalDate fechaService, String detalleService, float precio){
        this.idService=idService;
        this.elVehiculo=elVehiculo;
        this.elCliente=elCliente;
        this.fechaService=fechaService;
        this.detalleService=detalleService;
        this.precio=precio;
    }


    public static Service factoryService(int idService, Vehiculo elVehiculo, Cliente elCliente, LocalDate fechaService, String detalleService, float precio) throws ServiceIncompletoException {
        if(elVehiculo==null){
            throw new ServiceIncompletoException("no puede existir service sin vehiculo");
        }else if (!fechaService.isBefore(LocalDate.now())){
            throw new ServiceIncompletoException("Fecha Mayor a  la Actual");
        }else return new Service(idService,elVehiculo,elCliente,fechaService,detalleService,precio);
    }

    public String mostrarResumen() {
        //"Service Nro: 1\nCliente: Perez, Juan - 15152020\nVehiculo: VW Golf modelo 2009 - Patente ABC123\nTrabajo Realizado: Cambio de Aceite y Filtro"
        return "Service Nro: "+this.idService+
                "\nCliente: "+this.elCliente.getApellido()+", "+this.elCliente.getNombres()+" - "+this.elCliente.getTelefono()+
                "\nVehiculo: "+this.elVehiculo.getMarcaModelo()+" modelo "+this.elVehiculo.getAnio()+" - Patente "+this.elVehiculo.getPatente()+
                "\nTrabajo Realizado: "+this.detalleService;
    }
}
