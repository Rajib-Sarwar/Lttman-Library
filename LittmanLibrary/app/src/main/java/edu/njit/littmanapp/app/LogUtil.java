package edu.njit.littmanapp.app;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import edu.njit.littmanapp.BuildConfig;
import timber.log.Timber;

/**
 * Created by Samiran on 5/12/2018.
 *
 * @dependencies implementation 'com.jakewharton.timber:timber:4.7.1'
 */
public class LogUtil {


    public static void initializeLog(String tagName) {

        if (BuildConfig.DEBUG) {

            Timber.plant(new Timber.DebugTree() {
                @Override
                protected @Nullable
                String createStackElementTag(@NotNull StackTraceElement element) {
                    return tagName + ":[" + super.createStackElementTag(element) + ":" + element.getLineNumber() + "]";
                }
            });

        } else {
            //
        }
    }

}