package org.example.calculatrice.calculatrice;

import java.util.Scanner;

public class CalcFonctionController {

    double a, b, c, d, e, D;

    double Df;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public double getDf() {
        return Df;
    }

    public void setDf(double df) {
        Df = df;
    }

    public void etudeDeFonction() {

        final float x ;

        System.out.println(" >>>Est-ce la bonne fonction :  " + "(" + (Integer.parseInt(String.valueOf(a).substring(String.valueOf(a).indexOf(".") + 1)) > 0 ? a : String.valueOf(a).substring(0, String.valueOf(a).indexOf("."))) + "x² " + (b < 0 ? "" : "+") + b + "x + " + c + ")/(" + d + "x + " + e + ")" + "    ???") ;

        if (b == 0) {
            Df = 0;
            System.out.println(" ---La domaine de definition est : Df = ]-oo ; " + Df + "] U [" + Df + " ; +oo[");
        } else {
            System.out.println(" ---La domaine de definition est : Df = ]-oo ; " + Df + "] U [" + Df + " ; +oo[");
        }

        System.out.println(" ---La dériver f' de f est :  f'(x) = (" + a * d + "x² + " + (2 * a * e) + "x + " + (b * e - d * c) + " )/(" + d + "x + " + e + ")²" );

        if ( (a / d) > 0) {
            System.out.println(" ---La limite de f(x) lorsque x tend vers +oo est : +oo");
            System.out.println(" ---La limite de f(x) lorsque x tend vers -oo est : -oo");
        } else {
            System.out.println(" ---La limite de f(x) lorsque x tend vers +oo est : -oo");
            System.out.println(" ---La limite de f(x) lorsque x tend vers -oo est : +oo");
        }
    }

    private static void menuFOnction() {
        System.out.println("  1-Domaine de définition");
        System.out.println("  2-Les limites");
        System.out.println("  3-Dérivée");
        System.out.println("  4-Signe de la dérivée");
        System.out.println("  5-Sens de variation");
        System.out.println("  6-Tableau de variation");
    }

    private static void Df() {

    }

}
