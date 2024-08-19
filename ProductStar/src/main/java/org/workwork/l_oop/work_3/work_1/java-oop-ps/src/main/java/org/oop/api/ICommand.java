public interface ICommand {
    ICommand execute();

    String getDescription();
}
