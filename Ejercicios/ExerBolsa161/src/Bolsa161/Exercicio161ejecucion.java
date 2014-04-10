
package Bolsa161;

/**
 *
 * @author JRLV
 */
public class Exercicio161ejecucion {
    
    public static void main(String[] args) {
        
        BolsaEnBD novaB = new BolsaEnBD();
        
        novaB.iniciar();
        //novaB.inserirAccions(1, "Zara", 100);
        //novaB.inserirAccions(2, "Mercadona", 50);
        //novaB.inserirAccions(3, "Coren", 25);
        //novaB.novo("Manolo", "1234", 4000);
        //novaB.novo("Pepe", "qwerty", 2000);
        //novaB.novo("Marisa", "asdfg", 7000);
        //novaB.actualizar();
        //novaB.resumir();
        
        if(novaB.identificar("Marisa", "asdfg")){
            Cliente novoC = new Cliente();
            novoC.setLogin("Marisa");
            //novoC.comprar(2, 4);
            //novoC.vender(1, 10);
            //novoC.valorar();
            //novoC.resumir();
        } else{
            System.out.println("Cliente seleccionado descoñecido.");
        }
        
    } 
}
