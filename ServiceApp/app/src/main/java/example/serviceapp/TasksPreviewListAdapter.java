package example.serviceapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Class implementation of TasksPreviewListAdapter.
 */
public class TasksPreviewListAdapter extends RecyclerView.Adapter<TasksPreviewListAdapter.ViewHolder> {
    ArrayList<Task> listOfTasks;

    public TasksPreviewListAdapter() {
        listOfTasks = new ArrayList<>();
    }

    public void addItem(Task task) {
        listOfTasks.add(task);
        notifyItemInserted(listOfTasks.size() - 1);
    }

    public void removeItem(Task task) {
        listOfTasks.remove(task);
        notifyItemRemoved(findTaskPositionInList(task));
    }
    public void changeItem(Task task){
        int itemIndex;
        if((itemIndex = findTaskPositionById(task.getTaskId())) != -1){
            listOfTasks.remove(itemIndex);
        }
    }

    public int findTaskPositionInList(Task task) {

        return listOfTasks.indexOf(task);
    }
    public int findTaskPositionById(int taskId){
        Task foundedTask;
        for(Task task : listOfTasks)
        {
            if(task.getTaskId() == taskId){
                foundedTask = task;
                return listOfTasks.indexOf(foundedTask);
            }
        }
        return -1;
    }

    @Override
    public TasksPreviewListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_element_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksPreviewListAdapter.ViewHolder holder, int position) {
        holder.mTitle.setText(this.listOfTasks.get(position).getTaskDuration());
        holder.progresBar.setProgress(this.listOfTasks.get(position).getTaskTime());
    }

    @Override
    public int getItemCount() {
        return this.listOfTasks.size();
    }

    /**
     * class of ViewHolder implementation.
     * Use to remember each element in list.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitle;
        public final ProgressBar progresBar;

        /**
         * Constructor where we set reference to layout of progressbar and TextView.
         *
         * @param view instance of view.
         */
        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitle = (TextView) view.findViewById(R.id.taskTitle);
            progresBar = (ProgressBar) view.findViewById(R.id.taskProgressBar);
        }

        /**
         * @return text as String from titleTextView.
         */
        @Override
        public String toString() {
            return super.toString() + " '" + mTitle.getText() + "'";
        }
    }

}
