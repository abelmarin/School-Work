package com.example.civiladvocacy;

import android.util.JsonWriter;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.StringWriter;

public class Official {

    private String name;
    private String party;
    private String office;

    private String photo;

    // Contact info
    private String address;
    private String phoneNumber;
    private String email;
    private String website;
    private String facebook;
    private String twitter;
    private String youtube;

    Official(String name, String party, String office) {
        this.name = name;
        this.party = party;
        this.office = office;

        this.address = "";
        this.phoneNumber = "";
        this.email = "";
        this.website = "";
        this.facebook = "";
        this.twitter = "";
        this.youtube = "";
    }

    // Setters
    public void setPhoto(String photo) { this.photo = photo; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setWebsite(String website) { this.website = website; }
    public void setFacebook(String facebook) { this.facebook = facebook; }
    public void setTwitter(String twitter) { this.twitter = twitter; }
    public void setYoutube(String youtube) { this.youtube = youtube; }

    // Getters
    public String getName() { return name; }
    public String getParty() { return party; }
    public String getOffice() { return office; }
    public String getPhoto() { return photo; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getWebsite() { return website; }
    public String getFacebook() { return facebook; }
    public String getTwitter() { return twitter; }
    public String getYoutube() { return youtube; }

    @NonNull
    public String toString() {
//        try {
//            StringWriter sw = new StringWriter();
//            JsonWriter jsonWriter = new JsonWriter(sw);
//            jsonWriter.setIndent("  ");
//            jsonWriter.beginObject();
//            jsonWriter.name("symbol").value(getSymbolName());
//            jsonWriter.name("stock_price").value(getStockPrice());
//            jsonWriter.name("stock_price_changed").value(getStockPriceChange());
//            jsonWriter.name("company").value(getCompanyName());
//            jsonWriter.endObject();
//            jsonWriter.close();
//            return sw.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
//        }

        return office + " " + name + " (" + party + ")";
    }

}
