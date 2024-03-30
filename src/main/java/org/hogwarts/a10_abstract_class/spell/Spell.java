package org.hogwarts.a10_abstract_class.spell;

public abstract class Spell {
    private String name;
    private String effect;
    private String status;

    public Spell(String name, String effect, String status) {
        this.name = name;
        this.effect = effect;
        this.status = status;
    }

    public abstract void doMagic();
}