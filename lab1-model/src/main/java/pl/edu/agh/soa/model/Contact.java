package pl.edu.agh.soa.model;

public class Contact {
    private int albumNo;
    private int phone;

    public Contact(int albumNo, int phone) {
        this.albumNo = albumNo;
        this.phone = phone;
    }

    public Contact() {
    }

    public int getAlbumNo() {
        return albumNo;
    }

    public void setAlbumNo(int albumNo) {
        this.albumNo = albumNo;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "albumNo=" + albumNo +
                ", phone=" + phone +
                '}';
    }
}
