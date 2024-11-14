package repositories;

import entities.TodoList;
import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryDbImpl implements TodoListRepository {
    private final Database database;

    public TodoListRepositoryDbImpl(final Database database) {
        this.database = database;
    }

    @Override
    public TodoList[] getAll() {
        List<TodoList> todoList = new ArrayList<>();
        try (Connection connection = database.getConnection()) {
            String sqlStatement = "SELECT * FROM todos";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TodoList todoItem = new TodoList();
                Integer id = resultSet.getInt(1);
                String todo = resultSet.getString(2);
                todoItem.setId(id);
                todoItem.setTodo(todo);
                todoList.add(todoItem);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return todoList.toArray(new TodoList[0]);
    }

    @Override
    public void add(TodoList todoList) {
        // Implementasi tambahan untuk metode add
    }

    @Override
    public Boolean remove(Integer id) {
        return null;
    }

    @Override
    public Boolean edit(TodoList todoList) {
        return null;
    }
}
