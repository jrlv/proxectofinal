
package Bolsa161;

/**
 *
 * @author JRLV
 */
public class Exercicio161ejecucion {
    
    public static void main(String[] args) {
        
        BolsaEnBD novaB = new BolsaEnBD();
        
        //novaB.iniciar();
        novaB.conectar();
        //novaB.inserirAccions(1, "Zara", 100);
        //novaB.inserirAccions(2, "Mercadona", 50);
        //novaB.inserirAccions(3, "Coren", 25);
        //novaB.novo("Manolo", "1234", 4000);
        //novaB.novo("Pepe", "qwerty", 2000);
        //novaB.novo("Marisa", "asdf", 7000);
        //novaB.actualizar();
        //novaB.resumir();
        
        if(novaB.identificar("Manolo", "1234")){
            Cliente novoC = new Cliente();
            novoC.setLogin("Manolo");
            novoC.setB(novaB);
            novoC.comprar(2, 2);
            //novoC.vender(2, 2);
            //novoC.valorar();
            //novoC.resumir();
        } else{
            System.out.println("Cliente seleccionado descoñecido.");
        }
    } 
}
