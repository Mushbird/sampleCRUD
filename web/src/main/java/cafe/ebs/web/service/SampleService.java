package cafe.ebs.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.ebs.web.mapper.SampleMapper;
import cafe.ebs.web.vo.Sample;

@Service
public class SampleService {
	// 어노테이션와 코드 사이에는 주석을 적지 말자.
	@Autowired private SampleMapper sampleMapper;
	
	// Dao와 같은 기능을 가진 매서드 선언
	public List<Sample> getSampleList() {
		
		return null;
	}
	
	public List<Sample> getSampleOne() {
		
		return null;
	}
	
	public int addSample(Sample sample) {
		return 0;
	}
	
	public int removeSample(Sample sample) {
		
		return 0;
	}
}
