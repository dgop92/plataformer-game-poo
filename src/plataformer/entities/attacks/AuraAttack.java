package plataformer.entities.attacks;

public abstract class AuraAttack implements Attack{
    
    protected Aura aura;

    public AuraAttack(Aura aura) {
        this.aura = aura;
    }

    public void setAura(Aura aura) {
        this.aura = aura;
    }

    public Aura getAura() {
        return aura;
    }
    
}
