package repositorio;

import modelo.Cliente;

public interface IRepositorioCrearCliente {
    boolean guardar(Cliente clienteNuevo);

    Cliente findByDNI(String s);
}
