package lap_1;

public class MyCaesar {
	public static final char[] ALPHABET = {
	        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
	        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	    };
	    private int n; // Số bước dịch (dịch sang phải)

	    public MyCaesar(int shiftSteps) {
	        this.n = shiftSteps;
	    }

	    // Mã hóa một ký tự
	    public char encryptChar(char c) {
	        if (Character.isUpperCase(c)) {
	            int index = (c - 'A' + n) % 26;
	            if (index < 0) {
	                index += 26;
	            }
	            return ALPHABET[index];
	        } else {
	            return c; // Giữ nguyên ký tự không phải chữ cái in hoa
	        }
	    }

	    // Mã hóa một chuỗi
	    public String encrypt(String plaintext) {
	        StringBuilder encryptedText = new StringBuilder();
	        for (char c : plaintext.toCharArray()) {
	            encryptedText.append(encryptChar(c));
	        }
	        return encryptedText.toString();
	    }

	    // Giải mã một ký tự
	    public char decryptChar(char c) {
	        if (Character.isUpperCase(c)) {
	            int index = (c - 'A' - n) % 26;
	            if (index < 0) {
	                index += 26;
	            }
	            return ALPHABET[index];
	        } else {
	            return c; // Giữ nguyên ký tự không phải chữ cái in hoa
	        }
	    }

	    // Giải mã một chuỗi
	    public String decrypt(String ciphertext) {
	        StringBuilder decryptedText = new StringBuilder();
	        for (char c : ciphertext.toCharArray()) {
	            decryptedText.append(decryptChar(c));
	        }
	        return decryptedText.toString();
	    }

	    public static void main(String[] args) {
	        MyCaesar caesar = new MyCaesar(3); // Số bước dịch là 3

	        String plaintext = "HELLO";
	        String encryptedText = caesar.encrypt(plaintext);
	        System.out.println("Encrypted: " + encryptedText);

	        String decryptedText = caesar.decrypt(encryptedText);
	        System.out.println("Decrypted: " + decryptedText);
	    }

}
