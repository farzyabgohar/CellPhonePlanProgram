//Farzyab Gohar
//101021301
public class Customer {
    private String name;
    private CellPhone cellPhone;
    private PhonePlan plan;
    private int callsMade = 0;
    private float balance = 0.0f;

    public Customer(String n, CellPhone ph , PhonePlan p) {
        name = n;
        cellPhone = ph;
        plan = p;
        if (plan.getPlanType() == false) {
            balance = 0;
        } else {
            balance = 0.40f * (plan.getMinutesAllowed()); // $0.4 per minute for pay as you go customers.
        }
    }
    public void setName(String n) {
        name = n;
    }
    public void setCellPhone(CellPhone ph) {
        cellPhone = ph;
    }
    public void setPlan (PhonePlan p) {
        plan = p;
    }

    public String getName() {
        return name;
    }
    public CellPhone getCellPhone() {
        return cellPhone;
    }
    public PhonePlan getPlan(){
        return plan;
    }
    public String toString() {
        return name + " with a " + cellPhone.getManufacturer() + " " + cellPhone.getModel() + " on a " + plan;
    }
    public void phone(Customer c, int m) {
        if (m>=1){ //validation check for minimum 1 minute phone call
            if (plan.getPlanType() == true | c.plan.getPlanType() == true){ //checks if plan type is pay as you go
                //only runs when both caller and receiver still have minutes remaining
                // updates minutes used and calls made if call successful.
                if (m<=plan.getMinutesRemaining() && m<=c.plan.getMinutesRemaining()) {
                    plan.setMinutesUsed(m);
                    c.plan.setMinutesUsed(m);
                    callsMade = callsMade + 1;
                    c.callsMade = c.callsMade + 1;
                }
            } else { //else statement for when both callers are on regular plans.
                plan.setMinutesUsed(m);
                c.plan.setMinutesUsed(m);
                callsMade = callsMade + 1;
                c.callsMade = callsMade + 1;
            }
        }
    }
    public void buyMinutes(int purchase) {
        if (plan.getPlanType() == true) { //only runs for people with pay-as-you-go plan.
            balance = balance + (0.40f * purchase); //updates balance
            plan.setMinutesAllowed((plan.getMinutesAllowed() + purchase)); //updates minutes allowed
        }
    }
    public void accessInternet(int kb) {
        if (plan.getPlanType() == true) { //checks for plan type.
            //so what the if else statement below does is check if the amount of data used is higher than the customer's
            //allowed data limit. If it isn't, then it simply updates data used.
            //if customer goes above limit, then it just sets customer's data used to his data allowed
            //which would result in the getdataremaining method returning a value of 0, since the customer has used
            //all of his/her available data.
            if (kb < plan.getDataAllowed()) {
                plan.setDataUsed(kb);
            } else if (kb > plan.getDataRemaining() && !(plan.getDataRemaining() == 0)) {
                plan.setDataUsed(plan.getDataAllowed() - plan.getDataUsed());
            }
        } else { //method works normally for regular customers. simply updates data used
            plan.setDataUsed(kb);
        }
    }
    public void printMonthlyStatement() {
        if (plan.getPlanType() == false) { //for regular plans
            System.out.println();
            System.out.println(String.format("%-24s%s", "Name:", name));
            System.out.println(String.format("%-24s%s", "Plan Type:", ("Regular Monthly (" + plan.getMinutesAllowed() + " minutes, " +
                    ((float) plan.getDataAllowed() / 1000000) + "GB data)")));
            System.out.println(String.format("%-24s%s", "Minutes Used:", plan.getMinutesUsed()));
            System.out.println(String.format("%-24s%s", "Data Used:", plan.getDataUsed()));
            System.out.println(String.format("%-24s%s", "Calls Made:", callsMade));

            float mc = 0.00f;
            if (plan.getMinutesAllowed() == 200) {
                mc = 25f;
            } else {
                mc = 15f;
            }
            float md = (float) plan.getDataAllowed() / 100000;
            mc = mc + md;
            System.out.println(String.format("%-24s$%.2f", "Monthly Charges:" , mc));

            float votc = 0.0f;
            if (plan.getMinutesUsed() > plan.getMinutesAllowed()) {
                votc = 0.15f * (plan.getMinutesUsed() - plan.getMinutesAllowed());
            }
            System.out.println(String.format("%-24s$%.2f", "Voice Overtime Charges:", votc));
            float doc = 0.0f;
            if (plan.getDataUsed() > plan.getDataAllowed()) {
                doc = doc + (0.00005f * (plan.getDataUsed() - plan.getDataAllowed()));
            }
            System.out.println(String.format("%-24s$%.2f", "Data Overusage Charges:",doc));

            float totalBT = mc + votc + doc;
            float totalAT = totalBT + (0.13f * totalBT);
            System.out.println(String.format("%-24s$%.2f", "HST:", (0.13f * totalBT)));
            System.out.println(String.format("%-24s$%.2f", "Total Due:", totalAT));
        } else {
            System.out.println();
            System.out.println(String.format("%-24s%s", "Name:", name));
            System.out.println(String.format("%-24s%s", "Plan Type:", "Pay-as-you-go"));
            System.out.println(String.format("%-24s%s", "Minutes Used:", plan.getMinutesUsed()));
            System.out.println(String.format("%-24s%s", "Minutes Remaining:", plan.getMinutesRemaining()));
            System.out.println(String.format("%-24s%s", "Data Used:", plan.getDataUsed()));
            System.out.println(String.format("%-24s%s", "Data Remaining:", plan.getDataRemaining()));
            System.out.println(String.format("%-24s%s", "Calls Made:", callsMade));
            System.out.println(String.format("%-24s$%1.2f", "Monthly Charges:", balance));
            System.out.println(String.format("%-24s$%1.2f", "HST:", 0.13f * balance));
            float total = balance + (0.13f * balance);
            System.out.println(String.format("%-24s$%1.2f", "Total Due:", total));

        }
    }
}
