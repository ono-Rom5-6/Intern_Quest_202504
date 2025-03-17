//承認フォーム(承認・却下・差し戻しを登録する)
package spring.intern_quest_202504.form;

import java.util.ArrayList;

import lombok.Data;
import spring.intern_quest_202504.domain.overtime.model.Overtime;

@Data
public class ApproveForm {
	private ArrayList<Overtime> overtimeList;
}
