package com.jpl.easyrider.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Training {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateTraining;

    @ManyToOne
    @JoinTable(
            name = "users_trainings",
            joinColumns = @JoinColumn(
                    name = "training_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"))
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "trainings_horses",
            joinColumns = @JoinColumn(
                    name = "training_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "horse_id",
                    referencedColumnName = "id"))
    @JsonManagedReference
    private Horse horse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTraining() {
        return dateTraining;
    }

    public void setDateTraining(Date dateTraining) {
        this.dateTraining = dateTraining;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Objects.equals(id ,training.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", dateTraining=" + dateTraining +
                ", user=" + user +
                ", horse=" + horse +
                '}';
    }
}
