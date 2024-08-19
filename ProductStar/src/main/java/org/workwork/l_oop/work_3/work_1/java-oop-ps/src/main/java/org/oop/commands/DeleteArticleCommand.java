import IArticleService;
import ICommand;
import ArticleMenu;
import BaseCommand;
import Injector;

public class DeleteArticleCommand extends BaseCommand {
    private final IArticleService articleService;

    public DeleteArticleCommand() {
        this.articleService = Injector.getInstance().getService(IArticleService.class);
    }

    @Override
    public ICommand execute() {
        long articleId = Long.parseLong(ioService.prompt("Введите ID статьи для удаления: "));

        boolean isDeleted = articleService.deleteArticle(articleId);
        if (isDeleted) {
            ioService.printLine("Статья с ID " + articleId + " была удалена.");
        } else {
            ioService.printLine("Статью с ID " + articleId + " не удалось найти или удалить.");
        }

        return new ArticleMenu();
    }

    @Override
    public String getDescription() {
        return "Удалить существующую статью";
    }
}