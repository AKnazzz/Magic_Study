package org.workwork.d_java_core_two.work_1_adapter.workshop.decorator.third;

// Основной класс для тестирования
public class Main {
    public static void main(String[] args) {
        // терминальный блок
        TerminatorBlock tBlock = new TerminatorBlock();

        // блок - процесс
        ProcessBlock pBlock = new ProcessBlock();

        // Применим LabelDecorator к терминальному блоку
        LabelBlockDecorator labelDecorator = new LabelBlockDecorator(tBlock, "Label222");

        // Применим BorderDecorator к терминальному блоку, после применения LabelDecorator
        BorderBlockDecorator borderDecorator1 = new BorderBlockDecorator(labelDecorator, 22);

        // Применим BorderDecorator к блоку - процессу
        BorderBlockDecorator borderDecorator2 = new BorderBlockDecorator(pBlock, 22);

        labelDecorator.draw();
        borderDecorator1.draw();
        borderDecorator2.draw();
    }
}
