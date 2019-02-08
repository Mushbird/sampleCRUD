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
	// 1. 전체 리스트
	public List<Sample> getSampleList() {
		
		return null;
	}
	// 2. 검색 리스트
	public List<Sample> getSampleOne() {
		
		return null;
	}
	// 3. 입력 액션
	public int insertSample(String sampleName) {
		// mapper를 통한 입력 액션 쿼리 실행
		 sampleMapper.insertSample(sampleName);
		return 0;
	}
	// 4. 삭제 액션
	public int removeSample(Sample sample) {
		
		return 0;
	}
	// 5. 수정 액션
	public int updateSample(Sample sample) {
		return 0;
	}
}
