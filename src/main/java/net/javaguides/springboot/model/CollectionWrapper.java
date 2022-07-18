package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "Users")
public class CollectionWrapper {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "User")
    @JsonView(UserView.Summary.class)
    private List<User> users;


    public CollectionWrapper(List<User> users) {
        this.users = users;
    }
}
