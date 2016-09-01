package seedu.addressbook.data.person;

public class PostalCode {
	private String _postalCode;

	public PostalCode(String postalCode){
		_postalCode = postalCode;
	}
	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public String getPostalCode() {
		return _postalCode;
	}
}
