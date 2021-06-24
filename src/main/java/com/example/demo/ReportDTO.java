package com.example.demo;

public class ReportDTO {
    private int m_id;
    private String m_license_plate;
    private int m_driver_id;
    private int m_speed;

    public ReportDTO() {
    }

    public ReportDTO(int m_id, String m_license_plate, int m_driver_id, int m_speed) {
        this.m_id = m_id;
        this.m_license_plate = m_license_plate;
        this.m_driver_id = m_driver_id;
        this.m_speed = m_speed;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_license_plate() {
        return m_license_plate;
    }

    public void setM_license_plate(String m_license_plate) {
        this.m_license_plate = m_license_plate;
    }

    public int getM_driver_id() {
        return m_driver_id;
    }

    public void setM_driver_id(int m_driver_id) {
        this.m_driver_id = m_driver_id;
    }

    public int getM_speed() {
        return m_speed;
    }

    public void setM_speed(int m_speed) {
        this.m_speed = m_speed;
    }
}
