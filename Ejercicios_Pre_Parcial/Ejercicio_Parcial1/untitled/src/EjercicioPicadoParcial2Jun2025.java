/**
 *
 Herencia vs. Composición

 Se desea modelar un sistema de notificaciones para una aplicación. Una Notificación puede ser enviada por diferentes medios: email, SMS, push, etc. Cada tipo de notificación tiene su forma particular de enviarse, pero todas comparten una estructura básica de mensaje y destinatario.

 Se pide:

 a. Explicar brevemente las diferencias entre herencia y composición, considerando conceptos como acoplamiento, reutilización y extensibilidad.

 b. Justificar en qué situaciones conviene aplicar herencia o composición en el diseño de sistemas de notificación.

 c. Implementar en Java dos versiones del sistema: * Una solución usando herencia donde NotificacionEmail, NotificacionSMS, etc., extienden de una clase base Notificacion. * Otra solución usando composición donde Notificacion tiene un atributo de tipo CanalDeEnvio, que puede ser un Email, SMS, etc., y se invoca a través de una interfaz CanalDeEnvio.

 d. Para cada versión: * Mostrar un ejemplo de uso donde se envía un mensaje a través de distintos canales. * Diagramar en UML. * Escribir una conclusión breve en términos de reusabilidad, extensibilidad y mantenibilidad.
 */




//VERSION HERENCIA

public class EjercicioPicadoParcial2Jun2025 {


    public static void main(String [] args){
        NotificacionSMS notiS = new NotificacionSMS("Hola como estas", "Delfina");
        NotificacionEmail notiE = new NotificacionEmail("Hola por email", "Elian");
        NotificacionPush notiP = new NotificacionPush("Hola por push", "Kevin");

        System.out.println(notiP.toString());
        System.out.println(notiE.toString());
        System.out.println(notiS.toString());

    }


}



 abstract class Notificacion{
    protected String mensaje;
    protected String destinatario;



    public Notificacion(String mensaje, String destinatario){
        this.destinatario= destinatario;
        this.mensaje = mensaje;
    }

     @Override
     public String toString() {
         return "Notificacion{" +
                 "mensaje='" + mensaje + '\'' +
                 ", destinatario='" + destinatario + '\'' +
                 '}';
     }

     public abstract void enviar();
 }


 class NotificacionEmail extends Notificacion{

    public NotificacionEmail(String mensaje, String destinatario){
        super(mensaje, destinatario);
    }

     @Override
     public void enviar() {
         System.out.println("Mensaje enviado desde email");
     }
 }

 class NotificacionSMS extends Notificacion{
    public NotificacionSMS(String mensaje, String destinatario){
        super(destinatario, mensaje);
    }

    @Override
    public void enviar(){
        System.out.println("Mensaje enviado por SMS");
    }
 }

 class NotificacionPush extends Notificacion{
    public NotificacionPush(String mensaje, String destinatario){
        super(destinatario, mensaje);
    }

     @Override
     public String toString() {
         return super.toString();
     }

     public void enviar(){
        System.out.println("Mensaje enviado desde notificaicon push");
    }
 }
