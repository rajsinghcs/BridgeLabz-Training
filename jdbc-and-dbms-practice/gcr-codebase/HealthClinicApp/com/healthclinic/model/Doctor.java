public class Doctor {
    private int id;
    private String name;
    private int specialtyId;
    private String contact;
    private String email;
    private double consultationFee;
    private boolean isActive;

    public Doctor() {
    }

    public Doctor(int id, String name, int specialtyId, String contact, String email, double consultationFee) {
        this.id = id;
        this.name = name;
        this.specialtyId = specialtyId;
        this.contact = contact;
        this.email = email;
        this.consultationFee = consultationFee;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Doctor{id=" + id + ", name='" + name + "', fee=" + consultationFee + "}";
    }
}