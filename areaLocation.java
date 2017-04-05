/**
 * Created by nashm on 29/03/2017.
 */
public class areaLocation {
    private int id;
    private String country;
    private String region;
    private String city;
    private String latitude;
    private String longitude;

    public areaLocation(){}

    public areaLocation(int id, String co, String re, String ci,  String lat, String lon){
        this.id = id;
        this.country = co;
        this.region = re;
        this.city = ci;
        this.latitude = lat;
        this.longitude = lon;
    }

    /*public areaLocation(int id, String co, String re, String ci, String pc, float lat, float lon){
        this.id = id;
        this.country = co;
        this.region = re;
        this.city = ci;
        this.postalCode = pc;
        this.latitude = lat;
        this.longitude = lon;
    }*/
/***********Setters********************/

    public void setId(int newid){
        this.id = newid;
    }
    public void setCountry(String co){
        this.country = co;
    }

    public void setRegion(String re){
        this.region = re;
    }

    public void setCity(String ci){
        this.city = ci;
    }

   /* public void setPostalCode(String pc){
        this.postalCode = pc;
    }*/

    public void setLatitude(String la){
        this.latitude = la;
    }

    public void setLongitude(String lo){
        this.longitude = lo;
    }

   /* public void setMetroCode(int mc){
        this.metroCode = mc;
    }

    public void setAreaCode(int ac){
        this.areaCode = ac;
    }*/
/*************************************/

/**************Getters****************/
    public int getId(){
        return id;
    }

    public String getCountry(){
        return country;
    }

    public String getRegion(){
        return region;
    }

    public String getCity(){
        return city;
    }

   /* public String getPostalCode(){
        return postalCode;
    }*/

    public String getLatitude(){
        return latitude;
    }

    public String getLongitude(){
        return longitude;
    }

  /*  public int getMetroCode(){
        return metroCode;
    }

    public int getAreaCode(){
        return areaCode;
    }*/
/*************************************/
}
