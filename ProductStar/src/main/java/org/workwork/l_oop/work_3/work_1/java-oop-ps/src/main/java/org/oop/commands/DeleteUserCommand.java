import IAuthService;
import IUserService;
import ICommand;
import BaseCommand;
import UserMenu;
import Injector;
import User;

import java.util.Optional;

public class DeleteUserCommand extends BaseCommand {
    private final IUserService userService;
    private final IAuthService authService;

    public DeleteUserCommand() {
        this.userService = Injector.getInstance().getService(IUserService.class);
        this.authService = Injector.getInstance().getService(IAuthService.class);
    }

    @Override
    public ICommand execute() {
        ioService.printLine("Удаление пользователя:");

        Optional<String> username = promptOrReturn("Введите имя пользователя для удаления:");
        if (username.isEmpty()) return new UserMenu();

        User user = userService.getUserByUsername(username.get());

        if (authService.isCurrentUser(user)) {
            ioService.printLine("Нельзя удалить текущего пользователя.");
            return new UserMenu();
        }

        if (user == null) {
            ioService.printLine("Пользователь с таким именем не найден.");
        } else {
            boolean isDeleted = userService.deleteUserById(user.getId());
            if (isDeleted) {
                ioService.printLine("Пользователь успешно удален.");
            } else {
                ioService.printLine("Не удалось удалить пользователя.");
            }
        }

        return new UserMenu();
    }

    private Optional<String> promptOrReturn(String message) {
        String input = ioService.prompt(message);
        if ("back".equalsIgnoreCase(input)) {
            return Optional.empty();
        }
        return Optional.of(input);
    }

    @Override
    public String getDescription() {
        return "Удалить пользователя";
    }
}
