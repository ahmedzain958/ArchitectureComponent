package com.zain.alarmmanagerstandup.architecturecomponent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.zain.alarmmanagerstandup.R;

public class NoteAdapter extends ListAdapter<Note, NoteAdapter.NoteViewHolder> {

    private static final DiffUtil.ItemCallback<Note> DIFF_CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())
                    && oldItem.getDescription().equals(newItem.getDescription())
                    && oldItem.getPriority() == newItem.getPriority();
        }
    };

    public NoteAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_item, viewGroup, false);
        return new NoteViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int position) {
        noteViewHolder.noteTitle.setText(getItem(position).getTitle());
        noteViewHolder.noteDesc.setText(getItem(position).getDescription());
        noteViewHolder.notePriority.setText(String.valueOf(getItem(position).getPriority()));
    }

    public Note getNoteAt(int adapterPosition) {
        return getItem(adapterPosition);
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView noteTitle;
        TextView noteDesc;
        TextView notePriority;


        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.text_view_title);
            noteDesc = itemView.findViewById(R.id.text_view_description);
            notePriority = itemView.findViewById(R.id.text_view_priority);
        }
    }
}
