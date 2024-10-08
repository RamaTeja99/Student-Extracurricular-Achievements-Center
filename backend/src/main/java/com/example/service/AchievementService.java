package com.example.service;

import com.example.entity.Achievement;
import com.example.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService {
    @Autowired
    private AchievementRepository achievementRepository;

    public List<Achievement> findAll() {
        return achievementRepository.findAll();
    }

    public Achievement save(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    public Achievement findById(Long id) {
        return achievementRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        achievementRepository.deleteById(id);
    }
    public List<Achievement> findByStudentId(Long studentId) {
        return achievementRepository.findByStudentId(studentId);
    }
    public void delete(Long id) {
        achievementRepository.deleteById(id);
    }
    public Achievement update(Long id, Achievement achievement) {
        Achievement existingAchievement = achievementRepository.findById(id).orElse(null);
        if (existingAchievement != null) {
            // Update only non-null fields
            if (achievement.getActivityName() != null) {
                existingAchievement.setActivityName(achievement.getActivityName());
            }
            if (achievement.getActivityDescription() != null) {
                existingAchievement.setActivityDescription(achievement.getActivityDescription());
            }
            if (achievement.getActivityCategory() != null) {
                existingAchievement.setActivityCategory(achievement.getActivityCategory());
            }
            if (achievement.getFirstPosition() != null) {
                existingAchievement.setFirstPosition(achievement.getFirstPosition());
            }
            if (achievement.getSecondPosition() != null) {
                existingAchievement.setSecondPosition(achievement.getSecondPosition());
            }
            if (achievement.getThirdPosition() != null) {
                existingAchievement.setThirdPosition(achievement.getThirdPosition());
            }
            // Participation field can also be updated if provided
            existingAchievement.setParticipation(achievement.getParticipation());

            return achievementRepository.save(existingAchievement);
        }
        return null; // Handle the case where the achievement doesn't exist
    }
}
