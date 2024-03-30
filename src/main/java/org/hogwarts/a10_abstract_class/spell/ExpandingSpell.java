package org.hogwarts.a10_abstract_class.spell;

public class ExpandingSpell extends Spell {
    public ExpandingSpell(String name, String effect, String status) {
        super(name, effect, status);
    }

    @Override
    public void doMagic() {
        System.out.println("Expanding spell has been cast!");
    }
}