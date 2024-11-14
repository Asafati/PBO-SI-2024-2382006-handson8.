import config.Database;
import entities.TodoList;
import repositories.TodoListRepository;
import repositories.TodoListRepositoryDbImpl;
import services.TodoListService;
import services.TodoListServiceImpl;
import views.TodoListTerminalView;
import views.TodoListView;

public class Main {
    public static void main(String[] args) {
        // Membuat objek Database dengan parameter yang sesuai
        Database database = new Database("databaseku", "root", "", "localhost", "3306");
        database.setup();  // Setup koneksi database

        // Membuat objek TodoListRepository yang terhubung ke database
        TodoListRepository todoListRepository = new TodoListRepositoryDbImpl(database);

        // Membuat service dan view
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalView(todoListService);

        // Menjalankan aplikasi
        todoListView.run();
    }
}
