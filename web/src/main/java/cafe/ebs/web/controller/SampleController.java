package cafe.ebs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.ebs.web.service.SampleService;
import cafe.ebs.web.vo.Sample;

// request.getParameter가 필요하다.
@Controller
public class SampleController {
	@Autowired private SampleService sampleService;
	// 1. 입력 폼
	@GetMapping("/insertSample")
	public String addSample() {
		// 입력폼에 왔는지 확인한다.
		System.out.println("Request : /insertSample : 입력 폼");
		return "insertSample";	// view 이름은 template폴더에 addSample.html의 이름으로 보인다.		
	}
	// 2. 입력 액션
	@PostMapping("/insertSample")
	public String addSample(@RequestParam(value="sampleName") String sampleName) {
		// sampleName이라는 객체가 생성되고 이 객체에 
		// request.getParameter로 요청된 변수의 값을 sampleName객체에 넣는다.
		System.out.println("Request : /insertSample : 입력 액션");
		
		// Service에서 입력 처리
		sampleService.insertSample(sampleName);
		// 회원 리스트로 이동하기
		return "redirect:/sampleList";	
		// 접두사에 redirect는 redirect형태로 이동, 나머지는 forwarding한다.
	}
	// 3. 목록
	@GetMapping("/sampleList")
	public String sampleList(Model model) {
	// 무언가 담아야 하기에 model이란 객체를 사용한다.
		return "sampleList";
	}
	// 4. 삭제 액션
	@PostMapping("/deleteSample")
	public String deleteSample(@RequestParam(value="sampleId") String sampleId) {
		return "redirect:/sampleList";
	}
	// 5. 수정 폼
	@GetMapping("/updateSample")
	public String updateSample(@RequestParam(value="sampleId") String sampleId) {
		return "updateSample";
	}
	// 6. 수정 액션
	@PostMapping("/updateSample")
	public String updateSample(Model model) {
		return "sampleList";
	}
}
