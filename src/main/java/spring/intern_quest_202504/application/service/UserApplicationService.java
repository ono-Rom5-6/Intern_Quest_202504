//勤務パターン（メイン）のマップ
package spring.intern_quest_202504.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
	public Map<String, Integer> getWorkPatternMap(Locale locale) {
		Map<String, Integer> workPatternMap = new LinkedHashMap<>();
		workPatternMap.put("early", 1);
		workPatternMap.put("normal", 2);
		workPatternMap.put("late", 3);
		return workPatternMap;
	}

}

