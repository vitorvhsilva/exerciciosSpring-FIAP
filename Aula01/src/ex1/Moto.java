package ex1;

public class Moto extends Veiculo{
    public Moto(String marca, String modelo, String placa) {
        super(marca, modelo, placa, 0);
    }

    @Override
    public void printarVeiculo() {
        System.out.println("Eu sou uma moto!");
    }


}
