package pers.penglan.ioc.entity.annotation;

import org.springframework.beans.factory.annotation.Required;

/**
 * @Author PENGL
 * 2020-03-03
 */
public class RequiredAnnotation {
    private String name = null;
    private int rank = 0;

    public RequiredAnnotation() {
    }

    public RequiredAnnotation(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    @Required
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "RequiredAnnotation{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}
