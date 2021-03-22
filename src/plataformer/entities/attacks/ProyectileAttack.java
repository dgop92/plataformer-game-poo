package plataformer.entities.attacks;

public abstract class ProyectileAttack implements Attack {
    
    private Proyectile proyectile;

    public ProyectileAttack(Proyectile proyectile) {
        this.proyectile = proyectile;
    }

    public void setProyectile(Proyectile proyectile) {
        this.proyectile = proyectile;
    }

    public Proyectile getProyectile() {
        return proyectile;
    }
}
