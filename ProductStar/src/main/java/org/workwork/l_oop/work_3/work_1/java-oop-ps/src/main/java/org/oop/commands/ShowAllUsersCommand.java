import IUserService;
import ICommand;
import BaseCommand;
import UserMenu;
import Injector;
import User;

import java.util.List;

public class ShowAllUsersCommand extends BaseCommand {
    private final IUserService userService;

    public ShowAllUsersCommand() {
        this.userService = Injector.getInstance().getService(IUserService.class);
    }

    @Override
    public ICommand execute() {
        ioService.printLine("Список пользователей:");
        ioService.printUserTableHeader();
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            ioService.printLine("| Список пользователей пуст.                                         |");
        } else {
            users.forEach(user -> ioService.printLine(user.toString()));
        }
        ioService.printLine("+------------+----------------------+--------------------------------+------------+");

        return new UserMenu();
    }

    @Override
    public String getDescription() {
        return "Показать всех пользователей";
    }
}