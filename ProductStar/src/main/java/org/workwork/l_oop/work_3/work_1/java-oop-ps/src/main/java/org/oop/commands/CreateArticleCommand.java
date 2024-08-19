import IArticleService;
import ICommand;
import ArticleMenu;
import BaseCommand;
import Injector;

public class CreateArticleCommand extends BaseCommand {
    private final IArticleService articleService;

    public CreateArticleCommand() {
        this.articleService = Injector.getInstance().getService(IArticleService.class);
    }

    @Override
    public ICommand execute() {
        String title = ioService.prompt("Введите заголовок статьи: ");
        String content = ioService.prompt("Введите содержимое статьи: ");

        articleService.createArticle(title, content);

        ioService.printLine("Статья '" + title + "' была успешно создана.");

        return new ArticleMenu();
    }

    @Override
    public String getDescription() {
        return "Создать новую статью";
    }
}