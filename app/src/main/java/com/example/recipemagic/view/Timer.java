package com.example.recipemagic.view;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recipemagic.R;

import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

/**
 * This class creates the timer and handles the setting of the timer
 * and the countdown feature.
 */
public class Timer extends Fragment implements View.OnClickListener {
    public Timer() {
    }

    private String channel_id = "com.example.recipemagic.view.NOTIFICATION_CHANNEL";
    private EditText mEditTextInput;
    private TextView mTextViewCountDown;
    private Button mSetButton;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;
    private View layoutView;

    private long mStartTimeInMillis;
    private long mTimeLeftInMillis = mStartTimeInMillis;
    private long mEndTime;

    /*
     * This function creates the view of the fragment. When it is called it
     * displays the text fields and buttons to the screen.
     */
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutView = inflater.inflate(R.layout.fragment_timer, container, false);

        mEditTextInput = layoutView.findViewById(R.id.edit_text_input);
        mTextViewCountDown = layoutView.findViewById(R.id.timerDisplay);

        mSetButton = layoutView.findViewById(R.id.button_set);
        mButtonStartPause = layoutView.findViewById(R.id.start_button);
        mButtonReset = layoutView.findViewById(R.id.restart_button);

        //updateWatchInterface();



        mSetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String input = mEditTextInput.getText().toString();
                if (input.length() == 0) {
                    Toast.makeText(getContext(), "Field can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                long millisInput = Long.parseLong(input) * 60000;
                if (millisInput == 0) {
                    Toast.makeText(getContext(), "Please Enter a positive number", Toast.LENGTH_SHORT).show();
                    return;
                }

                setTime(millisInput);
                mEditTextInput.setText("");
            }
        });


        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountDownText();
        return layoutView;
    }

    /*
     * Set the time for the timer based on the input from the user.
     * default value is 00:00.
     */
    private void setTime(long milliseconds){
        mStartTimeInMillis = milliseconds;
        resetTimer();
    }

    /*
     * Starts the timer based on the value shown in the text field.
     */
    private void startTimer() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.bell);
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
                mp.start();
                mTimerRunning = false;
                updateWatchInterface();
                Toast.makeText(getContext(), "Timer Finished", Toast.LENGTH_SHORT).show();
                sendNotification(getView());
            }
        }.start();

        mTimerRunning = true;
        updateWatchInterface();
    }

    /*
     * This function pauses the timer.
     */
    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateWatchInterface();
    }

    /*
     * this function resets the timer back to the last value entered.
     */
    private void resetTimer() {
        mTimeLeftInMillis = mStartTimeInMillis;
        updateCountDownText();
        updateWatchInterface();
    }

    /*
     * this function updates the time left on the screen. it updates every second.
     */
    private void updateCountDownText() {
        int hours = (int) (mTimeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((mTimeLeftInMillis / 1000) %3600) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted;
        if (hours > 0){
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%02d:%02d", minutes, seconds);
        }

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    /*
     * this function determines what is done when each button is clicked.
     */
    @Override
    public void onClick(View v) {
        switch (layoutView.getId()) {
            case R.id.start_button:
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
                break;
            case R.id.restart_button:
                resetTimer();
                break;

        }
        updateCountDownText();
    }

    /*
     * This function changes the visibility and text of the buttons.
     */
    private void updateWatchInterface(){
        if(mTimerRunning){
            mEditTextInput.setVisibility(View.INVISIBLE);
            mSetButton.setVisibility(View.INVISIBLE);
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonStartPause.setText(getString(R.string.pause));
        } else {
            mEditTextInput.setVisibility(View.VISIBLE);
            mSetButton.setVisibility(View.VISIBLE);
            mButtonStartPause.setText(getString(R.string.start));

            if (mTimeLeftInMillis < 1000) {
                mButtonStartPause.setVisibility(View.VISIBLE);
            } else {
                mButtonStartPause.setVisibility(View.VISIBLE);
            }

            if (mTimeLeftInMillis < mStartTimeInMillis){
                mButtonReset.setVisibility(View.VISIBLE);
            } else {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }

    /*
     * saves time left on timer using the system time.
     * Saves into shared preferences.
     */
    @Override
    public void onStop() {
        super.onStop();

        SharedPreferences prefs = getActivity().getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("startTimeInMillis", mStartTimeInMillis);
        editor.putLong("millisLeft", mTimeLeftInMillis);
        editor.putBoolean("timerRunning", mTimerRunning);
        editor.putLong("endTime", mEndTime);

        editor.apply();

        if (mCountDownTimer != null){
            mCountDownTimer.cancel();
        }
    }

    /*
     * gets time left on timer when called.
     */
    @Override
    public void onStart(){
        super.onStart();

        SharedPreferences prefs = getActivity().getSharedPreferences("prefs", MODE_PRIVATE);

        mStartTimeInMillis = prefs.getLong("startTimeInMillis", 600000);
        mTimeLeftInMillis = prefs.getLong("millisLeft", mStartTimeInMillis);
        mTimerRunning = prefs.getBoolean("timerRunning", false);

        updateCountDownText();
        updateWatchInterface();

        if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0);
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();

            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0;
                mTimerRunning = false;
                updateCountDownText();
                updateWatchInterface();
            } else {
                startTimer();
            }
        }
    }

    public void sendNotification(View view) {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getActivity(), channel_id)

                .setSmallIcon(R.drawable.ic_launcher_foreground)

                .setContentTitle("Recipe Magic")

                .setContentText("Your Recipe Magic Timer has Finished!")

                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getActivity());


        notificationManagerCompat.notify(0, mBuilder.build());

        System.out.println("Finished Notification");
    }


        /**
         * Mandatory function to be implemented in each fragment.
         */
    interface OnFragmentInteractionListener {
    }
}