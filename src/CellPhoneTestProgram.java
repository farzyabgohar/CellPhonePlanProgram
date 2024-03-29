//Farzyab Gohar
//101021301
public class CellPhoneTestProgram {
    public static void main(String args[]) {

        CellPhone iPhone = new CellPhone("iPhone6Plus", "Apple", 12, 915);
        CellPhone galaxy = new CellPhone ("Galaxy S7", "Samsung", 18, 900);
        CellPhone priv = new CellPhone("Priv", "BlackBerry", 24, 890);
        System.out.println("Here is the Apple phone information:");
        System.out.println(iPhone.getModel());
        System.out.println(iPhone.getManufacturer());
        System.out.println(iPhone.getMonthsWarranty());
        System.out.println(iPhone.getPrice());
        System.out.println("\nHere is the Samsung phone information:");
        System.out.println(galaxy.getModel());
        System.out.println(galaxy.getManufacturer());
        System.out.println(galaxy.getMonthsWarranty());
        System.out.println(galaxy.getPrice());
        System.out.println("\nHere is the BlackBerry phone information:");
        System.out.println(priv.getModel());
        System.out.println(priv.getManufacturer());
        System.out.println(priv.getMonthsWarranty());
        System.out.println(priv.getPrice());

        iPhone.setModel("iPhoneSE");
        iPhone.setPrice(590);
        System.out.println("\nHere is the Apple phone's new information:");
        System.out.println(iPhone.getModel());
        System.out.println(iPhone.getManufacturer());
        System.out.println(iPhone.getMonthsWarranty());
        System.out.println(iPhone.getPrice());
        // Account for all cases? Same warranty?
        System.out.println("The total cost of all phones is $" + (iPhone.getPrice() + galaxy.getPrice() + priv.getPrice()));

        if (iPhone.getMonthsWarranty() > galaxy.getMonthsWarranty() && iPhone.getMonthsWarranty() > priv.getMonthsWarranty()) {
            System.out.println("The Apple phone has the longest warranty");
        } else if(galaxy.getMonthsWarranty() > iPhone.getMonthsWarranty() && galaxy.getMonthsWarranty() > priv.getMonthsWarranty()){
            System.out.println("The Samsung phone has the longest warranty");
        } else if (priv.getMonthsWarranty() > galaxy.getMonthsWarranty() && priv.getMonthsWarranty() > iPhone.getMonthsWarranty()){
            System.out.println("The BlackBerry phone has the longest warranty");
        }
    }
}
