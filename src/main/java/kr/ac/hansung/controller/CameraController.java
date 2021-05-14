package kr.ac.hansung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.service.CameraService;

@Controller
public class CameraController {
	
	@Autowired
	private CameraService cameraService;
	
	@RequestMapping(value = "/usecamera", method = RequestMethod.GET)
	public String showScreen() {
		return "usecamera";
	}
}
