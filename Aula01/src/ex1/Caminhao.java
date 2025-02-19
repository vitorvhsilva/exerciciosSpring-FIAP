package ex1;

public class Caminhao extends Veiculo{
    public Caminhao(String marca, String modelo, String placa) {
        super(marca, modelo, placa, 2);
    }

    @Override
    public void printarVeiculo() {
        System.out.println("Eu sou um caminhao!");
    }
}
