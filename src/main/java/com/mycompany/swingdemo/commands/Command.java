package com.mycompany.swingdemo.commands;

import javax.swing.SwingWorker;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public abstract class Command<T> {

    public Observable<T> execute() {
        return Observable.create(emitter -> {
            new CommandWorker(emitter).execute();
        });
    }

    protected abstract T runCommand() throws Exception;

    protected class CommandWorker extends SwingWorker<T, Object> {

        private T result;
        private ObservableEmitter<T> emitter;

        public CommandWorker(ObservableEmitter<T> emitter) {
            this.emitter = emitter;
        }

        @Override
        protected T doInBackground() throws Exception {
            result = runCommand();
            return result;
        }

        @Override
        protected void done() {
            this.emitter.onNext(result);
            this.emitter.onComplete();
        }

    }

}