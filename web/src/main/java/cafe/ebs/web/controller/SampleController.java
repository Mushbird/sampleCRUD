package cafe.ebs.web.controller;

import java.util.List;

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
	@Autowired 
	private SampleService sampleService;
	private Sample sample;
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
		// String타입의 sampleName을 vo의 Sample에 있는 sampleName에 set,get을 위한 sample참조변수에 setting함
		sample.setSampleName(sampleName);
		// Service에서 입력 처리
		int result = sampleService.insertSample(sample);
		// 결과 확인
		System.out.println("insertSample result :"+result);
		// 회원 리스트로 이동하기
		return "redirect:/sampleList";
		// 접두사에 redirect는 redirect형태로 이동, 나머지는 forwarding한다.
	}
	// 3. 목록
	@GetMapping("/sampleList")
	public String sampleList(Model model) {
		// 무언가 담아야 하기에 model이란 객체를 사용한다.
		System.out.println("Request : /sampleList : 목록");
		// Service에서 리스트 처리
		List<Sample> list = sampleService.selectSampleList();
		// model객체에 리스트 처리의 결과를 리스트로 보여주기 위해서 추가한다.
		model.addAttribute("list", list);
		// 리턴을 이용하여 list화면으로 이동
		return "sampleList";
	}
	// 4. 삭제 액션
	@GetMapping("/deleteSample")
	public String deleteSample(@RequestParam(value="sampleId") int sampleId) {
		return "redirect:/sampleList";
	}
	// 5. 수정 폼
	@GetMapping("/updateSample")
	public String updateSample(@RequestParam(value="sampleId") int sampleId, Model model) {
		// 수정폼에 왔는지 확인한다.
		System.out.println("Request : /updateSample : 수정 폼");
		// 매개변수로 가져온 int타입의 sampleId를 넣고 Service클래스의 selectSampleOne매서드를 통해 수정화면에 보여줄 값을 처리
		Sample sample = sampleService.selectSampleOne(sampleId);
		// 리턴값을 sample타입의 sample변수로 받아서 model객체를 통해 리스트 화면을 보여주기 위해서 Attribute한다.
		model.addAttribute("sample",sample);
		// 리턴을 이용하여 수정화면으로 이동
		return "updateSample";
	}
	// 6. 수정 액션
	@PostMapping("/updateSample")
	public String updateSample(@RequestParam(value="sampleId") int sampleId, @RequestParam(value="sampleName") String sampleName) {
		// 수정 액션 처리에 왔는지 확인한다.
		System.out.println("Request : /updateSample : 수정 액션");
		// 잘 받아왔는지 확인
		System.out.println("sampleId :" + sampleId);
		System.out.println("sampleName :" +sampleName);
		// int타입의 sampleId와 String타입의 sampleName을 
		// vo의 Sample에 있는 sampleId,sampleName에 set,get을 위한 sample참조변수에 setting함
		// @Autowired에서 써서 sample를 이용하면  NullPointException이 발생되므로 
		// 따로 생성자를 사용하여 sample2객체를 생성한다.
		Sample sample2 = new Sample();
		// sample2객체에 id와 name을 세팅한다.
		sample2.setSampleId(sampleId);
		sample2.setSampleName(sampleName);
		// sample참조변수를 Service의 updateSample매서드를 통해 수정 액션을 처리, 그 결과값을 int타입의 result변수에 담는다.
		int result = sampleService.updateSample(sample2);
		// 결과가 성공적이면 1, 그렇지 못하면 0으로 출력된다.
		System.out.println("updateSample result :"+result);
		// 수정 처리가 되었다면 전체 리스트로 이동한다.
		return "redirect:/sampleList";
	}
}
