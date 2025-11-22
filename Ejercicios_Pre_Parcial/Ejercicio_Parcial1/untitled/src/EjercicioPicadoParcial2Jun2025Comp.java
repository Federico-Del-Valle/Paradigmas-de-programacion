//VERSION COMPOSICION

public class EjercicioPicadoParcial2Jun2025Comp {

    public static void main (String[] args){
        CanalDeEnvio canalEmail = new CanalEmail();
        CanalDeEnvio canalSms = new CanalSms();
        CanalDeEnvio canalPush = new CanalPush();

        Notificacionn noti = new Notificacionn(
                "Hola, esto es una notificacion",
                "fede@ejemplo.com",
                canalSms
        );

        noti.enviar();

    }
}

class Notificacionn{
    private String destinatario;
    private String mensaje;
    private CanalDeEnvio canal;

    public Notificacionn(String destinatario, String mensaje, CanalDeEnvio canal){
        this.destinatario = destinatario;
        this.canal = canal;
        this.mensaje = mensaje;
    }

    public void enviar(){
        canal.enviar(mensaje, destinatario);
    }
}


 interface CanalDeEnvio{
    public void enviar(String mensaje, String destinatario);
}

class CanalEmail implements CanalDeEnvio{
    @Override
    public void enviar(String mensaje, String destinatario){
        System.out.println("Mail: " + destinatario + "\nMensaje: " + mensaje);
    }
}

class CanalSms implements CanalDeEnvio{
    @Override
    public void enviar(String mensaje, String destinatario){
        System.out.println("Sms: " + destinatario + "\nMensaje: " + mensaje);
    }
}

class CanalPush implements CanalDeEnvio{
    @Override
    public void enviar(String mensaje, String destinatario){
        System.out.println("Push: " + destinatario + "\nMensaje: " + mensaje);
    }
}