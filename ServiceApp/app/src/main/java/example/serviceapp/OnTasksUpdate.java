package example.serviceapp;

/**
 * Interface of Tasks Update Listener.
 */
public interface OnTasksUpdate {

    void onTaskAdded(Task task);
    void onTaskFinished(Task task);
    void onTaskProgress(Task task);
}
