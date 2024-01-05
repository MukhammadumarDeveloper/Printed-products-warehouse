package org.itpu.entity;


import java.util.Objects;

public abstract class Appliance <ITSELF extends Appliance<ITSELF>> {
    private String title;

    private String paperType;
    private long price;


    public String getTitle() {
        return title;
    }

    public ITSELF setTitle(String title) {
        this.title = title;
        return (ITSELF) this;
    }

    public ITSELF setPaperType(String paperType) {
        this.paperType = paperType;
        return (ITSELF) this;
    }


    public long getPrice() {
        return price;
    }

    public ITSELF setPrice(long price) {
        this.price = price;
        return (ITSELF) this;
    }

    public String getPaperType() {
        return paperType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliance<ITSELF> appliance = (Appliance<ITSELF>) o;
        return Objects.equals(getTitle(), appliance.getTitle())
                && Objects.equals(getPaperType(), appliance.getPaperType())
                && getPrice() == appliance.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPaperType(), getPrice());
    }

    @Override
    public String toString() {
        return "Appliance{" + specialField() + '}';
    }

    protected String specialField() {
        return
                "Title=" + title + "| paper type='" + paperType + "| price=" + price;
    }
}
