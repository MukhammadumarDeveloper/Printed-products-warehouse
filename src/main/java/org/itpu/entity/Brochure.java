package org.itpu.entity;

import java.util.Objects;

public class Brochure extends Appliance<Brochure> {
    private String description;
    private String size;
    private String graphics;
    private String images;

    public Brochure setDescription(String description) {
        this.description = description;
        return this;
    }

    public Brochure setSize(String size) {
        this.size = size;
        return this;
    }

    public Brochure setGraphics(String graphics) {
        this.graphics = graphics;
        return this;
    }

    public Brochure setImages(String images) {
        this.images = images;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public String getGraphics() {
        return graphics;
    }

    public String getImages() {
        return images;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Brochure brochure = (Brochure) o;
        return size == brochure.size  && Objects.equals(description, brochure.description) && Objects.equals(graphics, brochure.graphics) && Objects.equals(images, brochure.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, size, graphics, images);
    }

    @Override
    public String toString() {
        return "Brochure{" + specialField() + ", "
                +"description='" + description + '\'' +
                ", size='" + size + '\'' +
                "  graphics='" + graphics + '\'' +
                " images='" + images + '\'' +
                '}';
    }
}
