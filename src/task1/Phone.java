package task1;

public class Phone {
    private Network phoneNet;
    private String phoneNumber;

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        phoneNet = new Network();
    }

    public void registration() {
        if (!isRegistered()) {
            phoneNet.setRegistration(true);
            System.out.println(phoneNumber + ": Your phone number successfully registered in the net.");
        }
    }

    public void outgoingCall(Phone anotherPhone) {
        if (!isRegistered())
            System.out.println(phoneNumber + ": Your phone number doesn't registered in the net!");
        else if (!anotherPhone.isRegistered())
            System.out.println(phoneNumber + ": " + anotherPhone.getPhoneNumber() + " doesn't registered in the net!");
        else {
            System.out.println(phoneNumber + ": You're calling to " + anotherPhone.getPhoneNumber());
            anotherPhone.incomingCall(this);
        }
    }

    private void incomingCall(Phone anotherPhone) {
        System.out.println(phoneNumber + ": You have an incoming call from " + anotherPhone.getPhoneNumber());
    }

    private boolean isRegistered() {
        return phoneNet.getRegistration();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
