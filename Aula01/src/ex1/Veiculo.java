package ex1;

public class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
    private Integer quantidadePortas;

    public Veiculo(String marca, String modelo, String placa, Integer quantidadePortas) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.quantidadePortas = quantidadePortas;
    }

    public void printarVeiculo(){
        System.out.println("Eu sou um veículo");
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", quantidadePortas=" + quantidadePortas +
                '}';
    }
}
