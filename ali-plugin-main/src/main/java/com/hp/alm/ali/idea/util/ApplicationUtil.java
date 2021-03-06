/*
 * Copyright 2013 Hewlett-Packard Development Company, L.P
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hp.alm.ali.idea.util;

import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.TestOnly;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class ApplicationUtil {

    private static Application application = new DefaultApplication();

    public static void invokeLater(Runnable runnable) {
        application.invokeLater(runnable);
    }

    public static void executeOnPooledThread(Runnable runnable) {
        application.executeOnPooledThread(runnable);
    }

    public static <T> Future<T> executeOnPooledThread(Callable<T> callable) {
        return application.executeOnPooledThread(callable);
    }

    public static void invokeLaterIfNeeded(Runnable runnable) {
        application.invokeLaterIfNeeded(runnable);
    }

    @TestOnly
    public static void _setApplication(Application app) {
        application = app;
    }

    public static interface Application {

        void invokeLater(Runnable runnable);

        void executeOnPooledThread(Runnable runnable);

        <T> Future<T> executeOnPooledThread(Callable<T> callable);

        void invokeLaterIfNeeded(Runnable runnable);

    }

    private static class DefaultApplication implements Application {

        @Override
        public void invokeLater(Runnable runnable) {
            com.intellij.openapi.application.ApplicationManager.getApplication().invokeLater(runnable);
        }

        @Override
        public void executeOnPooledThread(Runnable runnable) {
            com.intellij.openapi.application.ApplicationManager.getApplication().executeOnPooledThread(runnable);
        }

        @Override
        public <T> Future<T> executeOnPooledThread(Callable<T> callable) {
            return com.intellij.openapi.application.ApplicationManager.getApplication().executeOnPooledThread(callable);
        }

        @Override
        public void invokeLaterIfNeeded(Runnable runnable) {
            UIUtil.invokeLaterIfNeeded(runnable);
        }
    }
}


