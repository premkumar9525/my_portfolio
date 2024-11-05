package com.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.dto.Constants;
import com.portfolio.model.Skills;
import com.portfolio.repository.SkillsReository;

@Service
public class SkillsService {
	
	@Autowired
   SkillsReository skillsRepository;

	public void createskill(Skills skill, MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		if (multipartFile!=null) {
			String path = Constants.LOCAL_BASE_DIR + Constants.LOCAL_IMG_LOCATION;
			String fname = Constants.getRandomPassword() + multipartFile.getOriginalFilename();
			String fileName = Constants.saveMultiPartFile(multipartFile, path, fname);
			skill.setImg(fileName);
			skill.setStatus(true);
			skill.setCreateDate(Constants.getDateAndTime());
			skillsRepository.save(skill);
		}
		
	}

	
	

}
