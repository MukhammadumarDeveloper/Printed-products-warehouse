package org.itpu.config;

import org.itpu.dao.ApplianceDAO;
import org.itpu.dao.DaoFactory;
import org.itpu.dao.impl.BookDAO;
import org.itpu.dao.impl.MagazineDAO;
import org.itpu.dao.impl.BrochureDAO;
import org.itpu.entity.Appliance;

public enum DaoFactoryImpl implements DaoFactory {
    INSTANCE;

    @Override
    public <A extends Appliance<A>> ApplianceDAO<A> getApplianceDAO(Class<A> applianceClass) {
        switch (applianceClass.getSimpleName()) {
            case "Book":
                System.out.println("you are looking for books");
                return (ApplianceDAO<A>) new BookDAO("Books.csv");
            case "Magazine":
                System.out.println("you are looking for magazines");
                return (ApplianceDAO<A>) new MagazineDAO("Magazine.csv");
            case "Brochure":
                System.out.println("you looking for Brochure");
                return (ApplianceDAO<A>) new BrochureDAO("Brochures.csv");
            default:
                return null;
        }
    }
}
