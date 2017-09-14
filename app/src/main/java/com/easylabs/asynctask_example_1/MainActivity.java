package com.easylabs.asynctask_example_1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.bt1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        MyAsyncTask myAsyncTask2 = new MyAsyncTask();
        // Запуск нескольних AsyncTask одновременно
        myAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        myAsyncTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        // Завершение потока
        // myAsyncTask.cancel(true);

        // Получат состояние потока
        // myAsyncTask.getStatus();

        // Состояния потока
        // AsyncTask.Status.RUNNING; - поток работает
        // AsyncTask.Status.FINISHED; - поток отработал
        // AsyncTask.Status.PENDING; - ещё не запускался

        // if (myAsyncTask.getStatus() != AsyncTask.Status.RUNNING)
        //     myAsyncTask.execute();
    }

    public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        int i = 0;

        // Метод вызываем непосредственно перед началом вычислений
        // ИМЕЕТ ДОСТУП К UI-ПОТОКУ
        // Вызывается первым
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            bt1.setText("Поток запущен");
        }

        // Основной метод класса AsyncTask, в котором происходят вычисления
        // НЕ ИМЕЕТ ДОСТУПА К UI-ПОТОКУ
        // Вызывается вторым
        @Override
        protected Void doInBackground(Void... voids) {
            // А теперь, представьте, что мы выполняем веб-запрос
            try {
                // Какие-то долгие вычисления
                for (int j = 0; j < 100; j++) {
                    Thread.sleep(50);
                    i = j;
                    // Вызывет метод onProgressUpdate
                    publishProgress();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        // Вызывается непросредственно после вычислений
        // ИМЕЕТ ДОСТУП К UI-ПОТОКУ
        // Вызывается третим
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            bt1.setText("Поток успешно отработал");
        }

        // Необходимо ЯВНО вызывать из методов класса AsyncTask
        // ИМЕЕТ ДОСТУ К UI
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(i);
        }
    }

}