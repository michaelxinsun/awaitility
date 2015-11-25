/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jayway.awaitility.pollinterval;

import com.jayway.awaitility.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Generates a fixed (linear) poll interval based on the supplied duration
 */
public class FixedPollInterval implements PollInterval {

    private final Duration duration;

    /**
     * Create a new instance of the {@link FixedPollInterval}.
     *
     * @param duration The duration of the poll interval
     */
    public FixedPollInterval(Duration duration) {
        if (duration == null) {
            throw new IllegalArgumentException("Duration cannot be null");
        }
        this.duration = duration;
    }

    /**
     * Create a new instance of the {@link FixedPollInterval}.
     *
     * @param pollInterval The poll interval amount
     * @param unit         The time unit
     */
    public FixedPollInterval(long pollInterval, TimeUnit unit) {
        this(new Duration(pollInterval, unit));
    }

    public Duration next(int pollCount, Duration previousDuration) {
        return duration;
    }

    /**
     * Syntactic sugar for create a new instance of {@link FixedPollInterval}.
     *
     * @param duration The duration of the poll interval
     * @return A new instance of {@link FixedPollInterval}
     */
    public static FixedPollInterval fixed(Duration duration) {
        return new FixedPollInterval(duration);
    }

    /**
     * Syntactic sugar for create a new instance of {@link FixedPollInterval}.
     *
     * @param pollInterval The poll interval amount
     * @param unit         The time unit
     * @return A new instance of {@link FixedPollInterval}
     */
    public static FixedPollInterval fixed(long pollInterval, TimeUnit unit) {
        return new FixedPollInterval(pollInterval, unit);
    }
}
