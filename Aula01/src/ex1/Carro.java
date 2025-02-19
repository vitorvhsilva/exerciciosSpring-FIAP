package ex1;

public class Carro extends Veiculo{
    public Carro(String marca, String modelo, String placa, Integer quantidadePortas) {
        super(marca, modelo, placa, quantidadePortas);
    }

    @Override
    public void printarVeiculo() {
        System.out.println("Eu sou um carro!");
    }
}
