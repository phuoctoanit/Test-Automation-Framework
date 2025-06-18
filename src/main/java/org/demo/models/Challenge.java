package org.demo.models;

public class Challenge {
    private String event;
    private String title;
    private String flag;
    private String description;
    private String attach;
    private String category;
    private int point;
    private String howToSolve;
    private String status = "In Review";
    private String createdBy;

    public Challenge(String title, String flag, String description, String attach, String category, int point, String howToSolve) {
        this.title = title;
        this.flag = flag;
        this.description = description;
        this.attach = attach;
        this.category = category;
        this.point = point;
        this.howToSolve = howToSolve;
    }

    public String getTitle() {
        return title;
    }

    public String getFlag() {
        return flag;
    }

    public String getDescription() {
        return description;
    }

    public String getAttach() {
        return attach;
    }

    public String getCategory() {
        return category;
    }

    public int getPoint() {
        return point;
    }

    public String getHowToSolve() {
        return howToSolve;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setHowToSolve(String howToSolve) {
        this.howToSolve = howToSolve;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
