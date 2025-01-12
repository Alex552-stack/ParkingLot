package org.parking.parkinglot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "car_photo")
public class CarPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    String filename;
    String fileType;
    byte[] fileContent;
    Car car;

    @GeneratedValue
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @OneToOne
    public Car getCar() {

        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    //@Size(min = 3, max = 100)
    @Column(unique = true, nullable = false, length = 100)
    public String getFilename() {

        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    //@Size(min = 3, max = 100)
    @Column(unique = true, nullable = false, length = 100)
    public byte[] getFileContent() {

        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    //@Size(min = 3, max = 100)
    @Column(unique = true, nullable = false, length = 100)
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}