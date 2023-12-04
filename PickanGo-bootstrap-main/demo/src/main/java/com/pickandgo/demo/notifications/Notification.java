package com.pickandgo.demo.notifications;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "notifications")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "noti_id")
    private Long notiId;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "message", length = 50)
    private String message;

    @Column(name = "viewed")
    private boolean viewed;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;


    @Override
    public String toString() {
        return "Notification{" +
            "noti_id=" + notiId +
            ", title='" + title + '\'' +
            ", message='" + message + '\'' +
            ", viewed='" + viewed + '\'' +
            ", date_created=" + dateCreated +
            '}';
}


}
