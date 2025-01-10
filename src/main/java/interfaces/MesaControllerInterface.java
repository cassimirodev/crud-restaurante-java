package interfaces;

import model.Mesa;
import java.util.List;

public interface MesaControllerInterface {
    void adicionarMesa(int numeroMesa, int qtdCadeiras, String status);
    Mesa buscarMesaPorId(int id);
    List<Mesa> listarTodasMesas();
    void atualizarMesa(int id, int novoNumero, int novaQtdCadeiras, String novoStatus);
    void removerMesa(int id);
}
