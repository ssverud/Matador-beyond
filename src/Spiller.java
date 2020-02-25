

public class Spiller {

    private int spillerPlacering;
    private int pengeKonto;
    private int antalGrundEjet;
    private int antalBonuskortEjet;

    public Spiller(int spillerPlacering, int pengeKonto, int antalGrundEjet, int antalBonuskortEjet) {
        this.spillerPlacering = spillerPlacering;
        this.pengeKonto = pengeKonto;
        this.antalGrundEjet = antalGrundEjet;
        this.antalBonuskortEjet = antalBonuskortEjet;
    }

    public int getSpillerPlacering() {
        return spillerPlacering;
    }

    public void setSpillerPlacering(int spillerPlacering) {
        this.spillerPlacering = spillerPlacering;
    }

    public int getPengeKonto() {
        return pengeKonto;
    }

    public void setPengeKonto(int pengeKonto) {
        this.pengeKonto = pengeKonto;
    }

    public int getAntalGrundEjet() {
        return antalGrundEjet;
    }

    public void setAntalGrundEjet(int antalGrundEjet) {
        this.antalGrundEjet = antalGrundEjet;
    }

    public int getAntalBonuskortEjet() {
        return antalBonuskortEjet;
    }

    public void setAntalBonuskortEjet(int antalBonuskortEjet) {
        this.antalBonuskortEjet = antalBonuskortEjet;
    }
}
