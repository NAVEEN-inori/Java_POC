package com;

import java.util.List;

public class ruleSet {

    String execution_mode;
    String name;
    int client_id;
    List<String> notification_preferences;
    List<String> publish_preferences;
    List<String> rule_ids;
    String group_name;

    public String getExecution_mode() {
        return execution_mode;
    }

    public void setExecution_mode(String execution_mode) {
        this.execution_mode = execution_mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public List<String> getNotification_preferences() {
        return notification_preferences;
    }

    public void setNotification_preferences(List<String> notification_preferences) {
        this.notification_preferences = notification_preferences;
    }

    public List<String> getPublish_preferences() {
        return publish_preferences;
    }

    public void setPublish_preferences(List<String> publish_preferences) {
        this.publish_preferences = publish_preferences;
    }

    public List<String> getRule_ids() {
        return rule_ids;
    }

    public void setRule_ids(List<String> rule_ids) {
        this.rule_ids = rule_ids;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    @Override
    public String toString() {
        return "ruleSet{" +
                "execution_mode='" + execution_mode + '\'' +
                ", name='" + name + '\'' +
                ", client_id=" + client_id +
                ", notification_preferences=" + notification_preferences +
                ", publish_preferences=" + publish_preferences +
                ", rule_ids=" + rule_ids +
                ", group_name='" + group_name + '\'' +
                '}';
    }
}
