package rango;

import java.util.Objects;

public class Rango {

        private final double r1;  // inicio
        private final double r2;  // fin
        private final boolean l1; // true = cerrado izquierda
        private final boolean l2; // true = cerrado derecha

        private Rango(double r1, double r2, boolean l1, boolean l2) {
            if (Double.isNaN(r1) || Double.isNaN(r2))
                throw new IllegalArgumentException("Extremos NaN");
            if (r1 > r2)
                throw new IllegalArgumentException("r1 no puede ser > r2");
            this.l1 = l1;
            this.l2 = l2;
            this.r1 = r1;
            this.r2 = r2;
        }

        // [r1, r2]
        public static Rango cerrado(double r1, double r2) {
            return new Rango(r1, r2, true, true);
        }

        // (r1, r2)
        public static Rango abierto(double r1, double r2) {
            return new Rango(r1, r2, false, false);
        }

        // (r1, r2]
        public static Rango abiertoIzq(double r1, double r2) {
            return new Rango(r1, r2, false, true);
        }

        // [r1, r2)
        public static Rango abiertoDer(double r1, double r2) {
            return new Rango(r1, r2, true, false);
        }

        public boolean numeroEnRango(double n) {
            boolean rangoIzq = l1 ? n >= r1 : n > r1;
            boolean rangoDer = l2 ? n <= r2 : n < r2;
            return rangoIzq && rangoDer;
        }

        public boolean rangoEnRango(Rango otro) {
            boolean rangoIzq = this.l1 ? otro.r1 >= this.r1 : otro.r1 > this.r1;
            boolean rangoDer = this.l2 ? otro.r2 <= this.r2 : otro.r2 < this.r2;
            return rangoIzq && rangoDer;
        }

        public boolean hayInterseccion(Rango otro) {
            if (this.r2 < otro.r1 || this.r1 > otro.r2) return false;
            if (this.r2 == otro.r1) return this.l2 && otro.l1; // ambos cerrados
            if (this.r1 == otro.r2) return this.l1 && otro.l2; // ambos cerrados
            return true;
        }

        public boolean rangosIguales(Rango otro) {
            return this.l1 == otro.l1 &&
                    this.l2 == otro.l2 &&
                    this.r1 == otro.r1 &&
                    this.r2 == otro.r2;
        }

        // -1 si this va antes que otro, 0 iguales, 1 si otro va antes
        public int ordenarRangos(Rango otro) {
            int c = Double.compare(this.r1, otro.r1);
            if (c != 0) return c < 0 ? -1 : 1;

            // mismo inicio: cerrados primero
            if (this.l1 != otro.l1) return this.l1 ? -1 : 1;

            c = Double.compare(this.r2, otro.r2);
            if (c != 0) return c < 0 ? -1 : 1;

            // mismo fin: cerrados primero
            if (this.l2 != otro.l2) return this.l2 ? -1 : 1;

            return 0;
        }

        public String imprimirString() {
            String izq = l1 ? "[" : "(";
            String der = l2 ? "]" : ")";
            return izq + r1 + " , " + r2 + der;
        }

        public static Rango abarcarRangos(Rango ran1, Rango ran2) {
            double ra1 = Math.min(ran1.r1, ran2.r1);
            boolean la1;
            if (ran1.r1 < ran2.r1)      la1 = ran1.l1;
            else if (ran1.r1 > ran2.r1) la1 = ran2.l1;
            else                        la1 = ran1.l1 || ran2.l1; // si comparten inicio, cerramos si alguno cierra

            double ra2 = Math.max(ran1.r2, ran2.r2);
            boolean la2;
            if (ran1.r2 > ran2.r2)      la2 = ran1.l2;
            else if (ran1.r2 < ran2.r2) la2 = ran2.l2;
            else                        la2 = ran1.l2 || ran2.l2; // si comparten fin, cerramos si alguno cierra

            return new Rango(ra1, ra2, la1, la2);
        }

        public Rango sumarRangos(Rango otro) {
            return new Rango(this.r1, otro.r2, this.l1, otro.l2);
        }

        public Rango devolverInterseccion(Rango otro) {
            if (!this.hayInterseccion(otro))
                return new Rango(0, 0, false, false);

            double ranRes1;
            boolean laRes1;
            if (this.r1 == otro.r1) { ranRes1 = this.r1; laRes1 = this.l1 && otro.l1; }
            else if (this.r1 >  otro.r1) { ranRes1 = this.r1; laRes1 = this.l1; }
            else { ranRes1 = otro.r1; laRes1 = otro.l1; }

            double ranRes2;
            boolean laRes2;
            if (this.r2 == otro.r2) { ranRes2 = this.r2; laRes2 = this.l2 && otro.l2; }
            else if (this.r2 <  otro.r2) { ranRes2 = this.r2; laRes2 = this.l2; }
            else { ranRes2 = otro.r2; laRes2 = otro.l2; }

            return new Rango(ranRes1, ranRes2, laRes1, laRes2);
        }

        public Rango desplazar(double num) {
            return new Rango(this.r1 + num, this.r2 + num, this.l1, this.l2);
        }

        // (opcional) equals/hashCode útiles si vas a usar en colecciones
        @Override public boolean equals(Object o){
            if(!(o instanceof Rango r)) return false;
            return rangosIguales(r);
        }
        @Override public int hashCode(){
            return Objects.hash(r1,r2,l1,l2);
        }

}
