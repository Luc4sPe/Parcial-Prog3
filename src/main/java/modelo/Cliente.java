package modelo;

import excepciones.ClienteIncompletoException;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Cliente {
    private int idCliente;
    private String apellido;
    private String nombres;
    private String documento;
    private LocalDate fechaNacimiento;
    private String domicilio;
    private String telefono;
    private List<Vehiculo> vehiculos;

    public Cliente(int idCliente,String apellido, String nombres, String documento,LocalDate fechaNacimiento, String domicilio,String telefono){
        this.idCliente=idCliente;
        this.apellido=apellido;
        this.nombres=nombres;
        this.documento=documento;
        this.fechaNacimiento=fechaNacimiento;
        this.domicilio=domicilio;
        this.telefono=telefono;
        this.vehiculos=new ArrayList<Vehiculo>();
    }

    public static Cliente factoryCliente(int idCliente, String apellido, String nombres, String documento, LocalDate fechaNacimiento, String domicilio, String telefono) throws ClienteIncompletoException {
       if(documento==null||documento.length()==0){
           throw new ClienteIncompletoException("no puede existir un cliente sin documento");

       }else if(Period.between(fechaNacimiento,LocalDate.now()).getYears()>=18){
           return new Cliente(idCliente,apellido,nombres,documento,fechaNacimiento,domicilio,telefono);
       }else throw new ClienteIncompletoException("El cliente es menor de edad");
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void asignarVehiculo(Vehiculo elVehiculo) {
        this.vehiculos.add(elVehiculo);
    }

    public List<Vehiculo> devolverVehiculos() {
        return this.vehiculos;
    }
}
