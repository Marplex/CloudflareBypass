package it.marplex.cloudflarebypass.util

import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

/**
 * Class containing all methods used to evaluate and run javascript.
 * This class could be easily changed in order to port the library to other platforms (es: Android)
 */
class JavascriptEvaluator {

    /**
     * Evaluates javascript
     *
     * @param javascript Code to evaluate
     * @return Evaluated string result
     */
    fun evaluateString(javascript: String): String {
        val rhino = Context.enter()
        rhino.optimizationLevel = -1

        val scope = rhino.initStandardObjects() as Scriptable
        return rhino.evaluateString(scope, javascript, "JavaScript", 1, null).toString()
    }

}