package com.edu.utez.asesesoria.model.courses;

public class BeanCourse {
    private long id;
    private String name;
    private String type;
    private int status;
    private long placeId;
    private long usersId;
    private long scheId;
    private String image;
    private String placeName;
    private String usersName;
    private String scheName;


    public BeanCourse() {
    }

    public BeanCourse(String name, String type, int status, long placeId, long usersId, long scheId, String placeName, String usersName, String scheName) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.placeId = placeId;
        this.usersId = usersId;
        this.scheId = scheId;
        this.placeName = placeName;
        this.usersName = usersName;
        this.scheName = scheName;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public long getPlaceId() {
        return placeId;
    }
    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }
    public long getUsersId() {
        return usersId;
    }
    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }
    public long getScheId() {
        return scheId;
    }
    public void setScheId(long scheId) {
        this.scheId = scheId;
    }
    public String getPlaceName() {
        return placeName;
    }
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    public String getUsersName() {
        return usersName;
    }
    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }
    public String getScheName() {
        return scheName;
    }
    public void setScheName(String scheName) {
        this.scheName = scheName;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "BeanCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", placeId=" + placeId +
                ", usersId=" + usersId +
                ", scheId=" + scheId +
                ", placeName='" + placeName + '\'' +
                ", usersName='" + usersName + '\'' +
                ", scheName='" + scheName + '\'' +
                '}';
    }
}
