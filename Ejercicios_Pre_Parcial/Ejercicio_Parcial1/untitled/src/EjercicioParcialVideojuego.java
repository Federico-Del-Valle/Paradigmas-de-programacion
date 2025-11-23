public class EjercicioParcialVideojuego {


    public static void main ( String[] args){
        ArmaFuego pistola = new ArmaFuego("Pistola");
        AgenteArmas fede = new AgenteArmas("Federico");
        AgenteCamara delfi = new AgenteCamara("Delfina");

        fede.usarArma(pistola, delfi);
    }


}


abstract class Agente{
    private String nombre;
    private Boolean oculto;

    public Agente(String nombre){
        this.nombre = nombre;
        this.oculto = false;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void ocultarse(){
        if(this.oculto)
            System.out.println("Ya esta oculto");
        else
            oculto = true;
    }
}

class AgenteCamara extends Agente{

    public AgenteCamara(String nombre){
        super(nombre);
    }

    public void usarCamara(Camara camara){
        if(camara.getEstado())
            System.out.println("La camara ya esta activada");
        else
            camara.activa();
    }


}
class AgenteArmas extends Agente{

    public AgenteArmas(String nombre){
        super(nombre);
    }

    public void usarArma(Armaa arma, Agente agente){

        System.out.println("El agente " + this.getNombre() + " ataco al agente " + agente.getNombre() + " con el arma " +
                arma.getNombre());
    }

}

class Camara{
    private String nombre;
    private Boolean activa;

    public Camara(String nombre){
        this.nombre = nombre;
        this.activa = false;
    }
    public String getNombre(){
        return this.nombre;
    }
    public Boolean getEstado(){
        return this.activa;
    }

    public void activa(){
        this.activa = true;
    }
}

class Armaa{
    private String nombre;

    public Armaa(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

}


class ArmaFuego extends Armaa{

    public ArmaFuego(String nombre){
        super(nombre);
    }

}
