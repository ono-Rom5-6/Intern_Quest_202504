package spring.intern_quest_202504.domain.overtime.model;

import lombok.Data;

@Data
public class WorkPattern {
	private String mainPattern;
	private String[] subPattern;
	
	public WorkPattern(String mainPattern, String[] subPattern){
        this.mainPattern = mainPattern;
        this.subPattern = subPattern;
    }

}
