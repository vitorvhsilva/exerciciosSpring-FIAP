package ex1;

public class MainConcessionaria {
    public static void main(String[] args) {
        Veiculo carro = new Carro("Hyundai", "Civic", "AAAAAAA", 4);
        Veiculo moto = new Moto("Honda", "X0", "BBBBBBB");
        Veiculo caminhao = new Caminhao("Mercedes", "Truck", "CCCCCCC");

        System.out.println(carro);
    }
}
