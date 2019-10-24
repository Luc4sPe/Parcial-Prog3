package modeloTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import excepciones.ClienteIncompletoException;
import excepciones.ServiceIncompletoException;
import excepciones.VehiculoIncompletoException;
import modelo.Cliente;
import modelo.Service;
import modelo.Vehiculo;

class ServiceUnitTest {

	
	@Test
	void instanciarService_ServiceCompleto_instanciaCorrecta() throws ClienteIncompletoException, ServiceIncompletoException, VehiculoIncompletoException {
		Vehiculo elVehiculo = Vehiculo.factoryVehiculo(1, "VW Golf", "ABC123", 2009);
		Cliente elCliente = Cliente.factoryCliente(1, "Perez", "Juan", "12345678", LocalDate.of(1990, 1, 1),
				"Av. San Martin 123", "15152020");
		Service elService = Service.factoryService(1, elVehiculo, elCliente, LocalDate.of(2018, 10, 10),
				"Cambio de Aceite y Filtro", 1500.00f);

		assertNotNull(elService);
	}
	
	@Test
	void instanciarService_ServiceSinVehiculo_ServiceIncompletoException() throws ClienteIncompletoException {

		Cliente elCliente = Cliente.factoryCliente(1, "Perez", "Juan", "12345678", LocalDate.of(1990, 1, 1),
				"Av. San Martin 123", "15152020");
		Assertions.assertThrows(ServiceIncompletoException.class, () -> Service.factoryService(1, null, elCliente,
				LocalDate.of(2018, 10, 10), "Cambio de Aceite y Filtro", 1500.00f));
	}



	@Test
	void mostrarResumen_formatoEspecifico_muestraFormateado() throws ClienteIncompletoException, ServiceIncompletoException, VehiculoIncompletoException {
		Vehiculo elVehiculo = Vehiculo.factoryVehiculo(1, "VW Golf", "ABC123", 2009);
		Cliente elCliente = Cliente.factoryCliente(1, "Perez", "Juan", "12345678", LocalDate.of(1990, 1, 1),
				"Av. San Martin 123", "15152020");
		Service elService = Service.factoryService(1, elVehiculo, elCliente, LocalDate.of(2018, 10, 10),
				"Cambio de Aceite y Filtro", 1500.00f);

		String formatoSalida = elService.mostrarResumen();

		assertEquals(
				"Service Nro: 1\nCliente: Perez, Juan - 15152020\nVehiculo: VW Golf modelo 2009 - Patente ABC123\nTrabajo Realizado: Cambio de Aceite y Filtro",
				formatoSalida);
	}

}
