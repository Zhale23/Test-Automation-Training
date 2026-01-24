package org.example.config;

import java.time.Duration;

public class JsTestConfig {
    public static class Environment{
        public static final String PRODUCTION_URL = "https://the-internet.herokuapp.com/javascript_alerts";
        public static final String GLOBAL_BROWSER = "chrome";
        public static final Duration GLOBAL_WAIT_TIMEOUT = Duration.ofSeconds(15);
        public static final Duration GLOBAL_ACTION_KEY_SEQUENCE_DELAY = Duration.ofMillis(200);
    }
}
