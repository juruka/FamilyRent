package utils;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//存放每輛車所有的訂單日期
public class ReDay {
	private String car_no;// 存放車牌
	private List<Integer> day;// 存放日期
	private String car_model;
	private List<Integer> clean;
	
	public String getCar_no() {
		return car_no;
	}

	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	public List<Integer> getDay() {
		return day;
	}

	public void setDay(List<Integer> day) {
		this.day = day;
	}

	public ReDay() {
		day = new ArrayList<>();
	}

	public void day(int start, int end, int sumMonth, int month) {
		
		if (month * 2 == sumMonth) {//要是 訂單開始與結束都在同月份
			while (start <= end) {
				day.add(start);
				start++;
			}
			clean.add(end);
		}else if (month * 2 > sumMonth) {//要是 訂單開始在當月前一個月份
			for (int i = 1;i<=end;i++) {
				day.add(i);
			}
			clean.add(end);
		}else {                         //要是 訂單結束在下一個月份
			int date = monthinDay(month);
			while(start <= date) {
				day.add(start);
				start++;
			}
			
		}

	}

	public int monthinDay(int month) { //取得指定月份 總天數
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH,month - 1);
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		int maximum = calendar.get(Calendar.DATE);
//		System.out.println(maximum);
		return maximum;
	}
	
	@Override
	public String toString() {
		return "ReDay [car_no=" + car_no + ", day=" + day + ", car_model=" + car_model + "]";
	}

}
