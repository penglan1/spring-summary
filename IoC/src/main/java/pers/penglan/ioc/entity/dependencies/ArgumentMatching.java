package pers.penglan.ioc.entity.dependencies;

/**
 * @Author PENGL
 * 2020-03-02
 */
public class ArgumentMatching {
    private int rank = 0;
    private String name = null;

    public ArgumentMatching(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public ArgumentMatching() {}

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ArgumentMatching{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                '}';
    }
}
