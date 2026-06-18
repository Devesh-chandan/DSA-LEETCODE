class Solution {
    public double angleClock(int hour, int minutes) {
        //Hour hand moves 30° per hour (360 / 12)
        //Hour hand also moves 0.5° per minute (30 / 60)
        //Minute hand moves 6° per minute (360 / 60)
        if (hour == 12) {
            hour = 0;
        }

        double hourAngle = hour * 30 + minutes * 0.5;
        double minuteAngle = minutes * 6;

        double diff = Math.abs(hourAngle - minuteAngle);

        return Math.min(diff, 360 - diff);
    }
}