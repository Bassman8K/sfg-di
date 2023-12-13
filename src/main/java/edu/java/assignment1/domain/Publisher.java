package edu.java.assignment1.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long publisher_id;
    private String name;
    String address_place;
    String address_city;
    String address_state;
    String address_zip;
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher() {

    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Publisher(String name, String address_place, String address_city, String address_state, String address_zip) {
        this.name = name;
        this.address_place = address_place;
        this.address_city = address_city;
        this.address_state = address_state;
        this.address_zip = address_zip;
    }

    public long getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(long publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress_place() {
        return address_place;
    }

    public void setAddress_place(String address_place) {
        this.address_place = address_place;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_state() {
        return address_state;
    }

    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }

    public String getAddress_zip() {
        return address_zip;
    }

    public void setAddress_zip(String address_zip) {
        this.address_zip = address_zip;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisher_id=" + publisher_id +
                ", name='" + name + '\'' +
                ", address_place='" + address_place + '\'' +
                ", address_city='" + address_city + '\'' +
                ", address_state='" + address_state + '\'' +
                ", address_zip='" + address_zip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return publisher_id == publisher.publisher_id;
    }

    @Override
    public int hashCode() {
        return (int) (publisher_id ^ (publisher_id >>> 32));
    }
}
