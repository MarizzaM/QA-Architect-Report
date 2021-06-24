package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class Repository {

    private String m_conn;

    public Repository(String m_conn) {
        this.m_conn = m_conn;
    }

    public void setM_conn(String m_conn) {
        this.m_conn = m_conn;
    }

    public ArrayList<ReportDTO> getAllReports (){

        ArrayList<ReportDTO>  m_reports = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)){

            if(conn != null){
                String sql = "SELECT * FROM Report";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()){
                    ReportDTO el = new ReportDTO(
                            rs.getInt("id"),
                            rs.getString("license_plate"),
                            rs.getInt("driver_id"),
                            rs.getInt("speed"));
                    m_reports.add(el);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return m_reports;
    }

    public ReportDTO getReportById (int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "SELECT * FROM Report WHERE id = " + id;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    ReportDTO restaurant = new ReportDTO(
                            rs.getInt("id"),
                            rs.getString("license_plate"),
                            rs.getInt("driver_id"),
                            rs.getInt("speed"));
                    return restaurant;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void insertReport(ReportDTO report){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = String.format("INSERT INTO Report (id, license_plate, driver_id, speed)" +
                                " VALUES ('%d', '%s', '%d', '%d')", report.getM_id(),
                        report.getM_license_plate(), report.getM_driver_id(),
                        report.getM_speed());
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateReport(ReportDTO report, int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = String.format("UPDATE Report SET " +
                                "license_plate = '%s', " +
                                "driver_id = %d, " +
                                "speed = %d " +
                                " WHERE id = %d", report.getM_license_plate(), report.getM_driver_id(),
                        report.getM_speed(), id);
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteReport(int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "DELETE FROM Report WHERE id = " + id;
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
