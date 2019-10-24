package interactorUnitTest;

import Mockito.MockitoExtension;
import excepciones.ClienteExisteException;
import excepciones.ClienteIncompletoException;
import interactor.CrearClienteUseCase;
import modelo.Cliente;
import repositorio.IRepositorioCrearCliente;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class crearClienteUnitTest {

    @Mock
    IRepositorioCrearCliente crearClienteGateway;


    @Test
    public void crearCliente_ClienteNoExiste_GuardaCorrectamente() throws ClienteIncompletoException, ClienteExisteException {
        Cliente ClienteNuevo=Cliente.factoryCliente(1,"Perez", "Juan","12345678",LocalDate.of(1990, 1, 1) , "Av. San Martin 123", "15152020");
        when(crearClienteGateway.guardar(ClienteNuevo)).thenReturn(true);
        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteGateway);
        boolean resultado = crearClienteUseCase.crearCliente(ClienteNuevo);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearCliente_ClienteExiste_ClienteExisteException() throws ClienteIncompletoException {
    	Cliente ClienteNuevo=Cliente.factoryCliente(1,"Perez", "Juan","12345678",LocalDate.of(1990, 1, 1) , "Av. San Martin 123", "15152020");
        when(crearClienteGateway.findByDNI("12345678")).thenReturn(Cliente.factoryCliente(1,"Lopez", "Carlos","12345678",LocalDate.of(1990, 1, 1) , "Av. San Martin 999", "15152020"));
        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteGateway);
        Assertions.assertThrows(ClienteExisteException.class, () -> crearClienteUseCase.crearCliente(ClienteNuevo));

    }
}
