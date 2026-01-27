package org.example.suite;

import org.example.hooks.JsTestHooks;
import org.testng.annotations.Test;


public class JsAlertPromptTest extends JsTestHooks {
    @Test
    public void testJsAlertPrompt() {
        theInternet.homePage().jsAlertTestFinal();
    }
}
