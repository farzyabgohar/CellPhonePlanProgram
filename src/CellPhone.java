//Farzyab Gohar
//101021301
public class CellPhone {
    private String model;
    private String manufacturer;
    private int monthsWarranty;
    private float price;

    public CellPhone() {
        model = "UNKNOWN";
        manufacturer = "UNKNOWN";
        monthsWarranty = 0;
        price = 0.0f;

    }
    public CellPhone(String m, String mf, int mw, float p) {
        model = m;
        manufacturer = mf;
        monthsWarranty = mw;
        price = p;
    }
    public String getModel() {
        return model;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public int getMonthsWarranty(){
        return monthsWarranty;
    }
    public float getPrice(){
        return price;
    }
    public void setModel(String m) {
        model = m;
    }
    public void setManufacturer(String mf){
        manufacturer = mf;
    }
    public void setMonthsWarranty(int mw){
        monthsWarranty = mw;
    }
    public void setPrice(float p){
        price = p;
    }
}
