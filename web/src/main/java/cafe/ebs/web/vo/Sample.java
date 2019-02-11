package cafe.ebs.web.vo;

import org.springframework.stereotype.Component;

// Controller에서 따로 생성자를 이용하여 객체를 일일이 생성하지 않게 하기 위해서 @Component를 사용 
@Component 
public class Sample {
	private int sampleId;	// sample.sample_id
	private String sampleName;	// sample.sample_name
	
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	public String getSampleName() {
		return sampleName;
	}
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	
	@Override
	public String toString() {
		return "sample [sampleId=" + sampleId + ", sampleName=" + sampleName + "]";
	}
}