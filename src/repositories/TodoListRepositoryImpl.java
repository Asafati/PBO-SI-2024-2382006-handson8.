package repositories;

import entities.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {
    private TodoList[] todoLists = new TodoList[10]; // contoh implementasi sederhana

    @Override
    public TodoList[] getAll() {
        return todoLists;
    }

    @Override
    public void add(TodoList todoList) {
        // Cari tempat kosong di array
        for (int i = 0; i < todoLists.length; i++) {
            if (todoLists[i] == null) { // Menemukan tempat kosong
                todoLists[i] = todoList; // Menambahkan todoList
                todoList.setId(i + 1); // Memberikan ID sesuai urutan
                break;
            }
        }
    }



    @Override
    public Boolean remove(Integer id) {
        // Mencari todo berdasarkan ID
        for (int i = 0; i < todoLists.length; i++) {
            if (todoLists[i] != null && todoLists[i].getId() == id) {
                // Menghapus elemen dengan menggeser yang berikutnya
                for (int j = i; j < todoLists.length - 1; j++) {
                    todoLists[j] = todoLists[j + 1];  // Geser ke kiri
                }
                todoLists[todoLists.length - 1] = null; // Menghapus elemen terakhir
                return true;  // Penghapusan berhasil
            }
        }
        return false;  // ID tidak ditemukan
    }



    @Override
    public Boolean edit(TodoList todoList) {
        for (int i = 0; i < todoLists.length; i++) {
            if (todoLists[i] != null && todoLists[i].getId() == todoList.getId()) {
                todoLists[i].setTodo(todoList.getTodo()); // Mengubah todo berdasarkan ID
                return true; // Berhasil mengedit
            }
        }
        return false; // Tidak ditemukan ID yang cocok
    }

}