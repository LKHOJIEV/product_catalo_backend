package com.ucell.backend.entity;


import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


import java.util.Objects;
@Node
public class Users {

    @Id
    @GeneratedValue
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;
    private String password;
    private String channel;
    private String accessLevel;
    private String isActive;


    public Users(String userName, String password, String channel, String accessLevel, String iActive) {
        this.name = userName;
        this.password = password;
        this.channel = channel;
        this.accessLevel = accessLevel;
        this.isActive = isActive;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + name + '\'' +
                ", password='" + password + '\'' +
                ", Channel='" + channel + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                ", iActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users user)) return false;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(channel, user.channel) && Objects.equals(accessLevel, user.accessLevel) && Objects.equals(isActive, user.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, channel, accessLevel, isActive);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        channel = channel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getisActive() {
        return isActive;
    }

    public void setisActive(String iActive) {
        this.isActive = iActive;
    }
}
