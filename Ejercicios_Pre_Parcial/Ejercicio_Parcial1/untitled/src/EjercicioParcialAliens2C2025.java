import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjercicioParcialAliens2C2025 {

    public static void main (String[] args){
        List <Criatura> criaturas = new ArrayList<>();
        criaturas.add(new Xenomorfo("Delfi", 10, 100));
        criaturas.add(new Reina("Juancita",1,2));
        criaturas.add(new Facehugger("Gutti", 2,1000));
        criaturas.add(new Xenomorfo("Scrozo",5,200000));

        System.out.println("Lista original");

        for(Criatura c : criaturas)
            System.out.println(c);

        Collections.sort(criaturas);

        System.out.println("------------");

        System.out.println("Lista ordenada");
        for (Criatura c: criaturas)
            System.out.println(c);



    }
}


abstract class Criatura implements Comparable<Criatura>{
    private String nombre;
    private int peligrosidad;
    private int velocidad;

    public abstract void atacar();

    public Criatura(String nombre,int velocidad, int peligrosidad ){
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.peligrosidad = peligrosidad;
    }

    public String getNombre(){
        return nombre;
    }
    public int getPeligrosidad(){
        return peligrosidad;
    }
    public int getVelocidad(){
        return velocidad;
    }

    @Override
    public int compareTo(Criatura c){
        return Integer.compare(c.peligrosidad, this.peligrosidad);
    }

    @Override
    public String toString(){
        return " Nombre: " + this.nombre + " Velocidad: "+ this.velocidad + " Peligrosidad: "+ this.peligrosidad;
    }
}


class Facehugger extends Criatura{

    public Facehugger(String nombre, int velocidad, int peligrosidad){
        super(nombre,velocidad,peligrosidad);
    }

    public void atacar(){
        System.out.println("Parasita al huesped");
    }
}

class Xenomorfo extends Criatura{

    public Xenomorfo(String nombre, int velocidad, int peligrosidad){
    super(nombre,velocidad,peligrosidad);
    }

    public void atacar(){
        System.out.println("Ataque con garras y cola ");
    }
}

class Reina extends Criatura{

    public Reina(String nombre, int velocidad, int peligrosidad){
        super(nombre, velocidad,peligrosidad);
    }

    public void atacar(){
        System.out.println("Ataques coordinados");
    }
}


