import entities.TodoList;
import repositories.TodoListRepository;
import repositories.TodoListRepositoryimpl;
import services.TodoListService;
import services.TodoListServiceimpl;
import views.TodoListTerminalView;
import views.TodoListView;

public class Main {
    public static void main(String[] args) {
        TodoListRepository todoListRepository = new TodoListRepositoryimpl();
        TodoListService todoListService = new TodoListServiceimpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalView(todoListService);
        todoListView.run();

    }
}