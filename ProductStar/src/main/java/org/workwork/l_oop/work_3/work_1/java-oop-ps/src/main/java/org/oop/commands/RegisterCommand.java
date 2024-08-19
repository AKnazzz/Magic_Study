import IUserService;
import ICommand;
import BaseCommand;
import MainMenu;
import Injector;
import Role;

public class RegisterCommand extends BaseCommand {
    private final IUserService userService;

    public RegisterCommand() {
        this.userService = Injector.getInstance().getService(IUserService.class);
    }

    @Override
    public ICommand execute() {
        ioService.printLine("Регистрация нового пользователя");

        String username = ioService.prompt("Введите имя пользователя:");
        String password = ioService.prompt("Введите пароль:");
        String email = ioService.prompt("Введите email адрес:");

        try {
            boolean isRegistered = userService.register(username, password, email, Role.ADMIN);

            if (isRegistered) {
                ioService.printLine("Регистрация прошла успешно. Теперь вы можете войти в систему.");
            } else {
                ioService.printLine("Не удалось зарегистрироваться. Пользователь с таким именем уже существует.");
            }
        } catch (Exception e) {
            ioService.printLine("Ошибка при регистрации: " + e.getMessage());
        }

        return new MainMenu();
    }

    @Override
    public String getDescription() {
        return "Регистрация пользователя";
    }
}
