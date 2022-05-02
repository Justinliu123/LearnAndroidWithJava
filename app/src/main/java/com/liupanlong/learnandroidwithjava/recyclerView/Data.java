package com.liupanlong.learnandroidwithjava.recyclerView;

public class Data {
    private Integer id;
    private String text;
    private Class toActivityId;

    public Data(Integer id, String text, Class ts) {
        this.id = id;
        this.text = text;
        this.toActivityId = ts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Class getToActivityId() {
        return toActivityId;
    }

    public void setToActivityId(Class toActivityId) {
        this.toActivityId = toActivityId;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", toActivityId=" + toActivityId +
                '}';
    }
}
