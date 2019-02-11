package cafe.ebs.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.ebs.web.vo.Sample;

@Mapper
public interface SampleMapper {
	// 1. 전체 회원 조회
	List<Sample> selectSampleList();
	// 2. 입력 액션
	int insertSample(Sample sampleName);
	// 3. 
}
