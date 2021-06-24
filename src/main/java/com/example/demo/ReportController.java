package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReportController {

    private static List<ReportDTO> m_reports = new ArrayList<>();
    Repository repository = new Repository("jdbc:sqlite:C:/SQLite/reports.db");

    @GetMapping("/report")
    public List<ReportDTO> getAllReports()
    {
        return repository.getAllReports();
    }
    @GetMapping("/report/{id}")
    public ReportDTO doGetReportById(@PathVariable("id") int id){
        return repository.getReportById(id);
    }

    @PostMapping("/report")
    public void addReport(@RequestBody ReportDTO report){
        repository.insertReport(report);
    }

    @PutMapping("/report/{id}")
    public void doUpdateReportByID(@PathVariable("id") int id, @RequestBody ReportDTO sent){
        repository.updateReport(sent,id);
    }

    @DeleteMapping("/report/{id}")
    public void deleteReportById(@PathVariable("id") int id){
        repository.deleteReport(id);
    }


}
