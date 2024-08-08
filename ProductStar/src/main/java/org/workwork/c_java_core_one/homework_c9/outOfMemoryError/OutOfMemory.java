package org.workwork.c_java_core_one.homework_c9.outOfMemoryError;

import java.util.Map;

public class OutOfMemory {

    public static void main(String[] args) {
        kill();
    }

    static class BadKey {
        // no hashCode or equals();
        public final String key;

        public BadKey(String key) {
            this.key = key;
        }
    }

    public static void kill() {
        Map map = System.getProperties();
        while (true) {
            map.put(new BadKey("key"), "value"); // Memory leak even if your threads die.
        }
    }

}