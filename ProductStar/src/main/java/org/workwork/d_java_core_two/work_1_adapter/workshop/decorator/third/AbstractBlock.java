package org.workwork.d_java_core_two.work_1_adapter.workshop.decorator.third;

// Абстрактный блок
abstract class AbstractBlock {
    public abstract void draw();
}


// Терминальный блок (начало/конец, вход/выход)
class TerminatorBlock extends AbstractBlock {
    @Override
    public void draw() {
        System.out.println("Terminator block drawing ...");
    }
}

// Блок - процесс (один или несколько операторов)
class ProcessBlock extends AbstractBlock {
    @Override
    public void draw() {
        System.out.println("Process block drawing ...");
    }
}

// Абстрактный декоратор блоков
abstract class AbstractBlockDecorator extends AbstractBlock {
    protected AbstractBlock decoratee;

    public AbstractBlockDecorator(AbstractBlock decoratee) {
        this.decoratee = decoratee;
    }

    @Override
    public void draw() {
        decoratee.draw();
    }
}

// Декорирует блок текстовой меткой
class LabelBlockDecorator extends AbstractBlockDecorator {
    private String label;

    public LabelBlockDecorator(AbstractBlock decoratee, String label) {
        super(decoratee);
        this.label = label;
    }

    @Override
    public void draw() {
        super.draw();
        drawLabel();
    }

    private void drawLabel() {
        System.out.println(" ... drawing label " + label);
    }
}

// Декорирует блок специальной рамкой
class BorderBlockDecorator extends AbstractBlockDecorator {
    private int borderWidth;

    public BorderBlockDecorator(AbstractBlock decoratee, int borderWidth) {
        super(decoratee);
        this.borderWidth = borderWidth;
    }

    @Override
    public void draw() {
        super.draw();
        drawBorder();
    }

    private void drawBorder() {
        System.out.println(" ... drawing border with width " + borderWidth);
    }
}