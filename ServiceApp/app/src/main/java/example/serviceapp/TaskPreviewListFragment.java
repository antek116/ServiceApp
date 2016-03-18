package example.serviceapp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Class implementation of Task Preview List Screen Fragment
 */
public class TaskPreviewListFragment extends Fragment implements OnTasksUpdate{
    @Override
    public void onTaskAdded(Task task) {
        taskPreviewAdapter.addItem(task);
    }

    @Override
    public void onTaskFinished(Task task) {
        taskPreviewAdapter.changeItem(task);
    }

    @Override
    public void onTaskProgress(Task task) {
        taskPreviewAdapter.removeItem(task);
    }
    private TasksPreviewListAdapter taskPreviewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.task_preview_list_layout, container, false);
        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.allTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(taskPreviewAdapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        taskPreviewAdapter = new TasksPreviewListAdapter();
    }
}
