package com.example.hotelreservationsystem;

public class GuestRecyclerViewModel {

    private String guestNameTextInput;
    private int guestAgeTextInput;

    public GuestRecyclerViewModel(String guestNameTextInput, int guestAgeTextInput) {
        this.guestNameTextInput = guestNameTextInput;
        this.guestAgeTextInput = guestAgeTextInput;
    }

    public String getGuestNameTextInput() {
        return guestNameTextInput;
    }

    public void setGuestNameTextInput(String guestNameTextInput) {
        this.guestNameTextInput = guestNameTextInput;
    }

    public int getGuestAgeTextInput() {
        return guestAgeTextInput;
    }

    public void setGuestAgeTextInput(int guestAgeTextInput) {
        this.guestAgeTextInput = guestAgeTextInput;
    }
}
