package pikachu.domain.customer;

public class ExecutivesCust implements Customer{

	private Long point;
	private String retireDate;
	
	@Override
	public boolean chkCustomerGubun() {
		if(point == 0L || retireDate == null) {
			return false;
		}
		return true;
	}
	
}
