package com.example.assignment1java;

import javafx.fxml.FXML;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TaskHelloController {
    @FXML
    private TableView<Task> taskTable;
    @FXML
    private ComboBox<String> filterComboBox;
    @FXML
    private Button addTaskButton;
    @FXML
    private Button editTaskButton;
    @FXML
    private Button deleteTaskButton;

    private ObservableList<Task> taskList;

    public TaskHelloController() {
        // Initialize taskList with your tasks
        taskList = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        // Configure the TableView columns
        TableColumn<Task, String> nameColumn = new TableColumn<>("Task Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Task, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Task, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        taskTable.getColumns().setAll(nameColumn, descriptionColumn, statusColumn);

        // Populate the TableView with data
        taskTable.setItems(taskList);
    }

    @FXML
    public void addTask() {
        // Implement code to add a new task to taskList
        taskList.add(new Task("New Task", "Description", "Pending"));
    }

    @FXML
    public void editTask() {
        // Implement code to edit the selected task
        Task selectedTask = taskTable.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            // Open an editing dialog or form
        }
    }

    @FXML
    public void deleteTask() {
        // Implement code to delete the selected task
        Task selectedTask = taskTable.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            taskList.remove(selectedTask);
        }
    }

    @FXML
    public void filterTasks() {
        // Implement code to filter tasks based on the selected status
        String selectedStatus = filterComboBox.getValue();
        if (selectedStatus.equals("All")) {
            // Show all tasks
            taskTable.setItems(taskList);
        } else {
            // Filter tasks based on the selected status
            ObservableList<Task> filteredTasks = FXCollections.observableArrayList();
            for (Task task : taskList) {
                if (task.getStatus().equals(selectedStatus)) {
                    filteredTasks.add(task);
                }
            }
            taskTable.setItems(filteredTasks);
        }
    }
}