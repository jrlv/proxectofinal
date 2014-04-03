
package Bolsa161;

/**
 *
 * @author JRLV
 */
public class Exercicio161ejecucion {
    
    public static void main(String[] args) {
        
        BolsaEnBD novaB = new BolsaEnBD();
        novaB.iniciar();
        novaB.inserirAccions(1, "Zara", 100);
        novaB.inserirAccions(2, "Mercadona", 50);
        novaB.novo("Manolo", "qwerty", 4000);
        novaB.novo("Pepe", "1234", 2000);
        novaB.novo("Marisa", "qaz", 7000);
        if(novaB.identificar("Pepe", "1234")){
            Cliente novoC = new Cliente();
            novoC.setLogin("Pepe");
            //novoC.comprar(2, 2);
            //novoC.vender(1, 1);
            //novoC.valorar();
        } else{
            System.out.println("Cliente seleccionado descoñecido.");
        }
        //novaB.actualizar();    
    } 
}
