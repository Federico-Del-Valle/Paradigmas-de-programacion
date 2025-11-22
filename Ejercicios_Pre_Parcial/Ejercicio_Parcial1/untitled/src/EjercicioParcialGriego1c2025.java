/**
 * 4. Desarrollar un programa inspirado en la mitología nórdica. En el mismo hay guerreros nórdicos, que dependiendo de sus habilidades pueden abrir portales mágicos, manejar armas divinas o alterar runas protectoras.
 * Todos pueden ocultarse usando magia. Cualquier guerrero puede ejecutar sus acciones en al menos dos variantes del elemento que manipula.
 * Ejemplos:
 * Los GuardianDePortales pueden abrir portales de Asgard o portales de Midgard.
 * Programar los siguientes métodos, donde corresponda:
 * - ocultarse(): El guerrero se oculta usando magia. No puede ocultarse si ya está oculto.
 * - abrir(Portal): Un guerrero puede abrir portales mágicos con este metodo.
 *   Un portal abierto no puede ser abierto nuevamente.
 * - usarArmaDivina(Arma, Guerrero): Un guerrero especialista puede usar un arma divina otorgada hacia otro guerrero, no puede usarla en sí mismo.
 * - alterar(Runa): Un guerrero desactiva una runa protectora.
 * Realizar un diagrama de clases y el código fuente completo del ejercicio.
 * Las implementaciones de los métodos deben ser simplemente salidas por pantalla indicando la acción realizada. Ejemplos:
 * "El guerrero Thor, especialista en portales, abrió un portal de Asgard"
 * "El guerrero Odin, especialista en runas, alteró el funcionamiento de una runa de protección"
 * "El guerrero Freyr, especialista en armas divinas, usó Mjölnir contra el guerrero Loki"
 * Se evaluará el correcto uso del paradigma y la orientación a objetos.
 * Probar los casos excepcionales.
 */


public class EjercicioParcialGriego1c2025 {

    public static void main (String[] args){
        GuerreroEspecialistaEnRunas delfi = new GuerreroEspecialistaEnRunas("Delfina");

        GuerreroEspecialistaEnPortales fede = new GuerreroEspecialistaEnPortales("Federico");

        GuerreroEspecialistaEnArmas kevin = new GuerreroEspecialistaEnArmas("Kevin");


        Portal asgard = new Portal("Asgard");
        Portal argentina = new Portal("Argentina");

        Runa fuego = new Runa("Fuego");
        Runa viento = new Runa ("Viento");

        Arma espadas = new Arma ("Spades of Chaos");

        kevin.usarArma(espadas, delfi);
        delfi.alterarRuna(fuego);
        fede.abrirPortal(asgard);



    }
}

abstract class GuerreroNordico{
    private String nombre;
    private Boolean oculto;
    public GuerreroNordico(String nombre){
        this.nombre = nombre;
        this.oculto = false;
    }
    public String getNombre(){
        return this.nombre;
    }

    public Boolean getOculto() {
        return oculto;
    }


    public void ocultar() throws ocultoException{
        if(oculto)
            throw new ocultoException("El  guerrero ya esta oculto");
        else
            oculto= true;
    }

}

class GuerreroEspecialistaEnPortales extends GuerreroNordico{
    public GuerreroEspecialistaEnPortales(String nombre){
        super(nombre);
    }

    public void abrirPortal(Portal portal){
        if(portal.estaAbierto()){
            System.out.println("El portal ya se encuentra abierto");
        }
        else{
            portal.abrir();
            System.out.println("El guerrero "+ getNombre() + "abrio el portal hacia " +
            portal.getDestino());
        }
    }
}


class GuerreroEspecialistaEnRunas extends GuerreroNordico{
    public GuerreroEspecialistaEnRunas(String nombre){
        super(nombre);
    }

    public void alterarRuna(Runa runa){

        if(runa.getEstado()){
            System.out.println("La runa ya esta activa");
        }
        else {
            System.out.println("La runa " + runa.getDescripcion() + "fue activa por el guerrero "+ this.getNombre());
        }
    }
}

class GuerreroEspecialistaEnArmas extends GuerreroNordico{
    public GuerreroEspecialistaEnArmas(String nombre){
        super(nombre);
    }

    public void usarArma(Arma arma, GuerreroNordico guerrero){
        System.out.println("El guerrero: " + getNombre() + " uso el arma " + arma.getNombre() + " contra el guerrrero : " + guerrero.getNombre());
    }
}





class ocultoException extends Exception{
    public ocultoException(String mensaje){
        super(mensaje);
    }
}


class Portal{
    private String destino;
    private Boolean abierto;

    public Portal(String destino){
        this.destino = destino;
        this.abierto = false;
    }

    public String getDestino(){
        return this.destino;
    }

    public Boolean estaAbierto(){
        return abierto;
    }

    public void abrir(){
        this.abierto = true;
    }
}

class Runa{
    private String descripcion;
    private Boolean activa;

    public Runa(String descripcion){
        this.descripcion = descripcion;
        this.activa = false;
    }

    public boolean getEstado(){
        return this.activa;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void activar(){
        this.activa = true;
    }
}

class Arma{
    private String nombre;

    public Arma(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

}