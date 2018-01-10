//Farzyab Gohar
//101021301
public class PhonePlan {
    private int minutesAllowed;
    private int minutesUsed;
    private int dataAllowed;
    private int dataUsed;
    private boolean planType;

    public PhonePlan(int m, int mu, boolean p) {
        minutesAllowed = m;
        dataAllowed = mu;
        planType = p;
        minutesUsed = 0;
        dataUsed = 0;
    }
    public void setMinutesAllowed(int m) {
        minutesAllowed = m;
    }
    public void setMinutesUsed(int m) {minutesUsed = minutesUsed + m;
    }
    public void setDataAllowed(int m) {
        dataAllowed = m;
    }
    public void setDataUsed(int d) {dataUsed = dataUsed + d;}
    public void setPlanType(boolean p) {
        planType = p;
    }
    public int getMinutesAllowed() {
        return minutesAllowed;
    }
    public int getMinutesUsed() {
        return minutesUsed;
    }
    public int getDataAllowed() {
        return dataAllowed;
    }
    public int getDataUsed() {
        return dataUsed;
    }
    public boolean getPlanType() {
        return planType;
    }
    public int getMinutesRemaining() {
        return minutesAllowed - minutesUsed;
    }
    public int getDataRemaining() {
        return dataAllowed - dataUsed;
    }
    public String toString() {
        if (planType == true) {
            return "Pay-as-you-go Plan with " + getMinutesRemaining() + " minutes " + "and " +getDataRemaining() + "KB remaining";
        } else {
            return "Regular (" + getMinutesAllowed() + " minute, " + ((float)getDataAllowed() / 1000000) + "GB data) Monthly Plan with " + getMinutesRemaining() + " minutes remaining and " + getDataRemaining() + "KB remaining";
        }
    }
}
