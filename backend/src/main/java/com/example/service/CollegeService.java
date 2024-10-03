package com.example.service;


import com.example.entity.College;
import com.example.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    public List<College> findAll() {
        return collegeRepository.findAll();
    }

    public College save(College college) {
        return collegeRepository.save(college);
    }

    public College findById(Long id) {
        return collegeRepository.findById(id).orElse(null);
    }
 

    public void deleteById(Long id) {
        collegeRepository.deleteById(id);
    }
    
    public College update(Long id, College college) {
        College existingCollege = collegeRepository.findById(id).orElse(null);
        if (existingCollege != null) {
            existingCollege.setName(college.getName());
            existingCollege.setLocation(college.getLocation());
            return collegeRepository.save(existingCollege);
        }
        return null;
    }
    public void delete(Long id) {
        collegeRepository.deleteById(id);
    }
}
