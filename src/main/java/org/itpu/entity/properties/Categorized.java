package org.itpu.entity.properties;

public interface Categorized<ITSELF extends Categorized<ITSELF>> {
String getCategory();
ITSELF setCategory(String category);
}
