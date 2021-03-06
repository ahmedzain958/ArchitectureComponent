package com.zain.alarmmanagerstandup.architecturecomponent;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * from note_table order by priority DESC")
    LiveData<List<Note>> getAllNotes();
}
