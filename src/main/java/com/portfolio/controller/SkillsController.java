package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.dto.ResultDTO;
import com.portfolio.model.Skills;
import com.portfolio.repository.SkillsReository;
import com.portfolio.service.SkillsService;

@RestController
@RequestMapping("skills")
public class SkillsController {
	@Autowired
	SkillsReository skilRepoReository;

	@Autowired
	SkillsService skilService;

	ResultDTO<?> responsePacket = null;
   @PostMapping("/sss")
	public ResponseEntity<?> createskills(@ModelAttribute Skills skill,
			@RequestParam("file") MultipartFile multipartFile) {
	   System.out.println(":::::::::::::createskills:::::::::::::::::::");
	   
		if (skill != null) {
			skilService.createskill(skill, multipartFile);
			responsePacket = new ResultDTO<>(true, "Skill created success!!");
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} else {
			responsePacket = new ResultDTO<>(false, null, "plz provide valid record!");
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

}
