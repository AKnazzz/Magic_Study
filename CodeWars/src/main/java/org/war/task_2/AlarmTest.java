package org.war.task_2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlarmTest {

    @Test
    public void setAlarmTest() {
        assertTrue("Should be true.", Alarm.setAlarm(true, false));
        assertFalse("Should be false.", Alarm.setAlarm(true, true));
        assertFalse("Should be false.", Alarm.setAlarm(false, false));
        assertFalse("Should be false.", Alarm.setAlarm(false, true));
    }

}