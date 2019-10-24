package modeloTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import excepciones.VehiculoIncompletoException;
import modelo.Service;
import modelo.Vehiculo;

class VehiculoUnitTest {

	@Test
	void instanciarVehiculo_VehiculoSinPatente_generaError() {
		Assertions.assertThrows(VehiculoIncompletoException.class, () -> Vehiculo.factoryVehiculo(1, "VW Golf", null, 2009));	
	}
	
	@Test
	void instanciarVehiculo_VehiculoCompleto_instanciaCorrecta() throws VehiculoIncompletoException {
		Vehiculo elVehiculo = Vehiculo.factoryVehiculo(1, "VW Golf", "ABC123", 2009);
		assertNotNull(elVehiculo);		
	}
	
	@Test
	void mostrarVehiculo_formatoEspecifico_muestraFormateado() throws VehiculoIncompletoException {
		Vehiculo elVehiculo = Vehiculo.factoryVehiculo(1, "VW Golf", "ABC123", 2009);
		String formatoSalida=elVehiculo.mostrarVehiculo();
		
		assertEquals("VW Golf modelo 2009 - Patente ABC123", formatoSalida);
	}

}
