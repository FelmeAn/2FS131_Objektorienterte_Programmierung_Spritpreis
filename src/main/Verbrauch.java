package main;

import javax.swing.*;
import java.util.Scanner;

public class Verbrauch {
    private double strecke, spritMenge, spritPreis;
    String spritArt;
    public Verbrauch(double strecke, double spritMenge, double spritPreis, String spritArt){
        this.strecke=strecke;
        this.spritMenge=spritMenge;
        this.spritPreis=spritPreis;
    }
    public Verbrauch(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte gebe die Strecke in Kilometern ein: ");
        strecke=Double.parseDouble(sc.next().replaceAll(",", "."));
        System.out.print("Bitte gebe die verbrauchte Spritmenge in Liter ein: ");
        spritMenge=Double.parseDouble(sc.next().replaceAll(",", "."));
        System.out.print("Bitte gebe den Spritpreis in Cent ein: ");
        spritPreis=Double.parseDouble(sc.next().replaceAll(",", "."));
        System.out.print("Bitte gebe die Kraftstoffart an: ");
        spritArt=sc.next();
    }
    private double verbrauch(double strecke, double spritMenge){
        return spritMenge/strecke;
    }
    private double verbrauchPro100Km(){
        return spritMenge*100/strecke;
    }
    private double kostenPro1Km(){
        return (spritMenge*(spritPreis/100))/strecke;
    }
    private double streckemit1Liter(){
        return strecke/spritMenge;
    }
    public double spezifischeCO2Emission(String spritArt){
        switch (spritArt){
            case "Benzin":
                return verbrauchPro100Km()*(23.2/10);
            case "Diesel":
                return verbrauchPro100Km()*(26.2/10);
            default:
                return 0;
        }
    }
    public double absoluteCO2Emissionen(String spritArt){
        switch (spritArt){
            case "Benzin":
                return (verbrauch(strecke, spritMenge)*(23.2/10))*strecke;
            case "Diesel":
                return (verbrauch(strecke, spritMenge)*(26.2/10))*strecke;
            default:
                return 0;
        }
    }

    void output(){
        System.out.println("-------------[Eingabe]-------------");
        System.out.println("Strecke: "+strecke);
        System.out.println("Spritmenge: "+spritMenge);
        System.out.println("Spritpreis: "+spritPreis/100+ " €");
        System.out.println("-------------[Ausgabe]-------------");
        System.out.println("Verbrauch im Durchschnitt: "+verbrauch(strecke, spritMenge));
        System.out.println("Verbrauch: "+verbrauchPro100Km()+"/100 km");
        System.out.println("Kosten: "+kostenPro1Km()+" €/km");
        System.out.println("Strecke: "+streckemit1Liter()+"/1L");
        System.out.println("---------------[CO2]---------------");
        System.out.println("Spezifisch: "+spezifischeCO2Emission(spritArt));
        System.out.println("Absolut: "+absoluteCO2Emissionen(spritArt));
    }

}
