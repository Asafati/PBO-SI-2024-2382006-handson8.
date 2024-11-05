package views;

import java.util.Scanner;
import service.TodoListService;

public class TodoListTerminalView implements TodoListView{
    public static Scanner scanner = new Scanner(source: System.in);
    private final TodoListService todoListService;

    public TodoListTerminalView(final TodoListService todoListService){
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        System.out.println("TODO LIST");
        TodoList[] todos = todoListService.getTodoList();
        for (var i = 0; i < todos.length; i++) {
            var todo = todos[i];
            if (todo != null) {
                System.out.println((i + 1) + ". " + todo.getTodo());
            }
        }
    }
    public void showMainMenu() {
        // infinite loop so the program will always run
        boolean isRunning = true;
        while (isRunning) {
            showTodoList();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Edit");
            System.out.println("4. Keluar");
            // input untuk menerima input dari user
            String selectedMenu = input("Pilih");

            switch (selectedMenu) {
                case "1":
                    showMenuAddTodoList();
                    break;
                case "2":
                    showMenuRemoveTodoList();
                    break;
                case "3":
                    showMenuEditTodoList();
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }
    @Override
    public void run(){
        showMainMenu();
    }

}
