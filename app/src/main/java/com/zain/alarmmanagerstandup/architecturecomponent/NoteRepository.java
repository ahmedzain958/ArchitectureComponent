package com.zain.alarmmanagerstandup.architecturecomponent;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;

import java.util.List;

 class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

     NoteRepository(Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        noteDao = noteDatabase.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

     void deleteNote(Note note) {
        new DeletingNote(noteDao).execute(note);
    }

     void insertNote(Note note) {
        new InsertingNote(noteDao).execute(note);
    }

     void updateNote(Note note) {
        new UpdatingNote(noteDao).execute(note);
    }

     void deleteAllNotes() {
        new DeleteAllNotes(noteDao).execute();
    }


    //static inner classes prevents leaking memory because it keeps its enclosing fragment/activity reference and
    // in case of long running operations it keeps the enclosing class reference and its implications is mem leak
    static class DeletingNote extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        DeletingNote(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }

    }

    static class InsertingNote extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

         InsertingNote(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }

    }

    static class UpdatingNote extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

         UpdatingNote(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }

    }

    static class DeleteAllNotes extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

         DeleteAllNotes(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }

    }
}
