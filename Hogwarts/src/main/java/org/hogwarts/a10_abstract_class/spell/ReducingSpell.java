package org.hogwarts.a10_abstract_class.spell;

public class ReducingSpell extends Spell {
    public ReducingSpell(String name, String effect, String status) {
        super(name, effect, status);
    }

    @Override
    public void doMagic() {
        System.out.println("Reducing spell has been cast!");
    }
}