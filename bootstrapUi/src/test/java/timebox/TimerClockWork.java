/**
 * Copyright (c) 2012-2017 Jens Deters http://www.jensd.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 *
 */
package timebox;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jens Deters
 */
public class TimerClockWork {

    private IntegerProperty minutes;
    private IntegerProperty seconds;
    private IntegerProperty milliSeconds;
    private LongProperty milliSecondsLeft;
    private BooleanProperty finished;
    private BooleanProperty running;
    private IntegerProperty startTime;
    private Calendar calendar;
    private Timeline timeline;
    private BooleanProperty overdueRunning;
    private BooleanProperty overdue;
    private Timeline overdueTimeline;
    private ObjectProperty<Mode> mode;

    public enum Mode {

        NORMAL, OVERDUE;
    }

    public TimerClockWork() {
        init();
    }

    private void init() {
        minutes = new SimpleIntegerProperty(0);
        seconds = new SimpleIntegerProperty(0);
        milliSeconds = new SimpleIntegerProperty(0);
        milliSecondsLeft = new SimpleLongProperty(0);
        finished = new SimpleBooleanProperty(Boolean.FALSE);
        running = new SimpleBooleanProperty(Boolean.FALSE);
        overdue = new SimpleBooleanProperty(Boolean.TRUE);
        overdueRunning = new SimpleBooleanProperty(Boolean.FALSE);
        running = new SimpleBooleanProperty(Boolean.FALSE);
        startTime = new SimpleIntegerProperty(0);
        calendar = new GregorianCalendar();
        mode = new SimpleObjectProperty<>();
        mode.set(Mode.NORMAL);
        //attachDebugOutput();
    }

    public BooleanProperty overdueOnProperty() {
        return overdue;
    }

    public BooleanProperty overdueRunningProperty() {
        return overdueRunning;
    }

    public ObjectProperty<Mode> modeProperty() {
        return mode;
    }

    public BooleanProperty runningProperty() {
        return running;
    }
    public boolean isRunning(){
        return runningProperty().get();
    }

    public BooleanProperty finishedProperty() {
        return finished;
    }

    public IntegerProperty minutesProperty() {
        return minutes;
    }

    public IntegerProperty secondsProperty() {
        return seconds;
    }

    public IntegerProperty milliSecondsProperty() {
        return milliSeconds;
    }

    public LongProperty milliSecondsLeftProperty() {
        return milliSecondsLeft;
    }

    public IntegerProperty startTimeProperty() {
        return startTime;
    }

    public void setStartTimeSeconds(int seconds) {
        startTime.set(seconds * 1000);
    }

    public void setStartTimeMillis(int milliseconds) {
        startTime.set(milliseconds);
    }

    public void setStartTimeMinutes(int minutes) {
        startTime.set(minutes * 60000);
    }

    public void start() {
        mode.set(Mode.NORMAL);
        overdueRunning.set(Boolean.FALSE);
        calendar.setTimeInMillis(startTime.get());
        milliSecondsLeft.set(calendar.getTimeInMillis());
        milliSeconds.set(calendar.get(Calendar.MILLISECOND));
        seconds.set(calendar.get(Calendar.SECOND));
        minutes.set(calendar.get(Calendar.MINUTE));
        finished.set(Boolean.FALSE);
        running.set(Boolean.TRUE);
        timeline = new Timeline(new KeyFrame(Duration.millis(1), tick()));
        timeline.setCycleCount(startTime.get());
        timeline.setOnFinished(finished());
        continuePlay();
    }

    public void continuePlay() {
        if (timeline != null) {
            timeline.play();
        }

    }

    public void pause() {
        if (timeline != null) {
            timeline.pause();
        }
    }

    public void stop() {
        if (timeline != null) {
            reset();
        }
    }

    public void reset() {
        if (timeline != null) {
            timeline.stop();
        }
        if (overdueTimeline != null) {
            overdueTimeline.stop();
        }
        milliSeconds.set(0);
        minutes.set(0);
        seconds.set(0);
        finished.set(Boolean.FALSE);
        running.set(Boolean.FALSE);
        overdueRunning.set(Boolean.FALSE);
        mode.set(Mode.NORMAL);
    }

    private EventHandler finished() {
        return (EventHandler<ActionEvent>) (ActionEvent t) -> {
            finished.set(Boolean.TRUE);
            running.set(Boolean.FALSE);
            if (overdue.get()) {
                startOverdue();
            }
        };
    }

    private void startOverdue() {
        mode.set(Mode.OVERDUE);
        calendar.setTimeInMillis(0);
        seconds.set(calendar.get(Calendar.SECOND));
        minutes.set(calendar.get(Calendar.MINUTE));
        finished.set(Boolean.FALSE);
        running.set(Boolean.TRUE);
        overdueRunning.set(Boolean.TRUE);
        overdueTimeline = new Timeline(new KeyFrame(Duration.millis(1), tick()));
        overdueTimeline.setCycleCount(600000);
        overdueTimeline.play();
    }

    private EventHandler tick() {
        return (EventHandler) (Event event) -> {
            calendar.setTimeInMillis(calendar.getTimeInMillis() - 1);
            milliSecondsLeft.set(calendar.getTimeInMillis());
            milliSeconds.set(calendar.get(Calendar.MILLISECOND));
            seconds.set(calendar.get(Calendar.SECOND));
            minutes.set(calendar.get(Calendar.MINUTE));
        };
    }

    private void attachDebugOutput() {
        startTime.addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
        });
        milliSeconds.addListener((ObservableValue<? extends Number> ov, Number t, Number t1) -> {
            String state = "normal";
            if (overdueRunning.get()) {
                state = "overdue";
            }
        });
        overdue.addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            System.out.
                    println("Overdue ON: " + t1);
        });
    }
}
