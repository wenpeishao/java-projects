public class IISBNVal implements IISBNValidator {
	
	public boolean validate(String isbn13) {
		if (isbn13 == null || isbn13.length() != 13) {
			return false;
		}
		int sum = 0, r;
		for (int i = 0; i < 12; i++) {
			if (isbn13.charAt(i) < '0' || isbn13.charAt(i) > '9') {
				return false;
			}
			if (i % 2 == 0) {
				sum += isbn13.charAt(i) - '0';
			} else {
				sum += 3 * (isbn13.charAt(i) - '0');
			}
		}
		r = 10 - (sum % 10);
		if (r == 10) {
			r = 0;
		}
		Character result = (char) ('0'+r);
		if(isbn13.charAt(12)!=result) {
			return false;
		}
		return true;
	}

}
