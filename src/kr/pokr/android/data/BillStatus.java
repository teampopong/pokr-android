package kr.pokr.android.data;

import java.util.HashMap;

public class BillStatus {
	static final HashMap<Integer, String> status_hm;

	static {
		status_hm = new HashMap<Integer, String>();
		status_hm.put(11, "예비심사");
		status_hm.put(11, "dd");
		status_hm.put(12, "예결위심사");
		status_hm.put(8, "폐기");
		status_hm.put(2, "위원회심사");
		status_hm.put(1, "접수");
		status_hm.put(4, "체계자구심사");
		status_hm.put(5, "본회의심의");
		status_hm.put(10, "철회");
		status_hm.put(3, "대안반영폐기");
		status_hm.put(7, "공포");
		status_hm.put(13, "부결");
		status_hm.put(9, "의결");
		status_hm.put(14, "정부재의");
		status_hm.put(6, "정부이송");
		status_hm.put(15, "임기만료폐기");
		status_hm.put(16, "심사보고서채택");
		status_hm.put(18, "부동의");
		status_hm.put(26, "채택");
		status_hm.put(21, "각하");
		status_hm.put(27, "부의가능안건");
		status_hm.put(24, "비상국무회의로이관");
		status_hm.put(19, "불승인");
		status_hm.put(25, "경과보고서채택");
		status_hm.put(20, "반려");
		status_hm.put(22, "의결불요");
		status_hm.put(23, "불허가");
		status_hm.put(17, "회기불계속폐기");
	}

}
