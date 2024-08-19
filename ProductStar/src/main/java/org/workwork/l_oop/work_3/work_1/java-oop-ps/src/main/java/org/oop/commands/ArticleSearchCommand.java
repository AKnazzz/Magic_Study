import IArticleService;
import ICommand;
import BaseCommand;
import MainMenu;
import Injector;
import Article;

import java.util.List;

public class ArticleSearchCommand extends BaseCommand {
    private final IArticleService articleService;

    public ArticleSearchCommand() {
        this.articleService = Injector.getInstance().getService(IArticleService.class);
    }

    @Override
    public ICommand execute() {
        String searchQuery = ioService.prompt("Введите название статьи для поиска: ");

        List<Article> articles = articleService.getArticlesByTitle(searchQuery);

        if (articles.isEmpty()) {
            ioService.printLine("Статьи с указанным названием не найдены.");
        } else {
            ioService.printLine("Найденные статьи:");
            ioService.printArticles(articles, Injector.getInstance().getService(IArticleService.class));
        }

        return new MainMenu();
    }

    @Override
    public String getDescription() {
        return "Найти статью";
    }

}